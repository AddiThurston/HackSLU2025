package healthcareApp.gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EncryptionPanel implements ActionListener{
    JPanel mainPanel;
    JLabel usernameLabel;
    JTextField usernameField;
    JLabel passwordLabel;
    JPasswordField passwordField;
    JLabel messageLabel;
    JTextArea messageArea;
    JButton submitButton;

    public EncryptionPanel()
    {
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding between components
    
        // Create components
        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(15);
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);
        messageLabel = new JLabel("Message:");
        messageArea = new JTextArea(5, 15);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        // Add username label and field
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST; // Align labels to the right
        mainPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // Align fields to the left
        mainPanel.add(usernameField, gbc);

        // Add password label and field
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(passwordField, gbc);

        // Add message label and area
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        mainPanel.add(messageLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(new JScrollPane(messageArea), gbc);

        // Add submit button
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(submitButton, gbc);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Button pressed!!");
    }

    public JPanel getPanel() {
        return mainPanel;
    }
}
