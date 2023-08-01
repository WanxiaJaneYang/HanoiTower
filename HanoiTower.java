//==================================
// Foundations of Computer Science
// Student: Wanxia Yang
// id: a1866893
// Semester:s1
// Year:2022
// Practical Number:04 partII
//===================================

import java.util.*;

public class HanoiTower{
	public ArrayList<Integer> pole1;
	public ArrayList<Integer> pole2;
	public ArrayList<Integer> pole3;
	public ArrayList<Poles> historyMove;
	public int numberOfDisc;
	//set the attribute



	public HanoiTower(){
		numberOfDisc=3;
		pole1=new ArrayList<>();
		pole2=new ArrayList<>();
		pole3=new ArrayList<>();
		historyMove=new ArrayList<>();
		//instantiate the three poles and set the default number of discs

		System.out.print("The discs in pole1 are ");
		for(int i=1; i<=numberOfDisc ; i++){
			pole1.add(i);
			System.out.print("Disc"+pole1.get(i-1)+" ");	
		}
		System.out.println("");
		//print the discs on pole1
	}
	//constructor without parameters
	


	public HanoiTower(int tempDisc){
		numberOfDisc=tempDisc;
		pole1=new ArrayList<>();
		pole2=new ArrayList<>();
		pole3=new ArrayList<>();
		historyMove=new ArrayList<>();
		//instantiate the three poles and set the  number of discs

		System.out.print("The discs in pole1 are ");
		for(int i=1; i<=numberOfDisc ; i++){
			pole1.add(i);
			System.out.print("Disc"+pole1.get(i-1)+" ");		
		}
		System.out.println("");
		//print the discs on pole1
	}
	//constructor with a paramete
	


	public void move1(ArrayList<Integer> sourcePole, ArrayList<Integer> auxiliaryPole, ArrayList<Integer> destinationPole){
		boolean inSourcePole=sourcePole.contains(1);
		boolean inAuxiliaryPole=auxiliaryPole.contains(1);
		boolean inDestinationPole=destinationPole.contains(1);
		if(inSourcePole==true){
			sourcePole.remove(0);
			auxiliaryPole.add(0,1);
			printMove(1,sourcePole, auxiliaryPole);
		}else if(inAuxiliaryPole==true){
			auxiliaryPole.remove(0);
			destinationPole.add(0,1);
			printMove(1, auxiliaryPole, destinationPole);
		}else{
			destinationPole.remove(0);
			sourcePole.add(0,1);
			printMove(1, destinationPole, sourcePole);
		}
		//find the smallest disc and move it
	}
	//write the method to move a disc and print it
	

	
	public void move2(ArrayList<Integer> sourcePole, ArrayList<Integer> auxiliaryPole, ArrayList<Integer> destinationPole){
		boolean inSourcePole=sourcePole.contains(1);
		boolean inAuxiliaryPole=auxiliaryPole.contains(1);
		boolean inDestinationPole=destinationPole.contains(1);
		int littleDisc;
		//instantiate all the needed variables

		if(inSourcePole==true){
			if(auxiliaryPole.size()==0){
				littleDisc=destinationPole.get(0);
				auxiliaryPole.add(littleDisc);
				destinationPole.remove(0);
				printMove(littleDisc, destinationPole, auxiliaryPole);
			}else if(destinationPole.size()==0){
				littleDisc=auxiliaryPole.get(0);
				destinationPole.add(littleDisc);
				auxiliaryPole.remove(0);
				printMove(littleDisc, auxiliaryPole, destinationPole);
			}else{
				if(auxiliaryPole.get(0)<destinationPole.get(0)){
					littleDisc=auxiliaryPole.get(0);
					destinationPole.add(0,littleDisc);
					auxiliaryPole.remove(0);
					printMove(littleDisc, auxiliaryPole, destinationPole);
				}else{
					littleDisc=destinationPole.get(0);
					auxiliaryPole.add(0,littleDisc);
					destinationPole.remove(0);
					printMove(littleDisc, destinationPole, auxiliaryPole);
				}
			}
		}
		//if the source Pole got the disc 1
		
		if(inAuxiliaryPole==true){
			if(sourcePole.size()==0){
				littleDisc=destinationPole.get(0);
				sourcePole.add(littleDisc);
				destinationPole.remove(0);
				printMove(littleDisc, destinationPole, sourcePole);
			}else if(destinationPole.size()==0){
				littleDisc=sourcePole.get(0);
				destinationPole.add(littleDisc);
				sourcePole.remove(0);
				printMove(littleDisc, sourcePole, destinationPole);
			}else{
				if(sourcePole.get(0)<destinationPole.get(0)){
					littleDisc=sourcePole.get(0);
					destinationPole.add(0,littleDisc);
					sourcePole.remove(0);
					printMove(littleDisc, sourcePole, destinationPole);
				}else{
					littleDisc=destinationPole.get(0);
					sourcePole.add(0,littleDisc);
					destinationPole.remove(0);
					printMove(littleDisc, destinationPole, sourcePole);
				}
			}
		}
		//if the auxiliary Pole got the disc 1
		
		if(inDestinationPole==true){
			if(sourcePole.size()==0){
				littleDisc=auxiliaryPole.get(0);
				sourcePole.add(littleDisc);
				auxiliaryPole.remove(0);
				printMove(littleDisc, auxiliaryPole, sourcePole);
			}else if(auxiliaryPole.size()==0){
				littleDisc=sourcePole.get(0);
				auxiliaryPole.add(littleDisc);
				sourcePole.remove(0);
				printMove(littleDisc, sourcePole, auxiliaryPole);
			}else{
				if(sourcePole.get(0)<auxiliaryPole.get(0)){
					littleDisc=sourcePole.get(0);
					auxiliaryPole.add(0,littleDisc);
					sourcePole.remove(0);
					printMove(littleDisc, sourcePole, auxiliaryPole);
				}else{
					littleDisc=auxiliaryPole.get(0);
					sourcePole.add(0,littleDisc);
					auxiliaryPole.remove(0);
					printMove(littleDisc, auxiliaryPole, sourcePole);
				}
			}
		}
		//if the destination Pole got the disc 1
	}
	//move the little disc from source to auxiliary, print and save the move
	


