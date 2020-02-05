package com.cs544.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Course {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long Id;
		private String courseID;
		@Lob
		private String description;
		public long getId() {
			return Id;
		}
						
		public Course() {}
		public Course(long id, String courseID, String description) {
			Id = id;
			this.courseID = courseID;
			this.description = description;
		}

		private void setId(long id) {
			Id = id;
		}
		public String getCourseID() {
			return courseID;
		}
		public void setCourseID(String courseID) {
			this.courseID = courseID;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
}
