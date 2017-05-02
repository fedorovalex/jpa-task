
package com.epam.javatc.DAO;

import com.epam.javatc.entity.Adress;
import java.util.List;

public interface AdressDAO {
    public Adress add(Adress adress);
    
    public void delete(int id);
    
    public Adress get(int id);
    
    public void update(Adress adress);
    
    public List<Adress> getAll();
}
