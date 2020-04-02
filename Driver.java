import javax.swing.JFrame;

public class Driver {
//Driver for movment of ship using arrow keys
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("KeyListener Demo");
		frame.setContentPane(new Panel());
		frame.setSize(400, 400);
		frame.setLocation(200, 200);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}