
import java.awt.Graphics;

public class Square extends Tetromino {

    public Square(int xPos, int yPos) {
        setxPos(xPos);
        setyPos(yPos);
        blocks = new Block[4];
    }

    public void updateMap(char map[][]) {

        int column1Pos = ((xPos - 50) / 25) + 1;
        int row1Pos = (yPos - 50) / 25;

        map[row1Pos][column1Pos] = 'x';
        map[row1Pos][column1Pos + 1] = 'x';
        map[row1Pos + 1][column1Pos] = 'x';
        map[row1Pos + 1][column1Pos + 1] = 'x';

        bottomPos = row1Pos + 1;

        xPositions = new int[2];
        xPositions[0] = column1Pos;
        xPositions[1] = column1Pos + 1;

        yBottomPositions = new int[2];
        yBottomPositions[0] = row1Pos + 1;
        yBottomPositions[1] = row1Pos + 1;
    }

    public void paint(Graphics g) {
        blocks[0] = new Block(xPos, yPos);
        blocks[1] = new Block(xPos + 25, yPos);
        blocks[2] = new Block(xPos, yPos + 25);
        blocks[3] = new Block(xPos + 25, yPos + 25);
        super.paint(g);
        for (int i = 0; i < blocks.length; i++) {
            blocks[i].paint(g);
        }
    }

    @Override
    public void rotate() {
    }
}
