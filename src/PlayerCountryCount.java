import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/*
   - Given The list of n players and their respective country
     Then player names on next m rows
   - find out from m rows
       a) Player whose name is repeated most
       b) Country Whose players are repeated most
      
       in case of same score please return lexicographically shortest string
      
     eg : 
1, 3
Dhoni, india
Dhoni
Dhoni
Dhoni          

output
Dhoni
India
---------------         
4, 5
Kohli, India
Smith, Australia
Root, England
Warner, Australia
Kohli
Smith
Smith
Kohli
Warner

         
Output
Kohli
Australia
 */


public class PlayerCountryCount {
   
    private TreeMap<String, String> pairs = new TreeMap<String, String>();
    private TreeMap<String, Integer> players = new TreeMap<String, Integer>();
    private TreeMap<String, Integer> countryCount = new TreeMap<String, Integer>();
    
    private void getInput() {
       Scanner sc = new Scanner(System.in);

       String input = sc.nextLine();
       String[] inputString = input.trim().split(",");
       
       int noOfPairs = Integer.parseInt(inputString[0].trim());
       int noOfPlayers = Integer.parseInt(inputString[1].trim());
       int loop = 1;

       while(loop <= noOfPairs + noOfPlayers)
       {
    	   if(loop <= noOfPairs){
        	   input = sc.nextLine();
        	   inputString = input.split(",");
        	   pairs.put(inputString[0].trim(), inputString[1].trim());
    	   }
    	   
    	   if(loop>noOfPairs && loop<=noOfPairs+noOfPlayers){
    		   populate(sc.nextLine());
    	   }
    	   loop++;
       }
		
		/* Getting the player present max no of times*/
		Set <String> keys = players.keySet();
		int maxVal=0;
		String maxKey = null;
		for(String key : keys){
			if(maxVal < players.get(key)){
				maxVal = players.get(key);
				maxKey = key;
			}
		}
		System.out.println(maxKey);
		
		/* Getting the country present max no of times*/
		keys = countryCount.keySet();
		maxVal=0;
		maxKey = null;
		for(String key : keys){
			if(maxVal < countryCount.get(key)){
				maxVal = countryCount.get(key);
				maxKey = key;
			}
		}
		System.out.println(maxKey);
		sc.close();
    }
   
    private void populate(String nextLine) {

    	if (players.containsKey(nextLine))
    		players.put(nextLine, players.get(nextLine) + 1);
    	else 
    		players.put(nextLine, 1);
    	
    	if(countryCount.containsKey(pairs.get(nextLine)))
    		countryCount.put(pairs.get(nextLine), countryCount.get(pairs.get(nextLine))+1);
    	else
    		countryCount.put(pairs.get(nextLine), 1);
    	
    }

	public static void main(String rgs[]) {
        PlayerCountryCount ob=new PlayerCountryCount();
        ob.getInput();
    }

}

