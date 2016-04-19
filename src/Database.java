import com.google.gson.Gson;

import java.io.*;
import java.util.HashMap;

/**
 * Created by sephirius on 19/04/16.
 */
public class Database {

    public void save(Jeu jeu) throws IOException {
        File f = new File("bbd.json");
        f.createNewFile();
        FileWriter fw = new FileWriter(f);
        fw.write(new Gson().toJson(jeu));
        fw.flush();
        fw.close();

    }

    public void load(Jeu jeu) throws IOException {
        File f = new File("bbd.json");
        FileInputStream fis = new FileInputStream(f);
        byte[] data = new byte[(int) f.length()];
        fis.read(data);
        fis.close();

        String str = new String(data, "UTF-8");
        Jeu j = new Gson().fromJson(str,Jeu.class);

        jeu.isGameRunning = j.isGameRunning;
        jeu.setScorePlayer1(j.getScorePlayer1());
        jeu.setScorePlayer2(j.getScorePlayer2());
    }
}
