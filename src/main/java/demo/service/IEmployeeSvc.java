package demo.service;

import demo.entity.Employee;

public interface IEmployeeSvc {
	public Employee save(Employee employee);

	public Employee update(Employee employee);

	public Employee findById(Integer eid);

	Iterable<Employee> findByAll();

	void deleteAll();

	void delete(Integer id);

}
