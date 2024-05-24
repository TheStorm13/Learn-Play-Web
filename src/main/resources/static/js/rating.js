// GET запрос для получения рейтинга
fetch('/rank/getRank')
    .then(response => response.json())
    .then(data => {
    console.log(data); // Делаем что-то с полученными данными о рейтинге
});

// GET запрос для получения списка рейтинга
fetch('/rank/getRankList')
    .then(response => response.json())
    .then(data => {
    console.log(data); // Делаем что-то со списком рейтинга
});