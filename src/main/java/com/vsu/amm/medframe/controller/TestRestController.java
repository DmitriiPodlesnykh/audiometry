package com.vsu.amm.medframe.controller;

import com.vsu.amm.medframe.model.dto.*;
import com.vsu.amm.medframe.service.TestService;
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

    @RequestMapping(value = "/generate", method = POST)
    public TestPointDto generatePoint(@RequestBody TestPointDto pointDto) {
        return pointDto;
    }

    @RequestMapping(value = "", method = PUT)
    public CreateTestDto create(@RequestBody CreateTestDto testDto) {
        testDto = testService.save(testDto);
        return testDto;
    }

    @RequestMapping(value = "/t", method = GET)
    public TestDto test() {
        TestDto testDto = new TestDto();
        testDto.setPatient(new PatientDto());
        testDto.setTemplate(new TemplateDto());
        return testDto;
    }

    @Autowired
    public TestRestController(TestService testService) {
        this.testService = testService;
    }
}
