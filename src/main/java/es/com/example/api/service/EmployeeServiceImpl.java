package es.com.example.api.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import es.com.example.api.dao.EmployeeRepository;
import es.com.example.api.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employee;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employee) {
		this.employee = employee;
	}
	
	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employee.findAll();
	}

	@Override
	public Employee getEmployeID(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> findById = employee.findById(id);
		
		Employee tempEmployee = null;
		
		if(findById.isPresent()) {
			tempEmployee = findById.get();
		} else {
			throw new RuntimeException("Did not find employee id - " + id);
		}
		
		return tempEmployee;
	}

	@Override
	public void save(Employee employee) {
		
		this.employee.save(employee);

	}

	@Override
	public void delete(int id) {
		
		this.employee.deleteById(id);

	}

	

}
