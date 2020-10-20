import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel implements ActionListener {

    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JTextField nameField;
    private JTextField occupation;
    private JButton enterButton;
    private JButton clearButton;
    private StringListiner stringListiner;
    private JComboBox empBox;
    private JCheckBox citizenCheck;
    private JLabel citizenLabel;
    private JLabel degreeLabel;
    private JLabel ssnLabel;
    private JTextField ssnField;

    public FormPanel(){
        super();
        //set the size of the FormPanel using the Dimesion class
        Dimension dimension = getPreferredSize();
        dimension.width = 325;
        setPreferredSize(dimension);

        nameLabel = new JLabel("First Name: ");
        occupationLabel = new JLabel("Occupation: ");
        nameField = new JTextField(10);
        occupation = new JTextField(10);
        enterButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        citizenLabel = new JLabel("Citizen ");
        empBox = new JComboBox();
        citizenCheck = new JCheckBox();
        ssnLabel = new JLabel("SSN: ");
        degreeLabel = new JLabel("Degree: ");
        ssnField = new JTextField(10);

        ssnLabel.setEnabled(false);
        ssnField.setEnabled(false);

        citizenCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isChecked = citizenCheck.isSelected();
                ssnLabel.setEnabled(isChecked);
                ssnField.setEnabled(isChecked);
            }
        });

        nameField.setForeground(Color.BLUE);
        occupation.setForeground(Color.BLUE);

        //set combo box
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        defaultComboBoxModel.addElement("H.S or G.E.D");
        defaultComboBoxModel.addElement("Associate");
        defaultComboBoxModel.addElement("Bachelor's");
        defaultComboBoxModel.addElement("Master's");
        defaultComboBoxModel.addElement("Doctoral");
        empBox.setModel(defaultComboBoxModel);

        empBox.setSelectedIndex(3);



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
        add(occupation,c);

        /////////////////third row /////////////////////////////
        c.weightx = 1;
        c.weighty = .2;

        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets =new Insets(0,0,0,5);
        add(degreeLabel,c);
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets =new Insets(0,0,0,0);
        add(empBox,c);

        /////////////////third row /////////////////////////////
        c.weightx = 1;
        c.weighty = .2;

        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets =new Insets(0,0,0,5);
        add(citizenLabel,c);
        c.gridx = 1;
        c.gridy = 3;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets =new Insets(0,0,0,0);
        add(citizenCheck,c);

        /////////////////fourth row /////////////////////////////
        c.weightx = 1;
        c.weighty = .2;

        c.gridx = 0;
        c.gridy = 4;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets =new Insets(0,0,0,5);
        add(ssnLabel,c);
        c.gridx = 1;
        c.gridy = 4;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets =new Insets(0,0,0,0);
        add(ssnField,c);

        /////////////////fifth row /////////////////////////////
        c.weightx = 1;
        c.weighty = 2.0;

        c.gridx = 1;
        c.gridy = 5;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        add(enterButton,c);
        c.gridx = 2;
        c.gridy = 5;
        add(clearButton,c);

        clearButton.addActionListener(this);
        enterButton.addActionListener(this);
    }

    public void setStringListiner(StringListiner listiner){
        this.stringListiner = listiner;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();

        if (button.getText() == "Submit"){
            if(nameField.getText().isEmpty() || occupation.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter value in each field","Warning",2);
            } else {
                String text = "Name: "+ nameField.getText()+
                              "\nOccupation: "+ occupation.getText()+
                              "\nDegree: "+empBox.getModel().getSelectedItem()+
                              "\nSSN: "+ssnField.getText();
                stringListiner.textEmitted(text);
            }
        }else if (button.getText() == "Clear"){
            nameField.setText("");
            occupation.setText("");
            ssnField.setText("");
        }

    }
}
