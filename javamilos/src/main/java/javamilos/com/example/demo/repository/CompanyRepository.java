package javamilos.com.example.demo.repository;

import javamilos.com.example.demo.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company,Long>{

}
