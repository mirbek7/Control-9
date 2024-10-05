<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Список книг</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <#list books as book>
            <div class="col-md-4 mb-4">
                <div class="card">
                    <#if book.imagePreview??>
                        <img src="${book.imagePreview}" class="card-img-top" alt="Изображение книги">
                    <#else>
                        <img src="/images/default-image.png" class="card-img-top" alt="Изображение по умолчанию">
                    </#if>
                    <div class="card-body">
                        <h5 class="card-title">${book.author! 'Автор не указан'}</h5>
                        <p class="card-text">${book.title! 'Название не указано'}</p>
                        <#if book.id??>
                            <button class="btn btn-primary get-book-btn" data-id="${book.id}">Получить</button>
                        <#else>
                            <button class="btn btn-secondary" disabled>Идентификатор книги не найден</button>
                        </#if>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $('.get-book-btn').on('click', function () {
        const bookId = $(this).data('id');
        alert('Вы выбрали книгу с ID: ' + bookId);
    });
</script><script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $('.get-book-btn').on('click', function () {
        const bookId = $(this).data('id');

        $.ajax({
            url: '/api/book/' + bookId,
            method: 'GET',
            success: function (data) {
                alert('Вы выбрали книгу: ' + data.title + ' автора ' + data.author);
            },
            error: function () {
                alert('Произошла ошибка при получении книги.');
            }
        });
    });
</script>

</body>
</html>
