# Final
Final exam for SDEV200

# Details
The final exam for SDEV200 is a debugging exercise for a java application that _"allows the user to create an `ArrayList` that contains a list of states"_ and ensures that there is _"only one entry per state in the list"_. 
Based on these instructions, I have decided to refactor the program alongside debugging the logic & syntax errors. Due to this, I will provide the orginial code and a brief description of its errors and then the updated code for comparison below.

# Previous Code
## Issues
**File Structure**
- The project folder name is `CollectionStoreStrings2` while the package name is `stringCollections` and the main class is called `TestStoreStrings`; this does not align with java conventions.
- The class with the main method is not in the project package, which violates common convention.
- The instructions listed above state that a user creates the `ArrayList`, but there is no functionality for user input.
  
**In StoreStrings.java**
- The package name `stringCollections` doesn't match the package name.
- The class contains a method: `public static int count(ArrayList<Integer> words)` that tries to iterate over the ArrayList `words` by String values instead of integer values.
- In the `duplicateString` method, the variable `isDuplicateString` is incorrectly intialized with an uppercase "False" when it should be a lowercase "false" per java syntax.
- The `ArrayList` in the `duplicateString` method is declared incorrectly. It should be `ArrayList<String> items = new ArrayList<>();` instead.
- Again, the boolean value is incorrectly capitilized and thus returns an invalid value.

**In TestStoreStrings.java**
- In the main method, the `ArrayList` is incorrectly declared both with syntax and logic errors. The corrected line should be `ArrayList<String> states = new ArrayList<>();`. The following values added are strings, not integers.
- There are missing semicolons after `states.add("New York")` and `System.out.println(state)`.
- The error message will always display because the `ArrayList` contains two "Indiana" entries, unless one is removed.
- The application prints out the number of states entered, but this seems unnecessary based on the instructions provided.

### StoreStrings.java
```java
package stringCollections;

import java.util.ArrayList;

public class StoreStrings {
	
	public static int count(ArrayList <Integer> words)
    {
        int lSize = 0;
        for(String i : words)
        {
            lSize++;
        }   
		return lSize;
    }
	
	public static boolean duplicateString(ArrayList <String> words) {
		boolean isDuplicateString = False;
		
		ArrayList<> items = new ArrayList<String>();
		
        for(String word : words)
        {
            if (items.contains(word)) {
            	isDuplicateString = True;
            }else {
            	items.add(word);
            }
        }
		return isDuplicateString;
	}
}
```

### TestStoreStrings.java
```java
import java.util.ArrayList;
import stringsCollections.StoreStrings;

public class TestStoreStrings {

	public static void main(String[] args) {
		ArrayList<> states = new ArrayList<Integer>();
		states.add("Virginia");
		states.add("New York")
		states.add("Michigan");
		states.add("Indiana");
		states.add("Missouri");
		states.add("Indiana");
		
		states.sort(null);
		
		for(String state:states) {
			System.out.println(state)
		}
		
		if (StoreStrings.duplicateString(states)) {
			System.out.println("Error! Contains more than one entry of the same state in the list. Must have only one entry for the state in the list");
		} else {
			System.out.println(StoreStrings.count(states));
		}
	}
}
```

# Updated Code
In the files below, you will see comments that explain the logic used.

## Changes
- The project has been renamed to `StateArrayList` to more accurately reflect the application's functionality.
- The class that holds the main method matches the project's name.
- Each class is held within the package.
- In the class `CreateStateArrayList`, functionality for user input is implemented to align with the instructions provided.
- A class named `ValidStates` is introduced to ensure user's only enter valid states.
- The program terminates after five unique and valid states are entered (utilized for simplicity).
- The application allows for variations on entered state names, handling lowercase entries by capitilizing the first letter (could use more, but seemed most common entry would be all lowercase or first letter capitilized).
- The prompts for invalid or duplicated states are clear for users.
- The final output of the states entered is clear and concise.
- The project now incorporates principles of modularity that enhances maintainability and scalability.
  
### StateArrayList.java
```java
package statearraylist;

import java.util.ArrayList;

public class StateArrayList {
    // pretty main method with one line >:)
    public static void main(String[] args) {
        // create an array list obj called states by calling the class and method
        ArrayList<String> states = CreateStateArray.createAndVerify();
    } 
}
```

### CreateStateArrayList.java
```java
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
```
### ValidStates.java
```java
package statearraylist;

import java.util.Arrays;
import java.util.List;

public class ValidStates {
    public static List<String> getValidStates() {
        // method to return list of valid states 
         return Arrays.asList(
                "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado",
                "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho",
                "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana",
                "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota",
                "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada",
                "New Hampshire", "New Jersey", "New Mexico", "New York",
                "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon",
                "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
                "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington",
                "West Virginia", "Wisconsin", "Wyoming"
        );
    }
}
```


