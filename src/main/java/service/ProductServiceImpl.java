package service;

import config.HibernateConfig;
import converter.ProductConverter;
import dao.ProductDao;
import dao.ProductDaoimpl;
import dto.CategoryRequest;
import dto.ProductRequest;
import entity.Product;
import org.hibernate.SessionFactory;
import validator.ProductValidator;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{

    private final SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
    private final ProductDao productDao =
            new ProductDaoimpl(sessionFactory);
    private final Integer limitStock =5;
    public List<Product>notifyForLowStock(){
        List<Product>products = new ArrayList<>();
        List<Product>lowStock = new ArrayList<>();
        for (Product product : products){
            if (product.getQuantity()<this.limitStock){
                lowStock.add(product);
            }
        }
        return lowStock;

    }

    public void addProduct(ProductRequest request){
        ProductValidator.validateProduct(request);
        Product product = ProductConverter.convertRequestToEntity(request);
        productDao.save(product);
        System.out.println(request);

    }

    public List<Product> displayAllProduct() {
        return new ArrayList<>();
    }

    @Override
    public void addCategory(CategoryRequest request) {
        System.out.println(request);
    }
}
