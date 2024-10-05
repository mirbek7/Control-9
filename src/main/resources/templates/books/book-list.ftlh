<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Каталог книг</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f4f8;
        }

        .navbar {
            margin-bottom: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .list-group-item a {
            color: #333;
            text-decoration: none;
        }

        .list-group-item a:hover {
            text-decoration: underline;
        }

        .card {
            border: none;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s;
        }

        .card:hover {
            transform: scale(1.05);
        }

        .pagination {
            justify-content: center;
        }

        .card-img-top {
            height: 100px;
            object-fit: cover;
        }

        .btn-primary, .btn-secondary {
            transition: background-color 0.3s ease;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }

        @media (max-width: 768px) {
            .navbar .navbar-brand {
                font-size: 18px;
            }

            .btn {
                margin-bottom: 5px;
                width: 100%;
            }

            .card-title {
                font-size: 16px;
            }

            .card-text {
                font-size: 14px;
            }
        }
    </style>
</head>
<body>
<div class="container mt-4">
    <nav class="navbar navbar-light bg-light justify-content-between">
        <a class="navbar-brand" href="#">Литература</a>
        <div>
            <a class="btn btn-outline-primary" href="/book">Мои книги</a>
            <a class="btn btn-outline-success" href="/profile">Мой профиль</a>
            <a class="btn btn-outline-info" href="/register">Регистрация</a>
        </div>
    </nav>

    <div class="row mt-4">
        <div class="col-md-3">
            <h4>Жанры:</h4>
            <ul class="list-group">
                <li class="list-group-item"><a href="/">Все</a></li>
                <li class="list-group-item"><a href="#">Остросюжетные</a></li>
                <li class="list-group-item"><a href="#">Религия</a></li>
                <li class="list-group-item"><a href="#">Детские</a></li>
                <li class="list-group-item"><a href="#">Проза</a></li>
            </ul>
        </div>

        <div class="col-md-9">
            <div class="row">
                <#list books as book>
                    <div class="col-md-4 mb-4">
                        <div class="card">
                            <img src="/static/images/No_Image_Available.jpg" class="card-img-top" alt="Изображение книги">
                            <div class="card-body">
                                <h5 class="card-title">${book.author}</h5>
                                <p class="card-text">${book.title}</p>
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

            <nav aria-label="Постраничная навигация">
                <ul class="pagination">
                    <#if currentPage?? && (currentPage?is_number)>
                        <li class="page-item <#if currentPage == 0>disabled</#if>">
                            <a class="page-link" href="?page=${currentPage - 1}&search=${search}">Предыдущая</a>
                        </li>
                    </#if>
                    <#list 0..totalPages as p>
                        <li class="page-item <#if p == currentPage>active</#if>">
                            <a class="page-link" href="?page=${p}&search=${search}">${p + 1}</a>
                        </li>
                    </#list>
                    <#if currentPage < totalPages - 1>
                        <li class="page-item">
                            <a class="page-link" href="?page=${currentPage + 1}&search=${search}">Следующая</a>
                        </li>
                    </#if>
                </ul>
            </nav>
        </div>
    </div>
</div>

<script>
    document.querySelectorAll('.get-book-btn').forEach(button => {
        button.addEventListener('click', function() {
            this.classList.add('btn-secondary');
            this.classList.remove('btn-primary');
            this.disabled = true;
            this.innerText = 'Ожидается';

            const bookId = this.getAttribute('data-id');
            if (!bookId) {
                alert('There seems to be an issue with the data. Please reload the page and try again.');
                resetButtonState(this);
                return;
            }

            const bookIdNumber = Number(bookId);
            if (isNaN(bookIdNumber)) {
                alert('Invalid book ID. Please contact the support team.');
                resetButtonState(this);
            }
        });
    });

    function resetButtonState(button) {
        button.classList.remove('btn-secondary');
        button.classList.add('btn-primary');
        button.disabled = false;
        button.innerText = 'Order';
    }

</script>

</body>
</html>
