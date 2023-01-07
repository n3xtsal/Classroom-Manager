package ca.sheridancollege.chomuham.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.chomuham.beans.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
	
}
