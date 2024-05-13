/*async function start(initialNum) {

    // Запрашиваем данные с сервера
    const response = await fetch('http://localhost:8080/getNewTask'+initialNum);
    const data = await response.json();
  
    // Загружаем полученные данные на страницу
    createTask(data);
  
    // Принимаем действие пользователя
    const userAction = await getUserAction();
  
    // Получаем новое значение
    const newValue = calculateNewValue(data.content, userAction);
  
    // Проверяем достижение условия остановки
    if (newValue === 0) {
      return;
    }
  
    // Вызываем функцию заново с новым значением
    start(newValue);
  }






function createTask (data) {
    var elemBefore = document.getElementById("button");
    let div = document.querySelector('a');
    const text_task = document.createElement('h1');
    text_task.innerHTML = `Задание ${data['idTask']}`;
    //text_task.innerHTML = `Задание ${i}`;
    div.append(text_task);
    const head = document.createElement('p');
    head.innerHTML = `${data['quotation']}`;
    // elemBefore.parentNode.insertBefore(head, elemBefore);
    div.append(head);

    var elemBefore = document.getElementById("body");
    let form = document.querySelector('form');
    let label = document.createElement('label');
    label.innerHTML = `<b>Ваш ответ: </b>`;
    label.setAttribute('style', 'color:black');
    form.append(label);
    const input = document.createElement('input');
    input.setAttribute('type', 'text');
    input.setAttribute('name', 'user_answer');
    input.setAttribute('id', 'user_answer');
    label.append(input);
    const button = document.createElement('button');
    button.setAttribute('type', 'submit');
    button.innerHTML = `Нанести удар`;
    form.append(button);
}*/


//работающая штука
var data_server;
const urlParams = new URLSearchParams(window.location.search);
const value1 = urlParams.get('topicId');
const value2 = urlParams.get('value') % 3 + 1;

function fetchData(value1, value2) {
    fetch('http://localhost:8080/getNewTask/' + value1 + '/' + value2)
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            data_server = data;
            var div = document.createElement('div');
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
                    labelResult.innerHTML = 'Правильно';
                } else {
                    labelResult.innerHTML = 'Неправильно';
                }
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
            label.innerHTML = '<b>Введите ваш ответ: </b>';
            label.setAttribute('style', 'color: black');
            form.append(label);

            let input = document.createElement('input');
            input.setAttribute('type', 'text');
            input.setAttribute('name', 'user_answer');
            input.setAttribute('id', 'user_answer');
            form.append(input);


            form.append(button);

            document.body.append(div); // добавляем div в тело документа
            document.body.append(form); // добавляем form в тело документа
        });
}

fetchData(value1, value2); // вызываем функцию с передачей параметров value1 и value2
