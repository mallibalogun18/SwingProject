import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    //all components variables added to the GUI should be set as private
    private TextPanel jTextArea;
    private ToolBar toolBar;
    private FormPanel formPanel;

    public MainFrame(){
        super("Main Frame");
        setLayout(new BorderLayout());

        jTextArea = new TextPanel();
        toolBar = new ToolBar();
        formPanel = new FormPanel();

        add(toolBar, BorderLayout.NORTH);
        add(jTextArea, BorderLayout.CENTER);
        add(formPanel, BorderLayout.WEST);

        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        toolBar.setStringListiner(new StringListiner() {
            @Override
            public void textEmitted(String text) {
                if (text == "OK"){
                    jTextArea.appendText(text+"\n");
                } else if (text == "Clear"){
                    jTextArea.cleatTextArea();
                }
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
