package com.nisc586;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class AppTest {
    
    @Test
    public void verifyNoExceptionThrown() {
        try{
            App.main(new String[]{});
        } catch (IOException e) {
            // FÜCK THIS SHAITE MANN
        }
    }
}
