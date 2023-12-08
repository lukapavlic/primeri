package si.um.feri.jee.poetry.jsf;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.jee.poetry.vao.Poem;
import si.um.feri.jee.poetry.vao.Poems;
import java.io.Serializable;
import java.util.List;
import java.util.Random;

@Named("poems")
@SessionScoped
public class PoemGenerator  implements Serializable {

    private String language= Poems.LANG_EN;

    private String topic=Poems.THEME_LOVE;

    private Poems poems=Poems.getInstance();

    private Random rand=new Random();

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String generatePoem() {
        List<Poem> candidates=null;

        if (language.equals(Poems.LANG_EN)) candidates=poems.getEnglishPoems().get(topic);
        if (language.equals(Poems.LANG_FR)) candidates=poems.getFrenchPoems().get(topic);
        if (language.equals(Poems.LANG_HU)) candidates=poems.getHungarianPoems().get(topic);
        if (language.equals(Poems.LANG_SI)) candidates=poems.getSlovenianPoems().get(topic);

        if (candidates==null) return "Error";

        int selected=rand.nextInt(candidates.size());
        return candidates.get(selected).getText();
    }
}
