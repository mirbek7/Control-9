<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Управление заявками на книги</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Заявки на книги</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Название книги</th>
            <th>Автор</th>
            <th>Читатель</th>
            <th>Читательский билет</th>
            <th>Дата возврата</th>
            <th>Статус возврата</th>
            <th>Действия</th>
        </tr>
        </thead>
        <tbody>
        <#list requests as request>
            <tr>
                <td>${request.book.title}</td>
                <td>${request.book.author}</td>
                <td>${request.user.fullName}</td>
                <td>${request.user.libraryCardNumber}</td>
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
                    <form action="/admin/requests/delete" method="post" style="display:inline;">
                        <input type="hidden" name="requestId" value="${request.id}">
                        <button type="submit" class="btn btn-danger btn-sm">Удалить</button>
                    </form>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
