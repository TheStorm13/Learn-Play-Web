// Получаем ссылку на элементы
const userNameElement = document.getElementById('userName');
const editNameButton = document.getElementById('editName');

// Добавляем обработчик события для клика по изображению
editNameButton.addEventListener('click', function() {
    let newName = userNameElement.textContent.trim(); // Получаем новое имя, удаляем лишние пробелы

    // Выполняем PUT запрос на сервер для обновления имени
    fetch('/profile/changeName/' + newName, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
    })
        .then(response => {
        if (response.ok) {
            alert('Имя успешно обновлено!');
        } else {
            alert('Ошибка при обновлении имени');
        }
    })
        .catch(error => {
        console.error('Произошла ошибка:', error);
    });
});

