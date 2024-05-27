const counters = document.querySelectorAll('.counter');
let arr = Array(18).fill(0);
counters.forEach(counter => {
    const count = counter.querySelector('.count');
    const plusBtn = counter.querySelector('.plus');
    const minusBtn = counter.querySelector('.minus');
    const id = counter.querySelector('.plus').id.replace('plus', ''); // Extracting the number from the button id

    let value = 0;

    plusBtn.addEventListener('click', () => {
        value++;
        count.textContent = value;
        arr[id-1] = value;
    });

    minusBtn.addEventListener('click', () => {
        value = Math.max(0, value - 1);
        count.textContent = value;
        arr[id-1] = value;
    });
});

const callback = () => {
    if (arr.every(element => element === 0)) {
        alert('Выберите задания');
    } else {
        fetch('/quest/startUserQuest', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ listTask: arr })
        }).then(response => {
            if(response.ok) {
                // Обработка успешного ответа
                window.location.href = '/quest';
            } else {
                // Обработка ошибки
                console.error('Ошибка:', response.status);
            }
        });
    }
};

const button = document.querySelector('#GET_btn');
button.addEventListener('click', callback);

const buttonDaily = document.querySelector('.btn_right');
buttonDaily.addEventListener('click', () => {
    fetch('/profile/isDailyQuest')
        .then(response => response.json())
        .then(isDailyQuest => {
        console.log(isDailyQuest);
        if (isDailyQuest) {
            fetch('/quest/startDailyQuest', {
                method: 'POST',
            })
                .then(response => {
                if(response.ok) {
                    // Если запрос выполнен успешно, перенаправляем пользователя
                    window.location.href = '/quest';
                } else {
                    // Обрабатываем ошибку, если не удалось выполнить запрос
                    console.error('Ошибка:', response.status);
                }
            })
        } else {
            alert('Вы уже прошли ежедневный квест')
        }
    })
        .catch((error) => {
        console.error('Ошибка при выполнении запроса:', error);
    });

});

const buttonRandom = document.querySelector('.btn_left');
buttonRandom.addEventListener('click', () => {
    fetch('/quest/startRandomQuest', {
        method: 'POST',
    })
        .then(response => {
        if(response.ok) {
            // Если запрос выполнен успешно, перенаправляем пользователя
            window.location.href = '/quest';
        } else {
            // Обрабатываем ошибку, если не удалось выполнить запрос
            console.error('Ошибка:', response.status);
        }
    })
});