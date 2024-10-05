<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Управление пользователями</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Пользователи</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ФИО</th>
            <th>Номер паспорта</th>
            <th>Читательский билет</th>
            <th>Адрес</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.fullName}</td>
                <td>${user.passportNumber}</td>
                <td>${user.libraryCardNumber}</td>
                <td>${user.address}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
