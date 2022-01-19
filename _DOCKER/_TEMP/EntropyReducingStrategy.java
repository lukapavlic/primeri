package si.unimb.lisa.luka.patterns.obdp.propose;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import si.unimb.lisa.luka.patterns.obdp.util.PatternsDao;
import si.unimb.lisa.luka.patterns.obdp.util.RdfDao;
import si.unimb.lisa.luka.patterns.obdp.util.vao.Answer;
import si.unimb.lisa.luka.patterns.obdp.util.vao.Consequence;
import si.unimb.lisa.luka.patterns.obdp.util.vao.Question;
import si.unimb.lisa.luka.patterns.obdp.view.ExpertEditorAction;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 * Strategy where entropy is used as a measure for selecting a pattern
 * Information gain is used as a measure for selecting next question
 */
public class EntropyReducingStrategy implements ProposeStrategy {

	private static final long serialVersionUID = 1767950220244949327L;

	/**
	 * @see si.unimb.lisa.luka.patterns.obdp.propose.ProposeStrategy#canQuestionBeSkipped()
	 */
	@Override
	public boolean canQuestionBeSkipped() {
		return true;
	}

	/**
	 * @see si.unimb.lisa.luka.patterns.obdp.propose.ProposeStrategy#getStrategyName()
	 */
	@Override
	public String getStrategyName() {
		return "Entropy Reducing Strategy";
	}
	
	private boolean DEBUG=false;
	
	/**
	 * Constructor for debugging
	 * @param printDebugInfo prints debug info to console
	 */
	public EntropyReducingStrategy(boolean printDebugInfo) {
		entropyCalculator=new EntropyCalculator();
		DEBUG=printDebugInfo;
		construct();
	}
	
	public EntropyReducingStrategy(boolean printDebugInfo, EntropyCalculator ec) {
		entropyCalculator=ec;
		DEBUG=printDebugInfo;
		construct();
	}
	
	/**
	 * Constructor
	 */
	public EntropyReducingStrategy() {
		entropyCalculator=new EntropyCalculator();
		construct();
	}
		
