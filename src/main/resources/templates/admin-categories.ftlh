<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Управление категориями книг</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Категории книг</h1>

    <form action="/admin/categories/add" method="post" class="mb-3">
        <div class="input-group">
            <label>
                <input type="text" name="name" class="form-control" placeholder="Название категории" required>
            </label>
            <button class="btn btn-primary" type="submit">Добавить категорию</button>
        </div>
    </form>

    <ul class="list-group">
        <#list categories as category>
            <li class="list-group-item d-flex justify-content-between align-items-center">
                ${category.name}
                <form action="/admin/categories/delete" method="post" style="margin: 0;">
                    <input type="hidden" name="categoryId" value="${category.id}">
                    <button type="submit" class="btn btn-danger btn-sm">Удалить</button>
                </form>
            </li>
        </#list>
    </ul>
</div>
</body>
</html>
