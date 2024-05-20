// Выполнение GET-запроса с использованием функции fetch
fetch('/getListNotification')
    .then(response => {
    if (!response.ok) {
        throw new Error('Network response was not ok');
    }
    return response.json(); // Преобразование ответа в формат JSON
})
    .then(data => {
    // Вывод полученного списка уведомлений в консоль
    console.log('Список уведомлений:', data);
})
    .catch(error => {
    console.error('Ошибка получения списка уведомлений:', error);
});


//При нажатии на уведомление отправляется этот запрос
/*
// замените на реальный идентификатор
// Выполнение PUT-запроса с использованием функции fetch
fetch(`/viewedNotification/${noteId}`, {
    method: 'PUT'
})
    .then(response => {
    if (!response.ok) {
        throw new Error('Network response was not ok');
    }
    console.log('Уведомление помечено как просмотренное');
})
    .catch(error => {
    console.error('Ошибка просмотра уведомления:', error);
});
*/
