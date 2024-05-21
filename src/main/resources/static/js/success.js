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
            const image = document.createElement('img');
            image.src = './images/win.png';
            questResultElement.appendChild(image);

            const textElement = document.createElement('p');
            textElement.textContent = 'Вы победили!';
            questResultElement.appendChild(textElement);
        } else {
            // Обработка, если пользователь не прошел квест
            const image = document.createElement('img');
            image.src = './images/lose.png';
            questResultElement.appendChild(image);

            const textElement = document.createElement('p');
            textElement.textContent = 'Попробуйте ещё раз!';
            questResultElement.appendChild(textElement);
        }
})
    .catch(error => {
    // Обработка ошибок
    console.error('Ошибка при получении статуса квеста:', error);
});