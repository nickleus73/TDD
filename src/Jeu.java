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
            case 0: scorePlayer1 = upScore(scorePlayer1);
            case 1: scorePlayer2 = upScore(scorePlayer2);
        }
    }

    public boolean isGameRunning()
    {
        return false;
    }

    public String winner()
    {
        String player = "";

        if(scorePlayer1 > 40) {
            player = "Player1";
        }

        if(scorePlayer2 > 40) {
            player = "Player2";
        }

        return player;
    }

    private int upScore(int score){
        switch(score){
            case 0:
            case 15:
                return score += 15;
            case 30:
                return score += 10;
            case 40:
                return score += 1;
        }

        return score;
    }
}
