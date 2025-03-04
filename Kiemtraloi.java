import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue; 
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kiemtraloi {

    private JFrame frame; 
    private JTextField coefficientAField;
    private JTextField coefficientBField;
    private JButton solveButton;
    private JLabel resultLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Kiemtraloi window = new Kiemtraloi(); 
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(); 
                }
            }
        });
    }

    public Kiemtraloi() {
        
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel labelA = new JLabel("Hệ số a:");
        labelA.setBounds(27, 50, 80, 25);
        frame.getContentPane().add(labelA);

        coefficientAField = new JTextField();
        coefficientAField.setBounds(117, 50, 150, 25);
        frame.getContentPane().add(coefficientAField);
        coefficientAField.setColumns(10);

        JLabel labelB = new JLabel("Hệ số b:");
        labelB.setBounds(62, 100, 80, 25);
        frame.getContentPane().add(labelB);

        coefficientBField = new JTextField();
        coefficientBField.setBounds(148, 100, 150, 25);
        frame.getContentPane().add(coefficientBField);
        coefficientBField.setColumns(10);

        solveButton = new JButton("Giải");
        solveButton.setBounds(187, 165, 80, 25);
        frame.getContentPane().add(solveButton);

        resultLabel = new JLabel("");
        resultLabel.setBounds(50, 200, 350, 25);
        frame.getContentPane().add(resultLabel);

        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solveEquation(); 
            }
        });

        frame.setTitle("Giải Phương Trình Bậc 1");
    }

    private void solveEquation() {
        double a;
        double b;
        try {
            a = Double.parseDouble(coefficientAField.getText());
            b = Double.parseDouble(coefficientBField.getText());
        } catch (Exception e) {
            resultLabel.setText("?"); 
            return;
        }

        if (a == 0) {
            if (b == 0) {
                resultLabel.setText("Vô số nghiệm"); 
            } else {
                resultLabel.setText("Vô nghiệm"); 
            }
        } else {
            double x = -b / a; // Không kiểm tra chia 0
            resultLabel.setText("Kết quả:" + x); 
        }
    }
}
