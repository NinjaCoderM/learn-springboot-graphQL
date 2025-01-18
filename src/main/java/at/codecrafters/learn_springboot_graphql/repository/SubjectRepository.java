package at.codecrafters.learn_springboot_graphql.repository;

import at.codecrafters.learn_springboot_graphql.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
