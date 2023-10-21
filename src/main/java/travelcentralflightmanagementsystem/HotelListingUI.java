/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package travelcentralflightmanagementsystem;

import java.awt.Component;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author the_scs
 */
public class HotelListingUI extends javax.swing.JFrame {

    private ProgramManager programManager;
    private float hotelCost;
    private boolean meals;
    private String checkInDate;
    private String checkOutDate;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String departureAirport;
    private String arrivalAirport;
    private String departureDate;
    private String returnDate;
    private int numPassengers;
    private String travelClass;
    private boolean oneWay;
    private Date depDate;
    private Date retDate;
    private float departureFlightPrice;
    private float returnFlightPrice;
    private String[] passengerFirstName;
    private String[] passengerLastName;
    private int[] passengerAge;
    private String departureTime;
    private String arrivalTime;
    private String rDepartureTime;
    private String rArrivalTime;
    private int depFlightID;
    private int retFlightID = 0;

    public HotelListingUI() throws SQLException {

        initComponents();
        populateTable();
        btnReserve.setVisible(false);
    }

    public HotelListingUI(String departureAirport, String arrivalAirport, String departureDate, String returnDate, int numPassengers, String travelClass, boolean oneWay, float departureFlightPrice, float returnFlightPrice, String departureTime, String arrivalTime, String rDepartureTime, String rArrivalTime, int depFlightID, int retFlightID, String checkInDate, String checkOutDate, boolean meals) throws SQLException {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.numPassengers = numPassengers;
        this.travelClass = travelClass;
        this.oneWay = oneWay;
        this.departureFlightPrice = departureFlightPrice;
        this.returnFlightPrice = returnFlightPrice;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.rDepartureTime = rDepartureTime;
        this.rArrivalTime = rArrivalTime;
        this.depFlightID = depFlightID;
        this.retFlightID = retFlightID;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.meals = meals;

        initComponents();
        programManager = new ProgramManager();
        lblTitle.setText(programManager.retrieveCityName(arrivalAirport) + " Hotel rooms for a " + calculateNumberOfDays(checkInDate, checkOutDate) +" night(s) stay");
        populateTable();
        btnReserve.setVisible(false);
        
        if (!SessionManager.isLoggedIn()) {
            lblName.setVisible(false);
            btnLogOut.setVisible(false);
        } else {
            lblName.setText(SessionManager.getLoggedInUsername());
        }
    }

