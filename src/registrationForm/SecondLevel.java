package registrationForm;
import javax.swing.*;
import DataBaseConnection.DataBase;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class SecondLevel extends javax.swing.JFrame {

	// Variables declaration
	private javax.swing.JButton boat_btn;
	private javax.swing.JButton car_btn;
	private javax.swing.JButton cat_btn;
	private javax.swing.JButton chair_btn;
	private javax.swing.JButton dog_btn;
	private javax.swing.JButton headphones_btn;
	private javax.swing.JButton keyboard_btn;
	private javax.swing.JButton monitor_btn;
	private javax.swing.JButton table_btn;
	private javax.swing.JButton clear_btn;

	private javax.swing.JLabel bg_lbl;
	private javax.swing.JPanel panel;
	private javax.swing.JComboBox<String> dropdown;

	private javax.swing.JButton proceed_btn;
	private javax.swing.JLabel title_lbl1;
	private javax.swing.JButton back_btn;
	private javax.swing.JButton instructions;
	private String sendtoSQL = "";

	private int NumberOfButtonPress = 0;

	public SecondLevel() {
		initComponents();
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
	}
	private void initComponents() {

		title_lbl1 = new javax.swing.JLabel();
		proceed_btn = new javax.swing.JButton("Proceed");
		dropdown = new javax.swing.JComboBox<>();

		headphones_btn = new javax.swing.JButton();  //1
		chair_btn = new javax.swing.JButton(); //2
		dog_btn = new javax.swing.JButton(); //3
		keyboard_btn = new javax.swing.JButton(); //4
		cat_btn = new javax.swing.JButton(); //5
		table_btn = new javax.swing.JButton(); //6
		boat_btn = new javax.swing.JButton(); //7
		car_btn = new javax.swing.JButton(); //8
		monitor_btn = new javax.swing.JButton(); //9
		instructions = new javax.swing.JButton();
		back_btn = new javax.swing.JButton();
		clear_btn = new javax.swing.JButton();
		panel = new javax.swing.JPanel();
		bg_lbl = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new java.awt.Dimension(500, 500));
		setResizable(false);

		instructions.setFont(new java.awt.Font("Tahoma", 1, 14));
		instructions.setText("Help");
		instructions.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				instructionsActionPerformed(evt);
			}
		});
		instructions.setBounds(30, 430, 110, 30);//button
		panel.add(instructions);

		panel.setPreferredSize(new java.awt.Dimension(500, 500));
		panel.setLayout(null);

		dropdown.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{ "Animals", "Flowers", "Sports", "Vehicles"}));
		panel.add(dropdown);
		dropdown.setBounds(30, 390, 110, 30);

		title_lbl1.setFont(new java.awt.Font("Tahoma", 1, 24));
		title_lbl1.setForeground(new java.awt.Color(255, 255, 255));
		title_lbl1.setText("Create Image-based password");
		panel.add(title_lbl1);//*
		title_lbl1.setBounds(60, 20, 380, 29);

		panel.add(monitor_btn);
		panel.add(table_btn);
		panel.add(dog_btn);
		panel.add(car_btn);
		panel.add(boat_btn);
		panel.add(keyboard_btn);
		panel.add(cat_btn);
		panel.add(chair_btn);
		panel.add(headphones_btn);

		proceed_btn.setFont(new java.awt.Font("Tahoma", 1, 14));
		proceed_btn.setText("Next");

		panel.add(proceed_btn);//*
		proceed_btn.setBounds(160, 390, 180, 34);//*

		clear_btn.setFont(new java.awt.Font("Tahoma", 1, 14));
		clear_btn.setText("Clear");

		panel.add(clear_btn);
		clear_btn.setBounds(180, 430, 140, 34);

		back_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		back_btn.setText("Go Back");
		back_btn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				back_btnActionPerformed(evt);
			}
		});
		panel.add(back_btn);
		back_btn.setBounds(360, 390, 110, 30);

		bg_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/level2.jpg"))); //*
		panel.add(bg_lbl);
		bg_lbl.setBounds(0, 0, 500, 500);

		String category="Animal";
		addimagesaccordingtocategory(category);

		dropdown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String category = "";
				if (Objects.equals(dropdown.getSelectedItem(), "Animals")) {
					category="Animal";
				}
				else if (dropdown.getSelectedItem().toString().equals("Flowers")) {
					category = "Flower";
				} else if (dropdown.getSelectedItem().toString().equals("Vehicles")) {
					category = "Vehicle";
				}
				else if(dropdown.getSelectedItem().toString().equals("Sports")) {
					category="Sport";
				}
				addimagesaccordingtocategory(category);
			}
		});
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
		proceed_btn.setEnabled(false);

		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ev) {

				JButton button = (JButton) ev.getSource();

				//Ensures that the user selects at least 2 images during the password creation
				if (NumberOfButtonPress > 1 && NumberOfButtonPress < 5) {
					proceed_btn.setEnabled(true);
				} else {
					proceed_btn.setEnabled(false);
				}
				//Button presses builds a string that will be used as a password, which will be compared to the sql server
				if (button == monitor_btn) {
					monitor_btn.setEnabled(false);
					sendtoSQL += monitor_btn.getText()+",";
					dropdown.setEnabled(false);
					NumberOfButtonPress++;
				} else if (button == table_btn) {
					table_btn.setEnabled(false);
					sendtoSQL += table_btn.getText()+",";
					dropdown.setEnabled(false);
					NumberOfButtonPress++;
				} else if (button == dog_btn) {
					dog_btn.setEnabled(false);
					sendtoSQL += dog_btn.getText()+",";
					dropdown.setEnabled(false);
					NumberOfButtonPress++;
				} else if (button == car_btn) {
					car_btn.setEnabled(false);
					sendtoSQL += car_btn.getText()+",";
					dropdown.setEnabled(false);
					NumberOfButtonPress++;
				} else if (button == boat_btn) {
					boat_btn.setEnabled(false);
					sendtoSQL += boat_btn.getText()+",";
					dropdown.setEnabled(false);
					NumberOfButtonPress++;
				} else if (button == keyboard_btn) {
					keyboard_btn.setEnabled(false);
					sendtoSQL += keyboard_btn.getText()+",";
					dropdown.setEnabled(false);
					NumberOfButtonPress++;
				} else if (button == cat_btn) {
					cat_btn.setEnabled(false);
					sendtoSQL += cat_btn.getText()+",";
					dropdown.setEnabled(false);
					NumberOfButtonPress++;
				} else if (button == chair_btn) {
					chair_btn.setEnabled(false);
					sendtoSQL += chair_btn.getText()+",";
					dropdown.setEnabled(false);
					NumberOfButtonPress++;
				} else if (button == headphones_btn) {
					headphones_btn.setEnabled(false);
					sendtoSQL += headphones_btn.getText()+",";
					dropdown.setEnabled(false);
					NumberOfButtonPress++;
				}
			}
		};
		monitor_btn.addActionListener(al);
		table_btn.addActionListener(al);
		dog_btn.addActionListener(al);
		car_btn.addActionListener(al);
		boat_btn.addActionListener(al);
		keyboard_btn.addActionListener(al);
		cat_btn.addActionListener(al);
		chair_btn.addActionListener(al);
		headphones_btn.addActionListener(al);

		proceed_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				//Password is built locally and compared after

				if (sendtoSQL.endsWith(",") || sendtoSQL.endsWith(" ")) {
					sendtoSQL = removeLastChar(sendtoSQL);
				}
				if (sendtoSQL.startsWith(",") || sendtoSQL.startsWith(" ")) {
					sendtoSQL =sendtoSQL.substring(1);
				}
				//System.out.println(sendtoSQL);
				ClientInfo.info.setImagePass(sendtoSQL);
				ThirdLevel third = new ThirdLevel();
				dispose();
				third.setVisible(true);
			}
		});

	//Clear button
		clear_btn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				proceed_btn.setEnabled(false);
				NumberOfButtonPress = 0;
				dog_btn.setEnabled(true);
				chair_btn.setEnabled(true);
				headphones_btn.setEnabled(true);
				monitor_btn.setEnabled(true);
				cat_btn.setEnabled(true);
				keyboard_btn.setEnabled(true);
				boat_btn.setEnabled(true);
				table_btn.setEnabled(true);
				car_btn.setEnabled(true);
				dropdown.setEnabled(true);
				sendtoSQL = "";

				JOptionPane.showMessageDialog(null, "Password Has Been Cleared");
			}
		});
	}//END OF initComponents

	public static String removeLastChar(String str) {
		return removeLastChars(str, 1);
	}

	public static String removeLastChars(String str, int chars) {
		return str.substring(0, str.length() - chars);
	}

	private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {
		CreateTextPass x = new CreateTextPass();
		x.setVisible(true);
		this.dispose();
	}

	private void addimages(String category, String picturenumber, JButton button) {
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
				//System.out.println(button.getText());
			}
			rs.close();
			pst.close();
			conn.close();
		}
		catch (SQLException e) {
			System.out.println("Adding image failure");
		}
	}

