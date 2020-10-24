import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    //all components variables added to the GUI should be set as private
    private TextPanel jTextArea;
    private ToolBar toolBar;
    private FormPanel formPanel;

    public MainFrame(){
        super("Employment GUI");
        setLayout(new BorderLayout());

        setJMenuBar(createMenuBar());

        jTextArea = new TextPanel();
        toolBar = new ToolBar();
        formPanel = new FormPanel();

        add(toolBar, BorderLayout.NORTH);
        add(jTextArea, BorderLayout.CENTER);
        add(formPanel, BorderLayout.WEST);

        setSize(700,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        toolBar.setStringListener(new StringListiner() {
            @Override
            public void textEmitted(String text) {
               if (text == "Clear Screen"){
                    jTextArea.cleatTextArea();
                }
            }
        });

        formPanel.setStringListener(new StringListiner() {
            @Override
            public void textEmitted(String text) {
                jTextArea.appendText(text+"\n");
            }
        });

        //This is a the lambda method way
        // that conduct the same function as the method above.
       /* jButton.addActionListener(e -> {
            String text = jButton.getText();
            jTextArea.append(text+"\n");
        });*/
    }

    private JMenuBar createMenuBar(){

        JMenuBar jMenuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu newMenu = new JMenu("New");
        JMenuItem close = new JMenuItem("Close");

        JMenuItem project = new JMenuItem("Project");
        JMenuItem module = new JMenuItem("Module");

        newMenu.add(project);
        newMenu.add(module);
        file.add(newMenu);
        file.add(close);
        jMenuBar.add(file);
        jMenuBar.add(edit);
        return jMenuBar;
    }


}
