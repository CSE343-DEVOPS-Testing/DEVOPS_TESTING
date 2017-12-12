import static org.junit.Assert.assertEquals;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JFrame; 
import javax.swing.JButton; 
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextField;



public class gui extends JFrame 
{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel class_;
	private JTextField class_name;
	private JLabel func_;
	private JTextField func_name;
	private JLabel delimeter_;
	private JTextField delimeter_name;
	private JLabel p1;
	private JTextField params;/*
	private JLabel p2;
	private JTextField param2;*/
	private JLabel expected;
	private JTextField expected_value;
	private JButton getcode;
	private JButton testbutton; 
	public gui() 
	{
				 
		class_ = new JLabel("Class name:"); 
		this.add(class_); 
		
		class_name = new JTextField(10);
		this.add(class_name);
		
		func_ = new JLabel("Function name:"); 
		this.add(func_); 
		
		func_name = new JTextField(10);
		this.add(func_name);
		

		p1 = new JLabel("Parameters:"); 
		this.add(p1); 
		params = new JTextField(20);
		params.setBounds(50,100, 200,30);  
		this.add(params);
	    //param1.setHorizontalAlignment(JTextField.RIGHT);

		delimeter_ = new JLabel("Delitemer:"); 
		this.add(delimeter_); 
		
		delimeter_name = new JTextField(3);
		this.add(delimeter_name);
		
		
		params.setEditable(true);
		
		
		expected = new JLabel("Expected Value:"); 
		this.add(expected); 
		expected_value = new JTextField(20);
		this.add(expected_value);
		
		testbutton = new JButton("Test!"); 
		this.add(testbutton);

		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("d.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		this.add(picLabel);
		
		
		// TEMEL PENCERE ÝSLEVLERÝ 
		this.setTitle("DEVOPS Testing Enviroment"); 
		this.setLayout(new FlowLayout()); 
		this.setBounds(150,150,445,400); 
		this.setVisible(true); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		
		params.addActionListener(new add_param());
		testbutton.addActionListener(new testClass());

		
	}
	
	class add_param implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	
	        String input = params.getText();   //receive input from text field
	        System.out.println(input);

	        
	    }
	}
	 
	public static void main(String[] args) 
	{ 
		new taslak_gui(); 
	} 
 
} 
