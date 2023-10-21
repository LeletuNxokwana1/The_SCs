/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package travelcentralflightmanagementsystem;

/**
 *
 * @author the_scs
 */
public class AdminOverviewUI extends javax.swing.JFrame {

    private ProgramManager programManager;
    
    public AdminOverviewUI() {
        programManager = new ProgramManager();
        initComponents();
        updateStatistics();
        
        setSize(1536, 1536);
        
        if (!SessionManager.isLoggedIn()) {
            lblName.setVisible(false);
        } else {
            lblName.setText(SessionManager.getLoggedInUsername());
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlHead = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        lblTravelCentral = new javax.swing.JLabel();
        lblSlogan = new javax.swing.JLabel();
        pnlBlock1 = new javax.swing.JPanel();
        pnlBlock2 = new javax.swing.JPanel();
        pnlBlock3 = new javax.swing.JPanel();
        pnlNumUsers = new javax.swing.JPanel();
        lblNumUsers = new javax.swing.JLabel();
        lblNumU = new javax.swing.JLabel();
        pnlNumFlightBookings = new javax.swing.JPanel();
        lblNumFlightBookings = new javax.swing.JLabel();
        lblNumFB = new javax.swing.JLabel();
        pnlNumHotelBookings = new javax.swing.JPanel();
        lblNumHotelBookings = new javax.swing.JLabel();
        lblNumHB = new javax.swing.JLabel();
        pnlSide = new javax.swing.JPanel();
        btnFlightManagement = new javax.swing.JButton();
        btnUserManagement = new javax.swing.JButton();
        btnHotelManagement = new javax.swing.JButton();
        btnAirportManagement = new javax.swing.JButton();
        btnAircraftManagement = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setSize(new java.awt.Dimension(1536, 1536));
        getContentPane().setLayout(null);

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain.setPreferredSize(new java.awt.Dimension(1536, 1536));
        pnlMain.setLayout(null);

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

        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setText("Full Name");
        pnlHead.add(lblName);
        lblName.setBounds(0, 40, 1540, 16);

        pnlMain.add(pnlHead);
        pnlHead.setBounds(0, 0, 1536, 80);

        lblTravelCentral.setFont(new java.awt.Font("Perpetua Titling MT", 0, 72)); // NOI18N
        lblTravelCentral.setText("TRAVEL CENTRAL");
        pnlMain.add(lblTravelCentral);
        lblTravelCentral.setBounds(700, 140, 630, 140);

        lblSlogan.setFont(new java.awt.Font("Poor Richard", 0, 24)); // NOI18N
        lblSlogan.setText("Where Travel Meets Simplicity");
        pnlMain.add(lblSlogan);
        lblSlogan.setBounds(1030, 240, 290, 28);

        pnlBlock1.setBackground(new java.awt.Color(0, 0, 0));
        pnlBlock1.setPreferredSize(new java.awt.Dimension(154, 15));

        javax.swing.GroupLayout pnlBlock1Layout = new javax.swing.GroupLayout(pnlBlock1);
        pnlBlock1.setLayout(pnlBlock1Layout);
        pnlBlock1Layout.setHorizontalGroup(
            pnlBlock1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 154, Short.MAX_VALUE)
        );
        pnlBlock1Layout.setVerticalGroup(
            pnlBlock1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        pnlMain.add(pnlBlock1);
        pnlBlock1.setBounds(1380, 300, 154, 15);

        pnlBlock2.setBackground(new java.awt.Color(255, 255, 255));
        pnlBlock2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBlock2.setPreferredSize(new java.awt.Dimension(154, 15));

        javax.swing.GroupLayout pnlBlock2Layout = new javax.swing.GroupLayout(pnlBlock2);
        pnlBlock2.setLayout(pnlBlock2Layout);
        pnlBlock2Layout.setHorizontalGroup(
            pnlBlock2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
        );
        pnlBlock2Layout.setVerticalGroup(
            pnlBlock2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        pnlMain.add(pnlBlock2);
        pnlBlock2.setBounds(1230, 300, 154, 15);

        pnlBlock3.setBackground(new java.awt.Color(0, 0, 0));
        pnlBlock3.setPreferredSize(new java.awt.Dimension(154, 15));

        javax.swing.GroupLayout pnlBlock3Layout = new javax.swing.GroupLayout(pnlBlock3);
        pnlBlock3.setLayout(pnlBlock3Layout);
        pnlBlock3Layout.setHorizontalGroup(
            pnlBlock3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 154, Short.MAX_VALUE)
        );
        pnlBlock3Layout.setVerticalGroup(
            pnlBlock3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        pnlMain.add(pnlBlock3);
        pnlBlock3.setBounds(1080, 300, 154, 15);

        pnlNumUsers.setBackground(new java.awt.Color(255, 255, 255));
        pnlNumUsers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlNumUsers.setPreferredSize(new java.awt.Dimension(170, 100));
        pnlNumUsers.setLayout(null);

        lblNumUsers.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNumUsers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumUsers.setText("Number of Users");
        pnlNumUsers.add(lblNumUsers);
        lblNumUsers.setBounds(0, 30, 170, 16);

        lblNumU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumU.setText("0");
        pnlNumUsers.add(lblNumU);
        lblNumU.setBounds(0, 60, 170, 16);

        pnlMain.add(pnlNumUsers);
        pnlNumUsers.setBounds(1070, 470, 170, 100);

        pnlNumFlightBookings.setBackground(new java.awt.Color(255, 255, 255));
        pnlNumFlightBookings.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlNumFlightBookings.setPreferredSize(new java.awt.Dimension(170, 100));
        pnlNumFlightBookings.setLayout(null);

        lblNumFlightBookings.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNumFlightBookings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumFlightBookings.setText("Number of Flight Bookings");
        pnlNumFlightBookings.add(lblNumFlightBookings);
        lblNumFlightBookings.setBounds(0, 30, 170, 16);

        lblNumFB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumFB.setText("0");
        pnlNumFlightBookings.add(lblNumFB);
        lblNumFB.setBounds(0, 60, 170, 16);

        pnlMain.add(pnlNumFlightBookings);
        pnlNumFlightBookings.setBounds(900, 470, 170, 100);

        pnlNumHotelBookings.setBackground(new java.awt.Color(255, 255, 255));
        pnlNumHotelBookings.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlNumHotelBookings.setPreferredSize(new java.awt.Dimension(170, 100));
        pnlNumHotelBookings.setLayout(null);

        lblNumHotelBookings.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNumHotelBookings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumHotelBookings.setText("Number of Hotel Bookings");
        pnlNumHotelBookings.add(lblNumHotelBookings);
        lblNumHotelBookings.setBounds(1, 31, 168, 16);

        lblNumHB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumHB.setText("0");
        pnlNumHotelBookings.add(lblNumHB);
        lblNumHB.setBounds(0, 60, 168, 16);

        pnlMain.add(pnlNumHotelBookings);
        pnlNumHotelBookings.setBounds(730, 470, 170, 100);

        pnlSide.setBackground(new java.awt.Color(0, 0, 0));
        pnlSide.setLayout(null);

        btnFlightManagement.setBackground(new java.awt.Color(0, 0, 0));
        btnFlightManagement.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        btnFlightManagement.setForeground(new java.awt.Color(255, 255, 255));
        btnFlightManagement.setText("FLIGHT MANAGEMENT");
        btnFlightManagement.setBorderPainted(false);
        btnFlightManagement.setPreferredSize(new java.awt.Dimension(400, 40));
        btnFlightManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlightManagementActionPerformed(evt);
            }
        });
        pnlSide.add(btnFlightManagement);
        btnFlightManagement.setBounds(0, 210, 400, 40);

