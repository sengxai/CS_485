package firstLevel;

import DataBaseConnection.DataBase;
import registrationForm.ClientInfo;
import registrationForm.InfoAndPass;
import secondLevel.SecondLevelGUI;

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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Marcelo Telleria
 */
public class FirstLevelGUI extends javax.swing.JFrame {


    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;

    private javax.swing.JLabel bg_lbl;
    private javax.swing.JLabel img;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel noAccount_lbl;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JLabel registerLabel;
    private javax.swing.JLabel title_lbl;
    private javax.swing.JTextField userText;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel usernameLabel1;
    private javax.swing.JLabel welcomeLabel;



    String filename = null;
    byte[] person_image = null;

    public FirstLevelGUI() {
        initComponents();
        conn= DataBase.java_db();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2,size.height/2 - getHeight()/2);
    }



    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        usernameLabel1 = new javax.swing.JLabel();
        passwordText = new javax.swing.JPasswordField();
        userText = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        noAccount_lbl = new javax.swing.JLabel();
        registerLabel = new javax.swing.JLabel();
        title_lbl = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        img = new javax.swing.JLabel();
        bg_lbl = new javax.swing.JLabel();
        welcomeLabel = new javax.swing.JLabel();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(500, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 500));
        jPanel1.setLayout(null);
        
        welcomeLabel.setFont(new java.awt.Font("Tahoma", 1, 45)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        welcomeLabel.setText("<HTML><div style='text-align: center;'>WELCOME<br>TO THE<br>3LA SYSTEM</div></HTML>");
        welcomeLabel.setVerticalTextPosition(SwingConstants.CENTER);
        jPanel1.add(welcomeLabel);
        welcomeLabel.setBounds(110, 80, 300, 200);
        welcomeLabel.setVisible(true);
        
        usernameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel.setText("Forgot Password?");
        jPanel1.add(usernameLabel);
        usernameLabel.setBounds(310, 360, 120, 30);
        usernameLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	//email here
            	String sql = "Select * from users where username=?";
                try{
                	
                    pst=conn.prepareStatement(sql);
                    pst.setString(1,userText.getText());
                    rs=pst.executeQuery();
                    
                  if (rs.next ())
                  {
                    String textPass = rs.getString("TEXTPASS");
                    String email = rs.getString("EMAIL");
                    String firstname = rs.getString("FIRSTNAME");
                    
                    sendMail(firstname,email,textPass,usernameLabel);
                    
                  }else {
                	  JOptionPane.showMessageDialog(usernameLabel, "Invalid Username!");
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
            	usernameLabel.setForeground(new Color(0x00FFFD));
            }

            public void mouseExited(MouseEvent evt) {
            	usernameLabel.setForeground(Color.WHITE);//
            }
        });

        usernameLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        usernameLabel1.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel1.setText("Forgot Username?");
        jPanel1.add(usernameLabel1);
        usernameLabel1.setBounds(310, 320, 120, 30);
        usernameLabel1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	//email here
            	String emailEntered = JOptionPane.showInputDialog(usernameLabel1, "Enter Email:");
            	try {
                   	String email = emailEntered.trim();
                	if(email != null && !email.isEmpty()) {
                		String sql = "Select * from users where email=?";
                        try{
                        	
                            pst=conn.prepareStatement(sql);
                            pst.setString(1,email);
                            rs=pst.executeQuery();
                            
                          if (rs.next ())
                          {
                            String username = rs.getString("USERNAME");
                            String firstname = rs.getString("FIRSTNAME");
                            sendUsernameMail(firstname,email,username,usernameLabel1);
                          }else {
                        	  JOptionPane.showMessageDialog(usernameLabel1, "Invalid Email!");
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
                	}else {
                		JOptionPane.showMessageDialog(usernameLabel1, "Invalid Email!");
                	}	
            	}catch (NullPointerException ne) {
            		//JOptionPane.showMessageDialog(usernameLabel1, "Invalid Email!");
            	}
     
            }

            public void mouseEntered(MouseEvent evt) {
            	usernameLabel1.setForeground(new Color(0x00FFFD));
            }

            public void mouseExited(MouseEvent evt) {
            	usernameLabel1.setForeground(Color.WHITE);//
            }
        });
        
        jPanel1.add(passwordText);
        passwordText.setText("Password");
        passwordText.setForeground(Color.lightGray);
        passwordText.setBounds(100, 360, 200, 30);
        passwordText.addFocusListener(new FocusListener() 
        {

			@Override
			public void focusGained(FocusEvent e) {
				
				if (String.valueOf(passwordText.getPassword()).trim().toLowerCase().equals("password")) {
			        passwordText.setText("");
			        passwordText.setForeground(Color.BLACK);
				}
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				
				if (String.valueOf(passwordText.getPassword()).equals("")) {
			        passwordText.setText("Password");
			        passwordText.setForeground(Color.lightGray);
				}
				
			}
        });
        
        jPanel1.add(userText);
        userText.setText("Username");
        userText.setForeground(Color.lightGray);
        userText.setBounds(100, 320, 200, 30);
        userText.addFocusListener(new FocusListener() 
        {

			@Override
			public void focusGained(FocusEvent e) {
				
				if (userText.getText().trim().toLowerCase().equals("username")) {
					userText.setText("");
					userText.setForeground(Color.BLACK);
				}
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (userText.getText().equals("")) {
					userText.setText("Username");
					userText.setForeground(Color.lightGray);
				}
				
			}
        });
        
        passwordText.addActionListener(action);//
        userText.addActionListener(action);

        /////
        userText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userTextKeyReleased(evt);
            }
        });

        ////



        loginButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        loginButton.setText("Login");
        jPanel1.add(loginButton);
        loginButton.setBounds(100, 400, 320, 31);
        loginButton.addActionListener(action);

        noAccount_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        noAccount_lbl.setForeground(new java.awt.Color(255, 255, 255));
        noAccount_lbl.setText("Don't have an account?");
        jPanel1.add(noAccount_lbl);
        noAccount_lbl.setBounds(100, 440, 220, 20);

        registerLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        registerLabel.setForeground(new java.awt.Color(255, 255, 255));
        registerLabel.setText("Sign Up!");
        registerLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                dispose();
                ClientInfo signup = new ClientInfo();
                signup.setVisible(true);
            }

            public void mouseEntered(MouseEvent evt) {
                registerLabel.setForeground(new Color(0x00FFFD));
            }

            public void mouseExited(MouseEvent evt) {
                registerLabel.setForeground(Color.WHITE);//
            }
        });


        jPanel1.add(registerLabel);
        registerLabel.setBounds(320, 440, 80, 20);

        title_lbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        title_lbl.setForeground(new java.awt.Color(255, 255, 255));
        title_lbl.setText("Three-Level Authentication System");
        jPanel1.add(title_lbl);
        title_lbl.setBounds(40, 30, 420, 30);

        jDesktopPane1.setLayer(img, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
        jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        jPanel1.add(jDesktopPane1);
        jDesktopPane1.setBounds(100, 100, 300, 200);
        jDesktopPane1.setVisible(false);

        bg_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/firstLevel.jpg"))); // NOI18N
        bg_lbl.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel1.add(bg_lbl);
        bg_lbl.setBounds(0, 0, 500, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }


    int delay = 30000; //this is in milliseconds

    /***Renables button when the countdown is done ***/
    Timer timer = new Timer(delay, new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            loginButton.setEnabled(true);
            userText.setEnabled(true);
            passwordText.setEnabled(true);
        }
    });

    //Login Action
    ActionListener action = new ActionListener() {
        /*** Local Variables ***/

        int tries = 0;
        int maxTries = 3;


        @Override
        public void actionPerformed(ActionEvent e) {

            if(tries < maxTries)
            {
                //timer stops when the time has achieved its countdown
                //so the next time it starts it starts from 30 seconds
                timer.stop();
                ClientInfo.info.setUsername(userText.getText());
                String username = InfoAndPass.getUsername();
                String password = String.valueOf(passwordText.getPassword());

                String sql = "Select username, textPass from users where username=? and textPass=?";
                try {
                    pst=conn.prepareStatement(sql);

                    pst.setString(1, username);
                    pst.setString(2, password);
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        dispose();
                        conn.close();
                        rs.close();
                        SecondLevelGUI second = new SecondLevelGUI();
                        second.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(loginButton, "Invalid Username & Password");
                    }

                    //conn.close();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
            else
            {
                loginButton.setEnabled(false);
                userText.setEnabled(false);
                passwordText.setEnabled(false);
                JOptionPane.showMessageDialog(loginButton, "You have exceeded 3 tries. Please wait 30 seeconds.");

                timer.start();
                //so whenever it starts over again it will be at 0 tries
                tries = -1;

            }
            //tries increments on number of unsuccessful tries
            tries = tries + 1;

            //System.out.println(tries);

        }
    };



    //This will display the image
    private void userTextKeyReleased(java.awt.event.KeyEvent evt) {

        String sql = "Select * from users where username=?";
        try{
        	
            pst=conn.prepareStatement(sql);
            pst.setString(1,userText.getText());
            rs=pst.executeQuery();
            
          if (rs.next ())
          {
        	jDesktopPane1.setVisible(true);
        	welcomeLabel.setVisible(false);
            byte[] image = rs.getBytes("Image");
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH));
            img.setIcon(imageIcon);
          }else {
        	  jDesktopPane1.setVisible(false);
        	  welcomeLabel.setVisible(true);
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
    }//end of keyreleased


    public void sendMail(String firstname, String recipient, String password, JLabel label) {
        // Recipient's email
        String to = recipient;

        // Sender's credentials
        String from = "*****@gmail.com";
        String emailPassword = "*****";

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
            message.setSubject("Forgotten Text Password");

            // Now set the actual message
            message.setText("Hi "+firstname+", \n\nYour text password is: "+password+" \n\n 3LA Admin");

            // Send message
            Transport.send(message);
            JOptionPane.showMessageDialog(label, "Password Has Been Sent To Your Email!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
            JOptionPane.showMessageDialog(label, "Could Not Send Password");
        }
    }

    
    public void sendUsernameMail(String firstname, String recipient, String username, JLabel label) {
        // Recipient's email
        String to = recipient;

        // Sender's credentials
        String from = "*****@gmail.com";
        String emailPassword = "*****";

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
            message.setSubject("Forgotten Username");

            // Now set the actual message
            message.setText("Hi "+firstname+", \n\nYour username is: "+username+" \n\n 3LA Admin");

            // Send message
            Transport.send(message);
            JOptionPane.showMessageDialog(label, "Username Has Been Sent To Your Email!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
            JOptionPane.showMessageDialog(label, "Could Not Send Username!");
        }
    }


        /**
         * @param args the command line arguments
         */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FirstLevelGUI().setVisible(true);
            }
        });
    }


}
