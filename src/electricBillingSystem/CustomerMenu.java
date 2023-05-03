package electricBillingSystem;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.nio.file.Files;
//import java.nio.file.Path;



public class CustomerMenu {
    protected void showCustomerMenu(){
        JFrame frame = new JFrame("Login page");
       
        //frame.setIconImage();
        //JLabels

        JLabel nameLabel = new JLabel();
        
            
        JLabel consumptionLabel = new JLabel();
        JLabel totalAmountLabel = new JLabel();
        nameLabel.setBounds(80,200,300,20);
        
            
        consumptionLabel.setBounds(80,230,300,20);
        totalAmountLabel.setBounds(80, 260,300, 20);
        

        
        
        JLabel createAccountLabel = new JLabel("Customer Information");
        JTextField meterTextField = new JTextField();
        meterTextField.setBounds(260,80,150,20);
        JLabel meterLabel = new JLabel("Meter Number");
        meterLabel.setBounds(80,80,150,20);
        JButton okButton = new JButton("OK");
        
        okButton.setBounds(130, 120, 100, 20);
        okButton.setBackground(Color.CYAN);
        okButton.setOpaque(true);

           
        
        
        
        
        //JButtons
        JButton payButton = new JButton("PAY");
        JButton logoutButton = new JButton("Logout");
        JButton exitButton = new JButton("Exit");     
        
        

        //add image to background
        frame.setLayout(new BorderLayout());
	    frame.setContentPane(new JLabel(new ImageIcon("images/customer.png")));
	    frame.setLayout(new FlowLayout());

        
        
        createAccountLabel.setFont(new Font("Elephant",Font.BOLD, 25));
       
        //JLabel Set Bound
        createAccountLabel.setBounds(130,30,450,50);
        

        //JTextField setBounds
        

        
    
        //JButtons setBounds
        payButton.setBounds(130,350,150,20);
        logoutButton.setBounds(650,370,120,20);
        exitButton.setBounds(650,400,120,20);

        //button colorizing
        payButton.setBackground(Color.CYAN);
        payButton.setOpaque(true);
        //registerButton.setBorderPainted(false);

        logoutButton.setBackground(Color.CYAN);
        logoutButton.setOpaque(true);

        exitButton.setBackground(Color.BLACK);
        exitButton.setOpaque(true);
        exitButton.setForeground(Color.WHITE);


        //action listner
        

        //action listner
        

        //action listner
        okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //
                

                String CustomerText = "Files/Customer.txt";
                File file =new File(CustomerText);

                try{
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String _temp = null;
                        String _user;
      
                        String meter = meterTextField.getText();
                                    
                        while ((_temp = reader.readLine()) != null) {
                            String[] AdminUserPass = _temp.split(",");
                            _user = AdminUserPass[3];
                            
                            if (_user.equals(meter)) {
                                //JLabel fnameLabel = new JLabel();
                                nameLabel.setText("Name   "+AdminUserPass[0]+" "+AdminUserPass[1]);
                                nameLabel.setForeground(Color.WHITE);
                                consumptionLabel.setText("Consumption  "+AdminUserPass[6]);
                                consumptionLabel.setForeground(Color.WHITE);
                                totalAmountLabel.setText("Total Charge  "+AdminUserPass[7]);
                                totalAmountLabel.setForeground(Color.WHITE);

                                payButton.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        //
                                        JOptionPane.showMessageDialog(null, "PAYMENT COMPLETED SUCCESSFULLY !!");
                                        
                        
                                    }
                                });













































                                
                                
                                
                                        
                            }
                            

                           
                        }
                    }
                }
                catch (Exception ex) {
                    System.out.print(ex.getMessage());
                }
			}
		});
        

        //action listner
        

        logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                MainMenu menu = new MainMenu();
                menu.displayMainMenu();
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
        
        frame.getContentPane().add(meterLabel);
        
        
        
        //add textfields to frame
        frame.getContentPane().add(meterTextField);
        frame.getContentPane().add(nameLabel);
        frame.getContentPane().add(consumptionLabel);
        frame.getContentPane().add(totalAmountLabel);
        
        


        //add buttons to frame
        frame.getContentPane().add(okButton);
        frame.getContentPane().add(payButton);
        frame.getContentPane().add(logoutButton);
        frame.getContentPane().add(exitButton);

        
        
        frame.setSize(854,480);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);//locaion
        frame.setVisible(true);
    }
    
}
