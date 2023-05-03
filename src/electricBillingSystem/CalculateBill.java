package electricBillingSystem;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;
//import java.text.DecimalFormat;


public class CalculateBill {
    protected void showCalculateBill(){
        JFrame frame = new JFrame("Login page");
       
        //frame.setIconImage();
        //JLabels
        JLabel createAccountLabel = new JLabel("Customer Information");
        JLabel fnameLabel = new JLabel("First Name");
        JLabel lnameLabel = new JLabel("Last Name");
        JLabel meterLabel = new JLabel("Meter Number");
        JLabel consumptionLabel = new JLabel("Consumption");
        JLabel tariffcategory = new JLabel("Select tariff category ?");
        

        //JTextFields
        JTextField fnameTextfield = new JTextField("");
        JTextField lnameTextField = new JTextField("");
        JTextField meterTextfield = new JTextField("");
        JTextField consumptionTextField = new JTextField("");
        
        
        
        //JButtons
        JButton domesticButton = new JButton("Domestic");
        JButton lowVoltButton = new JButton("Low Voltage");
        JButton highVoltButton = new JButton("High Voltage");
        JButton okButton = new JButton("OK");
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
        meterLabel.setBounds(80,160,150,20);
        consumptionLabel.setBounds(80,190,150,20);
        tariffcategory.setBounds(80, 250, 400, 30);

        createAccountLabel.setForeground(Color.WHITE);
        fnameLabel.setForeground(Color.WHITE);
        lnameLabel.setForeground(Color.WHITE);
        meterLabel.setForeground(Color.WHITE);
        consumptionLabel.setForeground(Color.WHITE);
        tariffcategory.setForeground(Color.WHITE);
        

        //JTextField setBounds
        fnameTextfield.setBounds(230,100,150,20);
        lnameTextField.setBounds(230,130,150,20);
        meterTextfield.setBounds(230,160,150,20);
        consumptionTextField.setBounds(230,190,150,20);

        tariffcategory.setFont(new Font("Elephant",Font.BOLD, 20));
        tariffcategory.setForeground(Color.WHITE);
    
        //JButtons setBounds
        domesticButton.setBounds(130,300,150,20);
        lowVoltButton.setBounds(290, 300, 150, 20);
        highVoltButton.setBounds(450, 300, 150, 20);
        okButton.setBounds(130,350,150,20);
        backButton.setBounds(650,370,120,20);
        exitButton.setBounds(650,400,120,20);

        //button colorizing
        domesticButton.setBackground(Color.CYAN);
        domesticButton.setOpaque(true);
        lowVoltButton.setBackground(Color.CYAN);
        lowVoltButton.setOpaque(true);
        highVoltButton.setBackground(Color.CYAN);
        highVoltButton.setOpaque(true);
        okButton.setBackground(Color.CYAN);
        okButton.setOpaque(true);
        //registerButton.setBorderPainted(false);

        backButton.setBackground(Color.CYAN);
        backButton.setOpaque(true);

        exitButton.setBackground(Color.BLACK);
        exitButton.setOpaque(true);
        exitButton.setForeground(Color.WHITE);


        //action listner
        domesticButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //
                String CustomerText = "Files/Customer.txt";
                String consump = consumptionTextField.getText();
                Integer consumption = Integer.parseInt(consump);
                String fname = fnameTextfield.getText();
                String meter = meterTextfield.getText(); 
                double serviceCharge = 22.56;
                double totalcoast;
                if (consumption == 0) {
                    try{
                        totalcoast = (0.6723 + serviceCharge);
                        Path path = Paths.get(CustomerText);
                        InputStream input = Files.newInputStream(path);
                        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                        OutputStream output = new BufferedOutputStream(Files.newOutputStream(path,APPEND));
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
                        String _temp = null;
                        String _user;
                        String _pass;
                        
                        while ((_temp = reader.readLine()) != null) {
                            String[] AdminUserPass = _temp.split(",");
                            _user = AdminUserPass[0];
                            _pass = AdminUserPass[3];
                            if (_user.equals(fname) || _pass.equals(meter)) {
                                writer.write(","+consump+" kw"+","+totalcoast);
                                writer.newLine();
                                writer.close();
                                output.close();
                            }
               
                        }
                    }
                    catch (Exception ex) {
                        System.out.print(ex.getMessage());
                    }
                    
                } else if (consumption > 0 && consumption <= 50) {
                    try{
                        totalcoast = (0.2730 * consumption) + 1.4;
                        Path path = Paths.get(CustomerText);
                        InputStream input = Files.newInputStream(path);
                        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                        OutputStream output = new BufferedOutputStream(Files.newOutputStream(path,APPEND));
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
                        String _temp = null;
                        String _user;
                        String _pass;
                        
                        while ((_temp = reader.readLine()) != null) {
                            String[] AdminUserPass = _temp.split(",");
                            _user = AdminUserPass[0];
                            _pass = AdminUserPass[3];
                            if (_user.equals(fname) || _pass.equals(meter)) {
                                writer.write(","+consump+" kw"+","+totalcoast);
                                writer.newLine();
                                writer.close();
                                output.close();
                            }
               
                        }
                    }
                    catch (Exception ex) {
                        System.out.print(ex.getMessage());
                    }
                    
                } else if (consumption >= 51 && consumption <= 100) {
                    try{
                        totalcoast = (0.3564 * consumption) + 6.8200;
                        Path path = Paths.get(CustomerText);
                        InputStream input = Files.newInputStream(path);
                        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                        OutputStream output = new BufferedOutputStream(Files.newOutputStream(path,APPEND));
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
                        String _temp = null;
                        String _user;
                        String _pass;
                        
                        while ((_temp = reader.readLine()) != null) {
                            String[] AdminUserPass = _temp.split(",");
                            _user = AdminUserPass[0];
                            _pass = AdminUserPass[3];
                            if (_user.equals(fname) || _pass.equals(meter)) {
                                writer.write(","+consump+" kw"+","+totalcoast);
                                writer.newLine();
                                writer.close();
                                output.close();
                            }
               
                       }
                    }
                    catch (Exception ex) {
                        System.out.print(ex.getMessage());
                    }
                } else if (consumption >= 101 && consumption <= 200) {
                    try{
                        totalcoast = (0.4993 * consumption) + 10.2400;
                        Path path = Paths.get(CustomerText);
                        InputStream input = Files.newInputStream(path);
                        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                        OutputStream output = new BufferedOutputStream(Files.newOutputStream(path,APPEND));
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
                        String _temp = null;
                        String _user;
                        String _pass;
                        
                        while ((_temp = reader.readLine()) != null) {
                            String[] AdminUserPass = _temp.split(",");
                            _user = AdminUserPass[0];
                            _pass = AdminUserPass[3];
                            if (_user.equals(fname) || _pass.equals(meter)) {
                                writer.write(","+consump+" kw"+","+totalcoast);
                                writer.newLine();
                                writer.close();
                                output.close();
                            }
               
                        }
                    }
                    catch (Exception ex) {
                        System.out.print(ex.getMessage()); 
                    }   
                } else if (consumption >= 201 && consumption <= 300) {
                    totalcoast = (0.5500 * consumption) + 10.2400;
                    Path path = Paths.get(CustomerText);
                    try {
                        InputStream input = Files.newInputStream(path); 
                        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                        OutputStream output = new BufferedOutputStream(Files.newOutputStream(path,APPEND));
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
                        String _temp = null;
                        String _user;
                        String _pass;
                        
                        while ((_temp = reader.readLine()) != null) {
                            String[] AdminUserPass = _temp.split(",");
                            _user = AdminUserPass[0];
                            _pass = AdminUserPass[3];
                            if (_user.equals(fname) || _pass.equals(meter)) {
                                writer.write(","+consump+" kw"+","+totalcoast);
                                writer.newLine();
                                writer.close();
                                output.close();
                            }
            
                        }
                    } 
                    catch (Exception ex) {
                        System.out.print(ex.getMessage());
                    }
                } else if (consumption >= 301 && consumption <= 500) {
                    try{
                        totalcoast = (0.5880 * consumption) + 13.65;
                        Path path = Paths.get(CustomerText);
                        InputStream input = Files.newInputStream(path);
                        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                        OutputStream output = new BufferedOutputStream(Files.newOutputStream(path,APPEND));
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
                        String _temp = null;
                        String _user;
                        String _pass;
                        while ((_temp = reader.readLine()) != null) {
                            String[] AdminUserPass = _temp.split(",");
                            _user = AdminUserPass[0];
                            _pass = AdminUserPass[3];
                            if (_user.equals(fname) || _pass.equals(meter)) {
                                writer.write(","+consump+" kw"+","+totalcoast);
                                writer.newLine();
                                writer.close();
                                output.close();
                            }
               
                        }
                    }
                    catch (Exception ex) {
                        System.out.print(ex.getMessage());
                    }
                } else {
                    try{
                        totalcoast = (0.6943 * consumption) + serviceCharge;
                        Path path = Paths.get(CustomerText);
                        InputStream input = Files.newInputStream(path);
                        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                        OutputStream output = new BufferedOutputStream(Files.newOutputStream(path,APPEND));
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
                       String _temp = null;
                        String _user;
                        String _pass;
                        while ((_temp = reader.readLine()) != null) {
                            String[] AdminUserPass = _temp.split(",");
                            _user = AdminUserPass[0];
                            _pass = AdminUserPass[3];
                            if (_user.equals(fname) || _pass.equals(meter)) {
                                writer.write(","+consump+" kw"+","+totalcoast);
                                writer.newLine();
                                writer.close();
                                output.close();
                            }
               
                        }
                    }
                    catch (Exception ex) {
                        System.out.print(ex.getMessage());
                    }
                
                
            }
        }

			
		});

        //action listner
        lowVoltButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //
                String CustomerText = "Files/Customer.txt";
                String consump = consumptionTextField.getText();
                Integer consumption = Integer.parseInt(consump);
                String fname = fnameTextfield.getText();
                String meter = meterTextfield.getText(); 
                double serviceChargeLI = 53.570;
                double totalcoast;
                if (consumption == 0) {
                    try{
                        totalcoast = (0.5778 + serviceChargeLI);
                        Path path = Paths.get(CustomerText);
                        InputStream input = Files.newInputStream(path);
                        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                        OutputStream output = new BufferedOutputStream(Files.newOutputStream(path,APPEND));
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
                        String _temp = null;
                        String _user;
                        String _pass;
                        
                        while ((_temp = reader.readLine()) != null) {
                            String[] AdminUserPass = _temp.split(",");
                            _user = AdminUserPass[0];
                            _pass = AdminUserPass[3];
                            if (_user.equals(fname) || _pass.equals(meter)) {
                                writer.write(","+consump+" kw"+","+totalcoast);
                                writer.newLine();
                                writer.close();
                                output.close();
                            }
               
                        }
                    }
                    catch (Exception ex) {
                        System.out.print(ex.getMessage());
                    }
                }
                else {
                    try{
                        totalcoast = (0.7426 * consumption) + serviceChargeLI;
                        Path path = Paths.get(CustomerText);
                        InputStream input = Files.newInputStream(path);
                        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                        OutputStream output = new BufferedOutputStream(Files.newOutputStream(path,APPEND));
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
                       String _temp = null;
                        String _user;
                        String _pass;
                        while ((_temp = reader.readLine()) != null) {
                            String[] AdminUserPass = _temp.split(",");
                            _user = AdminUserPass[0];
                            _pass = AdminUserPass[3];
                            if (_user.equals(fname) || _pass.equals(meter)) {
                                writer.write(","+consump+" kw"+","+totalcoast);
                                writer.newLine();
                                writer.close();
                                output.close();
                            }
               
                        }
                    }
                    catch (Exception ex) {
                        System.out.print(ex.getMessage());
                    }
                
                
                }

			}
		});

        //action listner
        highVoltButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //
                String CustomerText = "Files/Customer.txt";
                String consump = consumptionTextField.getText();
                Integer consumption = Integer.parseInt(consump);
                String fname = fnameTextfield.getText();
                String meter = meterTextfield.getText(); 
                double serviceChargeHI = 54.010;
                double totalcoast;
                if (consumption == 0) {
                    try{
                        totalcoast = (0.4086 + serviceChargeHI);
                        Path path = Paths.get(CustomerText);
                        InputStream input = Files.newInputStream(path);
                        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                        OutputStream output = new BufferedOutputStream(Files.newOutputStream(path,APPEND));
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
                        String _temp = null;
                        String _user;
                        String _pass;
                        
                        while ((_temp = reader.readLine()) != null) {
                            String[] AdminUserPass = _temp.split(",");
                            _user = AdminUserPass[0];
                            _pass = AdminUserPass[3];
                            if (_user.equals(fname) || _pass.equals(meter)) {
                                writer.write(","+consump+" kw"+","+totalcoast);
                                writer.newLine();
                                writer.close();
                                output.close();
                            }
               
                        }
                    }
                    catch (Exception ex) {
                        System.out.print(ex.getMessage());
                    }
                }
                else {
                    try{
                        totalcoast = (0.5085 * consumption) + serviceChargeHI;
                        Path path = Paths.get(CustomerText);
                        InputStream input = Files.newInputStream(path);
                        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                        OutputStream output = new BufferedOutputStream(Files.newOutputStream(path,APPEND));
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
                       String _temp = null;
                        String _user;
                        String _pass;
                        while ((_temp = reader.readLine()) != null) {
                            String[] AdminUserPass = _temp.split(",");
                            _user = AdminUserPass[0];
                            _pass = AdminUserPass[3];
                            if (_user.equals(fname) || _pass.equals(meter)) {
                                writer.write(","+consump+" kw"+","+totalcoast);
                                writer.newLine();
                                writer.close();
                                output.close();
                            }
               
                        }
                    }
                    catch (Exception ex) {
                        System.out.print(ex.getMessage());
                    }
                
                
                }

			}
		});

        //action listner
        okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //

			}
		});

        backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
        frame.getContentPane().add(meterLabel);
        frame.getContentPane().add(consumptionLabel);
        frame.getContentPane().add(tariffcategory);
        
        
        //add textfields to frame
        frame.getContentPane().add(fnameTextfield);
        frame.getContentPane().add(lnameTextField);
        frame.getContentPane().add(meterTextfield);
        frame.getContentPane().add(consumptionTextField);
        


        //add buttons to frame
        frame.getContentPane().add(domesticButton);
        frame.getContentPane().add(lowVoltButton);
        frame.getContentPane().add(highVoltButton);
        frame.getContentPane().add(okButton);
        frame.getContentPane().add(backButton);
        frame.getContentPane().add(exitButton);

        
        
        frame.setSize(854,480);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);//locaion
        frame.setVisible(true);
    }
    
}
