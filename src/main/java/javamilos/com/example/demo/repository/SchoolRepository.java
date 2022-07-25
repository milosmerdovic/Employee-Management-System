package javamilos.com.example.demo.repository;

import javamilos.com.example.demo.entity.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends CrudRepository<School,Long>{

}
