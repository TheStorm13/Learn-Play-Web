// Выполнение GET-запроса с использованием функции fetch
fetch('/getListNotification')
    .then(response => {
    if (!response.ok) {
        throw new Error('Network response was not ok');
    }
    return response.json(); // Преобразование ответа в формат JSON
})
    .then(data => {
    let no_name = document.querySelector('.fixed-block');
        data.forEach(data1 =>{
            let Div = document.createElement('button');
            Div.classList.add('btn_notification');

            Div.addEventListener('click', async (event) => {
                event.preventDefault();  // Предотвращаем стандартное поведение
                fetch('/viewedNotification/' + data1['id'], {
                    method: 'PUT'
                })
                    .then(response => {
                        if (!response.ok) {
                            throw new Error('Network response was not ok');
                        }
                    })
                    .catch(error => {
                        console.error('Ошибка просмотра уведомления:', error);
                    });
                window.location.href = data1['link'];
            });

            let h1_text = document.createElement('h1');
            h1_text.classList.add('h1_text');
            h1_text.textContent = data1['label'];
            Div.appendChild(h1_text);
            let text_mes = document.createElement('p');
            text_mes.classList.add('h1_text');
            text_mes.textContent = data1['message'];
            Div.appendChild(text_mes);
            let text_time = document.createElement('p');
            text_time.classList.add('text_time');
            text_time.textContent = data1['dateNote'];
            Div.appendChild(text_time);
            no_name.appendChild(Div);

        })
    if (data.length === 0) {
        let text_mes = document.createElement('p');
        text_mes.classList.add('h1_text');
        text_mes.textContent = 'У вас нет уведомлений';
        no_name.appendChild(text_mes);
    }
})
    .catch(error => {
    console.error('Ошибка получения списка уведомлений:', error);
});


//При нажатии на уведомление отправляется этот запрос
/*
// замените на реальный идентификатор
// Выполнение PUT-запроса с использованием функции fetch
fetch('/viewedNotification/${noteId}`, {
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
