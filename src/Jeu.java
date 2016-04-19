import java.io.IOException;

/**
 * Created by sephirius on 19/04/16.
 */
public class Jeu {

    private Database db = new Database();

    boolean isGameRunning = true;

    public int getScorePlayer1() {
        return scorePlayer1;
    }

    public void setScorePlayer1(int scorePlayer1) {
        this.scorePlayer1 = scorePlayer1;
    }

    public int getScorePlayer2() {
        return scorePlayer2;
    }

    public void setScorePlayer2(int scorePlayer2) {
        this.scorePlayer2 = scorePlayer2;
    }

    private int scorePlayer1, scorePlayer2 = 0;

    public String score()
    {
        return new StringBuilder().append(scorePlayer1).append("-").append(scorePlayer2).toString();
    }

    public void add(int player){
        switch(player){
            case 0: scorePlayer1 = upScore(scorePlayer1);
                break;
            case 1: scorePlayer2 = upScore(scorePlayer2);
                break;
        }

        if((scorePlayer1 > 40 || scorePlayer2 > 40) && (Math.abs(scorePlayer1-scorePlayer2)>1)){
            isGameRunning = false;
        }
    }

    public boolean isGameRunning()
    {
        return isGameRunning;
    }

    public String winner()
    {
        if(!isGameRunning)
            if(scorePlayer1 > scorePlayer2)
                return "Player1";
            else
                return "Player2";
        else if(scorePlayer1 >= 40 && scorePlayer2 >= 40)
                if(scorePlayer1 == scorePlayer2)
                    return "Equal";
                else if(Math.abs(scorePlayer1-scorePlayer2)==1)
                    return "Advantage";

        return "";
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

    public void save(){
        try {
            db.save(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(){
        try {
            db.load(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reset(){
        this.isGameRunning = true;
        this.setScorePlayer2(0);
        this.setScorePlayer1(0);
    }
}
