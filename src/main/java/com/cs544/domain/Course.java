package com.cs544.domain;

public class Course {
		private long Id;
		private int courseID;
		private String description;
		public long getId() {
			return Id;
		}
		
		
		public Course() {}
		public Course(long id, int courseID, String description) {
			Id = id;
			this.courseID = courseID;
			this.description = description;
		}

		private void setId(long id) {
			Id = id;
		}
		public int getCourseID() {
			return courseID;
		}
		public void setCourseID(int courseID) {
			this.courseID = courseID;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
}
