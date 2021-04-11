package registrationForm;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import DataBaseConnection.DataBase;
import registrationForm.ClientInfo;

public class FinishGUI extends javax.swing.JFrame {

    // Variables declaration - do not modify
    private javax.swing.JLabel bg_lbl;
    private javax.swing.JButton finish_btn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton back_btn;
    private javax.swing.JLabel createLabel;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel userNameLabel;

    


    //Database Stuff
    public static PreparedStatement pst = null;
    public static Connection conn = null;


    public FinishGUI() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2,size.height/2 - getHeight()/2);
    }



    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        finish_btn = new javax.swing.JButton();
        bg_lbl = new javax.swing.JLabel();
        back_btn = new javax.swing.JButton();
        createLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 500));
        setResizable(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(500, 500));
        jPanel1.setLayout(null);

        createLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
        createLabel.setForeground(Color.WHITE);
        createLabel.setText("Create Account with the Information Provided?");
        createLabel.setBounds(30,0,500,100);
        jPanel1.add(createLabel);  
        
        userNameLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
        userNameLabel.setForeground(Color.WHITE);
        userNameLabel.setText("Username: "+InfoAndPass.getUsername());
        userNameLabel.setBounds(120,80,500,100);
        jPanel1.add(userNameLabel);
        
        firstNameLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
        firstNameLabel.setForeground(Color.WHITE);
        firstNameLabel.setText("First Name: "+ClientInfo.info.getFirstName());
        firstNameLabel.setBounds(120,120,500,100);
        jPanel1.add(firstNameLabel);  
        
        lastNameLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
        lastNameLabel.setForeground(Color.WHITE);
        lastNameLabel.setText("Last Name: "+ClientInfo.info.getLastName());
        lastNameLabel.setBounds(120,160,500,100);
        jPanel1.add(lastNameLabel);  
        
        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setText("Email: "+ClientInfo.info.getEmail());
        emailLabel.setBounds(120,200,500,100);
        jPanel1.add(emailLabel);  
        
        finish_btn.setFont(new java.awt.Font("Tahoma", 1, 14));
        finish_btn.setText("Finish!");
        finish_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finish_btnActionPerformed(evt);
            }
        });
        jPanel1.add(finish_btn);
        finish_btn.setBounds(160, 350, 180, 34);

        back_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        back_btn.setText("Go Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });
        jPanel1.add(back_btn);
        back_btn.setBounds(180, 390, 140, 34);

        bg_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/finish.jpg")));
        jPanel1.add(bg_lbl);
        bg_lbl.setBounds(0, 0, 500, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

    private void finish_btnActionPerformed(java.awt.event.ActionEvent evt) {
        String firstName = ClientInfo.info.getFirstName();
        String lastName = ClientInfo.info.getLastName();
        String email = ClientInfo.info.getEmail();
        String username = InfoAndPass.getUsername();
        String textPass = ClientInfo.info.getTextPass();
        String imagePass = ClientInfo.info.getImagePass();
        String rgbPass = ClientInfo.info.getRgbPass();
        byte[] profilePic = ClientInfo.info.getProfilePic();///////////

        if (firstName == null || lastName == null || email == null || username == null || textPass == null || imagePass == null || rgbPass == null ) { //adding images

            JOptionPane.showMessageDialog(null, "One or more fields are NULL... Please Redo");

        }else if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || username.isEmpty() || textPass.isEmpty() || imagePass.isEmpty() || rgbPass.isEmpty()){

            JOptionPane.showMessageDialog(null, "One of the fields are EMPTY... Please Redo");

        }else {
        	
        	if (profilePic == null ) {
				try {
	        		//set default image
	        		File img = new File("src/ProfilePictures/default.jpg");
					String path = img.getCanonicalPath();		//path of image
					FileInputStream fix = new FileInputStream(path);
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					byte[] buf = new byte[1024];				
					
					//convert image to bytes
					for(int number; (number = fix.read(buf))!= -1;) {
					    bos.write(buf,0,number);
	
					}
					profilePic = bos.toByteArray();		//new image in bytes
					
					bos.close();
					fix.close();
				}catch(IOException ie) {
					
				}
				
        	}

            try{
            	conn = DataBase.java_db();
                String sql ="insert into users (firstName, lastName, email, username, textPass, imagePass, rgbPass, Image) values (?,?,?,?,?,?,?,?)";
                pst = conn.prepareStatement(sql);
                pst.setString(1,firstName);
                pst.setString(2,lastName);
                pst.setString(3,email);
                pst.setString(4,username);
                pst.setString(5,textPass);
                pst.setString(6,imagePass);
                pst.setString(7,rgbPass);
                pst.setBytes(8, profilePic);


                pst.execute();
                JOptionPane.showMessageDialog(null, "Your User Account Has Been Created");
                conn.close();

            }catch(Exception e1){
                JOptionPane.showMessageDialog(null, "Unable To Create A New User: " + username);
                System.out.print(e1);
            }

            dispose();
        }
    }

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {
        ThirdLevelConfirm x = new ThirdLevelConfirm();
        x.setVisible(true);
        this.dispose();
    }


    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinishGUI().setVisible(true);
            }
        });
    }



}