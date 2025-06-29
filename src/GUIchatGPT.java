import javax.swing.*;
import java.awt.*;

public class GUIchatGPT extends JFrame {

    private JTextField yearField;
    private JButton loadButton;
    private JComboBox<String> monthComboBox;
    private JPanel calendarPanel;

    private Year currentYear;
    private int selectedMonthIndex = 0; // 0 = January

    public GUIchatGPT() {
        setTitle("Kalendarz");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        yearField = new JTextField(5);
        loadButton = new JButton("Załaduj");
        topPanel.add(new JLabel("Rok:"));
        topPanel.add(yearField);
        topPanel.add(loadButton);

        add(topPanel, BorderLayout.NORTH);

        // Miesiące
        String[] months = {
                "Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec",
                "Lipiec", "Sierpień", "Wrzesień", "Październik", "Listopad", "Grudzień"
        };
        monthComboBox = new JComboBox<>(months);
        monthComboBox.setSelectedIndex(0);

        JPanel monthPanel = new JPanel();
        monthPanel.add(monthComboBox);
        add(monthPanel, BorderLayout.CENTER);

        // Panel na kalendarz
        calendarPanel = new JPanel();
        calendarPanel.setLayout(new GridLayout(0, 7)); // 7 kolumn (dni tygodnia)
        add(calendarPanel, BorderLayout.SOUTH);

        // Obsługa zdarzeń
        loadButton.addActionListener(e -> loadYear());
        monthComboBox.addActionListener(e -> {
            selectedMonthIndex = monthComboBox.getSelectedIndex();
            displayMonth();
        });

        setVisible(true);
    }

    private void loadYear() {
        try {
            int yearNumber = Integer.parseInt(yearField.getText());
            currentYear = new Year(yearNumber);
            displayMonth();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Wprowadź poprawny rok.");
        }
    }

    private void displayMonth() {
        calendarPanel.removeAll();

        if (currentYear == null) return;

        Month selectedMonth = currentYear.getMonths()[selectedMonthIndex];
        Day[] days = selectedMonth.getDays();

        // Nagłówki dni tygodnia
        for (String day : new String[]{"Pn", "Wt", "Śr", "Cz", "Pt", "So", "Nd"}) {
            calendarPanel.add(new JLabel(day, SwingConstants.CENTER));
        }

        // Wstawienie pustych miejsc przed 1-szym dniem miesiąca
        int dayOfWeekOffset = dayOfWeekToIndex(days[0].getDayOfTheWeek()); // np. "Mon" → 0
        for (int i = 0; i < dayOfWeekOffset; i++) {
            calendarPanel.add(new JLabel(""));
        }

        // Dodaj dni miesiąca
        for (Day day : days) {
            JLabel label = new JLabel(String.valueOf(day.getDayOfTheMonth()), SwingConstants.CENTER);
            if (day.isToday()) {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUIchatGPT::new);
    }
}
