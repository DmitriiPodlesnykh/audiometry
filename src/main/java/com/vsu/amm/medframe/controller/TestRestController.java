package com.vsu.amm.medframe.controller;

import com.vsu.amm.medframe.model.dto.TestDto;
import com.vsu.amm.medframe.model.dto.TestPointDto;
import com.vsu.amm.medframe.service.TestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("/rest/tests")
public class TestRestController {

    private static final Logger LOGGER = Logger.getLogger(TestRestController.class);

    @Autowired
    private final TestService testService;

    @RequestMapping(value = "/generate", method = POST)
    public TestPointDto generatePoint(@RequestBody TestPointDto pointDto) {
        return pointDto;
    }

    @RequestMapping(value = "", method = PUT)
    public TestDto create(@RequestBody TestDto testDto) {
        testDto = testService.save(testDto);
        return testDto;
    }

    public TestRestController(TestService testService) {
        this.testService = testService;
    }
}
