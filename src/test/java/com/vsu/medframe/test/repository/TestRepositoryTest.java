package com.vsu.medframe.test.repository;

import com.vsu.amm.medframe.repository.TestRepository;
import com.vsu.medframe.test.AbstractTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
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
