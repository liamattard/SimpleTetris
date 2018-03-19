
import java.awt.Graphics;

public class LShape extends Tetromino {

    public LShape(int xPos, int yPos) {
        setxPos(xPos);
        setyPos(yPos);
        blocks = new Block[4];

    }
    
    public void updateMap(char map[][]){
        
    }

    public void paint(Graphics g) {
        /*ROTATE 1 Original LSHAPE*/
        blocks[0] = new Block(xPos, yPos);
        blocks[1] = new Block(xPos - 25, yPos);
        blocks[2] = new Block(xPos , yPos + 25);
        blocks[3] = new Block(xPos , yPos + 50);
        
        
        /*ROTATE 2
        blocks[0] = new Block(xPos, yPos);
        blocks[1] = new Block(xPos, yPos + 25 );
        blocks[2] = new Block(xPos + 25, yPos);
        blocks[3] = new Block(xPos + 50, yPos);
        */
        
        /*ROTATE 3  
        blocks[0] = new Block(xPos, yPos);
        blocks[1] = new Block(xPos + 25, yPos);
        blocks[2] = new Block(xPos , yPos - 25);
        blocks[3] = new Block(xPos , yPos - 50);
        */
        
        /*ROTATE 4 
        blocks[0] = new Block(xPos, yPos);
        blocks[1] = new Block(xPos , yPos - 25);
        blocks[2] = new Block(xPos - 25, yPos );
        blocks[3] = new Block(xPos - 50, yPos);
        */
        
        super.paint(g);
        for (int i = 0; i < blocks.length; i++) {
            blocks[i].paint(g);
        }
        

        
    }

    @Override
    public void rotate() {
    }
}
