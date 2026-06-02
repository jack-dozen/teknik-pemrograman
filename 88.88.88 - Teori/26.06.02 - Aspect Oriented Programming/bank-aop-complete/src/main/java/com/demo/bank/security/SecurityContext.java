
package com.demo.bank.security;

public class SecurityContext {
    public static String getCurrentUser(){ return "admin"; }
    public static boolean hasPermission(){ return true; }
}
