package com.vsu.amm.medframe.controller;

import com.vsu.amm.medframe.model.dto.TestPointDto;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/rest/tests")
public class TestRestController {

    private static final Logger LOGGER = Logger.getLogger(TestRestController.class);

    @RequestMapping(value = "/generate", method = POST)
    public TestPointDto generatePoint(@RequestBody TestPointDto pointDto) {
        return pointDto;
    }
}
