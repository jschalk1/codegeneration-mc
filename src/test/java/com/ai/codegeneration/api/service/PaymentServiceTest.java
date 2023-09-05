package com.ai.codegeneration.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ai.codegeneration.api.entity.TransactionEntity;
import com.ai.codegeneration.api.model.PaymentRequest;
import com.ai.codegeneration.api.repository.TransactionRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PaymentService.class})
@ExtendWith(SpringExtension.class)
class PaymentServiceTest {
    @Autowired
    private PaymentService paymentService;

    @MockBean
    private TransactionRepository transactionRepository;

    /**
     * Method under test: {@link PaymentService#initiatePayment(PaymentRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testInitiatePayment() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.StringIndexOutOfBoundsException: begin -2, end 2, length 2
        //       at java.base/java.lang.String.checkBoundsBeginEnd(String.java:4604)
        //       at java.base/java.lang.String.substring(String.java:2707)
        //       at java.base/java.lang.String.substring(String.java:2680)
        //       at com.ai.codegeneration.api.mapper.PaymentToTransactionMapper.mapPaymentRequestToTransactionEntity(PaymentToTransactionMapper.java:13)
        //       at com.ai.codegeneration.api.service.PaymentService.initiatePayment(PaymentService.java:23)
        //   See https://diff.blue/R013 to resolve this issue.

        paymentService.initiatePayment(new PaymentRequest(10.0d, "42", "2020-03-01", "Cvv"));
    }

    /**
     * Method under test: {@link PaymentService#initiatePayment(PaymentRequest)}
     */
    @Test
    void testInitiatePayment2() {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setCardLastFourDigits("Card Last Four Digits");
        transactionEntity.setCurrency("GBP");
        transactionEntity.setId(1L);
        transactionEntity.setPaymentAmount(10.0d);
        transactionEntity.setTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay());
        transactionEntity.setUserId(1L);
        when(transactionRepository.save(Mockito.<TransactionEntity>any())).thenReturn(transactionEntity);
        ResponseEntity<String> actualInitiatePaymentResult = paymentService
                .initiatePayment(new PaymentRequest(10.0d, "Card Number", "2020-03-01", "Cvv"));
        assertEquals("Payment initiated", actualInitiatePaymentResult.getBody());
        assertEquals(200, actualInitiatePaymentResult.getStatusCodeValue());
        assertTrue(actualInitiatePaymentResult.getHeaders().isEmpty());
        verify(transactionRepository).save(Mockito.<TransactionEntity>any());
    }

    /**
     * Method under test: {@link PaymentService#initiatePayment(PaymentRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testInitiatePayment3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "String.length()" because the return value of "com.ai.codegeneration.api.model.PaymentRequest.getCardNumber()" is null
        //       at com.ai.codegeneration.api.mapper.PaymentToTransactionMapper.mapPaymentRequestToTransactionEntity(PaymentToTransactionMapper.java:13)
        //       at com.ai.codegeneration.api.service.PaymentService.initiatePayment(PaymentService.java:23)
        //   See https://diff.blue/R013 to resolve this issue.

        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setCardLastFourDigits("Card Last Four Digits");
        transactionEntity.setCurrency("GBP");
        transactionEntity.setId(1L);
        transactionEntity.setPaymentAmount(10.0d);
        transactionEntity.setTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay());
        transactionEntity.setUserId(1L);
        when(transactionRepository.save(Mockito.<TransactionEntity>any())).thenReturn(transactionEntity);
        paymentService.initiatePayment(new PaymentRequest());
    }

    /**
     * Method under test: {@link PaymentService#initiatePayment(PaymentRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testInitiatePayment4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ai.codegeneration.api.model.PaymentRequest.getPaymentAmount()" because "paymentRequest" is null
        //       at com.ai.codegeneration.api.mapper.PaymentToTransactionMapper.mapPaymentRequestToTransactionEntity(PaymentToTransactionMapper.java:12)
        //       at com.ai.codegeneration.api.service.PaymentService.initiatePayment(PaymentService.java:23)
        //   See https://diff.blue/R013 to resolve this issue.

        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setCardLastFourDigits("Card Last Four Digits");
        transactionEntity.setCurrency("GBP");
        transactionEntity.setId(1L);
        transactionEntity.setPaymentAmount(10.0d);
        transactionEntity.setTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay());
        transactionEntity.setUserId(1L);
        when(transactionRepository.save(Mockito.<TransactionEntity>any())).thenReturn(transactionEntity);
        paymentService.initiatePayment(null);
    }

    /**
     * Method under test: {@link PaymentService#retrieveTransactionHistory(Long)}
     */
    @Test
    void testRetrieveTransactionHistory() {
        ArrayList<TransactionEntity> transactionEntityList = new ArrayList<>();
        when(transactionRepository.findAllByUserId(Mockito.<Long>any())).thenReturn(transactionEntityList);
        List<TransactionEntity> actualRetrieveTransactionHistoryResult = paymentService.retrieveTransactionHistory(1L);
        assertSame(transactionEntityList, actualRetrieveTransactionHistoryResult);
        assertTrue(actualRetrieveTransactionHistoryResult.isEmpty());
        verify(transactionRepository).findAllByUserId(Mockito.<Long>any());
    }
}

