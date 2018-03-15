
import javax.swing.JFrame;

public class MainClass {

    //Main Method
    public static void main(String[] args) {
        //JFrame
        JFrame f = new JFrame("Tetris Test");
        f.setSize(500, 700);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Adding The Shape
        //
        f.add(new PlayingPanel());
        f.setVisible(true);
    }
}
