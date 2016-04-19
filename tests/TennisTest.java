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
        Assert.assertTrue(jeu.isGameRunning());
        Assert.assertEquals("0-0", jeu.score());
    }

    @Test
    public void testAddNewPoint()
    {
        jeu.add(1);
        Assert.assertTrue(jeu.isGameRunning());
        Assert.assertEquals("0-15", jeu.score());
    }

    @Test
    public void testAddNewPoint_30()
    {
        jeu.add(1);
        jeu.add(1);
        Assert.assertTrue(jeu.isGameRunning());
        Assert.assertEquals("0-30", jeu.score());
    }

    @Test
    public void testAddNewPoint_40()
    {
        jeu.add(1);
        jeu.add(1);
        jeu.add(1);
        Assert.assertTrue(jeu.isGameRunning());
        Assert.assertEquals("0-40", jeu.score());
    }

    @Test
    public void testAddNewPoint_victoire()
    {
        jeu.add(1);
        jeu.add(1);
        jeu.add(1);
        jeu.add(1);
        Assert.assertFalse(jeu.isGameRunning());
        Assert.assertEquals("Player2",jeu.winner());
    }

    @Test
    public void testAddNewPoint_equals()
    {
        jeu.add(0);
        jeu.add(1);
        jeu.add(0);
        jeu.add(1);
        jeu.add(0);
        jeu.add(1);
        jeu.add(0);
        Assert.assertTrue(jeu.isGameRunning());
        Assert.assertEquals("Equal",jeu.winner());
    }
}
