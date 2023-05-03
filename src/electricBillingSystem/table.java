package electricBillingSystem;
import javax.swing.*;
public class table {

    public static void main(String[] args) {

        String[] columns = {"Name", "ID", "Gender", "Department"};
        
        String[][] data = {{"Killo", "232", "Male", "SE"},
                            {"kali", "12", "Female", "CSE"}};
        JFrame f = new JFrame();
        JTable t = new JTable(data,columns);
        JScrollPane s = new JScrollPane(t);
        JLabel test = new JLabel("Test");

        test.setBounds(100,40,100,20);
        t.setBounds(50,50, 400,300);
        s.setBounds(100,300,400,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(test);
        f.add(s);
        
        f.setSize(600,600);
        f.setVisible(true);
        
    }

    
}
