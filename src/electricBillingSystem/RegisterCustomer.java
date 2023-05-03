package electricBillingSystem;


import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.FlowLayout;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;

public class RegisterCustomer {
    protected void showRegisterPage(){
        JFrame frame = new JFrame("Login page");
       
        //frame.setIconImage();
        //JLabels
        JLabel createAccountLabel = new JLabel("Create Account");
        JLabel fnameLabel = new JLabel("First Name");
        JLabel lnameLabel = new JLabel("Last Name");
        JLabel phoneLabel = new JLabel("Email Address");
        JLabel meterLabel = new JLabel("Meter Number");
        JLabel passwordLabel = new JLabel("New Password");
        JLabel AddressLabel = new JLabel("Address");
        //JLabel phoneLabel = new JLabel("Phone");
        //JLabel AddressLabel = new JLabel("Address");
        //JLabel meterLabel = new JLabel("Meter Number");

        //JTextFields
        JTextField fnameTextfield = new JTextField("First Name");
        JTextField lnameTextField = new JTextField("Last Name");
        JTextField phoneTextfield = new JTextField("Email Address");
        JTextField meterTextField = new JTextField("");
        //JTextField meterTextField = new JTextField();
        JPasswordField PassPasswordField = new JPasswordField();
        JTextField AddressTextField = new JTextField();
        //JTextField phoneTextfield = new JTextField("+251 9");
        //JTextField AddressTextField = new JTextField("Address");
        
        
        //JButtons
        JButton registerButton = new JButton("Register");
        JButton backButton = new JButton("Back");
        JButton exitButton = new JButton("Exit");     
        
        

        //add image to background
        frame.setLayout(new BorderLayout());
	    frame.setContentPane(new JLabel(new ImageIcon("images/agent.png")));
	    frame.setLayout(new FlowLayout());

        
        
        createAccountLabel.setFont(new Font("Elephant",Font.BOLD, 25));
       
        //JLabel Set Bound
        createAccountLabel.setBounds(130,30,450,50);
        fnameLabel.setBounds(80,100,150,20);
        lnameLabel.setBounds(80,130,150,20);
        phoneLabel.setBounds(80,160,150,20);
        meterLabel.setBounds(80,190,150,20);
        passwordLabel.setBounds(80,220,150,20);
        AddressLabel.setBounds(80,250,150,20);
        

        createAccountLabel.setForeground(Color.WHITE);
        fnameLabel.setForeground(Color.WHITE);
        lnameLabel.setForeground(Color.WHITE);
        phoneLabel.setForeground(Color.WHITE);
        meterLabel.setForeground(Color.WHITE);
        passwordLabel.setForeground(Color.WHITE);
        AddressLabel.setForeground(Color.WHITE);
        //phoneLabel.setForeground(Color.WHITE);

        //JTextField setBounds
        fnameTextfield.setBounds(230,100,150,20);
        lnameTextField.setBounds(230,130,150,20);
        phoneTextfield.setBounds(230,160,150,20);
        meterTextField.setBounds(230,190,150,20);
        PassPasswordField.setBounds(230,220,150,20);
        AddressTextField.setBounds(230,250,150,20);
        
    
        //JButtons setBounds
        registerButton.setBounds(130,370,150,20);
        backButton.setBounds(650,370,120,20);
        exitButton.setBounds(650,400,120,20);

        //button colorizing
        registerButton.setBackground(Color.CYAN);
        registerButton.setOpaque(true);
        //registerButton.setBorderPainted(false);

        backButton.setBackground(Color.CYAN);
        backButton.setOpaque(true);

        exitButton.setBackground(Color.BLACK);
        exitButton.setOpaque(true);
        exitButton.setForeground(Color.WHITE);


        //action listner
        registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try{
                    String CustomerText = "Files/Customer.txt";
                    Path path = Paths.get(CustomerText);
                    OutputStream output = new BufferedOutputStream(Files.newOutputStream(path,APPEND));
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
                    writer.write(fnameTextfield.getText() +","+ lnameTextField.getText() + ","  + meterTextField.getText() + "," + String.valueOf(PassPasswordField.getPassword())+ ","+AddressTextField.getText()+phoneTextfield.getText());
                    writer.newLine();
                    writer.close();
                    output.close();
                    JOptionPane.showMessageDialog(null, "Registeration Successfully Completed !!");
                }
                catch (Exception ex) {
                    System.out.print(ex.getMessage());
                }

			}
		});

        backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //
                AgentMenu agentMenu = new AgentMenu();
                agentMenu.showAgentMenu();
                frame.dispose();           

			}
		});


        exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                System.exit(0); //exit
			}
		});







        

        //add labels to frame
        frame.getContentPane().add(createAccountLabel);
        frame.getContentPane().add(fnameLabel);
        frame.getContentPane().add(lnameLabel);
        frame.getContentPane().add(phoneLabel);
        frame.getContentPane().add(meterLabel);
        frame.getContentPane().add(passwordLabel);
        frame.getContentPane().add(AddressLabel);
        
        
        //add textfields to frame
        frame.getContentPane().add(fnameTextfield);
        frame.getContentPane().add(lnameTextField);
        frame.getContentPane().add(phoneTextfield);
        frame.getContentPane().add(meterTextField);
        frame.getContentPane().add(PassPasswordField);
        frame.getContentPane().add(AddressTextField);
        

        //add buttons to frame
        frame.getContentPane().add(registerButton);
        frame.getContentPane().add(backButton);
        frame.getContentPane().add(exitButton);

        
        
        frame.setSize(854,480);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);//locaion
        frame.setVisible(true);
    }
}
