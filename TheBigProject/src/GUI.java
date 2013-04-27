import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


import javax.swing.*;
/**
 * This is the class that creates and manages all the GUI components as well as the actionlisteners
 * @author Andrew
 *
 */
public class GUI extends Frame
{
	public Timer timer;
	static JButton button = new JButton("Login");
	static JButton button2 = new JButton("Signup");
	static JTextField Field = new JTextField(30);
	static JPasswordField Field2 = new JPasswordField(30);
	static JPasswordField repass = new JPasswordField(30);
	static JFrame frame = new JFrame("Error");
	static JFrame Frame = new JFrame();
	JLabel label = new JLabel("Username: ");
	JLabel label2 = new JLabel("Password: ");
	static JPanel Panel = new JPanel();
	static JPanel Panel2 = new JPanel();
	public JLabel passfield = new JLabel("Re-Enter Password");
	public static JButton button3 = new JButton("Try Again");
	public JPanel buttonFrame = new JPanel();
	public JButton RegisterButton = new JButton("Register");
	public JButton TryAgain = new JButton("Try again");

	public GUI()
	{
		
		Frame.setLayout(new BorderLayout());
		Frame.setBounds(200, 200, 500, 120);
		Panel.setLayout(new GridLayout(3,0));
		Panel.add(label);
		Panel.add(label2);
		Panel2.setLayout(new GridLayout(3,0));
		Panel2.add(Field);
		Panel2.add(Field2);
		Frame.add(Panel, BorderLayout.LINE_START);
		Frame.add(Panel2, BorderLayout.LINE_END);
		Frame.add(buttonFrame, BorderLayout.SOUTH);
		buttonFrame.add(button);
		button.addActionListener(new buttonListener());
		buttonFrame.add(button2);
		button2.addActionListener(new button2Listener());
		button2.setVisible(false);
		buttonFrame.add(TryAgain);
		TryAgain.addActionListener(new TryAgainButtonListener());
		TryAgain.setVisible(false);
		buttonFrame.add(RegisterButton);
		RegisterButton.addActionListener(new RegisterButtonListener());
		RegisterButton.setVisible(false);
		//Frame.add(button2);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.setVisible(true);
	}
	
	/**
	 * This button is the Login button. It calls the method in LockAndLoad and checks if the username and password is authentic
	 * @author Andrew
	 *
	 */
	private class buttonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			try {
				LockAndLoad.Search();
				if (!LockAndLoad.Search())
				{
					GUISecondWindow();
					JOptionPane NoSuchUser = new JOptionPane();
					JOptionPane.showMessageDialog(NoSuchUser, "No such user");
				}
				else
				{
					Welcome.Counter();
					Field.setText("");
					Field2.setText("");
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	/**
	 * This calls the Registration window if the Registerbutton is clicked on
	 * @author Andrew
	 *
	 */
	private class button2Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			RegistrationWindow();
		}
	}
	
	/**
	 * This calls the Registration window if the Registerbutton is clicked on
	 */
	public void GUISecondWindow() 
	{
		button2.setVisible(true);
		button.setVisible(false);
		TryAgain.setVisible(true);
		Frame.repaint();
		Frame.revalidate();
	}
	
	/**
	 * This just goes back to the first window if this button is clicked
	 * @author Andrew
	 *
	 */
	private class TryAgainButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			//buttonFrame.remove(button2);
			//buttonFrame.remove(TryAgain);
			//buttonFrame.add(button);
			button2.setVisible(false);
			TryAgain.setVisible(false);
			button.setVisible(true);
			Field.setText("");
			Field2.setText("");
			Frame.repaint();
			Frame.revalidate();
		}
	}
	/**
	 * Registration window
	 */
	public void RegistrationWindow()
	{
		Panel.add(passfield);
		Panel2.add(repass);
		//buttonFrame.remove(button);
		//buttonFrame.remove(button2);
		//buttonFrame.remove(TryAgain);
		button.setVisible(false);
		button2.setVisible(false);
		TryAgain.setVisible(false);
		RegisterButton.setVisible(true);
		Frame.repaint();
		Frame.revalidate();
	}
	/**
	 * Calls various methods in order to save the username and password and shows a window if it cannot
	 * @author Andrew
	 *
	 */
	private class RegisterButtonListener implements ActionListener
	{
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
		{
			
			if (Field2.getText().equals(repass.getText()))
			{
				
				try 
				{
					String p = Field2.getText(); 
					String ss =Arrays.toString(FileHero.makeSalt());
					for (int i = 0; i < 10000; i++)
					{
						p = Encryption.Sha(p+ss);
					}
					int count = 0;
					for (int i = 0; i < User.r.size(); i++)
					{
						if (Field.getText().equals(User.r.get(i).getName()))
						{
							count++;
						}
					}
					if (count > 1)
					{
						JOptionPane DuplicateUser = new JOptionPane();
						JOptionPane.showMessageDialog(DuplicateUser, "That username already exists.");
					}
					else
					{
						
						User.addUser(Field.getText(), p) ;
						FileHero.addSalt(Field.getText(), ss);
						JOptionPane Alert = new JOptionPane();
						JOptionPane.showMessageDialog(Alert, "Account Created successfully");
						passfield.setVisible(false);
						repass.setVisible(false);
						RegisterButton.setVisible(false);
						button.setVisible(true);
						Field.setText("");
						Field2.setText("");
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			else if (!Field2.getText().equals(repass.getText()))
			{
				JOptionPane Alert2 = new JOptionPane("");
				JOptionPane.showMessageDialog(Alert2, "passwords do not match");
			}
		}
	}
	
}