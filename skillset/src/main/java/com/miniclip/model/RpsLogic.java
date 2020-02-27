package com.miniclip.model;
import java.util.HashMap;
import java.util.Random;

public class RpsLogic {
	
	
	public static HashMap<String, String> rpsLogic(String userChoice){
		String[] systemChoiceList 	= {"rock","paper","scissors"}; //system choice list
		String[] userChoiceList 	= {"rock","paper","scissors"}; //user choice list
		//List<String> gameResult = new ArrayList<String>();
		HashMap<String,String> gameResult = new HashMap<String,String>();  
		String gameResultStatus = null;
		String systemChoice=null;
		String winner = null;
		int gameDecision=-1;
		
		Random rand = new Random();		
		
		int systemChoiceIndex = rand.nextInt(3)+ 0; //exclusive 3, inclusive 0
		int userChoiceIndex=-1;
		
		//calculate user choice index
				for(int index=0;index<userChoiceList.length;index++){	
					if(userChoiceList[index].equals(userChoice)){
						userChoiceIndex=index;
						break;
					}
				}
			gameDecision=(3+userChoiceIndex-systemChoiceIndex)%3;//logic
				switch(gameDecision){
				case 0:
					gameResultStatus= userChoiceList[userChoiceIndex]+" equals "+systemChoiceList[systemChoiceIndex]+". TIE.";
					winner = "TIE";
					break;
				case 1:
					gameResultStatus= userChoiceList[userChoiceIndex]+" kills "+systemChoiceList[systemChoiceIndex]+". USER WINS.";
					winner = "USER";
					break;
				case 2:
					gameResultStatus= userChoiceList[userChoiceIndex]+" killed by "+systemChoiceList[systemChoiceIndex]+". SYSTEM WINS.";
					winner= "SYSTEM";
					break;
				default:gameResultStatus= "Undefined Result.";						
				}
				 systemChoice = systemChoiceList[systemChoiceIndex];
				//gameResult.add(gameResultStatus);
				
				//gameResult.add(winner);
				gameResult.put("userChoice", userChoice);
				gameResult.put("systemChoice", systemChoice);				
				gameResult.put("winner", winner);
				gameResult.put("gameResultStatus", gameResultStatus);
				
				System.out.println("USER CHOICE : "+userChoice+" "+userChoiceList[userChoiceIndex]);
				System.out.println("SYSTEM CHOICE                  : "+systemChoiceList[systemChoiceIndex]);
				System.out.println("Result: "+gameResultStatus);
				
							
				return (gameResult);
	}
	/*
	 * 
		String userChoice = request.getParameter("radio"); //receiving user choice
		
				
		
		*/
}
