import javax.swing.*;
import java.awt.*;     // this package used for event handling
import java.awt.event.*;

/* Dont write this comment its for your understanding
   we write "impements ActionListener" interface in the class Button_Mltplr to use and override
   Action Listener method  named "  public void actionPerformed(ActionEvent Actn) " */


class Button_Mltplr implements ActionListener  

{  

   JTextField tx3 = new JTextField();    //  create 3rd text field  for "1st number input" 
   JTextField tx4 = new JTextField();    //  create 4th text field  for "2nd number input"
   JLabel lb5 = new JLabel("OUTPUT: ");  // create label for showing  output 

   public Button_Mltplr()
    {
      JFrame jfrm = new JFrame("This is simple Jframe For Calculaiton");
      
      jfrm.setSize(600,500) ;   //400 width and 500 height 
             
      jfrm.setLocationRelativeTo(null);
      jfrm.getContentPane().setLayout(null); 

      /* create labels and text fields for each name, age, 1st number
         and second number accordingly*/ 
      
       JLabel lb1 = new JLabel("Enter Name:");   // create 1st label for "Enter Name:" 
       lb1.setBounds(30, 12, 150, 10); 
       jfrm.add(lb1);            


       JTextField tx1 = new JTextField();        //  create 1st text field  for "Name:" 
       tx1.setBounds(100, 10, 150, 20);
       jfrm.add(tx1); 
        
       JLabel lb2 = new JLabel("Enter Age:");   // create 2nd label for "Enter Age:" 
       lb2.setBounds(300, 12, 150, 10); 
       jfrm.add(lb2);     

       JTextField tx2 = new JTextField();    //  create 2nd text field  for "Age" 
       tx2.setBounds(370, 10, 150, 20);
       jfrm.add(tx2); 
      
      
   
        
       JLabel lb3 = new JLabel("Enter 1stno:");   // create 3rd label for "Ist number" 
       lb3.setBounds(30, 60, 150, 10); 
       jfrm.add(lb3);     
   
       
       tx3.setBounds(100, 55, 150, 20);    // create dimensions specifications for text 3 or 1st number input
       jfrm.add(tx3);                      // and add to  jframe 


       JLabel lb4 = new JLabel("Enter 2nd no:");   // create 4th label for "2nd number" 
       lb4.setBounds(300,60,80,10); 
       jfrm.add(lb4);     
   
   
       tx4.setBounds(380, 55, 150, 20);   // create dimensions specifications for text 4 or2nd number input
       jfrm.add(tx4); 

       JButton Btn = new JButton("Multiply"); // create button 
       Btn.setBounds (200,300,100,30);
       jfrm.add(Btn);                     
       
       Btn.addActionListener(this);        // register the button click as event trigger 
              
       
      // JLabel lb5=new JLabel("OUTPUT: ");
       lb5.setBounds(30, 350, 200, 20);
       jfrm.add(lb5);

       jfrm.setVisible(true) ; //making the frame visible  
       

      }

     public void actionPerformed(ActionEvent e)  // perform multiplicaiton as the event triggers
      
          {
                    String  num1 = tx3.getText().toString();
                    
                    String num2 = tx4.getText().toString();
              
                    int Frst,Scnd,Prdct;
                     
                    Frst = Integer.parseInt(num1);
                     
                    Scnd = Integer.parseInt(num2);
                    
                    Prdct =  Frst* Scnd;
            
                   lb5.setText("OUTPUT: "+Prdct);      // show the output in the label 5 "OUTPUT"   
           }         
     

    public static void main(String args[])

             {
                 
                new Button_Mltplr();
               

              }



    

}