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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ListManager {
	// Declare PriorityQueue Comparators	
	static Comparator<TravelItem> travelPriorityComparator = Comparator.comparing(TravelItem::getPriority).thenComparing(TravelItem::getTimestamp);
	static Comparator<ExperienceItem> experiencePriorityComparator = Comparator.comparing(ExperienceItem::getPriority).thenComparing(ExperienceItem::getTimestamp);
	static Comparator<PersonalGrowthItem> personalGrowthPriorityComparator = Comparator.comparing(PersonalGrowthItem::getPriority).thenComparing(PersonalGrowthItem::getTimestamp);
	// Declare PriorityQueues and ArrayList
	static PriorityQueue<TravelItem> myTravelList = new PriorityQueue<TravelItem>(travelPriorityComparator);
	static PriorityQueue<ExperienceItem> myExperienceList = new PriorityQueue<ExperienceItem>(experiencePriorityComparator);
	static PriorityQueue<PersonalGrowthItem> myPersonalGrowthList = new PriorityQueue<PersonalGrowthItem>(personalGrowthPriorityComparator);
	static ArrayList<Object> completedItems = new ArrayList<>();
	// Declare a DateTimeFormatter
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
	
	/**
	 * This method sets the completion time in the TravelItem object at the front of the myTravelList PriorityQueue
	 * then it removes the object from the PriorityQueue and adds it to the completedItems ArrayList
	 * @param - none
	 * @return - void
	 */
	public static void completeTravelItem() {
		myTravelList.peek().setCompletionTime();
		completedItems.add(ListManager.myTravelList.poll());
		return;
	}
	
	/**
	 * This method sets the completion time in the ExperienceItem object at the front of the myExperienceList PriorityQueue
	 * then it removes the object from the PriorityQueue and adds it to the completedItems ArrayList
	 * @param - none
	 * @return - void
	 */
	public static void completeExperienceItem() {
		myExperienceList.peek().setCompletionTime();
		completedItems.add(ListManager.myExperienceList.poll());
		return;
	}
	
	/**
	 * This method sets the completion time in the PersonalGrowthItem object at the front of the myPersonalGrowthList PriorityQueue
	 * then it removes the object from the PriorityQueue and adds it to the completedItems ArrayList
	 * @param - none
	 * @return - void
	 */
	public static void completePersonalGrowthItem() {
		myPersonalGrowthList.peek().setCompletionTime();
		completedItems.add(ListManager.myPersonalGrowthList.poll());
		return;
	}
	
	/**
	 * This method will use list traversal to search the completedItems ArrayList for specific element types.
	 * TravelItem objects are appended to a StringBuilder sbTravel, ExperienceItem objects are appended to a
	 * StringBuilder sbExperience and PersonalGrowthItem object are appended to a StringBuilder sbPersonalGrowth.
	 * When the traversal is complete, the 3 StringBuilders are appended to a StringBuilder with the header.
	 * @param - none
	 * @return String - categoryString is a column formatted multi-line String with headings containing all elements
	 * 					in the completedItems ArrayList 
	 */
	public static String byCategoryString() {
		StringBuilder sbAll = new StringBuilder();
		StringBuilder sbTravel = new StringBuilder();
		StringBuilder sbExperience = new StringBuilder();
		StringBuilder sbPersonalGrowth = new StringBuilder();
		String categoryString;
		// Create and format column headers
		sbAll.append(String.format("%-18s %-36s %s", " CATEGORY", "DESCRIPTION", "DATE COMPLETED\n"));
		sbAll.append("-".repeat(80) + "\n");
		// Traverse the ArrayList and concatenate the object elements to the appropriate StringBuilder based on object type
		if (!completedItems.isEmpty()) {  // If the completedItems ArrayList is empty than skip the traversal
			System.out.println("");
			for (Object item : completedItems) {
				if (item instanceof TravelItem) {
					TravelItem tI = (TravelItem) item;
					sbTravel.append(String.format("%-18s %-36s %s", " " + tI.getCategory(), tI.getDescription(), tI.getCompletionTime().format(formatter) + "\n"));
				}
				if (item instanceof ExperienceItem) {
					ExperienceItem eI = (ExperienceItem) item;
					sbExperience.append(String.format("%-18s %-36s %s", " " + eI.getCategory(), eI.getDescription(), eI.getCompletionTime().format(formatter) + "\n"));
				}
				if (item instanceof PersonalGrowthItem) {
					PersonalGrowthItem pgI = (PersonalGrowthItem) item;
					sbPersonalGrowth.append(String.format("%-18s %-36s %s", " " + pgI.getCategory(), pgI.getDescription(), pgI.getCompletionTime().format(formatter) + "\n"));
				}
			}
			sbAll.append(sbTravel);
			sbAll.append(sbExperience);
			sbAll.append(sbPersonalGrowth);
		}
		else {
			sbAll.append("\n");
			sbAll.append(String.format("%58s","You Have Not Completed Any Items Yet!\n"));
		}

		categoryString = sbAll.toString();
		return categoryString;
	}
	
	/**
	 * This method will use a queue retrieval (FIFO) to create a formatted String of all items contained
	 * in the completedItems ArrayList.  FIFO will put the oldest item completed at the beginning of the
	 * string which will but it at the top of the list.
	 * @param - none
	 * @return String - completedString is a column formatted multi-line String with headings containing all elements
	 * 					in the completedItems ArrayList 
	 */
	public static String byCompletedString() {
		StringBuilder sb = new StringBuilder();
		String completedString;
		sb.append(String.format("%-18s %-36s %s", " CATEGORY", "DESCRIPTION", "DATE COMPLETED\n"));
		sb.append("-".repeat(80) + "\n");
		// Beginning of the queue FIFO removal and concatenation to a StringBuilder sb
		if (!completedItems.isEmpty()) {  // If the completedItems ArrayList is empty than skip the queue
			System.out.println("");
			ArrayList<Object> completedItemsCopy = new ArrayList<>(completedItems);  //Create a copy of completedItems for queue removal
			while (!completedItemsCopy.isEmpty()) {
				Object item = completedItemsCopy.remove(0);  // Get and remove the object at front of the list
				if (item instanceof TravelItem) {
					TravelItem tI = (TravelItem) item;
					sb.append(String.format("%-18s %-36s %s", " " + tI.getCategory(), tI.getDescription(), tI.getCompletionTime().format(formatter) + "\n"));
				}
				if (item instanceof ExperienceItem) {
					ExperienceItem eI = (ExperienceItem) item;
					sb.append(String.format("%-18s %-36s %s", " " + eI.getCategory(), eI.getDescription(), eI.getCompletionTime().format(formatter) + "\n"));
				}
				if (item instanceof PersonalGrowthItem) {
					PersonalGrowthItem pgI = (PersonalGrowthItem) item;
					sb.append(String.format("%-18s %-36s %s", " " + pgI.getCategory(), pgI.getDescription(), pgI.getCompletionTime().format(formatter) + "\n"));
				}
			}
		}
		else {
			sb.append("\n");
			sb.append(String.format("%58s","You Have Not Completed Any Items Yet!\n"));
		}
		completedString = sb.toString();
		System.out.println(completedString);
		return completedString;
	}
	
	/**
	 * This method uses bubble sort to arrange the objects in the completedItems ArrayList alphabetically by the description attribute
	 * @param - none
	 * @return String - alphebiticalString is a column formatted multi-line String with headings containing all elements
	 * 					in the completedItems ArrayList 
	 */
	public static String byAlphebiticalString() {
		StringBuilder sb = new StringBuilder();
		String alphebiticalString;
		
		sb.append(String.format("%-18s %-36s %s", " CATEGORY", "DESCRIPTION", "DATE COMPLETED\n"));
		sb.append("-".repeat(80) + "\n");
		
		if (!completedItems.isEmpty()) {  // If the completedItems ArrayList is empty than skip the sorting process
			System.out.println("");
			ArrayList<Object> completedItemsCopy = new ArrayList<>(completedItems);  //Create a copy of completedItems for sorting
			// Beginning of nested loop to bubble sort the copied ArrayList alphabetically by the description element
			for (int i = 0; i < completedItemsCopy.size(); i++) {
	            for (int j = i + 1; j < completedItemsCopy.size(); j++) {
	                // compareTo returns > 0 if names[i] follows names[j] alphabetically
	                if ((completedItemsCopy.get(i) instanceof TravelItem) && (completedItemsCopy.get(j) instanceof TravelItem)) {
	                	TravelItem tIi = (TravelItem) completedItemsCopy.get(i);
	                	TravelItem tIj = (TravelItem) completedItemsCopy.get(j);
						if (tIi.getDescription().compareTo(tIj.getDescription()) > 0) {   // compareTo returns > 0 if description(i) follows description(j) alphabetically
		                    // Manual Swap
		                    Object temp = completedItemsCopy.get(i);
		                    completedItemsCopy.set(i, completedItemsCopy.get(j));
		                    completedItemsCopy.set(j, temp);
						}
	                }
	                if ((completedItemsCopy.get(i) instanceof TravelItem) && (completedItemsCopy.get(j) instanceof ExperienceItem)) {
	                	TravelItem tIi = (TravelItem) completedItemsCopy.get(i);
	                	ExperienceItem eIj = (ExperienceItem) completedItemsCopy.get(j);
						if (tIi.getDescription().compareTo(eIj.getDescription()) > 0) {
	                    // Manual Swap
	                    Object temp = completedItemsCopy.get(i);
	                    completedItemsCopy.set(i, completedItemsCopy.get(j));
	                    completedItemsCopy.set(j, temp);
						}
	                }
	                if ((completedItemsCopy.get(i) instanceof TravelItem) && (completedItemsCopy.get(j) instanceof PersonalGrowthItem)) {
	                	TravelItem tIi = (TravelItem) completedItemsCopy.get(i);
	                	PersonalGrowthItem pgIj = (PersonalGrowthItem) completedItemsCopy.get(j);
						if (tIi.getDescription().compareTo(pgIj.getDescription()) > 0) {
	                    // Manual Swap
	                    Object temp = completedItemsCopy.get(i);
	                    completedItemsCopy.set(i, completedItemsCopy.get(j));
	                    completedItemsCopy.set(j, temp);
						}
	                }
	                if ((completedItemsCopy.get(i) instanceof PersonalGrowthItem) && (completedItemsCopy.get(j) instanceof PersonalGrowthItem)) {
	                	PersonalGrowthItem pgIi = (PersonalGrowthItem) completedItemsCopy.get(i);
	                	PersonalGrowthItem pgIj = (PersonalGrowthItem) completedItemsCopy.get(j);
						if (pgIi.getDescription().compareTo(pgIj.getDescription()) > 0) {
	                    // Manual Swap
	                    Object temp = completedItemsCopy.get(i);
	                    completedItemsCopy.set(i, completedItemsCopy.get(j));
	                    completedItemsCopy.set(j, temp);
						}
	                }
	                if ((completedItemsCopy.get(i) instanceof PersonalGrowthItem) && (completedItemsCopy.get(j) instanceof TravelItem)) {
	                	PersonalGrowthItem pgIi = (PersonalGrowthItem) completedItemsCopy.get(i);
	                	TravelItem tIj = (TravelItem) completedItemsCopy.get(j);
						if (pgIi.getDescription().compareTo(tIj.getDescription()) > 0) {
	                    // Manual Swap
	                    Object temp = completedItemsCopy.get(i);
	                    completedItemsCopy.set(i, completedItemsCopy.get(j));
	                    completedItemsCopy.set(j, temp);
						}
	                }
	                if ((completedItemsCopy.get(i) instanceof PersonalGrowthItem) && (completedItemsCopy.get(j) instanceof ExperienceItem)) {
	                	PersonalGrowthItem pgIi = (PersonalGrowthItem) completedItemsCopy.get(i);
	                	ExperienceItem eIj = (ExperienceItem) completedItemsCopy.get(j);
						if (pgIi.getDescription().compareTo(eIj.getDescription()) > 0) {
	                    // Manual Swap
	                    Object temp = completedItemsCopy.get(i);
	                    completedItemsCopy.set(i, completedItemsCopy.get(j));
	                    completedItemsCopy.set(j, temp);
						}
	                }
	                if ((completedItemsCopy.get(i) instanceof ExperienceItem) && (completedItemsCopy.get(j) instanceof ExperienceItem)) {
	                	ExperienceItem eIi = (ExperienceItem) completedItemsCopy.get(i);
	                	ExperienceItem eIj = (ExperienceItem) completedItemsCopy.get(j);
						if (eIi.getDescription().compareTo(eIj.getDescription()) > 0) {
	                    // Manual Swap
	                    Object temp = completedItemsCopy.get(i);
	                    completedItemsCopy.set(i, completedItemsCopy.get(j));
	                    completedItemsCopy.set(j, temp);
						}
	                }
	                if ((completedItemsCopy.get(i) instanceof ExperienceItem) && (completedItemsCopy.get(j) instanceof TravelItem)) {
	                	ExperienceItem eIi = (ExperienceItem) completedItemsCopy.get(i);
	                	TravelItem tIj = (TravelItem) completedItemsCopy.get(j);
						if (eIi.getDescription().compareTo(tIj.getDescription()) > 0) {
	                    // Manual Swap
	                    Object temp = completedItemsCopy.get(i);
	                    completedItemsCopy.set(i, completedItemsCopy.get(j));
	                    completedItemsCopy.set(j, temp);
						}
	                }
	                if ((completedItemsCopy.get(i) instanceof ExperienceItem) && (completedItemsCopy.get(j) instanceof PersonalGrowthItem)) {
	                	ExperienceItem eIi = (ExperienceItem) completedItemsCopy.get(i);
	                	PersonalGrowthItem pgIj = (PersonalGrowthItem) completedItemsCopy.get(j);
						if (eIi.getDescription().compareTo(pgIj.getDescription()) > 0) {
	                    // Manual Swap
	                    Object temp = completedItemsCopy.get(i);
	                    completedItemsCopy.set(i, completedItemsCopy.get(j));
	                    completedItemsCopy.set(j, temp);
						}
	                }
	            }
			}
			// End of the Bubble Sort nested loop
			// Traverse the newly sorted list and concatenate the object elements to a StringBuilder sb
			if (!completedItemsCopy.isEmpty()) {
				System.out.println("");
				for (Object item : completedItemsCopy) {
					if (item instanceof TravelItem) {
						TravelItem tI = (TravelItem) item;
						sb.append(String.format("%-18s %-36s %s", " " + tI.getCategory(), tI.getDescription(), tI.getCompletionTime().format(formatter) + "\n"));
					}
					if (item instanceof ExperienceItem) {
						ExperienceItem eI = (ExperienceItem) item;
						sb.append(String.format("%-18s %-36s %s", " " + eI.getCategory(), eI.getDescription(), eI.getCompletionTime().format(formatter) + "\n"));
					}
					if (item instanceof PersonalGrowthItem) {
						PersonalGrowthItem pgI = (PersonalGrowthItem) item;
						sb.append(String.format("%-18s %-36s %s", " " + pgI.getCategory(), pgI.getDescription(), pgI.getCompletionTime().format(formatter) + "\n"));
					}
				}
			}
		}
		else {
			sb.append("\n");
			sb.append(String.format("%58s","You Have Not Completed Any Items Yet!\n"));
		}
		alphebiticalString = sb.toString();
		return alphebiticalString;
	}

}