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

public class CustomerTariff {
    void displayCustomerTariff() {
        JFrame frame = new JFrame("Agent Menu");
       
        //frame.setIconImage();
        JLabel mainMenuLabel = new JLabel("Select The Tariff Category");
        JButton domesticButton = new JButton("Domestic(house hold)");
        JButton lowVoltButton = new JButton("Low Voltage Industry");
        JButton highVoltButton = new JButton("High Voltage Industry");
        JButton exitButton = new JButton("Exit");
        //JButton logoutButton = new JButton("Logout");
        //Button adminLoginButton = new JButton("Admin");

        //add image to background
        frame.setLayout(new BorderLayout());
	    frame.setContentPane(new JLabel(new ImageIcon("images/agent.png")));
	    frame.setLayout(new FlowLayout());
        
        mainMenuLabel.setBounds(380,50,300,50);
        mainMenuLabel.setFont(new Font("ALGERIAN",Font.BOLD, 18));
        mainMenuLabel.setForeground(Color.WHITE);


        domesticButton.setBounds(240,110,400,50);//x,y,w,h
        lowVoltButton.setBounds(240,180,400,50);
        highVoltButton.setBounds(240,250,400,50);
        //logoutButton.setBounds(600,370,120,20);
        exitButton.setBounds(600,380,120,20);
        
        domesticButton.setBackground(Color.LIGHT_GRAY);
        domesticButton.setOpaque(true);

        lowVoltButton.setBackground(Color.GRAY);
        lowVoltButton.setOpaque(true);

        highVoltButton.setBackground(Color.LIGHT_GRAY);
        highVoltButton.setOpaque(true);

        //logoutButton.setBackground(Color.PINK);
        //logoutButton.setOpaque(true);

        exitButton.setBackground(Color.BLACK);
        exitButton.setOpaque(true);
        exitButton.setForeground(Color.WHITE);

        

        domesticButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                CalculateBill calculatebill = new CalculateBill();
                calculatebill.showCalculateBill();
                frame.dispose();
			}
		});

        lowVoltButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //
                frame.dispose();
			}
		});

        highVoltButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //
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
        frame.getContentPane().add(domesticButton);
        frame.getContentPane().add(lowVoltButton);
        //frame.getContentPane().add(logoutButton);
        frame.getContentPane().add(exitButton);
        frame.getContentPane().add(highVoltButton);
        //frame.getContentPane().add(adminLoginButton);
        
        
        frame.setSize(854,480);//480p
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
