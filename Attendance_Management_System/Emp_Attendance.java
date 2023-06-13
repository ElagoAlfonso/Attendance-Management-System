	package Attendance_Management_System;
	
	import java.awt.Color;
	import java.awt.EventQueue;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.FocusAdapter;
	import java.awt.event.FocusEvent;
	import java.awt.event.KeyAdapter;
	import java.awt.event.KeyEvent;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFileChooser;
	import javax.swing.JFrame;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.JTextField;
	import javax.swing.table.DefaultTableModel;
	
	
	import javax.swing.JLabel;
	import java.awt.Font;
	import java.awt.Image;
	
	import javax.swing.border.LineBorder;
	import javax.swing.SwingConstants;
	
	public class Emp_Attendance extends JFrame {
		
		private ImageIcon exitIcons = new ImageIcon(
				new ImageIcon("C:\\Users\\rafae\\Desktop\\School\\JPG\\icons\\button.png")
				.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		private ImageIcon checkinIcon = new ImageIcon(
				new ImageIcon("C:\\Users\\rafae\\Desktop\\School\\JPG\\icons\\calendar.png")
				.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		private ImageIcon checkoutIcon = new ImageIcon(
				new ImageIcon("C:\\Users\\rafae\\Desktop\\School\\JPG\\icons\\check-out.png")
				.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		private ImageIcon breakinIcon = new ImageIcon(
				new ImageIcon("C:\\Users\\rafae\\Desktop\\School\\JPG\\icons\\lunch-time.png")
				.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		private ImageIcon breakoutIcon = new ImageIcon(
				new ImageIcon("C:\\Users\\rafae\\Desktop\\School\\JPG\\icons\\tea-time.png")
				.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		private ImageIcon worksheeticon = new ImageIcon(
				new ImageIcon( "C:\\Users\\rafae\\Desktop\\School\\JPG\\icons\\documentation.png")
				.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		private ImageIcon viewIcon = new ImageIcon(
				new ImageIcon( "C:\\Users\\rafae\\Desktop\\School\\JPG\\icons\\analysis.png")
				.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		private ImageIcon logoIcon = new ImageIcon(
				new ImageIcon( "C:\\Users\\rafae\\Desktop\\School\\JPG\\icons\\Staclara.png")
				.getImage().getScaledInstance(1000, 85, Image.SCALE_DEFAULT));
		
	    private JPanel contentPane;
	    private JTable table;
	    private JTextField EmployeeName_tf;
	    private JTextField EmployeeID_tf;
	    private JTextField Department_tf;
	    private DefaultTableModel tableModel;
	
	    /**
	     * Launch the application.
	     */
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                	 Emp_Attendance frame = new  Emp_Attendance();
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
	    public Emp_Attendance() {
	    	setUndecorated(true);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 1125, 590);
	        contentPane = new JPanel();
	        contentPane.setLayout(null);
	        setContentPane(contentPane);
	
	        JPanel UP_pnl = new JPanel();
	        UP_pnl.setBackground(new Color(6, 139, 49));
	        UP_pnl.setBounds(0, 0, 1125, 70);
	        contentPane.add(UP_pnl);
	        UP_pnl.setLayout(null);
	        
	        JLabel Logo_lbl = new JLabel();
	        Logo_lbl.setHorizontalAlignment(SwingConstants.CENTER);
	        Logo_lbl.setFont(new Font("Arial", Font.BOLD, 45));
	        Logo_lbl.setBounds(0, 0, 1125, 70);
	        Logo_lbl.setIcon(logoIcon);
	        UP_pnl.add(Logo_lbl);
	        
	        final JLabel X_lbl = new JLabel("X");
	        X_lbl.setVerticalAlignment(SwingConstants.TOP);
	        X_lbl.setHorizontalAlignment(SwingConstants.CENTER);
	        X_lbl.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		if(JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
	        		ADMIN_EMPLOYEE AE = new ADMIN_EMPLOYEE();
	        		AE.setVisible(true);
	        		dispose();
	        		}
	        	}public void mouseEntered(MouseEvent arg0) {
	        		X_lbl.setForeground(Color.RED);
	    		}public void mouseExited(MouseEvent arg0) {
	    			X_lbl.setForeground(Color.BLACK);
	    		}
	        });
	        X_lbl.setBounds(1097, 5, 28, 26);
	        X_lbl.setFont(new Font("Candara Light", Font.BOLD, 30));
	        UP_pnl.add(X_lbl);
	
	        JPanel Mid_pnl = new JPanel();
	        Mid_pnl.setBorder(new LineBorder(new Color(6, 139, 49), 2));
	        Mid_pnl.setBounds(0, 68, 1125, 390);
	        contentPane.add(Mid_pnl);
	        Mid_pnl.setLayout(null);
	        
	        
	     // Create a JTable and its associated table model
	        tableModel = new DefaultTableModel(
	            new Object[][] {},
	            new String[] { "Employee Name", "Employee ID", "Check - In", "Department", "Work File", "Break In", "Break Out", "Total Work Of Hours"});
	        table = new JTable(tableModel);

	        // Create a JScrollPane to add scrollable functionality to the table
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(0, 0, 1125, 390);
	        Mid_pnl.add(scrollPane);

	        // Create a JPanel for the lower section of the content pane
	        JPanel Down_pnl = new JPanel();
	        Down_pnl.setBorder(new LineBorder(new Color(6, 139, 49), 2));
	        Down_pnl.setBounds(0, 457, 1125, 132);
	        contentPane.add(Down_pnl);
	        Down_pnl.setLayout(null);
	        
	     // Create a JTextField for entering the employee name
	        EmployeeName_tf = new JTextField();
	        EmployeeName_tf.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
	        EmployeeName_tf.setText("Enter Employee Name");
	        EmployeeName_tf.setBounds(110, 11, 303, 50);

	        // Add FocusListener to handle focus events on the text field
	        EmployeeName_tf.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusLost(FocusEvent e) {
	        		// When the field loses focus and is empty, set the default text and color
	        		if (EmployeeName_tf.getText().equals("")) {
	        			EmployeeName_tf.setForeground(new Color(96, 96, 96));
	        			EmployeeName_tf.setText("Enter Employee Name");
	        		}
	        	}

	        	@Override
	        	public void focusGained(FocusEvent e) {
	        		// When the field gains focus and contains default text, change the color and clear the text
	        		if (EmployeeName_tf.getText().equals("Enter Employee Name")) {
	        			EmployeeName_tf.setForeground(Color.BLACK);
	        			EmployeeName_tf.setText("");
	        		}
	        	}
	        });

	        // Add the employeeField to the downPanel
	        Down_pnl.add(EmployeeName_tf);

	 
	        
	     // Create a JTextField for entering the employee ID
	        EmployeeID_tf = new JTextField();
	        EmployeeID_tf.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
	        EmployeeID_tf.setText("Enter Employee ID");
	        EmployeeID_tf.setColumns(10);

	        // Add FocusListener to handle focus events on the text field
	        EmployeeID_tf.addFocusListener(new FocusAdapter() {
	            @Override
	            public void focusLost(FocusEvent e) {
	                // When the field loses focus and contains default text, set the default text and color
	                if (EmployeeID_tf.getText().equals("Enter Employee ID")) {
	                    EmployeeID_tf.setForeground(new Color(96, 96, 96));
	                    EmployeeID_tf.setText("Enter Event Place");
	                }
	            }

	            @Override
	            public void focusGained(FocusEvent e) {
	                // When the field gains focus and contains default text, change the color and clear the text
	                if (EmployeeID_tf.getText().equals("Enter Employee ID")) {
	                    EmployeeID_tf.setForeground(Color.BLACK);
	                    EmployeeID_tf.setText("");
	                }
	            }
	        });

	        // Add KeyListener to restrict the input to only digits and limit the length to 8 characters
	        EmployeeID_tf.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyTyped(KeyEvent e) {
	                char c = e.getKeyChar();
	                // Consume the event if the entered character is not a digit or the length exceeds 8
	                if (!Character.isDigit(c) || EmployeeID_tf.getText().length() >= 8) {
	                    e.consume();
	                }
	            }
	        });

	        EmployeeID_tf.setBounds(763, 11, 139, 50);
	        Down_pnl.add(EmployeeID_tf);

	
	     // Create a JTextField for entering the department
	        Department_tf = new JTextField();
	        Department_tf.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
	        Department_tf.setText("Enter Department Field");
	        Department_tf.setColumns(10);

	        // Add FocusListener to handle focus events on the text field
	        Department_tf.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusLost(FocusEvent e) {
	        		// When the field loses focus and is empty, set the default text and color
	        		if (Department_tf.getText().equals("")) {
	        			Department_tf.setForeground(new Color(96, 96, 96));
	        			Department_tf.setText("Enter Department Field");
	        		}
	        	}

	        	@Override
	        	public void focusGained(FocusEvent e) {
	        		// When the field gains focus and contains default text, change the color and clear the text
	        		if (Department_tf.getText().equals("Enter Department Field")) {
	        			Department_tf.setForeground(Color.BLACK);
	        			Department_tf.setText("");
	        		}
	        	}
	        });

	        Department_tf.setBounds(437, 12, 303, 48);
	        Down_pnl.add(Department_tf);

	        // Create a JPanel for the "Clock-In" button
	        JPanel ClockIn_pnl = new JPanel();
	        ClockIn_pnl.setBorder(new LineBorder(new Color(6, 139, 49), 2));
	        ClockIn_pnl.addMouseListener(new PanelButtonMouseAdapter(ClockIn_pnl));
	        ClockIn_pnl.setBounds(110, 72, 129, 35);
	        Down_pnl.add(ClockIn_pnl);
	        ClockIn_pnl.setLayout(null);

	        // Create a JLabel for the "Clock-In" button
	        JLabel Clock_in_lbl = new JLabel("Clock - In");
	        Clock_in_lbl.setHorizontalAlignment(SwingConstants.CENTER);
	        Clock_in_lbl.setIcon(checkinIcon);
	        Clock_in_lbl.setFont(new Font("Arial", Font.BOLD, 16));
	        Clock_in_lbl.setBounds(0, 0, 129, 35);
	        ClockIn_pnl.add(Clock_in_lbl);

	        
	        JPanel ClockOut_pnl = new JPanel();
	        ClockOut_pnl.setBorder(new LineBorder(new Color(6, 139, 49), 2));
	        ClockOut_pnl.addMouseListener(new PanelButtonMouseAdapter2(ClockOut_pnl));
	        ClockOut_pnl.setLayout(null);
	        ClockOut_pnl.setBounds(283, 72, 129, 35);
	        Down_pnl.add(ClockOut_pnl);
	        
	        JLabel Clock_out_lbl = new JLabel("Clock - Out");
	        Clock_out_lbl.setHorizontalAlignment(SwingConstants.CENTER);
	        Clock_out_lbl.setIcon(checkoutIcon);
	        Clock_out_lbl.setFont(new Font("Arial", Font.BOLD, 16));
	        Clock_out_lbl.setBounds(0, 0, 129, 35);
	        ClockOut_pnl.add(Clock_out_lbl);
	        
	        JPanel BreakIn_pnl = new JPanel();
	        BreakIn_pnl.setBorder(new LineBorder(new Color(6, 139, 49), 2));
	        BreakIn_pnl.addMouseListener(new PanelButtonMouseAdapter3(BreakIn_pnl));
	        BreakIn_pnl.setLayout(null);
	        BreakIn_pnl.setBounds(437, 71, 129, 35);
	        Down_pnl.add(BreakIn_pnl);
	        
	        JLabel BreakIn_lbl = new JLabel("Break - In");
	        BreakIn_lbl.setHorizontalAlignment(SwingConstants.CENTER);
	        BreakIn_lbl.setIcon(breakinIcon);
	        BreakIn_lbl.setFont(new Font("Arial", Font.BOLD, 16));
	        BreakIn_lbl.setBounds(0, 0, 129, 35);
	        BreakIn_pnl.add(BreakIn_lbl);
	        
	        JPanel BreakOut_pnl = new JPanel();
	        BreakOut_pnl.setBorder(new LineBorder(new Color(6, 139, 49), 2));
	        BreakOut_pnl.addMouseListener(new PanelButtonMouseAdapter4(BreakOut_pnl));
	        BreakOut_pnl.setLayout(null);
	        BreakOut_pnl.setBounds(610, 71, 129, 35);
	        Down_pnl.add(BreakOut_pnl);
	        
	        JLabel lblBreakOut = new JLabel("Break - Out");
	        lblBreakOut.setHorizontalAlignment(SwingConstants.CENTER);
	        lblBreakOut.setIcon(breakoutIcon);
	        lblBreakOut.setFont(new Font("Arial", Font.BOLD, 16));
	        lblBreakOut.setBounds(0, 0, 129, 35);
	        BreakOut_pnl.add(lblBreakOut);
	        
	        JPanel WorkFile_pnl = new JPanel();
	        WorkFile_pnl.setBorder(new LineBorder(new Color(6, 139, 49), 2));
	        WorkFile_pnl.addMouseListener(new PanelButtonMouseAdapter5(WorkFile_pnl));
	        WorkFile_pnl.setLayout(null);
	        WorkFile_pnl.setBounds(765, 72, 139, 35);
	        Down_pnl.add(WorkFile_pnl);
	        
	        JLabel WorkFile_lbl = new JLabel("Work File");
	        WorkFile_lbl.setHorizontalAlignment(SwingConstants.CENTER);
	        WorkFile_lbl.setIcon(worksheeticon);
	        WorkFile_lbl.setFont(new Font("Arial", Font.BOLD, 16));
	        WorkFile_lbl.setBounds(0, 0, 139, 35);
	        WorkFile_pnl.add(WorkFile_lbl);
	        
	        JPanel View_pnl = new JPanel();
	        View_pnl.setLayout(null);
	        View_pnl.addMouseListener(new PanelButtonMouseAdapter6(View_pnl));
	        View_pnl.setBorder(new LineBorder(new Color(6, 139, 49), 2));
	        View_pnl.setBounds(948, 11, 116, 96);
	        Down_pnl.add(View_pnl);
	        
	        JLabel View_lbl = new JLabel("View");
	        View_lbl.setHorizontalAlignment(SwingConstants.CENTER);
	        View_lbl.setIcon(viewIcon);
	        View_lbl.setFont(new Font("Arial", Font.BOLD, 20));
	        View_lbl.setBounds(0, 21, 116, 64);
	        View_pnl.add(View_lbl);
	    }
	
	
	 // Helper method to get the current time in HH:mm format
	 // This method retrieves the current time (hours and minutes) in the desired format
	 private String getCurrentTime() {
	     SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	     Date now = new Date();
	     return sdf.format(now);
	 }

	 // Helper method to update the table data and save it to a database (text file)
	 // The database file path is "C:\\Users\\rafae\\txt\\DatabaseAttendance.txt"
	 // This method updates the table data and saves it to the database file
	 private void updateAndSaveToFile() {
	     try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\rafae\\txt\\DatabaseAttendance.txt"))) {
	         int rowCount = tableModel.getRowCount();
	         int columnCount = tableModel.getColumnCount();
	         StringBuilder sb = new StringBuilder();

	         // Write the table headers
	         for (int i = 0; i < columnCount; i++) {
	             sb.append(tableModel.getColumnName(i));
	             if (i < columnCount - 1) {
	                 sb.append("\t");
	             }
	         }
	         sb.append(System.lineSeparator());

	         // Write the table data
	         for (int i = 0; i < rowCount; i++) {
	             for (int j = 0; j < columnCount; j++) {
	                 Object value = tableModel.getValueAt(i, j);
	                 sb.append(value);
	                 if (j < columnCount - 1) {
	                     sb.append("\t");
	                 }
	             }
	             sb.append(System.lineSeparator());
	         }

	         writer.write(sb.toString());
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	 }

	 // Helper method to load local table data from a file
	 // The database file path is "C:\\Users\\rafae\\txt\\DatabaseAttendance.txt"
	 // This method loads data from the database file into the designated table
	 private void loadTableDataFromFile() {
	     // Load data from file into table
	     try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\rafae\\txt\\DatabaseAttendance.txt"))) {
	         // Clear existing data
	         tableModel.setRowCount(0);

	         String line;
	         while ((line = reader.readLine()) != null) {
	             String[] rowData = line.split("\t");
	             tableModel.addRow(rowData);
	         }
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	 }

	
	 // PanelButtonMouseAdapter class for handling the check-in panel effect and function
	    private class PanelButtonMouseAdapter extends MouseAdapter {
	        
	        JPanel panel;
	        
	        public PanelButtonMouseAdapter(JPanel panel) {
	            this.panel = panel;
	        }
	        
	        // Change panel background color when mouse enters
	        public void mouseEntered(MouseEvent e) {
	            panel.setBackground(new Color(6, 137, 49));
	        }
	        
	        // Change panel background color when mouse exits
	        @Override
	        public void mouseExited(MouseEvent e) {
	            panel.setBackground(new Color(240, 240, 240));
	        }
	        
	        @Override
	        public void mousePressed(MouseEvent e) {
	            panel.setBackground(new Color(6, 137, 49));
	            
	            // Get input values from text fields
	            String employeeName = EmployeeName_tf.getText();
	            String employeeID = EmployeeID_tf.getText();
	            String department = Department_tf.getText();
	            String checkInTime = getCurrentTime();
	            
	            // Create an Employee object with the input values
	            Employee employee = new Employee(employeeName, employeeID);
	            employee.setDepartment(department);
	            employee.setCheckInTime(checkInTime);
	            
	            // Check if any of the fields are empty
	            if (EmployeeName_tf.getText().isEmpty() || EmployeeID_tf.getText().isEmpty() || Department_tf.getText().isEmpty()) {
	                JOptionPane.showMessageDialog(null, "Fill up all the fields");
	            } else {
	                // Create a row of data with the employee information
	                Object[] rowData = {
	                    employee.getName(),
	                    employee.getID(),
	                    employee.getCheckInTime(),
	                    employee.getDepartment(),
	                    "",
	                    "",
	                    "",
	                    ""
	                };
	                
	                // Add the row to the table model
	                tableModel.addRow(rowData);
	                
	                // Clear the text fields
	                EmployeeName_tf.setText("");
	                EmployeeID_tf.setText("");
	                Department_tf.setText("");
	            }
	        } 
	        
	        @Override
	        public void mouseReleased(MouseEvent e) {
	            panel.setBackground(new Color(240, 240, 240));
	        }
	    }

	  
	    
	    private class PanelButtonMouseAdapter2 extends MouseAdapter {
	        
	        JPanel panel;
	        
	        public PanelButtonMouseAdapter2(JPanel panel) {
	            this.panel = panel;
	        }
	        
	        // Change panel background color when mouse enters
	        public void mouseEntered(MouseEvent e) {
	            panel.setBackground(new Color(6, 137, 49));
	        }
	        
	        // Change panel background color when mouse exits
	        @Override
	        public void mouseExited(MouseEvent e) {
	            panel.setBackground(new Color(240, 240, 240));
	        }
	        
	        @Override
	        public void mousePressed(MouseEvent e) {
	            panel.setBackground(new Color(6, 137, 49));
	            
	            // Check-out function
	            int selectedRow = table.getSelectedRow();
	            if (selectedRow != -1) {
	                String hours = JOptionPane.showInputDialog(null, "How long was your duty?");
	                if (hours != null && !hours.isEmpty()) {
	                    hours += "        \n";                // Add spacing after the hour value
	                    table.setValueAt(hours, selectedRow, 7); // Assuming the total hours column index is 7
	                    updateAndSaveToFile();
	                    JOptionPane.showMessageDialog(null, "Attendance saved successfully.", "Message", JOptionPane.INFORMATION_MESSAGE);
	                }
	            }
	        } 
	        
	        @Override
	        public void mouseReleased(MouseEvent e) {
	            panel.setBackground(new Color(240, 240, 240));
	        }
	    }

	
	    
	    private class PanelButtonMouseAdapter3 extends MouseAdapter {
	        
	        JPanel panel;
	        
	        public PanelButtonMouseAdapter3(JPanel panel) {
	            this.panel = panel;
	        }
	        
	        // Change panel background color when mouse enters
	        public void mouseEntered(MouseEvent e) {
	            panel.setBackground(new Color(6, 137, 49));
	        }
	        
	        // Change panel background color when mouse exits
	        @Override
	        public void mouseExited(MouseEvent e) {
	            panel.setBackground(new Color(240, 240, 240));
	        }
	        
	        @Override
	        public void mousePressed(MouseEvent e) {
	            panel.setBackground(new Color(6, 137, 49));
	            
	            // Handle break-in time functionality
	            int selectedRow = table.getSelectedRow();
	            if (selectedRow != -1) {
	                String breakInTime = getCurrentTime();
	                table.setValueAt(breakInTime, selectedRow, 5); // Assuming the break-in time column index is 5
	            }
	        } 
	        
	        @Override
	        public void mouseReleased(MouseEvent e) {
	            panel.setBackground(new Color(240, 240, 240));
	        }
	    }

		
	    private class PanelButtonMouseAdapter4 extends MouseAdapter {
	        
	        JPanel panel;
	        
	        public PanelButtonMouseAdapter4(JPanel panel) {
	            this.panel = panel;
	        }
	        
	        // Change panel background color when mouse enters
	        public void mouseEntered(MouseEvent e) {
	            panel.setBackground(new Color(6, 137, 49));
	        }
	        
	        // Change panel background color when mouse exits
	        @Override
	        public void mouseExited(MouseEvent e) {
	            panel.setBackground(new Color(240, 240, 240));
	        }
	        
	        @Override
	        public void mousePressed(MouseEvent e) {
	            panel.setBackground(new Color(6, 137, 49));
	            
	            // Handle break-out time functionality
	            int selectedRow = table.getSelectedRow();
	            if (selectedRow != -1) {
	                String breakOutTime = getCurrentTime();
	                table.setValueAt(breakOutTime, selectedRow, 6); // Assuming the break-out time column index is 6
	            }
	        } 
	        
	        @Override
	        public void mouseReleased(MouseEvent e) {
	            panel.setBackground(new Color(240, 240, 240));
	        }
	    }

		
		// Insert Work Sheet Panel Effect and Functions 
	private class PanelButtonMouseAdapter5 extends MouseAdapter {
    
    JPanel panel;
    
    public PanelButtonMouseAdapter5(JPanel panel) {
        this.panel = panel;
    }
    
    // Change panel background color when mouse enters
    public void mouseEntered(MouseEvent e) {
        panel.setBackground(new Color(6, 137, 49));
    }
    
    // Change panel background color when mouse exits
    @Override
    public void mouseExited(MouseEvent e) {
        panel.setBackground(new Color(240, 240, 240));
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        panel.setBackground(new Color(6, 137, 49));
        
        // Handle file selection functionality
        JFileChooser fileChooser = new JFileChooser();
        
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getName();
            table.setValueAt(fileName, table.getSelectedRow(), 4); // Assuming the work file column index is 4

            // Save the file name in a text file
            try {
                FileWriter writer = new FileWriter("C:\\Users\\rafae\\txt\\DatabaseAttendance.txt", true);
                writer.write(fileName + System.lineSeparator());
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    } 
    
    @Override
    public void mouseReleased(MouseEvent e) {
        panel.setBackground(new Color(240, 240, 240));
    }
}

// PanelButtonMouseAdapter6 class for handling attendance JTable show panel effect and function
private class PanelButtonMouseAdapter6 extends MouseAdapter {
    
    JPanel panel;
    
    public PanelButtonMouseAdapter6(JPanel panel) {
        this.panel = panel;
    }
    
    // Change panel background color when mouse enters
    public void mouseEntered(MouseEvent e) {
        panel.setBackground(new Color(6, 137, 49));
    }
    
    // Change panel background color when mouse exits
    @Override
    public void mouseExited(MouseEvent e) {
        panel.setBackground(new Color(240, 240, 240));
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        panel.setBackground(new Color(6, 137, 49));
        
        super.mouseClicked(e);
        loadTableDataFromFile(); // Call the method to load table data from file
    } 
    
    @Override
    public void mouseReleased(MouseEvent e) {
        panel.setBackground(new Color(240, 240, 240));
    }
}
	}
