package si.um.feri.jee.poetry.vao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Poems {

    public static String LANG_SI="Slovenian";
    public static String LANG_EN="English";
    public static String LANG_FR="French";
    public static String LANG_HU="Hungarian";
    public static String THEME_LOVE="LOVE";
    public static String THEME_NATURE="NATURE";
    public static String THEME_SOCIETY="SOCIETY";
    public static String THEME_CHILD="CHILD";

    public static Poems singleton=new Poems();

    private Poems() {
    }

    public static Poems getInstance() {
        return singleton;
    }

    Map<String, List<Poem>> englishPoems=new HashMap<>();

    Map<String,List<Poem>> slovenianPoems=new HashMap<>();

    Map<String,List<Poem>> frenchPoems=new HashMap<>();

    Map<String,List<Poem>> hungarianPoems=new HashMap<>();

    public Map<String, List<Poem>> getEnglishPoems() {
        return englishPoems;
    }

    public Map<String, List<Poem>> getSlovenianPoems() {
        return slovenianPoems;
    }

    public Map<String, List<Poem>> getFrenchPoems() {
        return frenchPoems;
    }

    public Map<String, List<Poem>> getHungarianPoems() {
        return hungarianPoems;
    }

}
