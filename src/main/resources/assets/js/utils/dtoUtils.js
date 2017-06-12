function getCreateTestDto(testId, templateId, patientId, userId, testPoints) {
    var createTestDto = {};
    createTestDto.testId = testId;
    createTestDto.templateId = templateId;
    createTestDto.patientId = patientId;
    createTestDto.userId = userId;
    createTestDto.testPoints = testPoints;
    return createTestDto;
}

function createTemplateDto() {

}

function createPatientDto() {

}

function getTestPointsDto() {
    
}

function getTestPoint(id, frequency, intensityLevel, testId, status) {
    var testPointDto = {};
    testPointDto.id = id;
    testPointDto.frequency = frequency;
    testPointDto.intensityLevel = intensityLevel;
    testPointDto.testId = testId;
    testPointDto.status = status;
    return testPointDto;
}
