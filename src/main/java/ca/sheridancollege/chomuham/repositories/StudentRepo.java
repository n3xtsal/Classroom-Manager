package ca.sheridancollege.chomuham.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.chomuham.beans.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

}
