package com.ai.codegeneration.config;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SecurityConfig.class})
@ExtendWith(SpringExtension.class)
class SecurityConfigTest {
    @Autowired
    private SecurityConfig securityConfig;

    /**
     * Method under test: {@link SecurityConfig#authenticationManager(AuthenticationConfiguration)}
     */
    @Test
    void testAuthenticationManager() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        securityConfig.authenticationManager(new AuthenticationConfiguration());
    }

    /**
     * Method under test: {@link SecurityConfig#passwordEncoder()}
     */
    @Test
    void testPasswordEncoder() {
        assertTrue(securityConfig.passwordEncoder() instanceof BCryptPasswordEncoder);
    }

    /**
     * Method under test: {@link SecurityConfig#filterChain(HttpSecurity)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFilterChain() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: objectPostProcessor cannot be null
        //   See https://diff.blue/R013 to resolve this issue.

        AuthenticationManagerBuilder authenticationBuilder = new AuthenticationManagerBuilder(null);
        securityConfig.filterChain(new HttpSecurity(null, authenticationBuilder, new HashMap<>()));
    }

    /**
     * Method under test: {@link SecurityConfig#webSecurityCustomizer()}
     */
    @Test
    void testWebSecurityCustomizer() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        securityConfig.webSecurityCustomizer();
    }
}

