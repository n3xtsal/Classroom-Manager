package ca.sheridancollege.chomuham.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

//This is a wrapper class
public class ProfessorCourse {
	private Professor prof;
	private Course course;
}
