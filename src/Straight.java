
import java.awt.Graphics;

public class Straight extends Tetromino {

    public Straight(int xPos, int yPos) {
        setxPos(xPos);
        setyPos(yPos);
        blocks = new Block[4];

    }

    public void updateMap(char map[][]) {

    }

    public void paint(Graphics g) {
        /*ROTATE 1 original shape */
        for (int i = 0; i < blocks.length; i++) {
            blocks[i] = new Block(xPos + (i * 25), yPos);
        }

        /*ROTATE 2
        for (int i = 0; i < blocks.length; i++) {
            blocks[i] = new Block(xPos, yPos + (i * 25));
        }*/
        super.paint(g);

        for (int i = 0; i < blocks.length; i++) {
            blocks[i].paint(g);
        }
    }

    @Override
    public void rotate() {
    }

}
