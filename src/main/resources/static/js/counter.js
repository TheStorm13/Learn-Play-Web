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
console.log(arr);


const callback = () => {
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
    /*alert("Hello, World!");*/
};
const button = document.querySelector('#GET_btn');
button.addEventListener('click', callback);

const buttonDaily = document.querySelector('.btn_right');
buttonDaily.addEventListener('click', () => {
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
});