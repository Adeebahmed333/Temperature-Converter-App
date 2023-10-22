/*
 ******************************
* Code Written By: Adeeb Ahmed *
* Associated with INTERNSAVY   *
 ******************************
*/
import javax.swing.*;
import java.awt.*;

public class TemperatureConverter extends JFrame {
    private final JTextField temperatureField;
    private final JLabel resultLabel;

    public TemperatureConverter() {
        // Set up the frame
        super("Temperature Converter");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create components
        JPanel inputPanel = new JPanel();
        JLabel temperatureLabel = new JLabel("Temperature: ");
        temperatureField = new JTextField(10);
        inputPanel.add(temperatureLabel);
        inputPanel.add(temperatureField);

        JPanel buttonPanel = new JPanel();
        JButton fahrenheitToCelsiusButton = new JButton("F to C");
        JButton celsiusToFahrenheitButton = new JButton("C to F");
        buttonPanel.add(fahrenheitToCelsiusButton);
        buttonPanel.add(celsiusToFahrenheitButton);

        JPanel resultPanel = new JPanel();
        resultLabel = new JLabel("Result: ");
        resultPanel.add(resultLabel);

        // Add panels to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);

        // Add lambda expressions as ActionListeners to the buttons
        fahrenheitToCelsiusButton.addActionListener(e -> convertFahrenheitToCelsius());
        celsiusToFahrenheitButton.addActionListener(e -> convertCelsiusToFahrenheit());
    }

    private void convertFahrenheitToCelsius() {
        try {
            double fahrenheit = Double.parseDouble(temperatureField.getText());
            double celsius = (fahrenheit - 32) * 5/9;
            resultLabel.setText("Celsius: " + String.format("%.2f", celsius) + "°C");
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input");
        }
    }

    private void convertCelsiusToFahrenheit() {
        try {
            double celsius = Double.parseDouble(temperatureField.getText());
            double fahrenheit = (celsius * 9/5) + 32;
            resultLabel.setText("Fahrenheit: " + String.format("%.2f", fahrenheit) + "°F");
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TemperatureConverter().setVisible(true));
    }
}
