
import javax.swing.JFrame;


public class Test {

    public static void main(String[] args) {
        JFrame f = new JFrame("Tetris Test");
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new SShape(50, 50));
        f.setVisible(true);
    }

}
