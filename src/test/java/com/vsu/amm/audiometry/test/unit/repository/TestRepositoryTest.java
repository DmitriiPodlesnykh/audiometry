package com.vsu.amm.audiometry.test.unit.repository;

import com.vsu.amm.audiometry.test.unit.AbstractTest;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static junit.framework.Assert.assertEquals;

@DataJpaTest
//@RunWith(MockitoJUnitRunner.class)
public class TestRepositoryTest extends AbstractTest{

   // @Mock
    //private TestRepository repository;

    @Test
    public void test() {
        int n = 4;
        assertEquals(4, n);
    }
}
