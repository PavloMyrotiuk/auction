package com.myrotiuk.auction.middleware.web.controller;

import com.myrotiuk.auction.common.core.model.bet.Bet;
import com.myrotiuk.auction.middleware.service.product.ProductService;
import com.myrotiuk.auction.middleware.web.vo.BetVO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pav on 3/14/15.
 */
@RestController
@RequestMapping("/bet")
public class BetController {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private ProductService productService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void betForProduct(@RequestBody BetVO betVO) {
        Bet bet = conversionService.convert(betVO, Bet.class);
        productService.sendBetProductMessage(bet, new ObjectId(betVO.getProductId()));
    }
}
