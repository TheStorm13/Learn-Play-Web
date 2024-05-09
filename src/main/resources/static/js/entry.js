document.querySelector('form').addEventListener('submit', async function(event) {
    event.preventDefault();

    const email = encodeURIComponent(document.getElementById('email').value);
        const password = encodeURIComponent(document.getElementById('password').value);

    const userData = `username=${email}&password=${password}`;

    try {
        const response = await fetch('/entry', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: userData
        });

        if (response.status === 200) {
                window.location.href = '/education';
        }
        if (response.status === 401) {
        const errorMessageElement = document.getElementById('error-message');
        errorMessageElement.textContent = 'Неверный email или пароль!';
        }

        console.log(response.text())
    } catch (error) {
        console.error('Ошибка при выполнении запроса:', error);
    }
});