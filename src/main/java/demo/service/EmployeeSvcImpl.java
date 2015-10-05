package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import demo.entity.Employee;
import demo.exception.EmployeeAlreadyExists;
import demo.repo.EmployeeDao;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeSvcImpl implements IEmployeeSvc {
	@Autowired
	EmployeeDao employeeDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@CachePut(value = "empCache1", key = "#result.eid")
	public Employee save(Employee employee) {
		if (employeeDao.exists(employee.getEid())) {
			new EmployeeAlreadyExists(employee);
		}
		return employeeDao.save(employee);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@CachePut(value = "empCache1", key = "#employee.eid")
	public Employee update(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	@Cacheable(value = "empCache1", key = "#eid")
	public Employee findById(Integer eid) {
		return employeeDao.findOne(eid);

	}

	@Override
	public Iterable<Employee> findByAll() {
		return employeeDao.findAll();

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@CacheEvict(value = "empCache1", key = "#id")
	public void delete(Integer id) {
		employeeDao.delete(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@CacheEvict(value = "empCache1", allEntries = true)
	public void deleteAll() {
		employeeDao.deleteAll();

	}

}
