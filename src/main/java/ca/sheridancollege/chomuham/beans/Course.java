package ca.sheridancollege.chomuham.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String code;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinTable(name="COURSE_PROF")
	private Professor prof;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="COURSE_STUDENTS")
	private List<Student> students;
}
