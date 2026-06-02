
package com.demo.bank.service;

public class TransferService {
    public void transfer(String from,String to,double amount){
        System.out.println("Transfer " + amount + " dari " + from + " ke " + to);
        try { Thread.sleep(1000); } catch(Exception e){}
        System.out.println("Transfer selesai");
    }
}
