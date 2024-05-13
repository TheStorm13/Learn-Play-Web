

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
            //var elemBefore = document.getElementById("button");
            let div = document.createElement('div');
            const text_task = document.createElement('h1');
            text_task.innerHTML = `Задание ${data['idTask']}`;
            div.append(text_task);
            const head = document.createElement('p');
            head.innerHTML = data['quotation'];
            div.append(head);
            M.parseMath(div);

            let form = document.createElement('form');
            let label = document.createElement('label');
            label.innerHTML = '<b>Ваш ответ: </b>';
            label.setAttribute('style', 'color: black');
            form.append(label);
            const input = document.createElement('input');
            input.setAttribute('type', 'text');
            input.setAttribute('name', 'user_answer');
            input.setAttribute('id', 'user_answer');
            label.append(input);
            const button = document.createElement('button');
            button.setAttribute('type', 'submit');
            button.innerHTML = 'Нанести удар';
            form.append(button);
            document.body.append(div); // добавляем div в тело документа
            document.body.append(form); // добавляем form в тело документа
        });
}

fetchData(value1, value2); // вызываем функцию с передачей параметров value1 и value2

document.addEventListener(`DOMContentLoaded`, function () {

    const form = document.getElementById(`form`);

    const addButton = document.getElementById(`addInput`);
    const newInput = document.createElement(`input`);

    newInput.type = `text`;
});

function handleFormSubmit(event) {
    event.preventDefault()
    const name = form.querySelector('[name="user_answer"]');
    const data = {
        name: name.value,
    };
    if (data_server['idTask'] == name.value) {
        var form_for_task = document.getElementById("form");
        console.log('remove');
        form_for_task.remove();
        var elemBefore = document.getElementById("form");
        let div = document.querySelector('div');
        let div_elem = document.createElement('div_elem');
        div.append(div_elem);
        const label = document.createElement('label');
        label.innerHTML = `<b>Правильно</b>`;
        // label.setAttribute('style', 'color:green; ');
        label.setAttribute('style', 'margin-left:64%; margin-right:2%; color:green; ');
        div_elem.append(label);
        const btn = document.createElement('button');
        btn.innerHTML = `Продолжить`;
        div_elem.append(btn);
    } else {
        var form_for_task = document.getElementById("form");
        console.log('remove');
        form_for_task.remove();
        var elemBefore = document.getElementById("form");
        let div = document.querySelector('div');
        let div_elem = document.createElement('div_elem');
        div.append(div_elem);
        const label = document.createElement('label');
        label.innerHTML = `<b>Неправильно</b>`;
        label.setAttribute('style', 'margin-left:64%; margin-right:2%; color:#ff0000');
        div_elem.append(label);
        const btn = document.createElement('button');
        btn.innerHTML = `Продолжить`;
        div_elem.append(btn);
    }
}

const applicantForm = document.getElementById('form');
applicantForm.addEventListener('submit', handleFormSubmit);