package si.um.feri.jee.poetry.vao;

import si.um.feri.jee.poetry.PoemsFileReader;
import java.util.ArrayList;
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

    public static String getLanguageDifferentThan(String thisOne) {
        if (LANG_EN.equals(thisOne)) return LANG_SI;
        return LANG_EN;
    }

    public static String getTopicDifferentThan(String thisOne) {
        if (THEME_LOVE.equals(thisOne)) return THEME_SOCIETY;
        return THEME_LOVE;
    }

    public List<Poem> getPoems(String language, String topic) {
        if (language.equals(Poems.LANG_EN)) return getEnglishPoems().get(topic);
        if (language.equals(Poems.LANG_FR)) return getFrenchPoems().get(topic);
        if (language.equals(Poems.LANG_HU)) return getHungarianPoems().get(topic);
        if (language.equals(Poems.LANG_SI)) return getSlovenianPoems().get(topic);
        return new ArrayList<>();
    }

    public static Poems singleton=null;

    private Poems(String poemsRootFolder) {
        try {
            for (String th:List.of(THEME_LOVE,THEME_CHILD,THEME_NATURE,THEME_SOCIETY))
                englishPoems.put(th,new PoemsFileReader(poemsRootFolder+"/"+LANG_EN,th).getPoems());

            for (String th:List.of(THEME_LOVE,THEME_CHILD,THEME_NATURE,THEME_SOCIETY))
                slovenianPoems.put(th,new PoemsFileReader(poemsRootFolder+"/"+LANG_SI,th).getPoems());

            for (String th:List.of(THEME_LOVE,THEME_CHILD,THEME_NATURE,THEME_SOCIETY))
                frenchPoems.put(th,new PoemsFileReader(poemsRootFolder+"/"+LANG_FR,th).getPoems());

            for (String th:List.of(THEME_LOVE,THEME_CHILD,THEME_NATURE,THEME_SOCIETY))
                hungarianPoems.put(th,new PoemsFileReader(poemsRootFolder+"/"+LANG_HU,th).getPoems());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized Poems getInstance(String poemsRootFolder) {
        if (singleton==null) singleton=new Poems(poemsRootFolder);
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