        btnUserManagement.setBackground(new java.awt.Color(0, 0, 0));
        btnUserManagement.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        btnUserManagement.setForeground(new java.awt.Color(255, 255, 255));
        btnUserManagement.setText("USER MANAGEMENT");
        btnUserManagement.setBorderPainted(false);
        btnUserManagement.setPreferredSize(new java.awt.Dimension(400, 40));
        btnUserManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserManagementActionPerformed(evt);
            }
        });
        pnlSide.add(btnUserManagement);
        btnUserManagement.setBounds(0, 250, 400, 40);

        btnHotelManagement.setBackground(new java.awt.Color(0, 0, 0));
        btnHotelManagement.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        btnHotelManagement.setForeground(new java.awt.Color(255, 255, 255));
        btnHotelManagement.setText("HOTEL MANAGEMENT");
        btnHotelManagement.setBorderPainted(false);
        btnHotelManagement.setPreferredSize(new java.awt.Dimension(400, 40));
        btnHotelManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHotelManagementActionPerformed(evt);
            }
        });
        pnlSide.add(btnHotelManagement);
        btnHotelManagement.setBounds(0, 290, 400, 40);

        btnAirportManagement.setBackground(new java.awt.Color(0, 0, 0));
        btnAirportManagement.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        btnAirportManagement.setForeground(new java.awt.Color(255, 255, 255));
        btnAirportManagement.setText("AIRPORT MANAGEMENT");
        btnAirportManagement.setBorderPainted(false);
        btnAirportManagement.setPreferredSize(new java.awt.Dimension(400, 40));
        btnAirportManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAirportManagementActionPerformed(evt);
            }
        });
        pnlSide.add(btnAirportManagement);
        btnAirportManagement.setBounds(0, 330, 400, 40);

        btnAircraftManagement.setBackground(new java.awt.Color(0, 0, 0));
        btnAircraftManagement.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        btnAircraftManagement.setForeground(new java.awt.Color(255, 255, 255));
        btnAircraftManagement.setText("AIRCRAFT MANAGEMENT");
        btnAircraftManagement.setBorderPainted(false);
        btnAircraftManagement.setPreferredSize(new java.awt.Dimension(400, 40));
        btnAircraftManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAircraftManagementActionPerformed(evt);
            }
        });
        pnlSide.add(btnAircraftManagement);
        btnAircraftManagement.setBounds(0, 370, 400, 40);

        pnlMain.add(pnlSide);
        pnlSide.setBounds(0, 80, 400, 1460);

        getContentPane().add(pnlMain);
        pnlMain.setBounds(0, 0, 1536, 1536);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFlightManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlightManagementActionPerformed
        FlightManagementUI flightManagement = new FlightManagementUI();
        flightManagement.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnFlightManagementActionPerformed

    private void btnUserManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserManagementActionPerformed
        UserManagementUI userManagement = new UserManagementUI();
        userManagement.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnUserManagementActionPerformed

    private void btnHotelManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHotelManagementActionPerformed
        HotelManagementUI hotelManagement = new HotelManagementUI();
        hotelManagement.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHotelManagementActionPerformed

    private void btnAirportManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAirportManagementActionPerformed
        AirportManagementUI airportManagement = new AirportManagementUI();
        airportManagement.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAirportManagementActionPerformed

    private void btnAircraftManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAircraftManagementActionPerformed
        AircraftManagementUI aircraftManagement = new AircraftManagementUI();
        aircraftManagement.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAircraftManagementActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        LogOutUI logOut = new LogOutUI();

        logOut.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void updateStatistics() {
        // Update the JLabels with the retrieved statistics
        lblNumU.setText(Integer.toString(programManager.retrieveNumberOfUsers()));
        lblNumHB.setText(Integer.toString(programManager.retrieveNumberOfHotelBookings()));
        lblNumFB.setText(Integer.toString(programManager.retrieveNumberOfFlightBookings()));
    }
    
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
            java.util.logging.Logger.getLogger(AdminOverviewUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminOverviewUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminOverviewUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminOverviewUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminOverviewUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAircraftManagement;
    private javax.swing.JButton btnAirportManagement;
    private javax.swing.JButton btnFlightManagement;
    private javax.swing.JButton btnHotelManagement;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnUserManagement;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNumFB;
    private javax.swing.JLabel lblNumFlightBookings;
    private javax.swing.JLabel lblNumHB;
    private javax.swing.JLabel lblNumHotelBookings;
    private javax.swing.JLabel lblNumU;
    private javax.swing.JLabel lblNumUsers;
    private javax.swing.JLabel lblSlogan;
    private javax.swing.JLabel lblTravelCentral;
    private javax.swing.JPanel pnlBlock1;
    private javax.swing.JPanel pnlBlock2;
    private javax.swing.JPanel pnlBlock3;
    private javax.swing.JPanel pnlHead;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlNumFlightBookings;
    private javax.swing.JPanel pnlNumHotelBookings;
    private javax.swing.JPanel pnlNumUsers;
    private javax.swing.JPanel pnlSide;
    // End of variables declaration//GEN-END:variables
}
