package Registration;

import Login.Dashboard;
import Login.LoginPage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import javax.swing.JOptionPane;

public class RegisterToCourse extends javax.swing.JFrame {

    PriorityQueue<Student> studentQueue = new PriorityQueue<>(new StudentPriority());

    HashMap<String, Student> studentMap = new HashMap<>();

    private RegistrationHashTable registrationHashTable = new RegistrationHashTable();

    public RegisterToCourse() {

        initComponents();
        
        // Load existing registrations -----------------------------------------
        RegistrationReader.load(registrationHashTable);
        loadCourses();
        StudentID.setEditable(false);

    }

    // Load student details to the combo box -----------------------------------
    private void loadStudents(String course) {

        studentQueue.clear();
        studentMap.clear();
        StudentName.removeAllItems();
        int order = 0;
        try {
            BufferedReader read = new BufferedReader(new FileReader("Students.txt"));
            String line;

            while ((line = read.readLine()) != null) {
                String data[] = line.split(",");
                if (data.length == 7) {
                    if (data[3].equals(course)) {
                        Student student = new Student(
                                data[0], data[1],
                                Integer.parseInt(data[2]),
                                data[3], data[4], data[5], data[6], order++
                        );
                        studentQueue.offer(student);
                    }
                }
            }

            read.close();

            // Check no students found -----------------------------------------
            if (studentQueue.isEmpty()) {
                StudentName.addItem("No students available");
                StudentID.setText("");
                return;
            }

            // Load students according to priority -----------------------------
            while (!studentQueue.isEmpty()) {

                Student priority = studentQueue.poll();
                StudentName.addItem(priority.toString());

                studentMap.put(priority.toString(), priority);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading students");
        }
    }

    // Load course from Courses.text -------------------------------------------
    private void loadCourses() {

        Courses.removeAllItems();

        // Set fFirst default item ---------------------------------------------
        Courses.addItem("-- Select Student Course --");

        try {
            BufferedReader read = new BufferedReader(new FileReader("Courses.txt")
            );

            String line;

            while ((line = read.readLine()) != null) {
                String data[] = line.split(",");
                if (data.length == 6) {

                    // Add only Course Name ------------------------------------
                    Courses.addItem(data[1]);
                }
            }
            read.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading courses");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        RegistrationID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Courses = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        StudentID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        StudentName = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        RegistrationDate = new javax.swing.JTextField();
        RegistrationTime = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Enroll = new javax.swing.JButton();
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
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Enrollment");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Registration ID");

        RegistrationID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RegistrationID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Courses");

        Courses.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Courses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select Student Course --", "Computer Science", "Software Engineering", "Networking", "Business" }));
        Courses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CoursesActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Student ID");

        StudentID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        StudentID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Student Name");

        StudentName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        StudentName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No students available" }));
        StudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentNameActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Registration Date");

        RegistrationDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RegistrationDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        RegistrationTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RegistrationTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Registration Time");

        Enroll.setBackground(new java.awt.Color(33, 147, 243));
        Enroll.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Enroll.setText("Enroll");
        Enroll.setBorder(null);
        Enroll.setBorderPainted(false);
        Enroll.setFocusPainted(false);
        Enroll.setFocusable(false);
        Enroll.setOpaque(false);
        Enroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnrollActionPerformed(evt);
            }
        });

        Clear.setBackground(new java.awt.Color(255, 14, 14));
        Clear.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Clear.setForeground(new java.awt.Color(255, 255, 255));
        Clear.setText("Clear");
        Clear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(Courses, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(36, 36, 36)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(StudentID)))
                                .addComponent(RegistrationID, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(RegistrationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(36, 36, 36)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(RegistrationTime, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addComponent(Clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(StudentName, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Enroll, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RegistrationID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Courses, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(StudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(StudentName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RegistrationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RegistrationTime, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Enroll, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
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

    private void CoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CoursesActionPerformed

        //Load names while user select course ----------------------------------
        if (Courses.getSelectedIndex() > 0) {

            String selectedCourse = Courses.getSelectedItem().toString();

            loadStudents(selectedCourse);

        } else {

            StudentName.removeAllItems();
            StudentID.setText("");

        }
    }//GEN-LAST:event_CoursesActionPerformed

    private void StudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentNameActionPerformed

        if (StudentName.getSelectedItem() != null) {
            String selectedStudent = StudentName.getSelectedItem().toString();

            if (studentMap.containsKey(selectedStudent)) {
                Student student = studentMap.get(selectedStudent);
                StudentID.setText(student.getStudentID());
            } else {
                StudentID.setText("");
            }
        }
    }//GEN-LAST:event_StudentNameActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        RegistrationID.setText("");

        if (Courses.getItemCount() > 0) {
            Courses.setSelectedIndex(0);
        }

        StudentID.setText("");

        if (StudentName.getItemCount() > 0) {
            StudentName.setSelectedIndex(0);
        }

        RegistrationDate.setText("");
        RegistrationTime.setText("");

    }//GEN-LAST:event_ClearActionPerformed

    private void EnrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnrollActionPerformed

        String regID = RegistrationID.getText().trim();

        // Check Registration ID -----------------------------------------------
        if (registrationHashTable.containsRegistration(regID)) {

            JOptionPane.showMessageDialog(this, "Registration ID already exists!",
                    "Duplicate Registration ID", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String course = Courses.getSelectedItem().toString();
        String studentID = StudentID.getText().trim();
        String studentName = StudentName.getSelectedItem().toString();
        String regDate = RegistrationDate.getText().trim();
        String regTime = RegistrationTime.getText().trim();

        if (regID.isEmpty()
                || studentID.isEmpty()
                || regDate.isEmpty()
                || regTime.isEmpty()
                || Courses.getSelectedItem() == null
                || StudentName.getSelectedItem() == null) {

            JOptionPane.showMessageDialog(this,"Please fill in all fields.",
                    "Empty Fields",JOptionPane.WARNING_MESSAGE);
            return;
        }

        StudentCourse regStudent = new StudentCourse(regID, course, studentID,
                studentName, regDate,regTime);

        // Add to Hash Table ---------------------------------------------------
        if (!registrationHashTable.addRegistration(regStudent)) {

            JOptionPane.showMessageDialog(this,"Registration ID already exists!",
                    "Error",JOptionPane.ERROR_MESSAGE);

            return;
        }

        // Save only the new registration --------------------------------------
        RegistrationWriter.save(regStudent);

        JOptionPane.showMessageDialog(this,"Enrollment Saved Successfully!",
                "Success",JOptionPane.INFORMATION_MESSAGE);

        // Clear fields --------------------------------------------------------
        RegistrationID.setText("");

        if (Courses.getItemCount() > 0) {
            Courses.setSelectedIndex(0);
        }

        StudentID.setText("");

        if (StudentName.getItemCount() > 0) {
            StudentName.setSelectedIndex(0);
        }

        RegistrationDate.setText("");
        RegistrationTime.setText("");
    }//GEN-LAST:event_EnrollActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        setVisible(false);
        Dashboard obj = new Dashboard();
        obj.setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterToCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterToCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterToCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterToCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterToCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Clear;
    private javax.swing.JMenuItem Contact;
    private javax.swing.JComboBox<String> Courses;
    private javax.swing.JButton Enroll;
    private javax.swing.JMenuItem LogoutBtn;
    private javax.swing.JTextField RegistrationDate;
    private javax.swing.JTextField RegistrationID;
    private javax.swing.JTextField RegistrationTime;
    private javax.swing.JTextField StudentID;
    private javax.swing.JComboBox<String> StudentName;
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
