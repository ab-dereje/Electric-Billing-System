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

public class AgentMenu {
    void showAgentMenu() {
        JFrame frame = new JFrame("Agent Menu");
       
        //frame.setIconImage();
        JLabel lblAgentMenu = new JLabel("Agent Menu");
        JButton btnRegisterCustomer = new JButton("Register New Customer");
        JButton btnCustomerDetails = new JButton("View Customer Details");
        JButton btnCalculateBill = new JButton("Calculate Bill");
        JButton exitButton = new JButton("Exit");
        JButton bntLogout = new JButton("Logout");
        

        //add image to background
        frame.setLayout(new BorderLayout());
	    frame.setContentPane(new JLabel(new ImageIcon("images/agent.png")));
	    frame.setLayout(new FlowLayout());
        
        lblAgentMenu.setBounds(380,50,300,50);
        lblAgentMenu.setFont(new Font("ALGERIAN",Font.BOLD, 18));
        lblAgentMenu.setForeground(Color.WHITE);


        btnRegisterCustomer.setBounds(240,110,400,50);//x,y,w,h
        btnCustomerDetails.setBounds(240,180,400,50);
        btnCalculateBill.setBounds(240,250,400,50);
        bntLogout.setBounds(600,370,120,20);
        exitButton.setBounds(600,400,120,20);
        
        btnRegisterCustomer.setBackground(Color.LIGHT_GRAY);
        btnRegisterCustomer.setOpaque(true);

        btnCustomerDetails.setBackground(Color.GRAY);
        btnCustomerDetails.setOpaque(true);

        btnCalculateBill.setBackground(Color.LIGHT_GRAY);
        btnCalculateBill.setOpaque(true);

        bntLogout.setBackground(Color.PINK);
        bntLogout.setOpaque(true);

        exitButton.setBackground(Color.BLACK);
        exitButton.setOpaque(true);
        exitButton.setForeground(Color.WHITE);

        

        btnRegisterCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                RegisterCustomer registerCustomer = new RegisterCustomer();
                registerCustomer.showRegisterPage();
                frame.dispose();
			}
		});

        btnCustomerDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                ViewCustomerDetail customerDetail =new ViewCustomerDetail();
                customerDetail.customerTable();
                frame.dispose();
			}
		});

        btnCalculateBill.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CalculateBill calculatebill = new CalculateBill();
                calculatebill.showCalculateBill();
                frame.dispose();
            }
        });

        bntLogout.addActionListener(new ActionListener() {
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
        frame.getContentPane().add(lblAgentMenu);
        frame.getContentPane().add(btnRegisterCustomer);
        frame.getContentPane().add(btnCustomerDetails);
        frame.getContentPane().add(bntLogout);
        frame.getContentPane().add(exitButton);
        frame.getContentPane().add(btnCalculateBill);
        
        
        
        frame.setSize(854,480);//480p
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