    private void populateTable() {
        boolean[] editableColumns = {false, false, true, false}; // Set the third column (index 2) as editable
        DefaultTableModel model = new NonEditableTableModel(
                new Object[][]{},
                new String[]{
                    "Room Type", "Number of Guests", "Number of Rooms", "Price per Night"
                },
                editableColumns
        );
        tblRooms.setModel(model);
        setColumnWidths();
        setSpinnerColumn(2); // Set the spinner for the "Number of Rooms" column

        try {
            List<RoomType> roomTypes = programManager.retrieveRoomTypes();
            for (RoomType roomType : roomTypes) {
                // Construct the row with RoomTypeName and RoomTypeDescription
                Object[] row = {
                    getFormattedRow(roomType.getRoomTypeName(), roomType.getRoomTypeDescription()),
                    roomType.getRoomTypeMaxGuests(),
                    0,
                    roomType.getRoomTypeCost()
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setSpinnerColumn(int columnIndex) {
        TableColumn column = tblRooms.getColumnModel().getColumn(columnIndex);
        column.setCellEditor(new SpinnerEditor());
    }

    private void setColumnWidths() {
        TableColumnModel columnModel = tblRooms.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(800);
        columnModel.getColumn(1).setPreferredWidth(50);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(80);
    }

    private String getFormattedRow(String roomTypeName, String roomTypeDescription) {
        // Split RoomTypeDescription into lines and concatenate with hyphen
        String[] descriptionLines = roomTypeDescription.split("-");
        StringBuilder formattedRow = new StringBuilder();

        // Add RoomTypeName in bold followed by a colon
        formattedRow.append("<html><b>").append(roomTypeName).append(":</b> ");

        // Add formatted RoomTypeDescription with spaces between hyphens
        for (String line : descriptionLines) {
            formattedRow.append(" - ").append(line.trim());
        }

        return formattedRow.toString();
    }

    private class NonEditableTableModel extends DefaultTableModel {

        private final boolean[] editableColumns;

        public NonEditableTableModel(Object[][] data, Object[] columnNames, boolean[] editableColumns) {
            super(data, columnNames);
            this.editableColumns = editableColumns;
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return editableColumns[column];
        }
    }

    private class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {

        private final JSpinner spinner;

        public SpinnerEditor() {
            spinner = new JSpinner(new SpinnerNumberModel(0, 0, 5, 1));
        }

        @Override
        public Object getCellEditorValue() {
            return spinner.getValue();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            spinner.setValue(value);
            return spinner;
        }
    }

    private float updateTotalCost() {
        int hotelCost1 = 0;

        for (int i = 0; i < tblRooms.getRowCount(); i++) {
            int numberOfRooms = (int) tblRooms.getValueAt(i, 2); // The spinner is in the third column (index 2)
            float roomTypeCost = (float) tblRooms.getValueAt(i, 3); // The cost is in the fourth column (index 3)
            hotelCost1 += numberOfRooms * roomTypeCost * calculateNumberOfDays(checkInDate, checkOutDate);
        }
        
        return hotelCost1;
    }

    private int calculateNumberOfDays(String checkInDate, String checkOutDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate checkInLocalDate = LocalDate.parse(checkInDate, formatter);
        LocalDate checkOutLocalDate = LocalDate.parse(checkOutDate, formatter);

        return (int) checkInLocalDate.until(checkOutLocalDate).getDays();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRooms = new javax.swing.JTable();
        lblTotalCost = new javax.swing.JLabel();
        lblCost = new javax.swing.JLabel();
        btnGetTotalCost = new javax.swing.JButton();
        btnReserve = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        pnlHead = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JButton();
        lblTravel = new javax.swing.JLabel();
        lblCentral = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1507, 810));
        getContentPane().setLayout(null);

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain.setMinimumSize(new java.awt.Dimension(1539, 800));
        pnlMain.setPreferredSize(new java.awt.Dimension(1539, 800));
        pnlMain.setLayout(null);

        tblRooms.setModel(new javax.swing.table.DefaultTableModel(
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
        tblRooms.setRowHeight(40);
        jScrollPane1.setViewportView(tblRooms);

        pnlMain.add(jScrollPane1);
        jScrollPane1.setBounds(0, 170, 1500, 380);

        lblTotalCost.setText("Total Cost: R");
        pnlMain.add(lblTotalCost);
        lblTotalCost.setBounds(1330, 630, 70, 16);

        lblCost.setText("0000.00");
        pnlMain.add(lblCost);
        lblCost.setBounds(1410, 630, 70, 16);

        btnGetTotalCost.setBackground(new java.awt.Color(0, 0, 0));
        btnGetTotalCost.setForeground(new java.awt.Color(255, 255, 255));
        btnGetTotalCost.setText("Get Total Cost");
        btnGetTotalCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetTotalCostActionPerformed(evt);
            }
        });
        pnlMain.add(btnGetTotalCost);
        btnGetTotalCost.setBounds(1330, 580, 130, 30);

        btnReserve.setBackground(new java.awt.Color(0, 0, 0));
        btnReserve.setForeground(new java.awt.Color(255, 255, 255));
        btnReserve.setText("Reserve");
        btnReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReserveActionPerformed(evt);
            }
        });
        pnlMain.add(btnReserve);
        btnReserve.setBounds(1330, 660, 130, 30);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Hotel Rooms for 0 Day Stay");
        pnlMain.add(lblTitle);
        lblTitle.setBounds(0, 106, 1530, 40);

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
        lblName.setBounds(0, 40, 1530, 16);

        pnlMain.add(pnlHead);
        pnlHead.setBounds(0, 0, 1540, 80);

        getContentPane().add(pnlMain);
        pnlMain.setBounds(-4, 0, 1540, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGetTotalCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetTotalCostActionPerformed
        hotelCost = updateTotalCost();
        // Display the totalCost variable
        lblCost.setText(Float.toString(hotelCost));

        if (hotelCost > 0) {
            btnReserve.setVisible(true);
        } else {
            // Display a message using JOptionPane when no room is selected
            JOptionPane.showMessageDialog(null, "You have not selected any room.", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnGetTotalCostActionPerformed

    private void btnReserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReserveActionPerformed
        if (meals) {
            HotelMealsUI hotelMeals = new HotelMealsUI(departureAirport, arrivalAirport, departureDate, returnDate, numPassengers, travelClass, oneWay, departureFlightPrice, returnFlightPrice, departureTime, arrivalTime, rDepartureTime, rArrivalTime, depFlightID, retFlightID, checkInDate, checkOutDate, meals, Float.parseFloat(lblCost.getText()), calculateNumberOfDays(checkInDate, checkOutDate));
            hotelMeals.setVisible(true);
            this.dispose();
        } else {
            HotelBookingUI hotelBooking = new HotelBookingUI(departureAirport, arrivalAirport, departureDate, returnDate, numPassengers, travelClass, oneWay, departureFlightPrice, returnFlightPrice, departureTime, arrivalTime, rDepartureTime, rArrivalTime, depFlightID, retFlightID, checkInDate, checkOutDate, meals, Float.parseFloat(lblCost.getText()), calculateNumberOfDays(checkInDate, checkOutDate), 0);
            hotelBooking.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnReserveActionPerformed

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
            java.util.logging.Logger.getLogger(HotelListingUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HotelListingUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HotelListingUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HotelListingUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HotelListingUI().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(HotelListingUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGetTotalCost;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnReserve;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCentral;
    private javax.swing.JLabel lblCost;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalCost;
    private javax.swing.JLabel lblTravel;
    private javax.swing.JPanel pnlHead;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JTable tblRooms;
    // End of variables declaration//GEN-END:variables

}
