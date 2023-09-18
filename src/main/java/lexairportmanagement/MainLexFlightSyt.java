/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lexairportmanagement;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lelet
 */
public class MainLexFlightSyt extends javax.swing.JFrame {
    
 
   
    
    

    /**
     * Creates new form MainLexFlightSyt
     */
    public MainLexFlightSyt() {
        initComponents();
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonCarHire = new javax.swing.JButton();
        jButtonHotel = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButtonOrderFoodAtHotel = new javax.swing.JButton();
        jButtonOrderFoodAtHotel1 = new javax.swing.JButton();
        jButtonSignUp1 = new javax.swing.JButton();
        jButtonSignUp2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonSearchFlights = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBoxDepartFrom = new javax.swing.JComboBox<>();
        jComboBoxDestination = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jButtonCarHire.setBackground(new java.awt.Color(0, 0, 0));
        jButtonCarHire.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonCarHire.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCarHire.setText("Car-Hire");
        jButtonCarHire.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, null));
        jButtonCarHire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCarHireActionPerformed(evt);
            }
        });

        jButtonHotel.setBackground(new java.awt.Color(0, 0, 0));
        jButtonHotel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonHotel.setForeground(new java.awt.Color(255, 255, 255));
        jButtonHotel.setText("Hotel Bookings");
        jButtonHotel.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, null));
        jButtonHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHotelActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("My Bookings");
        jButton5.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, null));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButtonOrderFoodAtHotel.setBackground(new java.awt.Color(0, 0, 0));
        jButtonOrderFoodAtHotel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonOrderFoodAtHotel.setForeground(new java.awt.Color(255, 255, 255));
        jButtonOrderFoodAtHotel.setText("Order Food at Hotel");
        jButtonOrderFoodAtHotel.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, null));
        jButtonOrderFoodAtHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrderFoodAtHotelActionPerformed(evt);
            }
        });

        jButtonOrderFoodAtHotel1.setBackground(new java.awt.Color(0, 0, 0));
        jButtonOrderFoodAtHotel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonOrderFoodAtHotel1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonOrderFoodAtHotel1.setText("Borrow a Book at Hotel");
        jButtonOrderFoodAtHotel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, null));
        jButtonOrderFoodAtHotel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrderFoodAtHotel1ActionPerformed(evt);
            }
        });

        jButtonSignUp1.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSignUp1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonSignUp1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSignUp1.setText("Login");
        jButtonSignUp1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, null));
        jButtonSignUp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSignUp1ActionPerformed(evt);
            }
        });

        jButtonSignUp2.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSignUp2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonSignUp2.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSignUp2.setText("My Account");
        jButtonSignUp2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, null));
        jButtonSignUp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSignUp2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButtonCarHire, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonHotel)
                .addGap(18, 18, 18)
                .addComponent(jButtonOrderFoodAtHotel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonOrderFoodAtHotel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(jButtonSignUp2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSignUp1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(44, 44, 44))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCarHire, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOrderFoodAtHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOrderFoodAtHotel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSignUp1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSignUp2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1520, 80);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.setMaximumSize(new java.awt.Dimension(32769, 32769));

        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton1.setText("Return");

        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton2.setText("One-Way");

        jRadioButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton3.setText("Multi-City");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("From");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("To");

        jButtonSearchFlights.setBackground(new java.awt.Color(204, 204, 255));
        jButtonSearchFlights.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonSearchFlights.setForeground(new java.awt.Color(0, 0, 0));
        jButtonSearchFlights.setText("Search Flights");
        jButtonSearchFlights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchFlightsActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Depart");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Return");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Passengers");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Class");

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Infants", "Children", "Adults", " " }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(99, 39));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox2.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economy", "Premium", "Business", "Item 4" }));
        jComboBox2.setPreferredSize(new java.awt.Dimension(89, 29));

        jComboBox3.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economy", "Premium", "Business", "Item 4" }));
        jComboBox3.setPreferredSize(new java.awt.Dimension(99, 39));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jComboBoxDepartFrom.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxDepartFrom.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBoxDepartFrom.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxDepartFrom.setMaximumRowCount(30);
        jComboBoxDepartFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "New York", "Los Angeles", "Chicago", "London", "Paris", "Tokyo", "San Francisco", "Sydney", "Hong Kong", "Toronto", "Dubai", "Shanghai", "Miami", "Mumbai", "Berlin", "Rome", "Las Vegas", "Barcelona", "Amsterdam", "Bangkok", "Istanbul", "Copenhagen", "Rio de Janeiro", "Cairo", "Athens", "Budapest", "Vienna", "Prague", "Dublin", "Stockholm", "Helsinki" }));
        jComboBoxDepartFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDepartFromActionPerformed(evt);
            }
        });

        jComboBoxDestination.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxDestination.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBoxDestination.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxDestination.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chicago", "San Francisco", "Sydney", "Hong Kong", "Toronto", "Dubai", "Shanghai", "Miami", "Mumbai", "Berlin", "Rome", "Las Vegas", "Barcelona", "Amsterdam", "Bangkok", "Istanbul", "Copenhagen", "Rio de Janeiro", "Cairo", "Athens", "Budapest", "Vienna", "Prague", "Dublin", "Stockholm", "Helsinki", "New York", "Los Angeles", "London", "Paris", "Tokyo" }));
        jComboBoxDestination.setPreferredSize(new java.awt.Dimension(167, 41));
        jComboBoxDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDestinationActionPerformed(evt);
            }
        });

        jComboBox4.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox4.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023-09-20", "2023-09-21", "2023-09-22", "2023-09-23", "2023-09-24", "2023-09-25", "2023-09-26" }));
        jComboBox4.setPreferredSize(new java.awt.Dimension(99, 39));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jComboBox5.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox5.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Infants", "Children", "Adults", " " }));
        jComboBox5.setPreferredSize(new java.awt.Dimension(99, 39));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("-->");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("<--");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(237, 237, 237)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton3)
                        .addGap(137, 137, 137))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(108, 108, 108)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(9, 9, 9)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jComboBoxDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel6))
                                                .addGap(32, 32, 32)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                            .addComponent(jComboBoxDepartFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jButtonSearchFlights, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBoxDepartFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonSearchFlights, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jComboBoxDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(165, 165, 165))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(244, 188, 975, 231);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Lex's Best incedible flights there is");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(360, 110, 660, 60);

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\lelet\\OneDrive\\Documents\\wepik-export-20230914230706suFB.png")); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(-3, 76, 1540, 730);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1507, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
     
    
    private void jButtonSearchFlightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchFlightsActionPerformed
        // TODO add your handling code here:
        AvailableFlightsSearch mainFrame = new AvailableFlightsSearch();
    
    // Set the visibility of the MainLexFlightSyt frame
    mainFrame.setVisible(true);

    // Close the current frame (assuming this is in AvailableFlightsSearch)
    this.dispose();
    }//GEN-LAST:event_jButtonSearchFlightsActionPerformed

    private void jButtonHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHotelActionPerformed
        // TODO add your handling code here:
        HotelBookings mainFrame = new HotelBookings();
    
    // Set the visibility of the MainLexFlightSyt frame
    mainFrame.setVisible(true);

    // Close the current frame (assuming this is in AvailableFlightsSearch)
    this.dispose();
    }//GEN-LAST:event_jButtonHotelActionPerformed

    private void jButtonCarHireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCarHireActionPerformed
        // TODO add your handling code here:
        CarRental mainFrame = new CarRental();
    
    // Set the visibility of the MainLexFlightSyt frame
    mainFrame.setVisible(true);

    // Close the current frame (assuming this is in AvailableFlightsSearch)
    this.dispose();
    }//GEN-LAST:event_jButtonCarHireActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBoxDepartFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDepartFromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDepartFromActionPerformed

    private void jComboBoxDestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDestinationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDestinationActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        MyBookingsSummary mainFrame = new MyBookingsSummary();
    
    // Set the visibility of the MainLexFlightSyt frame
    mainFrame.setVisible(true);

    // Close the current frame (assuming this is in AvailableFlightsSearch)
    this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButtonOrderFoodAtHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrderFoodAtHotelActionPerformed
        // TODO add your handling code here:
         FoodOrderWhenAtLexHotel mainFrame = new  FoodOrderWhenAtLexHotel();
    
    // Set the visibility of the MainLexFlightSyt frame
    mainFrame.setVisible(true);

    // Close the current frame (assuming this is in AvailableFlightsSearch)
    this.dispose();
    }//GEN-LAST:event_jButtonOrderFoodAtHotelActionPerformed

    private void jButtonOrderFoodAtHotel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrderFoodAtHotel1ActionPerformed
        // TODO add your handling code here:
        LexBooks mainFrame = new LexBooks();
    
    // Set the visibility of the MainLexFlightSyt frame
    mainFrame.setVisible(true);

    // Close the current frame (assuming this is in AvailableFlightsSearch)
    this.dispose();
    }//GEN-LAST:event_jButtonOrderFoodAtHotel1ActionPerformed

    private void jButtonSignUp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSignUp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSignUp1ActionPerformed

    private void jButtonSignUp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSignUp2ActionPerformed
        // TODO add your handling code here:
        UserAccount mainFrame = new UserAccount();
    
    // Set the visibility of the MainLexFlightSyt frame
    mainFrame.setVisible(true);

    // Close the current frame (assuming this is in AvailableFlightsSearch)
    this.dispose();
    }//GEN-LAST:event_jButtonSignUp2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        EventQueue.invokeLater(() -> {
            Logo logoFrame = new Logo();
            logoFrame.setVisible(true);

            // Add a delay if needed before showing the main frame
            try {
                Thread.sleep(2000); // Delay for 2 seconds (2000 milliseconds)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Close the logo frame and open the main frame
            logoFrame.dispose(); // Close the logo frame
            MainLexFlightSyt mainFrame = new MainLexFlightSyt();
            mainFrame.setVisible(true);
        });
    
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
            java.util.logging.Logger.getLogger(MainLexFlightSyt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainLexFlightSyt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainLexFlightSyt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainLexFlightSyt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainLexFlightSyt().setVisible(true);
            }
        });
}
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonCarHire;
    private javax.swing.JButton jButtonHotel;
    private javax.swing.JButton jButtonOrderFoodAtHotel;
    private javax.swing.JButton jButtonOrderFoodAtHotel1;
    private javax.swing.JButton jButtonSearchFlights;
    private javax.swing.JButton jButtonSignUp1;
    private javax.swing.JButton jButtonSignUp2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBoxDepartFrom;
    private javax.swing.JComboBox<String> jComboBoxDestination;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    // End of variables declaration//GEN-END:variables
}
