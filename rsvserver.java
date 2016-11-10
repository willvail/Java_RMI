import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*; 
/**
 * 
 * @author William Vail #100941960
 * @version 1.5
 * @since 11/7/2016
 *
 */
public class rsvserver extends UnicastRemoteObject implements Rmi_Interface {
    String[ ]Business = new String[] {"E","E","E","E","E"};							//I used arrays, placing the person's name in. Element 0 is seat 1.
    String[ ]Economy = new String[] 
    		{"E","E","E","E","E",							
    		 "E","E","E","E","E",
    		 "E","E","E","E","E",
    		 "E","E","E","E","E",
    		 "E","E","E","E","E"};
    public rsvserver() throws RemoteException {					// required to avoid the 'rmic' step, see below
        super(0);    
    }
    public String getBiz(int arrayVal) {						//returns the specific value held by the server for the Business Class.
        return Business[arrayVal];
    }
    public String getEcon(int arrayVal) {						//returns the specific value held by the server for the Economy Class.
        return Economy[arrayVal];
    }
    public String RMI_Implement(String type, String name, int seat){
    	if(seat > 0 && seat <= 30 ){								//are the seats legitimate?
        	if(type.toLowerCase().equals("business")){				//is it a business class flight?
        		if(seat<=5){										//is this seat suitable for this class?
	        		if(Business[seat-1].equals("E")){				//is the seat free?
	        			Business[seat-1] = name;					//fill the seat with the reserver's name
	        		}
	        		else{return "Failed to reserve: Seat not available";}
	        	}
        		else{return "Failed to reserve: Invalid seat number";}
        	}
        	else if(type.toLowerCase().equals("economy")){			//is it an economy class flight?
        		if(seat>=5){										//is this seat suitable for this class?
	        		if(Economy[seat-6].equals("E")){				//is the seat free?
	        			Economy[seat-6] = name;						//fill the seat with the reserver's name
	        		}
	        		else{return "Failed to reserve: Seat not available";}
	        	}
        		else{return "Failed to reserve: Invalid seat number";}

        	}
        	else{return "Failed to reserve: Invalid Flight Class type. Select 'business' or 'economy'.";}
        }
    	else{return "Failed to reserve: Invalid seat number";}
    	
    	return "Successfully reserved seat " + seat + " for passenger " + name + ".";

    }
    public static void main(String args[]) throws Exception {
        System.out.println("RMI server started");
        try { 													//special exception handler for registry creation
            LocateRegistry.createRegistry(1099); 
            System.out.println("java RMI registry created.");
        } catch (RemoteException e) { 							//do nothing, error means registry already exists
            System.out.println("java RMI registry already exists.");
        }
        rsvserver obj = new rsvserver();      				  	//Instantiate RmiServer
        Naming.rebind("//localhost/rsvserver", obj);       		// Bind this object instance to the name "rsvServer"
        System.out.println("PeerServer bound in registry");
        while(true);
    }

}
