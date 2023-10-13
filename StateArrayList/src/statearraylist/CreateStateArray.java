
package statearraylist;

// imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateStateArray {
    public static ArrayList<String> createAndVerify() {
        
        // create a list obj that gets the valid states from valid class/method
        List<String> validStates = ValidStates.getValidStates();
        
        // create an array list obj and assign 
        ArrayList<String> states = new ArrayList<>();
        //create a scanner obj for user input and assign
        Scanner input = new Scanner(System.in);
        
        
        // only take input until 5 states is reached
        while (states.size() < 5) {
            System.out.print("Enter a state: ");
            // assign state var to input and also trim whitespace
            String state = input.nextLine().trim(); 
            
            // capitilize first letter in input so capitlization doesnt matter
            String stateCapitilized = state.substring(0,1).toUpperCase() + state.substring(1);
            
            // first make sure the input is a valid state
            if (!validStates.contains(stateCapitilized)) {
                // prompt user to enter valid state if so
                System.out.println("Invalid state name. Please enter a valid state.");
              // make sure there aren't duplicate entries
            } else if (states.contains(stateCapitilized)) {
                // prompt user to enter a diff state if so
                System.out.println("State has already been entered. Please enter a different state.");
            } else {
                // add the state to the array list
                states.add(stateCapitilized);
            }
            
            // once the list is full print out the list
            if (states.size() == 5) {
                System.out.println("List of states entered: ");
                states.forEach((String s) -> {
                    System.out.println(s);
                });
            }
        }
        // return the list
        return states;    
    }
    
}
