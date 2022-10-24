package com.digipay.inventory.checking;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
public class CheckingImpl implements Checking{

    private Logger logger;

    public CheckingImpl() {
    }



    @Override
    public Boolean checkQuality() {

       // logger.info("checkQuality called");
        return true;
    }

    @Override
    public Boolean checkPosition() {
       // logger.info("checkPosition called");
        return true;
    }
}
