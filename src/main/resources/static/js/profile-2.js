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
    // let achievements = data['achievement'];
    // achievements.forEach((achievement) => {
    //     let blockProgress = document.querySelector('.success');
    //     blockProgress.classList.add('block-progress');
    //     let progressP = document.createElement('p');
    //     progressP.classList.add('back-text');
    //     progressP.textContent = `${achievement[0]}`;
    //     progressP.appendChild(blockProgress);
    //     //функция для высчитывания процентов для достижений
    //     let progressBar = document.getElementById('progress-bar1');
    //     let progressText = document.querySelector('.progress-text');
    //     progressBar.style.width = `${(achievement[2]/achievement[1])*100}%`;
    //     progressText.textContent = `${(achievement[2]/achievement[1])*100}/${achievement[1]}`;
    //     });

        let achievements = data['achievement'];
        achievements.forEach((achievement) => {
            if(achievement[2]!==0) {
            // Создаем контейнер для прогресса
            let blockProgress = document.createElement('div');
            blockProgress.classList.add('block-progress');

            let ProgressContainer = document.createElement('div');
            ProgressContainer.classList.add('progress-container');

            // Создаем текстовый элемент для отображения прогресса
            let progressP = document.createElement('p');
            progressP.classList.add('back-text');
            progressP.textContent = `${achievement[0]}`;

            // Создаем прогресс-бар
            let progressBar = document.createElement('div');
            progressBar.classList.add('progress-bar');

            // Создаем текстовый элемент для отображения процентов прогресса
            let progressText = document.createElement('span');
            progressText.classList.add('progress-text');

            // Высчитываем проценты для прогресса
            let progressPercent = (achievement[2]/achievement[1])*100;
            progressBar.style.width = `${progressPercent}%`;
            progressText.textContent = `${achievement[2]}/${achievement[1]}`;

            // Добавляем элементы в контейнер
            blockProgress.appendChild(progressP);
            ProgressContainer.appendChild(progressBar);
            ProgressContainer.appendChild(progressText);
            blockProgress.appendChild(ProgressContainer);

            // Добавляем контейнер на страницу
                document.querySelector('.any_elem').appendChild(blockProgress);}
            else {
                console.log(achievement[0]);
                console.log(achievement[1]);
                console.log(achievement[2]);
            }
        });
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
//
// //функция для высчитывания процентов для достижений
// const progressBar = document.getElementById('progress-bar1');
// const progressText = document.querySelector('.progress-text');
//
// function updateProgressBar(done, all) {
//     progressBar.style.width = `${(done/all)*100}%`;
//     progressText.textContent = `${(done/all)*100}/${all}`;
//
//     // let progressBarDiv = document.querySelector('.progress-bar1');
//     // let progressP = document.createElement('p');
//     // progressP.classList.add('p_progress_bar');
//     // progressP.textContent = '30/60';
//     //     // progressP.textContent = `${data['userName']}`;
//     // progressBarDiv.appendChild(progressP);
// }
// updateProgressBar(50,100);
//
