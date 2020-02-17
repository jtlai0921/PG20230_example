import javax.swing.*;

public class MyExitButtonDemo {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.getContentPane().add(new MyExitButton());
		f.setSize(200, 100);
		f.setVisible(true);
	}
}

