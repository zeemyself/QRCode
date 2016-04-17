import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;


public class test2 implements TextListener{
	private int count =0;
	private ButtonGroup radiogroup;
	private String error;
	private String scan;
	private JFrame frame1,frame2;
	private JLabel image; 
	private JLabel qrlabel;
	private TextField qr,api,activity;
	private JLabel text,text2,text3,text4;
	private JPanel panel1,panel2,panel3;
	private JButton button1;
	private JRadioButton enter,exit;
	private static String[] imageList = {"src/pic/rsz_qrcode.png","src/pic/green_tick.png","src/pic/red_tick.png"};
	public test2(){
		Dimension expectedDimension = new Dimension(500, 500);
		frame1 = new JFrame("Ticket Provider Manager");
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
		frame1.setVisible(false);
		
		
		
		frame2 = new JFrame("Ticket Provider Manager");
		panel3 = new JPanel(new SpringLayout());
		api = new TextField();
		activity = new TextField();
		text2 = new JLabel("api token",JLabel.TRAILING);
		text3 = new JLabel("activity id",JLabel.TRAILING);
		text4 = new JLabel("",JLabel.TRAILING);
		button1 = new JButton("Validate");
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame1.setVisible(true);
				frame2.setVisible(false);
			}
		} );
		
//		Radio Button
		enter = new JRadioButton("Enter",true);
		exit = new JRadioButton("Exit");
		radiogroup = new ButtonGroup();
		radiogroup.add(enter);
		radiogroup.add(exit);
		
		
		panel3.add(text2);
		panel3.add(api);
		panel3.setOpaque(true);
		panel3.add(text3);
		panel3.add(activity);
		panel3.add(enter);
		panel3.add(exit);
		panel3.add(text4);
		panel3.add(button1);
		
		SpringUtilities.makeCompactGrid(panel3,
                4, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);
		frame2.add(panel3);
		frame2.setVisible(true);
		frame2.setLocation(150,150);
		frame2.setSize(500,150);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		new test2();
//		request("qMnsbPILS8eIvluTVb1rdg","707a6393","76fb3bd5");

	}

	@Override
	public void textValueChanged(TextEvent e) {
		// TODO Auto-generated method stub
		count++;
		System.out.println(count);
		System.out.println(qr.getText());
		scan = qr.getText();
		if(scan.length()==8){
			if(request(api.getText(),activity.getText(),qr.getText(),enter.isSelected())){
				qrlabel.setIcon(new ImageIcon(imageList[1]));
				System.out.println("FUCKK");
				makeAlert("pass");
			}
			else{
				qrlabel.setIcon(new ImageIcon(imageList[2]));
				makeAlert("fail");
			}
			try {
				Thread.sleep(3000);
				qrlabel.setIcon(new ImageIcon(imageList[0]));
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			qr.setText("");
		}
	}

	public void makeAlert(String words){
		JOptionPane optionPane = new JOptionPane(words,JOptionPane.WARNING_MESSAGE);
		JDialog dialog = optionPane.createDialog("Warning!");
		dialog.setAlwaysOnTop(true); // to show top of all other application
		dialog.setVisible(true);
	}
	public boolean request(String api,String activity,String user,boolean enter){
		String web = "https://ticket-provider-staging.herokuapp.com/api/v1/tickets/";
		String en = "";
		if(enter)
			en = "enter";
		else
			en = "exit";
		String post = web + en + "?api_token=" + api + "&activity_id=" + activity + "&user_id=" + user;
		System.out.println(post);
		URL url = null;
		try {
			url = new URL(post);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return false;
		}
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("PUT");
			connection.connect();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		InputStream stream;
		try {
			stream = connection.getInputStream();
//			System.out.println(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
