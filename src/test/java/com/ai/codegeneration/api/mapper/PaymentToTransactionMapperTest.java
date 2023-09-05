package com.ai.codegeneration.api.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ai.codegeneration.api.entity.TransactionEntity;
import com.ai.codegeneration.api.model.PaymentRequest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PaymentToTransactionMapperTest {
    /**
     * Method under test: {@link PaymentToTransactionMapper#mapPaymentRequestToTransactionEntity(PaymentRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapPaymentRequestToTransactionEntity() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.StringIndexOutOfBoundsException: begin -2, end 2, length 2
        //       at java.base/java.lang.String.checkBoundsBeginEnd(String.java:4604)
        //       at java.base/java.lang.String.substring(String.java:2707)
        //       at java.base/java.lang.String.substring(String.java:2680)
        //       at com.ai.codegeneration.api.mapper.PaymentToTransactionMapper.mapPaymentRequestToTransactionEntity(PaymentToTransactionMapper.java:13)
        //   See https://diff.blue/R013 to resolve this issue.

        PaymentToTransactionMapper
                .mapPaymentRequestToTransactionEntity(new PaymentRequest(10.0d, "42", "2020-03-01", "Cvv"));
    }

    /**
     * Method under test: {@link PaymentToTransactionMapper#mapPaymentRequestToTransactionEntity(PaymentRequest)}
     */
    @Test
    void testMapPaymentRequestToTransactionEntity2() {
        TransactionEntity actualMapPaymentRequestToTransactionEntityResult = PaymentToTransactionMapper
                .mapPaymentRequestToTransactionEntity(new PaymentRequest(10.0d, "Card Number", "2020-03-01", "Cvv"));
        assertEquals("mber", actualMapPaymentRequestToTransactionEntityResult.getCardLastFourDigits());
        assertEquals(123456L, actualMapPaymentRequestToTransactionEntityResult.getUserId().longValue());
        assertEquals(10.0d, actualMapPaymentRequestToTransactionEntityResult.getPaymentAmount().doubleValue());
        assertEquals("USD", actualMapPaymentRequestToTransactionEntityResult.getCurrency());
    }

    /**
     * Method under test: {@link PaymentToTransactionMapper#mapPaymentRequestToTransactionEntity(PaymentRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapPaymentRequestToTransactionEntity3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "String.length()" because the return value of "com.ai.codegeneration.api.model.PaymentRequest.getCardNumber()" is null
        //       at com.ai.codegeneration.api.mapper.PaymentToTransactionMapper.mapPaymentRequestToTransactionEntity(PaymentToTransactionMapper.java:13)
        //   See https://diff.blue/R013 to resolve this issue.

        PaymentToTransactionMapper.mapPaymentRequestToTransactionEntity(new PaymentRequest());
    }

    /**
     * Method under test: {@link PaymentToTransactionMapper#mapPaymentRequestToTransactionEntity(PaymentRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapPaymentRequestToTransactionEntity4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ai.codegeneration.api.model.PaymentRequest.getPaymentAmount()" because "paymentRequest" is null
        //       at com.ai.codegeneration.api.mapper.PaymentToTransactionMapper.mapPaymentRequestToTransactionEntity(PaymentToTransactionMapper.java:12)
        //   See https://diff.blue/R013 to resolve this issue.

        PaymentToTransactionMapper.mapPaymentRequestToTransactionEntity(null);
    }
}

