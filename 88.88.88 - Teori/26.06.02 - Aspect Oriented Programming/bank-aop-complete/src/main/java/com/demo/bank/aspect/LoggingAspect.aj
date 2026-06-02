
package com.demo.bank.aspect;

public aspect LoggingAspect {
    pointcut transferOperation():
        execution(* com.demo.bank.service.TransferService.transfer(..));

    before(): transferOperation() {
        System.out.println("[LOG] Transfer dimulai");
    }

    after(): transferOperation() {
        System.out.println("[LOG] Transfer selesai");
    }
}
