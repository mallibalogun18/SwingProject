import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    //all components variables added to the GUI should be set as private
    private JTextArea jTextArea;
    private JButton jButton;

    public MainFrame(){
        super("Main Frame");
        setLayout(new BorderLayout());

        jTextArea = new JTextArea();
        jButton = new JButton("Click Me!");

        add(jTextArea, BorderLayout.CENTER);
        add(jButton, BorderLayout.SOUTH);

        setSize(300,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea.append(jButton.getText()+"\n");
            }
        });

        //This is a the lambda method way
        // that conduct the same function as the method above.
       /* jButton.addActionListener(e -> {
            String text = jButton.getText();
            jTextArea.append(text+"\n");
        });*/
    }
}
