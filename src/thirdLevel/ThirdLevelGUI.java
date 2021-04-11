
package thirdLevel;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import DataBaseConnection.DataBase;
import registrationForm.InfoAndPass;



public class ThirdLevelGUI extends javax.swing.JFrame {

	// Variables declaration
	private javax.swing.JButton btn_1;
	private javax.swing.JButton btn_2;
	private javax.swing.JButton btn_3;
	private javax.swing.JButton btn_4;
	private javax.swing.JButton btn_5;
	private javax.swing.JButton btn_6;
	private javax.swing.JButton btn_7;
	private javax.swing.JButton btn_8;
	private javax.swing.JButton btn_9;
	
	private javax.swing.JLabel title_lbl1;
	private javax.swing.JButton clear_btn;
	private javax.swing.JButton proceed_btn;
	private javax.swing.JLabel bg_lbl;
	private javax.swing.JPanel panel;
	private javax.swing.JLabel email_btn;
	private javax.swing.JButton instructions;

	private int[] numbers = new int[9];
	
	ArrayList<Integer> pwList = new ArrayList<>();
	//
	public ThirdLevelGUI() {
		randomNums();
		initComponents();
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2,size.height/2 - getHeight()/2);
	}
	
	

	private void randomNums()
	{
		
		Random rand = new Random();
		
		for(int i = 0; i < numbers.length; i++)
		{
			int randInt = rand.nextInt(9 - 1 + 1) + 1;
			
			//if the number is in the array then do nothing
			if(contains(numbers, randInt))
			{
				i--;

			}
			//if the number is not in the array add it
			else if(!contains(numbers, randInt))
			{
				numbers[i] = randInt;
	            //System.out.println(numbers[i]);

			}
		}
	}
	
	private boolean contains (int[] array, int v)
	{
		boolean result = false;

        for(int i : array){
            if(i == v){
                result = true;
                break;
            }
        }

        return result;
	}
	
	private void initComponents() {

		title_lbl1 = new javax.swing.JLabel();
		proceed_btn = new javax.swing.JButton();

		btn_1 = new javax.swing.JButton();
		btn_2 = new javax.swing.JButton();
		btn_3 = new javax.swing.JButton();
		btn_4 = new javax.swing.JButton();
		btn_5 = new javax.swing.JButton();
		btn_6 = new javax.swing.JButton();
		btn_7 = new javax.swing.JButton();
		btn_8 = new javax.swing.JButton();
		btn_9 = new javax.swing.JButton();
		instructions = new javax.swing.JButton();
		
		clear_btn = new javax.swing.JButton();
		panel = new javax.swing.JPanel();
		bg_lbl = new javax.swing.JLabel();
		email_btn = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new java.awt.Dimension(500, 500));
		setResizable(false);

		panel.setPreferredSize(new java.awt.Dimension(500, 500));
		panel.setLayout(null);
		
		btn_1.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));				
		btn_1.setBounds(90, 90, 98, 90);				
		btn_1.getPreferredSize();

		btn_2.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));				
		btn_2.setBounds(200, 90, 98, 90);				
		btn_2.getPreferredSize();
		
		btn_3.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));				
		btn_3.setBounds(310, 90, 98, 90);				
		btn_3.getPreferredSize();
		
		btn_4.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));				
		btn_4.setBounds(90, 190, 98, 90);				
		btn_4.getPreferredSize();
		
		btn_5.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));				
		btn_5.setBounds(200, 190, 98, 90);				
		btn_5.getPreferredSize();
		
		btn_6.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));				
		btn_6.setBounds(310, 190, 98, 90);				
		btn_6.getPreferredSize();
		
		btn_7.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));				
		btn_7.setBounds(90, 290, 98, 90);				
		btn_7.getPreferredSize();
		
		btn_8.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));				
		btn_8.setBounds(200, 290, 98, 90);				
		btn_8.getPreferredSize();
		
		btn_9.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));				
		btn_9.setBounds(310, 290, 98, 90);				
		btn_9.getPreferredSize();
		
		randomizeButtons();


		clear_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		clear_btn.setText("Clear");

		panel.add(clear_btn);
		clear_btn.setBounds(180, 430, 140, 34);

		title_lbl1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		title_lbl1.setForeground(new java.awt.Color(0xffffff));
		title_lbl1.setText("Level 3: Color-based password");
		panel.add(title_lbl1);
		title_lbl1.setBounds(70, 20, 365, 29);

		
		proceed_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		proceed_btn.setText("Next");

		panel.add(proceed_btn);
		proceed_btn.setBounds(160, 390, 180, 34);

		email_btn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		email_btn.setForeground(new java.awt.Color(255, 255, 255));
		email_btn.setText("Forgot Password?");
		panel.add(email_btn);
		email_btn.setBounds(360, 390, 110, 30);
		email_btn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	//email here
            	Connection conn = null;
            	PreparedStatement pst = null;
            	ResultSet rs = null;
            	String sql = "Select * from users where username=?";
                try{
                	conn = DataBase.java_db();          	
                    pst=conn.prepareStatement(sql);
                    pst.setString(1,InfoAndPass.getUsername());
                    rs=pst.executeQuery();
                    
                  if (rs.next ())
                  {
                    String imagePass = rs.getString("RGBPASS");
                    String email = rs.getString("EMAIL");
                    String firstname = rs.getString("FIRSTNAME");
                    
                    sendMail(firstname,email,imagePass,email_btn);
                    
                  }else {
                	  JOptionPane.showMessageDialog(email_btn, "Incorrect Username");
                  }

                }catch(Exception e){
                	//System.out.println(e);
                }finally {

                    try{
                        rs.close();
                        pst.close();
                    }
                    catch(Exception e){

                    }
                }//end finally
            	
            }

            public void mouseEntered(MouseEvent evt) {
            	email_btn.setForeground(new Color(0x00FFFD));
            }

            public void mouseExited(MouseEvent evt) {
            	email_btn.setForeground(Color.WHITE);//
            }
        });

		instructions.setFont(new java.awt.Font("Tahoma", 1, 14));
		instructions.setText("Help");
		instructions.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				instructionsActionPerformed(evt);
			}
		});
		panel.add(instructions);
		instructions.setBounds(30, 390, 110, 30);//button

		bg_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/thirdlevelbg.jpg")));
		panel.add(bg_lbl);
		bg_lbl.setBounds(0, 0, 500, 500);

		
		//panel.setLayout(ly);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
		);
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);


		pack();
		validate();

		StringBuilder passwordString = new StringBuilder();
		
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				JButton button = (JButton) ev.getSource();
				//Each button press creates the password

				if(button == btn_1)
				{
					//btn_1.setEnabled(false);
					//System.out.println("BUTTON 1");
					buildPassword(btn_1);
				}
				else if(button == btn_2)
				{
					//btn_2.setEnabled(false);
					//System.out.println("BUTTON 2");
					buildPassword(btn_2);
				}
				else if(button == btn_3)
				{
					//btn_3.setEnabled(false);
					//System.out.println("BUTTON 3");
					buildPassword(btn_3);
				}
				else if(button == btn_4)
				{
					//btn_4.setEnabled(false);
					//System.out.println("BUTTON 4");
					buildPassword(btn_4);
				}
				else if(button == btn_5)
				{
					//btn_5.setEnabled(false);
					//System.out.println("BUTTON 5");
					buildPassword(btn_5);
				}
				else if(button == btn_6)
				{
					//btn_6.setEnabled(false);
					//System.out.println("BUTTON 6");
					buildPassword(btn_6);

				}
				else if(button == btn_7)
				{
					//btn_7.setEnabled(false);
					//System.out.println("BUTTON 7");
					buildPassword(btn_7);

				}
				else if(button == btn_8)
				{
					//btn_8.setEnabled(false);
					//System.out.println("BUTTON 8");
					buildPassword(btn_8);

				}
				else if(button == btn_9)
				{
					//btn_9.setEnabled(false);
					//System.out.println("BUTTON 9");
					buildPassword(btn_9);

				}
			}};

		btn_1.addActionListener(al);
		btn_2.addActionListener(al);
		btn_3.addActionListener(al);
		btn_4.addActionListener(al);
		btn_5.addActionListener(al);
		btn_6.addActionListener(al);
		btn_7.addActionListener(al);
		btn_8.addActionListener(al);
		btn_9.addActionListener(al);

		int delay = 30000; //this is in milliseconds

		/***Renables button when the countdown is done ***/
		Timer timer = new Timer(delay, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				proceed_btn.setEnabled(true);
			}
		});

		/*** Proceed button action ***/

		proceed_btn.addActionListener(new ActionListener(){
			int tries = 0;
			int maxTries = 3;
			@Override
			public void actionPerformed(ActionEvent e)
			{

				if(tries < maxTries)
				{
					//timer stops when the time has achieved its countdown
					//so the next time it starts it starts from 30 seconds
					timer.stop();

					/***Gets username from InfoAndPass class,
					 *  supposed to work but not sure why its not.
					 *  Gets password from the stringbuilder.
					 */
	        		String username = InfoAndPass.getUsername();
	        		
	        		String password = pwList.toString();
	        		//System.out.println(password);
	        		
	                try 
	                {
	                	//connecting to the database
	                	Connection connection = DataBase.java_db();
	                	
	                	
	                    PreparedStatement statement = (PreparedStatement) connection
	                        .prepareStatement("Select username, rgbPass from users where username=? and rgbPass=?");
	
	                    statement.setString(1, username);
	                    statement.setString(2, password);
	                    ResultSet rs = statement.executeQuery();
	                    
	                    if (rs.next()) 
	                    {
	                        dispose();
	                        JOptionPane.showMessageDialog(proceed_btn, "You have successfully logged in");  
	                        dispose();
	                        connection.close();
	                        rs.close();
	                    } 
	                    else 
	                    {
	                        JOptionPane.showMessageDialog(proceed_btn, "Wrong Password");
	                        
	                      //Auto resets the password to blank
	                        pwList.clear();
	                        passwordString.setLength(0);
	                    }
	                } 
	                catch (SQLException sqlException) 
	                {
	                    sqlException.printStackTrace();
	                }
				}
				else
	            {
	            	proceed_btn.setEnabled(false);
	                JOptionPane.showMessageDialog(proceed_btn, "You have exceeded 3 tries. Please wait 30 seeconds.");
	                
	                //Auto resets the password to blank
                    pwList.clear();
	                passwordString.setLength(0);
	    			timer.start();
	    			//so whenever it starts over again it will be at 0 tries
	    			tries = -1;	
	            }

	    		tries = tries + 1;
	    		//System.out.println(tries);
	        }
		});

		/*
		 * Clear Button
		 */
		clear_btn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				passwordString.setLength(0);
                pwList.clear();

				JOptionPane.showMessageDialog(null,"Password Has Been Cleared");
			}
		});


	}
	
	/*** HELPER METHODS ***/

	/*** Assigns a button a random color ***/
	public void randomizeButtons()
	{
				
		createFirstButton();
		createSecondButton();
		createThirdButton();
		createFourthButton();
		createFifthButton();
		createSixthButton();
		createSeventhButton();
		createEigthButton();
		createNinthButton();
		

		panel.add(btn_1);
		panel.add(btn_2);
		panel.add(btn_3);
		panel.add(btn_4);
		panel.add(btn_5);
		panel.add(btn_6);
		panel.add(btn_7);
		panel.add(btn_8);
		panel.add(btn_9);
	}
	
	private void createFirstButton() {
		//Button1 Picture
		if(numbers[0] == 1) {//red
			
				//System.out.println("RED");		
				btn_1.setBackground(new java.awt.Color(0xff0000));
				btn_1.setText("Red");
				btn_1.setForeground(new java.awt.Color(0xffffff));
			
		}
		else if(numbers[0] == 2) {//yellow
			
				btn_1.setBackground(new java.awt.Color(0xffff33));
				btn_1.setText("Yellow");
			
		}
		else if(numbers[0] == 3) {//dark blue
			
				btn_1.setBackground(new java.awt.Color(0x0033ff));
				btn_1.setText("Blue");
				btn_1.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[0] == 4) {//green
			
				btn_1.setBackground(new java.awt.Color(0x33ff00));
				btn_1.setText("Green");
				btn_1.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[0] == 5) {// light blue
			
				btn_1.setBackground(new java.awt.Color(0x00ffff));
				btn_1.setText("Light Blue");
				btn_1.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[0] == 6) {//purple
			//System.out.println("Setting to purple");

				btn_1.setBackground(new java.awt.Color(0xff00ff));
				btn_1.setText("Purple");
				btn_1.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[0] == 7) {//black
			
				btn_1.setBackground(new java.awt.Color(0x000000));
				btn_1.setText("Black");
				btn_1.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[0] == 8) {//pink
			
				btn_1.setBackground(new java.awt.Color(0xff9999));
				btn_1.setText("Pink");
				btn_1.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[0] == 9) {//orange
			
				btn_1.setBackground(new java.awt.Color(0xff6600));
				btn_1.setText("Orange");
				btn_1.setForeground(new java.awt.Color(0xffffff));

			
		}
	}
	
	private void createSecondButton() {
		//Button1 Picture
		if(numbers[1] == 1) {//red
			
				//System.out.println("RED");		
				btn_2.setBackground(new java.awt.Color(0xff0000));
				btn_2.setText("Red");
				btn_2.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[1] == 2) {//yellow
			
			btn_2.setBackground(new java.awt.Color(0xffff33));
			btn_2.setText("Yellow");
			
		}
		else if(numbers[1] == 3) {//dark blue
			
			btn_2.setBackground(new java.awt.Color(0x0033ff));
			btn_2.setText("Blue");
			btn_2.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[1] == 4) {//green
			
			btn_2.setBackground(new java.awt.Color(0x33ff00));
			btn_2.setText("Green");
			btn_2.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[1] == 5) {// light blue
			
			btn_2.setBackground(new java.awt.Color(0x00ffff));
			btn_2.setText("Light Blue");
			btn_2.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[1] == 6) {//purple
			//System.out.println("Setting to purple");

			btn_2.setBackground(new java.awt.Color(0xff00ff));
			btn_2.setText("Purple");
			btn_2.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[1] == 7) {//black
			
			btn_2.setBackground(new java.awt.Color(0x000000));
			btn_2.setText("Black");
			btn_2.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[1] == 8) {//pink
			
			btn_2.setBackground(new java.awt.Color(0xff9999));
			btn_2.setText("Pink");
			btn_2.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[1] == 9) {//orange
			
			btn_2.setBackground(new java.awt.Color(0xff6600));
			btn_2.setText("Orange");
			btn_2.setForeground(new java.awt.Color(0xffffff));

			
		}
	}
	
	private void createThirdButton() {
		//Button1 Picture
		if(numbers[2] == 1) {//red
			
			btn_3.setBackground(new java.awt.Color(0xff0000));
			btn_3.setText("Red");
			btn_3.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[2] == 2) {//yellow
			
				btn_3.setBackground(new java.awt.Color(0xffff33));
				btn_3.setText("Yellow");
			
		}
		else if(numbers[2] == 3) {//dark blue
			
				btn_3.setBackground(new java.awt.Color(0x0033ff));
				btn_3.setText("Blue");
				btn_3.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[2] == 4) {//green
			
				btn_3.setBackground(new java.awt.Color(0x33ff00));
				btn_3.setText("Green");
			
		}
		else if(numbers[2] == 5) {// light blue
			
				btn_3.setBackground(new java.awt.Color(0x00ffff));
				btn_3.setText("Light Blue");
				btn_3.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[2] == 6) {//purple
			//System.out.println("Setting to purple");

				btn_3.setBackground(new java.awt.Color(0xff00ff));
				btn_3.setText("Purple");
				btn_3.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[2] == 7) {//black
			
				btn_3.setBackground(new java.awt.Color(0x000000));
				btn_3.setText("Black");
				btn_3.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[2] == 8) {//pink
			
				btn_3.setBackground(new java.awt.Color(0xff9999));
				btn_3.setText("Pink");
				btn_3.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[2] == 9) {//orange
			
				btn_3.setBackground(new java.awt.Color(0xff6600));
				btn_3.setText("Orange");
				btn_3.setForeground(new java.awt.Color(0xffffff));

			
		}
	}
	
	private void createFourthButton() {
		//Button1 Picture
		if(numbers[3] == 1) {//red
			
				btn_4.setBackground(new java.awt.Color(0xff0000));
				btn_4.setText("Red");
				btn_4.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[3] == 2) {//yellow
			
				btn_4.setBackground(new java.awt.Color(0xffff33));
				btn_4.setText("Yellow");
			
		}
		else if(numbers[3] == 3) {//dark blue
			
				btn_4.setBackground(new java.awt.Color(0x0033ff));
				btn_4.setText("Blue");
				btn_4.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[3] == 4) {//green
			
				btn_4.setBackground(new java.awt.Color(0x33ff00));
				btn_4.setText("Green");
				btn_4.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[3] == 5) {// light blue
			
				btn_4.setBackground(new java.awt.Color(0x00ffff));
				btn_4.setText("Light Blue");
				btn_4.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[3] == 6) {//purple
			//System.out.println("Setting to purple");

				btn_4.setBackground(new java.awt.Color(0xff00ff));
				btn_4.setText("Purple");
				btn_4.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[3] == 7) {//black
			
				btn_4.setBackground(new java.awt.Color(0x000000));
				btn_4.setText("Black");
				btn_4.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[3] == 8) {//pink
			
				btn_4.setBackground(new java.awt.Color(0xff9999));
				btn_4.setText("Pink");
				btn_4.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[3] == 9) {//orange
			
				btn_4.setBackground(new java.awt.Color(0xff6600));
				btn_4.setText("Orange");
				btn_4.setForeground(new java.awt.Color(0xffffff));

			
		}
	}
	
	private void createFifthButton() {
		//Button1 Picture
		if(numbers[4] == 1) {//red
			
				btn_5.setBackground(new java.awt.Color(0xff0000));
				btn_5.setText("Red");
				btn_5.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[4] == 2) {//yellow
			
				btn_5.setBackground(new java.awt.Color(0xffff33));
				btn_5.setText("Yellow");
			
		}
		else if(numbers[4] == 3) {//dark blue
			
				btn_5.setBackground(new java.awt.Color(0x0033ff));
				btn_5.setText("Blue");
				btn_5.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[4] == 4) {//green
			
				btn_5.setBackground(new java.awt.Color(0x33ff00));
				btn_5.setText("Green");
				btn_5.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[4] == 5) {// light blue
			
				btn_5.setBackground(new java.awt.Color(0x00ffff));
				btn_5.setText("Light Blue");
				btn_5.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[4] == 6) {//purple
			//System.out.println("Setting to purple");

				btn_5.setBackground(new java.awt.Color(0xff00ff));
				btn_5.setText("Purple");
				btn_5.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[4] == 7) {//black
			
				btn_5.setBackground(new java.awt.Color(0x000000));
				btn_5.setText("Black");
				btn_5.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[4] == 8) {//pink
			
				btn_5.setBackground(new java.awt.Color(0xff9999));
				btn_5.setText("Pink");
				btn_5.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[4] == 9) {//orange
			
				btn_5.setBackground(new java.awt.Color(0xff6600));
				btn_5.setText("Orange");
				btn_5.setForeground(new java.awt.Color(0xffffff));

			
		}
	}
	
	private void createSixthButton() {
		//Button1 Picture
		if(numbers[5] == 1) {//red
			
				btn_6.setBackground(new java.awt.Color(0xff0000));
				btn_6.setText("Red");
				btn_6.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[5] == 2) {//yellow
			
				btn_6.setBackground(new java.awt.Color(0xffff33));
				btn_6.setText("Yellow");
			
		}
		else if(numbers[5] == 3) {//dark blue
			
				btn_6.setBackground(new java.awt.Color(0x0033ff));
				btn_6.setText("Blue");
				btn_6.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[5] == 4) {//green
			
				btn_6.setBackground(new java.awt.Color(0x33ff00));
				btn_6.setText("Green");
				btn_6.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[5] == 5) {// light blue
			
				btn_6.setBackground(new java.awt.Color(0x00ffff));
				btn_6.setText("Light Blue");
				btn_6.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[5] == 6) {//purple
			//System.out.println("Setting to purple");

				btn_6.setBackground(new java.awt.Color(0xff00ff));
				btn_6.setText("Purple");
				btn_6.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[5] == 7) {//black
			
				btn_6.setBackground(new java.awt.Color(0x000000));
				btn_6.setText("Black");
				btn_6.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[5] == 8) {//pink
			
				btn_6.setBackground(new java.awt.Color(0xff9999));
				btn_6.setText("Pink");
				btn_6.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[5] == 9) {//orange
			
				btn_6.setBackground(new java.awt.Color(0xff6600));
				btn_6.setText("Orange");
				btn_6.setForeground(new java.awt.Color(0xffffff));

			
		}
	}
	
	private void createSeventhButton() {
		//Button1 Picture
		if(numbers[6] == 1) {//red
			
				btn_7.setBackground(new java.awt.Color(0xff0000));
				btn_7.setText("Red");
				btn_7.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[6] == 2) {//yellow
			
				btn_7.setBackground(new java.awt.Color(0xffff33));
				btn_7.setText("Yellow");
			
		}
		else if(numbers[6] == 3) {//dark blue
			
				btn_7.setBackground(new java.awt.Color(0x0033ff));
				btn_7.setText("Blue");
				btn_7.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[6] == 4) {//green
			
				btn_7.setBackground(new java.awt.Color(0x33ff00));
				btn_7.setText("Green");
				btn_7.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[6] == 5) {// light blue
			
				btn_7.setBackground(new java.awt.Color(0x00ffff));
				btn_7.setText("Light Blue");
				btn_7.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[6] == 6) {//purple
			//System.out.println("Setting to purple");

				btn_7.setBackground(new java.awt.Color(0xff00ff));
				btn_7.setText("Purple");
				btn_7.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[6] == 7) {//black
			
				btn_7.setBackground(new java.awt.Color(0x000000));
				btn_7.setText("Black");
				btn_7.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[6] == 8) {//pink
			
				btn_7.setBackground(new java.awt.Color(0xff9999));
				btn_7.setText("Pink");
				btn_7.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[6] == 9) {//orange
			
				btn_7.setBackground(new java.awt.Color(0xff6600));
				btn_7.setText("Orange");
				btn_7.setForeground(new java.awt.Color(0xffffff));

			
		}
	}
	
	private void createEigthButton() {
		//Button1 Picture
		if(numbers[7] == 1) {//red
			
				btn_8.setBackground(new java.awt.Color(0xff0000));
				btn_8.setText("Red");
				btn_8.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[7] == 2) {//yellow
			
				btn_8.setBackground(new java.awt.Color(0xffff33));
				btn_8.setText("Yellow");
			
		}
		else if(numbers[7] == 3) {//dark blue
			
				btn_8.setBackground(new java.awt.Color(0x0033ff));
				btn_8.setText("Blue");
				btn_8.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[7] == 4) {//green
			
				btn_8.setBackground(new java.awt.Color(0x33ff00));
				btn_8.setText("Green");
				btn_8.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[7] == 5) {// light blue
			
				btn_8.setBackground(new java.awt.Color(0x00ffff));
				btn_8.setText("Light Blue");
				btn_8.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[7] == 6) {//purple
			//System.out.println("Setting to purple");

				btn_8.setBackground(new java.awt.Color(0xff00ff));
				btn_8.setText("Purple");
				btn_8.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[7] == 7) {//black
			
				btn_8.setBackground(new java.awt.Color(0x000000));
				btn_8.setText("Black");
				btn_8.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[7] == 8) {//pink
			
				btn_8.setBackground(new java.awt.Color(0xff9999));
				btn_8.setText("Pink");
				btn_8.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[7] == 9) {//orange
			
				btn_8.setBackground(new java.awt.Color(0xff6600));
				btn_8.setText("Orange");
				btn_8.setForeground(new java.awt.Color(0xffffff));

			
		}
	}
	
	private void createNinthButton() {
		//Button9 Picture
		if(numbers[8] == 1) {//red
			
				btn_9.setBackground(new java.awt.Color(0xff0000));
				btn_9.setText("Red");
				btn_9.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[8] == 2) {//yellow
			
				btn_9.setBackground(new java.awt.Color(0xffff33));
				btn_9.setText("Yellow");
			
		}
		else if(numbers[8] == 3) {//dark blue
			
				btn_9.setBackground(new java.awt.Color(0x0033ff));
				btn_9.setText("Blue");
				btn_9.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[8] == 4) {//green
			
				btn_9.setBackground(new java.awt.Color(0x33ff00));
				btn_9.setText("Green");
				btn_9.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[8] == 5) {// light blue
			
				btn_9.setBackground(new java.awt.Color(0x00ffff));
				btn_9.setText("Light Blue");
				btn_9.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[8] == 6) {//purple
				//System.out.println("Setting to purple");
				btn_9.setBackground(new java.awt.Color(0xff00ff));
				btn_9.setText("Purple");
				btn_9.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[8] == 7) {//black
			
				btn_9.setBackground(new java.awt.Color(0x000000));
				btn_9.setText("Black");
				btn_9.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[8] == 8) {//pink
			
				btn_9.setBackground(new java.awt.Color(0xff9999));
				btn_9.setText("Pink");
				btn_9.setForeground(new java.awt.Color(0xffffff));

			
		}
		else if(numbers[8] == 9) {//orange
			
				btn_9.setBackground(new java.awt.Color(0xff6600));
				btn_9.setText("Orange");
				btn_9.setForeground(new java.awt.Color(0xffffff));

			
		}
	}
	
	/*** BUILDS THE PASSWORD UPON BUTTON CLICK ***/
	
	private void buildPassword(JButton button)
	{
		if(button.getText().contentEquals("Red"))
		{
			//System.out.println("Red");
			pwList.add(1);
		}
		if(button.getText().contentEquals("Blue"))
		{
			//System.out.println("Blue");
			pwList.add(4);

		}
		if(button.getText().contentEquals("Green"))
		{
			//System.out.println("Green");
			pwList.add(3);

		}
		if(button.getText().contentEquals("Yellow"))
		{
			//System.out.println("Yellow");
			pwList.add(2);

		}
		if(button.getText().contentEquals("Black"))
		{
			//System.out.println("Black");
			pwList.add(7);

		}
		if(button.getText().contentEquals("Orange"))
		{
			//System.out.println("Orange");
			pwList.add(5);

		}
		if(button.getText().contentEquals("Purple"))
		{
			//System.out.println("Purple");
			pwList.add(8);

		}
		if(button.getText().contentEquals("Pink"))
		{
			//System.out.println("Pink");
			pwList.add(9);

		}
		if(button.getText().contentEquals("Light Blue"))
		{
			//System.out.println("Light Blue");
			pwList.add(6);
		}
		
	}

	private void instructionsActionPerformed(java.awt.event.ActionEvent evt){

		JOptionPane.showMessageDialog(null, "Red is 1.\n"
											+"Yellow is 2.\n"
											+ "Green is 3.\n"
											+ "Blue is 4.\n"
											+ "Orange is 5.\n"
											+ "Light Blue is 6\n"
											+ "Black is 7.\n"
											+ "Purple is 8.\n"
											+ "Pink is 9.");
	}
	
    public void sendMail(String firstname, String recipient, String password, JLabel email_btn2) {
        // Recipient's email
        String to = recipient;

        // Sender's credentials
        String from = "root.3la@gmail.com";
        String emailPassword = "Test@1234";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = new Properties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        
        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(from, emailPassword);

            }

        });
        
        // Used to debug SMTP issues
        //session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Forgotten RGB Password");

            // Now set the actual message
            message.setText("Hi "+firstname+", \n\nYour rgb password is: "+password+" \n\n 3LA Admin");

            // Send message
            Transport.send(message);
            JOptionPane.showMessageDialog(email_btn2, "Password Has Been Sent To Your Email!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
            JOptionPane.showMessageDialog(email_btn2, "Could Not Send Password");
        }
    }

	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {


		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ThirdLevelGUI().setVisible(true);
			}
		});
	}


}

