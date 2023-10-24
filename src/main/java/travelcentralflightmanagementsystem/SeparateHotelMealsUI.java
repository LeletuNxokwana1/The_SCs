/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package travelcentralflightmanagementsystem;

import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author the_scs
 */
public class SeparateHotelMealsUI extends javax.swing.JFrame {

    private String checkInDate;
    private String checkOutDate;
    private boolean meals;
    private float hotelCost;
    private int numNights;
    private float mealCost;
    private String bookingNumber;
    private int arrivalAirportBooking;
    
    public SeparateHotelMealsUI(String checkInDate, String checkOutDate, boolean meals, float hotelCost, int numNights, String bookingNumber, int arrivalAirportBooking) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.meals = meals;
        this.hotelCost = hotelCost;
        this.numNights = numNights;
        this.bookingNumber = bookingNumber;
        this.arrivalAirportBooking = arrivalAirportBooking;
        
        initComponents();
        
        if (!SessionManager.isLoggedIn()) {
            lblName.setVisible(false);
        } else {
            lblName.setText(SessionManager.getLoggedInUsername());
        }
        
        jPanel2.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBreakfast = new javax.swing.JPanel();
        jRadioButtonCornPasty = new javax.swing.JRadioButton();
        jRadioButtonSchoEgg = new javax.swing.JRadioButton();
        jRadioButtonBlackCrumble = new javax.swing.JRadioButton();
        jRadioButtonBerPancakes = new javax.swing.JRadioButton();
        jRadioButtonEngBreakfast = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jPanelLunch = new javax.swing.JPanel();
        jRadioButtonBeefHotpot = new javax.swing.JRadioButton();
        jRadioButtonFishnChips = new javax.swing.JRadioButton();
        jRadioButtonLamb = new javax.swing.JRadioButton();
        jRadioButtonMash = new javax.swing.JRadioButton();
        jRadioButtonPie = new javax.swing.JRadioButton();
        jPanelDinner = new javax.swing.JPanel();
        jRadioButtonRoastChicken = new javax.swing.JRadioButton();
        jRadioButtonBeef = new javax.swing.JRadioButton();
        jRadioButtonCurry = new javax.swing.JRadioButton();
        jRadioButtonBeefnPie = new javax.swing.JRadioButton();
        jRadioButtonChickenTikka = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabelTotal = new javax.swing.JLabel();
        jLabelBreakfast = new javax.swing.JLabel();
        jLabelLunch = new javax.swing.JLabel();
        jLabelSuper = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();
        jTextFieldBreakfast = new javax.swing.JTextField();
        jTextFieldLunch = new javax.swing.JTextField();
        jTextFieldSupper = new javax.swing.JTextField();
        jButtonPayment = new javax.swing.JButton();
        pnlHead = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JButton();
        lblTravel = new javax.swing.JLabel();
        lblCentral = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        btnBackToSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelBreakfast.setBackground(new java.awt.Color(0, 0, 0));
        jPanelBreakfast.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanelBreakfast.setForeground(new java.awt.Color(255, 255, 255));
        jPanelBreakfast.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jRadioButtonCornPasty.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonCornPasty.setText("Cornish Pasty                                               R55.00");
        jRadioButtonCornPasty.setPreferredSize(new java.awt.Dimension(164, 22));
        jRadioButtonCornPasty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCornPastyActionPerformed(evt);
            }
        });
        jPanelBreakfast.add(jRadioButtonCornPasty, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 352, 53));

        jRadioButtonSchoEgg.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonSchoEgg.setText("Schotch Egg                                                 R60.00");
        jRadioButtonSchoEgg.setPreferredSize(new java.awt.Dimension(164, 22));
        jRadioButtonSchoEgg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSchoEggActionPerformed(evt);
            }
        });
        jPanelBreakfast.add(jRadioButtonSchoEgg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 352, 53));

        jRadioButtonBlackCrumble.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonBlackCrumble.setText("Blackcurrant Crumble                                   R50.00");
        jRadioButtonBlackCrumble.setMaximumSize(new java.awt.Dimension(164, 22));
        jRadioButtonBlackCrumble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonBlackCrumbleActionPerformed(evt);
            }
        });
        jPanelBreakfast.add(jRadioButtonBlackCrumble, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 352, 53));

        jRadioButtonBerPancakes.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonBerPancakes.setText("Berry Pancakes                                            R70.00");
        jRadioButtonBerPancakes.setPreferredSize(new java.awt.Dimension(164, 22));
        jRadioButtonBerPancakes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonBerPancakesActionPerformed(evt);
            }
        });
        jPanelBreakfast.add(jRadioButtonBerPancakes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 352, 53));

        jRadioButtonEngBreakfast.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonEngBreakfast.setText("Full English Breakfast                                   R90.00");
        jRadioButtonEngBreakfast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEngBreakfastActionPerformed(evt);
            }
        });
        jPanelBreakfast.add(jRadioButtonEngBreakfast, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 352, 53));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("FreeSans", 1, 18)); // NOI18N
        jLabel2.setText("Breakfast");

        jPanelLunch.setBackground(new java.awt.Color(0, 0, 0));
        jPanelLunch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanelLunch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jRadioButtonBeefHotpot.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonBeefHotpot.setText("Beef Lancashire Hotpot                               R85.00");
        jRadioButtonBeefHotpot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonBeefHotpotActionPerformed(evt);
            }
        });
        jPanelLunch.add(jRadioButtonBeefHotpot, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 352, 40));

        jRadioButtonFishnChips.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonFishnChips.setText("Fish and Chips                                            R65.00");
        jRadioButtonFishnChips.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFishnChipsActionPerformed(evt);
            }
        });
        jPanelLunch.add(jRadioButtonFishnChips, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 352, 40));

        jRadioButtonLamb.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonLamb.setText("Lamb Lancashire Hotpot                              R95.00");
        jRadioButtonLamb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonLambActionPerformed(evt);
            }
        });
        jPanelLunch.add(jRadioButtonLamb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 352, 40));

        jRadioButtonMash.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonMash.setText("Bangers and Mash                                        R70.00");
        jRadioButtonMash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMashActionPerformed(evt);
            }
        });
        jPanelLunch.add(jRadioButtonMash, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 352, 53));

        jRadioButtonPie.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonPie.setText("Shepherd's Pie                                             R70.00");
        jRadioButtonPie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPieActionPerformed(evt);
            }
        });
        jPanelLunch.add(jRadioButtonPie, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 352, 53));

        jPanelDinner.setBackground(new java.awt.Color(0, 0, 0));
        jPanelDinner.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanelDinner.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jRadioButtonRoastChicken.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonRoastChicken.setText("Roast Chicken                                              R80.00");
        jRadioButtonRoastChicken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonRoastChickenActionPerformed(evt);
            }
        });
        jPanelDinner.add(jRadioButtonRoastChicken, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 352, 40));

        jRadioButtonBeef.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonBeef.setText("Beef Wellington                                          R250.00");
        jRadioButtonBeef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonBeefActionPerformed(evt);
            }
        });
        jPanelDinner.add(jRadioButtonBeef, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 352, 40));

        jRadioButtonCurry.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonCurry.setText("Vegetable Curry                                            R70.00");
        jRadioButtonCurry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCurryActionPerformed(evt);
            }
        });
        jPanelDinner.add(jRadioButtonCurry, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 352, 53));

        jRadioButtonBeefnPie.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonBeefnPie.setText("Beef and Alr Pie                                            R95.00");
        jRadioButtonBeefnPie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonBeefnPieActionPerformed(evt);
            }
        });
        jPanelDinner.add(jRadioButtonBeefnPie, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 352, 53));

        jRadioButtonChickenTikka.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonChickenTikka.setText("Chicken Tikka Masala                                 R100.00");
        jRadioButtonChickenTikka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonChickenTikkaActionPerformed(evt);
            }
        });
        jPanelDinner.add(jRadioButtonChickenTikka, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 352, 40));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("FreeSans", 1, 18)); // NOI18N
        jLabel1.setText("Supper");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("FreeSans", 1, 18)); // NOI18N
        jLabel3.setText("Lunch");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Total Cost");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTotal.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabelTotal.setText("Total");
        jPanel2.add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 70, 30));

        jLabelBreakfast.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabelBreakfast.setText("Breakfast");
        jPanel2.add(jLabelBreakfast, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 30));

        jLabelLunch.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabelLunch.setText("Lunch");
        jPanel2.add(jLabelLunch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 70, 30));

        jLabelSuper.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabelSuper.setText("Supper");
        jPanel2.add(jLabelSuper, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 70, 30));

        jTextFieldTotal.setText("0.00");
        jTextFieldTotal.setPreferredSize(new java.awt.Dimension(80, 24));
        jPanel2.add(jTextFieldTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        jTextFieldBreakfast.setText("0.00");
        jTextFieldBreakfast.setPreferredSize(new java.awt.Dimension(80, 24));
        jTextFieldBreakfast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBreakfastActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldBreakfast, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jTextFieldLunch.setText("0.00");
        jTextFieldLunch.setPreferredSize(new java.awt.Dimension(80, 24));
        jPanel2.add(jTextFieldLunch, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        jTextFieldSupper.setText("0.00");
        jTextFieldSupper.setPreferredSize(new java.awt.Dimension(80, 24));
        jPanel2.add(jTextFieldSupper, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, -1));

        jButtonPayment.setBackground(new java.awt.Color(0, 0, 0));
        jButtonPayment.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPayment.setText("Proceed To Payment");
        jButtonPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPaymentActionPerformed(evt);
            }
        });

        pnlHead.setBackground(new java.awt.Color(0, 0, 0));
        pnlHead.setPreferredSize(new java.awt.Dimension(1536, 100));
        pnlHead.setLayout(null);

        btnLogOut.setBackground(new java.awt.Color(0, 0, 0));
        btnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        btnLogOut.setText("Log Out");
        btnLogOut.setBorder(null);
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        pnlHead.add(btnLogOut);
        btnLogOut.setBounds(1430, 30, 80, 30);

        lblTravel.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        lblTravel.setForeground(new java.awt.Color(255, 255, 255));
        lblTravel.setText("T R A V E L");
        pnlHead.add(lblTravel);
        lblTravel.setBounds(60, 30, 70, 16);

        lblCentral.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        lblCentral.setForeground(new java.awt.Color(255, 255, 255));
        lblCentral.setText("C E N T R A L");
        pnlHead.add(lblCentral);
        lblCentral.setBounds(60, 50, 90, 15);

        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setText("Full Name");
        pnlHead.add(lblName);
        lblName.setBounds(0, 40, 1540, 16);

        btnBackToSearch.setBackground(new java.awt.Color(0, 0, 0));
        btnBackToSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnBackToSearch.setText("Back To Search");
        btnBackToSearch.setBorder(null);
        btnBackToSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToSearchActionPerformed(evt);
            }
        });
        pnlHead.add(btnBackToSearch);
        btnBackToSearch.setBounds(1330, 30, 100, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(637, 637, 637)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(60, 60, 60)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanelBreakfast, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addComponent(jPanelLunch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(58, 58, 58)
                            .addComponent(jPanelDinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(180, 180, 180))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlHead, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelBreakfast, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelLunch, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelDinner, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jButtonPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 160, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonCornPastyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCornPastyActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonCornPasty.isSelected()) {
            jRadioButtonEngBreakfast.setSelected(false);
            jRadioButtonSchoEgg.setSelected(false);
            jRadioButtonBlackCrumble.setSelected(false);
            jRadioButtonBerPancakes.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonCornPastyActionPerformed

    private void jRadioButtonSchoEggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSchoEggActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonSchoEgg.isSelected()) {
            jRadioButtonEngBreakfast.setSelected(false);
            jRadioButtonCornPasty.setSelected(false);
            jRadioButtonBlackCrumble.setSelected(false);
            jRadioButtonBerPancakes.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonSchoEggActionPerformed

    private void jRadioButtonBlackCrumbleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBlackCrumbleActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonBlackCrumble.isSelected()) {
            jRadioButtonEngBreakfast.setSelected(false);
            jRadioButtonCornPasty.setSelected(false);
            jRadioButtonSchoEgg.setSelected(false);
            jRadioButtonBerPancakes.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonBlackCrumbleActionPerformed

    private void jRadioButtonBerPancakesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBerPancakesActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonBerPancakes.isSelected()) {
            jRadioButtonEngBreakfast.setSelected(false);
            jRadioButtonCornPasty.setSelected(false);
            jRadioButtonSchoEgg.setSelected(false);
            jRadioButtonBlackCrumble.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonBerPancakesActionPerformed

    private void jRadioButtonEngBreakfastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEngBreakfastActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonEngBreakfast.isSelected()) {
            jRadioButtonCornPasty.setSelected(false);
            jRadioButtonSchoEgg.setSelected(false);
            jRadioButtonBlackCrumble.setSelected(false);
            jRadioButtonBerPancakes.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonEngBreakfastActionPerformed

    private void jRadioButtonBeefHotpotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBeefHotpotActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonBeefHotpot.isSelected()) {
            jRadioButtonFishnChips.setSelected(false);
            jRadioButtonLamb.setSelected(false);
            jRadioButtonPie.setSelected(false);
            jRadioButtonMash.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonBeefHotpotActionPerformed

    private void jRadioButtonFishnChipsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFishnChipsActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonFishnChips.isSelected()) {
            jRadioButtonBeefHotpot.setSelected(false);
            jRadioButtonLamb.setSelected(false);
            jRadioButtonPie.setSelected(false);
            jRadioButtonMash.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonFishnChipsActionPerformed

    private void jRadioButtonLambActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonLambActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonLamb.isSelected()) {
            jRadioButtonFishnChips.setSelected(false);
            jRadioButtonBeefHotpot.setSelected(false);
            jRadioButtonPie.setSelected(false);
            jRadioButtonMash.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonLambActionPerformed

    private void jRadioButtonMashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMashActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonMash.isSelected()) {
            jRadioButtonFishnChips.setSelected(false);
            jRadioButtonBeefHotpot.setSelected(false);
            jRadioButtonLamb.setSelected(false);
            jRadioButtonPie.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonMashActionPerformed

    private void jRadioButtonPieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPieActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonPie.isSelected()) {
            jRadioButtonFishnChips.setSelected(false);
            jRadioButtonBeefHotpot.setSelected(false);
            jRadioButtonLamb.setSelected(false);
            jRadioButtonMash.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonPieActionPerformed

    private void jRadioButtonRoastChickenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonRoastChickenActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonRoastChicken.isSelected()) {
            jRadioButtonBeef.setSelected(false);
            jRadioButtonChickenTikka.setSelected(false);
            jRadioButtonBeefnPie.setSelected(false);
            jRadioButtonCurry.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonRoastChickenActionPerformed

    private void jRadioButtonBeefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBeefActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonBeef.isSelected()) {
            jRadioButtonChickenTikka.setSelected(false);
            jRadioButtonRoastChicken.setSelected(false);
            jRadioButtonBeefnPie.setSelected(false);
            jRadioButtonCurry.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonBeefActionPerformed

    private void jRadioButtonCurryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCurryActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonCurry.isSelected()) {
            jRadioButtonBeef.setSelected(false);
            jRadioButtonChickenTikka.setSelected(false);
            jRadioButtonRoastChicken.setSelected(false);
            jRadioButtonBeefnPie.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonCurryActionPerformed

    private void jRadioButtonBeefnPieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBeefnPieActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonBeefnPie.isSelected()) {
            jRadioButtonBeef.setSelected(false);
            jRadioButtonChickenTikka.setSelected(false);
            jRadioButtonRoastChicken.setSelected(false);
            jRadioButtonCurry.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonBeefnPieActionPerformed

    private void jRadioButtonChickenTikkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonChickenTikkaActionPerformed

        if (jRadioButtonChickenTikka.isSelected()) {
            jRadioButtonBeef.setSelected(false);
            jRadioButtonRoastChicken.setSelected(false);
            jRadioButtonBeefnPie.setSelected(false);
            jRadioButtonCurry.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonChickenTikkaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        jPanel2.setVisible(true);

        float total = 0;
        float breakfast = 0;
        float lunch = 0;
        float supper = 0;

        if (jRadioButtonEngBreakfast.isSelected()) {
            breakfast = breakfast + 90;
        } else if (jRadioButtonCornPasty.isSelected()) {
            breakfast = breakfast + 55;
        } else if (jRadioButtonSchoEgg.isSelected()) {
            breakfast = breakfast + 60;
        } else if (jRadioButtonBlackCrumble.isSelected()) {
            breakfast = breakfast + 50;
        } else if (jRadioButtonBerPancakes.isSelected()) {
            breakfast = breakfast + 70;
        }

        if (jRadioButtonFishnChips.isSelected()) {
            lunch = lunch + 65;
        } else if (jRadioButtonBeefHotpot.isSelected()) {
            lunch = lunch + 85;
        } else if (jRadioButtonLamb.isSelected()) {
            lunch = lunch + 95;
        } else if (jRadioButtonPie.isSelected()) {
            lunch = lunch + 70;
        } else if (jRadioButtonMash.isSelected()) {
            lunch = lunch + 70;
        }

        if (jRadioButtonBeef.isSelected()) {
            supper = supper + 250;
        } else if (jRadioButtonChickenTikka.isSelected()) {
            supper = supper + 100;
        } else if (jRadioButtonRoastChicken.isSelected()) {
            supper = supper + 80;
        } else if (jRadioButtonBeefnPie.isSelected()) {
            supper = supper + 95;
        } else if (jRadioButtonCurry.isSelected()) {
            supper = supper + 70;
        }

        total = breakfast + lunch + supper;
        mealCost = total;

        jTextFieldBreakfast.setText(Float.toString(breakfast));
        jTextFieldLunch.setText(Float.toString(lunch));
        jTextFieldSupper.setText(Float.toString(supper));
        jTextFieldTotal.setText(Float.toString(total));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldBreakfastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBreakfastActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBreakfastActionPerformed

    private void jButtonPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPaymentActionPerformed
        SeparateHotelBookingUI hotelBooking = new SeparateHotelBookingUI(checkInDate, checkOutDate, meals, hotelCost, numNights, mealCost, bookingNumber, arrivalAirportBooking);
        hotelBooking.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonPaymentActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        LogOutUI logOut = new LogOutUI();

        logOut.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnBackToSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToSearchActionPerformed
        HotelListingUI mainFrame;
        try {
            mainFrame = new HotelListingUI();
            // Set the visibility of the HotelListingUI frame
            mainFrame.setVisible(true);
            // Close the current frame
            this.dispose();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(HotelSearchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBackToSearchActionPerformed

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
            java.util.logging.Logger.getLogger(SeparateHotelMealsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeparateHotelMealsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeparateHotelMealsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeparateHotelMealsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new SeparateHotelMealsUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackToSearch;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonPayment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelBreakfast;
    private javax.swing.JLabel jLabelLunch;
    private javax.swing.JLabel jLabelSuper;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelBreakfast;
    private javax.swing.JPanel jPanelDinner;
    private javax.swing.JPanel jPanelLunch;
    private javax.swing.JRadioButton jRadioButtonBeef;
    private javax.swing.JRadioButton jRadioButtonBeefHotpot;
    private javax.swing.JRadioButton jRadioButtonBeefnPie;
    private javax.swing.JRadioButton jRadioButtonBerPancakes;
    private javax.swing.JRadioButton jRadioButtonBlackCrumble;
    private javax.swing.JRadioButton jRadioButtonChickenTikka;
    private javax.swing.JRadioButton jRadioButtonCornPasty;
    private javax.swing.JRadioButton jRadioButtonCurry;
    private javax.swing.JRadioButton jRadioButtonEngBreakfast;
    private javax.swing.JRadioButton jRadioButtonFishnChips;
    private javax.swing.JRadioButton jRadioButtonLamb;
    private javax.swing.JRadioButton jRadioButtonMash;
    private javax.swing.JRadioButton jRadioButtonPie;
    private javax.swing.JRadioButton jRadioButtonRoastChicken;
    private javax.swing.JRadioButton jRadioButtonSchoEgg;
    private javax.swing.JTextField jTextFieldBreakfast;
    private javax.swing.JTextField jTextFieldLunch;
    private javax.swing.JTextField jTextFieldSupper;
    private javax.swing.JTextField jTextFieldTotal;
    private javax.swing.JLabel lblCentral;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTravel;
    private javax.swing.JPanel pnlHead;
    // End of variables declaration//GEN-END:variables
}
