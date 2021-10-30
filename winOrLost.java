import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class winOrLost extends JFrame implements WindowListener {		
	public winOrLost(int a, int b) {
		setSize(400,100);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(new GridLayout(2,1) );
		String kazanan="Black";
		if(b>a) {
			kazanan="White";
		}
		else if(b==a) {
			kazanan="oyun berabere bitti";
		}
		addWindowListener(this);
		setTitle("Oyunun kazanani.......");
		JLabel label = new JLabel("..."+kazanan);
		add(label);
		setVisible(true);		
	}			
	public void windowOpened(WindowEvent e) {		
	}	
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}	
	public void windowClosed(WindowEvent e) {		
	}
	public void windowIconified(WindowEvent e) {		
	}
	public void windowDeiconified(WindowEvent e) {	
	}	
	public void windowActivated(WindowEvent e) {		
	}
	public void windowDeactivated(WindowEvent e) {		
	}

}
