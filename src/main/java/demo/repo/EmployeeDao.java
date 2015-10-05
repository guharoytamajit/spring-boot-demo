package demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import demo.entity.Employee;

@RepositoryRestResource
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

}
