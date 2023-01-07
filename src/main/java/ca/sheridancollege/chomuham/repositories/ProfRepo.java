package ca.sheridancollege.chomuham.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.chomuham.beans.Professor;

@Repository
public interface ProfRepo extends JpaRepository<Professor, Long> {

}
