import javax.swing.*;

public class Main {



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jFrame = new JFrame("Hello. Welcome to the Swing Project");
                jFrame.setSize(300,300);
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.setVisible(true);
                jFrame.setLocationRelativeTo(null);
            }
        });
    }
}
