package AnimoGUI;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class AdminUI extends javax.swing.JFrame {
    private Component controllingFrame;
    String AdminPass = AdminLoginUI.AdminPass;
    //put the corresponding String of possible items here for the DropDown; please keep Default
    String[] CourseCodeDropDown = {"","INTESYS","INTRODB", "DIGIDES", "CCSCAL2",
                                   "CCSCAL1","FTTEAMS", "FTSPORT", "FTDANCE",
                                   "FITWELL", "CCSALGE", "CCSTRIG"};
    String[] DaysDropDown = {"", "MW", "TH", "M", "T", "W", "H", "F"};
    String[] TimeDropDown = {"", "0730-0900", "0915-1045", "1100-1230", "1245-1415",
                             "1430-1600", "1614-1745", "1745-1915"};
    String[] FacultyDropDown = {"", "10001","1001","1002","2001","3001","4001","5001", "6001", "7001", "8001", "9001"};
    String[] degreeDropDown = {"", "ECE","CS-CSE", "INSYS", "CS-IST","CS-ST", "CW"};
    
    private DefaultTableModel deptModel, facultyModel, courseModel, offeringModel,
                              studentModel, transModel;
   
    DateFormat dateFormat = new SimpleDateFormat("HH:mm, MM/dd/yyyy");
    DateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat timeFormat =  new SimpleDateFormat("HH:mm");
    Date date = new Date();
    
    dbConnection connect = new dbConnection();
    Connection con = connect.connectDB();
    Statement st = connect.getStatement();
    String statement;
    ResultSet rs;
    
    /**
     * Creates new form AdminUI
     */
    public AdminUI() {
        initComponents();
        
        OfferingCourseCodeDropDown.setModel(new javax.swing.DefaultComboBoxModel(CourseCodeDropDown));
        OfferingDaysDropDown.setModel(new javax.swing.DefaultComboBoxModel(DaysDropDown));
        OfferingTimeDropDown.setModel(new javax.swing.DefaultComboBoxModel(TimeDropDown));
        OfferingFaculty.setModel(new javax.swing.DefaultComboBoxModel(FacultyDropDown));
        degreeCombo.setModel(new javax.swing.DefaultComboBoxModel(degreeDropDown));
        
        deptModel = (DefaultTableModel) deptTable.getModel();
        facultyModel = (DefaultTableModel) facultyTable.getModel();
        courseModel = (DefaultTableModel) courseTable.getModel();
        offeringModel = (DefaultTableModel) offeringTable.getModel();
        studentModel = (DefaultTableModel) studentTable.getModel();
        transModel = (DefaultTableModel) transTable.getModel();
        
        refreshAll();
    }
    
    private void refreshAll(){
        //clearing the tables
        deptModel.getDataVector().removeAllElements();
        facultyModel.getDataVector().removeAllElements();
        courseModel.getDataVector().removeAllElements();
        offeringModel.getDataVector().removeAllElements();
        studentModel.getDataVector().removeAllElements();
        transModel.getDataVector().removeAllElements();
        
        //updating the tables
        deptModel.fireTableDataChanged();
        facultyModel.fireTableDataChanged();
        courseModel.fireTableDataChanged();
        offeringModel.fireTableDataChanged();
        studentModel.fireTableDataChanged();
        transModel.fireTableDataChanged();

        //list of depts
        try{
            statement = "SELECT * FROM department;";
            rs = st.executeQuery(statement);
			
            Object temp[];
			
            while(rs.next()){
		temp = new Object[]{rs.getString(1),rs.getString(2), rs.getString(3)};
                deptModel.addRow(temp);
            }
        }catch(Exception e){
            System.out.print(e);
	}
        
        try{
            statement = "SELECT * FROM faculty;";
            rs = st.executeQuery(statement);
			
            Object temp[];
			
            while(rs.next()){
		temp = new Object[]{rs.getString(1),rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(8)};
                facultyModel.addRow(temp);
            }
        }catch(Exception e){
            System.out.print(e);
	}
        
        try{
            statement = "SELECT * FROM course;";
            rs = st.executeQuery(statement);
			
            Object temp[];
			
            while(rs.next()){
		temp = new Object[]{rs.getString(1),rs.getString(2), rs.getInt(3),rs.getString(4)};
                courseModel.addRow(temp);
            }
        }catch(Exception e){
            System.out.print(e);
	}
        
        try{
            statement = "SELECT * FROM offering;";
            rs = st.executeQuery(statement);
			
            Object temp[];
			
            while(rs.next()){
		temp = new Object[]{rs.getString(1),rs.getString(10), rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(11)};
                offeringModel.addRow(temp);
            }
        }catch(Exception e){
            System.out.print(e);
	}
        
        try{
            statement = "SELECT * FROM student;";
            rs = st.executeQuery(statement);
			
            Object temp[];
			
            while(rs.next()){
		temp = new Object[]{rs.getInt(1),rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6),rs.getInt(10), rs.getInt(11)};
                studentModel.addRow(temp);
            }
        }catch(Exception e){
            System.out.print(e);
	}
        
        try{
            statement = "SELECT * FROM transaction_record;";
            rs = st.executeQuery(statement);
			
            Object temp[];
			
            while(rs.next()){
		temp = new Object[]{rs.getInt(1),rs.getDate(2), rs.getString(3),rs.getString(4), rs.getInt(5),rs.getInt(6)};
                transModel.addRow(temp);
            }
        }catch(Exception e){
            System.out.print(e);
	}  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AdminUI = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        LogoutButon = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        Department = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        deptTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        DeptNoField = new javax.swing.JTextField();
        DeptNameField = new javax.swing.JTextField();
        DeptHeadField = new javax.swing.JTextField();
        DepartmentAddButton = new javax.swing.JButton();
        DepartmentDeleteButton = new javax.swing.JButton();
        DepartmentSearchButton = new javax.swing.JButton();
        DepartmentSaveChangesButton = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        Faculty = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        facultyTable = new javax.swing.JTable();
        FacultyIDLabel = new javax.swing.JLabel();
        FacultyLastNameLabel = new javax.swing.JLabel();
        FacultyFirstNameLabel = new javax.swing.JLabel();
        FacultyEmailAddressLAbel = new javax.swing.JLabel();
        FacultyDeptNoLabel = new javax.swing.JLabel();
        FacultyIDField = new javax.swing.JTextField();
        FacultyLastNameField = new javax.swing.JTextField();
        FacultyFirstNameField = new javax.swing.JTextField();
        FacultyEmailAddField = new javax.swing.JTextField();
        FacultyDeptNoField = new javax.swing.JTextField();
        FireButton = new javax.swing.JButton();
        FacultySearchButton = new javax.swing.JButton();
        HireButton = new javax.swing.JButton();
        SaveChanges = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        Courses = new javax.swing.JPanel();
        CoursesAddButton = new javax.swing.JButton();
        CoursesDeleteButton = new javax.swing.JButton();
        CoursesSearchButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();
        CourseCodeField = new javax.swing.JTextField();
        CourseNameField = new javax.swing.JTextField();
        UnitsField = new javax.swing.JTextField();
        CourseDepartmentField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CoursesSaveChangesButton = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        Offerings = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        offeringTable = new javax.swing.JTable();
        OfferingCourseNoLabel = new javax.swing.JLabel();
        OfferingCourseCodeLabel = new javax.swing.JLabel();
        OfferingSectionLabel = new javax.swing.JLabel();
        OfferingDaysLabel = new javax.swing.JLabel();
        OfferingTimeLabel = new javax.swing.JLabel();
        OfferingRoomNumberLabel = new javax.swing.JLabel();
        OfferingCapacityLabel = new javax.swing.JLabel();
        OfferingCourseCodeDropDown = new javax.swing.JComboBox();
        OfferingTimeDropDown = new javax.swing.JComboBox();
        OfferingSectionField = new javax.swing.JTextField();
        OfferingCourseNoField = new javax.swing.JTextField();
        OfferingDaysDropDown = new javax.swing.JComboBox();
        OfferingRoomNumberField = new javax.swing.JTextField();
        OfferingCapacityField = new javax.swing.JTextField();
        OfferingSearchButton = new javax.swing.JButton();
        OfferingAddButoon = new javax.swing.JButton();
        OfferingDeleteButton = new javax.swing.JButton();
        OfferingSaveChangesButton = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        OfferingFaculty = new javax.swing.JComboBox();
        Student = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        StudentIDLabel = new javax.swing.JLabel();
        StudentLastNameLabel = new javax.swing.JLabel();
        StudentFirstNameLabel = new javax.swing.JLabel();
        StudentEmailAddressLabel = new javax.swing.JLabel();
        StudentIDField = new javax.swing.JTextField();
        StudentLastNameField = new javax.swing.JTextField();
        StudentFirstNameField = new javax.swing.JTextField();
        StudentEmailAddressField = new javax.swing.JTextField();
        StudentSearchButton = new javax.swing.JButton();
        StudentAddButton = new javax.swing.JButton();
        StudentDeleteButton = new javax.swing.JButton();
        StudentSaveChangesButton = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        degreeCombo = new javax.swing.JComboBox();
        Transactions = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel31.setText("Date:");

        jLabel32.setText(dateFormat.format(date));

        LogoutButon.setText("Logout");
        LogoutButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButonActionPerformed(evt);
            }
        });

        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel32))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ExitButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LogoutButon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(750, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addGap(18, 18, 18)
                .addComponent(LogoutButon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExitButton)
                .addContainerGap(401, Short.MAX_VALUE))
        );

        AdminUI.addTab("Home", jPanel1);

        deptTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Department Number", "Department Name", "Department Head"
            }
        ));
        deptTable.setColumnSelectionAllowed(true);
        deptTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deptTableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(deptTable);
        deptTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel9.setText("Department Number");

        jLabel11.setText("Department Head");

        jLabel12.setText("Department Name");

        DeptHeadField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeptHeadFieldActionPerformed(evt);
            }
        });

        DepartmentAddButton.setText("Add");
        DepartmentAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartmentAddButtonActionPerformed(evt);
            }
        });

        DepartmentDeleteButton.setText("Delete");
        DepartmentDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartmentDeleteButtonActionPerformed(evt);
            }
        });

        DepartmentSearchButton.setText("Search");
        DepartmentSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartmentSearchButtonActionPerformed(evt);
            }
        });

        DepartmentSaveChangesButton.setText("Save Changes");
        DepartmentSaveChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartmentSaveChangesButtonActionPerformed(evt);
            }
        });

        jLabel26.setText("Note: To edit the table permanently, press Save Changes");

        javax.swing.GroupLayout DepartmentLayout = new javax.swing.GroupLayout(Department);
        Department.setLayout(DepartmentLayout);
        DepartmentLayout.setHorizontalGroup(
            DepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
            .addGroup(DepartmentLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(DepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DepartmentSearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DepartmentAddButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DepartmentDeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(DepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DepartmentLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(DepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DepartmentLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)))
                .addGroup(DepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DepartmentLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(DepartmentSaveChangesButton))
                    .addGroup(DepartmentLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(DepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DeptNoField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DeptNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DeptHeadField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DepartmentLayout.createSequentialGroup()
                .addContainerGap(328, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(258, 258, 258))
        );
        DepartmentLayout.setVerticalGroup(
            DepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DepartmentLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(DepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeptNoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(DepartmentSearchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DepartmentLayout.createSequentialGroup()
                        .addGroup(DepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(DeptNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addComponent(DepartmentAddButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(DepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DepartmentLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(DepartmentSaveChangesButton))
                    .addGroup(DepartmentLayout.createSequentialGroup()
                        .addGroup(DepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DepartmentDeleteButton)
                            .addComponent(DeptHeadField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        AdminUI.addTab("Department", Department);

        facultyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Faculty ID", "Last Name", "First Name", "Email Address", "Department Number"
            }
        ));
        facultyTable.setColumnSelectionAllowed(true);
        jScrollPane3.setViewportView(facultyTable);
        facultyTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        FacultyIDLabel.setText("Faculty ID");

        FacultyLastNameLabel.setText("Last Name");

        FacultyFirstNameLabel.setText("First Name");

        FacultyEmailAddressLAbel.setText("Email Address");

        FacultyDeptNoLabel.setText("Department Number");

        FacultyFirstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacultyFirstNameFieldActionPerformed(evt);
            }
        });

        FacultyEmailAddField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacultyEmailAddFieldActionPerformed(evt);
            }
        });

        FireButton.setText("Fire");
        FireButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FireButtonActionPerformed(evt);
            }
        });

        FacultySearchButton.setText("Search");
        FacultySearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacultySearchButtonActionPerformed(evt);
            }
        });

        HireButton.setText("Hire");
        HireButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HireButtonActionPerformed(evt);
            }
        });

        SaveChanges.setText("Save Changes");
        SaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveChangesActionPerformed(evt);
            }
        });

        jLabel27.setText("Note: To edit the table permanently, press Save Changes");

        javax.swing.GroupLayout FacultyLayout = new javax.swing.GroupLayout(Faculty);
        Faculty.setLayout(FacultyLayout);
        FacultyLayout.setHorizontalGroup(
            FacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(FacultyLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(FacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FacultySearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HireButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FireButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(53, 53, 53)
                .addGroup(FacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FacultyIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FacultyFirstNameLabel)
                    .addComponent(FacultyLastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(FacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(FacultyFirstNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                        .addComponent(FacultyLastNameField))
                    .addComponent(FacultyIDField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(FacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FacultyDeptNoLabel)
                    .addComponent(FacultyEmailAddressLAbel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FacultyEmailAddField, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(FacultyDeptNoField))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FacultyLayout.createSequentialGroup()
                .addContainerGap(327, Short.MAX_VALUE)
                .addGroup(FacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FacultyLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(259, 259, 259))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FacultyLayout.createSequentialGroup()
                        .addComponent(SaveChanges)
                        .addContainerGap())))
        );
        FacultyLayout.setVerticalGroup(
            FacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FacultyLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(FacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FacultySearchButton)
                    .addComponent(FacultyIDLabel)
                    .addComponent(FacultyIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FacultyEmailAddressLAbel)
                    .addComponent(FacultyEmailAddField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HireButton)
                    .addComponent(FacultyFirstNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FacultyLastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FacultyDeptNoLabel)
                    .addComponent(FacultyDeptNoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FireButton)
                    .addComponent(FacultyLastNameLabel)
                    .addComponent(FacultyFirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(SaveChanges)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        AdminUI.addTab("Faculty", Faculty);

        CoursesAddButton.setText("Add");
        CoursesAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CoursesAddButtonActionPerformed(evt);
            }
        });

        CoursesDeleteButton.setText("Delete");
        CoursesDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CoursesDeleteButtonActionPerformed(evt);
            }
        });

        CoursesSearchButton.setText("Search");
        CoursesSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CoursesSearchButtonActionPerformed(evt);
            }
        });

        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Course Code", "Course Name", "Units", "Department"
            }
        ));
        courseTable.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(courseTable);
        courseTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        UnitsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnitsFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Course Code");

        jLabel2.setText("Course Name");

        jLabel3.setText("Units");

        jLabel4.setText("Department");

        CoursesSaveChangesButton.setText("Save Changes");
        CoursesSaveChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CoursesSaveChangesButtonActionPerformed(evt);
            }
        });

        jLabel28.setText("Note: To edit the table permanently, press Save Changes");

        javax.swing.GroupLayout CoursesLayout = new javax.swing.GroupLayout(Courses);
        Courses.setLayout(CoursesLayout);
        CoursesLayout.setHorizontalGroup(
            CoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CoursesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addGap(256, 256, 256))
            .addGroup(CoursesLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(CoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CoursesSaveChangesButton)
                    .addGroup(CoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(CoursesLayout.createSequentialGroup()
                            .addGroup(CoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(CoursesDeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CoursesSearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CoursesAddButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(52, 52, 52)
                            .addGroup(CoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(CoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(CourseCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CourseNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(CoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(CoursesLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(CourseDepartmentField))
                                .addGroup(CoursesLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(43, 43, 43)
                                    .addComponent(UnitsField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 29, Short.MAX_VALUE))
        );
        CoursesLayout.setVerticalGroup(
            CoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CoursesLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(CoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CourseCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(CoursesSearchButton)
                    .addComponent(jLabel3)
                    .addComponent(UnitsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CoursesAddButton)
                    .addComponent(jLabel2)
                    .addComponent(CourseNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(CourseDepartmentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CoursesDeleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(CoursesSaveChangesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        AdminUI.addTab("Courses", Courses);

        offeringTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Course Number", "Course Code", "Section", "Schedule Days", "Time", "Room Number", "Capacity", "Enrolled","Faculty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        offeringTable.setColumnSelectionAllowed(true);
        jScrollPane5.setViewportView(offeringTable);
        offeringTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        OfferingCourseNoLabel.setText("Course Number");

        OfferingCourseCodeLabel.setText("Course Code");

        OfferingSectionLabel.setText("Section");

        OfferingDaysLabel.setText("Schedule Days");

        OfferingTimeLabel.setText("Time");

        OfferingRoomNumberLabel.setText("Room Number");

        OfferingCapacityLabel.setText("Capacity");

        OfferingCourseCodeDropDown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        OfferingCourseCodeDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OfferingCourseCodeDropDownActionPerformed(evt);
            }
        });

        OfferingTimeDropDown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        OfferingTimeDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OfferingTimeDropDownActionPerformed(evt);
            }
        });

        OfferingDaysDropDown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        OfferingDaysDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OfferingDaysDropDownActionPerformed(evt);
            }
        });

        OfferingSearchButton.setText("Search");
        OfferingSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OfferingSearchButtonActionPerformed(evt);
            }
        });

        OfferingAddButoon.setText("Add");
        OfferingAddButoon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OfferingAddButoonActionPerformed(evt);
            }
        });

        OfferingDeleteButton.setText("Delete");
        OfferingDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OfferingDeleteButtonActionPerformed(evt);
            }
        });

        OfferingSaveChangesButton.setText("Save Changes");
        OfferingSaveChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OfferingSaveChangesButtonActionPerformed(evt);
            }
        });

        jLabel29.setText("Note: To edit the table permanently, press Save Changes");

        jLabel5.setText("Faculty:");

        OfferingFaculty.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout OfferingsLayout = new javax.swing.GroupLayout(Offerings);
        Offerings.setLayout(OfferingsLayout);
        OfferingsLayout.setHorizontalGroup(
            OfferingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
            .addGroup(OfferingsLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(OfferingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(OfferingAddButoon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OfferingSearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OfferingDeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60)
                .addGroup(OfferingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(OfferingsLayout.createSequentialGroup()
                        .addComponent(OfferingSectionLabel)
                        .addGap(49, 49, 49)
                        .addComponent(OfferingSectionField))
                    .addGroup(OfferingsLayout.createSequentialGroup()
                        .addGroup(OfferingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OfferingCourseNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OfferingCourseCodeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(OfferingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(OfferingCourseNoField)
                            .addComponent(OfferingCourseCodeDropDown, 0, 96, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(OfferingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(OfferingsLayout.createSequentialGroup()
                        .addComponent(OfferingDaysLabel)
                        .addGap(18, 18, 18)
                        .addComponent(OfferingDaysDropDown, 0, 99, Short.MAX_VALUE))
                    .addGroup(OfferingsLayout.createSequentialGroup()
                        .addGroup(OfferingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OfferingTimeLabel)
                            .addComponent(OfferingRoomNumberLabel))
                        .addGap(21, 21, 21)
                        .addGroup(OfferingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OfferingTimeDropDown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(OfferingRoomNumberField))))
                .addGroup(OfferingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(OfferingsLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(OfferingFaculty, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(OfferingsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(OfferingCapacityLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(OfferingCapacityField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(173, 173, 173))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OfferingsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(OfferingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OfferingsLayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(260, 260, 260))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OfferingsLayout.createSequentialGroup()
                        .addComponent(OfferingSaveChangesButton)
                        .addContainerGap())))
        );
        OfferingsLayout.setVerticalGroup(
            OfferingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OfferingsLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(OfferingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OfferingDaysLabel)
                    .addComponent(OfferingCapacityLabel)
                    .addComponent(OfferingCourseNoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OfferingDaysDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OfferingCapacityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OfferingSearchButton)
                    .addComponent(OfferingCourseNoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OfferingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OfferingCourseCodeLabel)
                    .addComponent(OfferingTimeLabel)
                    .addComponent(OfferingCourseCodeDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OfferingTimeDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OfferingAddButoon)
                    .addComponent(jLabel5)
                    .addComponent(OfferingFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OfferingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OfferingSectionLabel)
                    .addComponent(OfferingRoomNumberLabel)
                    .addComponent(OfferingSectionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OfferingRoomNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OfferingDeleteButton))
                .addGap(16, 16, 16)
                .addComponent(OfferingSaveChangesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        AdminUI.addTab("Course Offerings", Offerings);

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Last Name", "First Name", "Email Address", "Degree", "CGPA", "Term Units"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        studentTable.setColumnSelectionAllowed(true);
        jScrollPane4.setViewportView(studentTable);
        studentTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        StudentIDLabel.setText("Student ID");

        StudentLastNameLabel.setText("Last Name");

        StudentFirstNameLabel.setText("First Name");

        StudentEmailAddressLabel.setText("Email Address");

        StudentSearchButton.setText("Search");
        StudentSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentSearchButtonActionPerformed(evt);
            }
        });

        StudentAddButton.setText("Enroll");
        StudentAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentAddButtonActionPerformed(evt);
            }
        });

        StudentDeleteButton.setText("Graduate");
        StudentDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentDeleteButtonActionPerformed(evt);
            }
        });

        StudentSaveChangesButton.setText("Save Changes");
        StudentSaveChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentSaveChangesButtonActionPerformed(evt);
            }
        });

        jLabel30.setText("Note: To edit the table permanently, press Save Changes");

        jLabel6.setText("Degree");

        degreeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout StudentLayout = new javax.swing.GroupLayout(Student);
        Student.setLayout(StudentLayout);
        StudentLayout.setHorizontalGroup(
            StudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(StudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StudentSearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(StudentAddButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(StudentDeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(71, 71, 71)
                .addGroup(StudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StudentEmailAddressLabel)
                    .addComponent(StudentIDLabel)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(StudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StudentEmailAddressField, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(StudentIDField)
                    .addComponent(degreeCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(StudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(StudentLayout.createSequentialGroup()
                        .addComponent(StudentFirstNameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(StudentFirstNameField))
                    .addGroup(StudentLayout.createSequentialGroup()
                        .addComponent(StudentLastNameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(StudentLastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StudentLayout.createSequentialGroup()
                .addContainerGap(326, Short.MAX_VALUE)
                .addGroup(StudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StudentLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(260, 260, 260))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StudentLayout.createSequentialGroup()
                        .addComponent(StudentSaveChangesButton)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StudentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        StudentLayout.setVerticalGroup(
            StudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StudentLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(StudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StudentSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StudentIDLabel)
                    .addComponent(StudentIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StudentLastNameLabel)
                    .addComponent(StudentLastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StudentAddButton)
                    .addComponent(StudentEmailAddressLabel)
                    .addComponent(StudentEmailAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StudentFirstNameLabel)
                    .addComponent(StudentFirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(StudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StudentDeleteButton)
                    .addComponent(jLabel6)
                    .addComponent(degreeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(StudentSaveChangesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        AdminUI.addTab("Students", Student);

        transTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Transaction ID", "Date Stamp", "Time Stamp", "Transaction Type", "Student ID", "Course Number"
            }
        ));
        jScrollPane1.setViewportView(transTable);

        javax.swing.GroupLayout TransactionsLayout = new javax.swing.GroupLayout(Transactions);
        Transactions.setLayout(TransactionsLayout);
        TransactionsLayout.setHorizontalGroup(
            TransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
        );
        TransactionsLayout.setVerticalGroup(
            TransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        );

        AdminUI.addTab("Transactions", Transactions);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AdminUI)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AdminUI)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UnitsFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnitsFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UnitsFieldActionPerformed

    private void CoursesAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CoursesAddButtonActionPerformed
        String Text = CourseNameField.getText();
        String Text2 = CourseCodeField.getText();
        String Text3 = UnitsField.getText();
        String Text4 = CourseDepartmentField.getText();
        
        if(Text.equals("") || Text2.equals("") || Text3.equals("") || Text4.equals(""))
            JOptionPane.showMessageDialog(controllingFrame, "Please input something in all of the text fields", "ERROR", JOptionPane.ERROR_MESSAGE);
        else{
        if(JOptionPane.showConfirmDialog(controllingFrame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            try{
                    rs = st.executeQuery(statement);
                    boolean check = true;
					
                    while(rs.next() && check){			
                        if(rs.getString(1).equals(Text) || rs.getString(2).equals(Text2)){
                            check = false;
                            JOptionPane.showMessageDialog(null, "Course already exists");
                        }
                    }
					
                    if(check){
			/*rs.moveToInsertRow();
			rs.updateString("course_code",Text);
                        rs.updateString("course_name", Text2);
			rs.updateInt("units", Integer.parseInt(Text3));
			rs.updateString("dept_num", Text4);
			rs.insertRow();
			rs.updateRow();*/
                        
                        String st1 = "INSERT INTO course (course_code, course_name, units, dept_num)"
                                    + " VALUES ('"+Text+"', '"+Text2+"', '"+Integer.parseInt(Text3)+"' , '"+Text4+"')";
                        st.execute(st1);
                    }
		}catch(Exception e){
                    System.out.println(e);
		}
				
		Object[] temp = {Text, Text2, Text3, Text4};
                courseModel.addRow(temp);
                
                CourseCodeField.setText("");
                CourseNameField.setText("");
                UnitsField.setText("");
                CourseDepartmentField.setText("");
            }
        }
    }//GEN-LAST:event_CoursesAddButtonActionPerformed

    private void DeptHeadFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeptHeadFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeptHeadFieldActionPerformed

    private void DepartmentDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartmentDeleteButtonActionPerformed
        if(JOptionPane.showConfirmDialog(controllingFrame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            try{
                
		rs = st.executeQuery(statement);
		rs.absolute(deptTable.getSelectedRow()+1);
		rs.deleteRow();
               
                //st.execute("DELETE FROM department ")   
                     
            }catch(Exception e){
		System.out.println(e);
            }
				
            deptModel.removeRow(deptTable.getSelectedRow());
        }
        
    
    }//GEN-LAST:event_DepartmentDeleteButtonActionPerformed

    private void OfferingCourseCodeDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OfferingCourseCodeDropDownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OfferingCourseCodeDropDownActionPerformed

    private void DepartmentSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartmentSearchButtonActionPerformed
        String Text = DeptNoField.getText();
        String Text2 = DeptNameField.getText();
        String Text3 = DeptHeadField.getText();
        if(Text.equals("") && Text2.equals("") && Text3.equals("")){
            JOptionPane.showMessageDialog(controllingFrame, "Please input either Dept number or Dept name only", "ERROR", JOptionPane.ERROR_MESSAGE);
            refreshAll();
        }
        else{       
            deptModel.getDataVector().removeAllElements();
            deptModel.fireTableDataChanged();
            
            if(Text2.equals("") && !Text.equals("")){
                try{
                    statement = "SELECT * FROM department WHERE dept_num = '"+ Text + "';";
                    rs = st.executeQuery(statement);

                    Object temp[];

                    while(rs.next()){
                        temp = new Object[]{rs.getString(1),rs.getString(2), rs.getString(3)};
                        deptModel.addRow(temp);
                    }
                }catch(Exception e){
                    System.out.print(e);
                }
            }
            else if(Text.equals("") && !Text2.equals("")){
                 try{
                    statement = "SELECT * FROM department WHERE dept_name = '"+ Text2 + "';";
                    rs = st.executeQuery(statement);

                    Object temp[];

                    while(rs.next()){
                        temp = new Object[]{rs.getString(1),rs.getString(2), rs.getString(3)};
                        deptModel.addRow(temp);
                    }
                }catch(Exception e){
                    System.out.print(e);
                }
            }
            
            DeptNoField.setText("");
            DeptNameField.setText("");
            DeptHeadField.setText("");
        }
    }//GEN-LAST:event_DepartmentSearchButtonActionPerformed

    private void LogoutButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButonActionPerformed
        if(JOptionPane.showConfirmDialog(controllingFrame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            connect.closeConnection();
            this.dispose();
            WhoUI s = new WhoUI();
            s.setVisible(true);
        }
    }//GEN-LAST:event_LogoutButonActionPerformed

    private void StudentSaveChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentSaveChangesButtonActionPerformed
        if(JOptionPane.showConfirmDialog(controllingFrame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            //if Yes
        }
    }//GEN-LAST:event_StudentSaveChangesButtonActionPerformed

    private void StudentDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentDeleteButtonActionPerformed
        if(JOptionPane.showConfirmDialog(controllingFrame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            try{
		rs = st.executeQuery(statement);
		rs.absolute(studentTable.getSelectedRow()+1);
		rs.updateString("to_date", sqlFormat.format(date));
                
                 //st.execute("UPDATE student SET status= 'GRADUATE'");
            }catch(Exception e){
		System.out.println(e);
            }
				
            studentModel.removeRow(studentTable.getSelectedRow());
        }
    }//GEN-LAST:event_StudentDeleteButtonActionPerformed

    private void StudentAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentAddButtonActionPerformed
        String Text = StudentIDField.getText();
        String Text2 = StudentLastNameField.getText();
        String Text3 = StudentFirstNameField.getText();
        String Text4 = StudentEmailAddressField.getText();
        String Text5 = degreeCombo.getSelectedItem().toString();
        
        if(Text.equals("") || Text2.equals("") || Text3.equals("") || Text4.equals("") || Text5.equals(""))
            JOptionPane.showMessageDialog(controllingFrame, "Please input something in the all the text fields", "ERROR", JOptionPane.ERROR_MESSAGE); 
        else{
        if(JOptionPane.showConfirmDialog(controllingFrame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
             try{
                    rs = st.executeQuery(statement);
                    boolean check = true;
					
                    while(rs.next() && check){			
                        if(rs.getString(1).equals(Text) || rs.getString(3).equals(Text2) && rs.getString(4).equals(Text3)){
                            check = false;
                            JOptionPane.showMessageDialog(null, "Student already exists");
                        }
                    }
					
                    if(check){
                        /*
			rs.moveToInsertRow();
			rs.updateInt("student_id", Integer.parseInt(Text));
                        rs.updateString("password", "");
			rs.updateString("last_name", Text2);
			rs.updateString("first_name", Text3);
			rs.updateString("email_add", Text4);
                        rs.updateString("degree", Text5);
			rs.updateString("enroll_date", sqlFormat.format(date));
			rs.updateString("to_date", "9999-01-01");
                        rs.updateString("status", "UNDERGRADUATE");
                        rs.updateInt("cgpa", 0);
                        rs.updateInt("term_units", 0);
			rs.insertRow();
			rs.updateRow();*/
                        
                        String st1 = "INSERT INTO student (student_id, password, last_name, first_name, email_add, degree, enroll_date, to_date, status, cgpa, term_units)"
                                    + " VALUES ('"+Integer.parseInt(Text)+"', '', '"+Text2+"', '"+Text3+"' , '"+Text4+"', '"+Text5+"', '"+sqlFormat.format(date)+"', '9999-01-01', 'UNDERGRADUATE', '0', '0')";
                        st.execute(st1);
                    }
		}catch(Exception e){
                    System.out.println(e);
		}
				
		Object[] temp = {Text, Text2, Text3, Text4, Text5, 0, 0};
                studentModel.addRow(temp);
                
                StudentIDField.setText("");
                StudentLastNameField.setText("");
                StudentFirstNameField.setText("");
                StudentEmailAddressField.setText("");;
            }
        }
    }//GEN-LAST:event_StudentAddButtonActionPerformed

    private void StudentSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentSearchButtonActionPerformed
        String Text = StudentIDField.getText();
        String Text2 = StudentLastNameField.getText();
        String Text3 = StudentFirstNameField.getText();
        String Text4 = StudentEmailAddressField.getText();
       
        if(Text.equals("") && Text2.equals("") && Text3.equals("") && Text4.equals("")){
            JOptionPane.showMessageDialog(controllingFrame, "Please input either the ID or the Last name only", "ERROR", JOptionPane.ERROR_MESSAGE);
            refreshAll();
        }
        else{
            studentModel.getDataVector().removeAllElements();
            studentModel.fireTableDataChanged();
            
            if(Text2.equals("") && !Text.equals("")){
                try{
                    statement = "SELECT * FROM student WHERE student_id = '"+ Text + "';";
                    rs = st.executeQuery(statement);

                    Object temp[];

                    while(rs.next()){
                        temp = new Object[]{rs.getInt(1),rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6),rs.getInt(10), rs.getInt(11)};
                        studentModel.addRow(temp);
                    }
                }catch(Exception e){
                    System.out.print(e);
                }
            }
            else if(Text.equals("") && !Text2.equals("")){
                try{
                    statement = "SELECT * FROM student WHERE last_name LIKE '%"+ Text2 + "%';";
                    rs = st.executeQuery(statement);

                    Object temp[];

                    while(rs.next()){
                        temp = new Object[]{rs.getInt(1),rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6),rs.getInt(10), rs.getInt(11)};
                        studentModel.addRow(temp);
                    }
                }catch(Exception e){
                    System.out.print(e);
                }
            }
            
            StudentIDField.setText("");
            StudentLastNameField.setText("");
            StudentFirstNameField.setText("");
            StudentEmailAddressField.setText("");
        }
    }//GEN-LAST:event_StudentSearchButtonActionPerformed

    private void OfferingSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OfferingSearchButtonActionPerformed
        String Text = OfferingCourseNoField.getText();
        String Text2 = OfferingSectionField.getText();
        String Text3 = OfferingCapacityField.getText();
        String Text4 = OfferingRoomNumberField.getText();
        String Text5 = OfferingCourseCodeDropDown.getSelectedItem().toString();
        String Text6 = OfferingDaysDropDown.getSelectedItem().toString();
        String Text7 = OfferingTimeDropDown.getSelectedItem().toString();
        
        if(Text.equals("") && Text2.equals("") && Text3.equals("") && Text4.equals("") && Text5.equals("") && Text6.equals("") && Text7.equals("")){
            JOptionPane.showMessageDialog(controllingFrame, "Please input either Course num or Course code only", "ERROR", JOptionPane.ERROR_MESSAGE);
            refreshAll();
        }
        else{
            offeringModel.getDataVector().removeAllElements();
            offeringModel.fireTableDataChanged();
            
            if(Text5.equals("") && !Text.equals("")){
                try{
                    statement = "SELECT * FROM offering WHERE course_num = '"+ Text + "';";
                    rs = st.executeQuery(statement);

                    Object temp[];

                    while(rs.next()){
                        temp = new Object[]{rs.getString(1),rs.getString(10), rs.getInt(4),rs.getString(5), rs.getString(6),rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(11)};
                        offeringModel.addRow(temp);
                    }
                }catch(Exception e){
                    System.out.print(e);
                }
            }
            else if(Text.equals("") && !Text5.equals("")){
                try{
                    statement = "SELECT * FROM offering WHERE course_code LIKE '%"+ Text5 + "%';";
                    rs = st.executeQuery(statement);

                    Object temp[];

                    while(rs.next()){
                        temp = new Object[]{rs.getString(1),rs.getString(10), rs.getInt(4),rs.getString(5), rs.getString(6),rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(11)};
                        offeringModel.addRow(temp);
                    }
                }catch(Exception e){
                    System.out.print(e);
                }
            }
            
            OfferingCourseNoField.setText("");
            OfferingCapacityField.setText("");
            OfferingSectionField.setText("");
            OfferingRoomNumberField.setText("");
            OfferingCourseCodeDropDown.setSelectedIndex(0);
            OfferingDaysDropDown.setSelectedIndex(0);
            OfferingTimeDropDown.setSelectedIndex(0);
        }
    }//GEN-LAST:event_OfferingSearchButtonActionPerformed

    private void OfferingAddButoonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OfferingAddButoonActionPerformed
        String Text = OfferingCourseNoField.getText();
        String Text2 = OfferingSectionField.getText();
        String Text3 = OfferingCapacityField.getText();
        String Text4 = OfferingRoomNumberField.getText();
        String Text5 = OfferingCourseCodeDropDown.getSelectedItem().toString();
        String Text6 = OfferingDaysDropDown.getSelectedItem().toString();
        String Text7 = OfferingTimeDropDown.getSelectedItem().toString();
        String Text8 = OfferingFaculty.getSelectedItem().toString();
        
        if(Text.equals("") || Text2.equals("") || Text3.equals("") || Text4.equals("") || Text5.equals("Default") || Text6.equals("Default") || Text7.equals("Default"))
            JOptionPane.showMessageDialog(controllingFrame, "Please input something in all of the text fields", "ERROR", JOptionPane.ERROR_MESSAGE);
        else{
        if(JOptionPane.showConfirmDialog(controllingFrame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            try{
                    rs = st.executeQuery(statement);
                    boolean check = true;
					
                    while(rs.next() && check){			
                        if(rs.getString(1).equals(Text) && rs.getString(10).equals(Text5)){
                            check = false;
                            JOptionPane.showMessageDialog(null, "Offering already exists");
                        }
                    }
					
                    if(check){
                        /*
			rs.moveToInsertRow();
			rs.updateString("course_num",Text);
                        rs.updateString("term", "2");
			rs.updateString("acad_year", "2014-2015");
			rs.updateString("section", Text2);
			rs.updateString("sched_days", Text6);
                        rs.updateString("sched_time", Text7);
			rs.updateString("room_num", Text4);
			rs.updateInt("capacity", Integer.parseInt(Text3));
                        rs.updateInt("enrolled", 0);
			rs.updateString("faculty_id", Text8);
                        rs.updateString("course_code", Text5);
			rs.insertRow();
			rs.updateRow();
                        */
                        
                        String st1 = "INSERT INTO offering (course_num, term, acad_year, section, sched_days, sched_time, room_num, capacity, enrolled, faculty_id, course_code)"
                                    + " VALUES ('"+Text+"', '2', '2014-2015' , '"+Text2+"', '"+Text6+"', '"+Text7+"', '"+Text4+"', '"+Integer.parseInt(Text3)+"', '0', '"+Text8+"', '"+Text5+"')";
                        st.execute(st1);
                    }
		}catch(Exception e){
                    System.out.println(e);
		}
				
		Object[] temp = {Text, Text5, Text2, Text6, Text7, Text4, Text3, 0, Text8};
                offeringModel.addRow(temp);
                
                OfferingCourseNoField.setText("");
                OfferingCapacityField.setText("");
                OfferingSectionField.setText("");
                OfferingRoomNumberField.setText("");
                OfferingCourseCodeDropDown.setSelectedIndex(0);
                OfferingDaysDropDown.setSelectedIndex(0);
                OfferingTimeDropDown.setSelectedIndex(0);
                OfferingFaculty.setSelectedIndex(0);
            }
       }
    }//GEN-LAST:event_OfferingAddButoonActionPerformed

    private void OfferingDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OfferingDeleteButtonActionPerformed
        if(JOptionPane.showConfirmDialog(controllingFrame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            try{
		rs = st.executeQuery(statement);
		rs.absolute(offeringTable.getSelectedRow()+1);
		rs.deleteRow();
            }catch(Exception e){
		System.out.println(e);
            }
				
            offeringModel.removeRow(offeringTable.getSelectedRow());
        }
    }//GEN-LAST:event_OfferingDeleteButtonActionPerformed

    private void OfferingSaveChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OfferingSaveChangesButtonActionPerformed
        if(JOptionPane.showConfirmDialog(controllingFrame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            //if Yes
        }
    }//GEN-LAST:event_OfferingSaveChangesButtonActionPerformed

    private void CoursesSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CoursesSearchButtonActionPerformed
        String Text = CourseCodeField.getText();
        String Text4 = CourseDepartmentField.getText();
        String Text3 = UnitsField.getText();
        String Text2 = CourseNameField.getText();
        
        if(Text.equals("") && Text2.equals("") && Text3.equals("") && Text4.equals("")){
            JOptionPane.showMessageDialog(controllingFrame, "Please input either Course code or Department only", "ERROR", JOptionPane.ERROR_MESSAGE);
            refreshAll();
        }
        else{
            courseModel.getDataVector().removeAllElements();
            courseModel.fireTableDataChanged();
            
            if(Text4.equals("") && !Text.equals("")){
                try{
                    statement = "SELECT * FROM course WHERE course_code = '"+ Text + "';";
                    rs = st.executeQuery(statement);

                    Object temp[];

                    while(rs.next()){
                        temp = new Object[]{rs.getString(1),rs.getString(2), rs.getInt(3), rs.getString(4)};
                        courseModel.addRow(temp);
                    }
                }catch(Exception e){
                    System.out.print(e);
                }
            }
            else if(Text.equals("") && !Text4.equals("")){
                try{
                    statement = "SELECT * FROM course WHERE dept_num LIKE '%"+ Text4 + "%';";
                    rs = st.executeQuery(statement);

                    Object temp[];

                    while(rs.next()){
                        temp = new Object[]{rs.getString(1),rs.getString(2), rs.getInt(3), rs.getString(4)};
                        courseModel.addRow(temp);
                    }
					
                }catch(Exception e){
                    System.out.print(e);
                }
            }
            
            CourseNameField.setText("");
            CourseCodeField.setText("");
            UnitsField.setText("");
            CourseDepartmentField.setText("");
        }
    }//GEN-LAST:event_CoursesSearchButtonActionPerformed

    private void CoursesDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CoursesDeleteButtonActionPerformed
        if(JOptionPane.showConfirmDialog(controllingFrame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            try{
		rs = st.executeQuery(statement);
		rs.absolute(courseTable.getSelectedRow()+1);
		rs.deleteRow();
            }catch(Exception e){
		System.out.println(e);
            }
				
            courseModel.removeRow(courseTable.getSelectedRow());
        }
    }//GEN-LAST:event_CoursesDeleteButtonActionPerformed

    private void CoursesSaveChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CoursesSaveChangesButtonActionPerformed
       if(JOptionPane.showConfirmDialog(controllingFrame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            //if Yes
        }
    }//GEN-LAST:event_CoursesSaveChangesButtonActionPerformed

    private void DepartmentAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartmentAddButtonActionPerformed
        String num = DeptNoField.getText();
        String name = DeptNameField.getText();
        String head = DeptHeadField.getText();
        
        if(num.equals("") || name.equals("") || head.equals(""))
            JOptionPane.showMessageDialog(controllingFrame, "Please input something in all of the text fields", "ERROR", JOptionPane.ERROR_MESSAGE);
        else{   
            if(JOptionPane.showConfirmDialog(controllingFrame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            {		
		try{
                    rs = st.executeQuery(statement);
                    boolean check = true;
					
                    while(rs.next() && check){			
                        if(rs.getString(1).equals(num) || rs.getString(2).equals(name)){
                            check = false;
                            JOptionPane.showMessageDialog(null, "Department already exists");
                        }
                    }
					
                    if(check){
			/*rs.moveToInsertRow();
			rs.updateString("dept_num",name);
			rs.updateString("dept_name", num);
			rs.updateString("dept_head", head);
			rs.insertRow();
			rs.updateRow();*/
                        
                        String st1 = "INSERT INTO department (dept_num, dept_name, dept_head) VALUES ('"+name+"', '"+num+"', '"+head+"')";
                        st.execute(st1);
                    }
		}catch(Exception e){
                    System.out.println(e);
		}
				
		Object[] temp = {num, name, head};
                deptModel.addRow(temp);
                
                DeptNoField.setText("");
                DeptNameField.setText("");
                DeptHeadField.setText("");
            }
        }
    }//GEN-LAST:event_DepartmentAddButtonActionPerformed

    private void DepartmentSaveChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartmentSaveChangesButtonActionPerformed
        if(JOptionPane.showConfirmDialog(controllingFrame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            //if Yes
        }
    }//GEN-LAST:event_DepartmentSaveChangesButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        if(JOptionPane.showConfirmDialog(controllingFrame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void OfferingDaysDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OfferingDaysDropDownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OfferingDaysDropDownActionPerformed

    private void OfferingTimeDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OfferingTimeDropDownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OfferingTimeDropDownActionPerformed

    private void SaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveChangesActionPerformed
        if(JOptionPane.showConfirmDialog(controllingFrame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            //if Yes
        }
    }//GEN-LAST:event_SaveChangesActionPerformed

    private void HireButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HireButtonActionPerformed
        String ID = FacultyIDField.getText();
        String lName = FacultyLastNameField.getText();
        String fName = FacultyFirstNameField.getText();
        String email = FacultyEmailAddField.getText();
        String dept = FacultyDeptNoField.getText();
       
        if(ID.equals("") || lName.equals("") || fName.equals("") || email.equals("") || dept.equals(""))
        JOptionPane.showMessageDialog(controllingFrame, "Please input something in all of the text fields", "ERROR", JOptionPane.ERROR_MESSAGE);
        else{
            if(JOptionPane.showConfirmDialog(controllingFrame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            {
                try{
                    rs = st.executeQuery(statement);
                    boolean check = true;
					
                    while(rs.next() && check){			
                        if(rs.getString(1).equals(ID) || rs.getString(3).equals(lName) && rs.getString(4).equals(fName)){
                            check = false;
                            JOptionPane.showMessageDialog(null, "Faculty member already exists");
                        }
                    }
					
                    if(check){
                        /*
			rs.moveToInsertRow();
			rs.updateString("faculty_id",ID);
                        rs.updateString("password", "");
			rs.updateString("last_name", lName);
			rs.updateString("first_name", fName);
			rs.updateString("email_add", email);
                        rs.updateString("hire_date", sqlFormat.format(date));
			rs.updateString("to_date", "9999-01-01");
			rs.updateString("dept_num", dept);
			rs.insertRow();
			rs.updateRow();*/
                        
                        String st1 = "INSERT INTO faculty (faculty_id, password, last_name, first_name, email_add, hire_date, to_date, dept_num)"
                                    + " VALUES ('"+ID+"', '', '"+lName+"', '"+fName+"' , '"+email+"', '"+sqlFormat.format(date)+"', '9999-01-01', '"+dept+"')";
                        st.execute(st1);
                    }
		}catch(Exception e){
                    System.out.println(e);
		}
				
		Object[] temp = {ID, lName, fName, email, dept};
                facultyModel.addRow(temp);
                
                FacultyIDField.setText("");
                FacultyLastNameField.setText("");
                FacultyFirstNameField.setText("");
                FacultyEmailAddField.setText("");
                FacultyDeptNoField.setText("");
            }
        }
    }//GEN-LAST:event_HireButtonActionPerformed

    private void FacultySearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacultySearchButtonActionPerformed
        String Text = FacultyIDField.getText();
        String Text2 = FacultyLastNameField.getText();
        String Text3 = FacultyFirstNameField.getText();
        String Text4 = FacultyEmailAddField.getText();
        String Text5 = FacultyDeptNoField.getText();
        if(Text.equals("") && Text2.equals("") && Text3.equals("") && Text4.equals("") && Text5.equals("")){
            JOptionPane.showMessageDialog(controllingFrame, "Please input either ID, Last name, or Dept num only", "ERROR", JOptionPane.ERROR_MESSAGE);
            refreshAll();
        }
        else{
            facultyModel.getDataVector().removeAllElements();
            facultyModel.fireTableDataChanged();
            
            if(Text2.equals("") && Text5.equals("") && !Text.equals("")){
                try{
                    statement = "SELECT * FROM faculty WHERE faculty_id = '"+ Text + "';";
                    rs = st.executeQuery(statement);

                    Object temp[];

                    while(rs.next()){
                        temp = new Object[]{rs.getString(1),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(10)};
                        facultyModel.addRow(temp);
                    }
                }catch(Exception e){
                    System.out.print(e);
                }
            }
            else if(Text.equals("") && Text5.equals("") && !Text2.equals("")){
                try{
                    statement = "SELECT * FROM faculty WHERE last_name LIKE '%"+ Text2 + "%';";
                    rs = st.executeQuery(statement);

                    Object temp[];

                    while(rs.next()){
                        temp = new Object[]{rs.getString(1),rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(10)};
                        facultyModel.addRow(temp);
                    }
                }catch(Exception e){
                    System.out.print(e);
                }
            }
            else if(Text.equals("") && Text2.equals("") && !Text5.equals("")){
                try{
                    statement = "SELECT * FROM faculty WHERE dept_num LIKE '%"+ Text5 + "%';";
                    rs = st.executeQuery(statement);

                    Object temp[];

                    while(rs.next()){
                        temp = new Object[]{rs.getString(1),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(10)};
                        facultyModel.addRow(temp);
                    }
                }catch(Exception e){
                    System.out.print(e);
                }
            }
            
            FacultyIDField.setText("");
            FacultyLastNameField.setText("");
            FacultyFirstNameField.setText("");
            FacultyEmailAddField.setText("");
            FacultyDeptNoField.setText("");
        }
    }//GEN-LAST:event_FacultySearchButtonActionPerformed

    private void FireButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FireButtonActionPerformed
        if(JOptionPane.showConfirmDialog(controllingFrame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            try{
                /*
		rs = st.executeQuery();
		rs.absolute(facultyTable.getSelectedRow()+1);
		rs.updateString("hire_date", sqlFormat.format(date));*/
                
                st.execute("UPDATE faculty SET fire_date="+ sqlFormat.format(date));
                        
            }catch(Exception e){
		System.out.println(e);
            }
				
            facultyModel.removeRow(facultyTable.getSelectedRow());
        }
    }//GEN-LAST:event_FireButtonActionPerformed

    private void FacultyEmailAddFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacultyEmailAddFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FacultyEmailAddFieldActionPerformed

    private void FacultyFirstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacultyFirstNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FacultyFirstNameFieldActionPerformed

    private void deptTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deptTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_deptTableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane AdminUI;
    private javax.swing.JTextField CourseCodeField;
    private javax.swing.JTextField CourseDepartmentField;
    private javax.swing.JTextField CourseNameField;
    private javax.swing.JPanel Courses;
    private javax.swing.JButton CoursesAddButton;
    private javax.swing.JButton CoursesDeleteButton;
    private javax.swing.JButton CoursesSaveChangesButton;
    private javax.swing.JButton CoursesSearchButton;
    private javax.swing.JPanel Department;
    private javax.swing.JButton DepartmentAddButton;
    private javax.swing.JButton DepartmentDeleteButton;
    private javax.swing.JButton DepartmentSaveChangesButton;
    private javax.swing.JButton DepartmentSearchButton;
    private javax.swing.JTextField DeptHeadField;
    private javax.swing.JTextField DeptNameField;
    private javax.swing.JTextField DeptNoField;
    private javax.swing.JButton ExitButton;
    private javax.swing.JPanel Faculty;
    private javax.swing.JTextField FacultyDeptNoField;
    private javax.swing.JLabel FacultyDeptNoLabel;
    private javax.swing.JTextField FacultyEmailAddField;
    private javax.swing.JLabel FacultyEmailAddressLAbel;
    private javax.swing.JTextField FacultyFirstNameField;
    private javax.swing.JLabel FacultyFirstNameLabel;
    private javax.swing.JTextField FacultyIDField;
    private javax.swing.JLabel FacultyIDLabel;
    private javax.swing.JTextField FacultyLastNameField;
    private javax.swing.JLabel FacultyLastNameLabel;
    private javax.swing.JButton FacultySearchButton;
    private javax.swing.JButton FireButton;
    private javax.swing.JButton HireButton;
    private javax.swing.JButton LogoutButon;
    private javax.swing.JButton OfferingAddButoon;
    private javax.swing.JTextField OfferingCapacityField;
    private javax.swing.JLabel OfferingCapacityLabel;
    private javax.swing.JComboBox OfferingCourseCodeDropDown;
    private javax.swing.JLabel OfferingCourseCodeLabel;
    private javax.swing.JTextField OfferingCourseNoField;
    private javax.swing.JLabel OfferingCourseNoLabel;
    private javax.swing.JComboBox OfferingDaysDropDown;
    private javax.swing.JLabel OfferingDaysLabel;
    private javax.swing.JButton OfferingDeleteButton;
    private javax.swing.JComboBox OfferingFaculty;
    private javax.swing.JTextField OfferingRoomNumberField;
    private javax.swing.JLabel OfferingRoomNumberLabel;
    private javax.swing.JButton OfferingSaveChangesButton;
    private javax.swing.JButton OfferingSearchButton;
    private javax.swing.JTextField OfferingSectionField;
    private javax.swing.JLabel OfferingSectionLabel;
    private javax.swing.JComboBox OfferingTimeDropDown;
    private javax.swing.JLabel OfferingTimeLabel;
    private javax.swing.JPanel Offerings;
    private javax.swing.JButton SaveChanges;
    private javax.swing.JPanel Student;
    private javax.swing.JButton StudentAddButton;
    private javax.swing.JButton StudentDeleteButton;
    private javax.swing.JTextField StudentEmailAddressField;
    private javax.swing.JLabel StudentEmailAddressLabel;
    private javax.swing.JTextField StudentFirstNameField;
    private javax.swing.JLabel StudentFirstNameLabel;
    private javax.swing.JTextField StudentIDField;
    private javax.swing.JLabel StudentIDLabel;
    private javax.swing.JTextField StudentLastNameField;
    private javax.swing.JLabel StudentLastNameLabel;
    private javax.swing.JButton StudentSaveChangesButton;
    private javax.swing.JButton StudentSearchButton;
    private javax.swing.JPanel Transactions;
    private javax.swing.JTextField UnitsField;
    private javax.swing.JTable courseTable;
    private javax.swing.JComboBox degreeCombo;
    private javax.swing.JTable deptTable;
    private javax.swing.JTable facultyTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable offeringTable;
    private javax.swing.JTable studentTable;
    private javax.swing.JTable transTable;
    // End of variables declaration//GEN-END:variables
}
