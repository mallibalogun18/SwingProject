import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    //all components variables added to the GUI should be set as private
    private TextPanel jTextArea;
    private JButton jButton;
    private ToolBar toolBar;

    public MainFrame(){
        super("Main Frame");
        setLayout(new BorderLayout());

        jTextArea = new TextPanel();
        jButton = new JButton("Click Me!");
        toolBar = new ToolBar();

        add(toolBar, BorderLayout.NORTH);
        add(jTextArea, BorderLayout.CENTER);
        add(jButton, BorderLayout.SOUTH);

        toolBar.setStringListiner(new StringListiner() {
            @Override
            public void textEmitted(String text) {
                jTextArea.appendText(text+"\n");
            }
        });

        setSize(300,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea.appendText(jButton.getText()+"\n");
//                jTextArea.append(jButton.getText()+"\n");
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
