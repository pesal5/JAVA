import javax.swing.*;
import java.awt.*;     // this package used for event handling
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;


class JDB_CMS implements ActionListener  


{
            
       
                                       /*global declaraion of these varaibles for use by action listener methods */
   
   JTextField tx1 = new JTextField();    //  create 1st text field  for "Name:" 
   JTextField tx2 = new JTextField();    //  create 2nd text field  for "Acccount Number" 
   JTextField tx3 = new JTextField();    //  create 3rd text field  for "Amount" 
   JButton Btn1 = new JButton("INSERT"); // create INSERT button 
   JButton Btn2 = new JButton("SHOW TABLE'S CURRENT FILED VALUES"); // create DELETE button 


  JDB_CMS()
    {
         JFrame jfrm = new JFrame("JFRAME for DATABASE CONNECTIVITY");
      
        jfrm.setSize(800,500) ;   // Frame of 800 width and 500 height 
             
        jfrm.setLocationRelativeTo(null);
        jfrm.getContentPane().setLayout(null); 
        jfrm.setVisible(true) ; //making the frame visible  

      /* create labels and text fields for each name, age, 1st number
         and second number accordingly*/
      
       JLabel lb1 = new JLabel("Name");   // create 1st label for "Name:" 
       lb1.setBounds(30, 12, 150, 10); 
       jfrm.add(lb1);     
   
     
        
        tx1.setBounds(100, 10, 150, 20);
        jfrm.add(tx1); 
        
       JLabel lb2 = new JLabel("Account Number");   // create 2nd label for "Acccount Number" 
       lb2.setBounds(300, 12, 150, 10); 
       jfrm.add(lb2);     

      
       tx2.setBounds(470, 10, 150, 20);
       jfrm.add(tx2); 

        
       JLabel lb3 = new JLabel("Amount");   // create 3rd label for "Amount" 
       lb3.setBounds(670, 12, 150, 10); 
       jfrm.add(lb3);     
   
         
       tx3.setBounds(770,10, 150, 20);
       jfrm.add(tx3); 

  
   
      
     //  JButton Btn1 = new JButton("INSERT"); // create INSERT button 
       Btn1.setBounds (100, 80 , 150, 20);
       jfrm.add(Btn1);                     
       
       Btn1.addActionListener(this);        // register the button click as event trigger 
         
       
     //  JButton Btn2 = new JButton("SHOW TABLE'S CURRENT FILED VALUES"); // create DELETE button 
       Btn2.setBounds (390,140,300,30);
       jfrm.add(Btn2);   
       Btn2.addActionListener(this);
      

       }


    
    public void actionPerformed(ActionEvent ae)  // button event trigger action listener and inserts data to database  "Accounts"
               
          
       {
          try
           {


              //load database driver and connect to database, in my case its MSSQL server to be connected to java program                     

              Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");                           

              Connection conn= DriverManager.getConnection("jdbc:sqlserver://(localhost);databaseName=Account_Cust; user=sa; password = xxx");

              Statement st=conn.createStatement();
            
   
              if(ae.getSource() == Btn1)

            {

              String Name = tx1.getText().toString();
              String AccountNumber = tx2.getText().toString();
              String Amount = tx3.getText().toString();
               
               try {

                             String sql="INSERT INTO Accountslist (AccountNo,Name,Amount) VALUES('"+AccountNumber+"','"+Name+"','"+Amount+"')";
                                            
                             st.executeQuery(sql);  
                           
                             JOptionPane.showMessageDialog(null, "Data Inserted Successfully");

                      }
                


                  catch(Exception e) 
                  
                  {
                       JOptionPane.showMessageDialog(null, e);
                   }
            
              }     
              /*  if(ae.source == Btn2)


                    {
                          
                              String sql1="SELECT * FROM Accountslist";
                              ResultSet RST=st.executeQuery(sql1);
                              
                              System.out.println("AccountNo\t"+"Name\t"+"Amount");

                              while(RST.next()) 

                                 {
                                        String AccountNo = RST.getString(1);
                                        String Names= RST.getString(2);
                                        String Amounts= RST.getString(3);

                                       System.out.println(AccountNo+"\t"+Name+"\t"+Amount);
                                  }


                      }  */




                       if(ae.getSource() ==  Btn2) 
                     {
                        try {

                                
                                String[] columns= {"Name","AC NUMBER","Amount"};
              

                                 JTable JTBL=new JTable();

                                  DefaultTableModel MDL = new DefaultTableModel();
                                  JTBL.setModel(MDL);
                                   MDL.setColumnIdentifiers(columns);
       
                                   String sqlqry = "SELECT * FROM Accountslist";
                                   
                               
                         
                                   ResultSet RST=st.executeQuery(sqlqry);
                         
                               
                                              while(RST.next())

                                                    {
                                                          String AccountNumber=RST.getString(1);
                                                             String Name=RST.getString(2);
                                                            String Amount=RST.getString(3);
                                                          MDL.addRow(new String[]{Name,AccountNumber,Amount});
                                                    }

                                JScrollPane SCP=new JScrollPane(JTBL);
                                SCP.setBounds(350,200,500,120);
                                jfrm.add(SCP);
                              }

                                
             
                           catch(Exception e) 
 
                             {
                                    JOptionPane.showMessageDialog(null, e);
                              }
                    
                        }
             }

            catch(Exception e) 
                  
                  {
                       JOptionPane.showMessageDialog(null, e);
                   }          
     }


                 
 public static void main(String args[])

             {
                 
                       new JDB_CMS();
               

              }

}