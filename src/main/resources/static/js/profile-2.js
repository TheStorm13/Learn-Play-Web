fetch('/profile/info')
    .then((response) => {
    return response.json();
})
    .then((data) => {
    document.getElementById('user_name').innerText = data['userName'];
    document.getElementById('percent').innerText = (data['multiplier'] * 100) + '%';
    document.getElementById('exp').innerText = data['exp'];
    document.getElementById('top').innerText = data['rankPlace'];
    // Создание элемента изображения
    let img = document.createElement('img');
    var count = Math.floor(data['exp'] / 100) + 1
    if (count > 7) {
        count = 7;
    }
    img.src = './images/leagues/' + count + '.png';
    img.width = 21;
    img.height = 25;
    // Нахождение div-элемента
    let div = document.getElementById('img')
    // Вставка изображения в div
    div.appendChild(img);
});