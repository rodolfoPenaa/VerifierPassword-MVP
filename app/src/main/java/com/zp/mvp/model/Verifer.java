package com.zp.mvp.model;

import androidx.annotation.VisibleForTesting;

public class Verifer {
public static final int WEAK =0;
public static final int MEDIUM=1;
public static final int STRONG=10;
public static final int VERYSTRONG=100;

@VisibleForTesting
    public static int passwordVerifier(String pass) {

        if (islongenough(pass) && (hasUpperCase(pass)) && (hasnumber(pass))){
            return VERYSTRONG;
        }
        else if (hasUpperCase(pass) && islongenough(pass)){

            return STRONG;
        }
        if (islongenough(pass)) {
            return MEDIUM;
        }
        return WEAK;

    }

@VisibleForTesting
    protected static boolean islongenough(String pass) {
        if (pass.length() > 5) {
            return true;
        }

        return false;
    }
@VisibleForTesting
     protected static boolean hasUpperCase(String pass) {
        return !pass.toLowerCase().equals(pass);

    }
@VisibleForTesting
    protected static boolean hasnumber(String pass) {
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isDigit(pass.charAt(i))) {
                return true;
            }

        }
        return false;
    }


}
