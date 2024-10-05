<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Запрос на получение книги</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<div class="container">
    <h1>Запрос на получение книги</h1>
    <#if error??>
        <div class="alert alert-danger">
            ${error}
        </div>
    </#if>

    <form action="/book-request?bookId=${book.id}" method="post">
        <div class="form-group">
            <label>Название книги:</label>
            <label>
                <input type="text" class="form-control" value="${book.title}" readonly>
            </label>
        </div>

        <div class="form-group">
            <label>Автор:</label>
            <label>
                <input type="text" class="form-control" value="${book.author}" readonly>
            </label>
        </div>

        <div class="form-group">
            <label>Номер читательского билета:</label>
            <label>
                <input type="text" class="form-control" name="libraryCardNumber" required>
            </label>
        </div>

        <div class="form-group">
            <label>Дата возврата:</label>
            <label>
                <input type="date" class="form-control" value="${bookRequest.returnDate}" readonly>
            </label>
        </div>
        <button type="submit" class="btn btn-primary">Подать заявку</button>
    </form>
</div>
</body>
</html>

