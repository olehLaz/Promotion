package ua.promotion.entity;



import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "promotions")
public class Promotion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = true)
    private Integer authorizedCapital;

    @Column(nullable = false)
    private Integer edrpou;


    @Column(nullable = true)
    private Integer number;

    @Column(nullable = false)
    private double nominalValue;

    @Column(nullable = true)
    private double stateDutyPaid;

    @Column(nullable = true)
    private double totalNominalValue;

    @Column(nullable = false)
    private Date releaseDate;


    @ManyToOne
    @JoinColumn(name = "company_id", foreignKey = @ForeignKey(name = "fk_promotions_company_id"))
    private Company company;

    @OneToMany(mappedBy = "promotion", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Transaction> transactions = new ArrayList<>();

    public Promotion() {
    }

    public Promotion(String comment, Integer authorizedCapital, Integer number, double nominalValue, double stateDutyPaid, double totalNominalValue, Company company, List<Transaction> transactions) {
        this.comment = comment;
        this.authorizedCapital = authorizedCapital;
        this.number = number;
        this.nominalValue = nominalValue;
        this.stateDutyPaid = stateDutyPaid;
        this.totalNominalValue = totalNominalValue;
        this.releaseDate = new Date();
        this.company = company;
        this.transactions = transactions;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getAuthorizedCapital() {
        return authorizedCapital;
    }

    public void setAuthorizedCapital(Integer authorizedCapital) {
        this.authorizedCapital = authorizedCapital;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public double getNominalValue() {
        return nominalValue;
    }

    public void setNominalValue(double nominalValue) {
        this.nominalValue = nominalValue;
    }

    public double getStateDutyPaid() {
        return stateDutyPaid;
    }

    public void setStateDutyPaid(double stateDutyPaid) {
        this.stateDutyPaid = stateDutyPaid;
    }

    public double getTotalNominalValue() {
        return totalNominalValue;
    }

    public void setTotalNominalValue(double totalNominalValue) {
        this.totalNominalValue = totalNominalValue;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Integer getEdrpou() {
        return edrpou;
    }

    public void setEdrpou(Integer edrpou) {
        this.edrpou = edrpou;
    }
}
