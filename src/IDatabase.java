import java.io.IOException;

/**
 * Created by sephirius on 20/04/16.
 */
public interface IDatabase {
    void save(Jeu jeu) throws IOException;
    void load(Jeu jeu) throws IOException;
}
