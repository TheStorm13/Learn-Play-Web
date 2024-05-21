fetch('/profile/info')
    .then((response) => {
    return response.json();
})
    .then((data) => {
    document.getElementById('userName').innerText = data['userName'];
    document.getElementById('percent').innerText = (data['multiplier'] * 100) + '%';
    document.getElementById('exp').innerText = data['exp'];
    document.getElementById('top').innerText = data['rankPlace'];
    // Создание элемента изображения
    let img = document.createElement('img');
    var count = Math.floor(data['exp'] / 100) + 1
    if (count > 7) {
        count = 7;
    }
    img.src = './images/leagues/' + count + '.png';
    img.width = 21;
    img.height = 25;
    // Нахождение div-элемента
    let div = document.getElementById('img')
    // Вставка изображения в div
    div.appendChild(img);
});

// Получаем ссылку на элементы
const userNameElement = document.getElementById('userName');
const editNameButton = document.getElementById('editName');

userNameElement.addEventListener('keydown', function(e) {
    if (e.key === "Enter") {
        e.preventDefault(); // Предотвращаем создание новой строки при нажатии Enter
        // Можно также добавить обработку для сохранения изменений или отправки запроса на сервер
    }
});
// Добавляем обработчик события для клика по кнопке
editNameButton.addEventListener('click', function() {
    let newName = userNameElement.textContent.trim(); // Получаем новое имя, удаляем лишние пробелы

    // Выполняем PUT запрос на сервер для обновления имени
    fetch('/profile/changeName/' + newName, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ newName: newName }) // Отправляем новое имя в формате JSON
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