public void addimagesaccordingtocategory(String category)
{
	try {
		addimages(category, "1", monitor_btn);
		monitor_btn.setBounds(310, 290, 98, 90);
	} catch (Exception ex) {
		System.out.println("failure");
	}
	//Table Button
	try {
		addimages(category, "2", table_btn);
		table_btn.setBounds(310, 190, 98, 90);//
	} catch (Exception ex) {
		System.out.println("failure");
	}
	//Dog Button
	try {
		addimages(category, "3", dog_btn);
		dog_btn.setBounds(310, 90, 98, 90);
	} catch (Exception ex) {
		System.out.println("failure");
	}
	//Car Button
	try {
		addimages(category, "4", car_btn);
		car_btn.setBounds(200, 290, 98, 90);
	} catch (Exception ex) {
		System.out.println("failure");
	}
	//Boat Button
	try {
		addimages(category, "5", boat_btn);
		boat_btn.setBounds(90, 290, 98, 90);
	} catch (Exception ex) {
		System.out.println("failure");
	}
	//Keyboard Button
	try {
		addimages(category, "6", keyboard_btn);
		keyboard_btn.setBounds(90, 190, 98, 90);
	} catch (Exception ex) {
		System.out.println("failure");
	}
	//Cat Button
	try {
		addimages(category, "7", cat_btn);
		cat_btn.setBounds(200, 190, 98, 90);
	} catch (Exception ex) {
		System.out.println("failure");
	}
	//Chair Button
	try {
		addimages(category, "8", chair_btn);
		chair_btn.setBounds(200, 90, 98, 90);
	} catch (Exception ex) {
		System.out.println("failure");
	}
	//Headphone Button
	try {
		addimages(category, "9", headphones_btn);
		headphones_btn.setBounds(90, 90, 98, 90);
	} catch (Exception ex) {
		System.out.println("failure");
	}
}
	private void instructionsActionPerformed(java.awt.event.ActionEvent evt){

		JOptionPane.showMessageDialog(null, "Image Password Requirements:\n"+
				"1. Must select a category.\n"+
				"2. Minimum of 3 images must selected.\n"+
				"3. Maximum limit 5 images may be selected.\n");
	}
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new SecondLevel().setVisible(true);
			}
		});
	}
}

