package si.um.feri.jee.poetry;

import jakarta.faces.context.FacesContext;
import si.um.feri.jee.poetry.vao.Poem;
import si.um.feri.jee.poetry.vao.Poems;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class PoemGenerator {

    private Logger log=Logger.getLogger(PoemGenerator.class.getName());

    private static double LANGUAGE_ERROR_PROBABILITY=0.05;
    private static double TOPIC_ERROR_PROBABILITY=0.05;
    private static double MIXED_LANGUAGE_ERROR_PROBABILITY=0.05;
    private static double MIXED_TOPIC_ERROR_PROBABILITY=0.05;
    private static double SINGLE_STANZA_ERROR_PROBABILITY=0.05;

    private Poems poems=Poems.getInstance(FacesContext.getCurrentInstance().getExternalContext().getRealPath("WEB-INF/poems"));

    private Random rand=new Random();

    public String generatePoem(String language, String topic) {
        return generatePoemWithErrorProbability(language,topic,
                rand.nextDouble()<LANGUAGE_ERROR_PROBABILITY,
                rand.nextDouble()<TOPIC_ERROR_PROBABILITY,
                rand.nextDouble()<MIXED_LANGUAGE_ERROR_PROBABILITY,
                rand.nextDouble()<MIXED_TOPIC_ERROR_PROBABILITY,
                rand.nextDouble()<SINGLE_STANZA_ERROR_PROBABILITY
        );
    }

    public String generatePoemWithErrorProbability(
            String language, String topic,
            boolean languageError, boolean topicError,
            boolean mixedLanguageError, boolean mixedtopicError, boolean singleStanzaError) {

        if (languageError || topicError || mixedLanguageError || mixedtopicError || singleStanzaError)
            log.info("Generating poem with error: languageError "+languageError+", topicError "+topicError+
                    ", mixedLanguageError "+mixedLanguageError+", mixedtopicError "+mixedtopicError+", singleStanzaError "+singleStanzaError);

        List<Poem> candidatesStanza1=null;
        List<Poem> candidatesStanza2=null;
        String stanza1="";
        String stanza2="";

        candidatesStanza1=poems.getPoems(language,topic);
        candidatesStanza2=candidatesStanza1;

        if (languageError) {
            candidatesStanza1=poems.getPoems(Poems.getLanguageDifferentThan(language),topic);
            candidatesStanza2=candidatesStanza1;
        }
        if (topicError) {
            candidatesStanza1=poems.getPoems(language,Poems.getTopicDifferentThan(topic));
            candidatesStanza2=candidatesStanza1;
        }
        if (mixedLanguageError) {
            candidatesStanza1=poems.getPoems(language,topic);
            candidatesStanza2=poems.getPoems(Poems.getLanguageDifferentThan(language),topic);;
        }
        if (mixedtopicError) {
            candidatesStanza1=poems.getPoems(language,topic);
            candidatesStanza2=poems.getPoems(language,Poems.getTopicDifferentThan(topic));;
        }
        if (singleStanzaError) {
            candidatesStanza2=null;
        }

        if (candidatesStanza1!=null) {
            int selected = rand.nextInt(candidatesStanza1.size());
            stanza1=candidatesStanza1.get(selected).getText();
        }
        if (candidatesStanza2!=null) {
            int selected = rand.nextInt(candidatesStanza2.size());
            stanza2=candidatesStanza2.get(selected).getText();
        }

        if (languageError || topicError || mixedLanguageError || mixedtopicError || singleStanzaError)
            log.info("Generated: \n" + stanza1 + "\n\n" + stanza2);

        return stanza1 + "\n\n" + stanza2;
    }
}
