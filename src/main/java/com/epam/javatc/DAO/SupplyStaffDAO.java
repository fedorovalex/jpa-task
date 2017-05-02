package com.epam.javatc.DAO;

import com.epam.javatc.entity.SupplyStaff;
import java.util.List;


public interface SupplyStaffDAO {
    public SupplyStaff add(SupplyStaff supplyStaff);
    
    public void delete(int id);
    
    public SupplyStaff get(int id);
    
    public void update(SupplyStaff supplyStaff);
    
    public List<SupplyStaff> getAll();
    
    public List<SupplyStaff> findByName(String name);
}
