package cab;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Driver {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Driver().createGUI());
    }

    void createGUI() {
        // Load background image
        Image backgroundImage = new ImageIcon("C://Users//raksh//OneDrive//Attachments//Desktop//CabBooking//src//pngtree-yellow-taxi-sign-in-3d-with-map-pointer-a-digital-solution-image_3650811.jpg").getImage();

        BackgroundPanel bgPanel = new BackgroundPanel(backgroundImage);
        bgPanel.setLayout(null);
        bgPanel.setPreferredSize(new Dimension(900, 750));

        JFrame frame = new JFrame("Cab Booking Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(bgPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);

        // Larger fonts
        Font titleFont = new Font("Arial", Font.BOLD, 32);
        Font labelFont = new Font("Arial", Font.BOLD, 20);
        Font radioFont = new Font("Arial", Font.PLAIN, 20);
        Font comboFont = new Font("Arial", Font.PLAIN, 18);
        Font buttonFont = new Font("Arial", Font.BOLD, 22);
        Font outputFont = new Font("Monospaced", Font.PLAIN, 18);

        // Title Label
        JLabel title = new JLabel("Select Your Ride");
        title.setFont(titleFont);
        title.setForeground(Color.WHITE);
        title.setBounds(300, 20, 400, 40);
        bgPanel.add(title);

        // Radio buttons
        JRadioButton bikeBtn = new JRadioButton("Bike");
        JRadioButton autoBtn = new JRadioButton("AutoRickshaw");
        JRadioButton carBtn = new JRadioButton("Car");

        bikeBtn.setBounds(100, 80, 200, 40);
        autoBtn.setBounds(100, 130, 200, 40);
        carBtn.setBounds(100, 180, 200, 40);

        bikeBtn.setOpaque(false);
        bikeBtn.setForeground(Color.WHITE);
        bikeBtn.setFont(radioFont);
        autoBtn.setOpaque(false);
        autoBtn.setForeground(Color.WHITE);
        autoBtn.setFont(radioFont);
        carBtn.setOpaque(false);
        carBtn.setForeground(Color.WHITE);
        carBtn.setFont(radioFont);

        ButtonGroup bg = new ButtonGroup();
        bg.add(bikeBtn);
        bg.add(autoBtn);
        bg.add(carBtn);

        bgPanel.add(bikeBtn);
        bgPanel.add(autoBtn);
        bgPanel.add(carBtn);

        // Car type dropdown
        JLabel carTypeLabel = new JLabel("Select Car Type:");
        carTypeLabel.setForeground(Color.WHITE);
        carTypeLabel.setFont(labelFont);
        carTypeLabel.setBounds(300, 180, 200, 40);

        String[] carTypes = {"Mini", "Sedan", "Luxury"};
        JComboBox<String> carTypeBox = new JComboBox<>(carTypes);
        carTypeBox.setBounds(500, 180, 180, 40);
        carTypeBox.setFont(comboFont);

        carTypeLabel.setVisible(false);
        carTypeBox.setVisible(false);

        bgPanel.add(carTypeLabel);
        bgPanel.add(carTypeBox);

        carBtn.addActionListener(e -> {
            carTypeLabel.setVisible(true);
            carTypeBox.setVisible(true);
        });

        bikeBtn.addActionListener(e -> {
            carTypeLabel.setVisible(false);
            carTypeBox.setVisible(false);
        });

        autoBtn.addActionListener(e -> {
            carTypeLabel.setVisible(false);
            carTypeBox.setVisible(false);
        });

        // Distance input
        JLabel distanceLabel = new JLabel("Enter distance (km):");
        distanceLabel.setForeground(Color.WHITE);
        distanceLabel.setFont(labelFont);
        distanceLabel.setBounds(100, 240, 250, 40);
        JTextField distanceField = new JTextField();
        distanceField.setBounds(350, 240, 180, 40);
        distanceField.setFont(labelFont);

        bgPanel.add(distanceLabel);
        bgPanel.add(distanceField);

        // Buttons
        JButton bookButton = new JButton("Book Ride");
        bookButton.setBounds(150, 300, 180, 50);
        bookButton.setFont(buttonFont);
        bgPanel.add(bookButton);

        JButton cancelButton = new JButton("Cancel Ride");
        cancelButton.setBounds(400, 300, 180, 50);
        cancelButton.setFont(buttonFont);
        bgPanel.add(cancelButton);

        // Output text area with scroll
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(outputFont);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(100, 370, 700, 320);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        bgPanel.add(scrollPane);

        // Book button logic
        bookButton.addActionListener(e -> {
            try {
                int distance = Integer.parseInt(distanceField.getText());
                outputArea.setText("");

                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDateTime = now.format(formatter);
                outputArea.append("Ride Booked At: " + formattedDateTime + "\n");

                if (bikeBtn.isSelected()) {
                    Bike b = new Bike("John", "9964835192", "KA-07-51CC", 15, "Hornet 160R");
                    outputArea.append("Your Ride is booked\n");
                    outputArea.append(b.DisplayDetails(distance));
                } else if (autoBtn.isSelected()) {
                    AutoRikshaw a = new AutoRikshaw("Harry", "9912345678", "KA-05_AC3825", 10, "Bajaj Compact");
                    outputArea.append("Your Ride is booked\n");
                    outputArea.append(a.DisplayDetails(distance));
                } else if (carBtn.isSelected()) {
                    String selected = (String) carTypeBox.getSelectedItem();
                    switch (selected) {
                        case "Mini":
                            Mini m = new Mini("Steve", "9923134453", "KA 04 MA 3402", 12, "Maruti Suzuki", "Petrol", 4);
                            outputArea.append("Your Ride is booked\n");
                            outputArea.append(m.DisplayDetails(distance));
                            break;
                        case "Sedan":
                            Sedan s = new Sedan("Brook", "6123456789", "KA 09 AP 3454", 18, "Toyota", "Petrol", 4);
                            outputArea.append("Your Ride is booked\n");
                            outputArea.append(s.DisplayDetails(distance));
                            break;
                        case "Luxury":
                            Luxury l = new Luxury("Smith", "6633224455", "KA 09 AP 3454", 25, "Toyota", "Diesel", 8);
                            outputArea.append("Your Ride is booked\n");
                            outputArea.append(l.DisplayDetails(distance));
                            break;
                    }
                } else {
                    outputArea.setText("Please select a ride type.");
                }
            } catch (NumberFormatException ex) {
                outputArea.setText("Please enter a valid distance.");
            }
        });

        cancelButton.addActionListener(e -> {
            bg.clearSelection();
            carTypeBox.setSelectedIndex(0);
            carTypeBox.setVisible(false);
            carTypeLabel.setVisible(false);
            distanceField.setText("");
            outputArea.setText("Your ride has been cancelled.");
        });

        frame.setVisible(true);
    }

    // Custom JPanel to paint background image
    class BackgroundPanel extends JPanel {
        private final Image bgImage;

        public BackgroundPanel(Image image) {
            this.bgImage = image;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
