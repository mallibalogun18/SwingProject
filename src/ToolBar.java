import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel implements ActionListener {

    private JButton buttonOK;
    private JButton clearScreen;
    private StringListiner stringListiner;

    public ToolBar(){
       super();
       setBorder(BorderFactory.createEtchedBorder());
//        Border innerBorder = BorderFactory.createTitledBorder("Tool Bar");
//        Border outterBorder = BorderFactory.createEmptyBorder(5,0,5,5);
//        setBorder(BorderFactory.createCompoundBorder(outterBorder,innerBorder));

       buttonOK = new JButton("OK");
       clearScreen = new JButton("Clear Screen");

       //The FLowLayout is a layout manager that set the component added next to each other. You can manipulate the location
        //of the components in the layout by passing the FlowLayout.(LEFT or RIGHT) in the constructor. You cannot
        //set the component vertically. Only horizontally.
       setLayout(new FlowLayout(FlowLayout.CENTER));

       buttonOK.addActionListener(this);
       clearScreen.addActionListener(this);
       add(buttonOK);
       add(clearScreen);
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
