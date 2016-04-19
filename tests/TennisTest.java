import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nickleus on 19/04/16.
 */
public class TennisTest {

    @Test
    public void testinitialisationNouveauJeu()
    {
        new Jeu();
    }

    @Test
    public void testAfficherScoreDebutDePartie() {
        Jeu jeu = new Jeu();
        Assert.assertEquals("0-0",jeu.score());
    }
}
