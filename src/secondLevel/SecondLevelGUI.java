package secondLevel;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.*;
import javax.swing.Timer;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import thirdLevel.ThirdLevelGUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import DataBaseConnection.DataBase;
import registrationForm.InfoAndPass;

public class SecondLevelGUI extends javax.swing.JFrame {

	// Variables declaration
	private ArrayList<JButton> ButtonArray = new ArrayList<>();

	private javax.swing.JButton btn_1;
	private javax.swing.JButton btn_2;
	private javax.swing.JButton btn_3;
	private javax.swing.JButton btn_4;
	private javax.swing.JButton btn_5;
	private javax.swing.JButton btn_6;
	private javax.swing.JButton btn_7;
	private javax.swing.JButton btn_8;
	private javax.swing.JButton btn_9;

    private javax.swing.JButton clear_btn;

	private javax.swing.JLabel bg_lbl;
	private javax.swing.JPanel panel;
	private javax.swing.JButton instructions;
	private javax.swing.JButton proceed_btn;
	private javax.swing.JLabel title_lbl1;
	private javax.swing.JPasswordField pswd_txt;
	private javax.swing.JLabel email_btn;

	public String sqlpassword = "";

	public SecondLevelGUI() {
		initComponents();
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2,size.height/2 - getHeight()/2);
	}

	private void initComponents() {

//Buttons declaration
		title_lbl1 = new javax.swing.JLabel();
		pswd_txt = new javax.swing.JPasswordField();
		proceed_btn = new javax.swing.JButton("Proceed");
		instructions = new javax.swing.JButton();

		btn_1 = new javax.swing.JButton();
		btn_2 = new javax.swing.JButton();
		btn_3 = new javax.swing.JButton();
		btn_4 = new javax.swing.JButton();
		btn_5 = new javax.swing.JButton();
		btn_6 = new javax.swing.JButton();
		btn_7 = new javax.swing.JButton();
		btn_8 = new javax.swing.JButton();
		btn_9 = new javax.swing.JButton();
		email_btn = new javax.swing.JLabel();

		ButtonArray.add(btn_1);
		ButtonArray.add(btn_2);
		ButtonArray.add(btn_3);
		ButtonArray.add(btn_4);
		ButtonArray.add(btn_5);
		ButtonArray.add(btn_6);
		ButtonArray.add(btn_7);
		ButtonArray.add(btn_8);
		ButtonArray.add(btn_9);

        clear_btn = new javax.swing.JButton();

		panel = new javax.swing.JPanel();
		bg_lbl = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new java.awt.Dimension(500, 500));
		setResizable(false);

		panel.setPreferredSize(new java.awt.Dimension(500, 500));
		panel.setLayout(null);

		instructions.setFont(new java.awt.Font("Tahoma", 1, 14));
		instructions.setText("Help");
		instructions.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				instructionsActionPerformed(evt);
			}
		});
		panel.add(instructions);
		instructions.setBounds(30, 390, 110, 30);//button

		title_lbl1.setFont(new java.awt.Font("Tahoma", 1, 24));
		title_lbl1.setForeground(new java.awt.Color(255, 255, 255));
		title_lbl1.setText("Level 2: Image-based password");
		panel.add(title_lbl1);//*
		title_lbl1.setBounds(60, 20, 380, 29);

		proceed_btn.setFont(new java.awt.Font("Tahoma", 1, 14));
		proceed_btn.setText("Next");

		panel.add(proceed_btn);//*
		proceed_btn.setBounds(160, 390, 180, 34);

		clear_btn.setFont(new java.awt.Font("Tahoma", 1, 14));
		clear_btn.setText("Clear");
		panel.add(clear_btn);
		clear_btn.setBounds(180, 430, 140, 34);

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
                    String imagePass = rs.getString("IMAGEPASS");
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
				

		panel.add(btn_1);
		panel.add(btn_2);
		panel.add(btn_3);
		panel.add(btn_4);
		panel.add(btn_5);
		panel.add(btn_6);
		panel.add(btn_7);
		panel.add(btn_8);
		panel.add(btn_9);

		bg_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/level2.jpg"))); //*
		panel.add(bg_lbl);
		bg_lbl.setBounds(0, 0, 500, 500);

		addImages();

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

			ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				JButton button = (JButton) ev.getSource();
				String password = String.valueOf(pswd_txt.getPassword());
				pswd_txt.setText(password + button.getText());
				//Each button press creates edits a part of the string, which will be used to cross-reference the string pulled from the SQL server

				if(button == btn_1)
				{
					btn_1.setEnabled(false);
					sqlpassword += btn_1.getText()+",";
				}
				else if(button == btn_2)
				{
					btn_2.setEnabled(false);
					sqlpassword += btn_2.getText()+",";
				}
				else if(button == btn_3)
				{
					btn_3.setEnabled(false);
					sqlpassword += btn_3.getText()+",";
				}
				else if(button == btn_4)
				{
					btn_4.setEnabled(false);
					sqlpassword += btn_4.getText()+",";
				}
				else if(button == btn_5)
				{
					btn_5.setEnabled(false);
					sqlpassword += btn_5.getText()+",";
				}
				else if(button == btn_6)
				{
					btn_6.setEnabled(false);
					sqlpassword +=btn_6.getText()+",";
				}
				else if(button == btn_7)
				{
					btn_7.setEnabled(false);
					sqlpassword += btn_7.getText()+",";
				}
				else if(button == btn_8)
				{
					btn_8.setEnabled(false);
					sqlpassword += btn_8.getText()+",";
				}
				else if(button == btn_9)
				{
					btn_9.setEnabled(false);
					sqlpassword +=btn_9.getText()+",";
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

		pswd_txt.setVisible(false);

		int delay = 30000; //this is in milliseconds

		/***Renables button when the countdown is done ***/
		Timer timer = new Timer(delay, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				proceed_btn.setEnabled(true);
			}
		});

		proceed_btn.addActionListener(new ActionListener() {

			int tries = 0;
			int maxTries = 3;

			@Override
			public void actionPerformed(ActionEvent ev) {

				if (tries < maxTries) {
					timer.stop();

					String username = InfoAndPass.getUsername();
					sqlpassword = removeLastChar(sqlpassword);
					//System.out.println("I clicked these buttons in this order "+sqlpassword);
					//password string is built locally and cross-referenced with the one pulled from the sql server

					try {
						Connection connection = DataBase.java_db();

						assert connection != null;
						PreparedStatement statement = (PreparedStatement) connection
								.prepareStatement("SELECT username,imagePass FROM users WHERE username=?");

						statement.setString(1, username);
						ResultSet rs = statement.executeQuery();

						rs.next();
						String PasswordPulledFromSQL = rs.getString("IMAGEPASS");

						Vector<String> SQLPasswordSplit = splitStrings(PasswordPulledFromSQL, ',');
						Vector<String> InputtedPassword = splitStrings(sqlpassword, ',');

						Collections.sort(SQLPasswordSplit);
						Collections.sort(InputtedPassword);

						//Query is executed and the password is compared
						if (InputtedPassword.equals(SQLPasswordSplit)) {

							dispose();
							dispose();
							connection.close();
							rs.close();
							ThirdLevelGUI tlg = new ThirdLevelGUI();
							tlg.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(proceed_btn, "Wrong Password");
						}
					} catch (SQLException sqlException) {
						sqlException.printStackTrace();
					}

				} else {
					proceed_btn.setEnabled(false);
					JOptionPane.showMessageDialog(proceed_btn, "You have exceeded 3 tries. Please wait 30 seeconds.");

					timer.start();
					//so whenever it starts over again it will be at 0 tries
					tries = -1;
				}
				//tries increments on number of unsuccessful tries
				tries = tries + 1;
				//System.out.println(tries);
			}
		});

        clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

				btn_1.setEnabled(true);
				btn_2.setEnabled(true);
				btn_3.setEnabled(true);
				btn_4.setEnabled(true);
				btn_5.setEnabled(true);
				btn_6.setEnabled(true);
				btn_7.setEnabled(true);
				btn_8.setEnabled(true);
				btn_9.setEnabled(true);

				sqlpassword = "";

				JOptionPane.showMessageDialog(null,"Password Has Been Cleared");
            }
        });
	}

	private void instructionsActionPerformed(java.awt.event.ActionEvent evt){

		JOptionPane.showMessageDialog(null, "Click on the images that you have selected during Registration");
	}

	static Vector<String> splitStrings(String str, char dl)
	{
		String word = "";
		str = str + dl;
		int l = str.length();
		Vector<String> substr_list = new Vector<String>();
		for (int i = 0; i < l; i++)
		{
			if (str.charAt(i) != dl)
			{
				word = word + str.charAt(i);
			}
			else
			{
				if ((int) word.length() != 0)
				{
					substr_list.add(word);
				}
				word = "";
			}
		}

		return substr_list;
	}

	private void swapImagesAndText(List<String> imagesUsed) {

		String username = InfoAndPass.getUsername();

		try {
			Connection connection = DataBase.java_db();

			assert connection != null;
			PreparedStatement statement = (PreparedStatement) connection
					.prepareStatement("SELECT imagePass FROM users WHERE username=?");

			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();

			//Query is executed and the password is compared
			if (rs.next()) {

				String resultImagePassword = rs.getString("IMAGEPASS");
				Vector<String> splitPasssword = splitStrings(resultImagePassword, ',');

				String ImagePass1 = splitPasssword.get(0);
				String ImagePass2 = splitPasssword.get(1);
				String ImagePass3 = splitPasssword.get(2);
				String ImagePass4="";
				String ImagePass5 = "";
				if(splitPasssword.size() == 4)
				{
					ImagePass4 = splitPasssword.get(3);
				}
				else
				{
					ImagePass4 = "";
				}
				if(splitPasssword.size() == 5)
				{
					ImagePass5 = splitPasssword.get(4);
				}
				else
				{
					ImagePass5 = "";
				}

				int ButtonMax = 8;
				int ButtonMin = 0;

				Random rand = new Random();

				String Category="";

				if (ImagePass1.contains("Animal")) {
					Category = "Animal";
				} else if (ImagePass1.contains("Flower")) {
					Category = "Flower";
				} else if (ImagePass1.contains("Sport")) {
					Category = "Sport";
				} else if (ImagePass1.contains("Vehicle")) {
					Category = "Vehicle";
				}

				//System.out.println("The images used before swap are " + imagesUsed);
				//System.out.println("The Buttons Used are ");

				//System.out.println("Images used for the pass words are " + splitPasssword);

				//System.out.println("ImagePass1 " + ImagePass1);
				//System.out.println("ImagePass2 " + ImagePass2);
				//System.out.println("ImagePass3 " + ImagePass3);
				//System.out.println("ImagePass4 " + ImagePass4);
				//System.out.println("ImagePass5 " + ImagePass5);

				//System.out.println("Image Pass 1 Present? " + imagesUsed.contains(ImagePass1));
				//System.out.println("Image Pass 2 Present? " + imagesUsed.contains(ImagePass2));
				//System.out.println("Image Pass 3 Present? " + imagesUsed.contains(ImagePass3));
				//System.out.println("Image Pass 4 Present? " + imagesUsed.contains(ImagePass4));
				//System.out.println("Image Pass 5 Present? " + imagesUsed.contains(ImagePass5));

				//System.out.println("Current Category in Swap " + Category+"s");

				List<Integer> ButtonsUsed = new ArrayList<Integer>();

                int RandomButtonNumber  = rand.nextInt((ButtonMax - ButtonMin) + 1) + ButtonMin;;

					if(!imagesUsed.contains(ImagePass1)
							&& !ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass2)
							&& !ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass3)
							&& !ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass4)
							&& !ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass5)) {
						ButtonsUsed.add(RandomButtonNumber);
						try {
							String numberOnly= ImagePass1.replaceAll("[^0-9]", "");
							addimagesfromserver(Category, numberOnly, ButtonArray.get(RandomButtonNumber));
							//System.out.println("Button 1: "+ButtonArray.get(RandomButtonNumber).getText());

							if(!ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass1))
							{
								 numberOnly= ImagePass1.replaceAll("[^0-9]", "");
								addimagesfromserver(Category, numberOnly, ButtonArray.get(RandomButtonNumber));
							}

						} catch (Exception ex) {
							System.out.println("Swap 1 Failure");
						}
					}
				while (ButtonsUsed.contains(RandomButtonNumber)) {
					RandomButtonNumber = rand.nextInt((ButtonMax - ButtonMin) + 1) + ButtonMin;
				}
				ButtonsUsed.add(RandomButtonNumber);

				if(!imagesUsed.contains(ImagePass2)
						&& !ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass1)
						&& !ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass3)
						&& !ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass4)
						&& !ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass5)) {
					try {
						String numberOnly= ImagePass2.replaceAll("[^0-9]", "");
						addimagesfromserver(Category, numberOnly, ButtonArray.get(RandomButtonNumber));
						//System.out.println("Button 2: "+ButtonArray.get(RandomButtonNumber).getText());
						if(!ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass2))
						{
							 numberOnly= ImagePass1.replaceAll("[^0-9]", "");
							addimagesfromserver(Category, numberOnly, ButtonArray.get(RandomButtonNumber));
						}
					} catch (Exception ex) {
						System.out.println("Swap 2 Failure");
					}
				}
				while (ButtonsUsed.contains(RandomButtonNumber)) {
					RandomButtonNumber = rand.nextInt((ButtonMax - ButtonMin) + 1) + ButtonMin;
				}
				ButtonsUsed.add(RandomButtonNumber);

				if(!imagesUsed.contains(ImagePass3)
						&& !ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass2)
						&& !ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass1)
						&& !ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass4)
						&& !ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass5)) {
					try {
						String numberOnly= ImagePass3.replaceAll("[^0-9]", "");
						addimagesfromserver(Category, numberOnly, ButtonArray.get(RandomButtonNumber));
						//System.out.println("Button 3: "+ButtonArray.get(RandomButtonNumber).getText());
						if(!ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass3))
						{
							numberOnly= ImagePass3.replaceAll("[^0-9]", "");
							addimagesfromserver(Category, numberOnly, ButtonArray.get(RandomButtonNumber));
						}
					} catch (Exception ex) {
						System.out.println("Swap 3 Failure");
					}
				}
				while (ButtonsUsed.contains(RandomButtonNumber)) {
					RandomButtonNumber = rand.nextInt((ButtonMax - ButtonMin) + 1) + ButtonMin;
				}
				ButtonsUsed.add(RandomButtonNumber);

				if(!imagesUsed.contains(ImagePass4) && !ImagePass4.equals("")
						&& !ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass2)
						&& !ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass3)
						&& !ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass1)
						&& !ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass5)) {
					try {
						String numberOnly= ImagePass4.replaceAll("[^0-9]", "");
						addimagesfromserver(Category, numberOnly, ButtonArray.get(RandomButtonNumber));
						//System.out.println("Button 4: "+ButtonArray.get(RandomButtonNumber).getText());

						if(!ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass4))
						{
							numberOnly= ImagePass4.replaceAll("[^0-9]", "");
							addimagesfromserver(Category, numberOnly, ButtonArray.get(RandomButtonNumber));
						}

					} catch (Exception ex) {
						System.out.println("Swap 4 Failure");
					}
				}
				while (ButtonsUsed.contains(RandomButtonNumber)) {
					RandomButtonNumber = rand.nextInt((ButtonMax - ButtonMin) + 1) + ButtonMin;
				}
				ButtonsUsed.add(RandomButtonNumber);

				if(!imagesUsed.contains(ImagePass5) && !ImagePass5.equals("")
						&& !ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass1)
						&& !ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass2)
						&& !ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass3)
						&& !ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass4)) {
					while (ButtonsUsed.contains(RandomButtonNumber)) {
						RandomButtonNumber = rand.nextInt((ButtonMax - ButtonMin) + 1) + ButtonMin;
					}
					ButtonsUsed.add(RandomButtonNumber);

					try {
						String numberOnly= ImagePass5.replaceAll("[^0-9]", "");
						addimagesfromserver(Category, numberOnly, ButtonArray.get(RandomButtonNumber));
						//System.out.println("Button 5: "+ButtonArray.get(RandomButtonNumber).getText());
						if(!ButtonArray.get(RandomButtonNumber).getText().equals(ImagePass5))
						{
							numberOnly= ImagePass4.replaceAll("[^0-9]", "");
							addimagesfromserver(Category, numberOnly, ButtonArray.get(RandomButtonNumber));
						}
					} catch (Exception ex) {
						System.out.println("Swap 5 Failure");
					}
				}
				//System.out.println("The buttons that got their images and values swapped "+ButtonsUsed);
				connection.close();
				rs.close();
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}//End of Swapimagesandtext

	private void addImages ()
	{
		int CatMax =4;
		int CatMin =1;

		int ImageMax = 9;
		int ImageMin = 1;

		Random rand = new Random();

		int RandomPictureNumber = 0;

		int[] pictureNumbers  = new int[9];
		List<String> list = new ArrayList<String>();

		for(int i = 0; i<9; i++)
		{
			RandomPictureNumber = rand.nextInt( (ImageMax - ImageMin)+1) + ImageMin;
			pictureNumbers[i] = RandomPictureNumber;
		}

		int categoryNumber;
		String category="";

		categoryNumber = rand.nextInt((CatMax - CatMin) + 1) + CatMin;
		//System.out.println("Category Number 1 Random is: " + categoryNumber );
		
		//Button1 Picture
	category = categorySelector(category,categoryNumber);
			while(list.contains(category+pictureNumbers[0])) {
				pictureNumbers[0] = rand.nextInt((ImageMax - ImageMin) + 1) + ImageMin;
			}
			list.add(category+pictureNumbers[0]);
			try {
				String picturenumber = pictureNumbers[0]+"";
				addimagesfromserver(category,picturenumber,btn_1);
				btn_1.setBounds(310, 290, 98, 90);
			} catch (Exception ex) {
				System.out.println("failure");
			}

		categoryNumber = rand.nextInt((CatMax - CatMin) + 1) + CatMin;
		//System.out.println("\nCategory Number 2 Random is: " + categoryNumber );
		//System.out.println("Picture Number is (1-9): "+pictureNumbers[1]);
		//Button2 Picture
		category = categorySelector(category,categoryNumber);

		while(list.contains(category+pictureNumbers[1])) {
			pictureNumbers[1] = rand.nextInt((ImageMax - ImageMin) + 1) + ImageMin;
		}
		list.add(category+pictureNumbers[1]);
		try {
			String picturenumber = pictureNumbers[1]+"";
			addimagesfromserver(category,picturenumber,btn_2);
			btn_2.setBounds(310, 190, 98, 90);
		} catch (Exception ex) {
			System.out.println("failure");
		}


		categoryNumber = rand.nextInt((CatMax - CatMin) + 1) + CatMin;
		//System.out.println("\nCategory Number 3 Random is: " + categoryNumber );
		//System.out.println("Picture Number is (1-9): "+pictureNumbers[2]);
		//Button3 Picture
		btn_3.setBounds(310, 90, 98, 90);
		category = categorySelector(category,categoryNumber);

		while(list.contains(category+pictureNumbers[2])) {
			pictureNumbers[2] = rand.nextInt((ImageMax - ImageMin) + 1) + ImageMin;
		}
		list.add(category+pictureNumbers[2]);
		try {
			String picturenumber = pictureNumbers[2]+"";
			addimagesfromserver(category,picturenumber,btn_3);
			btn_3.setBounds(310, 90, 98, 90);
		} catch (Exception ex) {
			System.out.println("failure");
		}

		categoryNumber = rand.nextInt((CatMax - CatMin) + 1) + CatMin;
		//System.out.println("\nCategory Number 4 Random is: " + categoryNumber );
		//System.out.println("Picture Number is (1-9): "+pictureNumbers[3]);
		//Button4 Picture
		category = categorySelector(category,categoryNumber);

		while(list.contains(category+pictureNumbers[3])) {
			pictureNumbers[3] = rand.nextInt((ImageMax - ImageMin) + 1) + ImageMin;
		}
		list.add(category+pictureNumbers[3]);
		try {
			String picturenumber = pictureNumbers[3]+"";
			addimagesfromserver(category,picturenumber,btn_4);
			btn_4.setBounds(200, 290, 98, 90);
		} catch (Exception ex) {
			System.out.println("failure");
		}


		categoryNumber = rand.nextInt((CatMax - CatMin) + 1) + CatMin;
		//System.out.println("\nCategory Number 5 Random is: " + categoryNumber );
		//System.out.println("Picture Number is (1-9): "+pictureNumbers[4]);
		//Button5 Picture
		category = categorySelector(category,categoryNumber);
		while(list.contains(category+pictureNumbers[4])) {
			pictureNumbers[4] = rand.nextInt((ImageMax - ImageMin) + 1) + ImageMin;
		}
		list.add(category+pictureNumbers[4]);
		try {
			String picturenumber = pictureNumbers[4]+"";
			addimagesfromserver(category,picturenumber,btn_5);
			btn_5.setBounds(90, 290, 98, 90);
		} catch (Exception ex) {
			System.out.println("failure");
		}

		categoryNumber = rand.nextInt((CatMax - CatMin) + 1) + CatMin;
		//System.out.println("\nCategory Number 6 Random is: " + categoryNumber );
		//System.out.println("Picture Number is (1-9): "+pictureNumbers[5]);
		//Button6 Picture

		category = categorySelector(category,categoryNumber);
		while(list.contains(category+pictureNumbers[5])) {
			pictureNumbers[5] = rand.nextInt((ImageMax - ImageMin) + 1) + ImageMin;
		}
		list.add(category+pictureNumbers[5]);
		try {
			String picturenumber = pictureNumbers[5]+"";
			addimagesfromserver(category,picturenumber,btn_6);
			btn_6.setBounds(90, 190, 98, 90);
		} catch (Exception ex) {
			System.out.println("failure");
		}

		categoryNumber = rand.nextInt((CatMax - CatMin) + 1) + CatMin;
		//System.out.println("\nCategory Number 7 Random is: " + categoryNumber );
		//System.out.println("Picture Number is (1-9): "+pictureNumbers[6]);
		//Button7 Picture

		category = categorySelector(category,categoryNumber);
		while(list.contains(category+pictureNumbers[6])) {
			pictureNumbers[6] = rand.nextInt((ImageMax - ImageMin) + 1) + ImageMin;
		}
		list.add(category+pictureNumbers[6]);
		try {
			String picturenumber = pictureNumbers[6]+"";
			addimagesfromserver(category,picturenumber,btn_7);
			btn_7.setBounds(200, 190, 98, 90);
		} catch (Exception ex) {
			System.out.println("failure");
		}

		categoryNumber = rand.nextInt((CatMax - CatMin) + 1) + CatMin;
		//System.out.println("\nCategory Number 8 Random is: " + categoryNumber );
	//	System.out.println("Picture Number is (1-9): "+pictureNumbers[7]);
		//Button8 Picture

		category = categorySelector(category,categoryNumber);
		while(list.contains(category+pictureNumbers[7])) {
			pictureNumbers[7] = rand.nextInt((ImageMax - ImageMin) + 1) + ImageMin;
		}
		list.add(category+pictureNumbers[7]);
		try {
			String picturenumber = pictureNumbers[7]+"";
			addimagesfromserver(category,picturenumber,btn_8);
			btn_8.setBounds(200, 90, 98, 90);
		} catch (Exception ex) {
			System.out.println("failure");
		}

		categoryNumber = rand.nextInt((CatMax - CatMin) + 1) + CatMin;
		//System.out.println("\nCategory Number 9 Random is: " + categoryNumber );

		//Button9 Picture

		category = categorySelector(category,categoryNumber);
		while(list.contains(category+pictureNumbers[8])) {
			pictureNumbers[8] = rand.nextInt((ImageMax - ImageMin) + 1) + ImageMin;
		}
		list.add(category+pictureNumbers[8]);
		try {
			String picturenumber = pictureNumbers[8]+"";
			addimagesfromserver(category,picturenumber,btn_9);
			btn_9.setBounds(90, 90, 98, 90);
		} catch (Exception ex) {
			System.out.println("failure");
		}
		swapImagesAndText(list);
	}
	public static String removeLastChar(String str) {
		return removeLastChars(str, 1);
	}

	public static String removeLastChars(String str, int chars) {
		return str.substring(0, str.length() - chars);
	}

	private void addimagesfromserver(String category, String picturenumber, JButton button) {
		try {
			String sql = "Select * from level2 where id=?";
			Connection conn = DataBase.java_db();
			PreparedStatement pst;
			ResultSet rs;

			pst = conn.prepareStatement(sql);
			pst.setString(1, picturenumber);
			rs = pst.executeQuery();

			if (rs.next()) {
				byte[] image = rs.getBytes(category+"s");
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH));
				button.setIcon(imageIcon);
				button.setText(category+picturenumber);
			}
			rs.close();
			pst.close();
			conn.close();
		}
		catch (SQLException e) {
			System.out.println("Adding image failure");
		}
	}

    public void sendMail(String firstname, String recipient, String password, JLabel email_btn2) {
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
            message.setSubject("Forgotten Image Password");
            
            // This mail has 2 part, the BODY and the embedded image
            MimeMultipart multipart = new MimeMultipart("related");
            
            // first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            
            String noComma = password.replaceAll(",", "");
            String noNum = noComma.replaceAll("[0-9]", " ");
            
            noNum = Arrays.stream( noNum.split("\\s+")).distinct().collect(Collectors.joining(" ") );
            String onlyNum = noComma.replaceAll(noNum, "");
            StringBuilder html = new StringBuilder("<p>Hi "+firstname+",</p><p>Your image password is:</p>");

            if (onlyNum != null) {
            	for (int i = 0; i < onlyNum.length(); i++){
    	            char c = onlyNum.charAt(i);
    	            String number = Character.toString(c);
    	            
    	            try {
       		            String sql = "Select * from level2 where id=?";  
       		            Connection conn = DataBase.java_db();
       		            PreparedStatement pst;
       		            ResultSet rs;
       		            
       		        	pst=conn.prepareStatement(sql);
       					pst.setString(1,number);
       					rs=pst.executeQuery();
       					
    					if (rs.next ()) {
    	   		            byte[] image = rs.getBytes(noNum+"s");
    						ByteArrayInputStream bis = new ByteArrayInputStream(image);
    						BufferedImage bImage2 = ImageIO.read(bis);
    						File newFile = new File("src/Images/"+noNum+number+".jpg");
    						ImageIO.write(bImage2, "jpg", newFile);
    						html.append("<img src=\"cid:" + noNum+number + "\" width=\"100\" height=\"100\"/>");
       		            }  					
       					rs.close();
       					pst.close();
       					conn.close();
    	           }catch(Exception e) {
    	            	
    	           }
            	}
            }
            html.append("<br><p>3LA Admin</p>");
            String html2 = html.toString();
            messageBodyPart.setContent(html2, "text/html");
            // add it
            multipart.addBodyPart(messageBodyPart);            

            if (onlyNum != null) {
            	for (int i = 0; i < onlyNum.length(); i++){
    	            char c = onlyNum.charAt(i);
    	            String number = Character.toString(c);
    	            //System.out.println(noNum+number);
    	         // second part (the image)
    	            messageBodyPart = new MimeBodyPart();
    	    		File fi = new File("src/Images/"+noNum+number+".jpg");
    	    		String pass = fi.getAbsolutePath();
    	            DataSource fds = new FileDataSource(pass);
    	            messageBodyPart.setDataHandler(new DataHandler(fds));
    	            messageBodyPart.setHeader("Content-ID", "<"+noNum+number+">");
    	            messageBodyPart.setDisposition(MimeBodyPart.INLINE);
    	            
    	            // add image to the multipart
    	            multipart.addBodyPart(messageBodyPart);
            	}
            }
            
            // put everything together
            message.setContent(multipart);

            // Send message
            Transport.send(message);
            
            if (onlyNum != null) {
            	for (int i = 0; i < onlyNum.length(); i++){
    	            char c = onlyNum.charAt(i);
    	            String number = Character.toString(c);
    	    		File fi = new File("src/Images/"+noNum+number+".jpg");
    	    		//String pass = fi.getAbsolutePath();
    	    		if (fi.delete()) { 
    	    		      //System.out.println("Deleted the file: " + fi.getName());
    	    		} else {
    	    		      //System.out.println("Failed to delete the file.");
    	    		} 
    	            
            	}
            }
           
            JOptionPane.showMessageDialog(email_btn2, "Password Has Been Sent To Your Email!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
            JOptionPane.showMessageDialog(email_btn2, "Could Not Send Password");
        }
    }



    public String categorySelector(String category,int categoryNumber)
	{
		if(categoryNumber == 1) {
			category = "Animal";
		}
		else if(categoryNumber == 2)
		{
			category = "Flower";
		}
		else if(categoryNumber == 3)
		{
			category = "Sport";
		}
		else if(categoryNumber == 4)
		{
			category = "Vehicle";
		}
		return category;
	}
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new SecondLevelGUI().setVisible(true);
			}
		});
	}


}

