package com.vsu.amm.audiometry.test.unit.service;

import com.vsu.amm.audiometry.model.dto.CreateTestRequest;
import com.vsu.amm.audiometry.service.TestService;
import com.vsu.amm.audiometry.test.unit.AbstractTest;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Assert;

import javax.transaction.Transactional;

@Transactional
@RunWith(MockitoJUnitRunner.class)
public class TestServiceTest extends AbstractTest{

    @Mock
    private TestService testService;

    @After
    public void tearDown() {
        //TODO clean up
    }

    @Test
    public void createTest() {
        int n = 4;
        Assert.assertEquals(4, n);
    }

    @Test
    public void updateTest() {

    }

    @Test
    public void getAll() {

    }

    private CreateTestRequest generateTestRequest() {
        return new CreateTestRequest();
    }

}
