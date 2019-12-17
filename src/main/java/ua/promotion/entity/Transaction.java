package ua.promotion.entity;

import ua.promotion.entity.Promotion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String logs;

    @ManyToOne
    @JoinColumn(name = "to_promotion_id", foreignKey = @ForeignKey(name = "fk_transactions_to_promotion_id"))
    private Promotion promotion;

    public Transaction() {
    }

    public Transaction(Date date, String logs, Promotion promotion) {
        this.date = date;
        this.logs = logs;
        this.promotion = promotion;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLogs() {
        return logs;
    }

    public void setLogs(String logs) {
        this.logs = logs;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
}