
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils; 

public class JourneyDetails extends JFrame implements ActionListener {
    
    JLabel lblpnr ;
    JTextField pnr;
    JButton show;
    JTable table ;
    
    public JourneyDetails(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        lblpnr = new JLabel("PNR Details");
        lblpnr.setBounds(50,50,100,25);
        lblpnr.setFont(new Font("tahoma", Font.PLAIN , 16));
        add(lblpnr);
        
        pnr = new JTextField();
        pnr.setBounds(160,50,120,25);
        add(pnr);
        
        show = new JButton("Show details");
        show.setBackground(Color.white);
        show.setForeground(Color.BLACK);
        show.setBounds(290,50,120,25);
        show.addActionListener(this);
        add(show);
        
        table = new JTable();
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,800,150);
        jsp.setBackground(Color.white);
        add(jsp);
        
        
        
              
        setSize(800,500);
        setLocation(400,200);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
       try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from reservation where PNR = '"+pnr.getText()+"' ");
            if(!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null,"No Information Found");
                return;
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            
        } 
    }
    
    
    public static void main(String args[]){
        new JourneyDetails();
    }
}

