import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ATM extends JFrame 
{

	ATM()
	{
		super("Test Frame GUI");
		buildGUI();
		pack();
		setSize(600, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void buildGUI()
	{
		
		JPanel top = new JPanel();
		top.setLayout(new BorderLayout());
		add(top, BorderLayout.NORTH);
		add(new TextArea(20,50), BorderLayout.CENTER);
		
		JPanel middle = new JPanel();
		middle.setLayout(new GridLayout(4,4));
		
		middle.add(new JButton("Withdraw"));
		middle.add(new JButton("1"));
		middle.add(new JButton("2"));
		middle.add(new JButton("3"));
		middle.add(new JButton("Deposit"));
		middle.add(new JButton("4"));
		middle.add(new JButton("5"));
		middle.add(new JButton("6"));
		middle.add(new JButton(" "));
		middle.add(new JButton("7"));
		middle.add(new JButton("8"));
		middle.add(new JButton("9"));
		middle.add(new JButton("EXIT"));
		middle.add(new JButton("0"));
		middle.add(new JButton("Clear"));
		middle.add(new JButton("Enter"));
		add(middle, BorderLayout.SOUTH);
		
	}
	
	public static void main (String[] args)
	{
		ATM auto = new ATM();
		
	}

}
