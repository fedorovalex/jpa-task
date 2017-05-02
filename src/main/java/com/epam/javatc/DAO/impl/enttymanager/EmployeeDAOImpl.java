
package com.epam.javatc.DAO.impl.enttymanager;

import com.epam.javatc.DAO.EmployeeDAO;
import com.epam.javatc.entity.Employee;
import com.epam.javatc.utils.EntityManagerFactoryCreator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class EmployeeDAOImpl implements EmployeeDAO{

    public EntityManager em = 
            EntityManagerFactoryCreator.getEntityManagerFactory().createEntityManager();
    
    @Override
    public Employee add(Employee employee) {
        em.getTransaction().begin();
        Employee employeeFromDB = em.merge(employee);
        em.getTransaction().commit();
        return employeeFromDB;
    }

    @Override
    public void delete(int id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    @Override
    public Employee get(int id) {
        return em.find(Employee.class, id);
    }

    @Override
    public void update(Employee employee) {
        em.getTransaction().begin();
        em.merge(employee);
        em.getTransaction().commit();
    }

    @Override
    public List<Employee> getAll() {
        TypedQuery<Employee> namedQuery = em.createNamedQuery("Employee.getAll", Employee.class);
        return namedQuery.getResultList();
    }
    
    public List<Employee> findByNamePart(String namePart){
        String query = "SELECT em FROM Employee em WHERE em.name LIKE '%:substr%'";
        TypedQuery<Employee> namedQuery = em.createNamedQuery(query, Employee.class);
        namedQuery.setParameter("substr", namePart);
        return namedQuery.getResultList();
    }
}
