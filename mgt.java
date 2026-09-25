import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mgt extends JFrame implements ActionListener {

    JLabel lblCustomer, lblFood, lblQuantity, lblPrice;
    JTextField txtCustomer, txtFood, txtQuantity, txtPrice;
    JButton btnOrder, btnClear;
    JTextArea result;

    public mgt() {

        setTitle("Online Food Management System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Customer Name
        lblCustomer = new JLabel("Customer Name:");
        lblCustomer.setBounds(50, 40, 120, 30);
        add(lblCustomer);

        txtCustomer = new JTextField();
        txtCustomer.setBounds(180, 40, 220, 30);
        add(txtCustomer);

        // Food Name
        lblFood = new JLabel("Food Name:");
        lblFood.setBounds(50, 90, 120, 30);
        add(lblFood);

        txtFood = new JTextField();
        txtFood.setBounds(180, 90, 220, 30);
        add(txtFood);

        // Quantity
        lblQuantity = new JLabel("Quantity:");
        lblQuantity.setBounds(50, 140, 120, 30);
        add(lblQuantity);

        txtQuantity = new JTextField();
        txtQuantity.setBounds(180, 140, 220, 30);
        add(txtQuantity);

        // Price
        lblPrice = new JLabel("Price:");
        lblPrice.setBounds(50, 190, 120, 30);
        add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(180, 190, 220, 30);
        add(txtPrice);

        // Place Order Button
        btnOrder = new JButton("Place Order");
        btnOrder.setBounds(100, 240, 120, 35);
        btnOrder.addActionListener(this);
        add(btnOrder);

        // Clear Button
        btnClear = new JButton("Clear");
        btnClear.setBounds(250, 240, 100, 35);
        btnClear.addActionListener(this);
        add(btnClear);

        // Result Area
        result = new JTextArea();
        result.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(result);
        scrollPane.setBounds(50, 300, 350, 120);
        add(scrollPane);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Place Order
        if (e.getSource() == btnOrder) {

            try {
                String customer = txtCustomer.getText().trim();
                String food = txtFood.getText().trim();

                int quantity = Integer.parseInt(txtQuantity.getText().trim());
                double price = Double.parseDouble(txtPrice.getText().trim());

                // Validate input
                if (customer.isEmpty() || food.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Please enter customer name and food name!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                if (quantity <= 0 || price < 0) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Quantity must be greater than 0 and price cannot be negative!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                double total = quantity * price;

                result.setText(
                    "========== ORDER DETAILS ==========\n\n"
                    + "Customer Name : " + customer + "\n"
                    + "Food Name     : " + food + "\n"
                    + "Quantity      : " + quantity + "\n"
                    + "Price         : Rs." + String.format("%.2f", price) + "\n"
                    + "Total Amount  : Rs." + String.format("%.2f", total) + "\n\n"
                    + "Order Status  : Order Placed"
                );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numbers for Quantity and Price!",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }

        // Clear
        if (e.getSource() == btnClear) {

            txtCustomer.setText("");
            txtFood.setText("");
            txtQuantity.setText("");
            txtPrice.setText("");
            result.setText("");
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new mgt();
        });
    }
}
