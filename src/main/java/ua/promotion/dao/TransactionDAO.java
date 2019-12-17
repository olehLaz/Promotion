package ua.promotion.dao;

import ua.promotion.entity.Transaction;

import java.util.List;

public interface TransactionDAO {
    void add(Transaction transaction);
    void delete(Transaction transaction);
    Transaction findOne(int id);
    List<Transaction> list();

}
