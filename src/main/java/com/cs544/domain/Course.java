package com.cs544.domain;

import javax.persistence.*;

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

	@Override
	public String toString() {
		return "Course{" +
				"Id=" + Id +
				", courseID='" + courseID + '\'' +
				", description='" + description + '\'' +
				'}';
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
