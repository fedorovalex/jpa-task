
package com.epam.javatc.entity;

import com.epam.javatc.enums.Category;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
import org.joda.time.DateTime;


@Entity
@Table(name = "SupplyStaff")
public class SupplyStaff implements Serializable {
    
    @Version
    static final long serialVersionUID = 0L;
    
    @Column(name = "price")
    private double price;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "shipDate")
    private DateTime shipDate;
    
    @Column(name = "Category")
    @Enumerated(EnumType.STRING)
    private Category category;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ManyToMany(mappedBy = "SupplyStaff")
    private Set<Employee> employees;

    public SupplyStaff() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getShipDate() {
        return shipDate;
    }

    public void setShipDate(DateTime shipDate) {
        this.shipDate = shipDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "SupplyStaff{" + "price=" + price + ", name=" + name + ", shipDate=" + shipDate + ", category=" + category + ", id=" + id + ", employees=" + employees + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.shipDate);
        hash = 79 * hash + Objects.hashCode(this.category);
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.employees);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SupplyStaff other = (SupplyStaff) obj;
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.shipDate, other.shipDate)) {
            return false;
        }
        if (this.category != other.category) {
            return false;
        }
        if (!Objects.equals(this.employees, other.employees)) {
            return false;
        }
        return true;
    }
     
    
}
