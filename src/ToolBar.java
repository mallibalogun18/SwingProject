import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel implements ActionListener {

    private JButton clearScreen;
    private StringListiner stringListiner;

    public ToolBar(){
       super();
       setBorder(BorderFactory.createEtchedBorder());
//        Border innerBorder = BorderFactory.createTitledBorder("Tool Bar");
//        Border outterBorder = BorderFactory.createEmptyBorder(5,0,5,5);
//        setBorder(BorderFactory.createCompoundBorder(outterBorder,innerBorder));
       clearScreen = new JButton("Clear Screen");

       //The FLowLayout is a layout manager that set the component added next to each other. You can manipulate the location
        //of the components in the layout by passing the FlowLayout.(LEFT or RIGHT) in the constructor. You cannot
        //set the component vertically. Only horizontally.
       setLayout(new FlowLayout(FlowLayout.RIGHT));

       clearScreen.addActionListener(this);
       add(clearScreen);
    }

    public void setStringListener(StringListiner listener){
        this.stringListiner = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonCLicked = (JButton)e.getSource();
        stringListiner.textEmitted(buttonCLicked.getText());
    }
}
