package com.epam.javatc.DAO.impl.sessionfactory;

import com.epam.javatc.DAO.RegionDAO;
import com.epam.javatc.entity.Region;
import com.epam.javatc.utils.SessionFactoryCreator;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

public class RegionDAOImpl implements RegionDAO{
    public Session session = 
        SessionFactoryCreator.getSessionFactory().openSession();
    
    @Override
    public Region add(Region region) {
        session.getTransaction().begin();
        Region regionFromDB = (Region) session.save(region);
        session.getTransaction().commit();
        session.close();
        return regionFromDB;
    }

    @Override
    public void delete(int id) {
        session.getTransaction().begin();
        session.delete(get(id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Region get(int id) {
        return (Region) session.get(Region.class, id);
    }

    @Override
    public void update(Region region) {
        session.getTransaction().begin();
        session.merge(region);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Region> getAll() {
        TypedQuery<Region> namedQuery = (TypedQuery<Region>) session.createQuery("Region.getAll");
        session.close();
        return namedQuery.getResultList();
    }
}
