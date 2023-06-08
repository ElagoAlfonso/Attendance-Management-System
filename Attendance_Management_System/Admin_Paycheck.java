package Attendance_Management_System;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;



public class Admin_Paycheck extends JFrame {
	
	// all image 
	private ImageIcon exitIcons = new ImageIcon(
	new ImageIcon( "C:\\Users\\rafae\\Desktop\\School\\JPG\\icons\\button.png")
	.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
	
	private ImageIcon logoutIcon = new ImageIcon(
			new ImageIcon( "C:\\Users\\rafae\\Desktop\\School\\JPG\\icons\\logout (1).png")
			.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
	
	private ImageIcon paycheckIcon = new ImageIcon(
			new ImageIcon( "C:\\Users\\rafae\\Desktop\\School\\JPG\\icons\\wage.png")
			.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
	
	private ImageIcon viewIcon = new ImageIcon(
			new ImageIcon( "C:\\Users\\rafae\\Desktop\\School\\JPG\\icons\\immigration.png")
			.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
	
	private ImageIcon pesosIcon = new ImageIcon(
			new ImageIcon( "C:\\Users\\rafae\\Desktop\\School\\JPG\\icons\\philippines-peso-currency-symbol.png")
			.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
	private ImageIcon chequeIcon = new ImageIcon(
			new ImageIcon( "C:\\Users\\rafae\\Desktop\\School\\JPG\\icons\\cheque.png")
			.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
	private ImageIcon logoIcon = new ImageIcon(
			new ImageIcon( "C:\\Users\\rafae\\Desktop\\School\\JPG\\icons\\Staclara.png")
			.getImage().getScaledInstance(1000, 85, Image.SCALE_DEFAULT));

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;
    private JLabel Peso_lbl;
	private int hours;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {	
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Admin_Paycheck frame = new Admin_Paycheck();
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
    public Admin_Paycheck() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1141, 628);
        setUndecorated(true);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 250, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel UP_pnl = new JPanel();
        UP_pnl.setBounds(0, 0, 1141, 63);
        UP_pnl.setBackground(new Color(0, 153, 51));
        contentPane.add(UP_pnl);
        UP_pnl.setLayout(null);

        JLabel Employee_Paycheck_lbl = new JLabel();
        Employee_Paycheck_lbl.setFont(new Font("Arial", Font.BOLD, 30));
        Employee_Paycheck_lbl.setIcon(logoIcon);
        Employee_Paycheck_lbl.setHorizontalAlignment(SwingConstants.CENTER);
        Employee_Paycheck_lbl.setBounds(0, 0, 1141, 63);
        UP_pnl.add(Employee_Paycheck_lbl);

        JPanel Mid_pnl = new JPanel();
        Mid_pnl.setBorder(new LineBorder(new Color(6, 139, 49), 2));
        Mid_pnl.setBounds(0, 62, 1141, 376);
        contentPane.add(Mid_pnl);
        Mid_pnl.setLayout(null);

        tableModel = new DefaultTableModel(
                new Object[][] {},
                new String[] { "Employee Name", "Employee ID", "Check-In", "Department", "Work File", "Break-In", "Break-Out", "Total Work Of Hours" }
        );
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(new LineBorder(new Color(0, 153, 51), 2));
        scrollPane.setBounds(0, 0, 1141, 376);
        Mid_pnl.add(scrollPane);
        
        JPanel Down_pnl = new JPanel();
        Down_pnl.setBorder(new LineBorder(new Color(0, 153, 51), 2));
        Down_pnl.setBounds(0, 438, 1141, 179);
        contentPane.add(Down_pnl);
        Down_pnl.setLayout(null);
        
        JPanel LoadData_pnl = new JPanel();
        LoadData_pnl.setBorder(new LineBorder(new Color(0, 153, 51), 2));
        LoadData_pnl.addMouseListener(new PanelButtonMouseAdapter(LoadData_pnl));
        LoadData_pnl.setBounds(142, 110, 184, 58);
        Down_pnl.add(LoadData_pnl);
        LoadData_pnl.setLayout(null);
        
        JLabel LoadData_lbl = new JLabel("Load Data");
        LoadData_lbl.setHorizontalAlignment(SwingConstants.CENTER);
        LoadData_lbl.setIcon(viewIcon);
        LoadData_lbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        LoadData_lbl.setBounds(0, 0, 184, 58);
        LoadData_pnl.add(LoadData_lbl);
        
        JPanel Paycheck_pnl = new JPanel();
        Paycheck_pnl.setBorder(new LineBorder(new Color(0, 153, 51), 2));
        Paycheck_pnl.addMouseListener(new PanelButtonMouseAdapter2(Paycheck_pnl));
        Paycheck_pnl.setBounds(383, 110, 184, 58);
        Down_pnl.add(Paycheck_pnl);
        Paycheck_pnl.setLayout(null);
        
        JLabel Paycheck_lbl = new JLabel("Paycheck");
        Paycheck_lbl.setHorizontalAlignment(SwingConstants.CENTER);
        Paycheck_lbl.setIcon(paycheckIcon);
        Paycheck_lbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        Paycheck_lbl.setBounds(0, 0, 184, 58);
        Paycheck_pnl.add(Paycheck_lbl);
        
        // paycheck label show
         Peso_lbl = new JLabel();
         Peso_lbl.setIcon(pesosIcon);
         Peso_lbl.setBounds(400, 11, 333, 58);
         Down_pnl.add(Peso_lbl);
         Peso_lbl.setFont(new Font("Arial", Font.BOLD, 20));
         
         JPanel Logout_pnl = new JPanel();
         Logout_pnl.addMouseListener(new PanelButtonMouseAdapter2(Logout_pnl));
         Logout_pnl.setLayout(null);
         Logout_pnl.setBorder(new LineBorder(new Color(0, 153, 51), 2));
         Logout_pnl.setBounds(836, 110, 184, 58);
         Down_pnl.add(Logout_pnl);
         
         JLabel Logout_lbl = new JLabel("Logout");
         Logout_lbl.setHorizontalAlignment(SwingConstants.CENTER);
         Logout_lbl.setIcon(logoutIcon);
         Logout_lbl.addMouseListener(new MouseAdapter() {
         	@Override
         	public void mouseClicked(MouseEvent e) {
         		if(JOptionPane.showConfirmDialog(null, "Do you want Logout?", "Confirm", JOptionPane.YES_NO_OPTION)== 0 ) {
         		ADMIN_EMPLOYEE fra = new ADMIN_EMPLOYEE();
 				fra.setVisible(true);
 				dispose();
 				}
         	}
         });
         Logout_lbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
         Logout_lbl.setBounds(0, 0, 184, 58);
         Logout_pnl.add(Logout_lbl);
         
         JPanel PrintPayslip_pnl = new JPanel();
         PrintPayslip_pnl.addMouseListener(new PanelButtonMouseAdapter4(PrintPayslip_pnl));
         PrintPayslip_pnl.setLayout(null);
         PrintPayslip_pnl.setBorder(new LineBorder(new Color(0, 153, 51), 2));
         PrintPayslip_pnl.setBounds(616, 110, 184, 58);
         Down_pnl.add(PrintPayslip_pnl);
          
         JLabel PrintPayslip_lbl = new JLabel("Print Payslip");
         PrintPayslip_lbl.setHorizontalAlignment(SwingConstants.CENTER);
         PrintPayslip_lbl.setIcon(chequeIcon);
         PrintPayslip_lbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
         PrintPayslip_lbl.setBounds(0, 0, 184, 58);
         PrintPayslip_pnl.add(PrintPayslip_lbl);        	
         }
          	

    
 // private method to load table data from the database file
 // This method populates the table with data from the specified file path
 private void loadTableData() {
     String filePath = "C:\\Users\\rafae\\txt\\DatabaseAttendance.txt";
     tableModel.setRowCount(0);

     try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
         String headerLine = br.readLine(); // Read the header line (not needed for the table)
         String[] headers = headerLine.split("\t"); // Split the header line by tabs

         // Check if the header line contains the expected number of columns and correct headers
         if (headers.length == 8 && headers[0].equals("Employee Name") && headers[1].equals("Employee ID") && headers[2].equals("Check - In") && headers[3].equals("Department")
                 && headers[4].equals("Work File") && headers[5].equals("Break In") && headers[6].equals("Break Out") && headers[7].equals("Total Work Of Hours")) {

             String line;

             while ((line = br.readLine()) != null) {
                 String[] data = line.split("\t"); // Split the line by tabs

                 if (data.length == 8) {
                     String employeeName = data[0];
                     String employeeID = data[1];
                     String checkIn = data[2];
                     String department = data[3];
                     String workFile = data[4];
                     String breakIn = data[5];
                     String breakOut = data[6];
                     String totalWorkHours = data[7];

                     tableModel.addRow(new Object[]{employeeName, employeeID, checkIn, department, workFile, breakIn, breakOut, totalWorkHours});
                 }
             }
         } else {
             System.out.println("Invalid header format in the data file.");
         }
     } catch (IOException e) {
         e.printStackTrace();
     }
 }

//private method to calculate the paycheck
//This method computes the total work hours and calculates the paycheck
private void calculatePaycheck() {
  int selectedRow = table.getSelectedRow();
  if (selectedRow != -1) {
      String totalWorkHours = table.getValueAt(selectedRow, 7).toString();
      double hours = Double.parseDouble(totalWorkHours);
      double hourlyRate = 72.25; // total salary per hour

      double regularPay = 0;
      double overtimePay = 0;
      
      // Check if there are overtime hours
      if (hours > 8) {
          double excessHours = hours - 8;
          regularPay = 8 * hourlyRate;
          overtimePay = excessHours * (hourlyRate * 0.8);
      } else {
          regularPay = hours * hourlyRate;
      }

      double grossPay = regularPay + overtimePay;

      // Subtract taxes
      double taxSSS = 0.8;
      double taxPagibig = 0.2;
      double taxPhilhealth = 0.4;
      double totalDeductions = taxSSS + taxPagibig + taxPhilhealth;
      double netPay = grossPay - totalDeductions;

      Peso_lbl.setText(" : " + netPay); // Display the paycheck total
  }
}


    // View Panel Panel Effect and Function
    private class PanelButtonMouseAdapter extends MouseAdapter{
		
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		public void mouseEntered(MouseEvent e){
			
			panel.setBackground(new Color(6, 137, 49));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(240, 240, 240));
		}
		
		@Override
		public void mousePressed(MouseEvent e){
			panel.setBackground(new Color(6, 137, 49));
			
			  loadTableData(); // called Textfile
		} 
		
		@Override
		public void mouseReleased(MouseEvent e){
			panel.setBackground(new Color(240,  240, 240));
		}

	}
    
    // Paycheck Panel Panel Effect and Function
    private class PanelButtonMouseAdapter2 extends MouseAdapter{
		
		JPanel panel;
		public PanelButtonMouseAdapter2(JPanel panel) {
			this.panel = panel;
		}
		public void mouseEntered(MouseEvent e){
			
			panel.setBackground(new Color(6, 137, 49));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(240, 240, 240));
		}
		
		@Override
		public void mousePressed(MouseEvent e){
			panel.setBackground(new Color(6, 137, 49));
			
			calculatePaycheck(); // button to calculate your Days
		} 
		
		@Override
		public void mouseReleased(MouseEvent e){
			panel.setBackground(new Color(240,  240, 240));
		}

	}
    
    // logout panel Effect and function
    private class PanelButtonMouseAdapter3 extends MouseAdapter{
		
		JPanel panel;
		public PanelButtonMouseAdapter3(JPanel panel) {
			this.panel = panel;
		}
		public void mouseEntered(MouseEvent e){
			
			panel.setBackground(new Color(6, 137, 49));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(240, 240, 240));
		}
		
		@Override
		public void mousePressed(MouseEvent e){
			panel.setBackground(new Color(6, 137, 49));
			
		
		} 
		
		@Override
		public void mouseReleased(MouseEvent e){
			panel.setBackground(new Color(240,  240, 240));
		}

	}
    
 // Print Cheque panel Effect and function
    private class PanelButtonMouseAdapter4 extends MouseAdapter {
        JPanel panel;

        public PanelButtonMouseAdapter4(JPanel panel) {
            this.panel = panel;
        }

        public void mouseEntered(MouseEvent e) {
            panel.setBackground(new Color(6, 137, 49));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            panel.setBackground(new Color(240, 240, 240));
        }

        @Override
        public void mousePressed(MouseEvent e) {
            panel.setBackground(new Color(6, 137, 49));

            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String employeeName = table.getValueAt(selectedRow, 0).toString();
                String employeeID = table.getValueAt(selectedRow, 1).toString();
                String department = table.getValueAt(selectedRow, 3).toString();
                String totalWorkHours = table.getValueAt(selectedRow, 7).toString();

                                                                                // Create an instance of the Receipt frame
                PayslipFrame fr = new PayslipFrame();

                // Set values in the Receipt frame
                fr.employeenamehere.setText(employeeName);
                fr.EmployeeIDhere.setText(employeeID);
                fr.departmenthere.setText(department);
                fr.paydatehere.setText(getCurrentDate());                       // Assuming getCurrentDate() returns the current date
                fr.incomehere.setText(Peso_lbl.getText().replace(" : ", ""));
                fr.totalhourhere.setText(totalWorkHours);
                
                                                                                // Set the visibility of the Receipt frame to true
                fr.setVisible(true);
                
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            panel.setBackground(new Color(240, 240, 240));
        }

        private String getCurrentDate() {
        	 LocalDate currentDate = LocalDate.now();
        	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        	 String formattedDate = currentDate.format(formatter);
        	 return formattedDate;
          
        }
    }

}
