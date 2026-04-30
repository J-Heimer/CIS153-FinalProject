/**
 * Final Project - Bucket List App - JUnit Test
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

import static org.junit.jupiter.api.Assertions.*;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;

class BucketListTest {
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");

	@Test
	void byCompletedStringEmpty() {
		// ARRANGE
		ListManager.completedItems.clear();
		String expected = """ 
			 CATEGORY          DESCRIPTION                          DATE COMPLETED
			--------------------------------------------------------------------------------

	                      You Have Not Completed Any Items Yet!
			""";
		// ACT
		String actual = ListManager.byCompletedString();
		// ASSERT
		assertEquals(expected, actual);
	}
	
	@Test
	void byCategoryStringEmpty() {
		// ARRANGE
		ListManager.completedItems.clear();
		String expected = """ 
			 CATEGORY          DESCRIPTION                          DATE COMPLETED
			--------------------------------------------------------------------------------

	                      You Have Not Completed Any Items Yet!
			""";
		// ACT
		String actual = ListManager.byCategoryString();
		// ASSERT
		assertEquals(expected, actual);
	}
	
	@Test
	void byAlphabeticalStringEmpty() {
		// ARRANGE
		ListManager.completedItems.clear();
		String expected = """ 
			 CATEGORY          DESCRIPTION                          DATE COMPLETED
			--------------------------------------------------------------------------------

	                      You Have Not Completed Any Items Yet!
			""";
		// ACT
		String actual = ListManager.byAlphebiticalString();
		// ASSERT
		assertEquals(expected, actual);
	}
	
	@Test
	void byAlphabeticalString() {
		// ARRANGE
		ListManager.completedItems.add(new PersonalGrowthItem("B", 1)); // Add description "B" first
		ListManager.completedItems.add(new ExperienceItem("A", 1)); // Add description "A" second
		ListManager.completedItems.add(new TravelItem("C", 1));  // Add description "C" third
		PersonalGrowthItem pgI = (PersonalGrowthItem) ListManager.completedItems.get(0);
		ExperienceItem eI = (ExperienceItem) ListManager.completedItems.get(1);
		TravelItem tI = (TravelItem) ListManager.completedItems.get(2);
		pgI.setCompletionTime();
		eI.setCompletionTime();
		tI.setCompletionTime();
		String personalGrowthTime = pgI.getCompletionTime().format(formatter);
		String experienceTime = eI.getCompletionTime().format(formatter);
		String travelTime = tI.getCompletionTime().format(formatter);
		// Expected output is description "A" will be first
		String expected = """ 
			 CATEGORY          DESCRIPTION                          DATE COMPLETED
			--------------------------------------------------------------------------------
			 Experience        A                                    %s
			 Personal Growth   B                                    %s
			 Travel            C                                    %s
			 """.formatted(experienceTime, personalGrowthTime, travelTime);
		// ACT
		System.out.println(expected);
		String actual = ListManager.byAlphebiticalString();
		// ASSERT
		assertEquals(expected, actual);
		ListManager.completedItems.clear();
	}
	
	@Test
	void byCompletedString() {
		// ARRANGE
		ListManager.completedItems.add(new PersonalGrowthItem("B", 1)); // Add description "B" first
		ListManager.completedItems.add(new ExperienceItem("A", 1)); // Add description "A" second
		ListManager.completedItems.add(new TravelItem("C", 1));  // Add description "C" third
		PersonalGrowthItem pgI = (PersonalGrowthItem) ListManager.completedItems.get(0);
		ExperienceItem eI = (ExperienceItem) ListManager.completedItems.get(1);
		TravelItem tI = (TravelItem) ListManager.completedItems.get(2);
		pgI.setCompletionTime();
		eI.setCompletionTime();
		tI.setCompletionTime();
		String personalGrowthTime = pgI.getCompletionTime().format(formatter);
		String experienceTime = eI.getCompletionTime().format(formatter);
		String travelTime = tI.getCompletionTime().format(formatter);
		// Expected output is description "B" will be first
		String expected = """ 
			 CATEGORY          DESCRIPTION                          DATE COMPLETED
			--------------------------------------------------------------------------------
			 Personal Growth   B                                    %s
			 Experience        A                                    %s
			 Travel            C                                    %s
			 """.formatted(personalGrowthTime, experienceTime, travelTime);
		// ACT
		System.out.println(expected);
		String actual = ListManager.byCompletedString();
		// ASSERT
		assertEquals(expected, actual);
		ListManager.completedItems.clear();
	}
	
	@Test
	void byCategoryString() {
		// ARRANGE
		ListManager.completedItems.add(new PersonalGrowthItem("B", 1)); // Add description "B" first
		ListManager.completedItems.add(new ExperienceItem("A", 1)); // Add description "A" second
		ListManager.completedItems.add(new TravelItem("C", 1));  // Add description "C" third
		PersonalGrowthItem pgI = (PersonalGrowthItem) ListManager.completedItems.get(0);
		ExperienceItem eI = (ExperienceItem) ListManager.completedItems.get(1);
		TravelItem tI = (TravelItem) ListManager.completedItems.get(2);
		pgI.setCompletionTime();
		eI.setCompletionTime();
		tI.setCompletionTime();
		String personalGrowthTime = pgI.getCompletionTime().format(formatter);
		String experienceTime = eI.getCompletionTime().format(formatter);
		String travelTime = tI.getCompletionTime().format(formatter);
		// Expected output is description "C" will be first
		String expected = """ 
			 CATEGORY          DESCRIPTION                          DATE COMPLETED
			--------------------------------------------------------------------------------
			 Travel            C                                    %s
			 Experience        A                                    %s
			 Personal Growth   B                                    %s
			 """.formatted(travelTime, experienceTime, personalGrowthTime);
		// ACT
		System.out.println(expected);
		String actual = ListManager.byCategoryString();
		// ASSERT
		assertEquals(expected, actual);
		ListManager.completedItems.clear();
	}

}
