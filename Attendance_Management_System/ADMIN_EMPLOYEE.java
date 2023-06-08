package Attendance_Management_System;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;


import javax.swing.border.BevelBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class ADMIN_EMPLOYEE extends JFrame {

	private ImageIcon iconEMPLOYEE = new ImageIcon(
			new ImageIcon("C:\\Users\\rafae\\Desktop\\School\\JPG\\icons\\employee.png")
					.getImage().getScaledInstance(198, 180, Image.SCALE_DEFAULT));
	private ImageIcon iconADMIN = new ImageIcon(
			new ImageIcon( "C:\\Users\\rafae\\Desktop\\School\\JPG\\icons\\admin.png")
					.getImage().getScaledInstance(198, 180, Image.SCALE_DEFAULT));
	private ImageIcon logoIcon = new ImageIcon(
			new ImageIcon( "C:\\Users\\rafae\\Desktop\\School\\JPG\\icons\\Staclara.png")
			.getImage().getScaledInstance(1000, 250, Image.SCALE_DEFAULT));

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADMIN_EMPLOYEE frame = new ADMIN_EMPLOYEE();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ADMIN_EMPLOYEE() {
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel UP_pnl = new JPanel();
		UP_pnl.setBackground(new Color(6, 137, 49));
		UP_pnl.setBounds(0, 0, 1125, 37);
		contentPane.add(UP_pnl);
		UP_pnl.setLayout(null);
		
		final JLabel X_btn = new JLabel("X");
		X_btn.setVerticalAlignment(SwingConstants.TOP);
		X_btn.setBounds(1070, 5, 27, 26);	
		UP_pnl.add(X_btn);
		X_btn.setFont(new Font("Candara Light", Font.BOLD, 30));
		X_btn.setHorizontalAlignment(SwingConstants.CENTER);
		X_btn.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			if(JOptionPane.showConfirmDialog(null, "Do you want to close the application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
				ADMIN_EMPLOYEE fra = new ADMIN_EMPLOYEE();
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
		
		JPanel Employee_pnl = new JPanel();
		Employee_pnl.addMouseListener(new PanelButtonMouseAdapter2(Employee_pnl));
		Employee_pnl.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(6, 137, 49), new Color(6, 137, 49), new Color(6, 137, 49), new Color(6, 137, 49)));
		Employee_pnl.setBounds(273, 205, 262, 266);
		contentPane.add(Employee_pnl);
		Employee_pnl.setLayout(null);
		
		JLabel Employee_icon = new JLabel("");
		Employee_icon.setHorizontalAlignment(SwingConstants.CENTER);
		Employee_icon.setIcon(iconEMPLOYEE);
		Employee_icon.setBounds(44, 33, 176, 192);
		Employee_pnl.add(Employee_icon);
		
		JLabel Attendance_lbl = new JLabel("EMPLOYEE ATTENDANCE");
		Attendance_lbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		Attendance_lbl.setBounds(10, 221, 252, 34);
		Employee_pnl.add(Attendance_lbl);
		
		JPanel Admin_pnl = new JPanel();
		Admin_pnl.addMouseListener(new PanelButtonMouseAdapter3(Admin_pnl));
		Admin_pnl.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(6, 137, 49), new Color(6, 137, 49), new Color(6, 137, 49), new Color(6, 137, 49)));
		Admin_pnl.setBounds(638, 205, 262, 266);
		contentPane.add(Admin_pnl);
		Admin_pnl.setLayout(null);
		
		JLabel Admin_icon = new JLabel("");
		Admin_icon.setHorizontalAlignment(SwingConstants.CENTER);
		Admin_icon.setIcon(iconADMIN);
		Admin_icon.setBounds(38, 34, 198, 180);
		Admin_pnl.add(Admin_icon);
		
		JLabel Admin_lbl = new JLabel("ADMIN");
		Admin_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		Admin_lbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		Admin_lbl.setBounds(27, 221, 188, 34);
		Admin_pnl.add(Admin_lbl);
		
		JLabel BG_pic = new JLabel("");
		BG_pic.setHorizontalAlignment(SwingConstants.CENTER);
		BG_pic.setIcon(logoIcon);
		BG_pic.setBounds(0, 37, 1125, 552);
		contentPane.add(BG_pic);
	}

	private class PanelButtonMouseAdapter2 extends MouseAdapter {
	    
	    JPanel panel; // Reference to the panel being adapted
	    
	    public PanelButtonMouseAdapter2(JPanel panel) {
	        this.panel = panel; // Initialize the panel reference
	    }
	    
	    // Mouse entered event handler
	    public void mouseEntered(MouseEvent e) {
	        panel.setBackground(new Color(6, 137, 49)); // Set the background color when the mouse enters the panel
	    }
	    
	    // Mouse exited event handler
	    @Override
	    public void mouseExited(MouseEvent e) {
	        panel.setBackground(new Color(240, 240, 240)); // Set the background color when the mouse exits the panel
	    }
	    
	    // Mouse pressed event handler
	    @Override
	    public void mousePressed(MouseEvent e) {
	        panel.setBackground(new Color(6, 137, 49)); // Set the background color when the mouse is pressed
	        
	        // Show a confirmation dialog and take action based on the user's choice
	        if (JOptionPane.showConfirmDialog(null, "Are you an Employee?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
	            Emp_Attendance employeeAttendance = new Emp_Attendance();
	            employeeAttendance.setVisible(true); // Display the employee attendance window
	            dispose(); // Close the current window
	        }
	    }
	    
	    // Mouse released event handler
	    @Override
	    public void mouseReleased(MouseEvent e) {
	        panel.setBackground(new Color(240, 240, 240)); // Set the background color when the mouse is released
	    }
	}

	
	private class PanelButtonMouseAdapter3 extends MouseAdapter {
	    
	    JPanel panel; // Reference to the panel being adapted
	    
	    public PanelButtonMouseAdapter3(JPanel panel) {
	        this.panel = panel; // Initialize the panel reference
	    }
	    
	    // Mouse entered event handler
	    public void mouseEntered(MouseEvent e) {
	        panel.setBackground(new Color(6, 137, 49)); // Set the background color when the mouse enters the panel
	    }
	    
	    // Mouse exited event handler
	    @Override
	    public void mouseExited(MouseEvent e) {
	        panel.setBackground(new Color(240, 240, 240)); // Set the background color when the mouse exits the panel
	    }
	    
	    // Mouse pressed event handler
	    @Override
	    public void mousePressed(MouseEvent e) {
	        panel.setBackground(new Color(6, 137, 49)); // Set the background color when the mouse is pressed
	        
	        // Show a confirmation dialog and take action based on the user's choice
	        if (JOptionPane.showConfirmDialog(null, "Are you an Admin?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
	            AdminLoginFrame adminPaycheck = new AdminLoginFrame();
	            adminPaycheck.setVisible(true); // Display the admin login frame
	            dispose(); // Close the current window
	        }
	    }
	    
	    // Mouse released event handler
	    @Override
	    public void mouseReleased(MouseEvent e) {
	        panel.setBackground(new Color(240, 240, 240)); // Set the background color when the mouse is released
	    }
	}
}