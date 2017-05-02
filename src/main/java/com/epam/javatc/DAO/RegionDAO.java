package com.epam.javatc.DAO;

import com.epam.javatc.entity.Region;
import java.util.List;


public interface RegionDAO {
    public Region add(Region region);
    
    public void delete(int id);
    
    public Region get(int id);
    
    public void update(Region region);
    
    public List<Region> getAll();
}
