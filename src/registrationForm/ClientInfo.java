package registrationForm;

import firstLevel.FirstLevelGUI;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *Author: XX
 *Date: 9/4/2020
 *Description: This is the GUI interface for the registration form where the user will enter data to create a new account.
 */

public class ClientInfo extends javax.swing.JFrame {

    private javax.swing.JButton attach_btn;
    private javax.swing.JLabel bg_lbl;
    private javax.swing.JLabel email_lbl;
    private javax.swing.JTextField email_txt;
    private javax.swing.JTextField firstName_txt;
    private javax.swing.JLabel firstname_lbl;
    private javax.swing.JLabel img;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JTextField lastName_txt;
    private javax.swing.JLabel lastname_lbl;
    private javax.swing.JPanel panel;
    private javax.swing.JButton proceed_btn;
    private javax.swing.JLabel title_lbl;
    private javax.swing.JLabel username_lbl;
    private javax.swing.JTextField username_txt;
    private javax.swing.JButton back_btn;

    String filename = null;
    byte[] person_image = null;


    public static InfoAndPass info = new InfoAndPass();
	private FileInputStream fix;
    
    /**
     * Creates registration
     */
    public ClientInfo() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2,size.height/2 - getHeight()/2);

    }



    private void initComponents() {

        panel = new javax.swing.JPanel();
        firstName_txt = new javax.swing.JTextField();
        firstname_lbl = new javax.swing.JLabel();
        lastname_lbl = new javax.swing.JLabel();
        lastName_txt = new javax.swing.JTextField();
        email_lbl = new javax.swing.JLabel();
        email_txt = new javax.swing.JTextField();
        username_lbl = new javax.swing.JLabel();
        username_txt = new javax.swing.JTextField();
        proceed_btn = new javax.swing.JButton();
        title_lbl = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        img = new javax.swing.JLabel();
        attach_btn = new javax.swing.JButton();
        bg_lbl = new javax.swing.JLabel();
        back_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panel.setPreferredSize(new java.awt.Dimension(500, 500));
        panel.setLayout(null);
        panel.add(firstName_txt);
        firstName_txt.setBounds(120, 170, 160, 20);

        firstname_lbl.setFont(new java.awt.Font("Tahoma", 1, 14));
        firstname_lbl.setForeground(new java.awt.Color(255, 255, 255));
        firstname_lbl.setText("First Name:");
        panel.add(firstname_lbl);
        firstname_lbl.setBounds(30, 170, 79, 17);

        lastname_lbl.setFont(new java.awt.Font("Tahoma", 1, 14));
        lastname_lbl.setForeground(new java.awt.Color(255, 255, 255));
        lastname_lbl.setText("Last Name:");
        panel.add(lastname_lbl);
        lastname_lbl.setBounds(30, 210, 78, 17);
        panel.add(lastName_txt);
        lastName_txt.setBounds(120, 210, 160, 20);

        email_lbl.setFont(new java.awt.Font("Tahoma", 1, 14));
        email_lbl.setForeground(new java.awt.Color(255, 255, 255));
        email_lbl.setText("Email:");
        panel.add(email_lbl);
        email_lbl.setBounds(70, 250, 41, 17);
        panel.add(email_txt);
        email_txt.setBounds(120, 250, 160, 20);

        username_lbl.setFont(new java.awt.Font("Tahoma", 1, 14));
        username_lbl.setForeground(new java.awt.Color(255, 255, 255));
        username_lbl.setText("Username:");
        panel.add(username_lbl);
        username_lbl.setBounds(40, 290, 74, 17);
        panel.add(username_txt);
        username_txt.setBounds(120, 290, 160, 20);

        proceed_btn.setFont(new java.awt.Font("Tahoma", 1, 14));
        proceed_btn.setText("Proceed to Step 2");
        proceed_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceed_btnActionPerformed(evt);
            }
        });
        panel.add(proceed_btn);
        proceed_btn.setBounds(120, 350, 160, 25);

        title_lbl.setFont(new java.awt.Font("Tahoma", 1, 36));
        title_lbl.setForeground(new java.awt.Color(255, 255, 255));
        title_lbl.setText("Register Now!");
        panel.add(title_lbl);
        title_lbl.setBounds(140, 40, 260, 35);

        jDesktopPane1.setLayer(img, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );

        panel.add(jDesktopPane1);
        jDesktopPane1.setBounds(310, 170, 180, 140);

        attach_btn.setFont(new java.awt.Font("Tahoma", 1, 14));
        attach_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/attach.png")));
        attach_btn.setText("Attach");
        attach_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attach_btnActionPerformed(evt);
            }
        });
        panel.add(attach_btn);
        attach_btn.setBounds(350, 330, 110, 30);

        back_btn.setFont(new java.awt.Font("Tahoma", 1, 14));
        back_btn.setText("Go Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });
        panel.add(back_btn);
        back_btn.setBounds(160, 390, 90, 25);

        bg_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/registration1.jpg")));
        panel.add(bg_lbl);
        bg_lbl.setBounds(0, 0, 500, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();

        repopulateData();
    }

    private void proceed_btnActionPerformed(java.awt.event.ActionEvent evt) {

        //if any of the text fields are empty, do not proceed to step 2.
        if(firstName_txt.getText().isEmpty() || lastName_txt.getText().isEmpty() || email_txt.getText().isEmpty() || username_txt.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "There cannot be empty text fields.");
        }else if(validateEmail(email_txt.getText()) == false) {
        	JOptionPane.showMessageDialog(null, "Invalid Email!");
        }else{//welcome message and proceed to step to 1st level

            String firstName = firstName_txt.getText();
            String lastName = lastName_txt.getText();
            String email = email_txt.getText();
            String username = username_txt.getText();
            
            info.setFirstName(firstName);
            info.setLastName(lastName);
            info.setEmail(email);
            info.setUsername(username);
            info.setProfilePic(person_image);///////////////////

            CreateTextPass first = new CreateTextPass();
            dispose();
            first.setVisible(true);
            

        }//end of else
    }


    private void attach_btnActionPerformed(java.awt.event.ActionEvent evt) {
        try{
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog((null));
        File f = chooser.getSelectedFile();

        filename = f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon (new ImageIcon(filename).getImage().getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_DEFAULT));
        img.setIcon(imageIcon);

        //try{

            File image = new File(filename);
            fix = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];

            for(int number; (number = fix.read(buf))!= -1;) {
                bos.write(buf,0,number);

            }
            person_image = bos.toByteArray();



        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Image has been selected");
        }

    }

    public void back_btnActionPerformed(java.awt.event.ActionEvent evt) {
        FirstLevelGUI x = new FirstLevelGUI();
        x.setVisible(true);
        this.dispose();

    }

    public void repopulateData(){
        firstName_txt.setText(info.getFirstName());
        lastName_txt.setText(info.getLastName());
        email_txt.setText(info.getEmail());
        username_txt.setText(InfoAndPass.getUsername());
    }
    
    public boolean validateEmail(String e1) {
        boolean valid;
        String regex = "^(.*)@(.*)\\.(.*)$";
        
        //initialize the Pattern object
        Pattern pattern = Pattern.compile(regex);

       //searching for occurrences of regex
        Matcher matcher = pattern.matcher(e1);
        
        if (matcher.matches()) {
            valid = true;
        } else {
            valid = false;
        }
        return valid;
     }

    public static void main(String args[]) {


		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ClientInfo().setVisible(true);
			}
		});


	}


}
