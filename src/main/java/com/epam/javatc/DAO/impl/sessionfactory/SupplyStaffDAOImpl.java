package com.epam.javatc.DAO.impl.sessionfactory;

import com.epam.javatc.DAO.SupplyStaffDAO;
import com.epam.javatc.entity.SupplyStaff;
import com.epam.javatc.utils.SessionFactoryCreator;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

public class SupplyStaffDAOImpl implements SupplyStaffDAO {
    public Session session = 
        SessionFactoryCreator.getSessionFactory().openSession();
    
    @Override
    public SupplyStaff add(SupplyStaff supplyStaff) {
        session.getTransaction().begin();
        SupplyStaff supplyStaffFromDB = (SupplyStaff) session.save(supplyStaff);
        session.getTransaction().commit();
        session.close();
        return supplyStaffFromDB;
    }

    @Override
    public void delete(int id) {
        session.getTransaction().begin();
        session.delete(get(id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public SupplyStaff get(int id) {
        return (SupplyStaff) session.get(SupplyStaff.class, id);
    }

    @Override
    public void update(SupplyStaff supplyStaff) {
        session.getTransaction().begin();
        session.merge(supplyStaff);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<SupplyStaff> getAll() {
        TypedQuery<SupplyStaff> namedQuery = (TypedQuery<SupplyStaff>) session.createQuery("SupplyStaff.getAll");
        session.close();
        return namedQuery.getResultList();
    }
    
    @Override
    public List<SupplyStaff> findByName(String name) {
        String query = "SELECT s FROM SupplyStaff s JOIN s.employees em"
                + "WHERE em.name = :name";
        TypedQuery<SupplyStaff> namedQuery = (TypedQuery<SupplyStaff>) 
                session.createQuery(query);
        namedQuery.setParameter("name", name);
        //session.close();
        return namedQuery.getResultList();
    }
}
