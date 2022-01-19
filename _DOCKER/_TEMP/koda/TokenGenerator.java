package si.um.voteit.voteit.logic;

import si.um.voteit.voteit.dao.VoteRepository;
import si.um.voteit.voteit.vao.Survey;
import si.um.voteit.voteit.vao.Vote;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class TokenGenerator {

    Logger log=Logger.getLogger(TokenGenerator.class.toString());

    public static int TOKEN_LENGTH=5;

    private AtomicInteger conflictCount=new AtomicInteger(0);

    private Survey survey;

    private VoteRepository dao;

    private Random rand=new Random();

    public TokenGenerator(Survey survey, VoteRepository dao) {
        this.survey = survey;
        this.dao = dao;
    }

    private boolean isTokenValid(String token) {
        return dao.findById(token).isEmpty();
    }

    private String constructUniqueToken() {
        String validChars="0123456789abcdefghijkslmoprstuvzxywqABCDEFGHIJKLMNOPRSTUVZXYWQ";
        int length=validChars.length();
        String ret="";//=survey.getId()+"";
        for (int i=0;i<TOKEN_LENGTH;i++)
            ret=ret+validChars.charAt(rand.nextInt(0,length));
        return ret;
    }

    public void generateTokens(int count) {
        for (int i=0;i<count;i++) {
            String token=constructUniqueToken();
            while (!isTokenValid(token)) {
                log.info("UPS - solving duplicate token issue #"+conflictCount.incrementAndGet());
                token=constructUniqueToken();
            }
            dao.save(new Vote(token, survey.getId()));
        }
    }

}
