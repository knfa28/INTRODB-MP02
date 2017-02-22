package AnimoGUI;
import java.awt.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class StudentUI extends javax.swing.JFrame {
    private Component controllingFrame;
    private String CurrentPass;
    
    private final DefaultTableModel addModel, dropModel, schedModel;
   
    DateFormat dateFormat = new SimpleDateFormat("HH:mm, MM/dd/yyyy");
    DateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat timeFormat =  new SimpleDateFormat("HH:mm");
    java.util.Date date = new java.util.Date();
    
    String password, name, email, degree, status;
    int ID, cgpa, termUnits;
    Date enroll, to;
    
    dbConnection connect = new dbConnection();
    Connection con = connect.connectDB();
    Statement st = connect.getStatement();
    String statement;
    ResultSet addRS,dropRS;
    private TableModel DefaultTableModel;
    
    public StudentUI(final ResultSet rs,String studentID) {
        try{
            password = rs.getString("password");
            name = rs.getString("last_name")+ ", " + rs.getString("first_name");
            email = rs.getString("email_add");
            degree = rs.getString("degree");
            status = rs.getString("status");

            ID = rs.getInt("student_id");
            cgpa = rs.getInt("cgpa");
            termUnits = rs.getInt("term_units");

            enroll = rs.getDate("enroll_date");
            to = rs.getDate("to_date");
        }catch(Exception e){
            System.out.println(e);
	}
        
        initComponents();
        
        addModel = (DefaultTableModel) addTable.getModel();
        dropModel = (DefaultTableModel) dropTable.getModel();
        schedModel = (DefaultTableModel) schedTable.getModel();  
        refreshTable("Course Num");
    }

    private void refreshTable(String s){
        //clearing the tables
        addModel.getDataVector().removeAllElements();
        dropModel.getDataVector().removeAllElements();
        schedModel.getDataVector().removeAllElements();
        
        //updating the tables
        addModel.fireTableDataChanged();
        dropModel.fireTableDataChanged();
        schedModel.fireTableDataChanged();

        //list of offerings
        try{
            statement = "SELECT * FROM offering where (capacity - enrolled) > 0;";
            addRS = st.executeQuery(statement);
			
            Object addTemp[];
			
            while(addRS.next()){
		addTemp = new Object[]{addRS.getInt(1),addRS.getString(10), addRS.getString(4),addRS.getString(5),addRS.getString(6), addRS.getString(7), addRS.getString(11)};
                addModel.addRow(addTemp);
            }
        }catch(Exception e){
            System.out.print(e);
	}
    
        if(s.equals("Course Num")){
            try{
                statement = "SELECT * FROM transaction_record T, offering O WHERE T.student_id = '"+ ID +"' AND T.transaction_type = 'ADD' ORDER BY O.course_num;";
                addRS = st.executeQuery(statement);

                Object addTemp[];
			
                while(addRS.next()){
                    addTemp = new Object[]{addRS.getInt(1),addRS.getString(10), addRS.getString(4),addRS.getString(5),addRS.getString(6), addRS.getString(7), addRS.getString(11)};
                    schedModel.addRow(addTemp);
                    dropModel.addRow(addTemp);
                }
            }catch(Exception e){
                System.out.print(e);
            }
        }
        else if(s.equals("Course Code")){
            try{
                statement = "SELECT * FROM transaction_record T, offering O WHERE T.student_id = '"+ ID +"' AND T.transaction_type = 'ADD' ORDER BY O.course_code;";
                addRS = st.executeQuery(statement);

                Object addTemp[];
			
                while(addRS.next()){
                    addTemp = new Object[]{addRS.getInt(1),addRS.getString(10), addRS.getString(4),addRS.getString(5),addRS.getString(6), addRS.getString(7), addRS.getString(11)};
                    schedModel.addRow(addTemp);
                    dropModel.addRow(addTemp);
                }
            }catch(Exception e){
                System.out.print(e);
            }
        }
        else if(s.equals("Days")){
            try{
                statement = "SELECT course_num FROM transaction_record T, offering O WHERE T.student_id = "+ ID +" AND T.transaction_type = 'ADD' ORDER BY O.sched_days;";
                addRS = st.executeQuery(statement);

                Object addTemp[];
			
                while(addRS.next()){
                    addTemp = new Object[]{addRS.getInt(1),addRS.getString(10), addRS.getString(4),addRS.getString(5),addRS.getString(6), addRS.getString(7), addRS.getString(11)};
                    schedModel.addRow(addTemp);
                    dropModel.addRow(addTemp);
                }
            }catch(Exception e){
                System.out.print(e);
            }
        }
         else if(s.equals("Time")){
            try{
                statement = "SELECT * FROM transaction_record T, offering O WHERE T.student_id = "+ ID +" AND transaction_type = 'ADD' ORDER BY O.sched_time;";
                addRS = st.executeQuery(statement);

                Object addTemp[];
			
                while(addRS.next()){
                    addTemp = new Object[]{addRS.getInt(1),addRS.getString(10), addRS.getString(4),addRS.getString(5),addRS.getString(6), addRS.getString(7), addRS.getString(11)};
                    schedModel.addRow(addTemp);
                    dropModel.addRow(addTemp);
                }
             }catch(Exception e){
                System.out.print(e);
            }
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        StudentInfo = new javax.swing.JLabel();
        StudentName = new javax.swing.JLabel();
        CGPA = new javax.swing.JLabel();
        StudentEmail = new javax.swing.JLabel();
        StudentNameField = new javax.swing.JLabel();
        StudentEmailField = new javax.swing.JLabel();
        CGPAField = new javax.swing.JLabel();
        CPassButton = new javax.swing.JButton();
        LastLogin = new javax.swing.JLabel();
        LastLoginDetails = new javax.swing.JLabel();
        LogoutButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        DegreeField = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ExitButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        CourseCodeField = new javax.swing.JTextField();
        AddButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        CourseNumberField = new javax.swing.JTextField();
        CourseNumberLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        addTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        DropButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dropTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        ArrangeDropDown = new javax.swing.JComboBox();
        jScrollPane7 = new javax.swing.JScrollPane();
        schedTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        StudentInfo.setText("Student Information");

        StudentName.setText("Name:");

        CGPA.setText("CGPA:");

        StudentEmail.setText("Email:");

        StudentNameField.setText(name);

        StudentEmailField.setText(email);

        CGPAField.setText(String.valueOf(cgpa));

        CPassButton.setText("Change Password");
        CPassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPassButtonActionPerformed(evt);
            }
        });

        LastLogin.setText("Date:");

        LastLoginDetails.setText(dateFormat.format(date));

        LogoutButton.setText("Logout");
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Degree:");

        DegreeField.setText(degree);

        jLabel2.setText("Status:");

        jLabel3.setText(status);

        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Term Units:");

        jLabel8.setText(String.valueOf(termUnits));

        jLabel4.setText("ID number:");

        jLabel5.setText(String.valueOf(ID));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LogoutButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(StudentInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
                        .addComponent(LastLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LastLoginDetails))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DegreeField))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(StudentName)
                                    .addComponent(jLabel4)
                                    .addComponent(StudentEmail)
                                    .addComponent(jLabel2)
                                    .addComponent(CGPA)
                                    .addComponent(jLabel6))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(StudentNameField)
                                    .addComponent(StudentEmailField)
                                    .addComponent(jLabel3)
                                    .addComponent(CGPAField)
                                    .addComponent(jLabel8))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(CPassButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LastLoginDetails)
                    .addComponent(LastLogin)
                    .addComponent(StudentInfo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StudentName)
                    .addComponent(StudentNameField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StudentEmail)
                    .addComponent(StudentEmailField))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(DegreeField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CGPAField)
                    .addComponent(CGPA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addComponent(LogoutButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExitButton)
                    .addComponent(CPassButton))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Home", jPanel1);

        jLabel7.setText("Course Code:");

        CourseCodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourseCodeFieldActionPerformed(evt);
            }
        });

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        CourseNumberLabel.setText("Course Number");

        addTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Course Num", "Course Code", "Section", "Days", "Time", "Room Number", "Professor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(addTable);
        addTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CourseCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CourseNumberLabel)
                .addGap(18, 18, 18)
                .addComponent(CourseNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(SearchButton)
                .addGap(18, 18, 18)
                .addComponent(AddButton)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(CourseCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddButton)
                    .addComponent(SearchButton)
                    .addComponent(CourseNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CourseNumberLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Add", jPanel2);

        DropButton.setText("Drop");
        DropButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DropButtonActionPerformed(evt);
            }
        });

        dropTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Course Num", "Course Code", "Section", "Days", "Time", "Room Number", "Professor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dropTable.setColumnSelectionAllowed(true);
        dropTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dropTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dropTable);
        dropTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DropButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DropButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Drop", jPanel4);

        jLabel14.setText("Arrange by:");

        ArrangeDropDown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Course Num", "Course Code", "Days", "Time" }));
        ArrangeDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArrangeDropDownActionPerformed(evt);
            }
        });

        schedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Course Num", "Course Code", "Section", "Days", "Time", "Room Number", "Professor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(schedTable);

        jButton1.setText("Sort");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ArrangeDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(ArrangeDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Schedule", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CourseCodeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourseCodeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CourseCodeFieldActionPerformed

    private void CPassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPassButtonActionPerformed
        ChangePass s = new ChangePass("student", String.valueOf(ID));
        s.setVisible(true);
    }//GEN-LAST:event_CPassButtonActionPerformed

    private void ArrangeDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArrangeDropDownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ArrangeDropDownActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        if(JOptionPane.showConfirmDialog(controllingFrame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            connect.closeConnection();
            this.dispose();
            WhoUI s = new WhoUI();
            s.setVisible(true);
        }
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        if(JOptionPane.showConfirmDialog(controllingFrame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_ExitButtonActionPerformed
  
    
    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        String Text = CourseCodeField.getText();
        int transCnt, courseNum;
        
        /*addRS = st.executeQuery("SELECT COUNT * from transaction_record;");
        addRS.next();
        transCnt = addRS.getInt("count(*)");
        if(Text.equals(""))
           JOptionPane.showMessageDialog(controllingFrame, "Please input something in the text field", "ERROR", JOptionPane.ERROR_MESSAGE);
        else{
            if(JOptionPane.showConfirmDialog(controllingFrame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            {
                String st1 = "INSERT INTO transaction_record(transaction_id, date_stamp, time_stamp, student_id, course_num)"
                           + " VALUES ('"+(transCnt++)+"', '"+sqlFormat.format(date)+"', '"+timeFormat.format(date)+"' , '"+ID+"', '"+courseNum+"')";
                st.execute(st1);
            }
        }*/
    }//GEN-LAST:event_AddButtonActionPerformed

    @SuppressWarnings("empty-statement")
    private void DropButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DropButtonActionPerformed
        if(JOptionPane.showConfirmDialog(controllingFrame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            try{
		dropRS = st.executeQuery(statement);
		dropRS.absolute(addTable.getSelectedRow()+1);
		dropRS.deleteRow();
            }catch(Exception e){
		System.out.println(e);
            }
            addModel.removeRow(addTable.getSelectedRow());
            try{
            st.execute("DELETE * FROM transaction WHERE course_code = '"+ addTable.getValueAt(addTable.getSelectedRow(), 1) +"';");
            }catch(Exception e){
            
        }
        }
    }//GEN-LAST:event_DropButtonActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        String code = CourseCodeField.getText();
        String num = CourseNumberField.getText();
        
        if(code.equals("") && num.equals("")){
            JOptionPane.showMessageDialog(controllingFrame, "Please input something in the text field", "ERROR", JOptionPane.ERROR_MESSAGE);
            refreshTable("Course Num");
        }
        else if(code.equals("")){
            addModel.getDataVector().removeAllElements();
            addModel.fireTableDataChanged();
        
            try{
                statement = "SELECT * FROM offering WHERE course_num = '"+ num +"' AND (capacity - enrolled) > 0;";
                addRS = st.executeQuery(statement);

                Object addTemp[];

                while(addRS.next()){
                    addTemp = new Object[]{addRS.getInt(1),addRS.getString(10), addRS.getString(4),addRS.getString(5),addRS.getString(6), addRS.getString(7), addRS.getString(11)};
                    addModel.addRow(addTemp);
                }
            }catch(Exception e){
                System.out.print(e);
            }
            
            CourseCodeField.setText("");
            CourseNumberField.setText("");
        }
        else{
            addModel.getDataVector().removeAllElements();
            addModel.fireTableDataChanged();
        
            try{
                statement = "SELECT * FROM offering WHERE course_code = '"+ code +"' AND (capacity - enrolled) > 0;";
                addRS = st.executeQuery(statement);

                Object addTemp[];

                while(addRS.next()){
                    addTemp = new Object[]{addRS.getInt(1),addRS.getString(10), addRS.getString(4),addRS.getString(5),addRS.getString(6), addRS.getString(7), addRS.getString(11)};
                    addModel.addRow(addTemp);
                }
            }catch(Exception e){
                System.out.print(e);
            }
            
            CourseCodeField.setText("");
            CourseNumberField.setText("");
        }
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String s = (String)ArrangeDropDown.getSelectedItem();
        refreshTable(s);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void dropTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dropTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dropTableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
	EventQueue.invokeLater(new Runnable() {
            public void run(){
		try {
                    //StudentUI frame = new StudentUI();
                    //frame.setVisible(true);
		} catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JComboBox ArrangeDropDown;
    private javax.swing.JLabel CGPA;
    private javax.swing.JLabel CGPAField;
    private javax.swing.JButton CPassButton;
    private javax.swing.JTextField CourseCodeField;
    private javax.swing.JTextField CourseNumberField;
    private javax.swing.JLabel CourseNumberLabel;
    private javax.swing.JLabel DegreeField;
    private javax.swing.JButton DropButton;
    private javax.swing.JButton ExitButton;
    private javax.swing.JLabel LastLogin;
    private javax.swing.JLabel LastLoginDetails;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel StudentEmail;
    private javax.swing.JLabel StudentEmailField;
    private javax.swing.JLabel StudentInfo;
    private javax.swing.JLabel StudentName;
    private javax.swing.JLabel StudentNameField;
    private javax.swing.JTable addTable;
    private javax.swing.JTable dropTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable schedTable;
    // End of variables declaration//GEN-END:variables
}
