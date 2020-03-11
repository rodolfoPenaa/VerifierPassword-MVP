package com.zp.mvp.model;

import com.zp.mvp.model.Verifer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VeriferTest {

    public static final int WEAK =0;
    public static final int MEDIUM=1;
    public static final int STRONG=10;
    public static final int VERYSTRONG=100;

    Verifer verifer;

    @Before
    public void setUp() {
        verifer = new Verifer();
    }

    @Test
    public void lengthpass_ok() {
        String pass = "asdfgt";
        assertTrue(verifer.islongenough(pass));
    }

    @Test
    public void lengthpass() {
        String pass = "qwer";
        assertFalse(verifer.islongenough(pass));
    }

    @Test
    public void upperCase_Test_ok(){
        String pass = "blaPAAAAS";
        assertTrue(verifer.hasUpperCase(pass));
    }

    @Test
    public void upperCase_Test(){
        String pass = "blaasasasasas";
        assertFalse(verifer.hasUpperCase(pass));
    }

    @Test
    public void numberInPass_ok(){
        String pass= "123123As";
        assertTrue(verifer.hasnumber(pass));
    }

    @Test
    public void numberInPass(){
        String pass= "qweqwert";
        assertFalse(verifer.hasnumber(pass));

    }



    @Test
    public void passwordVerifier1(){
        String pass = "kwer";
        int test = verifer.passwordVerifier(pass);
        assertEquals(test, Verifer.WEAK);

    }

    @Test
    public void passwordVerifier2(){
        String pass = "kwerty";
        int test = verifer.passwordVerifier(pass);
        assertEquals(test, Verifer.MEDIUM);

    }
    @Test
    public void passwordVerifier3(){
        String pass = "kwertyQ";
        int test = verifer.passwordVerifier(pass);
        assertEquals(test, Verifer.STRONG);

    }

    @Test
    public void passwordVerifier4(){
        String pass = "kwerty1Q";
        int test = verifer.passwordVerifier(pass);
        assertEquals(test, Verifer.VERYSTRONG);

    }
}
