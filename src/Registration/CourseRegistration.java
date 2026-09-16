
package Registration;

import Course_Manage.CourseReader;
import Login.Dashboard;
import Login.LoginPage;
import javax.swing.JOptionPane;


public class CourseRegistration extends javax.swing.JFrame {


    public CourseRegistration() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CourseID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        CourseName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Lecturer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Duration = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CourseFee = new javax.swing.JTextField();
        Register = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Seats = new javax.swing.JTextField();
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
        jLabel1.setText("Course Registration");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Course ID");

        CourseID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CourseID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Course Name");

        CourseName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CourseName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Lecturer");

        Lecturer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Lecturer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Duration");

        Duration.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Duration.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Course Fee (Rs.)");

        CourseFee.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CourseFee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Register.setBackground(new java.awt.Color(33, 147, 243));
        Register.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Register.setText("Register");
        Register.setBorder(null);
        Register.setBorderPainted(false);
        Register.setFocusPainted(false);
        Register.setFocusable(false);
        Register.setOpaque(false);
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Seats");

        Seats.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Seats.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(Duration, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(CourseFee, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(146, 146, 146))
                            .addComponent(Seats)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addGap(228, 228, 228))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(CourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(CourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Lecturer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(Register, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Lecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Duration, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CourseFee, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(Seats))))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Register, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
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

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        
        setVisible(false);
        Dashboard back = new Dashboard();
        back.setVisible(true);
        
    }//GEN-LAST:event_BackActionPerformed

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed

        String courseID = CourseID.getText().trim();
        String courseName = CourseName.getText().trim();
        String lecturer = Lecturer.getText().trim();
        String duration = Duration.getText().trim();
        String feeText = CourseFee.getText().trim();
        String seatsText = Seats.getText().trim();

        // Text Fields Validation ----------------------------------------------
        if (courseID.isEmpty()
                || courseName.isEmpty()
                || lecturer.isEmpty()
                || duration.isEmpty()
                || feeText.isEmpty()
                || seatsText.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please fill all fields.",
                    "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Check Course ID already exists --------------------------------------
        if (CourseReader.readCourses().stream()
                .anyMatch(course -> course.getCourseID().equalsIgnoreCase(courseID))) {

            JOptionPane.showMessageDialog(this,"Course ID already exists!",
                    "Duplicate Course ID", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Course Fee validation -----------------------------------------------
        double courseFee;

        try {

            courseFee = Double.parseDouble(feeText);

            if (courseFee < 0) {

                JOptionPane.showMessageDialog(this, "Course fee cannot be negative.",
                        "Validation Error", JOptionPane.WARNING_MESSAGE
                );
                return;
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "Please enter a valid course fee.",
                    "Validation Error", JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Seate text Field Validation -----------------------------------------
        int seats;

        try {
            seats = Integer.parseInt(seatsText);
            if (seats <= 0) {

                JOptionPane.showMessageDialog(
                        this, "Seats must be greater than 0.",
                        "Validation Error", JOptionPane.WARNING_MESSAGE
                );

                return;
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "Please enter a valid number of seats.",
                    "Validation Error", JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // Create Object for Course class --------------------------------------
        Course course = new Course(courseID, courseName, lecturer, duration,
                courseFee, seats);

        CoursePriorityQueue queue = new CoursePriorityQueue();

        boolean success = queue.registerCourse(course);

        if (success) {

            JOptionPane.showMessageDialog(this, "Course registered successfully!",
                    "Success", JOptionPane.INFORMATION_MESSAGE
            );

            // Cleare Text Fields ----------------------------------------------
            CourseID.setText("");
            CourseName.setText("");
            Lecturer.setText("");
            Duration.setText("");
            CourseFee.setText("");
            Seats.setText("");
        }


    }//GEN-LAST:event_RegisterActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        
        CourseID.setText("");
        CourseName.setText("");
        Lecturer.setText("");
        Duration.setText("");
        CourseFee.setText("");
        Seats.setText("");
        
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
            java.util.logging.Logger.getLogger(CourseRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Clear;
    private javax.swing.JMenuItem Contact;
    private javax.swing.JTextField CourseFee;
    private javax.swing.JTextField CourseID;
    private javax.swing.JTextField CourseName;
    private javax.swing.JTextField Duration;
    private javax.swing.JTextField Lecturer;
    private javax.swing.JMenuItem LogoutBtn;
    private javax.swing.JButton Register;
    private javax.swing.JTextField Seats;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemHome;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
