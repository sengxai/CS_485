package registrationForm;

import javax.swing.*;
import java.awt.*;

/**
 *Author: Marcelo Telleria
 *Date: 9/4/2020
 *Description: This is the first level.
 */

public class CreateTextPass extends javax.swing.JFrame {

    // Here we declare our variables
    private javax.swing.JLabel cnfrmpswd_lbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton proceed_btn;
    private javax.swing.JLabel pswd_lbl;
    private javax.swing.JPasswordField pswd_txt;
    private javax.swing.JPasswordField pswdcnfrm_txt;
    private javax.swing.JLabel requirements_lbl;
    private javax.swing.JTextArea requirements_txtarea;
    private javax.swing.JLabel title_lbl;
    private javax.swing.JLabel bg_lbl;
    private javax.swing.JPanel panel;
    private javax.swing.JButton back_btn;
    // End of variables declaration

    boolean backbtn = false;

    /**
     * Creates FirstLevel GUI
     */
    public CreateTextPass() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2,size.height/2 - getHeight()/2);
    }


    public boolean passwordIsValid(String password, String confirmPassword, int pswdLength){

        //We create our boolean variables. All of these have to be true in order to make a password valid.
        boolean hasEightCharacters = false;
        boolean hasUpperCaseLetter = false;
        boolean hasOneNumber = false;
        boolean hasSpecialCharacter = false;
        boolean passwordIsValid = false;

        char[] passChar = new char [pswdLength];
        String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";


        if(password.equals(confirmPassword)){//First check if both text fields match in order to proceed to checking for requirements

            for(int i = 0; i < pswdLength; i++){
                passChar[i] = password.charAt(i);//This copies the password character by character and stores it in passChar so we can check character by character

                if(pswdLength >= 8){
                    hasEightCharacters = true;
                }

                if(Character.isDigit(passChar[i])){//Check if password has a number
                    hasOneNumber = true;
                }
                if(Character.isUpperCase(passChar[i])){//Check if password has an uppercase letter
                    hasUpperCaseLetter = true;
                }
                if(specialCharactersString.contains(Character.toString(passChar[i]))){//Check if password has special characters
                    hasSpecialCharacter = true;
                }

                if(hasEightCharacters && hasOneNumber && hasSpecialCharacter && hasUpperCaseLetter){//If password has all the requirements then grant access to next step.
                    passwordIsValid = true;
                }
            }

            //System.out.println(hasEightCharacters + " " + hasOneNumber + " " + hasSpecialCharacter + " " + hasUpperCaseLetter);
        }


        return passwordIsValid;
    }


    private void initComponents() {

        title_lbl = new javax.swing.JLabel();
        cnfrmpswd_lbl = new javax.swing.JLabel();
        pswdcnfrm_txt = new javax.swing.JPasswordField();
        pswd_txt = new javax.swing.JPasswordField();
        pswd_lbl = new javax.swing.JLabel();
        requirements_lbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        requirements_txtarea = new javax.swing.JTextArea();
        proceed_btn = new javax.swing.JButton();
        bg_lbl = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        back_btn = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panel.setPreferredSize(new java.awt.Dimension(500, 500));
        panel.setLayout(null);

        proceed_btn.setFont(new java.awt.Font("Tahoma", 1, 14));
        proceed_btn.setText("Next");
        proceed_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceed_btnActionPerformed(evt);
            }
        });
        panel.add(proceed_btn);
        proceed_btn.setBounds(220, 400, 170, 40);

        requirements_txtarea.setEditable(false);
        requirements_txtarea.setColumns(20);
        requirements_txtarea.setFont(new java.awt.Font("Monospaced", 1, 13));
        requirements_txtarea.setLineWrap(true);
        requirements_txtarea.setRows(5);
        requirements_txtarea.setText("*8 character minimum\n*1 uppercase letter\n*1 number\n*1 special character\n(!@$#%*-+)\n");
        requirements_txtarea.setWrapStyleWord(true);
        requirements_txtarea.setAutoscrolls(false);
        requirements_txtarea.setEnabled(false);
        requirements_txtarea.setOpaque(false);
        jScrollPane1.setViewportView(requirements_txtarea);

        panel.add(jScrollPane1);
        jScrollPane1.setBounds(190, 150, 230, 120);

        requirements_lbl.setFont(new java.awt.Font("Tahoma", 1, 14));
        requirements_lbl.setForeground(new java.awt.Color(255, 255, 255));
        requirements_lbl.setText("Requirements:");
        panel.add(requirements_lbl);
        requirements_lbl.setBounds(80, 150, 101, 17);

        pswd_lbl.setBackground(new java.awt.Color(0, 0, 0));
        pswd_lbl.setFont(new java.awt.Font("Tahoma", 1, 14));
        pswd_lbl.setForeground(java.awt.Color.white);
        pswd_lbl.setText("Create Password:");
        panel.add(pswd_lbl);
        pswd_lbl.setBounds(50, 290, 130, 30);
        panel.add(pswd_txt);
        pswd_txt.setBounds(190, 290, 230, 30);
        panel.add(pswdcnfrm_txt);
        pswdcnfrm_txt.setBounds(190, 340, 230, 30);

        cnfrmpswd_lbl.setBackground(new java.awt.Color(255, 255, 255));
        cnfrmpswd_lbl.setFont(new java.awt.Font("Tahoma", 1, 14));
        cnfrmpswd_lbl.setForeground(java.awt.Color.white);
        cnfrmpswd_lbl.setText("Confirm Password:");
        panel.add(cnfrmpswd_lbl);
        cnfrmpswd_lbl.setBounds(40, 340, 140, 30);

        title_lbl.setBackground(new java.awt.Color(255, 255, 255));
        title_lbl.setFont(new java.awt.Font("Tahoma", 1, 24));
        title_lbl.setForeground(java.awt.Color.white);
        title_lbl.setText("Create Text-Based Password");
        panel.add(title_lbl);
        title_lbl.setBounds(80, 50, 370, 29);

        back_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        back_btn.setText("Go Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });
        panel.add(back_btn);
        back_btn.setBounds(240, 450, 130, 30);

        bg_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/createpass.jpg")));
        panel.add(bg_lbl);
        bg_lbl.setBounds(0, 0, 500, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        repopulateData();
    }

    private void proceed_btnActionPerformed(java.awt.event.ActionEvent evt) {

        String password = String.valueOf(pswd_txt.getPassword());
        String confirmPassword = String.valueOf(pswdcnfrm_txt.getPassword());
        int passwordLength = password.length();

        //If both text fields are empty, throw an error message.
        if(password.isEmpty() || confirmPassword.isEmpty()){
            JOptionPane.showMessageDialog(null, "There cannot be empty text fields.");
        }else {//if both text fields are filled and they met the requirements and they match, proceed to level 2/

            //first we compare both password and confirm password to see if they match, if they do, proceed to check for requirements
            boolean passwordIsValid = passwordIsValid(password, confirmPassword, passwordLength);

            if(passwordIsValid){
            	ClientInfo.info.setTextPass(password);
                //JOptionPane.showMessageDialog(null, "Password passed all the tests");
                SecondLevel second = new SecondLevel();
                this.dispose();
                second.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "The password you entered does not match and/or meet all the requirements. Try again!");
            }

        }

    }

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {
        ClientInfo x = new ClientInfo();
        x.setVisible(true);
        this.dispose();

    }

    public void repopulateData(){
        pswd_txt.setText(ClientInfo.info.getTextPass());
        pswdcnfrm_txt.setText(ClientInfo.info.getTextPass());
    }


	public static void main(String args[]) {


		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CreateTextPass().setVisible(true);


			}
		});
	}


}
