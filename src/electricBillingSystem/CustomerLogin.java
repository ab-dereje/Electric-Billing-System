package electricBillingSystem;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;



public class CustomerLogin {

    void showCustomerLoginPage(){

        String CustomerText = "Files/Customer.txt";

        JFrame frame = new JFrame("Login page");
       
        //frame.setIconImage();
        JLabel welcomeLabel = new JLabel("Welcome");
        JLabel labelUserName = new JLabel("Username"); //username
        JTextField usernameTextField = new JTextField();
        JLabel labelPass = new JLabel("Password");
        JPasswordField passwordTextField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton exitButton = new JButton("Exit");
        JButton backButton = new JButton("Back");

        //add image to background
        frame.setLayout(new BorderLayout());
	    frame.setContentPane(new JLabel(new ImageIcon("images/menu.png")));
	    frame.setLayout(new FlowLayout());
        
        welcomeLabel.setBounds(150,50,150,50);
        welcomeLabel.setFont(new Font("Elephant",Font.BOLD, 25));
        welcomeLabel.setForeground(Color.WHITE);

        labelUserName.setBounds(50,110,150,20);
        labelUserName.setFont(new Font("Alice", Font.BOLD, 16));
        labelUserName.setForeground(Color.WHITE);
        usernameTextField.setBounds(150,110,150,20);

        

        labelPass.setBounds(50,160,150,20);
        labelPass.setFont(new Font("Elephant", Font.BOLD, 16));
        labelPass.setForeground(Color.WHITE);
        passwordTextField.setBounds(150,160,150,20);

        loginButton.setBounds(130,210,120,20);
        exitButton.setBounds(650,400,120,20);
        backButton.setBounds(650,360,120,20);


        //registerButton.setBorderPainted(false);

        loginButton.setBackground(Color.CYAN);
        loginButton.setOpaque(true);

        backButton.setBackground(Color.BLACK);
        backButton.setOpaque(true);
        backButton.setForeground(Color.WHITE);



        exitButton.setBackground(Color.BLACK);
        exitButton.setOpaque(true);
        exitButton.setForeground(Color.WHITE);


        //action listner
        loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //

                try {

                    String username = usernameTextField.getText();
                    String password = String.valueOf(passwordTextField.getPassword());

                    

                    File file = new File(CustomerText);
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String _temp = null;
                        String _user;
                        String _pass;
                        Boolean check=false;
                        while ((_temp = reader.readLine()) != null) {
                            String[] AdminUserPass = _temp.split(",");
                            _user = AdminUserPass[0];
                            _pass = AdminUserPass[2];
                            if (username.equals(_user) && (password.equals(_pass))){
                                CustomerMenu customermenu = new CustomerMenu();
                                customermenu.showCustomerMenu();
                                frame.dispose();
                                check=true;
                            } 
                            
   
                        }
                        if(check==false){
                            JOptionPane.showMessageDialog(null, "Incorect password!!");
                        }
                    }
                }
                catch (Exception ex) {
                    System.out.print(ex.getMessage());
                }

                
                



			}
		});

        exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                System.exit(0); //exit

			}
		});

        backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                MainMenu menu = new MainMenu();
                menu.displayMainMenu();
                frame.dispose();

			}
		});



        //add to frame
        frame.getContentPane().add(welcomeLabel);
        frame.getContentPane().add(usernameTextField);
        frame.getContentPane().add(labelUserName);
        frame.getContentPane().add(labelPass);
        frame.getContentPane().add(passwordTextField);
        frame.getContentPane().add(loginButton);
        frame.getContentPane().add(exitButton);
        frame.getContentPane().add(backButton);

        //frame.setLocationRelativeTo(null);
        frame.setSize(854,480);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);//locaion
        frame.setVisible(true);
    }
    
}
