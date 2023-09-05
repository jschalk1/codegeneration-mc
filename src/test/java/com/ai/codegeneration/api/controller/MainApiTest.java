package com.ai.codegeneration.api.controller;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ai.codegeneration.api.model.PaymentRequest;
import com.ai.codegeneration.api.service.PaymentService;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {MainApi.class})
@ExtendWith(SpringExtension.class)
class MainApiTest {
    @Autowired
    private MainApi mainApi;

    @MockBean
    private PaymentService paymentService;

    /**
     * Method under test: {@link MainApi#getTransactionHistory(Long)}
     */
    @Test
    void testGetTransactionHistory() throws Exception {
        when(paymentService.retrieveTransactionHistory(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/transactions/history");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("userId", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(mainApi)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link MainApi#initiatePayment(PaymentRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testInitiatePayment() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R034 Diffblue Cover can't complete test.
        //   Diffblue Cover was unable to complete the test.
        //   Try to increase the number of fuzzing iterations if non-default
        //   value is used.
        //   See https://diff.blue/R034 for further troubleshooting of this issue.

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
        //       at com.ai.codegeneration.api.controller.MainApi.initiatePayment(MainApi.java:50)
        //   See https://diff.blue/R013 to resolve this issue.

        MainApi mainApi = new MainApi(new PaymentService());
        mainApi.initiatePayment(new PaymentRequest(10.0d, "42", "2020-03-01", "Cvv"));
    }

    /**
     * Method under test: {@link MainApi#initiatePayment(PaymentRequest)}
     */
    @Test
    void testInitiatePayment2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R034 Diffblue Cover can't complete test.
        //   Diffblue Cover was unable to complete the test.
        //   Try to increase the number of fuzzing iterations if non-default
        //   value is used.
        //   See https://diff.blue/R034 for further troubleshooting of this issue.

        PaymentService paymentService = mock(PaymentService.class);
        when(paymentService.initiatePayment(Mockito.<PaymentRequest>any())).thenReturn(null);
        MainApi mainApi = new MainApi(paymentService);
        assertNull(mainApi.initiatePayment(new PaymentRequest(10.0d, "42", "2020-03-01", "Cvv")));
        verify(paymentService).initiatePayment(Mockito.<PaymentRequest>any());
    }
}

