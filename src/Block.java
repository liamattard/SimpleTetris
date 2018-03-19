
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Block extends JPanel {

    public final int SIZE = 25;

    private int xPos;
    private int yPos;

    private boolean forpanel = false;
    private boolean filled = false;

    public Block(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Block(int xPos, int yPos, boolean forPanel, boolean filled) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.forpanel = forPanel;
        this.filled = filled;
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

    public void paint(Graphics g) {
        super.paint(g);
        if (forpanel == true) {
            g.setColor(Color.DARK_GRAY);
            if (filled == true) {
                g.fillRect(xPos, yPos, SIZE, SIZE);
            } else {
                g.drawRect(xPos, yPos, SIZE, SIZE);
            }
            g.drawRect(xPos, yPos, SIZE, SIZE);
        } else {
            g.setColor(Color.green);
            g.fillRect(xPos, yPos, SIZE, SIZE);
            g.setColor(Color.BLUE);
            g.drawRect(xPos, yPos, SIZE, SIZE);
        }
    }
}
