package com.vsu.amm.medframe.controller;

import com.vsu.amm.medframe.service.PatientService;
import com.vsu.amm.medframe.service.TemplateService;
import com.vsu.amm.medframe.service.TestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/tests")
public class TestController {

    private static final Logger LOGGER = Logger.getLogger(TestController.class);

    private final TestService testService;
    private final TemplateService templateService;
    private final PatientService patientService;

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

    @RequestMapping(value = "/add", method = GET)
    public String addTestForm(ModelMap modelMap) {
        Map<String, Object> attributeMap = new HashMap<String, Object>();
        attributeMap.put("patientList", patientService.getAll());
        attributeMap.put("templateList", templateService.getAll());

        modelMap.addAllAttributes(attributeMap);
        return "createTestForm";
    }

    @Autowired
    TestController(TestService testService, TemplateService templateService, PatientService patientService) {
        this.testService = testService;
        this.templateService = templateService;
        this.patientService = patientService;
    }
}
