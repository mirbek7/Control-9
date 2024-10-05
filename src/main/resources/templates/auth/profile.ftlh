<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Профиль</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Профиль пользователя</h1>

    <div class="card mb-4">
        <div class="card-body">
            <h5 class="card-title">${user.fullName}</h5>
            <p>Читательский билет: ${user.libraryCardNumber}</p>
        </div>
    </div>

    <h2>Заявки на книги</h2>

    <form action="/profile" method="get" class="mb-4">
        <input type="hidden" name="userId" value="${user.id}">
        <div class="row">
            <div class="col">
                <label for="startDate">С:</label>
                <input type="date" id="startDate" name="startDate" class="form-control" value="${startDate!}">
            </div>
            <div class="col">
                <label for="endDate">По:</label>
                <input type="date" id="endDate" name="endDate" class="form-control" value="${endDate!}">
            </div>
            <div class="col">
                <button type="submit" class="btn btn-primary mt-4">Фильтровать</button>
            </div>
        </div>
    </form>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Название книги</th>
            <th>Автор</th>
            <th>Дата возврата</th>
            <th>Статус</th>
            <th>Действия</th>
        </tr>
        </thead>
        <tbody>
        <#list bookRequests as request>
            <tr>
                <td>${request.book.title}</td>
                <td>${request.book.author}</td>
                <td>${request.returnDate}</td>
                <td>
                    <#if request.returnStatus == "ОЖИДАЕТСЯ">
                        <span class="badge bg-warning">Ожидается</span>
                    <#elseif request.returnStatus == "ВОЗВРАЩЕНО">
                        <span class="badge bg-success">Возвращено</span>
                    <#else>
                        <span class="badge bg-danger">Просрочено</span>
                    </#if>
                </td>
                <td>
                    <#if request.returnStatus == "ОЖИДАЕТСЯ">
                        <form action="/returnBook" method="post">
                            <input type="hidden" name="requestId" value="${request.id}">
                            <input type="hidden" name="userId" value="${user.id}">
                            <button type="submit" class="btn btn-danger">Вернуть книгу</button>
                        </form>
                    </#if>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>
