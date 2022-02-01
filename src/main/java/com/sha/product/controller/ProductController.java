package com.sha.product.controller;

import com.sha.product.model.entity.Product;
import com.sha.product.model.service.AbstractProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    pre-path (Request mapping, belirtildigi scope'taki tum unsurlari etkiler)

    @RequestMapping(path)
        Buna bagli olan mapping'ler neler ?
        @GetMapping, @PostMaping, @DeleteMapping, @PutMapping

        ResponseEntity<?> donduren metotta, param kismi hangi anotation ile isaretlenebilir:
        @RequestBody -> POST https//endpoint-data{requestBody}
        @RequestPath ->  https//endpoint?requestPath=x
        @PathVariable -> https//endpoint/pathVariable

        api/product'i 2 farkli @GetMapping icin kullanamayiz.
        Ne var ki, bu yolu hem @GetMapping hem de @PostMapping icin kullanabildik.
 */
@RequestMapping("api/product")
@RestController
public class ProductController
{
    @Autowired
    private AbstractProductService productService;

    // api/product
    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product)
    {
        Product savedProduct = productService.save(product);

        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("{productID}") // api/product/productID
    public ResponseEntity<Product> deleteProduct(@PathVariable  Integer productID)
    {
        productService.deleteByID(productID);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // api/product
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts()
    {
        List<Product> productList  = productService.findAll();

        return ResponseEntity.ok(productList); // cevabın döndürülmesi
    }
}
