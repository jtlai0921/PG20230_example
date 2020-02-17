import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyExitButton extends JButton {
    public MyExitButton() {
        super();

        this.setLayout(new GridLayout(2, 1));
        this.add(new JLabel("����", JLabel.CENTER));
        this.add(new JLabel("����", JLabel.CENTER));

        this.setBackground(Color.green);

        ActionListener l = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int optionChosen = JOptionPane.showConfirmDialog(
                        null,
                        "�z�u���n������?", 
                        "����?", 
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                if (optionChosen == 0) { // Yes (�Ĥ@�ӿﶵ).
                        // �u���a�������ε{��, �i��U�إ��n���M�z�ʧ@
                        // ... �Ӹ`�ٲ�

                        System.exit(0);
                }
            }
        };
        this.addActionListener(l);
    }

    // ���ե�
    public static void main(String[] args) {
        JFrame f = new JFrame("�ϥΦ۩w�������s");
        f.getContentPane().add(new JLabel("�o��O���ε{�����U�إ\�� ...",
                JLabel.CENTER), BorderLayout.CENTER);
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 3));
        p.add(new JLabel(""));
        p.add(new MyExitButton());
        p.add(new JLabel(""));
        f.getContentPane().add(p, BorderLayout.SOUTH);
        f.setSize(400, 200);
        f.setVisible(true);
    }
}
