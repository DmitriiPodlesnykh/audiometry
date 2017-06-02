package com.vsu.amm.medframe.component;

import com.vsu.amm.medframe.model.entity.*;
import com.vsu.amm.medframe.enums.Frequency;
import com.vsu.amm.medframe.repository.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBinit {

    private static final Logger LOGGER = Logger.getLogger(DBinit.class);


    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PatientRepository patientRepository;

    @Autowired
    private final TemplateRepository templateRepository;

    @Autowired
    private final TemplatePointRepository templatePointRepository;

    @Autowired
    private final DeviceRepository deviceRepository;

    @Autowired
    private final DevicePointRepository devicePointRepository;

    @Autowired
    private final TestRepository testRepository;

    @Autowired
    private final TestPointRepository testPointRepository;

    @Autowired
    public DBinit(PatientRepository patientRepository,
                  UserRepository userRepository1, TemplateRepository templateRepository,
                  TemplatePointRepository templatePointRepository,
                  DeviceRepository deviceRepository,
                  DevicePointRepository devicePointRepository,
                  TestRepository testRepository,
                  TestPointRepository testPointRepository) {
        this.userRepository = userRepository1;
        this.patientRepository = patientRepository;
        this.templateRepository = templateRepository;
        this.templatePointRepository = templatePointRepository;
        this.deviceRepository = deviceRepository;
        this.devicePointRepository = devicePointRepository;
        this.testRepository = testRepository;
        this.testPointRepository = testPointRepository;
    }

    @PostConstruct
    @Transactional
    public void init() {
        System.out.println("DBinit init() start");

        User user = addTestUser();

        List<Device> devices = addTestDevices(4);
        addDevicePoint(devices.get(0).getId(), Frequency.FREQUENCY_40_HZ, 0, 0.5);
        addDevicePoint(devices.get(0).getId(), Frequency.FREQUENCY_100_HZ, 0, 0.4);
        addDevicePoint(devices.get(0).getId(), Frequency.FREQUENCY_250_HZ, 0, 0.3);

        List<Template> templates = addTemplateForTest(5);
        addTemplatePointForTest(templates.get(0), Frequency.FREQUENCY_40_HZ, 0);
        Patient patient = addPatient(user);
        Test test = addTest(templates.get(0), patient);
        addTestPoint(test);
    }

    private Patient addPatient(User user) {
        Patient patient = new Patient();
        patient.setBirthday(new Date(100L));
        patient.setDescription("deded");
        patient.setDoctor(user);
        patient.setFirstName("wswsws");
        patient.setLastName("deded");
        patient.setMiddleName("eded");
        patient = patientRepository.saveAndFlush(patient);
        return patient;
    }

    private TestPoint addTestPoint(Test test) {
        TestPoint point = new TestPoint();
        point.setTest(test);
        point.setStatus("deded");
        point.setFrequency(11);
        point.setIntensityValue(12);
        return testPointRepository.saveAndFlush(point);
    }

    private Test addTest(Template template, Patient patient) {
        Test test = new Test();
        test.setDate(new Date(9999L));
        test.setPatient(patient);
        test.setTemplate(template);
        return testRepository.saveAndFlush(test);
    }

    private void addDevicePoint(Long deviceId, Frequency frequency, Integer intensityLevel, Double volumeValue) {
        DevicePoint point = new DevicePoint();
        point.setDevice(deviceRepository.getOne(deviceId));
        point.setVolumeValue(new BigDecimal(volumeValue));
        point.setIntensityLevel(intensityLevel);
        point.setFrequency(frequency);
        devicePointRepository.saveAndFlush(point);
    }

    private List<Device> addTestDevices(int count) {
        List<Device> devices = new ArrayList<Device>();
        for (int i = 0; i < count; i++) {
            Device device = new Device();
            device.setSoundCardName("Аудиокарта" + i);
            device.setHeadphoneName("Наушники" + i);
            deviceRepository.saveAndFlush(device);
            devices.add(device);
        }
        return devices;
    }

    private void addTemplatePointForTest(Template template, Frequency frequency, Integer intensityLevel) {
        TemplatePoint templatePoint = new TemplatePoint();
        templatePoint.setTemplate(template);
        templatePoint.setFrequency(frequency.getValue());
        templatePoint.setInrensityValue(intensityLevel);
        templatePointRepository.save(templatePoint);
        System.out.println("Template point added");
    }

    private List<Template> addTemplateForTest(int count) {
        List<Template> templates = new ArrayList<Template>();
        for (int i = 0; i < count; i++) {
            Template template = new Template();
            template.setName("First template");
            template.setAuthor(userRepository.findOne(1L));
            templateRepository.save(template);
            System.out.println("Template added");
            templates.add(template);
        }
        return templates;
    }

    private void addPatientForTest() {
        Patient patient = new Patient();
        patient.setFirstName("Гадя");
        patient.setLastName("Хренова");
        patient.setMiddleName("Петрович");
        patient.setSex("Female");
        User userForPatient = addTestUserForPatient();
        patient.setDoctor(userForPatient);

        patientRepository.save(patient);

        System.out.println("Patient added");
    }

    private User addTestUserForPatient() {
        User user = new User();
        user.setFirstName("dfghjkfttft");
        user.setLastName("qwerty");
        user.setUserType("Admin");
        user.setEmail("11@qw.ru");
        user.setPassword("sde");
        user.setMiddleName("qwqqq");

        userRepository.save(user);

        return user;
    }

    private User addTestUser() {
        User user = new User();
        user.setFirstName("Pop");
        user.setLastName("qwerty");
        user.setUserType("Admin");
        user.setEmail("11@qw.ru");
        user.setPassword("sde");
        user.setMiddleName("qwqqq");

        userRepository.save(user);

        System.out.println("User added");
        return user;
    }

}
