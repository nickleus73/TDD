import java.io.IOException;

/**
 * Created by sephirius on 20/04/16.
 */
public class DatabaseBouchon implements IDatabase {
    private boolean alreadyCalled = false;

    public void save(Jeu jeu) throws IOException {
    }

    public void load(Jeu jeu) throws IOException {
        if(alreadyCalled) {
            jeu.setScorePlayer1(15);
            jeu.setScorePlayer2(15);
            jeu.isGameRunning=true;
        }else{
            jeu.setScorePlayer1(30);
            jeu.setScorePlayer2(30);
            jeu.isGameRunning=true;
            alreadyCalled = true;
        }


    }
}