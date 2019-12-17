package ua.promotion.dao;

import ua.promotion.entity.Promotion;

import java.util.List;

public interface PromotionDAO {
    void add(Promotion promotion);
    void edit(Promotion promotion);
    void delete(Promotion promotion);
    Promotion findOne(int id);
    List<Promotion> list();


}
