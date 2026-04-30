/**
 * Final Project - Bucket List App - TestBlDriver
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

public class BucketListDriver {
	
	public static void main(String[] args) {
		
		// Add Fictional Items For Test Purposes
		ListManager.myTravelList.add(new TravelItem("Alaska", 4));
		ListManager.myExperienceList.add(new ExperienceItem("Great White Shark Cage Dive", 3));
		ListManager.myPersonalGrowthList.add(new PersonalGrowthItem("Learn To Speak Spanish", 3));
		ListManager.myTravelList.add(new TravelItem("Australia", 2));
		ListManager.myExperienceList.add(new ExperienceItem("Metalica Concert", 2));
		ListManager.myPersonalGrowthList.add(new PersonalGrowthItem("Learn Java Software Programming", 4));
		ListManager.myTravelList.add(new TravelItem("Brazil", 3));
		ListManager.myExperienceList.add(new ExperienceItem("Sky Diving", 4));
		ListManager.myPersonalGrowthList.add(new PersonalGrowthItem("Learn To Play The Guitar", 2));

// FICTIONAL LIST FOR ALPHABETICAL SORT TESTING - UNCOMMENT TO USE
/*
		// Add Fictional Items specifically for testing the alphabetical sort
		// Include a time "pause" between each add() so the comparator has a clear time difference for sorting
		ListManager.myTravelList.add(new TravelItem("A", 1));
		try {
		    Thread.sleep(100); // Pauses for 100 milliseconds (.1 second)
		} catch (InterruptedException e) {
		    // Handle the exception if the sleep is interrupted
		    Thread.currentThread().interrupt();
		}
		ListManager.myExperienceList.add(new ExperienceItem("B", 1));
		try {
		    Thread.sleep(100); // Pauses for 100 milliseconds (.1 second)
		} catch (InterruptedException e) {
		    // Handle the exception if the sleep is interrupted
		    Thread.currentThread().interrupt();
		}
		ListManager.myPersonalGrowthList.add(new PersonalGrowthItem("C", 1));
		try {
		    Thread.sleep(100); // Pauses for 100 milliseconds (.1 second)
		} catch (InterruptedException e) {
		    // Handle the exception if the sleep is interrupted
		    Thread.currentThread().interrupt();
		}
		ListManager.myTravelList.add(new TravelItem("D", 1));
		try {
		    Thread.sleep(100); // Pauses for 100 milliseconds (.1 second)
		} catch (InterruptedException e) {
		    // Handle the exception if the sleep is interrupted
		    Thread.currentThread().interrupt();
		}
		ListManager.myExperienceList.add(new ExperienceItem("E", 1));
		try {
		    Thread.sleep(100); // Pauses for 100 milliseconds (.1 second)
		} catch (InterruptedException e) {
		    // Handle the exception if the sleep is interrupted
		    Thread.currentThread().interrupt();
		}
		ListManager.myPersonalGrowthList.add(new PersonalGrowthItem("F", 1));
		try {
		    Thread.sleep(100); // Pauses for 100 milliseconds (.1 second)
		} catch (InterruptedException e) {
		    // Handle the exception if the sleep is interrupted
		    Thread.currentThread().interrupt();
		}
		ListManager.myTravelList.add(new TravelItem("G", 1));
		try {
		    Thread.sleep(100); // Pauses for 100 milliseconds (.1 second)
		} catch (InterruptedException e) {
		    // Handle the exception if the sleep is interrupted
		    Thread.currentThread().interrupt();
		}
		ListManager.myExperienceList.add(new ExperienceItem("H", 1));
		try {
		    Thread.sleep(100); // Pauses for 100 milliseconds (.1 second)
		} catch (InterruptedException e) {
		    // Handle the exception if the sleep is interrupted
		    Thread.currentThread().interrupt();
		}
		ListManager.myPersonalGrowthList.add(new PersonalGrowthItem("I", 1));
		try {
		    Thread.sleep(100); // Pauses for 100 milliseconds (.1 second)
		} catch (InterruptedException e) {
		    // Handle the exception if the sleep is interrupted
		    Thread.currentThread().interrupt();
		}
		ListManager.myTravelList.add(new TravelItem("J", 1));
		try {
		    Thread.sleep(100); // Pauses for 100 milliseconds (.1 second)
		} catch (InterruptedException e) {
		    // Handle the exception if the sleep is interrupted
		    Thread.currentThread().interrupt();
		}
		ListManager.myExperienceList.add(new ExperienceItem("K", 1));
		try {
		    Thread.sleep(100); // Pauses for 100 milliseconds (.1 second)
		} catch (InterruptedException e) {
		    // Handle the exception if the sleep is interrupted
		    Thread.currentThread().interrupt();
		}
		ListManager.myPersonalGrowthList.add(new PersonalGrowthItem("L", 1));
*/		
		
		new MainFrame();	
    }		
}
