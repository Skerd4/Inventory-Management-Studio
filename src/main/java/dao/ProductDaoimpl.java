package dao;

import entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDaoimpl implements ProductDao{
    private final SessionFactory sessionFactory;
    public ProductDaoimpl(SessionFactory sessionFactory){
        this.sessionFactory =  sessionFactory;
    }
    @Override
    public void save(Product product) {
        try(Session session= sessionFactory.openSession()){
            Transaction transaction=session.beginTransaction();
            session.save(product);
            transaction.commit();
        }

    }

    @Override
    public Product findByID(long ID) {
        return null;
    }

    @Override
    public List<Product> findall() {
        return null;
    }
}
