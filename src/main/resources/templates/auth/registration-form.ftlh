<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Регистрация</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #f0f4f8, #d9e2ec);
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 500px;
            background: white;
            padding: 30px;
            margin: 5% auto;
            border-radius: 10px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
            position: relative;
        }
        .form-group label {
            font-size: 14px;
            color: #333;
        }
        .form-control {
            width: 100%;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
            transition: all 0.3s ease;
        }
        .form-control:focus {
            border-color: #007bff;
            outline: none;
        }
        .alert {
            color: red;
            font-size: 12px;
            margin-top: 5px;
        }
        .btn-primary {
            background: #007bff;
            color: white;
            padding: 12px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            transition: background 0.3s ease;
        }
        .btn-primary:hover {
            background: #0056b3;
        }
        @media (max-width: 768px) {
            .container {
                padding: 20px;
            }
            .form-group {
                margin-bottom: 10px;
            }
            .btn-primary {
                padding: 10px;
            }
        }
        .form-group i {
            position: absolute;
            right: 15px;
            top: 35px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Регистрация читателя</h1>

    <form action="/register" method="post">
        <div class="form-group">
            <label for="fullName">ФИО:</label>
            <input type="text" id="fullName" name="fullName" class="form-control" required>
            <div id="errorFullName" class="alert"></div>
        </div>

        <div class="form-group">
            <label for="address">Адрес:</label>
            <input type="text" id="address" name="address" class="form-control" required>
            <div id="errorAddress" class="alert"></div>
        </div>

        <div class="form-group">
            <label for="passportNumber">Номер паспорта:</label>
            <input type="text" id="passportNumber" name="passportNumber" class="form-control" required>
            <div id="errorPassportNumber" class="alert"></div>
        </div>

        <div class="form-group">
            <label for="password">Пароль:</label>
            <input type="password" id="password" name="password" class="form-control" required>
            <i class="fas fa-eye" id="togglePassword"></i>
            <div id="errorPassword" class="alert"></div>
        </div>

        <div class="form-group">
            <label for="confirmPassword">Подтвердите пароль:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" required>
            <div id="errorConfirmPassword" class="alert"></div>
        </div>

        <button type="submit" class="btn btn-primary">Получить читательский билет</button>
    </form>
</div>

<script>
    const togglePassword = document.querySelector('#togglePassword');
    const password = document.querySelector('#password');

    togglePassword.addEventListener('click', function (e) {
        const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
        password.setAttribute('type', type);
        this.classList.toggle('fa-eye-slash');
    });

    const form = document.querySelector('form');
    form.addEventListener('submit', function (e) {
        let hasError = false;

        document.querySelectorAll('.alert').forEach(alert => alert.innerText = '');

        const fullName = document.getElementById('fullName').value.trim();
        const address = document.getElementById('address').value.trim();
        const passportNumber = document.getElementById('passportNumber').value.trim();
        const password = document.getElementById('password').value.trim();
        const confirmPassword = document.getElementById('confirmPassword').value.trim();

        if (fullName === '') {
            document.getElementById('errorFullName').innerText = 'Пожалуйста, введите ФИО.';
            hasError = true;
        }
        if (address === '') {
            document.getElementById('errorAddress').innerText = 'Пожалуйста, введите адрес.';
            hasError = true;
        }
        if (passportNumber === '') {
            document.getElementById('errorPassportNumber').innerText = 'Пожалуйста, введите номер паспорта.';
            hasError = true;
        }
        if (password === '') {
            document.getElementById('errorPassword').innerText = 'Пожалуйста, введите пароль.';
            hasError = true;
        }
        if (password !== confirmPassword) {
            document.getElementById('errorConfirmPassword').innerText = 'Пароли не совпадают.';
            hasError = true;
        }
        if (hasError) {
            e.preventDefault();
        }
    });
</script>
</body>
</html>

