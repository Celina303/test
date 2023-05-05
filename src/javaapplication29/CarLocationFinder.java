/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication29;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class CarLocationFinder extends JFrame implements ActionListener {

    private JTextField licensePlateField;
    private JTextArea locationResultArea;

    private HashMap<String, CarLocation> carLocations;

    public CarLocationFinder() {
        super("Car Location Finder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        carLocations = new HashMap<String, CarLocation>();

        // add some sample car locations to the hashmap
        carLocations.put("ABC-123", new CarLocation(10.768124, 106.691643));
        carLocations.put("DEF-456", new CarLocation(10.765043, 106.685452));
        carLocations.put("GHI-789", new CarLocation(10.766976, 106.691144));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));

        JLabel licensePlateLabel = new JLabel("License Plate:");
        licensePlateField = new JTextField();
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(this);

        inputPanel.add(licensePlateLabel);
        inputPanel.add(licensePlateField);
        inputPanel.add(new JLabel());
        inputPanel.add(searchButton);

        locationResultArea = new JTextArea();
        locationResultArea.setEditable(false);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(locationResultArea, BorderLayout.CENTER);

        getContentPane().add(mainPanel);
    }

    public void actionPerformed(ActionEvent e) {
        String licensePlate = licensePlateField.getText();
        if (licensePlate.isEmpty()) {
            locationResultArea.setText("Please enter a license plate.");
            return;
        }

        CarLocation location = carLocations.get(licensePlate);
        if (location == null) {
            locationResultArea.setText("Car with license plate " + licensePlate + " not found.");
        } else {
            locationResultArea.setText("Car with license plate " + licensePlate + " is at " + location.getLatitude() + "," + location.getLongitude());
        }
    }

    public static void main(String[] args) {
        CarLocationFinder finder = new CarLocationFinder();
        finder.setVisible(true);
    }
}

class CarLocation {
    private double latitude;
    private double longitude;

    public CarLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
