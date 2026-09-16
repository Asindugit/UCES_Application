
package Login;

import Course_Manage.*;
import Student_Manage.*;
import Registration.*;
import Searching.*;
import User_Manage.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Dashboard extends javax.swing.JFrame {

  
    public Dashboard() {
        initComponents();
        
        loadStudentCount();
        loadCourseAndSeatCount();
        loadCourseDetails();
    }
    
    // Generate Student Count --------------------------------------------------
    private void loadStudentCount() {

        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Students.txt"))) {
            while (br.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        StudentCount.setText(String.valueOf(count));
    }

    // Generate Course Count and Seat Count ------------------------------------
    private void loadCourseAndSeatCount() {

        int courseCount = 0;
        int totalSeats = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Courses.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                // Count courses -----------------------------------------------
                courseCount++;

                // Seat Count
                if (data.length > 5) {
                    try {
                        int seats = Integer.parseInt(data[5].trim());
                        totalSeats += seats;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid seat value: " + data[5]);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        CourseCount.setText(String.valueOf(courseCount));
        SeatCount.setText(String.valueOf(totalSeats));
    }

    // Load Course Details to the Table ----------------------------------------
    private void loadCourseDetails() {

        DefaultTableModel model = (DefaultTableModel) CourseDetails.getModel();
        model.setRowCount(0);

        HashMap<String, Integer> registrationCount = new HashMap<>();

        // 1. Read StudentCourse.txt and count registrations -------------------
        try (BufferedReader br = new BufferedReader(new FileReader("StudentCourse.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");
                if (data.length > 1) {
                    String courseName = data[1].trim();
                    registrationCount.put(courseName,
                            registrationCount.getOrDefault(courseName, 0) + 1
                    );
                }
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading StudentCourse.txt: "
                    + e.getMessage());
        }

        // 2. Read Courses.txt and display course details ----------------------
        int count = 1;

        try (BufferedReader br = new BufferedReader(new FileReader("Courses.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                if (data.length >= 6) {

                    String courseName = data[1].trim();
                    String duration = data[3].trim();
                    String courseFee = data[4].trim();

                    int totalSeats;

                    try {
                        totalSeats = Integer.parseInt(data[5].trim());
                    } catch (NumberFormatException e) {
                        totalSeats = 0;
                    }

                    // Get registered student count ----------------------------
                    int registeredCount = registrationCount.getOrDefault(courseName, 0);

                    // Calculate available seats -------------------------------
                    int availableSeats = totalSeats - registeredCount;

                    // Prevent negative seats ----------------------------------
                    if (availableSeats < 0) {
                        availableSeats = 0;
                    }

                    // Add row to table ----------------------------------------
                    model.addRow(new Object[]{
                        count, courseName, duration, courseFee, availableSeats
                    });
                    count++;
                }
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading Courses.txt: "
                    + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        StudentCount = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        CourseCount = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        SeatCount = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CourseDetails = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        StudentEdit = new javax.swing.JButton();
        StudentRemove = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        CourseEdit = new javax.swing.JButton();
        CourseRemove = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        UserEdit = new javax.swing.JButton();
        UserRemove = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        StudentRegister = new javax.swing.JButton();
        RegisterToCourse = new javax.swing.JButton();
        SearchStudent = new javax.swing.JButton();
        ViewStudent = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        LogoutBtn = new javax.swing.JButton();
        CourseRegistration = new javax.swing.JButton();
        UserRegistration = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        Menu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        LogoutMenu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        Contact = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(246, 250, 253));

        jPanel3.setBackground(new java.awt.Color(37, 91, 234));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total Students");

        StudentCount.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        StudentCount.setForeground(new java.awt.Color(255, 255, 255));
        StudentCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StudentCount.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(StudentCount)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StudentCount))
        );

        jPanel4.setBackground(new java.awt.Color(241, 146, 96));

        CourseCount.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        CourseCount.setForeground(new java.awt.Color(255, 255, 255));
        CourseCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CourseCount.setText("0");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Total Courses");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(CourseCount)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CourseCount))
        );

        jPanel7.setBackground(new java.awt.Color(57, 138, 204));

        SeatCount.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        SeatCount.setForeground(new java.awt.Color(255, 255, 255));
        SeatCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SeatCount.setText("000");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Total Seats");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(SeatCount))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeatCount))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Course Details and Avalable Seats");

        CourseDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "#", "Course Name", "Duration", "Course Fee", "Available Seats"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(CourseDetails);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        StudentEdit.setBackground(new java.awt.Color(13, 110, 253));
        StudentEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        StudentEdit.setForeground(new java.awt.Color(255, 255, 255));
        StudentEdit.setText("Edit");
        StudentEdit.setBorder(null);
        StudentEdit.setBorderPainted(false);
        StudentEdit.setFocusPainted(false);
        StudentEdit.setFocusable(false);
        StudentEdit.setOpaque(false);
        StudentEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentEditActionPerformed(evt);
            }
        });

        StudentRemove.setBackground(new java.awt.Color(220, 53, 69));
        StudentRemove.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        StudentRemove.setForeground(new java.awt.Color(255, 255, 255));
        StudentRemove.setText("Remove");
        StudentRemove.setBorder(null);
        StudentRemove.setBorderPainted(false);
        StudentRemove.setFocusPainted(false);
        StudentRemove.setFocusable(false);
        StudentRemove.setOpaque(false);
        StudentRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(StudentEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(StudentRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StudentEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StudentRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Manage Student");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        CourseEdit.setBackground(new java.awt.Color(13, 110, 253));
        CourseEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CourseEdit.setForeground(new java.awt.Color(255, 255, 255));
        CourseEdit.setText("Edit");
        CourseEdit.setBorder(null);
        CourseEdit.setBorderPainted(false);
        CourseEdit.setFocusPainted(false);
        CourseEdit.setFocusable(false);
        CourseEdit.setOpaque(false);
        CourseEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourseEditActionPerformed(evt);
            }
        });

        CourseRemove.setBackground(new java.awt.Color(220, 53, 69));
        CourseRemove.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CourseRemove.setForeground(new java.awt.Color(255, 255, 255));
        CourseRemove.setText("Remove");
        CourseRemove.setBorder(null);
        CourseRemove.setBorderPainted(false);
        CourseRemove.setFocusPainted(false);
        CourseRemove.setFocusable(false);
        CourseRemove.setOpaque(false);
        CourseRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourseRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(CourseEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CourseRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CourseEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CourseRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Manage Course");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Manage Users");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        UserEdit.setBackground(new java.awt.Color(13, 110, 253));
        UserEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UserEdit.setForeground(new java.awt.Color(255, 255, 255));
        UserEdit.setText("Edit");
        UserEdit.setBorder(null);
        UserEdit.setBorderPainted(false);
        UserEdit.setFocusPainted(false);
        UserEdit.setFocusable(false);
        UserEdit.setOpaque(false);
        UserEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserEditActionPerformed(evt);
            }
        });

        UserRemove.setBackground(new java.awt.Color(220, 53, 69));
        UserRemove.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UserRemove.setForeground(new java.awt.Color(255, 255, 255));
        UserRemove.setText("Remove");
        UserRemove.setBorder(null);
        UserRemove.setBorderPainted(false);
        UserRemove.setFocusPainted(false);
        UserRemove.setFocusable(false);
        UserRemove.setOpaque(false);
        UserRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(UserEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(UserRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel9))))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addComponent(jLabel8)))))
                                .addGap(0, 4, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(4, 4, 4)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(4, 4, 4)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(4, 4, 4)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        StudentRegister.setBackground(new java.awt.Color(38, 88, 130));
        StudentRegister.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StudentRegister.setForeground(new java.awt.Color(255, 255, 255));
        StudentRegister.setText("Student Registration");
        StudentRegister.setBorder(null);
        StudentRegister.setBorderPainted(false);
        StudentRegister.setFocusPainted(false);
        StudentRegister.setFocusable(false);
        StudentRegister.setOpaque(false);
        StudentRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentRegisterActionPerformed(evt);
            }
        });

        RegisterToCourse.setBackground(new java.awt.Color(38, 88, 130));
        RegisterToCourse.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        RegisterToCourse.setForeground(new java.awt.Color(255, 255, 255));
        RegisterToCourse.setText("Student Enrollment");
        RegisterToCourse.setBorder(null);
        RegisterToCourse.setBorderPainted(false);
        RegisterToCourse.setFocusPainted(false);
        RegisterToCourse.setFocusable(false);
        RegisterToCourse.setOpaque(false);
        RegisterToCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterToCourseActionPerformed(evt);
            }
        });

        SearchStudent.setBackground(new java.awt.Color(38, 88, 130));
        SearchStudent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SearchStudent.setForeground(new java.awt.Color(255, 255, 255));
        SearchStudent.setText("Search Student");
        SearchStudent.setBorder(null);
        SearchStudent.setBorderPainted(false);
        SearchStudent.setFocusPainted(false);
        SearchStudent.setFocusable(false);
        SearchStudent.setOpaque(false);
        SearchStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchStudentActionPerformed(evt);
            }
        });

        ViewStudent.setBackground(new java.awt.Color(38, 88, 130));
        ViewStudent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ViewStudent.setForeground(new java.awt.Color(255, 255, 255));
        ViewStudent.setText("View Student");
        ViewStudent.setBorder(null);
        ViewStudent.setBorderPainted(false);
        ViewStudent.setFocusPainted(false);
        ViewStudent.setFocusable(false);
        ViewStudent.setOpaque(false);
        ViewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewStudentActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel2.setText("Dashboard");

        jLabel7.setBackground(new java.awt.Color(37, 91, 234));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(37, 91, 234));
        jLabel7.setText("Welcome to Admin");

        LogoutBtn.setBackground(new java.awt.Color(255, 14, 14));
        LogoutBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LogoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        LogoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/power.png"))); // NOI18N
        LogoutBtn.setText("Logout");
        LogoutBtn.setBorder(null);
        LogoutBtn.setBorderPainted(false);
        LogoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LogoutBtn.setFocusPainted(false);
        LogoutBtn.setFocusable(false);
        LogoutBtn.setOpaque(false);
        LogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtnActionPerformed(evt);
            }
        });

        CourseRegistration.setBackground(new java.awt.Color(38, 88, 130));
        CourseRegistration.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CourseRegistration.setForeground(new java.awt.Color(255, 255, 255));
        CourseRegistration.setText("Course Registration");
        CourseRegistration.setBorder(null);
        CourseRegistration.setBorderPainted(false);
        CourseRegistration.setFocusPainted(false);
        CourseRegistration.setFocusable(false);
        CourseRegistration.setOpaque(false);
        CourseRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourseRegistrationActionPerformed(evt);
            }
        });

        UserRegistration.setBackground(new java.awt.Color(38, 88, 130));
        UserRegistration.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        UserRegistration.setForeground(new java.awt.Color(255, 255, 255));
        UserRegistration.setText("User Registration");
        UserRegistration.setBorder(null);
        UserRegistration.setBorderPainted(false);
        UserRegistration.setFocusPainted(false);
        UserRegistration.setFocusable(false);
        UserRegistration.setOpaque(false);
        UserRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserRegistrationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(StudentRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RegisterToCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SearchStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ViewStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CourseRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(StudentRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RegisterToCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ViewStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CourseRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UserRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        Menu.setText("File");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        jMenuItem1.setText("Home");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Menu.add(jMenuItem1);

        LogoutMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout.png"))); // NOI18N
        LogoutMenu.setText("Logout");
        LogoutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutMenuActionPerformed(evt);
            }
        });
        Menu.add(LogoutMenu);

        jMenuBar1.add(Menu);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(816, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void LogoutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutMenuActionPerformed
        setVisible(false);
        LoginPage obj = new LoginPage();
        obj.setVisible(true);
    }//GEN-LAST:event_LogoutMenuActionPerformed

    private void StudentRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentRegisterActionPerformed
        
        setVisible(false);
        StudentRegistrationUI obj = new StudentRegistrationUI();
        obj.setVisible(true);
        
    }//GEN-LAST:event_StudentRegisterActionPerformed

    private void RegisterToCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterToCourseActionPerformed
        
        setVisible(false);
        RegisterToCourse obj = new RegisterToCourse();
        obj.setVisible(true);
        
    }//GEN-LAST:event_RegisterToCourseActionPerformed

    private void SearchStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchStudentActionPerformed
        setVisible(false);
        StudentSearching obj = new StudentSearching();
        obj.setVisible(true);
        
    }//GEN-LAST:event_SearchStudentActionPerformed

    private void ViewStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewStudentActionPerformed
        
        setVisible(false);
        ViewStudents obj = new ViewStudents();
        obj.setVisible(true);
        
    }//GEN-LAST:event_ViewStudentActionPerformed

    private void CourseRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourseRegistrationActionPerformed
        
        setVisible(false);
        CourseRegistration obj = new CourseRegistration();
        obj.setVisible(true);
        
    }//GEN-LAST:event_CourseRegistrationActionPerformed

    private void UserRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserRegistrationActionPerformed
        setVisible(false);
        UserRegistration obj = new UserRegistration();
        obj.setVisible(true);
        
    }//GEN-LAST:event_UserRegistrationActionPerformed

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed

        setVisible(false);
        LoginPage obj = new LoginPage();
        obj.setVisible(true);

    }//GEN-LAST:event_LogoutBtnActionPerformed

    private void StudentEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentEditActionPerformed
        
        setVisible(false);
        EditStudent obj = new EditStudent();
        obj.setVisible(true);
        
    }//GEN-LAST:event_StudentEditActionPerformed

    private void StudentRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentRemoveActionPerformed
        setVisible(false);
        RemoveStudent obj = new RemoveStudent();
        obj.setVisible(true);
        
    }//GEN-LAST:event_StudentRemoveActionPerformed

    private void CourseEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourseEditActionPerformed
        
        setVisible(false);
        EditCourse obj = new EditCourse();
        obj.setVisible(true);
        
    }//GEN-LAST:event_CourseEditActionPerformed

    private void CourseRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourseRemoveActionPerformed
        
        setVisible(false);
        DeleteCourse obj = new DeleteCourse();
        obj.setVisible(true);
        
    }//GEN-LAST:event_CourseRemoveActionPerformed

    private void UserEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserEditActionPerformed
        
        setVisible(false);
        EditUser obj = new EditUser();
        obj.setVisible(true);
        
    }//GEN-LAST:event_UserEditActionPerformed

    private void UserRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserRemoveActionPerformed
        
        setVisible(false);
        DeleteUser obj = new DeleteUser();
        obj.setVisible(true);
        
    }//GEN-LAST:event_UserRemoveActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Contact;
    private javax.swing.JLabel CourseCount;
    private javax.swing.JTable CourseDetails;
    private javax.swing.JButton CourseEdit;
    private javax.swing.JButton CourseRegistration;
    private javax.swing.JButton CourseRemove;
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JMenuItem LogoutMenu;
    private javax.swing.JMenu Menu;
    private javax.swing.JButton RegisterToCourse;
    private javax.swing.JButton SearchStudent;
    private javax.swing.JLabel SeatCount;
    private javax.swing.JLabel StudentCount;
    private javax.swing.JButton StudentEdit;
    private javax.swing.JButton StudentRegister;
    private javax.swing.JButton StudentRemove;
    private javax.swing.JButton UserEdit;
    private javax.swing.JButton UserRegistration;
    private javax.swing.JButton UserRemove;
    private javax.swing.JButton ViewStudent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
