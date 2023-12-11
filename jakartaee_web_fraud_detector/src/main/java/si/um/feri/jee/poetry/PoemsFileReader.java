package si.um.feri.jee.poetry;

import si.um.feri.jee.poetry.vao.Poem;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PoemsFileReader {

    private Logger log=Logger.getLogger(PoemsFileReader.class.getName());

    List<Poem> poems=new ArrayList<>();

    public PoemsFileReader(String folderName, String theme) {
        try {
            File folder=new File(folderName);
            if (!folder.isDirectory()) return;
            for (File f:folder.listFiles()){
                if(f.getName().startsWith(theme)){
                    String content = new String(Files.readAllBytes(Paths.get(f.getAbsolutePath())));
                    poems.add(new Poem(content));
                }
            }
            log.info(theme+ " poems read successful ("+poems.size()+") from "+folderName);
        } catch (IOException e) {
            log.info("Unable to read folder "+folderName+"; "+e.getMessage());
        }
    }

    public List<Poem> getPoems() {
        return poems;
    }

}
