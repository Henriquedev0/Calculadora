import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    int c, n;
    String s1, s2;
    Frame f;
    Button[] numButtons;
    Button badd, bsub, bmul, bdiv, beq, bclr;
    Panel p;
    TextField t1;
    GridLayout g;

    Calculator() {
        f = new Frame("Calculadora");
        f.setLayout(new BorderLayout());
        p = new Panel();
        g = new GridLayout(4, 4, 10, 10);
        p.setLayout(g);

        t1 = new TextField(10);
        t1.setEditable(false);
        t1.setFont(new Font("Arial", Font.PLAIN, 18));

        numButtons = new Button[10];
        for (int i = 9; i >= 0; i--) {
            numButtons[i] = new Button(Integer.toString(i));
            numButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            numButtons[i].addActionListener(this);
        }

        badd = new Button("+");
        badd.setFont(new Font("Arial", Font.PLAIN, 18));
        badd.addActionListener(this);

        bsub = new Button("-");
        bsub.setFont(new Font("Arial", Font.PLAIN, 18));
        bsub.addActionListener(this);

        bmul = new Button("*");
        bmul.setFont(new Font("Arial", Font.PLAIN, 18));
        bmul.addActionListener(this);

        bdiv = new Button("/");
        bdiv.setFont(new Font("Arial", Font.PLAIN, 18));
        bdiv.addActionListener(this);

        beq = new Button("=");
        beq.setFont(new Font("Arial", Font.PLAIN, 18));
        beq.addActionListener(this);

        bclr = new Button("CLR");
        bclr.setFont(new Font("Arial", Font.PLAIN, 18));
        bclr.addActionListener(this);

        // Row 1
        p.add(bclr);
        p.add(bdiv);
        p.add(bmul);
        p.add(bsub);

        // Row 2
        p.add(numButtons[7]);
        p.add(numButtons[8]);
        p.add(numButtons[9]);
        p.add(badd);

        // Row 3
        p.add(numButtons[4]);
        p.add(numButtons[5]);
        p.add(numButtons[6]);
        p.add(beq);

        // Row 4
        p.add(numButtons[1]);
        p.add(numButtons[2]);
        p.add(numButtons[3]);
        p.add(new Label());

        f.add(t1, BorderLayout.NORTH);
        f.add(p, BorderLayout.CENTER);
        f.setSize(300, 400);
        f.setVisible(true);
        f.setBackground(Color.lightGray);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.matches("[0-9]")) {
            t1.setText(t1.getText() + command);
        } else if (e.getSource() == badd) {
            s1 = t1.getText();
            t1.setText("");
            c = 1;
        } else if (e.getSource() == bsub) {
            s1 = t1.getText();
            t1.setText("");
            c = 2;
        } else if (e.getSource() == bmul) {
            s1 = t1.getText();
            t1.setText("");
            c = 3;
        } else if (e.getSource() == bdiv) {
            s1 = t1.getText();
            t1.setText("");
            c = 4;
        } else if (e.getSource() == beq) {
            s2 = t1.getText();
            switch (c) {
                case 1:
                    n = Integer.parseInt(s1) + Integer.parseInt(s2);
                    break;
                case 2:
                    n = Integer.parseInt(s1) - Integer.parseInt(s2);
                    break;
                case 3:
                    n = Integer.parseInt(s1) * Integer.parseInt(s2);
                    break;
                case 4:
                    n = Integer.parseInt(s1) / Integer.parseInt(s2);
                    break;
            }
            t1.setText(String.valueOf(n));
        } else if (e.getSource() == bclr) {
            t1.setText("");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
