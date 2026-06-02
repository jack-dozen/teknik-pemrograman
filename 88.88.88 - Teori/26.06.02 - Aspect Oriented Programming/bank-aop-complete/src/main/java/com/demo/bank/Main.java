
package com.demo.bank;
import com.demo.bank.service.TransferService;

public class Main {
    public static void main(String[] args) {
        new TransferService().transfer("Budi","Siti",500000);
    }
}
