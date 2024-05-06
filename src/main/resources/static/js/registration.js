document.querySelector('form').addEventListener('submit', async function(event) {
    event.preventDefault();

    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const password2 = document.getElementById('password2').value;

    if (password != password2) {
    const errorMessageElement = document.getElementById('error-message');
    errorMessageElement.textContent = 'Пароли не совпадают!';
    }
    else {
    const userData = {
            name: name,
            email: email,
            password: password
        };

        try {
            const response = await fetch('/registration/addUser', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(userData)
            });

            if (response.status === 201) {
                window.location.href = '/education'; // Перенаправление на страницу '/education' при успешной отправке данных
            } else if (response.status === 409) {
                const errorMessageElement = document.getElementById('error-message');
                errorMessageElement.textContent = 'Пользователь с таким email уже существует!';
            }
        } catch (error) {
            console.error('Ошибка при выполнении запроса:', error);
        }
    }

});