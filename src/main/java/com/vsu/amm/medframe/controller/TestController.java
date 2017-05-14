package com.vsu.amm.medframe.controller;

import com.vsu.amm.medframe.service.TestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/tests")
public class TestController {

    private static final Logger LOGGER = Logger.getLogger(TestController.class);

    @Autowired
    private final TestService testService;

    @RequestMapping(value = "", method = GET)
    public String getAllTests(ModelMap modelMap) {
        modelMap.addAttribute("tests", testService.getAll());
        return "testList";
    }

    @RequestMapping(value = "/{testId}", method = GET)
    public String getTest(@PathVariable Long testId, ModelMap modelMap) {
        LOGGER.info("testId = " + testId.toString());
        modelMap.addAttribute("test", testService.getTestById(testId));
        return "test";
    }

    TestController(TestService testService) {
        this.testService = testService;
    }
}
