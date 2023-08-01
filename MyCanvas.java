//==================================
// Foundations of Computer Science
// Student: Wanxia Yang
// id: a1866893
// Semester:s1
// Year:2022
// Practical Number:04 partII
//===================================

import javax.swing.*;
import java.awt.*;
import java.util.*;


public class MyCanvas extends Canvas{
	public boolean isGenerated=false;
	public boolean isStarted=false;
	public static int thicknessOfDisc=10;
	public int numberOfDiscs=3;
	public static int move=1;
	//declare attributes 

	public MyCanvas(){
		this.setPreferredSize(new Dimension(700,300));
	}
	//generator
	

	@Override
	public void paint(Graphics g){
		g.setColor(Color.GRAY);
		g.fillRect(100,0,20,300);
		g.fillRect(325,0,20,300);
		g.fillRect(550,0,20,300);
		//draw three poles

		if(isGenerated==true){
			HanoiTower tower1=new HanoiTower(numberOfDiscs);
			for(Integer d : tower1.pole1){
				int value=d.intValue();
				int width=getWidth(value);
				g.setColor(getColor(value));
				g.fillRect(110-width/2,300-(numberOfDiscs-value+1)*thicknessOfDisc,width, thicknessOfDisc);
			}
		}
		//draw discs in pole1

		if(isStarted==true){
			painDiscs(g);		
		}
		//write the drawing process when started is clicked
	}


	public void painDiscs(Graphics g){
		HanoiTower tower1=new HanoiTower(numberOfDiscs);
		tower1.solve();
		Poles poles=tower1.historyMove.get(move-1);
		//get the history to paint

		int place1=1;
		for(Integer d1: poles.pole1Discs){
			int size1=poles.pole1Discs.size();
			int valueD1=d1.intValue();
			int widthD1=getWidth(valueD1);
			g.setColor(getColor(valueD1));
			g.fillRect(110-widthD1/2,300-(size1-place1+1)*thicknessOfDisc,widthD1, thicknessOfDisc);
			place1++;
		}
		
		int place2=1;
		for(Integer d2: poles.pole2Discs){
			int size2=poles.pole2Discs.size();
			int valueD2=d2.intValue();
			int widthD2=getWidth(valueD2);
			g.setColor(getColor(valueD2));
			g.fillRect(335-widthD2/2,300-(size2-place2+1)*thicknessOfDisc,widthD2, thicknessOfDisc);
			place2++;
		}
		
		int place3=1;
		for(Integer d3: poles.pole3Discs){
			int size3=poles.pole3Discs.size();
			int valueD3=d3.intValue();
			int widthD3=getWidth(valueD3);
			g.setColor(getColor(valueD3));
			g.fillRect(560-widthD3/2,300-(size3-place3+1)*thicknessOfDisc,widthD3, thicknessOfDisc);
			place3++;
		}
		//paint the discs
	}
	//paint the discs according to move
	


	public Color getColor(int number){
		int i=number%3;
		if(i==0){
			return Color.RED;
		}else if(i==1){
			return Color.BLUE;
		}else{
			return Color.GREEN;
		}
	}
	//get the disc color
	


	public int getWidth(int number){
		int width=150;
		width=width-20*(numberOfDiscs-number);
		return width;
	}
	//get the width of disc
}
