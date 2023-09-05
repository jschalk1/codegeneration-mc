package com.ai.codegeneration.api.repository;

import com.ai.codegeneration.api.entity.TransactionEntity;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {TransactionRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.ai.codegeneration.api.entity"})
@DataJpaTest
class TransactionRepositoryTest {
    @Autowired
    private TransactionRepository transactionRepository;

    /**
     * Method under test: {@link TransactionRepository#findAllByUserId(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindAllByUserId() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        Long userId = null;

        // Act
        List<TransactionEntity> actualFindAllByUserIdResult = this.transactionRepository.findAllByUserId(userId);

        // Assert
        // TODO: Add assertions on result
    }
}

