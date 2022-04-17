import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

class Main extends JFrame implements ActionListener {

    JPanel basePanel = new JPanel();
    JPanel menuPanel = new JPanel();
    JPanel chatPanel = new JPanel();
    JPanel chatInputPanel = new JPanel();
    JTextArea chat = new JTextArea(20,40);
    JTextField chatInput = new JTextField(40);
    JButton connectButton = new JButton("Connect to chat");
    String userNameInput;

    public Main() {

        userNameInput = JOptionPane.showInputDialog(null, "Enter username");
        if (userNameInput == null || userNameInput.length() == 0) {
            System.exit(0);
        }

        basePanel.setLayout(new BorderLayout());
        menuPanel.setLayout(new BorderLayout());
        
        add(basePanel);
        basePanel.add(menuPanel, BorderLayout.NORTH);
        basePanel.add(chatPanel);
        basePanel.add(chatInputPanel, BorderLayout.SOUTH);
        menuPanel.add(connectButton);
        chatPanel.add(chat);
        chatInputPanel.add(chatInput);

        chat.setEditable(false);
        chatInput.addActionListener(this);
        connectButton.addActionListener(this);
        setTitle("Chat " + userNameInput);
        pack();
        setLocation(500,100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Main m = new Main();
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == connectButton) {
            //Here connect user to chat/disconnect
            //Change text for button
        }

        if(ae.getSource() == chatInput) {
            //Here we want to send message to chat.
        }
    }
}