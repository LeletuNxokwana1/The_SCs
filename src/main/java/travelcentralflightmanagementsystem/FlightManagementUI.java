/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package travelcentralflightmanagementsystem;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Component;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author the_scs
 */
public class FlightManagementUI extends javax.swing.JFrame {

    private ProgramManager programManager;
    private JTable flightTable;
    private DefaultTableModel tableModel;
    private JComboBox<String> departureAirportComboBox;
    private JComboBox<String> arrivalAirportComboBox;
    private JComboBox<String> flightStatusComboBox;
    private JComboBox<String> aircraftComboBox;
    private JDateChooser departureDateChooser;
    private JDateChooser arrivalDateChooser;
    private JTextField flightCostTextField;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-d");

    public FlightManagementUI() {
        programManager = new ProgramManager();

        // Initialize components
        initComponents();

        if (!SessionManager.isLoggedIn()) {
            lblName.setVisible(false);
        } else {
            lblName.setText(SessionManager.getLoggedInUsername());
        }

        // Dynamic creation of components
        departureAirportComboBox = new JComboBox<>(listToArray(programManager.getAirportNames()));
        arrivalAirportComboBox = new JComboBox<>(listToArray(programManager.getAirportNames()));
        flightStatusComboBox = new JComboBox<>(listToArray(programManager.getFlightStatusOptions()));
        aircraftComboBox = new JComboBox<>(listToArray(programManager.getAircraftNames()));
        departureDateChooser = new JDateChooser();
        arrivalDateChooser = new JDateChooser();
        JTextFieldDateEditor editor = (JTextFieldDateEditor) departureDateChooser.getDateEditor();
        // Set the format for displaying the date in the date chooser
        editor.setDateFormatString("yyyy-MM-d");

        // Initialize flightCostTextField
        flightCostTextField = new JTextField();

        // Set up the table model with columns
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.setColumnIdentifiers(new Object[]{"Flight ID", "Flight Cost", "Flight Departure Date",
            "Flight Arrival Date", "Flight Status", "Departure Airport", "Arrival Airport", "Aircraft ID"});

        refreshFlightTable();
    }

    private String[] listToArray(List<String> list) {
        return list.toArray(new String[0]);
    }

