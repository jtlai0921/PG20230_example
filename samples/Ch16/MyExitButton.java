import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyExitButton extends JButton {
    public MyExitButton() {
        super();

        this.setLayout(new GridLayout(2, 1));
        this.add(new JLabel("按此", JLabel.CENTER));
        this.add(new JLabel("結束", JLabel.CENTER));

        this.setBackground(Color.green);

        ActionListener l = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int optionChosen = JOptionPane.showConfirmDialog(
                        null,
                        "您真的要結束嗎?", 
                        "結束?", 
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                if (optionChosen == 0) { // Yes (第一個選項).
                        // 優雅地結束應用程式, 進行各種必要的清理動作
                        // ... 細節省略

                        System.exit(0);
                }
            }
        };
        this.addActionListener(l);
    }

    // 測試用
    public static void main(String[] args) {
        JFrame f = new JFrame("使用自定結束按鈕");
        f.getContentPane().add(new JLabel("這邊是應用程式的各種功能 ...",
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
