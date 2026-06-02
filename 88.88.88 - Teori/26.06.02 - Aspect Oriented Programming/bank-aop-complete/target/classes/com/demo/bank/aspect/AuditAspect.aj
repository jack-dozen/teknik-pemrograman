
package com.demo.bank.aspect;

import com.demo.bank.security.SecurityContext;

public aspect AuditAspect {
    pointcut transferOperation():
        execution(* com.demo.bank.service.TransferService.transfer(..));

    after(): transferOperation() {
        System.out.println("[AUDIT] User " + SecurityContext.getCurrentUser() + " melakukan transfer");
    }
}
