
import javax.swing.JPanel;

public abstract class Tetromino extends JPanel{
    
    protected int xPos;
    protected int yPos;
    protected Block blocks[];
    protected int bottomPos;
    
    protected int[] xPositions;
    protected int[] yBottomPositions;
    
    protected int rotateValue;

    public int getBottomPos() {
        return bottomPos;
    }

    public int[] getyBottomPositions() {
        return yBottomPositions;
    }

    public int[] getxPositions() {
        return xPositions;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
    
    public void moveDown(){
        this.yPos = this.yPos + 25;
    }
    
    public void moveLeft(){
        xPos = xPos - 25;
    }
    
    public void moveRight(){
        xPos = xPos + 25;
    }
    
    public abstract void rotate();
    public abstract void updateMap(char map[][]);
}
