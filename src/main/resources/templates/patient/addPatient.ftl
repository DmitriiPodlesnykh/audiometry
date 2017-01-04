<form name="patient" role="form" action="/patients/addpatient" method="post">
    <div>
        <label>Имя:</label>
        <input type="text" name="first-name">
    </div>
    <div>
        <label>Фамилия:</label>
        <input type="text" name="last-name">
    </div>
    <div>
        <label>Отчество:</label>
        <input type="text" name="middle-name">
    </div>
    <div>
        <label>Пол:</label>
        <input type="radio" name="gender" value="male">Мужской
        <input type="radio" name="gender" value="female">Женский
    </div>
    <div>
        <label>Дата рождения:</label>
        <input type="date" name="birth-date">
    </div>
    <div>
        <label>Дополнительно:</label>
        <input type="text" name="description">
    </div>
    <input type="hidden" name="doctor-id" value="1">
    <button type="submit" id="submit">Добавить пациента</button>
</form>