import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nickleus on 19/04/16.
 */
public class TennisTest {

    Jeu jeu;

    @Before
    public void before()
    {
        jeu = new Jeu();
    }

    @Test
    public void testAfficherScoreDebutDePartie()
    {
        Assert.assertEquals("0-0", jeu.score());
    }

    @Test
    public void testAddNewPoint()
    {
        jeu.add(1);
        Assert.assertEquals("0-15", jeu.score());
    }

    @Test
    public void testAddNewPoint_30()
    {
        jeu.add(1);
        jeu.add(1);
        Assert.assertEquals("0-30", jeu.score());
    }

    @Test
    public void testAddNewPoint_40()
    {
        jeu.add(1);
        jeu.add(1);
        jeu.add(1);
        Assert.assertEquals("0-40", jeu.score());
    }
}
