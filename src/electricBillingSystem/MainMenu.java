package electricBillingSystem;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MainMenu {
    void displayMainMenu() {
        JFrame frame = new JFrame("Login page");
       
        //frame.setIconImage();
        JLabel mainMenuLabel = new JLabel("Main Menu");
        JButton adminButton = new JButton("Admin");
        JButton agentButton = new JButton("Agent");
        JButton customerButton = new JButton("Customer");
        JButton exitButton = new JButton("Exit");
        

        //add image to background
        frame.setLayout(new BorderLayout());
	    frame.setContentPane(new JLabel(new ImageIcon("images/menu.png")));
	    frame.setLayout(new FlowLayout());
        
        mainMenuLabel.setBounds(380,50,300,50);
        mainMenuLabel.setFont(new Font("ALGERIAN",Font.BOLD, 18));
        mainMenuLabel.setForeground(Color.WHITE);


        adminButton.setBounds(240,110,400,50);//x,y,w,h
        agentButton.setBounds(240,180,400,50);
        customerButton.setBounds(240,250,400,50);
        
        exitButton.setBounds(600,380,120,20);
        
        adminButton.setBackground(Color.LIGHT_GRAY);
        adminButton.setOpaque(true);

        agentButton.setBackground(Color.GRAY);
        agentButton.setOpaque(true);

        customerButton.setBackground(Color.LIGHT_GRAY);
        customerButton.setOpaque(true);

        

        exitButton.setBackground(Color.BLACK);
        exitButton.setOpaque(true);
        exitButton.setForeground(Color.WHITE);

        

        adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                AdminLog adminlog = new AdminLog();
                adminlog.showAdminLOg();
                frame.dispose();
			}
		});

        agentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                AgentLogin agentLogin = new AgentLogin();
                agentLogin.showAgentLoginPage();
                frame.dispose();
			}
		});

        customerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CustomerLogin customerLogin = new CustomerLogin();
                customerLogin.showCustomerLoginPage();
                frame.dispose();
            }
        });
        /*
        logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //
                Login logout = new Login();
                logout.displayLoginPage();
                frame.dispose();
			}
		});
        */
        exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                System.exit(0);
			}
		});
      
        

        

        //adminLoginButton.setBounds(550,30,100,15);

        //add to frame
        frame.getContentPane().add(mainMenuLabel);
        frame.getContentPane().add(adminButton);
        frame.getContentPane().add(agentButton);
        //frame.getContentPane().add(logoutButton);
        frame.getContentPane().add(exitButton);
        frame.getContentPane().add(customerButton);
        //frame.getContentPane().add(adminLoginButton);
        
        
        frame.setSize(854,480);//480p
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
