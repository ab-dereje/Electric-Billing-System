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



public class AdminLog {
    void showAdminLOg(){

        String AdminText = "Files/Admin.txt";

        JFrame frame = new JFrame("Login page");
       
        //frame.setIconImage();
        JLabel adminLabel = new JLabel("Admin");
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
        
        adminLabel.setBounds(150,50,150,50);
        adminLabel.setFont(new Font("Elephant",Font.BOLD, 25));
        adminLabel.setForeground(Color.WHITE);

        labelUserName.setBounds(50,110,150,20);
        labelUserName.setFont(new Font("Alice", Font.BOLD, 16));
        usernameTextField.setBounds(150,110,150,20);
        labelUserName.setForeground(Color.WHITE);

        
        
        labelPass.setBounds(50,160,150,20);
        labelPass.setFont(new Font("Elephant", Font.BOLD, 16));
        labelPass.setForeground(Color.WHITE);
        passwordTextField.setBounds(150,160,150,20);


        //setBounds
        loginButton.setBounds(130,210,120,20);
        backButton.setBounds(650,360,120,20);
        exitButton.setBounds(650,400,120,20);
        

        //Coloring buttons
        loginButton.setBackground(Color.CYAN);
        loginButton.setOpaque(true);

        backButton.setBackground(Color.BLACK);
        backButton.setOpaque(true);
        backButton.setForeground(Color.WHITE);

        exitButton.setBackground(Color.PINK);
        exitButton.setOpaque(true);

        //actionListner

        loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                
                try {

                    String username = usernameTextField.getText();
                    String password = String.valueOf(passwordTextField.getPassword());

                    

                    File file = new File(AdminText);
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String _temp = null;
                        String _user;
                        String _pass;
                        Boolean check=false;
                        while ((_temp = reader.readLine()) != null) {
                            String[] AdminUserPass = _temp.split(",");
                            _user = AdminUserPass[0];
                            _pass = AdminUserPass[2];
                            if (_user.equals(username) && _pass.equals(password)) {
                                AdminPanel adminPanel = new AdminPanel();
                                adminPanel.showAdminPanel();
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
        backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                MainMenu menu = new MainMenu();
                menu.displayMainMenu();
                frame.dispose();

			}
		});

        exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                System.exit(0);

			}
		});

        //add to frame
        frame.getContentPane().add(adminLabel);
        frame.getContentPane().add(usernameTextField);
        frame.getContentPane().add(labelUserName);
        frame.getContentPane().add(labelPass);
        frame.getContentPane().add(passwordTextField);
        frame.getContentPane().add(loginButton);
        frame.getContentPane().add(exitButton);
        frame.getContentPane().add(backButton);
        //frame.getContentPane().add(adminLoginButton);
        
        frame.setSize(854,480);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
}
