package com.apit.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository // for comopnents scanning
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public void addCabe() {
        System.out.println(getClass() + ":DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");

    }

}