	public void solve(){
		int numberOfMoves=(int)Math.pow(2,numberOfDisc)-1;
		int count=1;
		//calculate the number of moves

		if(numberOfDisc%2==1){
			while(count<=numberOfMoves){
				if(count%2==1){
					move1(pole1, pole3, pole2);
					saveMove(pole1, pole2, pole3);
					count++;
				}else{
					move2(pole1, pole3, pole2);
					saveMove(pole1, pole2, pole3);
					count++;
				}
			}
		}else{
			while(count<=numberOfMoves){
				if(count%2==1){
					move1(pole1, pole2, pole3);
					saveMove(pole1, pole2, pole3);
					count++;
				}else{
					move2(pole1, pole2, pole3);
					saveMove(pole1, pole2, pole3);
					count++;
				}
			}
		}
	}
	//write the solve method
	


	public void printMove(int disc, ArrayList<Integer> sourcePole, ArrayList<Integer> destinationPole){
		int source=0;
		int destination=0;
		//instantiate all the needed variables

		
		if(sourcePole==pole1){
			source=1;
		}else if(sourcePole==pole2){
			source=2;
		}else if(sourcePole==pole3){
			source=3;
		}
		if(destinationPole==pole1){
			destination=1;
		}else if(destinationPole==pole2){
			destination=2;
		}else if(destinationPole==pole3){
			destination=3;
		}
		//identify the poles
		
		System.out.printf("Move disc%d from pole%d to pole%d\n", disc, source, destination);	
		//print the move and save the history
	}



	public void saveMove(ArrayList<Integer> pole1, ArrayList<Integer> pole2, ArrayList<Integer> pole3){
		Poles record =new Poles();
		record.pole1Discs=new ArrayList<>();
		record.pole2Discs=new ArrayList<>();
		record.pole3Discs=new ArrayList<>();
		record.pole1Discs.addAll(pole1);
		record.pole2Discs.addAll(pole2);
		record.pole3Discs.addAll(pole3);
		historyMove.add(record);
	}
	//save the record



	public void printHistory(){
		int i=1;
		for(Poles poles:historyMove){
			
			System.out.println("Move "+i);
			System.out.print("Pole1:");
			for(Integer disc:poles.pole1Discs){
				System.out.print(disc+" ");
			}
			System.out.println(" ");
			System.out.print("Pole2:");
			for(Integer disc:poles.pole2Discs){
				System.out.print(disc+" ");
			}
			System.out.println(" ");
			System.out.print("Pole3:");
			for(Integer disc:poles.pole3Discs){
				System.out.print(disc+" ");
			}
			System.out.println(" ");
			i++;
		}
	}
	//print the history record -- for test	
	
}
