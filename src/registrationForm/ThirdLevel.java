package registrationForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ThirdLevel extends javax.swing.JFrame {

	// Variables declaration
	
	private javax.swing.JButton black_btn; 
	private javax.swing.JButton darkblue_btn;
	private javax.swing.JButton green_btn;
	private javax.swing.JButton lightblue_btn;
	private javax.swing.JButton orange_btn;
	private javax.swing.JButton pink_btn;
	private javax.swing.JButton proceed_btn;
	private javax.swing.JButton purple_btn;
	private javax.swing.JButton red_btn;
	private javax.swing.JLabel title_lbl1;
	private javax.swing.JButton yellow_btn;
	private javax.swing.JButton clear_btn;
	private javax.swing.JLabel bg_lbl;
	private javax.swing.JPanel panel;
	private javax.swing.JButton back_btn;
	private javax.swing.JButton instructions;

	private int NumberOfButtonPress = 0;
	private int redBtnPress = 0;
	private int yellowBtnPress = 0;
	private int blackBtnPress = 0;
	private int dBlueBtnPress = 0;
	private int lBlueBtnPress = 0;
	private int orangeBtnPress = 0;
	private int purpleBtnPress = 0;
	private int greenBtnPress = 0;
	private int pinkBtnPress = 0;

	private int[] numbers = new int[9];
	private int count;
	
	ArrayList<Integer> pwList = new ArrayList<>();

	public ThirdLevel() {
		initComponents();
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2,size.height/2 - getHeight()/2);
	}
	
	/*
	 * Looks at first value and compares it to the
	 * next value to see if it adds or subtracts up by 1
	 */
	private boolean fourConsecutive(ArrayList<Integer> arr) {
	    for (int i = 0; i < arr.size() - 3; i++) {
	    	//ascending 1,2,3,4
	      if (arr.get(i + 1) == arr.get(i) + 1 && arr.get(i + 2) == arr.get(i) + 2 && arr.get(i + 3) == arr.get(i) + 3) {
	        return true;
	      }
	      //descending 4,3,2,1
	      if (arr.get(i + 1) == arr.get(i) - 1 && arr.get(i + 2) == arr.get(i) - 2 && arr.get(i + 3) == arr.get(i) - 3) {
		        return true;
		  }
	    }
	    return false;
	  }
	
	private boolean threeConsecutive(ArrayList<Integer> arr) {
	    for (int i = 0; i < arr.size() - 2; i++) {
	    	//ascending 1,2,3 is good
	      if (arr.get(i + 1) == arr.get(i) + 1 && arr.get(i + 2) == arr.get(i) + 2) {
	        return true;
	      }
	      //descending 3,2,1 is good as well
	      if (arr.get(i + 1) == arr.get(i) - 1 && arr.get(i + 2) == arr.get(i) - 2) {
		        return true;
		  }
	    }
	    return false;
	  }
	

	private void initComponents() {

		title_lbl1 = new javax.swing.JLabel();
		proceed_btn = new javax.swing.JButton();
		red_btn = new javax.swing.JButton("Red");
		yellow_btn = new javax.swing.JButton("Yellow");
		orange_btn = new javax.swing.JButton("Orange");
		darkblue_btn = new javax.swing.JButton("Dark Blue");
		black_btn = new javax.swing.JButton("Black");
		purple_btn = new javax.swing.JButton("Purple");
		green_btn = new javax.swing.JButton("Green");
		lightblue_btn = new javax.swing.JButton("Light Blue");
		pink_btn = new javax.swing.JButton("Pink");
		clear_btn = new javax.swing.JButton();
		panel = new javax.swing.JPanel();
		bg_lbl = new javax.swing.JLabel();
		back_btn = new javax.swing.JButton();
		instructions = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new java.awt.Dimension(500, 500));
		setResizable(false);

		panel.setPreferredSize(new java.awt.Dimension(500, 500));
		panel.setLayout(null);
		title_lbl1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		title_lbl1.setForeground(new java.awt.Color(0, 51, 255));
		title_lbl1.setText("Create: Color-based password");

		instructions.setFont(new java.awt.Font("Tahoma", 1, 14));
		instructions.setText("Help");
		instructions.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				instructionsActionPerformed(evt);
			}
		});
		panel.add(instructions);
		instructions.setBounds(30, 390, 110, 30);//button
		
		pink_btn.setBackground(new java.awt.Color(255, 153, 153));
		pink_btn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		pink_btn.setForeground(new java.awt.Color(255, 255, 255));
		pink_btn.setText("9");
		panel.add(pink_btn);
		pink_btn.setBounds(310, 290, 98, 90);
		proceed_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		proceed_btn.setText("Next");

		red_btn.setBackground(new java.awt.Color(0xff0000));
		red_btn.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));

		lightblue_btn.setBackground(new java.awt.Color(0, 255, 255));
		lightblue_btn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lightblue_btn.setForeground(new java.awt.Color(255, 255, 255));
		lightblue_btn.setText("6");
		panel.add(lightblue_btn);
		lightblue_btn.setBounds(310, 190, 98, 90);
		yellow_btn.setBackground(new java.awt.Color(0xffff33));
		yellow_btn.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));

		green_btn.setBackground(new java.awt.Color(51, 255, 0));
		green_btn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		green_btn.setForeground(new java.awt.Color(255, 255, 255));
		green_btn.setText("3");
		panel.add(green_btn);
		green_btn.setBounds(310, 90, 98, 90);
		orange_btn.setBackground(new java.awt.Color(0xff6600));
		orange_btn.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));

		purple_btn.setBackground(new java.awt.Color(255, 0, 255));
		purple_btn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		purple_btn.setForeground(new java.awt.Color(255, 255, 255));
		purple_btn.setText("8");
		panel.add(purple_btn);
		purple_btn.setBounds(200, 290, 98, 90);
		darkblue_btn.setBackground(new java.awt.Color(0x0033ff));
		darkblue_btn.setForeground(Color.WHITE);
		darkblue_btn.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));

		black_btn.setBackground(new java.awt.Color(0, 0, 0));
		black_btn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		black_btn.setForeground(new java.awt.Color(255, 255, 255));
		black_btn.setText("7");
		panel.add(black_btn);
		black_btn.setBounds(90, 290, 98, 90);

		black_btn.setBackground(new java.awt.Color(0x000000));
		black_btn.setForeground(Color.WHITE);
		black_btn.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));

		darkblue_btn.setBackground(new java.awt.Color(0, 51, 255));
		darkblue_btn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		darkblue_btn.setForeground(new java.awt.Color(255, 255, 255));
		darkblue_btn.setText("4");
		panel.add(darkblue_btn);
		darkblue_btn.setBounds(90, 190, 98, 90);

		orange_btn.setBackground(new java.awt.Color(255, 102, 0));
		orange_btn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		orange_btn.setForeground(new java.awt.Color(255, 255, 255));
		orange_btn.setText("5");
		panel.add(orange_btn);
		orange_btn.setBounds(200, 190, 98, 90);
		purple_btn.setBackground(new java.awt.Color(0xff00ff));
		purple_btn.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));

		yellow_btn.setBackground(new java.awt.Color(255, 255, 51));
		yellow_btn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		yellow_btn.setText("2");
		green_btn.setBackground(new java.awt.Color(0x33ff00));
		green_btn.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));

		lightblue_btn.setBackground(new java.awt.Color(0x00ffff));
		lightblue_btn.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));

		panel.add(yellow_btn);
		yellow_btn.setBounds(200, 90, 98, 90);
		pink_btn.setBackground(new java.awt.Color(0xff9999));
		pink_btn.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));

		red_btn.setBackground(new java.awt.Color(255, 0, 0));
		red_btn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		red_btn.setForeground(new java.awt.Color(255, 255, 255));
		red_btn.setText("1");
		panel.add(red_btn);
		red_btn.setBounds(90, 90, 98, 90);

		clear_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		clear_btn.setText("Clear");

		panel.add(clear_btn);
		clear_btn.setBounds(180, 430, 140, 34);
		proceed_btn.setEnabled(false);

		title_lbl1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		title_lbl1.setForeground(new java.awt.Color(255, 255, 255));
		title_lbl1.setText("Create Color-based password");
		panel.add(title_lbl1);
		title_lbl1.setBounds(70, 20, 365, 29);


		proceed_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		proceed_btn.setText("Next");

		panel.add(proceed_btn);
		proceed_btn.setBounds(160, 390, 180, 34);

		back_btn.setFont(new java.awt.Font("Tahoma", 1, 14));
		back_btn.setText("Go Back");
		back_btn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				back_btnActionPerformed(evt);
			}
		});
		panel.add(back_btn);
		back_btn.setBounds(360, 390, 110, 30);

		bg_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/thirdlevelbg.jpg"))); // NOI18N
		panel.add(bg_lbl);
		bg_lbl.setBounds(0, 0, 500, 500);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
		layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
		);
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);


		pack();
		validate();

		red_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				
				pwList.add(1);
				redBtnPress++;

				//Checks to see if more than 3 colors has been chosen for proceed button to work
				NumberOfButtonPress++;
				btnVisible();
				
				//Makes sure user cant consecutively click on the same button
				nonConsecutiveClicks(false, true, true, true, true, true, true, true, true);
			}
		});
		
		/*
		 * When mouse is clicking the red button
		 * it shows a color change and when mouse click
		 * is released show the original color.
		 */
		 red_btn.addMouseListener(new MouseAdapter() {
	    	  public void mousePressed(MouseEvent evt) {	    		  
	  				red_btn.setBackground(new java.awt.Color(0xFFA07A));
	    	  }

			public void mouseReleased(MouseEvent evt) {
				red_btn.setBackground(new java.awt.Color(255, 0, 0));
			}
		});
		
		yellow_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
	
				pwList.add(2);
				yellowBtnPress++;

				//Checks to see if more than 3 colors has been chosen for proceed button to work
				NumberOfButtonPress++;
				btnVisible();

				//Makes sure user cant consecutively click on the same button
				nonConsecutiveClicks(true, false, true, true, true, true, true, true, true);
				
			}
		});

		yellow_btn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				yellow_btn.setBackground(new Color(0xFFFFE0));
			}
			
			public void mouseReleased(MouseEvent evt) {
				yellow_btn.setBackground(new java.awt.Color(255, 255, 51));
			}
		});

		
		orange_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {

				pwList.add(5);
				orangeBtnPress++;
				
				//Checks to see if more than 3 colors has been chosen for proceed button to work
				NumberOfButtonPress++;
				btnVisible();
				
				//Makes sure user cant consecutively click on the same button
				nonConsecutiveClicks(true, true, false, true, true, true, true, true, true);
				
			}
		});

		orange_btn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				orange_btn.setBackground(new Color(0xFFCC99));
			}

			public void mouseReleased(MouseEvent evt) {
				orange_btn.setBackground(new java.awt.Color(255, 102, 0));
			}
		});
		
		darkblue_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {

				pwList.add(4);
				dBlueBtnPress++;
				//Checks to see if more than 3 colors has been chosen for proceed button to work
				NumberOfButtonPress++;
				
				btnVisible();
				
				//Makes sure user cant consecutively click on the same button
				nonConsecutiveClicks(true, true, true, false, true, true, true, true, true);
				
			}
		});

		darkblue_btn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				darkblue_btn.setBackground(new Color(0x87CEFA));
			}
			
			public void mouseReleased(MouseEvent evt) {
				darkblue_btn.setBackground(new java.awt.Color(0, 51, 255));
			}
		});
		
		black_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {

				pwList.add(7);
				blackBtnPress++;
				
				//Checks to see if more than 3 colors has been chosen for proceed button to work
				NumberOfButtonPress++;
				btnVisible();
				
				//Makes sure user cant consecutively click on the same button
				nonConsecutiveClicks(true, true, true, true, false, true, true, true, true);
				
			}
		});

		black_btn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				black_btn.setBackground(new Color(0xC0C0C0));
			}

			public void mouseReleased(MouseEvent evt) {
				black_btn.setBackground(new java.awt.Color(0, 0, 0));
			}
		});

		
		purple_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {

				pwList.add(8);
				purpleBtnPress++;
				
				//Checks to see if more than 3 colors has been chosen for proceed button to work
				NumberOfButtonPress++;
				btnVisible();
				
				//Makes sure user cant consecutively click on the same button
				nonConsecutiveClicks(true, true, true, true, true, false, true, true, true);
				
			}
		});

		purple_btn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				purple_btn.setBackground(new Color(0xD8BFD8));
			}
			
			public void mouseReleased(MouseEvent evt) {
				purple_btn.setBackground(new java.awt.Color(255, 0, 255));
			}
		});

		green_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {

				pwList.add(3);
				greenBtnPress++;
				
				//Checks to see if more than 3 colors has been chosen for proceed button to work
				NumberOfButtonPress++;
				btnVisible();
				
				//Makes sure user cant consecutively click on the same button
				nonConsecutiveClicks(true, true, true, true, true, true, false, true, true);
				
			}
		});

		green_btn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				green_btn.setBackground(new Color(0x90EE90));
			}

			public void mouseReleased(MouseEvent evt) {
				green_btn.setBackground(new java.awt.Color(51, 255, 0));
			}
		});
		
		lightblue_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {

				pwList.add(6);
				lBlueBtnPress++;
				
				//Checks to see if more than 3 colors has been chosen for proceed button to work
				NumberOfButtonPress++;
				btnVisible();
				
				//Makes sure user cant consecutively click on the same button
				nonConsecutiveClicks(true, true, true, true, true, true, true, false, true);
				
			}
		});

		lightblue_btn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				lightblue_btn.setBackground(new Color(0xE6E6FA));
			}

			public void mouseReleased(MouseEvent evt) {
				lightblue_btn.setBackground(new java.awt.Color(0, 255, 255));
			}
		});
		
		pink_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {

				pwList.add(9);
				pinkBtnPress++;
				
				//Checks to see if more than 3 colors has been chosen for proceed button to work
				NumberOfButtonPress++;
				btnVisible();
				
				//Makes sure user cant consecutively click on the same button
				nonConsecutiveClicks(true, true, true, true, true, true, true ,true, false);
				
				
			}
		});

		pink_btn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				pink_btn.setBackground(new Color(0xFF66B2));
			}
			public void mouseReleased(MouseEvent evt) {
				pink_btn.setBackground(new java.awt.Color(255, 153, 153));
			}
		});
			
		proceed_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				
				//Password must contain at least 3 of the same color in order to proceed
				
				
				if(threeConsecutive(pwList))
				{
					
					//contains 4 consecutive then error, but if not 4 consecutive then fine
					if(!fourConsecutive(pwList))
					{	
						String password = pwList.toString();
						
						//System.out.println(pwList);
						ClientInfo.info.setRgbPass(password);
						
						ThirdLevelConfirm tlc = new ThirdLevelConfirm();
						dispose();
						tlc.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Passwords cannot contain at least 4 consecutive.");
						enableAllColButtons();
						resetButtonPressed();
						clearPasswords();
						proceed_btn.setEnabled(false);
						//Resets the password back to blank
						NumberOfButtonPress = 0;

					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Passwords must contain at least 3 consecutive.");
					enableAllColButtons();
					resetButtonPressed();
					clearPasswords();
					proceed_btn.setEnabled(false);
					//Resets the password back to blank
					NumberOfButtonPress = 0;
				}
			}
		});
			


		/*
		 * Clear Button
		 */
		clear_btn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				clearPasswords();
				NumberOfButtonPress = 0;
				resetButtonPressed();
				proceed_btn.setEnabled(false);
				enableAllColButtons();
				JOptionPane.showMessageDialog(null,"Password Has Been Cleared");

			}
		});
	}
	
	/*
	 * Helper method that checks to see 
	 * if the user has clicked more than 4
	 * colors for the proceed button to enable.
	 */
	public void btnVisible() {
		if(NumberOfButtonPress > 3)
		{
			proceed_btn.setEnabled(true);
		}
		else
		{
			proceed_btn.setEnabled(false);
		}
	}
	
	/***
	 * 
	 * Helper method that enables or disables button when clicked
	 * to prevent consecutive clicks
	 */
	public void nonConsecutiveClicks(boolean red, boolean yellow, boolean orange, boolean dBlue, boolean black, boolean purple,
										boolean green, boolean lBlue, boolean pink) {
		red_btn.setEnabled(red);
		yellow_btn.setEnabled(yellow);
		orange_btn.setEnabled(orange);
		darkblue_btn.setEnabled(dBlue);
		black_btn.setEnabled(black);
		purple_btn.setEnabled(purple);
		green_btn.setEnabled(green);
		lightblue_btn.setEnabled(lBlue);
		pink_btn.setEnabled(pink);
	}
	
	/*** Enables all colored buttons ***/
	
	public void enableAllColButtons() {
		red_btn.setEnabled(true);
		yellow_btn.setEnabled(true);
		orange_btn.setEnabled(true);
		darkblue_btn.setEnabled(true);
		black_btn.setEnabled(true);
		purple_btn.setEnabled(true);
		green_btn.setEnabled(true);
		lightblue_btn.setEnabled(true);
		pink_btn.setEnabled(true);
	}
	
	/*** Resets colored buttons pressed ***/
	
	public void resetButtonPressed() {
		redBtnPress = 0;
		yellowBtnPress = 0;
		blackBtnPress = 0;
		dBlueBtnPress = 0;
		lBlueBtnPress = 0;
		orangeBtnPress = 0;
		purpleBtnPress = 0;
		greenBtnPress = 0;
		pinkBtnPress = 0;
	}

	public void clearPasswords()
	{
		pwList.clear();
	}

	private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {
		SecondLevel x = new SecondLevel();
		x.setVisible(true);
		this.dispose();
	}
	
	private void instructionsActionPerformed(java.awt.event.ActionEvent evt){

		JOptionPane.showMessageDialog(null, "Color Password Requirements:\n"+
											"1. Minimum of 4 button clicks.\n"+
											"2. 3 button clicks must be in consecutive sequence (i.e. 123, 789, 234)\n"+
											"3. Maximum of 3 button clicks in consecutive sequence (i.e. 1234 = INVALID)\n"+
											"\n"+
											"Valid Password Ex: 1235, 8567, 045698, etc.");
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {


		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ThirdLevel().setVisible(true);
			}
		});
	}


}

