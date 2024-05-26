//работающая штука
var data_server;
let num = 1;
async function getNewTask() {
    fetch('/quest/getNewTask')
        .then((response) => {
        return response.json();
    })
        .then((data) => {
        data_server = data;
        let div = document.querySelector('.task');
        div.innerHTML = ''; // Очищаем содержимое div
        const text_task = document.createElement('h1');
        text_task.innerHTML = `Задание ` + num++;
        div.append(text_task);
        const head = document.createElement('p');
        head.innerHTML = data['quotation'];
        div.append(head);
        if (data['image'] !== null) {
            const image = document.createElement('img');
            image.src = './images/pictures/' + data['image']; // Укажите путь к вашему изображению
            div.append(image);
        }
        M.parseMath(div);
        let form = document.createElement('form');
        const labelResult = document.createElement('label');
        form.append(labelResult);

        const button = document.createElement('button');
        button.setAttribute('type', 'button');
        button.innerHTML = 'Нанести удар';
        button.addEventListener('click', async function() {
            if (parseFloat(data_server['answer']) == parseFloat(document.getElementById('user_answer').value)) {
                labelResult.innerHTML = parseFloat(data_server['answer']);
                labelResult.setAttribute('style', 'margin-left:64%; margin-right:2%; color:green; ');
                try {
                    let response = await fetch(`/quest/successTask/${data_server.idTask}`, {
                        method: 'PUT'
                    });
                    if (response.ok) {
                        console.log('Задание успешно завершено');
                    } else {
                        console.error('Ошибка завершения задания:', response.status);
                    }
                } catch (err) {
                    console.error('Ошибка отправки PUT-запроса:', err);
                }
                // Находим элемент изображения по его ID
                let imageToRemove = document.getElementById('anim');
                // Проверяем, существует ли элемент
                if (imageToRemove) {
                    imageToRemove.parentNode.removeChild(imageToRemove); // Удаляем найденный элемент из его родительского элемента
                } else {
                    console.log('Изображение не найдено');
                }
                // Создаем новый элемент для анимации Lottie
                let lottieAnimation = document.createElement('div');
                lottieAnimation.id = 'lottie-animation'; // Устанавливаем ID для нового элемента
                lottieAnimation.style.width = '565px'; // Ширина анимации
                lottieAnimation.style.height = '306px'; // Высота анимации
                // Добавляем элемент в тег body
                document.body.appendChild(lottieAnimation);

                // Загружаем и добавляем анимацию Lottie из файла 1.json
                fetch('./images/animation/1.json')
                    .then(response => response.json()) // Парсим JSON-данные
                    .then(animationData => {
                    bodymovin.loadAnimation({
                        container: lottieAnimation, // Ссылка на элемент
                        renderer: 'svg',
                        loop: false, // или false
                        autoplay: true, // или false
                        animationData: animationData // Данные анимации Lottie JSON
                    });
                })
                    .catch(error => console.log('Ошибка загрузки анимации:', error));
            } else {
                labelResult.innerHTML = parseFloat(data_server['answer']);
                labelResult.setAttribute('style', 'margin-left:64%; margin-right:2%; color:#ff0000');
                try {
                    let response = await fetch(`/quest/failedTask/${data_server.idTask}`, {
                        method: 'PUT'
                    });
                    if (response.ok) {
                        console.log('Задание успешно завершено');
                    } else {
                        console.error('Ошибка завершения задания:', response.status);
                    }
                } catch (err) {
                    console.error('Ошибка отправки PUT-запроса:', err);
                }
                // Находим элемент изображения по его ID
                let imageToRemove = document.getElementById('anim');
                // Проверяем, существует ли элемент
                if (imageToRemove) {
                    imageToRemove.parentNode.removeChild(imageToRemove); // Удаляем найденный элемент из его родительского элемента
                } else {
                    console.log('Изображение не найдено');
                }
                // Создаем новый элемент для анимации Lottie
                let lottieAnimation = document.createElement('div');
                lottieAnimation.id = 'lottie-animation'; // Устанавливаем ID для нового элемента
                lottieAnimation.style.width = '565px'; // Ширина анимации
                lottieAnimation.style.height = '306px'; // Высота анимации
                // Добавляем элемент в тег body
                document.body.appendChild(lottieAnimation);

                // Загружаем и добавляем анимацию Lottie из файла 2.json
                fetch('./images/animation/2.json')
                    .then(response => response.json()) // Парсим JSON-данные
                    .then(animationData => {
                    bodymovin.loadAnimation({
                        container: lottieAnimation, // Ссылка на элемент
                        renderer: 'svg',
                        loop: false, // или false
                        autoplay: true, // или false
                        animationData: animationData // Данные анимации Lottie JSON
                    });
                })
                    .catch(error => console.log('Ошибка загрузки анимации:', error));
            }
            label.remove();
            form.removeChild(input);
            form.removeChild(button);
            const continueButton = document.createElement('button');
            continueButton.innerHTML = 'Продолжить';
            continueButton.setAttribute('type', 'button');
            continueButton.addEventListener('click', async function() {
                let lottieAnimationToRemove = document.getElementById('lottie-animation');
                // Проверяем, существует ли элемент
                if (lottieAnimationToRemove) {
                    lottieAnimationToRemove.parentNode.removeChild(lottieAnimationToRemove); // Удаляем найденный элемент из его родительского элемента
                } else {
                    console.log('Элемент анимации не найден');
                }
                fetch('/quest/isEndQuest')
                    .then(response => {
                    if (response.ok) {
                        return response.json();
                    }
                })
                    .then(data => {
                    if (data) {
                        // Обработка, если квест завершен
                        window.location.href = '/success';
                    } else {
                        // Обработка, если квест не завершен
                        getNewTask();
                    }
                });
            });
            form.append(continueButton);
        });

        let label = document.createElement('label');
        label.innerHTML = '<b>Ваш ответ: </b>';
        label.setAttribute('style', 'color: black');
        form.append(label);

        let input = document.createElement('input');
        input.setAttribute('type', 'text');
        input.setAttribute('name', 'user_answer');
        input.setAttribute('id', 'user_answer');
        form.append(input);
        form.append(button);
        div.appendChild(form);
        let newImage = document.createElement('img');
        newImage.src = './images/аnim.png'; // Устанавливаем атрибут src для указания пути к изображению
        newImage.id = 'anim';
        document.body.appendChild(newImage);
    });
}

getNewTask();

