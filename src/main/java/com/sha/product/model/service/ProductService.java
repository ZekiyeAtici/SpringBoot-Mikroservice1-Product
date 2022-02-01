package com.sha.product.model.service;

import com.sha.product.model.entity.Product;
import com.sha.product.util.Util;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends AbstractProductService
{

    @Override
    protected List<Product> findByPriceGreaterThan(Double upperLimit)
    {
        return productRepository.findByPriceGreaterThan(upperLimit);
    }

    @Override
    protected List<Product> findByPriceGreaterThanEqual(Double upperLimit)
    {
        return productRepository.findByPriceGreaterThanEqual(upperLimit);
    }

    @Override
    public List<Product> findAll()
    {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product entity)
    {
        try
        {
            return productRepository.save(entity);
        }
        catch (IllegalArgumentException e)
        {
            Util.showExceptionInfo(e);
            return new Product();
        }
    }

    @Override
    public void deleteByID(Integer id)
    {
        try
        {
            productRepository.deleteById(id);
        }
        catch (IllegalArgumentException e)
        {
            Util.showExceptionInfo(e);
        }
    }
}
