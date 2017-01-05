<form name="patient" role="form" action="/patients/add" method="post">
    <div>
        <label>Имя:</label>
        <input type="text" name="firstName">
    </div>
    <div>
        <label>Фамилия:</label>
        <input type="text" name="lastName">
    </div>
    <div>
        <label>Отчество:</label>
        <input type="text" name="middleName">
    </div>
    <div>
        <label>Пол:</label>
        <input type="radio" name="sex" value="male">Мужской
        <input type="radio" name="sex" value="female">Женский
    </div>
    <div>
        <label>Дата рождения:</label>
        <input type="date" name="birthday">
    </div>
    <div>
        <label>Дополнительно:</label>
        <input type="text" name="description">
    </div>
    <input type="hidden" name="doctorId" value="1">
    <button type="submit" id="submit">Добавить пациента</button>
</form>