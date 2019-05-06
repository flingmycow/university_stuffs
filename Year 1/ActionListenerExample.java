import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionListenerExample extends JFrame
{
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JTextField textField;

    public ActionListenerExample()
    {
        MyButtonListener listener = new MyButtonListener();

        button1 = new JButton("One");
        button1.setActionCommand("Hi From Button 1");
        button1.addActionListener(listener);
        getContentPane().add(button1, BorderLayout.WEST);

        button2 = new JButton("Two");
        button2.setActionCommand("Hi From Button 2");
        button2.addActionListener(listener);
        getContentPane().add(button2, BorderLayout.CENTER);
        
        button3 = new JButton("Three");
        button3.setActionCommand("Hi From Button 3");
        button3.addActionListener(listener);
        getContentPane().add(button3, BorderLayout.EAST);         
        
        textField = new JTextField(50);
        textField.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    String text = ((JTextField)e.getSource()).getText();
                    button1.setText(text);
                    button2.setText(text);
                    button3.setText(text);
                }
            });
        getContentPane().add(textField, BorderLayout.NORTH);
    }

    public class MyButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String actionCommand = e.getActionCommand();
            textField.setText(actionCommand);
        }
    }

    public static void main(String[] args)
    {
        ActionListenerExample frame = new ActionListenerExample();
        frame.pack();
        frame.setVisible(true);
        frame.setSize(300,200);
    }
}
