<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Управление книгами</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Книги</h1>

    <form action="/admin/books/add" method="post" class="mb-4">
        <div class="row mb-3">
            <div class="col">
                <label for="title">Название книги:</label>
                <input type="text" id="title" name="title" class="form-control" placeholder="Введите название книги" required>
            </div>
            <div class="col">
                <label for="author">Автор:</label>
                <input type="text" id="author" name="author" class="form-control" placeholder="Введите имя автора" required>
            </div>
        </div>

        <div class="row mb-3">
            <div class="col">
                <label for="categoryId">Категория:</label>
                <select id="categoryId" name="categoryId" class="form-select" required>
                    <option value="" disabled selected>Выберите категорию</option>
                    <#list categories as category>
                        <option value="${category.id}">${category.name}</option>
                    </#list>
                </select>
            </div>
        </div>

        <button type="submit" class="btn btn-primary">Добавить книгу</button>
    </form>

    <h2>Список книг</h2>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Название</th>
            <th>Автор</th>
            <th>Категория</th>
            <th>Доступность</th>
            <th>Действия</th>
        </tr>
        </thead>
        <tbody>
        <#list books as book>
            <tr>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.category.name}</td>
                <td>
                    <#if book.isAvailable>
                        <span class="badge bg-success">Доступно</span>
                    <#else>
                        <span class="badge bg-danger">Недоступно</span>
                    </#if>
                </td>
                <td>
                    <form action="/admin/books/delete" method="post" style="display:inline;">
                        <input type="hidden" name="bookId" value="${book.id}">
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
