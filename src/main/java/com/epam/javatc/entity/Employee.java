
package com.epam.javatc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable{
    
    @Version
    static final long serialVersionUID = 0L;
    
    @Column(name = "name")
    private String name;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "dob")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    
    @ManyToOne
    private Region region;
    
    @ManyToMany
    @JoinTable(name = "Employee_SupplyStaff",
            joinColumns = 
                {@JoinColumn(name = "Employee_ID")},
                inverseJoinColumns = 
                {@JoinColumn(name = "SupplyStaff_ID")})
    private Set<SupplyStaff> supplyStaffs;

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Set<SupplyStaff> getSupplyStaffs() {
        return supplyStaffs;
    }

    public void setSupplyStaffs(Set<SupplyStaff> supplyStaffs) {
        this.supplyStaffs = supplyStaffs;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", id=" + id + ", dob=" + dob + ", region=" + region + ", supplyStaffs=" + supplyStaffs + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.dob);
        hash = 79 * hash + Objects.hashCode(this.region);
        hash = 79 * hash + Objects.hashCode(this.supplyStaffs);
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
        final Employee other = (Employee) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.dob, other.dob)) {
            return false;
        }
        if (!Objects.equals(this.region, other.region)) {
            return false;
        }
        if (!Objects.equals(this.supplyStaffs, other.supplyStaffs)) {
            return false;
        }
        return true;
    }
    
}
