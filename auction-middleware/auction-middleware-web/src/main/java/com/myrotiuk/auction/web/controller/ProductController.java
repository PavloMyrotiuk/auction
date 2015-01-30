package com.myrotiuk.auction.web.controller;

import com.myrotiuk.auction.web.vo.ProductVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pav on 1/29/15.
 */
@RestController
@RequestMapping("/rest/product")
public class ProductController {

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ProductVO getById(@PathVariable("id") long id){

        return new ProductVO();
    }




}
