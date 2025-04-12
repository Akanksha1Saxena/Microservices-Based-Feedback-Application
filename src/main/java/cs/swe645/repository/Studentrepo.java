package cs.swe645.repository;
import cs.swe645.model.Survey;

import org.springframework.data.jpa.repository.JpaRepository;



public interface Studentrepo extends JpaRepository<Survey, Long> {
    // Custom query methods can be defined here if needed
} 