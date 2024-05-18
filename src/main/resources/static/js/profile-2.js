fetch('/profile/info')
    .then((response) => {
    return response.json();
})
    .then((data) => {
    document.getElementById('user_name').innerText = data['userName'];
    document.getElementById('percent').innerText = (data['multiplier'] * 100) + '%';
    document.getElementById('exp').innerText = data['exp'];
    document.getElementById('top').innerText = data['rankPlace'];
});