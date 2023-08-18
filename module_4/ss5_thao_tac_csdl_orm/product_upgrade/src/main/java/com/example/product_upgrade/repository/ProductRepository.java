package com.example.product_upgrade.repository;

import com.example.product_upgrade.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Product> findAll() {
        TypedQuery<Product> product = entityManager.createQuery("from Product ", Product.class);
        return product.getResultList();
    }

    @Override
    @Transactional
    public void create(Product products) {
        entityManager.merge(products);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Product product = findById(id);
        entityManager.remove(product);
    }

    @Override
    @Transactional
    public Product findById(int id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    @Override
    @Transactional
    public List<Product> findByName(String name) {
        TypedQuery<Product> query = entityManager.createQuery(
                "SELECT p FROM Product p WHERE LOWER(p.name) = LOWER(:name)", Product.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}

