import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * Thic class creates the window that counts down if the user succesfully logged in
 * @author Andrew
 *
 */
public class Welcome extends JPanel {
   private static final String INTRO = "intro";
   //private static final String USED_BEFORE = "used before";
   private CardLayout cardLayout = new CardLayout();
   private JLabel countDownLabel = new JLabel("", SwingConstants.CENTER);
   public static JFrame frame = new JFrame("Logged in Successfully" );
   /**
    * Creates the GUI components for this class
    */
   public Welcome() {
      JPanel introSouthPanel = new JPanel();
      introSouthPanel.add(new JLabel("Logging off in:"));
      introSouthPanel.add(countDownLabel);

      JPanel introPanel = new JPanel();
      introPanel.setPreferredSize(new Dimension(400, 300));
      introPanel.setLayout(new BorderLayout());
      introPanel.add(new JLabel("You have succesfully logged in. Welcome " + GUI.Field.getText(), SwingConstants.CENTER), BorderLayout.CENTER);
      introPanel.add(introSouthPanel, BorderLayout.SOUTH);

      JPanel usedBeforePanel = new JPanel(new BorderLayout());
      usedBeforePanel.setBackground(Color.pink);
      usedBeforePanel.add(new JLabel("Used Before", SwingConstants.CENTER));

      setLayout(cardLayout);
      add(introPanel, INTRO);
      //add(usedBeforePanel, USED_BEFORE);

      new HurdlerTimer(this).start();
   }
   /**
    * Creates and shows the UI that the user sees if the user manages to log in
    */
   private static void createAndShowUI() 
   {
      frame.getContentPane().add(new Welcome());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }
   /**
    * Makes a new runnable instance
    */
   public static void Counter() 
   {
      java.awt.EventQueue.invokeLater(new Runnable()
      {
         public void run() 
         {
            createAndShowUI();
            
         }
      });
   }
   /**
    * sets text in countdown label
    * @param text String that contains text to be put in countdownlabel
    */
   public void setCountDownLabelText(String text) {
      countDownLabel.setText(text);
   }
   /**
    * Shows the next panel
    */
   public void showNextPanel() {
      cardLayout.next(this);
   }
}

class HurdlerTimer {
   private static final int TIMER_PERIOD = 1000; //in milliseconds
   protected static final int MAX_COUNT = 7; //max number of seconds to count down from
   private Welcome welcome; // holds a reference to the Welcome class
   private int count;

   public HurdlerTimer(Welcome welcome) {
      this.welcome = welcome; // initializes the reference to the Welcome class.
      String text = "(" + (MAX_COUNT - count) + ") seconds left";
      welcome.setCountDownLabelText(text);
		/*if (count == 0)
		{
			System.exit(0);
		}*/
   }

   public void start() {
      new Timer(TIMER_PERIOD, new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (count < MAX_COUNT) {
            	GUI.Frame.setVisible(false);
               count++;
               String text = "(" + (MAX_COUNT - count) + ") seconds left";
               welcome.setCountDownLabelText(text); // uses the reference to Welcome
            } else {
               ((Timer) e.getSource()).stop();
               welcome.frame.dispose();
               GUI.Frame.setVisible(true);
            }
            
         }
      }).start();
   }

}