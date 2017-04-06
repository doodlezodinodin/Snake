package objects;


import javax.swing.*;

public class Snake {

    public int direction = 2;
    public int length = 1;

    public int snakeX[] = new int[25];
    public int snakeY[] = new int[25];

    public Snake(int x0, int y0, int x1, int y1){
        snakeX[0] = x0;
        snakeY[0] = y0;
        snakeX[1] = x1;
        snakeY[1] = y1;
    }

    public void move(int w, int h){
        for(int i = length; i > 0; i--){
            snakeX[i] = snakeX[i-1];
            snakeY[i] = snakeY[i-1];
        }

        if(direction == 0) snakeY[0]--;
        if(direction == 1) snakeY[0]++;
        if(direction == 2) snakeX[0]--;
        if(direction == 3) snakeX[0]++;

        for(int i = length-1; i > 0; i--){
            if((snakeX[0] == snakeX[i]) & (snakeY[0] == snakeY[i])){
                length = i;
            }
        }

        if(snakeX[0] == -1) snakeX[0] = w;
        else if(snakeX[0] == w) snakeX[0] = 0;

        if(snakeY[0] == -1) snakeY[0] = h;
        else if(snakeY[0] == h) snakeY[0] = 0;
    }
}
