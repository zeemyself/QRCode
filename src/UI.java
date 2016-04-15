import java.awt.*;
import java.awt.event.*;

public class UI extends Frame implements ActionListener {
	   private Label label1,label2;
	   private TextField text1,text2;
	   private Button btnCount;   
	public UI () {
		
	      setLayout(new FlowLayout());
	        
	      label1 = new Label("Input1");
	      text1 = new TextField("", 20);
	      add(label1);             
	      add(text1);
	      
	      label2 = new Label("Input2");
	      text2 = new TextField("", 20);
	      add(label2);             
	      add(text2);
	   
	      
	      setSize(300,300);
	      setVisible(true);       
	   }
	 
	   public static void main(String[] args) {
	      // Invoke the constructor to setup the GUI, by allocating an instance
	      UI app = new UI();
	         // or simply "new AWTCounter();" for an anonymous instance
	   }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
