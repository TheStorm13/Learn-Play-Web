

async function startQuest(topicId, step) {
  const data = {
    topicId: topicId,
    step: step
  };
  try {
    const response = await fetch('/quest/startQuest', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    });
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    window.location.href = '/quest';  // Переход на страницу '/quest' после успешного запроса
  } catch (error) {
    console.error('There has been a problem with your fetch operation:', error);
  }
}

async function getListProgress() {
  try {
    const response = await fetch('/education/getListProgress'); // Выполняем GET-запрос на сервер
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    const progressList = await response.json(); // Получаем данные в формате JSON
    console.log(progressList)
    const mainParent = document.querySelector('.main');
    progressList.forEach(progress => {
          const chapterDiv = document.createElement('div');
          chapterDiv.classList.add('chapter');

          const chapterTitle = document.createElement('p');
          chapterTitle.textContent = 'Раздел ' + progress.topicId;

          const chapterElemDiv = document.createElement('div');
          chapterElemDiv.classList.add('chapter_elem');

          const chapterElemTitle = document.createElement('p');
          chapterElemTitle.textContent = progress.topicName;

          const btn = document.createElement('button');
          btn.classList.add('btn');
          btn.textContent = 'Справочник';

          chapterElemDiv.appendChild(chapterElemTitle);
          chapterElemDiv.appendChild(btn);

          chapterDiv.appendChild(chapterTitle);
          chapterDiv.appendChild(chapterElemDiv);

          mainParent.appendChild(chapterDiv);

          const section = document.createElement('section');
          section.classList.add('box');

          for (let i = 0; i < 5; i++) {
            const boxLevel = document.createElement('div');
            boxLevel.classList.add('box__level_' + i); // Добавляем класс box__level_0

            const num = document.createElement('p');
            num.classList.add('num');
            num.textContent = i + 1; // Устанавливаем содержимое для тега p

            const form = document.createElement('form');

            const hiddenInput1 = document.createElement('input');
            hiddenInput1.setAttribute('type', 'hidden');
            hiddenInput1.setAttribute('name', 'topicId');
            hiddenInput1.setAttribute('value', progress.topicId);

            const hiddenInput2 = document.createElement('input');
            hiddenInput2.setAttribute('type', 'hidden');

            const input = document.createElement('input');
            input.setAttribute('type', 'image');
            if (i + 1 > progress.step) {
            input.setAttribute('src', './images/button2.png');
            }
            else {
            input.setAttribute('src', './images/button.png');
            }
            input.setAttribute('alt', progress.topicId + '?' + (i + 1));

            form.appendChild(hiddenInput1);
            form.appendChild(hiddenInput2);
            form.appendChild(input);

            form.addEventListener('submit', function(event) {
            event.preventDefault();  // Отменяем стандартное поведение формы
            startQuest(progress.topicId, i + 1);  // Вызываем функцию для отправки POST-запроса
            });

            boxLevel.appendChild(num);
            boxLevel.appendChild(form);
            section.appendChild(boxLevel);
          }

          mainParent.appendChild(section);
        });
  } catch (error) {
    console.error('There has been a problem with your fetch operation:', error);
  }
}

getListProgress();


form.setAttribute('action', '/quest');
form.setAttribute('method', 'GET');