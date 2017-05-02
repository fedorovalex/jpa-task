package com.epam.javatc.DAO.impl.sessionfactory;

import com.epam.javatc.DAO.AdressDAO;
import com.epam.javatc.entity.Adress;
import com.epam.javatc.utils.SessionFactoryCreator;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

public class AdressDAOImpl implements AdressDAO {
    public Session session = 
        SessionFactoryCreator.getSessionFactory().openSession();
    
    @Override
    public Adress add(Adress adress) {
        session.getTransaction().begin();
        Adress adressFromDB = (Adress) session.save(adress);
        session.getTransaction().commit();
        session.close();
        return adressFromDB;
    }

    @Override
    public void delete(int id) {
        session.getTransaction().begin();
        session.delete(get(id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Adress get(int id) {
        return (Adress) session.get(Adress.class, id);
    }

    @Override
    public void update(Adress adress) {
        session.getTransaction().begin();
        session.merge(adress);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Adress> getAll() {
        TypedQuery<Adress> namedQuery = (TypedQuery<Adress>) session.createQuery("Adress.getAll");
        session.close();
        return namedQuery.getResultList();
    }
}
