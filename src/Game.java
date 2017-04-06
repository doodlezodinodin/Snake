import objects.Apple;
import objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Game extends JPanel implements ActionListener{

    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;

    public static final int SPEED = 10;

    Snake snake = new Snake(10, 10, 9, 10);
    Apple apple = new Apple((int) (Math.random()*WIDTH), (int) (Math.random()*HEIGHT));
    Timer timer = new Timer(1000/SPEED, this);

    public Game() {
        timer.start();
        addKeyListener(new Keyboard());
        setFocusable(true);
    }

    public void paint(Graphics graphics) {
        graphics.setColor(color(240, 248, 255));
        graphics.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
        graphics.setColor(color(0, 0, 0));

        for(int x = 0; x <= WIDTH*SCALE; x+=SCALE){
            graphics.drawLine(x, 0, x, HEIGHT*SCALE);
        }

        for(int y = 0; y <= HEIGHT*SCALE; y+=SCALE){
            graphics.drawLine(0, y, HEIGHT*SCALE, y);
        }

        for(int i = 0; i < snake.length; i++) {
            graphics.setColor(color(0, 191, 255));
            graphics.fillRect(snake.snakeX[i]*SCALE+1, snake.snakeY[i]*SCALE+1, SCALE-1, SCALE-1);
        }

        graphics.setColor(color(255, 0, 147));
        graphics.fillRect(apple.appleX*SCALE+1, apple.appleY*SCALE+1, SCALE-1, SCALE-1);
    }

    public Color color(int red, int green, int blue){
        return new Color(red, green, blue);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        frame.setTitle("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(WIDTH*SCALE+7, HEIGHT*SCALE+30);
        frame.setLocationRelativeTo(null);
        frame.add(new Game());
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        snake.move(WIDTH, HEIGHT);

        if((snake.snakeX[0] == apple.appleX) & snake.snakeY[0] == apple.appleY){
            apple.setRandomPosition();
            snake.length++;
        }
        for(int i = 1; i < snake.length; i++) {
            if ((snake.snakeX[i] == apple.appleX) & snake.snakeY[i] == apple.appleY) {
                apple.setRandomPosition();
                snake.length++;
            }
        }
        repaint();
    }

    private class Keyboard extends KeyAdapter {
        public void keyPressed(KeyEvent keyEvent) {
            int key = keyEvent.getKeyCode();

            if((key == KeyEvent.VK_UP) & snake.direction != 1) snake.direction = 0;
            if((key == KeyEvent.VK_DOWN) & snake.direction != 0) snake.direction = 1;
            if((key == KeyEvent.VK_LEFT) & snake.direction != 3) snake.direction = 2;
            if((key == KeyEvent.VK_RIGHT) & snake.direction != 2) snake.direction = 3;
        }
    }
}






