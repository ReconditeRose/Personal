import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainDisplay {
	public static void main(String[] args) {
		window frame = new window();


		frame.setTitle("An Empty Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final drawingFrame myObject = new drawingFrame(5,5,frame);
		JPanel myPanel = new JPanel();
		JButton update = new JButton("Solve");
		update.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TileSolver a= new TileSolver(myObject.differenceMap());
				myObject.printValues(a.solve());
			}
			
		});
		JButton switchType = new JButton("Switch Input");
		switchType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myObject.switchInput();
			}
		});
		myPanel.add(update);
		myPanel.add(switchType);
		frame.add(myPanel,BorderLayout.SOUTH);
		
		myObject.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				myObject.clicked(arg0.getX(), arg0.getY());
				
			}
		});
		frame.add(myObject);
		frame.setVisible(true);
		frame.pack();
	}
}
