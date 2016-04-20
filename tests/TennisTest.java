import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.util.Arrays;

import static org.mockito.Mockito.*;

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
        Assert.assertTrue(jeu.isGameRunning());
        Assert.assertEquals("Equal",jeu.winner());
    }

    @Test
    public void testAddNewPoint_advantage()
    {
        jeu.add(0);
        jeu.add(1);
        jeu.add(0);
        jeu.add(1);
        jeu.add(0);
        jeu.add(1);
        jeu.add(1);
        Assert.assertTrue(jeu.isGameRunning());
        Assert.assertEquals("Advantage",jeu.winner());
    }

    @Test
    public void testAddNewPoint_returnToEqual()
    {
        jeu.add(0);
        jeu.add(1);
        jeu.add(0);
        jeu.add(1);
        jeu.add(0);
        jeu.add(1);
        jeu.add(1);
        jeu.add(0);
        Assert.assertTrue(jeu.isGameRunning());
        Assert.assertEquals("Equal",jeu.winner());
    }

    @Test
    public void testAddNewPoint_saveAndLoad()
    {
        jeu.setDb(new DatabaseBouchon());
        jeu.add(0);
        jeu.add(1);
        jeu.add(0);
        jeu.add(1);
        Assert.assertEquals("30-30", jeu.score());
        jeu.save();
        Assert.assertEquals("30-30", jeu.score());
        jeu.reset();
        Assert.assertEquals("0-0", jeu.score());
        jeu.add(1);
        Assert.assertEquals("0-15", jeu.score());
        jeu.load();
        Assert.assertEquals("30-30", jeu.score());
        jeu.reset();
        Assert.assertEquals("0-0", jeu.score());
        jeu.load();
        Assert.assertEquals("15-15", jeu.score());
    }

    @Test
    public void testAddNewPoint_mock() throws IOException {
        /*jeu = spy(Jeu.class);
        when(jeu.save()).then();
        when(jeu.load()).then();
        */

        Database db = new Database();
        db = spy(db);
        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invoc) {
                Object[] args = invoc.getArguments();
                Jeu jeu = (Jeu)args[0];
                jeu.setScorePlayer1(30);
                jeu.setScorePlayer2(30);
                return null;
            }
        }).when(db).load(any(Jeu.class));

        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invoc) {
                return null;
            }
        }).when(db).save(any(Jeu.class));

        jeu.setDb(db);

        jeu.add(0);
        jeu.add(1);
        jeu.add(0);
        jeu.add(1);
        Assert.assertEquals("30-30", jeu.score());
        jeu.save();
        Assert.assertEquals("30-30", jeu.score());
        jeu.reset();
        Assert.assertEquals("0-0", jeu.score());
        jeu.add(1);
        Assert.assertEquals("0-15", jeu.score());
        jeu.load();
        Assert.assertEquals("30-30", jeu.score());
        jeu.reset();
        Assert.assertEquals("0-0", jeu.score());
        jeu.load();
        Assert.assertEquals("30-30", jeu.score());
    }
}
