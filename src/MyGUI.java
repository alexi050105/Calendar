import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MyGUI extends JFrame {

    private JTextField yearField;
    private JButton loadButton;
    private JComboBox<String> monthBox;
    private JPanel calendarPanel;

    private Year currentYear;
    private Integer monthIndex = 0;

    public MyGUI(){
        setTitle("Calendar");
        setSize(600, 225);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        yearField = new JTextField(5);
        loadButton = new JButton("Load");
        topPanel.add(new JLabel("Year: "));
        topPanel.add(yearField);
        topPanel.add(loadButton);

        add(topPanel, BorderLayout.NORTH);

        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        monthBox = new JComboBox<>(months);
        monthBox.setSelectedIndex(0);

        JPanel monthPanel = new JPanel();
        monthPanel.add(monthBox);
        add(monthPanel, BorderLayout.CENTER);

        calendarPanel = new JPanel();
        calendarPanel.setLayout(new GridLayout(0, 7));
        add(calendarPanel, BorderLayout.SOUTH);


        loadButton.addActionListener(e -> loadYear());
        monthBox.addActionListener(e -> {
            monthIndex = monthBox.getSelectedIndex();
            displayMonth();
        });

        setVisible(true);
    }

    private void loadYear(){
        try {
            int year = Integer.parseInt(yearField.getText());
            currentYear = new Year(year);
            displayMonth();
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Invalid year");
        }
    }

    private void displayMonth(){
        calendarPanel.removeAll();

        if(currentYear == null) return;

        Month selectedMonth = currentYear.getMonths()[monthIndex];
        Day[] days = selectedMonth.getDays();

        for(String day : new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"}){
            calendarPanel.add(new JLabel(day, SwingConstants.CENTER));
        }

        int dayOfWeekOffset = dayOfWeekToIndex(days[0].getDayOfTheWeek());
        for (int i = 0; i < dayOfWeekOffset; i++){
            calendarPanel.add(new JLabel(""));
        }

        for(Day day : days){
            JLabel label = new JLabel(String.valueOf(day.getDayOfTheMonth()), SwingConstants.CENTER);

            if(Objects.equals(day.getDayOfTheWeek(), "Sat") || Objects.equals(day.getDayOfTheWeek(), "Sun")){
                label.setForeground(Color.GREEN);
            }

            if(day.isToday()){
                label.setForeground(Color.RED);
            }
            calendarPanel.add(label);
        }

        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    private int dayOfWeekToIndex(String day) {
        return switch (day) {
            case "Mon" -> 0;
            case "Tue" -> 1;
            case "Wed" -> 2;
            case "Thu" -> 3;
            case "Fri" -> 4;
            case "Sat" -> 5;
            case "Sun" -> 6;
            default -> 0;
        };
    }
}























