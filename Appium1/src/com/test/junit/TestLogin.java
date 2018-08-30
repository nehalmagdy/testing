package com.test.junit;
import java.io.IOException;

import org.junit.Test;

import net.sourceforge.tess4j.TesseractException;

public class TestLogin  {

    @Test
    public void searchContact() throws InterruptedException, IOException, TesseractException {
        //Search for contact
        LoginPageObjects p = new LoginPageObjects();
        p.test();
    }
}
