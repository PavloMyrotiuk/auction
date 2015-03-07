package com.myrotiuk.auction.middleware.web.controller;

import com.myrotiuk.auction.middleware.service.product.ProductService;
import com.myrotiuk.auction.middleware.web.converter.service.CustomConversionService;
import com.myrotiuk.auction.middleware.web.vo.ProductVO;
import com.myrotiuk.auction.model.product.Product;
import com.myrotiuk.auction.model.product.ProductStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by pav on 1/29/15.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomConversionService conversionService;

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ProductVO getById(@PathVariable("id") String id){
        Product product = new Product();
        productService.sendCreatedProductMessage(product);
        return new ProductVO();
    }

    /**
     *
     * @return products that satisfy given template
     * */
    @PreAuthorize("permitAll")
    @RequestMapping(method = RequestMethod.GET)
    public List<ProductVO> getByProductsTemplate(ProductVO template){
        Product product = conversionService.convert(template, Product.class);
        return conversionService.convertAll(productService.findProducts(product), ProductVO.class);
    }

    /**
     * creates product from given value object
     * */
    @PreAuthorize("permitAll")
    @RequestMapping(method = RequestMethod.POST)
    public void createProduct(@RequestBody ProductVO productVO){
        Product product = conversionService.convert(productVO, Product.class);
        populateProductWithNewProductData(product);
        productService.create(product);
    }

    private void populateProductWithNewProductData(Product product) {
        product.setAddedDate(new Date());
        product.setProductStatus(ProductStatus.VALID);
    }

}
