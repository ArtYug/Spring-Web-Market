package com.geekbrains.web_market.core.tests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:./secret.properties")
class SpringWebCoreApplicationTests {
    @Test
    void contextLoads() {
    }
}
