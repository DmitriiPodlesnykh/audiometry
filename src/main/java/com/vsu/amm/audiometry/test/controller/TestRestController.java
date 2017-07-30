package com.vsu.amm.audiometry.test.controller;

import com.vsu.amm.audiometry.model.dto.*;
import com.vsu.amm.audiometry.service.TestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("/rest/tests")
public class TestRestController {

    private static final Logger LOGGER = Logger.getLogger(TestRestController.class);

    private final TestService testService;

    @Autowired
    public TestRestController(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping(value = "/generate", method = POST)
    public TestPointResponse generatePoint(@RequestBody TestPointResponse pointDto) {
        return pointDto;
    }

    @RequestMapping(value = "", method = PUT)
    public TestResponse create(@RequestBody CreateTestRequest dto) {
        LOGGER.info("create test");
        return testService.save(dto);
    }

    @RequestMapping(value = "/t", method = GET)
    public TestResponse test() {
        TestResponse testResponse = new TestResponse();
        testResponse.setPatient(new PatientDto());
        testResponse.setTemplate(new TemplateDto());
        return testResponse;
    }
}
