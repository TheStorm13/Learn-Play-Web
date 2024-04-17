//работающая штука
var data_server;
const object ={
    "idTopic": 1,
    "step": 1
};
fetch('http://localhost:8080/getNewTask')
    .then((response) => {
        var last_task = response.json()
        return last_task
    })
    .then((data) => {
        data_server = data;
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

    });

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