package com.vsu.amm.medframe.controller;

import com.vsu.amm.medframe.model.dto.CreateTestRequest;
import com.vsu.amm.medframe.service.TestService;
import com.vsu.medframe.test.AbstractTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;


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