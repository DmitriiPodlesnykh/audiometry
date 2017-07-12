<#include "header.ftl">
<div class="create-test-form">
    <div id="addDeviceFormBody">
        <div>
            <label>Пациент: </label>
            <select class="patient-selector" id="patient-selector-id" name="patient-selector">
            <#list patientList as patient>
                <option value="${patient.getId()}">${patient.getFirstName()}</option>
            </#list>
            </select>
        </div>
        <div>
            <label>Шаблон: </label>
            <select class="template-selector" id="template-selector-id" name="template-selector">
            <#list templateList as template>
                <option value="${template.getId()}">${template.getName()}</option>
            </#list>
            </select>
        </div>
        <input type="button" class="create-test" name="create-test" value="Начать тест">
    </div>
</div>