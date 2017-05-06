package com.vsu.medframe.test;

import com.vsu.amm.medframe.MainConfiguration;
import com.vsu.amm.medframe.app.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@EnableAutoConfiguration
@SpringApplicationConfiguration(classes = MainConfiguration.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractTest {
}
