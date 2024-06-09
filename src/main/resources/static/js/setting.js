document.getElementById('email').addEventListener('submit', function(event) {
    event.preventDefault(); // Предотвращаем стандартное поведение отправки формы, чтобы обрабатывать запрос

    let newEmail = document.querySelector('input[name="new_email"]').value;

    fetch('/setting/changeEmail/' + newEmail, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => {
        if (response.ok) {
            return response.json(); // Возвращаем JSON тело ответа
        }
        throw new Error('Network response was not ok.');
    })
        .then(data => {
        if (data) {
            // Ваша логика обработки успешного изменения почты
            alert("Почта успешно изменена!");
        } else {
            alert("Произошла ошибка!");
        }
    })
        .catch(error => {
        // Обрабатываем ошибку
        console.error('Произошла ошибка:', error);
    });
});

document.getElementById('pass').addEventListener('submit', function(event) {
    event.preventDefault(); // Предотвращаем стандартное поведение отправки формы

    let oldPassword = this.querySelector('input[name="last_password"]').value;
    let newPassword = this.querySelector('input[name="new_password"]').value;
    let newPassword2 = this.querySelector('input[name="new_password2"]').value;

    if (newPassword === newPassword2) {
        fetch('/setting/changePassword/' + oldPassword + '/' + newPassword, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => {
            if (response.ok) {
                return response.json(); // Возвращаем JSON тело ответа
            }
            throw new Error('Network response was not ok.');
        })
            .then(data => {
            // Обрабатываем успешный ответ от сервера
            console.log(data);
            if (data) {
                // Ваша логика обработки успешного изменения пароля
                alert("Пароль успешно изменен!");
            } else {
                alert("Произошла ошибка!");
            }
        })
            .catch(error => {
            // Обрабатываем ошибку
            console.error('Произошла ошибка:', error);
        });
    }
    else {
        alert("Пароли не совпадают!");
    }
});

// Находим форму выхода и добавляем обработчик события на клик
document.getElementById('exit_btn').addEventListener('click', function() {
    fetch('/logout', {
        method: 'POST'
    })
        .then(response => {
        if (response.status === 200) {
            // Обработка успешного выхода
            alert("Вы успешно вышли из системы");
            window.location.replace("/"); // Перенаправляем пользователя на главную страницу или другую страницу по вашему выбору
        } else {
            // Обработка ошибки выхода
            alert("Произошла ошибка при попытке выхода");
        }
    })
        .catch(error => {
        // Обработка ошибки сети или других ошибок
        console.error('Произошла ошибка:', error);
    });
});

/*
function sendDailyNoticeRequest() {
    let checkbox = document.querySelector('.notification-buttton');
    let active = checkbox.checked;

    fetch(`/setting/switchDailyNotice/${active}`, {
        method: 'PUT'
    }).then(response => {
        if (response.ok) {
            console.log('Статус ежедневного уведомления обновлен');
        } else {
            console.error('Ошибка при обновлении статуса');
        }
    }).catch(error => {
        console.error('Ошибка:', error);
    });
}*/
