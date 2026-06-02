
package com.demo.bank.aspect;

public aspect MonitoringAspect {
    pointcut transferOperation():
        execution(* com.demo.bank.service.TransferService.transfer(..));

    Object around(): transferOperation() {
        long start = System.currentTimeMillis();
        Object result = proceed();
        long end = System.currentTimeMillis();
        System.out.println("[MONITOR] Execution Time = " + (end-start) + " ms");
        return result;
    }
}
