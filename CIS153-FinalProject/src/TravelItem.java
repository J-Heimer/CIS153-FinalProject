/**
 * Final Project - Bucket List App - TravelItem Class
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

import java.time.LocalDateTime;

public class TravelItem {
	// Members
	private String category;
	private String description;
	private int priority;
	private LocalDateTime timestamp;
	private LocalDateTime completionTime;

	//Constructors
	public TravelItem() {
		setCategory("Travel");
		setDescription("EMPTY");
		setPriority(5);
		setTimestamp();
	}
	
	public TravelItem(String desc, int pri) {
		setCategory("Travel");
		setDescription(desc);
		setPriority(pri);
		setTimestamp();
	}

	// Setters and Getters
	/**
	 * @return String category
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * This method is private and can only be accessed by the constructor
	 * @param String category
	 */
	private void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * @return String description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param String description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return int priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param int priority
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * @return LocalDateTime timestamp
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	/**
	 * @param LocalDateTime timestamp
	 */
	public void setTimestamp() {
		this.timestamp = LocalDateTime.now();
	}
	
	/**
	 * @return LocalDateTime completionTime
	 */
	public LocalDateTime getCompletionTime() {
		return completionTime;
	}

	/**
	 * @param LocalDateTime completionTime
	 */
	public void setCompletionTime() {
		this.completionTime = LocalDateTime.now();
	}

}