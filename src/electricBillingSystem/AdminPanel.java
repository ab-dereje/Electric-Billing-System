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

public class AdminPanel {
    void showAdminPanel(){
    JFrame frame = new JFrame("Admin Panel");
       
        //frame.setIconImage();
        JLabel mainMenuLabel = new JLabel("Admin Panel");
        JButton btnRegisterAgent = new JButton("Register New Agent");
        JButton btnViewAgents = new JButton("Agent Details");
        
        JButton exitButton = new JButton("Exit");
        JButton logoutButton = new JButton("Logout");
        

        //add image to background
        frame.setLayout(new BorderLayout());
	    frame.setContentPane(new JLabel(new ImageIcon("images/AdminPanel.png")));
	    frame.setLayout(new FlowLayout());
        
        mainMenuLabel.setBounds(380,50,300,50);
        mainMenuLabel.setFont(new Font("ALGERIAN",Font.BOLD, 18));
        mainMenuLabel.setForeground(Color.WHITE);

        
        btnRegisterAgent.setBounds(240,110,400,50);//x,y,w,h
        btnViewAgents.setBounds(240,180,400,50);

        logoutButton.setBounds(600,350,120,20);
        exitButton.setBounds(600,380,120,20);
        
        btnRegisterAgent.setBackground(Color.LIGHT_GRAY);
        btnRegisterAgent.setOpaque(true);

        logoutButton.setBackground(Color.CYAN);
        logoutButton.setOpaque(true);

        btnViewAgents.setBackground(Color.GRAY);
        btnViewAgents.setOpaque(true);

        

        exitButton.setBackground(Color.BLACK);
        exitButton.setOpaque(true);
        exitButton.setForeground(Color.WHITE);

        

        btnRegisterAgent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                RegisterAgent registerAgent = new RegisterAgent();
                registerAgent.showRegisterPage();
                frame.dispose();
			}
		});

        btnViewAgents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //
                //
                ViewAgentDetail viewAgent = new ViewAgentDetail();
                viewAgent.agentTable();
                frame.dispose();
			}
		});

        logoutButton.addActionListener(new ActionListener() {
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
      
        

        

        //adminLoginButton.setBounds(550,30,100,15);

        //add to frame
        frame.getContentPane().add(mainMenuLabel);
        frame.getContentPane().add(btnRegisterAgent);
        frame.getContentPane().add(btnViewAgents);
        frame.getContentPane().add(logoutButton);
        frame.getContentPane().add(exitButton);
        //frame.getContentPane().add(adminLoginButton);
        
        
        frame.setSize(854,480);//480p
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
