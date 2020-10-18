import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {

    private JTextArea jTextArea;

    public TextPanel(){
        super();
        jTextArea = new JTextArea();

        setLayout(new BorderLayout());
        //the new JScrollPane will be embedded in the JPanel, while it wraps the JTextArea variable
        add(new JScrollPane(jTextArea), BorderLayout.CENTER);
    }

    public void appendText(String text){
            jTextArea.append(text);
    }

    public void cleatTextArea(){
        jTextArea.selectAll();
        jTextArea.replaceSelection("");
    }

}
