
import java.awt.Graphics;

public class ZShape extends Tetromino {

    public ZShape(int xPos, int yPos) {
        setxPos(xPos);
        setyPos(yPos);
        blocks = new Block[4];
    }

    public void updateMap(char map[][]) {

    }

    public void paint(Graphics g) {
        super.paint(g);
        blocks[0] = new Block(xPos, yPos);
        blocks[1] = new Block(xPos + 25, yPos);
        blocks[2] = new Block(xPos + 25, yPos + 25);
        blocks[3] = new Block(xPos + 50, yPos + 25);

        for (int i = 0; i < blocks.length; i++) {
            blocks[i].paint(g);
        }
    }

    @Override
    public void rotate() {
    }
}
