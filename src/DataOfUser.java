import java.io.Serializable;

public class DataOfUser implements Serializable {

    int Score;

    DataOfUser(int High){

        Score=High;
    }
    public String toString(){
        return Integer.toString(Score);
    }
    public int getScore(){
        return Score;
    }



    public void setScore(int highScore) {
        Score = highScore;
    }
}
