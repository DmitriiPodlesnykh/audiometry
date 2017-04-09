package com.vsu.amm.medframe.component;

import com.vsu.amm.medframe.entity.*;
import com.vsu.amm.medframe.enums.Frequency;
import com.vsu.amm.medframe.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

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
    private final DeviceRepository deviceRepository;

    @Autowired
    private final DevicePointRepository devicePointRepository;

    @Autowired
    public DBinit(PatientRepository patientRepository,
                  UserRepository userRepository1, TemplateRepository templateRepository,
                  TemplatePointRepository templatePointRepository,
                  DeviceRepository deviceRepository,
                  DevicePointRepository devicePointRepository) {
        this.userRepository = userRepository1;
        this.patientRepository = patientRepository;
        this.templateRepository = templateRepository;
        this.templatePointRepository = templatePointRepository;
        this.deviceRepository = deviceRepository;
        this.devicePointRepository = devicePointRepository;
    }

    @PostConstruct
    @Transactional
    public void init() {
        System.out.println("DBinit init() start");

        addTestDevices(4);
        addDevicePoint(1L, Frequency.FREQUENCY_40_HZ, 0, 0.5);
        addDevicePoint(1L, Frequency.FREQUENCY_100_HZ, 0, 0.4);
        addDevicePoint(1L, Frequency.FREQUENCY_250_HZ, 0, 0.3);
    }

    private void addDevicePoint(Long deviceId, Frequency frequency, Integer IntensityLevel, Double volumeValue) {
        DevicePoint point = new DevicePoint();
        point.setDevice(deviceRepository.getOne(deviceId));
        point.setVolumeValue(new BigDecimal(volumeValue));
        point.setIntensityLevel(IntensityLevel);
        point.setFrequency(frequency);
        devicePointRepository.saveAndFlush(point);
    }

    private void addTestDevices(int count) {
        for (int i = 0; i < count; i++) {
            Device device = new Device();
            device.setSoundCardName("Аудиокарта" + i);
            device.setHeadphoneName("Наушники" + i);
            deviceRepository.saveAndFlush(device);
        }
    }

    private void addTemplatePointForTest() {
        TemplatePoint templatePoint = new TemplatePoint();
        templatePoint.setTemplate(templateRepository.findOne(411L));
        templatePoint.setFrequency(4000);
        templatePoint.setInrensityValue(10);
        templatePointRepository.save(templatePoint);
        System.out.println("Template point added");
    }

    private void addTemplateForTest() {
        Template template = new Template();
        template.setName("First template");
        template.setAuthor(userRepository.findOne(1L));
        templateRepository.save(template);
        System.out.println("Template added");
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
