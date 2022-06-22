/*
package com.payment.service.payment.impl;

import com.payment.dto.payment.PaymentLogViewDTO;
import com.payment.service.client.ClientService;
import junit.framework.TestCase;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceImplTest extends TestCase {

    @InjectMocks
    private  PaymentServiceImpl paymentService;
    @Mock
    private ClientService clientService;
    @BeforeEach
    void init_mocks() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testGetPaymentLogs() {
        when(clientService.findOne(BigInteger.ONE)).thenReturn()
        List<PaymentLogViewDTO> paymentLogs = paymentService.getPaymentLogs(null);
        assertEquals(Collections.EMPTY_LIST, paymentLogs);
    }
}*/
