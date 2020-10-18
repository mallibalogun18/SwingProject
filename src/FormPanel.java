import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel implements ActionListener {

    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JTextField nameField;
    private JTextField occupationField;
    private JButton enterButton;
    private JButton clearButton;
    private StringListiner stringListiner;

    public FormPanel(){
        super();
        //set the size of the FormPanel using the Dimesion class
        Dimension dimension = getPreferredSize();
        dimension.width = 300;
        setPreferredSize(dimension);

        nameLabel = new JLabel("First Name: ");
        occupationLabel = new JLabel("Occupation: ");
        nameField = new JTextField(10);
        occupationField = new JTextField(10);
        enterButton = new JButton("Submit");
        clearButton = new JButton("Clear");

        nameField.setForeground(Color.BLUE);
        occupationField.setForeground(Color.BLUE);

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
        add(nameField,c);

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
        add(occupationField,c);

        /////////////////third row /////////////////////////////
        c.weightx = 1;
        c.weighty = 2.0;

        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        add(enterButton,c);
        c.gridx = 2;
        c.gridy = 2;
        add(clearButton,c);


        clearButton.addActionListener(this);
        enterButton.addActionListener(this);

//        clearButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                nameField.setText("");
//                occupationField.setText("");
//            }
//        });
//
//        enterButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                if(nameField.getText().isEmpty() || occupationField.getText().isEmpty()){
//                JOptionPane.showMessageDialog(null,"Enter value in each field","Warning",2);
//                } else {
//                    String text = "Name: "+ nameField.getText()+"\nOccupation: "+ occupationField.getText();
//                    stringListiner.textEmitted(text);
//                }
//
//            }
//        });
    }

    public void setStringListiner(StringListiner listiner){
        this.stringListiner = listiner;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();

        if (button.getText() == "Submit"){
            if(nameField.getText().isEmpty() || occupationField.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter value in each field","Warning",2);
            } else {
                String text = "Name: "+ nameField.getText()+"\nOccupation: "+ occupationField.getText();
                stringListiner.textEmitted(text);
            }
        }else if (button.getText() == "Clear"){
            nameField.setText("");
            occupationField.setText("");
        }

    }
}
