package com.vsu.amm.audiometry.test.unit.controller;

import com.vsu.amm.audiometry.controller.TestRestController;
import com.vsu.amm.audiometry.model.dto.CreateTestRequest;
import com.vsu.amm.audiometry.service.TestService;
import com.vsu.amm.audiometry.test.unit.AbstractTest;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


public class TestRestControllerTest extends AbstractTest{

    @Mock
    private TestService testService;

    @InjectMocks
    private TestRestController controller;

    @Test
    public void create() throws Exception {
        CreateTestRequest request = new CreateTestRequest();

        controller.create(request);

    }

}