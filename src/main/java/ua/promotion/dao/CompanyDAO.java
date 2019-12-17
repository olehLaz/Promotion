package ua.promotion.dao;

import ua.promotion.entity.Company;

import java.util.List;

public interface CompanyDAO {
    void add(Company transaction);
    void delete(Company company);
    Company findOne(int id);
    List<Company> list();
}
