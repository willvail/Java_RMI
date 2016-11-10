import java.rmi.Naming;
/**
 * 
 * @author William Vail #100941960
 * @version 1.9
 * @since 11/7/2016
 *
 */
public class rsvclient {
	public static void main(String args[]) throws Exception {
        Rmi_Interface obj = (Rmi_Interface)Naming.lookup("/"+args[0]);   //please use '/localhost/rsvserver' for the hostname portion of the input. 
		if(args[1].toLowerCase().equals("list")){
			int count = 0;										//count will determine how many seats remain
			String unoccupied = "";								//unoccupied will keep track of unfilled elements (seats) and concatenate this string
			for(int x=0; x<5; x++){
				if(obj.getBiz(x).contains("E")){				//if the business seat is open record it
					unoccupied= unoccupied.concat(Integer.toString(x+1)+",");
				}
				else{
					count++;									//otherwise count it
				}
			}
			System.out.println("Business Class:");
			if(count <=3){
				System.out.println((3-count) + " seat(s) at $500 each");	//so that we can determine costs
				System.out.println("2 seat(s) at $800 each");
			}
			else if(count <5 && count >=3){
				System.out.println("0 seat(s) at $500 each");
				System.out.println((5-count) + " seat(s) at $800 each");
			}
			else{System.out.println("Business Class filled.");}
			System.out.println("Seat Numbers: " + unoccupied);	//finally when everything is said and done there will be a list of open seats.
			count = 0;
			unoccupied = "";
			for(int y=0; y<25; y++){								//check all 25 values
				if(obj.getEcon(y).contains("E")){					//if the value has an E
					unoccupied= unoccupied.concat(Integer.toString(y+6)+",");	//it's unoccupied: record that.
				}
				else{
					count++;										//otherwise keep # seats remaining statistic
				}
			}
			
			System.out.println("Economy Class:");
			if(count <=10){
				System.out.println((10-count) + " seat(s) at $200 each");		//Outputing information
				System.out.println("10 seat(s) at $300 each");
				System.out.println("5 seat(s) at $450 each");
			}
			else if(count <=20 && count >10){
				System.out.println("0 seat(s) at $200 each");
				System.out.println((20-count) + " seat(s) at $300 each");
				System.out.println("5 seat(s) at $450 each");
			}
			else if(count <25 && count > 20){
				System.out.println("0 seat(s) at $200 each");
				System.out.println("0 seat(s) at $300 each");
				System.out.println((25-count) + " seat(s) at $450 each");
			}
			else{System.out.println("Economy Class filled.");}
			System.out.println("Seat Numbers: " + unoccupied);
		}
				
			else if(args[1].toLowerCase().equals("reserve")){
			String type = args[2];
			String name = args[3];
			int seat = Integer.parseInt(args[4]);
			System.out.println(obj.RMI_Implement(type,name,seat));
			}
			
			else if(args[1].toLowerCase().equals("passengerlist")){
			for(int z=0; z<5; z++){
				String temp = obj.getBiz(z);		
				if(temp.equals("E")){}
				else{
					System.out.println(temp + " business " + (z+1));
				}
			}
			for(int w=0; w<25; w++){
				String temp = obj.getEcon(w);
				if(temp.equals("E")){}
				else{
					System.out.println(temp + " economy " + (w+6));
				}
			}
			}
			
			else{
			System.err.println("Error: Incorrect Option for RMI_Client.");
			}
		}
    }