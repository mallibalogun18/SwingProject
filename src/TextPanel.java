import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {

    private JTextArea jTextArea;

    public TextPanel(){
        super();
        jTextArea = new JTextArea();

        setLayout(new BorderLayout());
        //the new JScrollPane will give the JPanel a scroll pane that wraps around the JTextArea
        add(new JScrollPane(jTextArea), BorderLayout.CENTER);
    }

    public void appendText(String text){
        jTextArea.append(text);
    }

}
