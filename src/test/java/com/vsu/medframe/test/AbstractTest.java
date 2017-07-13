package com.vsu.medframe.test;

import com.vsu.amm.medframe.app.Application;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public abstract class AbstractTest {

    protected static final Logger LOGGER = Logger.getLogger(AbstractTest.class);
}
