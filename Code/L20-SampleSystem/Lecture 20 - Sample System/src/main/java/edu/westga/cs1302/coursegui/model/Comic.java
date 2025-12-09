/*
 * 
 */
package edu.westga.cs1302.coursegui.model;

/**
 * The Class Comic.
 * @version 2025
 * @author Dillan
 */
public class Comic {
  private final String title;
  private final int issueNumber;
  
  /**
   * Instantiates a new comic.
   *
   * @param title the title
   * @param issueNumber the issue number
   */
  public Comic(String title, int issueNumber) {
	  if (title == null || title.trim().isEmpty()) {
		  throw new IllegalArgumentException("Title cannot be empty.");
      }
      this.title = title;
      this.issueNumber = issueNumber;
  }
  
   /**
    * Gets the title.
    *
    * @return the title
    */
   public String getTitle() {
	   return this.title;
   }
   
   /**
    * Gets the issue number.
    *
    * @return the issue number
    */
   public int getIssueNumber() {
	   return this.issueNumber;
   }
   
   @Override
   public String toString() {
       return this.title + " # " + this.issueNumber;
   }
   
}
