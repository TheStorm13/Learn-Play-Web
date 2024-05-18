fetch('/quest/successQuest')
    .then(response => {
    if (response.ok) {
        return response.json();
    }
    throw new Error('Network response was not ok.');
})
    .then(data => {
    let questResultElement = document.getElementById('questResult');

    if (data) {
        // Обработка, если пользователь прошел квест
        questResultElement.textContent = 'Вы победили!';
    } else {
        // Обработка, если пользователь не прошел квест
        questResultElement.textContent = 'Вы проиграли!';
    }
})
    .catch(error => {
    // Обработка ошибок
    console.error('Ошибка при получении статуса квеста:', error);
});