/**
 * Created by sephirius on 19/04/16.
 */
public class Jeu {

    private int scorePlayer1, scorePlayer2 = 0;

    public String score()
    {
        return new StringBuilder().append(scorePlayer1).append("-").append(scorePlayer2).toString();
    }

    public void add(int player){
        switch(player){
            case 0: scorePlayer1 += 15;
            case 1: scorePlayer2 += 15;
        }
    }
}
