package Attendance_Management_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class PayslipFrame extends JFrame {

	private JPanel contentPane;
	private ImageIcon logoIcon = new ImageIcon(
			new ImageIcon( "C:\\Users\\rafae\\Desktop\\School\\JPG\\icons\\Staclara.png")
			.getImage().getScaledInstance(650, 50, Image.SCALE_DEFAULT));
	// this is the reason why you see the text from another frame
	

	public static JLabel employeenamehere;
	public static JLabel EmployeeIDhere;
	public static JLabel departmenthere;
	public static JLabel paydatehere;
	public static JLabel incomehere;
	public static JLabel totalhere;
	public static JLabel totalhourhere; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayslipFrame frame = new PayslipFrame();
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
	public PayslipFrame() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 340);
		setTitle("Receipt");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Logo_pnl = new JPanel();
		Logo_pnl.setBounds(0, 0, 687, 58);
		Logo_pnl.setBackground(new Color(0, 153, 51));
		contentPane.add(Logo_pnl);
		Logo_pnl.setLayout(null);
		
		final JLabel X_btn = new JLabel("X");
		X_btn.setVerticalAlignment(SwingConstants.TOP);
		X_btn.setBounds(665, 3, 20, 19);	
		Logo_pnl.add(X_btn);
		X_btn.setFont(new Font("Candara Light", Font.BOLD, 20));
		X_btn.setHorizontalAlignment(SwingConstants.CENTER);
		X_btn.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			if(JOptionPane.showConfirmDialog(null, "Do you want to close the application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
//				ADMIN_EMPLOYEE fra = new ADMIN_EMPLOYEE();
//				fra.setVisible(true);
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
		
		JLabel logo = new JLabel("");
		logo.setBounds(0, 0, 685, 54);
		Logo_pnl.add(logo);
		logo.setIcon( logoIcon);
		
		JPanel receiptpanel = new JPanel();
		receiptpanel.setBackground(new Color(240, 240, 240));
		receiptpanel.setBounds(0, 0, 688, 340);
		contentPane.add(receiptpanel);
		receiptpanel.setLayout(null);
		
		JPanel uppanel = new JPanel();
		uppanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		uppanel.setBackground(new Color(0, 153, 51));
		uppanel.setBounds(0, 63, 688, 34);
		receiptpanel.add(uppanel);
		uppanel.setLayout(null);
		
		JLabel EmployeeName_lbl = new JLabel("Employee Name");
		EmployeeName_lbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		EmployeeName_lbl.setBounds(0, 0, 136, 34);
		uppanel.add(EmployeeName_lbl);
		
		JLabel EmployeeID_lbl = new JLabel("Employee ID");
		EmployeeID_lbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		EmployeeID_lbl.setBounds(196, 0, 136, 34);
		uppanel.add(EmployeeID_lbl);
		
		JLabel Paydate_lbl = new JLabel("Paydate");
		Paydate_lbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		Paydate_lbl.setBounds(583, 0, 105, 34);
		uppanel.add(Paydate_lbl);
		
		JLabel Department_lbl = new JLabel("Department");
		Department_lbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		Department_lbl.setBounds(390, 0, 136, 34);
		uppanel.add(Department_lbl);
		
		JPanel downpanel = new JPanel();
		downpanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		downpanel.setBackground(new Color(0, 153, 51));
		downpanel.setBounds(0, 154, 688, 45);
		receiptpanel.add(downpanel); 
		downpanel.setLayout(null);
		
		JPanel down = new JPanel();
		down.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		down.setBackground(new Color(0, 153, 51));
		down.setBounds(0, 263, 688, 34);
		receiptpanel.add(down);
		down.setLayout(null);
		
		JLabel TotalIncome_lbl = new JLabel("Total Income");
		TotalIncome_lbl.setBounds(406, 0, 136, 34);
		down.add(TotalIncome_lbl);
		TotalIncome_lbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		 employeenamehere = new JLabel("");
		 employeenamehere.setFont(new Font("Tahoma", Font.BOLD, 15));
		employeenamehere.setBounds(0, 107, 182, 22);
		receiptpanel.add(employeenamehere);
		
		EmployeeIDhere = new JLabel("");
		EmployeeIDhere.setFont(new Font("Tahoma", Font.BOLD, 15));
		EmployeeIDhere.setBounds(182, 108, 184, 22);
		receiptpanel.add(EmployeeIDhere);
		
		 departmenthere = new JLabel("");
		 departmenthere.setFont(new Font("Tahoma", Font.BOLD, 15));
		departmenthere.setBounds(376, 108, 176, 22);
		receiptpanel.add(departmenthere);
		
		 paydatehere = new JLabel("");
		 paydatehere.setFont(new Font("Tahoma", Font.BOLD, 15));
		paydatehere.setBounds(562, 108, 116, 21);
		receiptpanel.add(paydatehere);
		
		 incomehere = new JLabel("");
		 incomehere.setFont(new Font("Tahoma", Font.BOLD, 15));
		incomehere.setBounds(524, 295, 129, 45);
		receiptpanel.add(incomehere);
		
		JLabel totalhere = new JLabel("73.37 Hour");
		totalhere.setFont(new Font("Tahoma", Font.BOLD, 15));
		totalhere.setHorizontalAlignment(SwingConstants.CENTER);
		totalhere.setBounds(45, 210, 106, 34);
		receiptpanel.add(totalhere);
		
		totalhourhere = new JLabel("");
		totalhourhere.setFont(new Font("Tahoma", Font.BOLD, 15));
		totalhourhere.setBounds(342, 210, 106, 34);
		receiptpanel.add(totalhourhere);
		
		JLabel pagibiglbl = new JLabel("Pagibig     : 0.2");
		pagibiglbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		pagibiglbl.setBounds(524, 190, 154, 34);
		receiptpanel.add(pagibiglbl);
		
		JLabel PerHour_lbl = new JLabel("Per Hour");
		PerHour_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		PerHour_lbl.setBounds(0, 12, 102, 34);
		PerHour_lbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		downpanel.add(PerHour_lbl);
		
		JLabel TotalHour_lbl = new JLabel("Total Hour");
		TotalHour_lbl.setBounds(289, 12, 136, 34);
		TotalHour_lbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		downpanel.add(TotalHour_lbl);
		
		JLabel MandatoryContributions_lbl = new JLabel("Mandatory Contributions");
		MandatoryContributions_lbl.setBounds(506, 11, 182, 37);
		MandatoryContributions_lbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		downpanel.add(MandatoryContributions_lbl);
		
		JLabel lblSss = new JLabel("SSS           : 0.8");
		lblSss.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSss.setBounds(524, 210, 164, 34);
		receiptpanel.add(lblSss);
		
		JLabel pagibiglbl_1_1 = new JLabel("Philhealth: 0.4");
		pagibiglbl_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		pagibiglbl_1_1.setBounds(524, 229, 164, 34);
		receiptpanel.add(pagibiglbl_1_1);
	}
}