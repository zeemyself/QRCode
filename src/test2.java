import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;


public class test2 implements TextListener{
	private String scan;
	private JFrame frame1;
	private JLabel image; 
	private JLabel qrlabel;
	private TextField qr;
	private JLabel text;
	private JPanel panel1,panel2;
	private static String[] imageList = {"src/pic/rsz_qrcode.png","src/pic/green_tick.png","src/pic/red_tick.png"};
	public test2(){
		Dimension expectedDimension = new Dimension(500, 500);
		frame1 = new JFrame("Yeahhhhhhhhh");
		panel1 = new JPanel();
		panel1.setPreferredSize(expectedDimension);
        panel1.setMaximumSize(expectedDimension);
        panel1.setMinimumSize(expectedDimension);
		Box box = new Box(BoxLayout.Y_AXIS);
		box.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		
		ImageIcon qrcode = new ImageIcon(imageList[0]);
		qrlabel = new JLabel(qrcode);
		qrlabel.setSize(10,10);
		image = qrlabel;
		qr = new TextField("");
//		qr.setVisible(false);
		qr.requestFocus();
//		qr.addActionListener(this);
		qr.addTextListener(this);
		
//		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		text = new JLabel("Please show your QR code");
		text.setFont(new Font("Lao MN", Font.PLAIN, 19));
		text.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(image);
		panel1.add(text);
		
		panel1.setLocation(100,100);
		
		box.add(Box.createVerticalGlue());
		box.add(panel1);
		box.add(Box.createVerticalGlue());
		
		panel2 = new JPanel();
		panel2.add(qr);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame1.setMaximumSize(new Dimension(500,500));
//        frame1.setMinimumSize(new Dimension(500,500));
//		frame1.add(panel1,BorderLayout.NORTH);
        frame1.add(panel2,BorderLayout.NORTH);
        frame1.add(box,BorderLayout.NORTH);
//		frame1.setSize(500,200);
		frame1.setLocation(150,150);
		frame1.pack();
//		frame1.setPreferredSize(new Dimension(500,500));
		frame1.setVisible(true);
	}
	
	public static void main(String[] args) {
		new test2();

	}

	@Override
	public void textValueChanged(TextEvent e) {
		// TODO Auto-generated method stub
		System.out.println(qr.getText());
		scan = qr.getText();
		if(scan.length()==8){
		makeAlert();
		qrlabel.setIcon(new ImageIcon(imageList[1]));
		}
	}

	public void makeAlert(){
		JOptionPane optionPane = new JOptionPane(scan,JOptionPane.WARNING_MESSAGE);
		JDialog dialog = optionPane.createDialog("Warning!");
		dialog.setAlwaysOnTop(true); // to show top of all other application
		dialog.setVisible(true);
	}

}
