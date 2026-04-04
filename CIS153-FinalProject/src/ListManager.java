/**
 * Final Project - Bucket List App - ListManager
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

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Scanner;


public class ListManager {
	
	// Declare Variables
	int choice;
	
	static Comparator<TravelItem> travelPriorityComparator = Comparator.comparing(TravelItem::getPriority).thenComparing(TravelItem::getTimestamp);
	static Comparator<ExperienceItem> experiencePriorityComparator = Comparator.comparing(ExperienceItem::getPriority).thenComparing(ExperienceItem::getTimestamp);
	static Comparator<PersonalGrowthItem> personalGrowthPriorityComparator = Comparator.comparing(PersonalGrowthItem::getPriority).thenComparing(PersonalGrowthItem::getTimestamp);
	
	static PriorityQueue<TravelItem> myTravelList = new PriorityQueue<TravelItem>(travelPriorityComparator);
	static PriorityQueue<ExperienceItem> myExperienceList = new PriorityQueue<ExperienceItem>(experiencePriorityComparator);
	static PriorityQueue<PersonalGrowthItem> myPersonalGrowthList = new PriorityQueue<PersonalGrowthItem>(personalGrowthPriorityComparator);
	static ArrayList<Object> completedItems = new ArrayList<>();
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void printMainMenu() {
		System.out.println("");
		System.out.println("== MAIN MENU ==");
        System.out.println("1. Add a new Bucket List Item");
        System.out.println("2. Mark a Bucket List Item as completed");
        System.out.println("3. View the next item on your Bucket List");
        System.out.println("4. Search completed Bucket List Items");
        System.out.println("5. Exit");
    }
// ***** END OF printMainMenu *****
	
	private static void printCategoryMenu() {
		System.out.println("");
		System.out.println("== CHOOSE A CATEGORY ==");
        System.out.println("1. Experience");
        System.out.println("2. Travel");
        System.out.println("3. Personal Growth");
        System.out.println("4. Exit");
    }
// ***** END OF printCategoryMenu *****
	
	public static int getIntInput(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        return input;
    }
// ***** END OF getIntInput *****
	
	public static String getStringInput(String message) {
        System.out.print(message);
        String input = scanner.next();
        scanner.nextLine(); // Consume the newline
        return input;
    }
// ***** END OF getIntInput *****
	
	public static void addBucketListItem() {
		int choice;
		do {
            printCategoryMenu();
            choice = getIntInput("Choose an option: ");
            switch (choice) {
                case 1 -> addExperienceItem();
                case 2 -> addTravelItem();
                case 3 -> addPersonalGrowthItem();
                case 4 -> System.out.println("\nReturning to Main Menu");
                default -> System.out.println("\nInvalid option. Try again.");
            }
        } while (choice != 4);
		System.out.println("");
	}
// ***** END OF addBucketListItem *****
	
	public static void MarkItemCompleted() {
		
		int choice;
		do {
			printItemsToComplete();
            choice = getIntInput("Choose an option: ");
            switch (choice) {
                case 1 -> completedItems.add(myTravelList.poll());
                case 2 -> completedItems.add(myExperienceList.poll());
                case 3 -> completedItems.add(myPersonalGrowthList.poll());
                case 4 -> System.out.println("Returning to Main Menu");
                default -> System.out.println("Invalid option. Try again.");
            }
        } while (choice != 4);
		System.out.println("");
	}
// ***** END OF MarkItemCompleted *****
	
	public static void viewNextItem() {
		System.out.println("");
		System.out.println("- THE NEXT ITEMS ON YOUR BUCKET LIST -");
		if (myTravelList.isEmpty()) {
			System.out.println("Next Travel Item: " + "** THIS LIST IS EMPTY **");
		}
		else {
			System.out.println("Next Travel Item: " + myTravelList.peek().getDescription());
		}
		if (myExperienceList.isEmpty()) {
			System.out.println("Next Experience Item: " + "** THIS LIST IS EMPTY **");
		}
		else {
			System.out.println("Next Experience Item: " + myExperienceList.peek().getDescription());
		}
		if (myPersonalGrowthList.isEmpty()) {
			System.out.println("Next Personal Growth Item: " + "** THIS LIST IS EMPTY **");
		}
		else {	
		System.out.println("Next Personal Growth Item: " + myPersonalGrowthList.peek().getDescription());
		}
	}
// ***** END OF viewNextItem *****
	
	public static void printItemsToComplete() {
		System.out.println("");
		System.out.println("- CHOOSE THE ITEM YOU HAVE COMPLETED -");
		if (myTravelList.isEmpty()) {
			System.out.println("1.  Travel: " + "** THIS LIST IS EMPTY **");
		}
		else {
			System.out.println("1. Travel: " + myTravelList.peek().getDescription());
		}
		if (myExperienceList.isEmpty()) {
			System.out.println("2. Experience: " + "** THIS LIST IS EMPTY **");
		}
		else {
			System.out.println("2. Experience: " + myExperienceList.peek().getDescription());
		}
		if (myPersonalGrowthList.isEmpty()) {
			System.out.println("3. Personal Growth: " + "** THIS LIST IS EMPTY **");
		}
		else {	
		System.out.println("3. Personal Growth: " + myPersonalGrowthList.peek().getDescription());
		}
		System.out.println("4. Exit");
	}
// ***** END OF printItemsToComplete *****
	
	public static void deleteItem() {
		//TODO;
	}
// ***** END OF deleteItem *****
	
	public static void searchCompletedItem() {
		if (!completedItems.isEmpty()) {
			System.out.println("");
			for (Object item : completedItems) {
				if (item instanceof TravelItem) {
					TravelItem tI = (TravelItem) item;
					System.out.println(tI.getCategory() + ": " + tI.getDescription());
				}
				if (item instanceof ExperienceItem) {
					ExperienceItem tI = (ExperienceItem) item;
					System.out.println(tI.getCategory() + ": " + tI.getDescription());
				}
				if (item instanceof PersonalGrowthItem) {
					PersonalGrowthItem tI = (PersonalGrowthItem) item;
					System.out.println(tI.getCategory() + ": " + tI.getDescription());
				}
			}
		}
		else {
			System.out.println("");
			System.out.println("You Have Not Completed Any Items Yet!");
		}
	}
// ***** END OF searchCompletedItem *****
	
	public static void addExperienceItem() {
		String description;
		int priority;
		description = getStringInput("Enter The Item Description: ");
		priority = getIntInput("Enter the Priority 1 - 5: ");
		if (priority < 1 || priority > 5) {
			System.out.println("Your entry is not valid.  Please try again.");
			priority = getIntInput("Enter the Priority 1 - 5: ");
		}
		myExperienceList.add(new ExperienceItem(description, priority));
	}
	
	public static void addTravelItem() {
		String description;
		int priority;
		description = getStringInput("Enter The Item Description: ");
		priority = getIntInput("Enter the Priority 1 - 5: ");
		if (priority < 1 || priority > 5) {
			System.out.println("Your entry is not valid.  Please try again.");
			priority = getIntInput("Enter the Priority 1 - 5: ");
		}
		myTravelList.add(new TravelItem(description, priority));
	}
	
	public static void addPersonalGrowthItem() {
		String description;
		int priority;
		description = getStringInput("Enter The Item Description: ");
		priority = getIntInput("Enter the Priority 1 - 5: ");
		if (priority < 1 || priority > 5) {
			System.out.println("Your entry is not valid.  Please try again.");
			priority = getIntInput("Enter the Priority 1 - 5: ");
		}
		myPersonalGrowthList.add(new PersonalGrowthItem(description, priority));
	}
	
}