package com.vsu.amm.medframe.component;

import com.vsu.amm.medframe.entity.Patient;
import com.vsu.amm.medframe.entity.Template;
import com.vsu.amm.medframe.entity.TemplatePoint;
import com.vsu.amm.medframe.entity.User;
import com.vsu.amm.medframe.repository.PatientRepository;
import com.vsu.amm.medframe.repository.TemplatePointRepository;
import com.vsu.amm.medframe.repository.TemplateRepository;
import com.vsu.amm.medframe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class DBinit {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PatientRepository patientRepository;

    @Autowired
    private final TemplateRepository templateRepository;

    @Autowired
    private final TemplatePointRepository templatePointRepository;

    @Autowired
    public DBinit(PatientRepository patientRepository,
                  UserRepository userRepository1, TemplateRepository templateRepository,
                  TemplatePointRepository templatePointRepository) {
        this.userRepository = userRepository1;
        this.patientRepository = patientRepository;
        this.templateRepository = templateRepository;
        this.templatePointRepository = templatePointRepository;
    }

    @PostConstruct
    @Transactional
    public void init() {
        System.out.println("DBinit init() start");

        //checkTables();
        addUserForTest();
        addPatieantForTest();
        addTemplateForTest();
        addTemplatePointForTest();
    }

    private void checkTables() {
        System.out.println("All tables checked");
    }

    private void addTemplatePointForTest() {
        TemplatePoint templatePoint = new TemplatePoint();
        templatePoint.setTemplateId(1L);
        templatePoint.setFrequency(4000);
        templatePoint.setInrensityValue(10);
        templatePointRepository.save(templatePoint);
        System.out.println("Template point added");
    }

    private void addTemplateForTest() {
        Template template = new Template();
        template.setName("First template");
        template.setAuthorId(1L);
        templateRepository.save(template);
        System.out.println("Template added");
    }

    private void addPatieantForTest() {
        Patient patient = new Patient();
        patient.setFirstName("Гадя");
        patient.setLastName("Хренова");
        patient.setMiddleName("Петрович");
        patient.setSex("Female");
        patient.setDoctorId(1L);

        patientRepository.save(patient);

        System.out.println("Patient added");
    }

    private void addUserForTest() {
        User user = new User();
        user.setFirstName("Pop");
        user.setLastName("qwerty");
        user.setUserType("Admin");
        user.setEmail("11@qw.ru");
        user.setPassword("sde");
        user.setMiddleName("qwqqq");

        userRepository.save(user);

        System.out.println("User added");
    }

}
