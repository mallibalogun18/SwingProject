import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JTextField nameText;
    private JTextField occupationTex;
    private JButton enterButton;

    public FormPanel(){
        super();
        //set the size of the FormPanel using the Dimesion class
        Dimension dimension = getPreferredSize();
        dimension.width = 250;
        setPreferredSize(dimension);

        nameLabel = new JLabel("First Name: ");
        occupationLabel = new JLabel("Last Name: ");
        nameText = new JTextField(10);
        occupationTex = new JTextField(10);
        enterButton = new JButton("Submit");

        //create an inner and outer border
        Border innerBorder = BorderFactory.createTitledBorder("Add person");
        Border outterBorder = BorderFactory.createEmptyBorder(10,10,10,10);

        //this will add the title to the border
        setBorder(BorderFactory.createCompoundBorder(outterBorder,innerBorder));

        //GridBagLayout to properly arrange the components to the FormPanel
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //set spacing in the GridBagLayout
        /////////////////first row /////////////////////////////
        c.weightx = 1;
        c.weighty = .1;

        c.gridx = 0;
        c.gridy = 0;
        //this specify the side of the cell that the control sticks to
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets =new Insets(0,0,0,5);
        add(nameLabel,c);
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets =new Insets(0,0,0,0);
        add(nameText,c);

        /////////////////second row /////////////////////////////
        c.weightx = 1;
        c.weighty = .1;

        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets =new Insets(0,0,0,5);
        add(occupationLabel,c);
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets =new Insets(0,0,0,0);
        add(occupationTex,c);

        /////////////////third row /////////////////////////////
        c.weightx = 1;
        c.weighty = 2.0;

        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        add(enterButton,c);
    }


}
