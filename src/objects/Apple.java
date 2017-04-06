package objects;

/**
 * Created by alex on 06.04.2017.
 */
public class Apple {



    public int appleX;
    public int appleY;

    public Apple(int appleX, int appleY){
        this.appleX = appleX;
        this.appleY = appleY;
    }

    public void setRandomPosition(){
        appleX = (int) (Math.random()*20);
        appleY = (int) (Math.random()*20);
    }
}
