
package com.epam.javatc.DAO;

import com.epam.javatc.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    public Employee add(Employee employee);
    
    public void delete(int id);
    
    public Employee get(int id);
    
    public void update(Employee employee);
    
    public List<Employee> getAll();
    
    public List<Employee> findByNamePart(String namePart);
}