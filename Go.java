//hocam main methodu en assagida
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class Go extends JFrame  implements MouseListener, MouseMotionListener,WindowListener{
	///////////////////////////////////////////////////////////////////////////////////////////
	//hocam bu satirdan  111. satira kadar eski go oyunundan kalma kodun bulundugu kisim
	String[][] item=new String[9][9];	
	boolean exceptions=true;
	String forInput="x";
	String[] letter= {"a","b","c","d","e","f","g","h","i"};
	public  void basla() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				item[i][j]="-";	}}}
	
	 public  void degisim(String girdi,String renk) {
		int sutun=girdi.charAt(0)-97;
		int satir=girdi.charAt(1)-49;
		if(kontrol( girdi,renk)==true) {
			item[sutun][satir]=renk;
			}
		else {
			if(renk.equals("o"))
			item[sutun][satir]="x";
			else item[sutun][satir]="o";
		}
	}
	public  boolean kontrol(String girdi,String renk/*,Board tahta*/) {
		int sutun=girdi.charAt(0)-97;
		int satir=girdi.charAt(1)-49;
		String oyuncuRenk ="o";
		int kontrol=0;
		if(renk.equals("o")){		
			oyuncuRenk="x";	}
		
		if(sutun==0) {kontrol+=1;}
		else if(item[sutun-1][satir].equals(oyuncuRenk)) {kontrol+=1;}
		if(sutun==8) {kontrol+=1;}
		else if(item[sutun+1][satir].equals(oyuncuRenk)) {kontrol+=1;}
		if(satir==0) {kontrol+=1;}
		else if(item[sutun][satir-1].equals(oyuncuRenk)) {kontrol+=1;}
		if(satir==8) {kontrol+=1;}
		else if(item[sutun][satir+1].equals(oyuncuRenk)) {kontrol+=1;}
		
		if(kontrol==4) {
			return false;}
		else {
			return true;}		
	}
	public  void delete(String girdi,String renk) {
		int sutun=girdi.charAt(0)-97;		
		int satir=girdi.charAt(1)-49;		
		String oyuncuRenk ="o";
		if(renk.equals("o")){oyuncuRenk="x";}
		if((!(sutun==0))&&item[sutun-1][satir].equals(oyuncuRenk)) {
			char harf=(char) ((char)sutun+96);
			String newGirdi=""+harf+(satir+1);
			degisim(newGirdi,oyuncuRenk);
			if(item[sutun-1][satir].equals("-")) {item[sutun-1][satir]=renk;}}
		if((!(sutun==8))&&item[sutun+1][satir].equals(oyuncuRenk)) {
			char harf=(char) ((char)sutun+98);
			String newGirdi=""+harf+(satir+1);
			degisim(newGirdi,oyuncuRenk);
			if(item[sutun+1][satir].equals("-")) {item[sutun+1][satir]=renk;}}
		if((!(satir==0))&&item[sutun][satir-1].equals(oyuncuRenk)) {
			char harf=(char) ((char)sutun+97);
			String newGirdi=""+harf+(satir);
			degisim(newGirdi,oyuncuRenk);
			if(item[sutun][satir-1].equals("-")) {item[sutun][satir-1]=renk;}}
		if((!(satir==8))&&item[sutun][satir+1].equals(oyuncuRenk)) {
			char harf=(char) ((char)sutun+97);
			String newGirdi=""+harf+(satir+2);
			degisim(newGirdi,oyuncuRenk);
			if(item[sutun][satir+1].equals("-")) {item[sutun][satir+1]=renk;}}
	}
	public void start(String girdi,String renk) {
		degisim(girdi, renk);
		 delete(girdi, renk );
	}
	 public int sayacX() {
		 int sayiX=0;		
		 for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					if(item[i][j].equals("x")){
						sayiX+=1;
		 }}}
		 return sayiX;
	 }
	 public int sayacO() {
		 int sayiO=0;		
		 for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					if(item[i][j].equals("o")){
						sayiO+=1;
		 }}}
		 return sayiO;
	 }
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	int sayacPas=0;
	public Go(){
		basla();
		setSize(880,860);
		setBackground(Color.orange);
	    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Black");
		JPanel panel=new JPanel();
		JButton pas=new JButton("PAS");
		pas.addActionListener((a)-> {if(BlackorWhite) {BlackorWhite=false;setTitle("White");}
		else {BlackorWhite=true;setTitle("Black");}sayacPas+=1;bitti();});
		pas.setBackground(Color.green);
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.ORANGE);
		panel.add(pas,BorderLayout.NORTH);
		add(panel,BorderLayout.WEST);
		
		addWindowListener(this);
		addMouseListener(this);
		setVisible(true);			 
	}	
	public void paint(Graphics g)
	{	g.setColor(Color.ORANGE);
		g.fillRect(60,60,780,780);
		g.setColor(Color.BLACK);
		g.drawLine(90,90,90,810);
		g.drawLine(180,90,180,810);
		g.drawLine(270,90,270,810);
		g.drawLine(360,90,360,810);
		g.drawLine(450,90,450,810);		
		g.drawLine(540,90,540,810);
		g.drawLine(630,90,630,810);
		g.drawLine(720,90,720,810);
		g.drawLine(810,90,810,810);	
		
		g.drawLine(90,90,810,90);
		g.drawLine(90,180,810,180);
		g.drawLine(90,270,810,270);
		g.drawLine(90,360,810,360);
		g.drawLine(90,450,810,450);		
		g.drawLine(90,540,810,540);
		g.drawLine(90,630,810,630);
		g.drawLine(90,720,810,720);
		g.drawLine(90,810,810,810);
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(item[j][i].equals("x")) {
					g.setColor(Color.BLACK);
					g.fillOval(yer(i),yer(j),60,60);
				}
				else if(item[j][i].equals("o")) {
					g.setColor(Color.WHITE);
					g.fillOval(yer(i),yer(j),60,60);
				}
				}
			}			
	}
	boolean BlackorWhite=true;
	public void mouseDragged(MouseEvent e) {		
		
	}	
	public void mouseMoved(MouseEvent e) {		
	
	}
	public void mouseClicked(MouseEvent e) {
		
	}	
	public void mousePressed(MouseEvent e) {
		sayacPas=0;
		int konumx = konumX(e.getX());
		String konumy = konumY(e.getY());
		start(""+konumy+konumx,xo(BlackorWhite));
		if(BlackorWhite) {BlackorWhite=false;setTitle("White");}
		else {BlackorWhite=true;setTitle("Black");}		
		repaint();
		bitti();
		
	}	
	public void mouseReleased(MouseEvent e) {
		
	}	
	public void mouseEntered(MouseEvent e) {
	
	}	
	public void mouseExited(MouseEvent e) {
	}
	
	public int konumX(int a) {///hocam konuX ve konumY çnceki go oyunundaki methodlar icin veriyi olusturuyor
		if(a<=135) {return 1;	}
		else if(a>=135 & a<=225) {return 2;	}
		else if(a>=225 & a<=315) {return 3;	}
		else if(a>=315 & a<=405) {return 4;	}
		else if(a>=405 & a<=495) {return 5;	}
		else if(a>=495 & a<=585) {return 6;	}
		else if(a>=585 & a<=675) {return 7;	}
		else if(a>=675 & a<=765) {return 8;	}
		else  {return 9;	}
	}
	public String konumY(int a) {
		if(a<=135) {return "a";	}
		else if(a>=135 & a<=225) {return "b";	}
		else if(a>=225 & a<=315) {return "c";	}
		else if(a>=315 & a<=405) {return "d";	}
		else if(a>=405 & a<=495) {return "e";	}
		else if(a>=495 & a<=585) {return "f";	}
		else if(a>=585 & a<=675) {return "g";	}
		else if(a>=675 & a<=765) {return "h";	}
		else  {return "i";	}
	}
	public int yer(int a) {//gelen veriye gore cizilecek yuvarlagin konumunu buluyor
		
		if(a==0) {return 60;}
		else if (a==1) {return 150;}
		else if (a==2) {return 240;}
		else if (a==3) {return 330;}
		else if (a==4) {return 420;}
		else if (a==5) {return 510;}
		else if (a==6) {return 600;}
		else if (a==7) {return 690;}
		else  {return 780;}	
	}
	public String xo(boolean b) {//sirayi buluyor
		if(b) {
			return "x";
		}
		else
			return "o";
	}
	public void bitti() {
		if(((sayacO()+sayacX())==81)||sayacPas==2 ) {
			new winOrLost(sayacX(),sayacO());
		}
	}	
	public void windowOpened(WindowEvent e) {		
	}	
	public void windowClosing(WindowEvent e) {
		new areYouSure(sayacX(),sayacO());		
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
	public static void main(String[]args) {
		new Go();
		}	
		
	
}
