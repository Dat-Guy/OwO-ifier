package SamurottDev;

import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OwOifier extends JPanel implements ActionListener {
	
	protected static JTextArea input;                       // Input textArea
	protected static JTextArea output;                      // Output textArea
	
	// OwOifier
	// Accepts no inputs, and gives a subclass of JPanel as its output
	// This constructor creates all components of the larger application
	public OwOifier(){
		super(new GridBagLayout());                         //Set the layout type to 'GridBag'
		
		JPanel subPanel = new JPanel();                     // Create a panel for text entry
		JLabel label = new JLabel("Text to OwO: ");    // Create a label describing the input field
		input = new JTextArea(2, 50);        // Create the input text field as a textArea
		input.setLineWrap(true);                            // Enable linewrap, to improve readability of inputted text
		JButton send = new JButton("ÒwÓ!");            // Input
		send.addActionListener(this);                    // Attach the action listener for the button
		subPanel.add(label);                                // Add the label to the input panel
		subPanel.add(input);                                // Add the input field to the input panel
		subPanel.add(send);                                 // Add the button to the input panel
		
		output = new JTextArea(20,60);       // Create the output text field
		output.setLineWrap(true);                           // Enable linewrap to improve readability
		
		GridBagConstraints c = new GridBagConstraints();    // Setup the constraints for 'GridBag' layout
		
		c.gridwidth = GridBagConstraints.HORIZONTAL;        // Constrains the element to be added on the horizontal axis
		c.weightx = 0.0;                                    // Weights the element to fall on the far left of its grid
		c.gridx = 0;                                        // Sets the grid position to x-coord 0 (left edge)
		c.gridy = 0;                                        // Sets the grid position to y-coord 0 (top edge)
		add(output, c);                                     // Adds the output textArea with the current constraints
		
		c.gridwidth = GridBagConstraints.HORIZONTAL;        // Constrains the element to be added on the horizontal axis
		c.weightx = 0.0;                                    // Weights the element to fall on the far left of its grid
		c.gridx = 0;                                        // Sets the grid position to x-coord 0 (left edge)
		c.gridy = 1;                                        // Sets the grid position to y-coord 1 (in this case, bottom edge)
		add(subPanel, c);                                   // Adds the input panel with the current constraints
	}
	
	// main
	// The standard main function (accepts a list of command-line arguments, and although gives no output, can return an exit code).
	// This is where the program begibs
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				displayGUI();
			}
		});                                                 // Passes a job to Swing, to build our application window.
	}
	
	// displayGUI
	// Accepts no inputs and gives no output
	// This takes the JPanel setup by 'OwOifier', puts it in a JFrame (window), and displays the window.
	private static void displayGUI(){
		JFrame frame = new JFrame("ÒwÓifier");         // Creates a new window with the header displaying 'ÒwÓifier'
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Sets the default behavior of closing the window to exiting the application
		frame.setSize(400, 400);              // Sets the default window size of 400px by 400px
		
		frame.add(new OwOifier());                          // Adds a new instance of the application content to the window
		
		frame.pack();                                       // Reformats the window to properly hold our content
		frame.setVisible(true);                             // Displays the window
	}
	
	// actionPreformed
	// Accepts 1 input (the ActionEvent object) and gives no output
	// This converts normal text to OwO text whenever triggered, then throws the output onto the output textArea,
	// erasing anything that may have been written there, and highlights the input textArea.
	public void actionPerformed(ActionEvent evt) {
		String text = input.getText();                      // Grabs the contents of the input textArea
		output.setText(Owoify(text));                       // Sets the contents of the output textArea to owo text
		input.selectAll();                                  // Selects all text in the input field
	}
	
	// Owoify
	// Accepts 1 input (a String), and gives 1 output (a String)
	// This does the heavy lifting of converting text to OwO text
	private static String Owoify(String toOwo){
		String OwOified = "";                               // Sets up the string to pass OwO text to
		for (var i = 0; i < toOwo.length(); i++){           //Loops through all characters
			char character = toOwo.charAt(i);               //Gets the character at the current index
			switch (character){                             //Opens a switch case with the character for all canidates to owoify
				case 'o':
					OwOified += "owo";
					break;
				case 'O':
					OwOified += "OwO";
					break;
				case 'u':
					OwOified += "uwu";
					break;
				case 'U':
					OwOified += "UwU";
					break;
				default:
					OwOified += character;
					break;
			}
		}
		return OwOified;                                    //Returns the processed string
	}
}
