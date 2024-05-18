//работающая штука
var data_server;
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
        text_task.innerHTML = `Задание ${data['idTask']}`;
        div.append(text_task);
        const head = document.createElement('p');
        head.innerHTML = data['quotation'];
        div.append(head);
        M.parseMath(div);

        let form = document.createElement('form');
        const labelResult = document.createElement('label');
        form.append(labelResult);

        const button = document.createElement('button');
        button.setAttribute('type', 'button');
        button.innerHTML = 'Нанести удар';
        button.addEventListener('click', async function() {
            if (data_server['answer'] == document.getElementById('user_answer').value) {
                labelResult.innerHTML = data_server['answer'];
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
            } else {
                labelResult.innerHTML = data_server['answer'];
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
            }
            label.remove();
            form.removeChild(input);
            form.removeChild(button);
            const continueButton = document.createElement('button');
            continueButton.innerHTML = 'Продолжить';
            continueButton.setAttribute('type', 'button');
            continueButton.addEventListener('click', async function() {
                fetch('/quest/isEndQuest')
                    .then(response => {
                    if (response.ok) {
                        return response.json();
                    }
                })
                    .then(data => {
                    console.log(data)
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
    });
}

getNewTask();

