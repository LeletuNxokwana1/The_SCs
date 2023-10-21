/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package travelcentralflightmanagementsystem;

import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author the_scs
 */
public class SearchFlightUI extends javax.swing.JFrame {

    // Set up a model to add the airports to the departute combo box
    private DefaultComboBoxModel<String> departureComboBoxModel = new DefaultComboBoxModel<>();
    // Set up a model to add the airports to the arrival combo box
    private DefaultComboBoxModel<String> arrivalComboBoxModel = new DefaultComboBoxModel<>();

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public SearchFlightUI() {

        initComponents();
        btngrpBookingType.add(rbtnOneWay); // Add radio buttons to the group
        btngrpBookingType.add(rbtnReturn);

        // Hide the components dtchooserReturn and lblReturnDate
        dtchooserReturn.setVisible(false);
        lblReturnDate.setVisible(false);
        lblRightArrow.setVisible(false);
        lblLeftArrow.setVisible(false);
        // Disable the dtchooserReturn
        dtchooserReturn.setEnabled(false);

        cmboxFrom.setModel(departureComboBoxModel);

        populateCmbDeparture();

        // Set the arrivalComboBoxModel as the model for cmbArrival
        cmboxDestination.setModel(arrivalComboBoxModel);
        
        if (!SessionManager.isLoggedIn()) {
            lblName.setVisible(false);
            btnLogOut.setVisible(false);
            btnHotelBooking.setVisible(false);
        } else {
            lblName.setText(SessionManager.getLoggedInUsername());
            btnLogin.setVisible(false);
            btnSignUp.setVisible(false);
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

        btngrpBookingType = new javax.swing.ButtonGroup();
        pnlMain = new javax.swing.JPanel();
        pnlDetails = new javax.swing.JPanel();
        lblDepartureAirport = new javax.swing.JLabel();
        lblArrivalAirport = new javax.swing.JLabel();
        lblDepartureDate = new javax.swing.JLabel();
        lblReturnDate = new javax.swing.JLabel();
        lblNumPassengers = new javax.swing.JLabel();
        lblClass = new javax.swing.JLabel();
        cmbClass = new javax.swing.JComboBox<>();
        cmboxFrom = new javax.swing.JComboBox<>();
        cmboxDestination = new javax.swing.JComboBox<>();
        lblRightArrow = new javax.swing.JLabel();
        lblLeftArrow = new javax.swing.JLabel();
        rbtnOneWay = new javax.swing.JRadioButton();
        rbtnReturn = new javax.swing.JRadioButton();
        dtchooserDeparture = new com.toedter.calendar.JDateChooser();
        dtchooserReturn = new com.toedter.calendar.JDateChooser();
        spnNumPassengers = new javax.swing.JSpinner();
        btnSearchFilghts = new javax.swing.JButton();
        lblRightArrow1 = new javax.swing.JLabel();
        lblTCFlights = new javax.swing.JLabel();
        lblMain = new javax.swing.JLabel();
        pnlHead = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JButton();
        lblTravel = new javax.swing.JLabel();
        lblCentral = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        btnHotelBooking = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Travel Central Flight Management System");

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain.setLayout(null);

        pnlDetails.setBackground(new java.awt.Color(255, 255, 255));
        pnlDetails.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        pnlDetails.setMaximumSize(new java.awt.Dimension(32769, 32769));
        pnlDetails.setLayout(null);

        lblDepartureAirport.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDepartureAirport.setText("Departure Airport");
        pnlDetails.add(lblDepartureAirport);
        lblDepartureAirport.setBounds(20, 80, 150, 25);

        lblArrivalAirport.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblArrivalAirport.setText("Arrival Airport");
        pnlDetails.add(lblArrivalAirport);
        lblArrivalAirport.setBounds(380, 80, 140, 25);

        lblDepartureDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDepartureDate.setText("Departure Date");
        pnlDetails.add(lblDepartureDate);
        lblDepartureDate.setBounds(20, 170, 140, 25);

        lblReturnDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblReturnDate.setText("Return Date");
        pnlDetails.add(lblReturnDate);
        lblReturnDate.setBounds(380, 170, 110, 25);

        lblNumPassengers.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNumPassengers.setText("Passengers");
        pnlDetails.add(lblNumPassengers);
        lblNumPassengers.setBounds(780, 80, 100, 25);

        lblClass.setBackground(new java.awt.Color(255, 255, 255));
        lblClass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblClass.setText("Class");
        pnlDetails.add(lblClass);
        lblClass.setBounds(930, 80, 60, 25);

        cmbClass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economy", "Business", "First" }));
        cmbClass.setPreferredSize(new java.awt.Dimension(99, 39));
        cmbClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClassActionPerformed(evt);
            }
        });
        pnlDetails.add(cmbClass);
        cmbClass.setBounds(930, 110, 207, 39);

        cmboxFrom.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmboxFrom.setMaximumRowCount(30);
        cmboxFrom.setAutoscrolls(true);
        cmboxFrom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmboxFromItemStateChanged(evt);
            }
        });
        cmboxFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboxFromActionPerformed(evt);
            }
        });
        pnlDetails.add(cmboxFrom);
        cmboxFrom.setBounds(20, 110, 300, 37);

        cmboxDestination.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmboxDestination.setPreferredSize(new java.awt.Dimension(167, 41));
        cmboxDestination.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmboxDestinationItemStateChanged(evt);
            }
        });
        cmboxDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboxDestinationActionPerformed(evt);
            }
        });
        pnlDetails.add(cmboxDestination);
        cmboxDestination.setBounds(380, 110, 300, 35);

        lblRightArrow.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblRightArrow.setText("-->");
        pnlDetails.add(lblRightArrow);
        lblRightArrow.setBounds(330, 110, 37, 20);

        lblLeftArrow.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblLeftArrow.setText("<--");
        pnlDetails.add(lblLeftArrow);
        lblLeftArrow.setBounds(330, 130, 37, 20);

        rbtnOneWay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rbtnOneWay.setSelected(true);
        rbtnOneWay.setText("One-Way");
        rbtnOneWay.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtnOneWayItemStateChanged(evt);
            }
        });
        rbtnOneWay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnOneWayActionPerformed(evt);
            }
        });
        pnlDetails.add(rbtnOneWay);
        rbtnOneWay.setBounds(20, 10, 127, 30);

        rbtnReturn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rbtnReturn.setText("Return");
        rbtnReturn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtnReturnItemStateChanged(evt);
            }
        });
        rbtnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnReturnActionPerformed(evt);
            }
        });
        pnlDetails.add(rbtnReturn);
        rbtnReturn.setBounds(20, 40, 98, 30);

        dtchooserDeparture.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dtchooserDeparture.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dtchooserDeparturePropertyChange(evt);
            }
        });
        pnlDetails.add(dtchooserDeparture);
        dtchooserDeparture.setBounds(20, 200, 300, 31);

        dtchooserReturn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dtchooserReturn.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dtchooserReturnPropertyChange(evt);
            }
        });
        pnlDetails.add(dtchooserReturn);
        dtchooserReturn.setBounds(380, 200, 300, 31);

        spnNumPassengers.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        spnNumPassengers.setValue(1);
        spnNumPassengers.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnNumPassengersStateChanged(evt);
            }
        });
        pnlDetails.add(spnNumPassengers);
        spnNumPassengers.setBounds(780, 110, 77, 31);

        btnSearchFilghts.setBackground(new java.awt.Color(0, 0, 0));
        btnSearchFilghts.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSearchFilghts.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchFilghts.setText("Search Flights");
        btnSearchFilghts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchFilghtsActionPerformed(evt);
            }
        });
        pnlDetails.add(btnSearchFilghts);
        btnSearchFilghts.setBounds(790, 200, 265, 37);

        lblRightArrow1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblRightArrow1.setText("-->");
        pnlDetails.add(lblRightArrow1);
        lblRightArrow1.setBounds(330, 120, 37, 20);

        pnlMain.add(pnlDetails);
        pnlDetails.setBounds(184, 188, 1180, 280);

        lblTCFlights.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTCFlights.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTCFlights.setText("Travel Central Flights");
        pnlMain.add(lblTCFlights);
        lblTCFlights.setBounds(580, 110, 400, 60);
        pnlMain.add(lblMain);
        lblMain.setBounds(0, 80, 1530, 730);

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

        btnLogin.setBackground(new java.awt.Color(0, 0, 0));
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.setBorder(null);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnlHead.add(btnLogin);
        btnLogin.setBounds(1350, 30, 80, 30);

        btnSignUp.setBackground(new java.awt.Color(0, 0, 0));
        btnSignUp.setForeground(new java.awt.Color(255, 255, 255));
        btnSignUp.setText("Sign Up");
        btnSignUp.setBorder(null);
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        pnlHead.add(btnSignUp);
        btnSignUp.setBounds(1190, 30, 80, 30);

        btnHotelBooking.setBackground(new java.awt.Color(0, 0, 0));
        btnHotelBooking.setForeground(new java.awt.Color(255, 255, 255));
        btnHotelBooking.setText("Hotel Room");
        btnHotelBooking.setBorder(null);
        btnHotelBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHotelBookingActionPerformed(evt);
            }
        });
        pnlHead.add(btnHotelBooking);
        btnHotelBooking.setBounds(1270, 30, 80, 30);

        pnlMain.add(pnlHead);
        pnlHead.setBounds(0, 0, 1536, 80);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, 1524, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void cmboxFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboxFromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboxFromActionPerformed

    private void cmboxDestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboxDestinationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboxDestinationActionPerformed

    private void cmbClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbClassActionPerformed

    private void rbtnOneWayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnOneWayActionPerformed
        // Clear the selection from the "Return" radio button
        rbtnReturn.setSelected(false);

        // Check if "One Way" radio button is selected
        if (rbtnOneWay.isSelected()) {
            // Hide the components for return
            dtchooserReturn.setVisible(false);
            lblReturnDate.setVisible(false);
            dtchooserReturn.setDate(null);
            lblRightArrow.setVisible(false);
            lblLeftArrow.setVisible(false);
            lblRightArrow1.setVisible(true);

        }
    }//GEN-LAST:event_rbtnOneWayActionPerformed

    private void spnNumPassengersStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnNumPassengersStateChanged
        int value = (int) spnNumPassengers.getValue();
        if (value < 1) {
            spnNumPassengers.setValue(1);
        }
    }//GEN-LAST:event_spnNumPassengersStateChanged

    private void rbtnOneWayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtnOneWayItemStateChanged

    }//GEN-LAST:event_rbtnOneWayItemStateChanged

    private void rbtnReturnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtnReturnItemStateChanged

    }//GEN-LAST:event_rbtnReturnItemStateChanged

    private void dtchooserDeparturePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dtchooserDeparturePropertyChange
        if ("date".equals(evt.getPropertyName())) {
            // Get the selected date from the date chooser
            Date selectedDate = (Date) evt.getNewValue();

            String departureDate = dateFormat.format(dtchooserDeparture.getDate());
            System.out.println(" " + departureDate);
            // Check if the selected departure date is null
            if (selectedDate == null) {
                // If departure date is null, disable the dtchooserReturn
                dtchooserReturn.setEnabled(false);
            } else {
                // If departure date is not null, enable the dtchooserReturn
                dtchooserReturn.setEnabled(true);
            }

            if (selectedDate != null) {
                // Create a calendar instance and set it to the current date
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());

                // Create a calendar instance for the date 6 months from now
                Calendar sixMonthsFromNowCalendar = Calendar.getInstance();
                sixMonthsFromNowCalendar.setTime(new Date());
                sixMonthsFromNowCalendar.add(Calendar.MONTH, 6);

                // Check if the selected date is within the allowed range
                if (selectedDate.before(calendar.getTime()) || selectedDate.after(sixMonthsFromNowCalendar.getTime())) {
                    // If the selected date is outside the allowed range, reset the date chooser
                    dtchooserDeparture.setDate(null);
                }
            }
        }
    }//GEN-LAST:event_dtchooserDeparturePropertyChange

    private void rbtnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnReturnActionPerformed
        // Clear the selection from the "OneWay" radio button
        rbtnOneWay.setSelected(false);

        // Check if "Return" radio button is selected
        if (rbtnReturn.isSelected()) {
            // Show the components for return
            dtchooserReturn.setVisible(true);
            lblReturnDate.setVisible(true);
            lblRightArrow.setVisible(true);
            lblLeftArrow.setVisible(true);
            lblRightArrow1.setVisible(false);
        } else {
            // Hide the components for return
            dtchooserReturn.setVisible(false);
            lblReturnDate.setVisible(false);
            lblRightArrow.setVisible(false);
            lblLeftArrow.setVisible(false);
            lblRightArrow1.setVisible(true);
        }
    }//GEN-LAST:event_rbtnReturnActionPerformed

    private void btnSearchFilghtsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchFilghtsActionPerformed
        // Capture user input
        String in1 = cmboxFrom.getSelectedItem().toString();
        String in2 = cmboxDestination.getSelectedItem().toString();

        int index1OfOpeningBracket = in1.indexOf('(') - 1;
        String departureAirport = in1.substring(0, index1OfOpeningBracket).trim();

        int index2OfOpeningBracket = in2.indexOf('(') - 1;
        String arrivalAirport = in2.substring(0, index2OfOpeningBracket).trim();

        String departureDate = dateFormat.format(dtchooserDeparture.getDate());
        String returnDate = null; // Initialize to null
        if (rbtnReturn.isSelected()) {
            returnDate = dateFormat.format(dtchooserReturn.getDate());
        }
        int numPassengers = (int) spnNumPassengers.getValue();
        String travelClass = cmbClass.getSelectedItem().toString();
        boolean isOneWay = rbtnOneWay.isSelected();

        // Create the DepartureFlightUI frame
        DepartureFlightUI mainFrame = new DepartureFlightUI(departureAirport, arrivalAirport, departureDate, returnDate, numPassengers, travelClass, isOneWay);

        // Pass user input data to the DepartureFlightUI frame
        // Set the visibility of the DepartureFlightUI frame to true
        mainFrame.setVisible(true);

        // Set the visibility of the SearchFlightUI frame to false
        dispose();
    }//GEN-LAST:event_btnSearchFilghtsActionPerformed

    private void dtchooserReturnPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dtchooserReturnPropertyChange
        if ("date".equals(evt.getPropertyName())) {
            // Get the selected date from the dtchooserArrival
            Date selectedDateReturn = (Date) evt.getNewValue();

            // Get the selected date from the dtchooserDeparture
            Date selectedDateDeparture = dtchooserDeparture.getDate();

            // Create a calendar instance and set it to the departure date
            Calendar departureCalendar = Calendar.getInstance();
            departureCalendar.setTime(selectedDateDeparture);

            // Add 6 months to the departure date
            departureCalendar.add(Calendar.MONTH, 6);
            Date sixMonthsFromDeparture = departureCalendar.getTime();

            // Check if the selected return date is within the allowed range
            if (selectedDateReturn.before(selectedDateDeparture)
                    || selectedDateReturn.after(sixMonthsFromDeparture)) {
                // If the selected date is outside the allowed range, reset the arrival date chooser
                dtchooserReturn.setDate(null);
            }

        }
    }//GEN-LAST:event_dtchooserReturnPropertyChange

    private void cmboxFromItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmboxFromItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            // Get the selected departure airport from cmboxFrom
            String selectedDepartureAirport = cmboxFrom.getSelectedItem().toString();
            int indexOfOpeningBracket = selectedDepartureAirport.indexOf('(') - 1;
            String result = selectedDepartureAirport.substring(0, indexOfOpeningBracket).trim();

            // Call the method to populate cmboxArrival
            populateCmbArrival(result);

        }
    }//GEN-LAST:event_cmboxFromItemStateChanged

    private void cmboxDestinationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmboxDestinationItemStateChanged

    }//GEN-LAST:event_cmboxDestinationItemStateChanged

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        LoginUI mainFrame = new LoginUI();

        // Set the visibility of the SearchFlightUI frame
        mainFrame.setVisible(true);

        // Close the current frame (assuming this is in DepartureFlightUI)
        this.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        SignUpUI mainFrame = new SignUpUI();

        // Set the visibility of the SearchFlightUI frame
        mainFrame.setVisible(true);

        // Close the current frame (assuming this is in DepartureFlightUI)
        this.dispose();
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        LogOutUI logOut = new LogOutUI();
        
        logOut.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnHotelBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHotelBookingActionPerformed
        BookingViewUI bookingView = new BookingViewUI();
        bookingView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHotelBookingActionPerformed

    // Method to populate the combo box with airport names
    private void populateCmbDeparture() {
        ProgramManager programManager = new ProgramManager();
        // Call the retrieveAirports method to get the list of airports
        List<Airport> airports = programManager.retrieveAirports();

        // Populate the combo box with airport names
        for (Airport airport : airports) {
            departureComboBoxModel.addElement(airport.getAirportName() + " (" + airport.getAirportIATACode() + ")");
        }

        // Refresh the combo box to display the added items
        cmboxFrom.revalidate();
        cmboxFrom.repaint();
    }

    private void populateCmbArrival(String selectedDepartureAirport) {

        ProgramManager programManager = new ProgramManager();
        // Call the retrieveAirports method to get the list of airports
        List<Airport> airports = programManager.retrieveAirports();
        int cityID = programManager.retrieveCityID(selectedDepartureAirport);
        // Clear the existing items in the arrivalComboBoxModel
        arrivalComboBoxModel.removeAllElements();

        // Populate the arrivalComboBoxModel with the filtered list of arrival airports
        for (Airport airport : airports) {
            int airportCity = airport.getCityID();
            if (airportCity != cityID) {
                arrivalComboBoxModel.addElement(airport.getAirportName() + " (" + airport.getAirportIATACode() + ")");
            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchFlightUI().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHotelBooking;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSearchFilghts;
    private javax.swing.JButton btnSignUp;
    private javax.swing.ButtonGroup btngrpBookingType;
    private javax.swing.JComboBox<String> cmbClass;
    private javax.swing.JComboBox<String> cmboxDestination;
    private javax.swing.JComboBox<String> cmboxFrom;
    private com.toedter.calendar.JDateChooser dtchooserDeparture;
    private com.toedter.calendar.JDateChooser dtchooserReturn;
    private javax.swing.JLabel lblArrivalAirport;
    private javax.swing.JLabel lblCentral;
    private javax.swing.JLabel lblClass;
    private javax.swing.JLabel lblDepartureAirport;
    private javax.swing.JLabel lblDepartureDate;
    private javax.swing.JLabel lblLeftArrow;
    private javax.swing.JLabel lblMain;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNumPassengers;
    private javax.swing.JLabel lblReturnDate;
    private javax.swing.JLabel lblRightArrow;
    private javax.swing.JLabel lblRightArrow1;
    private javax.swing.JLabel lblTCFlights;
    private javax.swing.JLabel lblTravel;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JPanel pnlHead;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JRadioButton rbtnOneWay;
    private javax.swing.JRadioButton rbtnReturn;
    private javax.swing.JSpinner spnNumPassengers;
    // End of variables declaration//GEN-END:variables
}
