package com.example.java.web.test;

import com.example.java.web.DatabaseLogger;
import com.example.java.web.Payment;
import com.example.java.web.PaymentServiceImpl;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {

    PaymentServiceImpl service;

    @Mock
    DatabaseLogger logger;

    @Before
    public void init(){
        service = new PaymentServiceImpl();
//        DatabaseLogger logger = Mockito.mock(DatabaseLogger.class);
        Mockito.when(logger.log(Mockito.any(Payment.class))).thenReturn(true);
        service.setLogger(logger);
    }

    @Test(expected = NullPointerException.class)
    public void deposit_givenNullExpectException(){
        service.deposit(null);
    }

    @Test
    public void deposit_givenNotNullReturnTrue(){
        Assert.assertTrue(service.deposit(new Payment()));
    }

    @AfterClass
    public static void shutdown(){

    }
}
