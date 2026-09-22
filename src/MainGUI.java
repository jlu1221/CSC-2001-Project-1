import javax.swing.*;
import java.awt.*;
import java.time.temporal.Temporal;
import java.util.List;
public class MainGUI extends JFrame {
    private JTextField idField;
    private JTextField titleField;
    private JTextField mentorField;
    private JTextField departmentField;
    private JTextField dateField;
    private JTextField timeField;
    private JTextField locationField;
    private JTextField maxField;
    private JTextArea outputArea;

    // instance variable
    private MyLinkedList list;

    public MainGUI() {

        // new LinkedList
        list = new MyLinkedList();
        setTitle("Employee Mentorship and Inclusion Manager");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        createGUI();
        setVisible(true);
    }
    // DO NOT CHANGE THIS METHOD!
    // This method creates your GUI of the layout
    private void createGUI() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(8,2,5,5));
        idField = new JTextField();
        titleField = new JTextField();
        mentorField = new JTextField();
        departmentField = new JTextField();
        dateField = new JTextField();
        timeField = new JTextField();
        locationField = new JTextField();
        maxField = new JTextField();
        inputPanel.add(new JLabel("Session ID"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Title"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Mentor"));
        inputPanel.add(mentorField);
        inputPanel.add(new JLabel("Department"));
        inputPanel.add(departmentField);
        inputPanel.add(new JLabel("Date"));
        inputPanel.add(dateField);
        inputPanel.add(new JLabel("Time"));
        inputPanel.add(timeField);
        inputPanel.add(new JLabel("Location"));
        inputPanel.add(locationField);
        inputPanel.add(new JLabel("Max Participants"));
        inputPanel.add(maxField);
        add(inputPanel, BorderLayout.NORTH);
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(outputArea);
        add(scroll, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Session");
        JButton displayButton = new JButton("Display");
        JButton searchButton = new JButton("Search");
        JButton removeButton = new JButton("Remove");
        JButton registerButton = new JButton("Register");
        JButton exitButton = new JButton("Exit");
        // add Buttons
        buttonPanel.add(addButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(registerButton);
        buttonPanel.add(exitButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button Actions:
        // Clicking each button in the layout will invoke its corresponding functionality.
        addButton.addActionListener(e -> addSession());
        displayButton.addActionListener(e -> displaySessions());
        searchButton.addActionListener(e -> searchSession());
        removeButton.addActionListener(e -> removeSession());
        registerButton.addActionListener(e -> registerParticipant());
        exitButton.addActionListener(e -> System.exit(0));
    }
    // DO NOT CHANGE THIS METHOD!
    // It clears all fields in the layout
    private void clearFields() {
        idField.setText("");
        titleField.setText("");
        mentorField.setText("");
        departmentField.setText("");
        dateField.setText("");
        timeField.setText("");
        locationField.setText("");
        maxField.setText("");
        // Put the cursor back in the first field
        idField.requestFocus();
    }
    // Add a Session in the correct location first, last, or after based on sessionID
    private void addSession() {
        try {
            int id = Integer.parseInt(idField.getText());
            int max = Integer.parseInt(maxField.getText());

            String topic = titleField.getText();
            String mentor = mentorField.getText();
            String department = departmentField.getText();
            String date = dateField.getText();
            String time = timeField.getText();
            String location = locationField.getText();

            Session session = new Session(
                    id,
                    topic,
                    mentor,
                    department,
                    date,
                    time,
                    location,
                    max
            );

            if (list.display().isEmpty()) {
                list.addFirst(session);
            } else if (id < 200) {
                list.addFirst(session);
            } else if (id < 500) {
                list.insertAfter(session);
            } else {
                list.addLast(session);
            }

            outputArea.setText("Session Added Successfully");
            clearFields();

        } catch (Exception e) {
            outputArea.setText("Invalid input");
        }
    }
    
    // Display the information in the outputArea in GUI
    private void displaySessions() {
        outputArea.setText(list.display());

    }

    // Search based on sessionID or mentor if the fields are not empty
    private void searchSession() {
        String idText = idField.getText();
        String mentor = mentorField.getText();

        if (!idText.isEmpty()) {
            try {
                int id = Integer.parseInt(idText);
                outputArea.setText(list.searchByID(id));
            } catch (Exception e) {
                outputArea.setText("Session not found");
            }

        } else if (!mentor.isEmpty()) {
            outputArea.setText(list.searchByMentor(mentor));

        } else {
            outputArea.setText("Please enter a Session ID or Mentor name");
        }
    }
    
    // delete the session
    private void removeSession() {
        try {
            int id = Integer.parseInt(idField.getText());

            Session session = list.getSessionByID(id);

            if (session == null) {
                outputArea.setText("Session not found");
            } else {
                outputArea.setText(list.remove(session));
            }

        } catch (Exception e) {
            outputArea.setText("Session not found");
        }
    }

    // registerParticipants call the method in the LinkedList
    private void registerParticipant() {
        try {
            int id = Integer.parseInt(idField.getText());

            Session session = list.getSessionByID(id);

            if (session == null) {
                outputArea.setText("Registration failed");
                return;
            }

            boolean registered = list.registerParticipant(session);

            if (registered) {
                outputArea.setText("Participant registered");
            } else {
                outputArea.setText("Registration failed");
            }

        } catch (Exception e) {
            outputArea.setText("Registration failed");
        }
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}
