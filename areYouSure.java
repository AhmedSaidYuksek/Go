import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class areYouSure extends JFrame implements ActionListener {
	int xForwin=0;
	int oForwin=0;
	public areYouSure(int a,int b) {
		 xForwin=a;
		 oForwin=b;
		setSize(400,100);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(new GridLayout(2,1) );
		
		JLabel label = new JLabel("Oyun Sonlandirilsin mi");
			
		JButton evet = new JButton("Evet");
		JButton hayir = new JButton("Hayir");
		
		evet.addActionListener(this);
		hayir.addActionListener(this);
		
		JPanel tus_paneli = new JPanel(new FlowLayout());
		
		tus_paneli.add(evet);
		tus_paneli.add(hayir);
		
		add(label);
		add(tus_paneli);
		
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if(s.equals("Evet")) {
			setVisible(false);
			new winOrLost(xForwin, oForwin);
			
		}
		else {
			dispose();
		}
		
	}

}
