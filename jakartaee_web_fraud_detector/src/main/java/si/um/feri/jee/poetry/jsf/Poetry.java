package si.um.feri.jee.poetry.jsf;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.jee.poetry.PoemGenerator;
import si.um.feri.jee.poetry.vao.Poems;
import java.io.Serializable;

@Named("poems")
@SessionScoped
public class Poetry implements Serializable {

    private String language= Poems.LANG_EN;

    private String topic=Poems.THEME_LOVE;

    private String generatedPoem="";

    private PoemGenerator gen=new PoemGenerator();

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

    public String getGeneratedPoem() {
        return generatedPoem;
    }

    public void setGeneratedPoem(String generatedPoem) {
        this.generatedPoem = generatedPoem;
    }

    public void generatePoem() {
        generatedPoem=gen.generatePoem(language,topic);
    }

}
