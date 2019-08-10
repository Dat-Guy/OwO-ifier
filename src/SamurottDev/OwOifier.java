package SamurottDev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OwOifier extends JPanel implements ActionListener {
    
    protected static JTextArea input;
    protected static JTextArea output;

    public OwOifier(){
        super(new FlowLayout());
        
        JPanel subPanel = new JPanel();
        JLabel label = new JLabel("Text to OwO: ");
        input = new JTextArea(2, 50);
        input.setLineWrap(true);
        JButton send = new JButton("ÒwÓ!");
        send.addActionListener(this);
        subPanel.add(label); // Components Added using Flow Layout
        subPanel.add(label); // Components Added using Flow Layout
        subPanel.add(input);
        subPanel.add(send);
    
        output = new JTextArea(20,60);
        output.setLineWrap(true);
        output.setEditable(false);
    
        add(output);
        
        add(subPanel);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                displayGUI();
            }
        });
    }
    
    private static void displayGUI(){
        //Create and set up the window.
        JFrame frame = new JFrame("ÒwÓifier");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
    
        frame.add(new OwOifier());
    
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent evt) {
        String text = input.getText();
        output.append(Owoify(text) + "\n");
        input.selectAll();
        
        //Make sure the new text is visible, even if there
        //was a selection in the text area.
        output.setCaretPosition(output.getDocument().getLength());
    }
    
    private static String Owoify(String toOwo){
        String OwOified = "";
        for (var i = 0; i < toOwo.length(); i++){
            String character = toOwo.substring(i, i+1);
            if (character.contains("o")){
                character = "owo";
            }
            if (character.contains("O")){
                character = "OwO";
            }
            if (character.contains("u")){
                character = "uwu";
            }
            if (character.contains("U")){
                character = "UwU";
            }
            OwOified = OwOified + character;
        }
        return OwOified;
    }
}
