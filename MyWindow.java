//==================================
// Foundations of Computer Science
// Student: Wanxia Yang
// id: a1866893
// Semester:s1
// Year:2022
// Practical Number:04 partII
//===================================

import javax.swing.*;
import java.util.*;

public class MyWindow extends JFrame{
	public MyWindow(){
		setWindowAttribute();
		createComponent();
	}
	//set a default constructor

	public void setWindowAttribute(){
		setTitle("Hanoi Tower Problem");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);
	}
	//set the basic attribute for the window
	
	public void createComponent(){
		JPanel mainPanel = new JPanel(); 
		JPanel titlePanel = new JPanel();
		JPanel hanoiShow = new JPanel(); 
		JPanel menuPanel = new JPanel(); 
		//create four panels

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(titlePanel);
		mainPanel.add(hanoiShow);
		mainPanel.add(menuPanel);
		//set layout and add the three panel to the main
	
		createMenuAndHanoiShow(menuPanel, hanoiShow);
		//create menu panel

		titlePanel.add(new JLabel("Hanoi Tower Show"));
		

		add(mainPanel); 
	}
	
	public void createMenuAndHanoiShow(JPanel menu, JPanel hanoiShow){
		JButton generateButton= new JButton("Generate Hanoi Tower");
		JButton randomGenerateButton=new JButton("Generate Hanoi Tower Randomly");
		JButton startAnimationButton=new JButton("Start");
		JButton nextButton=new JButton("Next");
		JButton clearButton=new JButton("Clear");
		//create buttons

		menu.setLayout(new BoxLayout(menu, BoxLayout.X_AXIS));
		//set the layout

		menu.add(generateButton);
		menu.add(randomGenerateButton);
		menu.add(startAnimationButton);
		menu.add(nextButton);
		menu.add(clearButton);
		//add the button to the menu
		//listener to be added
		
		MyCanvas canvas= new MyCanvas();
		hanoiShow.add(canvas);

		generateButton.addActionListener((e)->{
			canvas.isGenerated=true;
			canvas.repaint();
		});
		//add actionListener to generate Button

		randomGenerateButton.addActionListener((e)->{
			canvas.isGenerated=true;
			Random number= new Random();
			canvas.numberOfDiscs=(number.nextInt(12));
			canvas.repaint();
		});
		//add actionListener to generate Button
	
		startAnimationButton.addActionListener((e)->{
			canvas.isGenerated=false;
			canvas.isStarted=true;
			canvas.move=1;
			canvas.repaint();
		});
		//add actionListener to startAnimationButton Button
		
		nextButton.addActionListener((e)->{
			canvas.isGenerated=false;
			canvas.isStarted=true;
			canvas.move++;
			if(canvas.move>(Math.pow(2, canvas.numberOfDiscs)-1)){
				canvas.isStarted=false;
			}
			canvas.repaint();
		});

		clearButton.addActionListener((e)->{
			canvas.isGenerated=false;
			canvas.isStarted=false;
			canvas.repaint();
		});
		//add actionListener to clear Button
	}
	//method to create menu

	
}
