document.querySelector('form').addEventListener('submit', async function(event) {
    event.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const userData = {
                username: email,
                password: password
    };

    try {
        const response = await fetch('/entry', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
        });

        if (response.ok) {
                window.location.href = '/education';
        } else {
            const errorMessageElement = document.getElementById('error-message');
            errorMessageElement.textContent = 'Неверный email или пароль!';
        }
    } catch (error) {
        console.error('Ошибка при выполнении запроса:', error);
    }
});