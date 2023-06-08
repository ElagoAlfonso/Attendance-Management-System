package Attendance_Management_System;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class AdminLoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField Username_tf;
	private JPasswordField Password_pf;
	private String Username;
	private ImageIcon logoIcon = new ImageIcon(
			new ImageIcon( "C:\\Users\\rafae\\Desktop\\School\\JPG\\icons\\Staclara.png")
			.getImage().getScaledInstance(575, 100, Image.SCALE_DEFAULT));
	/**
	 * Create the frame.
	 */
	public AdminLoginFrame () {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700,500);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(193, 282, 114, 23);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel Password_lbl = new JLabel("Password:");
		Password_lbl.setBounds(5, 5, 80, 20);
		panel_2.add(Password_lbl);
		Password_lbl.setVerticalAlignment(SwingConstants.TOP);
		Password_lbl.setFont(new Font("Sitka Text", Font.BOLD, 15));
		Password_lbl.setForeground(new Color(0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(193, 215, 120, 23);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel Username_lbl = new JLabel("Username:");
		Username_lbl.setBounds(7, 3, 103, 20);
		Username_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(Username_lbl);
		Username_lbl.setFont(new Font("Sitka Text", Font.BOLD, 15));
		Username_lbl.setForeground(new Color(0, 0, 0));
		
		JPanel UP_pnl = new JPanel();
		UP_pnl.setBounds(0, 0, 700, 19);
		UP_pnl.setBackground(new Color(0, 153, 51));
		contentPane.add(UP_pnl);
		UP_pnl.setLayout(null);
		
		final JLabel X_btn = new JLabel("X");
		X_btn.setVerticalAlignment(SwingConstants.TOP);
		X_btn.setBounds(674, 0, 20, 19);	
		UP_pnl.add(X_btn);
		X_btn.setFont(new Font("Candara Light", Font.BOLD, 20));
		X_btn.setHorizontalAlignment(SwingConstants.CENTER);
		X_btn.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			if(JOptionPane.showConfirmDialog(null, "Do you want to close the application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
				ADMIN_EMPLOYEE fra = new ADMIN_EMPLOYEE();
				fra.setVisible(true);
				dispose();
			}
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			X_btn.setForeground(Color.RED);
		}public void mouseExited(MouseEvent arg0) {
			X_btn.setForeground(Color.BLACK);
		}
	});
		X_btn.setForeground(new Color(0, 0, 0));
		
		JLabel Login_lbl = new JLabel("LOGIN");
		Login_lbl.setBounds(280, 104, 174, 54);
		Login_lbl.setVerticalAlignment(SwingConstants.TOP);
		Login_lbl.setForeground(new Color(0, 153, 51));
		Login_lbl.setFont(new Font("Sitka Text", Font.PLAIN, 55));
		Login_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(Login_lbl);
		
		// Create a JTextField for the username input
		Username_tf = new JTextField();
		Username_tf.setBounds(195, 239, 327, 20); // Set the position and size of the text field
		contentPane.add(Username_tf); // Add the text field to the content pane
		Username_tf.setColumns(10); // Set the number of columns for the text field

		// Add focus listeners to the username text field
		Username_tf.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (Username_tf.getText().equals("")) {
		            Username_tf.setForeground(new Color(96, 96, 96)); // Set the text color to a gray shade
		            Username_tf.setText("Username"); // Set the default placeholder text
		        }
		    }

		    @Override
		    public void focusGained(FocusEvent e) {
		        if (Username_tf.getText().equals("Username")) {
		            Username_tf.setForeground(Color.BLACK); // Set the text color back to black
		            Username_tf.setText(""); // Clear the text field
		        }
		    }
		});

		// Create a JPasswordField for the password input
		Password_pf = new JPasswordField();
		Password_pf.setBounds(195, 314, 327, 20); // Set the position and size of the password field
		contentPane.add(Password_pf); // Add the password field to the content pane
		Password_pf.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (Password_pf.getText().equals("")) {
		            Password_pf.setForeground(new Color(96, 96, 96)); // Set the text color to a gray shade
		            Password_pf.setText("Password"); // Set the default placeholder text
		            Password_pf.setEchoChar((char) 0); // Make the password characters invisible
		        }
		    }

		    @Override
		    public void focusGained(FocusEvent e) {
		        if (Password_pf.getText().equals("Password")) {
		            Password_pf.setForeground(Color.BLACK); // Set the text color back to black
		            Password_pf.setText(""); // Clear the password field
		            Password_pf.setEchoChar('•'); // Set the password characters to be visible as dots
		        }
		    }
		});

		
		// Create a Login button
		final JButton Login_btn = new JButton("Login");
		Login_btn.setBounds(526, 421, 145, 41); // Set the position and size of the button
		Login_btn.setFont(new Font("Tahoma", Font.BOLD, 12)); // Set the font for the button text
		Login_btn.setForeground(new Color(0, 0, 0)); // Set the text color of the button
		Login_btn.setBackground(new Color(0, 153, 51)); // Set the background color of the button
		contentPane.add(Login_btn); // Add the button to the content pane for logging in

		// Add an action listener to the Login button
		Login_btn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String username = Username_tf.getText(); // Get the entered username
		        String password = new String(Password_pf.getPassword()); // Get the entered password

		        if (username.equals("Admin01") && password.equals("admin1")) {
		            JOptionPane.showMessageDialog(null, "Admin Login Successful!"); // Display a success message
		            Admin_Paycheck ap = new Admin_Paycheck();
		            ap.setVisible(true); // Display the admin paycheck window
		            dispose(); // Close the current window
		            // Add your admin login logic here
		        } else {
		            JOptionPane.showMessageDialog(null, "Invalid username or password!"); // Display an error message
		        }
		    }
		});

		Login_btn.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 23)); // Change the font of the Login button
		contentPane.add(Login_btn); // Add the modified Login button to the content pane

		
		JLabel BG_pic = new JLabel("");
		BG_pic.setHorizontalAlignment(SwingConstants.CENTER);
		BG_pic.setIcon(logoIcon);
		BG_pic.setBounds(0, 37, 690, 452);
		contentPane.add(BG_pic);
		
		
	
		
	}
}