// Создать новый элемент div
const newDiv = document.createElement('div');

// Установить атрибуты и содержимое элемента
newDiv.setAttribute('id', 'my-div');
newDiv.innerHTML = 'Это новый div, созданный с помощью JavaScript';

// Добавить элемент на страницу
document.body.appendChild(newDiv);

const newList = document.createElement('ul');

// Создать элементы списка и добавить их в список
for (let i = 0; i < 5; i++) {
  const newListItem = document.createElement('li');
  newListItem.innerHTML = 'Элемент списка ' + (i + 1);
  newList.appendChild(newListItem);
}

// Добавить список на страницу
document.body.appendChild(newList);