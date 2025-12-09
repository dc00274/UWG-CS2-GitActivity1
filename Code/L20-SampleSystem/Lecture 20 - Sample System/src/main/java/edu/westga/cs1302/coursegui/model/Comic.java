package edu.westga.cs1302.coursegui.model;

public class Comic {
  private final String title;
  private final int issueNumber;
  
  public Comic(String title, int issueNumber) {
	  if(title == null || title.trim().isEmpty()) {
		  throw new IllegalArgumentException("Title cannot be empty.");
      }
      this.title = title;
      this.issueNumber = issueNumber;
  }
  
   public String getTitle() {
	   return title;
   }
   
   public int getIssueNumber() {
	   return issueNumber;
   }
   
   @Override
   public String toString() {
       return title + " # " + issueNumber;
   }
   
}
