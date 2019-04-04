/* 
 * Java Program that will allow the user to insert, remove, search, find the size, 
 * clear and find the sum of a Set. The main TextPane will display the elements as 
 * they are inserted or removed. When the user clicks the buttons for search, size,
 * clear and sum, a popup window with a message will appear and display the relevant
 * information pertaining the case. 
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.event.*;
import java.util.TreeSet;

// Public class that has to inherit from JFrame to output a GUI
public class SetApp extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JLabel label;
    private JFrame frame = new JFrame();
    private JTextPane pane = new JTextPane();;
    private JPanel mainPanel = new JPanel();
    private JTextArea textArea = new JTextArea() ;
    public TreeSet<Integer> set = new TreeSet<Integer>();
    public TreeSet<String> setConverted = new TreeSet<String>();

    // printSet() Method for Set
    public String printSet(){
        String setConverted = String.valueOf(set);
        return setConverted;
    }
    // add(number) Method for Set
    public void add(Integer number) {
        set.add(number);
    }
    // remove(number) Method for Set
    public void remove(Integer number){
        set.remove(number);
    }
    // inSet() - Popup message for number in set
    public void notInSet(String message, Integer number)
    {
        JOptionPane.showMessageDialog(null, message, number + " Not Found", JOptionPane.INFORMATION_MESSAGE);
    }
    // notInSet() - Popup message for number not in set
    public void inSet(String message, Integer number)
    {
        JOptionPane.showMessageDialog(null, message, number + " Found", JOptionPane.INFORMATION_MESSAGE);
    }
    // sizeSet() - Popup message that displays size of the Set
    public void sizeSet(Integer number, String message)
    {
        JOptionPane.showMessageDialog(null, number, message, JOptionPane.INFORMATION_MESSAGE);
    }
    // Sum() - Popup message that displays the sum of all elements in the set
    public void sum(Integer number, String message)
    {
        JOptionPane.showMessageDialog(null, number, message, JOptionPane.INFORMATION_MESSAGE);
    }
    // notNumber() - Popup message that warns that the input is not a number
    public void notNumber(String warning, String message)
    {
        JOptionPane.showMessageDialog(null, warning, message, JOptionPane.INFORMATION_MESSAGE);
    }

    // Set a new Frame for the SetApp, pane, frame, 
    // label and buttons with actionCommand and action Listener
    public SetApp(){
        super ("Set Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(750, 300));
        // ((JPanel) getContentPane()).setBorder(new EmptyBorder(12, 12, 12, 12));
        label = new JLabel("Summable Set Application");
        add(label);
        pane = new JTextPane();
        pane.setEditable(false);
        add(pane);
        pack();
        pane.setPreferredSize(new Dimension(720, 200));
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        textArea = new JTextArea("Type here");
        textArea.setPreferredSize(new Dimension(92, 20));
        textArea.setBounds(2, 2, 2, 2);
        add(textArea);
        textArea.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textArea.setText("");
            }
        });
        setLayout(new FlowLayout());
        JButton btn1 = new JButton("Insert");
        btn1.setActionCommand("Insert");
        btn1.addActionListener(this);
        add(btn1);
        JButton btn2 = new JButton("Remove");
        btn2.setActionCommand("Remove");
        btn2.addActionListener(this);
        add(btn2);
        JButton btn3 = new JButton("Search");
        btn3.setActionCommand("Search");
        btn3.addActionListener(this);
        add(btn3);
        JButton btn4 = new JButton("Size of Set");
        btn4.setActionCommand("Size");
        btn4.addActionListener(this);
        add(btn4);
        JButton btn5 = new JButton("Sum");
        btn5.setActionCommand("Sum");
        btn5.addActionListener(this);
        add(btn5);
        JButton btn6 = new JButton("Clear");
        btn6.setActionCommand("Clear");
        btn6.addActionListener(this);
        add(btn6);
        JButton btn7 = new JButton("Quit");
        btn7.setActionCommand("Quit");
        btn7.addActionListener(this);
        add(btn7);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    // ActionCommands for each of the Buttons
    public void actionPerformed(ActionEvent e){
        // First Button - Insert a Number to the Set
        if(e.getActionCommand().equals("Insert"))
        {
            try
            {
                Integer number = Integer.parseInt(textArea.getText());
                if (set.contains(number) == true)
                {
                    inSet("Number already in set", number);
                }
                set.add(number);
                pane.setText(printSet());
            }
            catch (NumberFormatException ex)
            {
                notNumber("Type a Number", "Invalid Input");
            }
        }
        // Second Button - Remove a Number from the Set
        if(e.getActionCommand().equals("Remove"))
        {
            try
            {
                Integer number = Integer.parseInt(textArea.getText());
                if (set.contains(number) == false)
                {
                    notInSet("Number not in set", number);
                }
                set.remove(number);
                this.pane.setText(printSet());
            }
            catch (NumberFormatException ex)
            {
                notNumber("Type a Number", "Invalid Input");
            }
        }
        // Third Button - Search for a Number in the Set
        if(e.getActionCommand().equals("Search"))
        {
            try 
            {
                Integer number = Integer.parseInt(textArea.getText());
                if (set.contains(number) == false) 
                {
                    notInSet("Number not in Set", number);
                }
                else 
                {
                    inSet("Number in Set", number);
                }
            }
            catch (NumberFormatException ex)
            {
                notNumber("Type a Number", "Invalid Input");
            }
        }
        // Fourth Button - Size of the Set
        if(e.getActionCommand().equals("Size"))
        {
            Integer sizeSet = set.size();
            sizeSet(sizeSet, "Elements in Set");
        }
        // Fifth Button - Sum of the Set
        if(e.getActionCommand().equals("Sum"))
        {
            Integer sum = set.stream().mapToInt(Integer::intValue).sum();
            sum(sum, "Sum of the Set");
        }
        // Sixth Button - Clear Set
        if(e.getActionCommand().equals("Clear"))
        {
            set.clear();
            this.pane.setText(printSet());
        }
        // Seventh Button - Exit the Program
        if(e.getActionCommand().equals("Quit"))
        {
            System.exit(0);
        }
    }

    // Main Function
    public static void main(String[] args) {
        new SetApp();
    }
}