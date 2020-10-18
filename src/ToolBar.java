import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel implements ActionListener {

    private JButton buttonOK;
    private JButton buttonCancel;
    private StringListiner stringListiner;

    public ToolBar(){
       super();

       buttonOK = new JButton("OK");
       buttonCancel = new JButton("Cancel");

       //The FLowLayout is a layout manager that set the component added next to each other. You can manipulate the location
        //of the components in the layout by passing the FlowLayout.(LEFT or RIGHT) in the constructor. You cannot
        //set the component vertically. Only horizontally.
       setLayout(new FlowLayout(FlowLayout.LEFT));

       buttonOK.addActionListener(this);
       buttonCancel.addActionListener(this);
       add(buttonOK);
       add(buttonCancel);
    }

    public void setStringListiner(StringListiner listiner){
        this.stringListiner = listiner;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonCLicked = (JButton)e.getSource();
        stringListiner.textEmitted(buttonCLicked.getText());
    }
}