    private void refreshFlightTable() {
        // Assuming the table model is already set by NetBeans
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();

        // Retrieve flight data from the database and update the table
        List<DepartureFlight> flights = programManager.retrieveFlights();

        // Clear existing data in the table
        tableModel.setRowCount(0);

        // Populate the table with the retrieved flights
        for (DepartureFlight flight : flights) {
            // Add a row to the table model with flight details
            tableModel.addRow(new Object[]{
                flight.getScheduledFlightID(),
                flight.getScheduledFlightPrice(),
                flight.getScheduledFlightDepartureDate(),
                flight.getScheduledFlightArrivalDate(),
                flight.getScheduledFlightStatus(),
                flight.getDepartureAirportID(),
                flight.getArrivalAirportID(),
                flight.getAircraftID()
            });
        }

        int selectedRow1 = jTable1.getSelectedRow();
        if (selectedRow1 != -1) {
            // Set the flight cost from the selected row
            Object selectedFlightCost = tableModel.getValueAt(selectedRow1, 1);
            if (selectedFlightCost != null) {
                flightCostTextField.setText(String.valueOf(selectedFlightCost));
            }
        }

        // Add combo boxes and date choosers to the table
        TableColumnModel columnModel = jTable1.getColumnModel();
        columnModel.getColumn(4).setCellEditor(new DefaultCellEditor(flightStatusComboBox));
        columnModel.getColumn(5).setCellEditor(new DefaultCellEditor(departureAirportComboBox));
        columnModel.getColumn(6).setCellEditor(new DefaultCellEditor(arrivalAirportComboBox));
        columnModel.getColumn(2).setCellEditor(new JDateChooserCellEditor(departureDateChooser));
        columnModel.getColumn(3).setCellEditor(new JDateChooserCellEditor(arrivalDateChooser));
        columnModel.getColumn(1).setCellEditor(new DefaultCellEditor(flightCostTextField));

        // Add a JComboBox for Aircraft ID in the seventh column
        String[] aircraftIDs = listToArray(programManager.getAircraftNames());
        JComboBox<String> aircraftComboBox = new JComboBox<>(aircraftIDs);
        columnModel.getColumn(7).setCellEditor(new DefaultCellEditor(aircraftComboBox));

        // Set the dates based on the selected row
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            String depDateStr = (String) tableModel.getValueAt(selectedRow, 2);
            String arrDateStr = (String) tableModel.getValueAt(selectedRow, 3);

            try {
                Date departureDate = dateFormat.parse(depDateStr);
                Date arrivalDate = dateFormat.parse(arrDateStr);

                // Initialize date choosers if not already done
                if (departureDateChooser == null) {
                    departureDateChooser = new JDateChooser();
                    JTextFieldDateEditor editor = (JTextFieldDateEditor) departureDateChooser.getDateEditor();
                    editor.setDateFormatString("yyyy-MM-d");
                }
                if (arrivalDateChooser == null) {
                    arrivalDateChooser = new JDateChooser();
                    JTextFieldDateEditor editor = (JTextFieldDateEditor) arrivalDateChooser.getDateEditor();
                    editor.setDateFormatString("yyyy-MM-d");
                }

                departureDateChooser.setDate(departureDate);
                arrivalDateChooser.setDate(arrivalDate);
            } catch (ParseException e) {
                e.printStackTrace();
                // Handle the exception according to your needs
            }
        }
    }

    private void updateDatabaseWithChanges() {
        // Iterate through the rows of the table and check for changes
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();

        // Check if a row is selected
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            // Get values from the table model
            int flightID = (int) tableModel.getValueAt(selectedRow, 0);

            try {
                // Update the flight cost text field with the latest value
                flightCostTextField.postActionEvent();

                String newDepartureAirport = (String) departureAirportComboBox.getSelectedItem();
                String newArrivalAirport = (String) arrivalAirportComboBox.getSelectedItem();
                String newFlightStatus = (String) flightStatusComboBox.getSelectedItem();
                String newAircraft = (String) aircraftComboBox.getSelectedItem();

                // Format the date as a string in the desired format
                Date newDepartureDate = departureDateChooser.getDate();
                Date newArrivalDate = arrivalDateChooser.getDate();

                // Check if either newDepartureDate or newArrivalDate is null
                if (newDepartureDate == null || newArrivalDate == null) {
                    JOptionPane.showMessageDialog(this, "Please update all fields in the row.",
                            "Incomplete Information", JOptionPane.WARNING_MESSAGE);
                    return; // Exit the method if dates are null
                }

                String formattedDepDateStr = dateFormat.format(newDepartureDate);

                // Get flight cost as a string
                String flightCostString = flightCostTextField.getText().trim();

                try {
                    newDepartureDate = dateFormat.parse(formattedDepDateStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                    newDepartureDate = null; // Handle the exception
                }

                // Check if flightCostString is not empty
                if (!flightCostString.isEmpty()) {
                    float newFlightCost = Float.parseFloat(flightCostString);

                    System.out.println("New flight cost (from text field): " + flightCostString);

                    // Update the database with changes
                    programManager.updateFlightDetails(flightID, newDepartureAirport, newArrivalAirport,
                            newFlightStatus, newAircraft, newDepartureDate, newArrivalDate, newFlightCost);

                    // Refresh the table after making changes
                    refreshFlightTable();
                } else {
                    // Handle the case where flightCostString is empty

                    System.out.println("Flight Cost cannot be empty.");
                }
            } catch (NumberFormatException e) {
                // Handle the case where the input is not a valid float

                System.out.println("Invalid Flight Cost format. Please enter a valid number.");
            }
        } else {
            // Handle the case where no row is selected
            System.out.println("Please select a row to update.");
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
        btnHome = new javax.swing.JButton();
        lblTravel = new javax.swing.JLabel();
        lblCentral = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        pnlSide = new javax.swing.JPanel();
        btnFlightManagement = new javax.swing.JButton();
        btnUserManagement = new javax.swing.JButton();
        btnHotelManagement = new javax.swing.JButton();
        btnAirportManagement = new javax.swing.JButton();
        btnAircraftManagement = new javax.swing.JButton();
        btnConfirm = new javax.swing.JButton();
        lblUsers = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        btnHome.setBackground(new java.awt.Color(0, 0, 0));
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setText("Home");
        btnHome.setBorder(null);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        pnlHead.add(btnHome);
        btnHome.setBounds(1350, 30, 80, 30);

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

        pnlMain.add(pnlHead);
        pnlHead.setBounds(0, 0, 1536, 80);

        pnlSide.setBackground(new java.awt.Color(0, 0, 0));
        pnlSide.setLayout(null);

        btnFlightManagement.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
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

        btnConfirm.setBackground(new java.awt.Color(0, 0, 0));
        btnConfirm.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirm.setText("Confirm Changes");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        pnlMain.add(btnConfirm);
        btnConfirm.setBounds(1290, 780, 120, 30);

        lblUsers.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblUsers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsers.setText("Flights");
        pnlMain.add(lblUsers);
        lblUsers.setBounds(400, 70, 1140, 120);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setRowHeight(40);
        jScrollPane1.setViewportView(jTable1);

        pnlMain.add(jScrollPane1);
        jScrollPane1.setBounds(530, 160, 880, 620);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1536, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1536, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        AdminOverviewUI adminOverview = new AdminOverviewUI();
        adminOverview.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // Check for changes in the table and update the database
        updateDatabaseWithChanges();
    }//GEN-LAST:event_btnConfirmActionPerformed

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

    private void btnFlightManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlightManagementActionPerformed

    }//GEN-LAST:event_btnFlightManagementActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        LogOutUI logOut = new LogOutUI();

        logOut.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

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
            java.util.logging.Logger.getLogger(FlightManagementUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlightManagementUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlightManagementUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlightManagementUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlightManagementUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAircraftManagement;
    private javax.swing.JButton btnAirportManagement;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnFlightManagement;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnHotelManagement;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnUserManagement;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCentral;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTravel;
    private javax.swing.JLabel lblUsers;
    private javax.swing.JPanel pnlHead;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlSide;
    // End of variables declaration//GEN-END:variables
    private class JDateChooserCellEditor extends AbstractCellEditor implements TableCellEditor {

        private JDateChooser dateChooser;

        public JDateChooserCellEditor(JDateChooser dateChooser) {
            this.dateChooser = dateChooser;
        }

        @Override
        public Object getCellEditorValue() {
            return dateChooser.getDate();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return dateChooser;
        }
    }

}
