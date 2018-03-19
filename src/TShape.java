
import java.awt.Graphics;

public class TShape extends Tetromino {

    public TShape(int xPos, int yPos) {
        setxPos(xPos);
        setyPos(yPos);
        blocks = new Block[4];
    }

    public void updateMap(char map[][]) {

        int column1Pos = ((xPos - 50) / 25);
        int row1Pos = (yPos - 50) / 25;

        if (rotateValue == 0) {
            map[row1Pos][column1Pos + 1] = 'x';
            map[row1Pos + 1][column1Pos] = 'x';
            map[row1Pos + 1][column1Pos + 1] = 'x';
            map[row1Pos + 2][column1Pos + 1] = 'x';
            bottomPos = row1Pos + 2;

            xPositions = new int[2];
            xPositions[0] = column1Pos;
            xPositions[1] = column1Pos + 1;

            yBottomPositions = new int[2];
            yBottomPositions[0] = row1Pos + 1;
            yBottomPositions[1] = row1Pos + 2;
        }else if(rotateValue == 1){
            
        }else if(rotateValue == 2){
            
        }
    }

    public void paint(Graphics g) {
        if (rotateValue == 1) {
            /* ROTATE 1 original
                X
               XX
                X
             */
            blocks[0] = new Block(xPos, yPos);
            blocks[1] = new Block(xPos + 25, yPos);
            blocks[2] = new Block(xPos + 50, yPos);
            blocks[3] = new Block(xPos + 25, yPos + 25);
        } else if (rotateValue == 2) {

            /*ROTATE 2
                XXX
                 X
             */
            blocks[0] = new Block(xPos, yPos);
            blocks[1] = new Block(xPos, yPos + 25);
            blocks[2] = new Block(xPos, yPos + 50);
            blocks[3] = new Block(xPos + 25, yPos + 25);
        } else if (rotateValue == 3) {
            /*ROTATE 3 
                X
                XX
                X
             */
            blocks[0] = new Block(xPos, yPos);
            blocks[1] = new Block(xPos - 25, yPos);
            blocks[2] = new Block(xPos - 50, yPos);
            blocks[3] = new Block(xPos - 25, yPos - 25);
        } else {
            /*ROTATE 4 
                 X
                XXX
             */
            blocks[0] = new Block(xPos, yPos);
            blocks[1] = new Block(xPos, yPos + 25);
            blocks[2] = new Block(xPos, yPos + 50);
            blocks[3] = new Block(xPos - 25, yPos + 25);
        }
        super.paint(g);
        for (int i = 0; i < blocks.length; i++) {
            blocks[i].paint(g);
        }
    }

    @Override
    public void rotate() {
        rotateValue++;
        if (rotateValue == 5) {
            rotateValue = 1;
        }
    }
}
