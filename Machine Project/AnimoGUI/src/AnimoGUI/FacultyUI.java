package AnimoGUI;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FacultyUI extends javax.swing.JFrame {
    private Component controllingFrame;
    private String CurrentPass;
    
    private DefaultTableModel courseModel;
    private String[] dropdown = {"Course Num", "Course Code", "Enrolled"};
    
    DateFormat dateFormat = new SimpleDateFormat("HH:mm, MM/dd/yyyy");
    Date date = new Date();
    
    String ID, password, name, email, deptNum;
    int courseCnt = 0;
    Date hire, to;
    
    dbConnection connect = new dbConnection();
    Connection con = connect.connectDB();
    Statement st = connect.getStatement();
    String statement;
    ResultSet offeringRS, courseRS;
    
    public FacultyUI(final ResultSet rs,String studentID) {
        try{
            ID = rs.getString("faculty_id");
            password = rs.getString("password");
            name = rs.getString("last_name")+ ", " + rs.getString("first_name");
            email = rs.getString("email_add");
            deptNum = rs.getString("dept_num");
                    
            try{
                statement = "SELECT * FROM offering WHERE faculty_id = '"+ ID +"';";
                offeringRS = st.executeQuery(statement);

                while(offeringRS.next()){
                    courseCnt++;
                }
            }catch(Exception e){
                System.out.print(e);
            }
            
            hire = rs.getDate("hire_date");
            to = rs.getDate("to_date");
        }catch(Exception e){
            System.out.println(e);
	}
        initComponents();
        
        courseModel = (javax.swing.table.DefaultTableModel) courseTable.getModel();
        
        refreshTable("Course Num");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Faculty = new javax.swing.JTabbedPane();
        HomeTab = new javax.swing.JPanel();
        FacultyInfo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        FacultyName = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        LogoutButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        HandledCoursesTab = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        OrderByDropDown = new javax.swing.JComboBox();
        Sort = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FacultyInfo.setText("Faculty Information");

        jLabel2.setText("Name:");

        jLabel4.setText("Email:");

        FacultyName.setText(name);

        jLabel8.setText(email);

        jLabel10.setText("Number of handled courses:");

        jLabel11.setText(String.valueOf(courseCnt));

        jButton2.setText("Change Password");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel12.setText("Date:");

        jLabel13.setText(dateFormat.format(date));

        LogoutButton.setText("Logout");
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });

        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Satff ID:");

        jLabel3.setText(ID);

        jLabel5.setText("Department Number:");

        jLabel6.setText(deptNum);

        javax.swing.GroupLayout HomeTabLayout = new javax.swing.GroupLayout(HomeTab);
        HomeTab.setLayout(HomeTabLayout);
        HomeTabLayout.setHorizontalGroup(
            HomeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HomeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HomeTabLayout.createSequentialGroup()
                        .addComponent(FacultyInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 387, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeTabLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(HomeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LogoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(HomeTabLayout.createSequentialGroup()
                        .addGroup(HomeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(HomeTabLayout.createSequentialGroup()
                                .addGroup(HomeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(HomeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(FacultyName, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(HomeTabLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addGroup(HomeTabLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        HomeTabLayout.setVerticalGroup(
            HomeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HomeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FacultyInfo)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HomeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(FacultyName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HomeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HomeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HomeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HomeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(LogoutButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HomeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExitButton)
                    .addComponent(jButton2))
                .addGap(12, 12, 12))
        );

        Faculty.addTab("Home", HomeTab);

        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Course Num", "Course Code", "Section", "Days", "Time", "Room Number", "Enrolled", "Capacity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(courseTable);

        jLabel14.setText("Arrange by:");

        OrderByDropDown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Course Num", "Course Code", "Enrolled"}));
        OrderByDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderByDropDownActionPerformed(evt);
            }
        });

        Sort.setText("Sort");
        Sort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HandledCoursesTabLayout = new javax.swing.GroupLayout(HandledCoursesTab);
        HandledCoursesTab.setLayout(HandledCoursesTabLayout);
        HandledCoursesTabLayout.setHorizontalGroup(
            HandledCoursesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HandledCoursesTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OrderByDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Sort)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );
        HandledCoursesTabLayout.setVerticalGroup(
            HandledCoursesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HandledCoursesTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HandledCoursesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(OrderByDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sort))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
        );

        Faculty.addTab("Handled Courses", HandledCoursesTab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Faculty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Faculty, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshTable(String s){
        //clearing the tables
        courseModel.getDataVector().removeAllElements();
        
        //updating the tables
        courseModel.fireTableDataChanged();
        
        if(s.equals("Course Num")){
            try{
                statement = "SELECT * FROM offering where faculty_id = '"+ ID +"' ORDER BY course_num;";
                courseRS = st.executeQuery(statement);

                Object courseTemp[];

                while(courseRS.next()){
                    courseTemp = new Object[]{courseRS.getInt(1),courseRS.getString(10), courseRS.getString(4),courseRS.getString(5),courseRS.getString(6), courseRS.getString(7), courseRS.getInt(8), courseRS.getInt(9)};
                    courseModel.addRow(courseTemp);
                }
            }catch(Exception e){
                System.out.print(e);
            }
        }
        else if(s.equals("Course Code")){
            try{
                statement = "SELECT * FROM offering where faculty_id = '"+ ID +"' ORDER BY course_code;";
                courseRS = st.executeQuery(statement);

                Object courseTemp[];

                while(courseRS.next()){
                    courseTemp = new Object[]{courseRS.getInt(1),courseRS.getString(10), courseRS.getString(4),courseRS.getString(5),courseRS.getString(6), courseRS.getString(7), courseRS.getInt(8), courseRS.getInt(9)};
                    courseModel.addRow(courseTemp);
                }
            }catch(Exception e){
                System.out.print(e);
            }
        }
        else if(s.equals("Enrolled")){
            try{
                statement = "SELECT * FROM offering where faculty_id = '"+ ID +"' ORDER BY enrolled;";
                courseRS = st.executeQuery(statement);

                Object courseTemp[];

                while(courseRS.next()){
                    courseTemp = new Object[]{courseRS.getInt(1),courseRS.getString(10), courseRS.getString(4),courseRS.getString(5),courseRS.getString(6), courseRS.getString(7), courseRS.getInt(8), courseRS.getInt(9)};
                    courseModel.addRow(courseTemp);
                }
            }catch(Exception e){
                System.out.print(e);
            }
        }
    }
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ChangePass s = new ChangePass("faculty", ID);
        s.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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

    private void OrderByDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderByDropDownActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_OrderByDropDownActionPerformed

    private void SortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortActionPerformed
       String s = (String)OrderByDropDown.getSelectedItem();
       refreshTable(s);
    }//GEN-LAST:event_SortActionPerformed

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
            java.util.logging.Logger.getLogger(FacultyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacultyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacultyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacultyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {   
                try {
                     //new FacultyUI().setVisible(true);
		} catch (Exception e) {
                    e.printStackTrace();
		}
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitButton;
    private javax.swing.JTabbedPane Faculty;
    private javax.swing.JLabel FacultyInfo;
    private javax.swing.JLabel FacultyName;
    private javax.swing.JPanel HandledCoursesTab;
    private javax.swing.JPanel HomeTab;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JComboBox OrderByDropDown;
    private javax.swing.JButton Sort;
    private javax.swing.JTable courseTable;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
