
package com.epam.javatc.DAO.impl.sessionfactory;

import com.epam.javatc.DAO.EmployeeDAO;
import com.epam.javatc.entity.Employee;
import com.epam.javatc.utils.HibernateSessionFactory;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class EmployeeDAOImpl implements EmployeeDAO {
    
    public SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
            //SessionFactoryCreator.getSessionFactory().openSession();
    
    @Override
    public Employee add(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.getTransaction();
        tr.begin();
        session.save(employee);
        tr.commit();
        session.close();
        return null;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(get(id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Employee get(int id) {
        Session session = sessionFactory.openSession();
        return (Employee) session.get(Employee.class, id);
    }

    @Override
    public void update(Employee employee) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.merge(employee);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Employee> getAll() {
        Session session = sessionFactory.openSession();
        TypedQuery<Employee> namedQuery =
                (TypedQuery<Employee>) session.createQuery("Employee.getAll");
        return namedQuery.getResultList();
    }
    
    @Override
    public List<Employee> findByNamePart(String namePart) {
        Session session = sessionFactory.openSession();
        String query = "SELECT em FROM Employee em WHERE em.name LIKE '%:substr%'";
        TypedQuery<Employee> namedQuery =
                (TypedQuery<Employee>) session.createQuery(query);
        namedQuery.setParameter("substr", namePart);
        return namedQuery.getResultList();
    }
}
