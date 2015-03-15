package com.myrotiuk.auction.middleware.web.converter;

import com.myrotiuk.auction.common.core.model.bet.Bet;
import com.myrotiuk.auction.common.core.model.product.Product;
import com.myrotiuk.auction.common.core.model.user.User;
import com.myrotiuk.auction.middleware.service.product.ProductService;
import com.myrotiuk.auction.middleware.service.user.UserService;
import com.myrotiuk.auction.middleware.web.vo.BetVO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by pav on 3/14/15.
 */
@Component
public class BetVO2BetConverter implements Converter<BetVO, Bet> {

    @Autowired
    private UserService userService;

    @Override
    public Bet convert(BetVO source) {
        if (source == null) return null;

        Bet result = new Bet();
        result.setAmount(source.getAmount());
        result.setUser(getUser());
        return result;
    }

    private User getUser() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return (User) userService.loadUserByUsername(username);
    }
}
