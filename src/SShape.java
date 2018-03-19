
import java.awt.Graphics;


public class SShape extends Tetromino{
    
    public SShape(int xPos,int yPos){
        setxPos(xPos);
        setyPos(yPos);
        blocks = new Block[4];

        
    }
    
    public void updateMap(char map[][]){
        
    }
    
    public void paint(Graphics g){
        /*ROTATE 1 original shape */
        blocks[0] = new Block(xPos , yPos);
        blocks[1] = new Block(xPos + 25, yPos);
        blocks[2] = new Block(xPos , yPos + 25);
        blocks[3] = new Block(xPos - 25, yPos + 25);
        
        /*ROTATE 2
        blocks[0] = new Block(xPos , yPos);
        blocks[1] = new Block(xPos , yPos + 25);
        blocks[2] = new Block(xPos - 25, yPos );
        blocks[3] = new Block(xPos - 25, yPos - 25);
        */
        super.paint(g);        
        
        for(int i = 0;i < blocks.length;i++){
            blocks[i].paint(g);
        }
    }
    
    @Override
    public void rotate() {
    }
}
