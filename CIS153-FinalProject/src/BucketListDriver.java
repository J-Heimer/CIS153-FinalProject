/**
 * Final Project - Bucket List App - BucketListDriver
 * @author	Jon Heimer
 * @version 1.0
 * @since	1.0
 */
/*  
* OS: Windows 10 Pro
* IDE: Eclipse IDE 4.32.0
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified, nor used generative AI as a final draft. 
* I have not given other fellow student(s) access to my program.
*/

import java.util.Scanner;

public class BucketListDriver {
	
    static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Declare Variables
		int choice;
		
		// Add Fictional Items For Test Purposes
		ListManager.myExperienceList.add(new ExperienceItem("Great White shark cage dive", 3));
		ListManager.myTravelList.add(new TravelItem("Alaska", 3));
		ListManager.myPersonalGrowthList.add(new PersonalGrowthItem("Learn to speak Spanish", 3));
		ListManager.myExperienceList.add(new ExperienceItem("Metalica Concert", 2));
		ListManager.myTravelList.add(new TravelItem("Australia", 2));
		ListManager.myPersonalGrowthList.add(new PersonalGrowthItem("Learn Java software programming", 2));
		
		do {
            ListManager.printMainMenu();
            choice = ListManager.getIntInput("Choose an option: ");
            switch (choice) {
                case 1 -> ListManager.addBucketListItem();
                case 2 -> ListManager.MarkItemCompleted();
                case 3 -> ListManager.viewNextItem();
                case 4 -> ListManager.searchCompletedItem();
                case 5 -> System.out.println("\nGoodbye!");
                default -> System.out.println("\nInvalid option. Try again.");
            }
        } while (choice != 5);
		
    }
// ***** END OF main *****		
}
