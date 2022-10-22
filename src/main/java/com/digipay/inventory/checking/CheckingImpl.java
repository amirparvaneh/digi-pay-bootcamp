package com.digipay.inventory.checking;

public class CheckingImpl implements Checking{
    @Override
    public Boolean checkQuality() {
        return true;
    }

    @Override
    public Boolean checkPosition() {
        return true;
    }
}