	public void construct() {	
		candidatePossibilities=new HashMap<String, Double>();
		//all candidates=all that can be found as a possibilities to answers
		unaskedQuestions=new ArrayList<Question>();
		try {
			//fill unasked questions
			List<Resource> allQuestionsRes=RdfDao.getAllInstances("http://lisa.uni-mb.si/dprepository/dponto.owl#Question");
			for (Resource q : allQuestionsRes) {
				Question qwe=ExpertEditorAction.getQuestion(""+q.toString().hashCode());
				if (!qwe.isDisabled()) unaskedQuestions.add(qwe);
			}
			//fill candidates - from unasked questions
			HashSet<String> candidates=new HashSet<String>();
			for(Question q : unaskedQuestions)
				for (Answer a : q.getAnswers() ) {
					ArrayList<Consequence> consequencesToAdd=new ArrayList<Consequence>();    //consequences to be added when replacing containers
					ArrayList<Consequence> consequencesToRemove=new ArrayList<Consequence>(); //consequences to be removed when replacing containers
					
					for (Consequence c : a.getConsequences()) {
						if (c.getAppliesTo()!=null)	if (!c.getAppliesTo().equals("")) {
							//if (DEBUG) { System.out.println("ADDING PATTERN: "+c.getAppliesTo()); }
							candidates.add(c.getAppliesTo());
						} else {
							//do not add container, add member patterns
							//candidates.add(c.getAppliesToContainer());
							//if (DEBUG) { System.out.println("ADDING CONTAINER: "+c.getAppliesToContainer()); }
							List<Resource> includedPatterns=PatternsDao.getAllContainerDirectMembers_Patterns(RdfDao.getInstance().getModel().getResource(c.getAppliesToContainer()));
							for (Resource pat:includedPatterns) {
								//if (DEBUG) { System.out.println("ADDING INCLUDED PATTERN: "+pat.toString()); }
								candidates.add(pat.toString());
								
								//prepare collections for modifying this answer
								Consequence newConsequence=new Consequence();
								newConsequence.setAppliesTo(pat.toString());
								newConsequence.setRelevance(c.getRelevance());
								newConsequence.setInAnswer(c.getInAnswer());
								consequencesToAdd.add(newConsequence);
								
							}
							consequencesToRemove.add(c);
						}
					}
					//change the question itself: replace containers with member patterns

					for(Consequence c:consequencesToRemove)
						a.getConsequences().remove(c);
					
					for(Consequence c:consequencesToAdd)
						a.getConsequences().add(c);
					
				}
			//create candidatePossibilities
			for (String c: candidates) {
				candidatePossibilities.put(c, 0.5);
				if (DEBUG){ System.out.println(0.5+" : ADDED TO "+c); }
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		answersGivenCount=0;
		history=new ArrayList<ProposeActionStateItem>();
		currentQuestion=null;
	}
	
	private Map<String, Double> candidatePossibilities;
	
	private List<Question> unaskedQuestions;

	private List<ProposeActionStateItem> history;
	
	private int answersGivenCount=0;
	
	private Question currentQuestion;
	
	private EntropyCalculator entropyCalculator;
	
	@Override
	public void postAnswer(Question q, Answer a) {
		//undo stuff
		ProposeActionStateItem p=new ProposeActionStateItem();
		p.question=q.getUri();
		p.answer=a.getUri();
		history.add(p);
		
		//combine values
		entropyCalculator.combineAnswerToCandidates(candidatePossibilities,a);
		answersGivenCount++;
		
	}
	
	@Override
	public int getAnswersGivenCount() {
		return answersGivenCount;
	}
	
	@Override
	public Question getCurrentQuestion() {
		if (currentQuestion!=null) return currentQuestion;
		else return getNextQuestion();
	}

	@Override
	public Map<String, Double> getCurrentSolutions() {
		HashMap<String, Double> ret=new HashMap<String, Double>();
		for (String r:candidatePossibilities.keySet()) {
			ret.put(r, candidatePossibilities.get(r).doubleValue());
		}
		return ret;
		
	}

	@Override
	public Question getNextQuestion() {
		//decide which question to ask
		HashMap<Question, Double> minInfomationGain=new HashMap<Question, Double>();
		HashMap<Question, Double> maxInfomationGain=new HashMap<Question, Double>();
		
		double currentEntropy=calculateEntropy();
		
		//TODO - if goal entropy achieved, stop here
		
		if (DEBUG) System.out.println("Selecting one of "+unaskedQuestions.size()+" questions.");
		if (DEBUG) System.out.println("minGain\tmaxGain\tanswrs\tText");
		if (DEBUG) System.out.println("----------------------------------------------------");

		for (Question q: unaskedQuestions) {
			double infGainMin=10.0;
			double infGainMax=0.0;
			
			for (Answer a: q.getAnswers()) {
				//calculate information gain
				//clone candidatePossibilities
				Map<String, Double> candidates=new HashMap<String, Double>();
				for (String s :candidatePossibilities.keySet()) {
					candidates.put(s,candidatePossibilities.get(s));
				}
				//combine this answer
				entropyCalculator.combineAnswerToCandidates(candidates,a);
				//calculate entropy
				double newEntropy=entropyCalculator.calculateEntropy(candidates);
				double gain=currentEntropy-newEntropy;
				if (gain>infGainMax) infGainMax=gain;
				if (gain<infGainMin) infGainMin=gain;
			}
			minInfomationGain.put(q,infGainMin);
			maxInfomationGain.put(q,infGainMax);

			if (DEBUG) System.out.println(infGainMin+"\t"+infGainMax+"\t"+q.getAnswers().size()+"\t"+q.getText().trim());
			
		}

		//ask a question with maximum infGainMin
		Question toAsk=null;
		double maxValue=0.0;
		for (Question q:minInfomationGain.keySet()) {
			double gain=minInfomationGain.get(q);
			if (gain>maxValue) {
				maxValue=gain;
				toAsk=q;
			}
		}

		if (DEBUG) System.out.println("Selected gain="+((int)(maxValue*1000)/1000.0));
		
		//remove question from unasked questions
		unaskedQuestions.remove(toAsk);
		currentQuestion=toAsk;
		
		//move it to asked question set (if needed later)
		
		return toAsk;
	}
	
	@Override
	public List<ProposeActionStateItem> getHistory() {
		return history;
	}

	@Override
	public void returnToHistory(String questionURIHash) {
		//TODO
	}
	
	//this strategy special methods
	
	public double calculateEntropy() {
		return entropyCalculator.calculateEntropy(candidatePossibilities);
	}	
	
	@Override
	public boolean isUndoSupported() {
		return false;
	}
	
	@Override
	public String getStrategyUserInfo() {
		return "Current entropy: "+(double)((int)(calculateEntropy()*10000.0))/10000.0;
	}	
	
}
