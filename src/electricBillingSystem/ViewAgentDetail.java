package electricBillingSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.nio.file.Files;
//import java.nio.file.Path;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewAgentDetail {
    void agentTable(){
        JFrame frame = new JFrame();
        JTable table = new JTable();
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(70,110,700,250);

        

            
            JLabel viewCustomer = new JLabel("AGENT DETAIL");

            viewCustomer.setBounds(300,20,300,50);
            viewCustomer.setFont(new Font("ALGERIAN",Font.BOLD, 18));
            viewCustomer.setForeground(Color.BLACK);

            JButton importButton = new JButton("Import Agent Information");
            JButton backButton = new JButton("Back");
            JButton exitButton = new JButton("Exit");
            
            importButton.setBounds(280,70,250,30);
            backButton.setBounds(650,370,120,20);
            exitButton.setBounds(650,400,120,20);

            importButton.setBackground(Color.LIGHT_GRAY);
            importButton.setOpaque(true);

            backButton.setBackground(Color.CYAN);
            backButton.setOpaque(true);

            exitButton.setBackground(Color.BLACK);
            exitButton.setOpaque(true);
            exitButton.setForeground(Color.WHITE);


            //table.setBounds(200,90, 400,100);
            
            

            frame.setLayout(new BorderLayout());
	        frame.setContentPane(new JLabel(new ImageIcon("images/customer.png")));
	        frame.setLayout(new FlowLayout());

            String AgentText = "Files/Agent.txt";
            File file =new File(AgentText);

            importButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try{
                        
                        //Path path = Paths.get(AgentText);
                        //InputStream input = Files.newInputStream(path);
                        
                        try (
                        BufferedReader reader = new BufferedReader(new FileReader(file))) {
                            String[] columns = {"FName","LName","Password", "Address", "Branch","email", "Phone"};
                            DefaultTableModel model = (DefaultTableModel)table.getModel();
                            model.setColumnIdentifiers(columns);
         
                            Object[] tableLines =reader.lines().toArray();
         
                            for(int i=0 ;i<tableLines.length;i++){
                                String line = tableLines[i].toString();
                                String[] dataRow = line.split(",");
                                model.addRow(dataRow);
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
                    AdminPanel adminPanel = new AdminPanel();
                    adminPanel.showAdminPanel();
                    frame.dispose();          
    
                }
            });
    
    
            exitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0); //exit
                }
            });

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(viewCustomer);
            frame.add(scroll);
            frame.getContentPane().add(importButton);
            frame.getContentPane().add(backButton);
            frame.getContentPane().add(exitButton);
            
            //frame.setLocationRelativeTo(null);
            frame.setSize(854,480);
            frame.setResizable(false);
            frame.setLayout(null);
            frame.setLocationRelativeTo(null);//locaion
            //SwingUtilities.updateComponentTreeUI(frame);
            frame.setVisible(true);

    
    }
}
