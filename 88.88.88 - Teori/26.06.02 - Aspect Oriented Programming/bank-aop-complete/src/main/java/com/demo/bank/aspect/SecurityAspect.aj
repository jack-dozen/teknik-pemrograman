
package com.demo.bank.aspect;

import com.demo.bank.security.SecurityContext;

public aspect SecurityAspect {
    pointcut transferOperation():
        execution(* com.demo.bank.service.TransferService.transfer(..));

    before(): transferOperation() {
        if(!SecurityContext.hasPermission())
            throw new RuntimeException("Access denied");
        System.out.println("[SECURITY] Access granted");
    }
}
