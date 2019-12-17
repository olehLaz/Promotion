package ua.promotion.entity;

import ua.promotion.entity.Promotion;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "сompany_tab")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String Name;

    @Column(nullable = false)
    private Integer edrpouInstitutions;


    @OneToMany(mappedBy = "company", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Promotion> promotions = new ArrayList<>();

    public Company() {
    }

    public Company(String name, Integer edrpouInstitutions) {
        Name = name;
        this.edrpouInstitutions = edrpouInstitutions;


    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getEdrpouInstitutions() {
        return edrpouInstitutions;
    }

    public void setEdrpouInstitutions(Integer edrpouInstitutions) {
        this.edrpouInstitutions = edrpouInstitutions;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }
}
