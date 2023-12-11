package si.um.feri.jee.poetry.vao;

public class Poem {

    public Poem(String text) {
        this.text = text;
    }

    String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
