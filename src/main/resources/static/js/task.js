//работающая штука
var data_server;
const urlParams = new URLSearchParams(window.location.search);
const value1 = urlParams.get('topicId');
const value2 = urlParams.get('value') % 3 + 1;

fetch('http://localhost:8080/getNewTask/' + value1 + '/' + value2)
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            data_server = data;
            let div = document.querySelector('.task');
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
            button.innerHTML = 'Проверить ответ';
            button.addEventListener('click', function() {
                if (data_server['answer'] === document.getElementById('user_answer').value) {
                    labelResult.innerHTML = data_server['answer'];
                    labelResult.setAttribute('style', 'margin-left:64%; margin-right:2%; color:green; ');
                } else {
                    labelResult.innerHTML = data_server['answer'];
                    labelResult.setAttribute('style', 'margin-left:64%; margin-right:2%; color:#ff0000');
                }
                label.remove();
                form.removeChild(input);
                form.removeChild(button);
                const continueButton = document.createElement('button');
                continueButton.innerHTML = 'Продолжить';
                continueButton.setAttribute('type', 'button');
                continueButton.addEventListener('click', function() {
                    location.reload(); // обновляем страницу для получения нового задания
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
