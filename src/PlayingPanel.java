
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PlayingPanel extends JPanel implements ActionListener, KeyListener {

    private Tetromino tetrimino;
    private Timer myTimer = new Timer(800, this);
    private int totalLines = 0;
    private String playerNickName;
    private char previousTop = ' ';

    private char[][] map = {
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}};

    public PlayingPanel() {
        playerNickName = JOptionPane.showInputDialog("Enter your nick name");
        addKeyListener(this);
        myTimer.start();
        getNextTetrimino();
        setFocusable(true);
    }

    private void getNextTetrimino() {
        tetrimino = getRandomTetrimino(); //new Square(100, 50); //getRandomTetrimino();
    }

    private Tetromino getRandomTetrimino() {
        Random r = new Random();

        switch (r.nextInt(2)) {
            case 0:
                return new Square(100, 50);
            case 1:
                return new TShape(100, 50);
        }

        switch (r.nextInt(7)) {
            case 0:
                return new JShape(100, 50);
            case 1:
                return new LShape(100, 50);
            case 2:
                return new SShape(100, 50);
            case 3:
                return new Square(100, 50);
            case 4:
                return new Straight(100, 50);
            case 5:
                return new TShape(100, 50);
            case 6:
                return new ZShape(100, 50);
        }
        return null;
    }

    public void paint(Graphics g) {
        super.paint(g);
        tetrimino.paint(g);
        g.setColor(Color.red);
        g.drawString("PLAYER: " + playerNickName, 300, 50);
        g.drawString("TOTAL LINES: " + totalLines, 300, 80);
        // g.drawLine(25, 600, 25 + (25 * 9), 600);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 22; j++) {
                if (map[j][i] == 'x') {
                    Block b = new Block(25 + (i * 25), 50 + (j * 25), true, true);
                    b.paint(g);
                } else {
                    Block b = new Block(25 + (i * 25), 50 + (j * 25), true, false);
                    b.paint(g);
                }
            }
        }
    }

    // For testing purposes only
    private void displayMap() {
        System.out.println("-----------------------------------------------------------------------");
        for (int j = 0; j < 21; j++) {
            for (int i = 0; i < 9; i++) {
                System.out.print(map[j][i]);
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------");
    }

    private boolean checkIfLine() {
        for (int i = 0; i < 21; i++) {
            boolean isFilled = true;
            for (int j = 0; j < 9; j++) {
                if (map[i][j] != 'x') {
                    isFilled = false;
                }
            }

            if (isFilled) {
                try {
                    for (int x = i - 1; x >= 1; x--) {
                        for (int j = 0; j < 9; j++) {
                            map[x + 1][j] = map[x][j];
                        }
                    }
                } catch (Exception e) {
                    // Do nothing
                }
                for (int j = 0; j < 9; j++) {
                    map[0][j] = ' ';
                }
                totalLines++;
            }
        }
        return true;
    }

    private void checkIfHit() {
        boolean bottomHit = false;
        int startFromRow = tetrimino.getBottomPos();

        displayMap();

        try {
            for (int i = 0; i < tetrimino.getxPositions().length; i++) {
                if (map[tetrimino.getyBottomPositions()[i]][tetrimino.getxPositions()[i]] == 'x'
                        && map[tetrimino.getyBottomPositions()[i] + 1][tetrimino.getxPositions()[i]] == 'x') {
                    bottomHit = true;
                    repaint();
                    getNextTetrimino();
                }
            }
        } catch (Exception e) {
            // bottomHit = false;
        }

        // Clean the map
        if (bottomHit == false) {
            for (int i = 0; i <= startFromRow; i++) {
                for (int j = 0; j < tetrimino.getxPositions().length; j++) {
                    map[i][tetrimino.getxPositions()[j]] = ' ';
                }
            }
        }
    }

    private void saveScores() {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("SCORES.TXT", true));
            out.write("\n" + playerNickName + "," + totalLines);
            out.close();
        } catch (Exception e) {
            System.out.println("Score Not Saved");
        }
    }

    private void showScores() {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>();
        // Load scores from file
        try {
            BufferedReader in = new BufferedReader(new FileReader("SCORES.TXT"));
            String str;
            while ((str = in.readLine()) != null) {
                String x[] = str.split(",");
                try{
                    names.add(x[0]);
                    scores.add(Integer.parseInt(x[1]));
                }catch(Exception e){
                    // Do nothing
                }
            }
            in.close();
        } catch (Exception e) {
             System.out.println("Scores Not Loaded");
        }
        
        // Do the sorting
        // Bubble sort
        int n = scores.size();
        Integer[] scoresArray = scores.toArray(new Integer[n]);
        String[] namesArray = names.toArray(new String[n]);
        
        for (int j = 0; j < scoresArray.length; j++) {
            for (int i = j + 1; i < scoresArray.length; i++) {
                if (scoresArray[i] > scoresArray[j]){
                    // Swap the integer
                    Integer t = scoresArray[j];
                    scoresArray[j] = scoresArray[i];
                    scoresArray[i] = t;
                    
                    // Swap the string
                    String s = namesArray[j];
                    namesArray[j] = namesArray[i];
                    namesArray[i] = s; 
                }
            }
        }
        
        // Now Display the scores in order
        String msg = "";
        for(int i = 0;i < scoresArray.length;i++){
            msg = msg + namesArray[i] + " -> " + scoresArray[i] + "\n" ;
        }
        JOptionPane.showMessageDialog(this, msg, "Scores", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private void doGameOver() {
        JOptionPane.showMessageDialog(this, "GAME OVER :(");
        saveScores();
        try{
            // 4 seconds Delay to give time to save
            Thread.sleep(4000);
        }catch(Exception e){
            // Do nothing
        }
        showScores();
    }

    private void checkIfGameOver() {
        for (int i = 0; i < 9; i++) {
            if (map[0][i] == 'x') {
                doGameOver();
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        try {
            tetrimino.moveDown();
            tetrimino.updateMap(map);
            checkIfHit();
            checkIfLine();
            repaint();
            checkIfGameOver();
        } catch (Exception exp) {
            doGameOver();
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 37) {
            // LEFT
            tetrimino.moveLeft();
        } else if (e.getKeyCode() == 39) {
            // RIGHT
            tetrimino.moveRight();
        } else if (e.getKeyCode() == 38) {
            // ROTATE
            tetrimino.rotate();
        } else if (e.getKeyCode() == 32) {
            // DOWN
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {

    }
}
