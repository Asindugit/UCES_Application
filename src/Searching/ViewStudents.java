
package Searching;

import Login.Dashboard;
import Login.LoginPage;
import Registration.Student;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ViewStudents extends javax.swing.JFrame {

    String selectedCourse = "";

    public ViewStudents() {
        initComponents();

        loadStudentCourses();

    }

    // Load courses to the combo box -------------------------------------------
    private void loadStudentCourses() {

        StudentCourse.removeAllItems();

        // Default Course ----------------------------------------------------------
        StudentCourse.addItem("-- Select Student Course --");

        try (BufferedReader br = new BufferedReader(new FileReader("Courses.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] data = line.split(",");

                if (data.length >= 6) {
                    String courseName = data[1].trim();
                    StudentCourse.addItem(courseName);
                }
            }

        } catch (IOException e) {

            JOptionPane.showMessageDialog(this, "Unable to read Courses.txt\n" + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void showStudentDetails() {

        if (selectedCourse.equals("-- Select Student Course --")) {
            return;
        }

        String sortingType = SortingType.getSelectedItem().toString();

        ArrayList<Student> allStudents = StudentReader.readStudents();

        ArrayList<Student> courseStudents = new ArrayList<>();

        // Filter selected course ----------------------------------------------
        for (Student s : allStudents) {
            if (s.getCourse().equalsIgnoreCase(selectedCourse)) {
                courseStudents.add(s);
            }
        }

        DefaultTableModel model = (DefaultTableModel) jTableStudentDetails.getModel();

        model.setRowCount(0);

        if (courseStudents.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No students registered for "
                    + selectedCourse,"Not Found", JOptionPane.WARNING_MESSAGE);
            return;

        }

        // Sorting Process -----------------------------------------------------
        
        if (sortingType.equals("Alphabetically by name")) {
            MergeSort.sortByName(courseStudents);
            
        } else if (sortingType.equals("Numerically by age")) {
            MergeSort.sortByAge(courseStudents);
        }

        int count = 1;

        for (Student student : courseStudents) {

            model.addRow(new Object[]{
                count++,
                student.getStudentID(),
                student.getStudentName(),
                student.getStudentAge(),
                student.getCourse(),
                student.getAcademicYear(),
                student.getDate(),
                student.getTime()
            });
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableStudentDetails = new javax.swing.JTable();
        StudentCourse = new javax.swing.JComboBox<>();
        SortingType = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        Clear = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemHome = new javax.swing.JMenuItem();
        LogoutBtn = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        Contact = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(246, 250, 253));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("View Students Details");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Select Course");

        jTableStudentDetails.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableStudentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Student ID", "Name", "Age", "Course", "Academic Year", "Reg. Date", "Reg. Time"
            }
        ));
        jScrollPane1.setViewportView(jTableStudentDetails);

        StudentCourse.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        StudentCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select Student Course --", "Computer Science", "Software Engineering", "Networking", "Business" }));
        StudentCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentCourseActionPerformed(evt);
            }
        });

        SortingType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SortingType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select Type --", "Alphabetically by name", "Numerically by age" }));
        SortingType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortingTypeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Select Order");

        Clear.setBackground(new java.awt.Color(255, 14, 14));
        Clear.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Clear.setForeground(new java.awt.Color(255, 255, 255));
        Clear.setText("Clear");
        Clear.setBorder(null);
        Clear.setBorderPainted(false);
        Clear.setFocusPainted(false);
        Clear.setFocusable(false);
        Clear.setOpaque(false);
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        Back.setBackground(new java.awt.Color(11, 218, 81));
        Back.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Back.setText("Back");
        Back.setBorder(null);
        Back.setBorderPainted(false);
        Back.setFocusPainted(false);
        Back.setFocusable(false);
        Back.setOpaque(false);
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(237, 237, 237))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(StudentCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(SortingType, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(StudentCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(SortingType, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        jMenuItemHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        jMenuItemHome.setText("Home");
        jMenuItemHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHomeActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemHome);

        LogoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout.png"))); // NOI18N
        LogoutBtn.setText("Logout");
        LogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtnActionPerformed(evt);
            }
        });
        jMenu1.add(LogoutBtn);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("About");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/about.png"))); // NOI18N
        jMenuItem3.setText("About Us");
        jMenu2.add(jMenuItem3);

        Contact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/account.png"))); // NOI18N
        Contact.setText("Contact");
        Contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactActionPerformed(evt);
            }
        });
        jMenu2.add(Contact);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(816, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHomeActionPerformed
        setVisible(false);
        Dashboard obj = new Dashboard();
        obj.setVisible(true);
    }//GEN-LAST:event_jMenuItemHomeActionPerformed

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        setVisible(false);
        LoginPage obj = new LoginPage();
        obj.setVisible(true);
    }//GEN-LAST:event_LogoutBtnActionPerformed

    private void SortingTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortingTypeActionPerformed

        if (selectedCourse.equals("-- Select Student Course --")
                || selectedCourse.equals("")) {

            JOptionPane.showMessageDialog(
                    this, "Please select student course first", 
                    "Incomplete Data", JOptionPane.WARNING_MESSAGE
            );

            SortingType.setSelectedIndex(0);
            return;

        }
        showStudentDetails();
    }//GEN-LAST:event_SortingTypeActionPerformed

    private void StudentCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentCourseActionPerformed

        if (StudentCourse.getSelectedItem() == null) {
            return;
        }

        selectedCourse = StudentCourse.getSelectedItem().toString();

        DefaultTableModel model = (DefaultTableModel) jTableStudentDetails.getModel();
        model.setRowCount(0);

        // If sorting type already selected ------------------------------------
        if (!SortingType.getSelectedItem().toString().equals("-- Select Type --")) {
            showStudentDetails();
        }

    }//GEN-LAST:event_StudentCourseActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        
        setVisible(false);
        Dashboard back = new Dashboard();
        back.setVisible(true);
        
    }//GEN-LAST:event_BackActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        
        SortingType.setSelectedIndex(0);
        StudentCourse.setSelectedIndex(0);
        DefaultTableModel model=(DefaultTableModel) jTableStudentDetails.getModel();
        model.setRowCount(0);
        
    }//GEN-LAST:event_ClearActionPerformed

    private void ContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactActionPerformed
        JOptionPane.showMessageDialog(
                this,
                "UNIVERSITY COURSE ENROLLMENT SYSTEM (UCES)\n"
                + "Contact : +94 11 234 5678\n"
                + "Address : No. 36, De Kretser Place, Bambalapitiya, Colombo 04\n"
                + "Email : info@uces.com",
                "Contact Details",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ContactActionPerformed

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
            java.util.logging.Logger.getLogger(ViewStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Clear;
    private javax.swing.JMenuItem Contact;
    private javax.swing.JMenuItem LogoutBtn;
    private javax.swing.JComboBox<String> SortingType;
    private javax.swing.JComboBox<String> StudentCourse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemHome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableStudentDetails;
    // End of variables declaration//GEN-END:variables
}
