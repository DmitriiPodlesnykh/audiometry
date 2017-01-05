package com.vsu.amm.medframe.controller;

import com.vsu.amm.medframe.entity.Patient;
import com.vsu.amm.medframe.service.Impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    @RequestMapping(value = "", method = GET)
    public String getDoctorPatients(ModelMap modelMap){
        modelMap.addAttribute("patients", patientService.getAllPatientsOfTheDoctor(1L));
        return "patient/patientList";
    }

    @RequestMapping(value = "/add", method = GET)
    public String createForm(){
        return "patient/addPatient";
    }

    @RequestMapping(value = "/add", method = POST)
    public String create(@ModelAttribute("patient")Patient patient){
        patientService.save(patient);
        return "redirect:/patients";
    }
}
