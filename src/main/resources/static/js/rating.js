// GET запрос для получения рейтинга
fetch('/rank/getRank')
    .then(response => response.json())
    .then(data => {
        let persRatingDiv = document.querySelector('.pers_rating');
        //вывод места
        if( data['rank_place']===1) {
            const image = document.createElement('img');
            image.src = './images/icons/first.png';
            persRatingDiv.appendChild(image);
        }
        else if(data['rank_place']===2) {
            const image = document.createElement('img');
            image.src = './images/icons/second.png';
            persRatingDiv.appendChild(image);
        }
        else if(data['rank_place']===3){
            const image = document.createElement('img');
            image.src = './images/icons/third.png';
            persRatingDiv.appendChild(image);
        }
        else{
            let ratingPlaceElement = document.createElement('p');
            ratingPlaceElement.classList.add('rating_name');
            ratingPlaceElement.textContent = `${data['rank_place']}`;
            persRatingDiv.appendChild(ratingPlaceElement);
        }
        //имя пользователя
        let ratingNameElement = document.createElement('p');
        ratingNameElement.classList.add('rating_name');
        ratingNameElement.textContent = `${data['userName']}`;
        persRatingDiv.appendChild(ratingNameElement);
       //количество опыта
        let ratingExpElement = document.createElement('p1');
        ratingExpElement.classList.add('rating_exp');
        ratingExpElement.textContent = `${data['exp']} exp`;
        persRatingDiv.appendChild(ratingExpElement);

        if (data['exp']<100){
        let img_scale = document.getElementById('1');
        img_scale.style.transform = 'scale(1.62)';
       }
        else if(data['exp']>100 && data['exp']<200 ){
            let img_scale = document.getElementById('2');
            img_scale.style.transform = 'scale(1.62)';
        }
        else if(data['exp']>200 && data['exp']<300 ){
            let img_scale = document.getElementById('3');
            img_scale.style.transform = 'scale(1.62)';
        }
        else if(data['exp']>300 && data['exp']<400 ){
            let img_scale = document.getElementById('4');
            img_scale.style.transform = 'scale(1.62)';
        }
        else if(data['exp']>400 && data['exp']<500 ){
            let img_scale = document.getElementById('5');
            img_scale.style.transform = 'scale(1.62)';
        }
        else if(data['exp']>500 && data['exp']<600 ){
            let img_scale = document.getElementById('6');
            img_scale.style.transform = 'scale(1.62)';
        }
        else {
            let img_scale = document.getElementById('7');
            img_scale.style.transform = 'scale(1.62)';
        }
    });

// GET запрос для получения списка рейтинга
fetch('/rank/getRankList')
    .then(response => response.json())
    .then(data => {
    for (let i = 0; i < data.length; i++) {
        let persRatingDiv = document.querySelector('.user_rating1');
        let iDiv = document.createElement('div');
        iDiv.classList.add('user_rating');

        // Вывод места пользователя
        if (data[i]['rank_place'] === 1) {
            const image = document.createElement('img');
            image.src = './images/icons/first.png';
            iDiv.appendChild(image);
        } else if (data[i]['rank_place'] === 2) {
            const image = document.createElement('img');
            image.src = './images/icons/second.png';
            iDiv.appendChild(image);
        } else if (data[i]['rank_place'] === 3) {
            const image = document.createElement('img');
            image.src = './images/icons/third.png';
            iDiv.appendChild(image);
        } else {
            let ratingPlaceElement = document.createElement('p');
            ratingPlaceElement.classList.add('rating_name');
            ratingPlaceElement.textContent = `${data[i]['rank_place']}`;
            iDiv.appendChild(ratingPlaceElement);
        }

        // Имя пользователя
        let ratingNameElement = document.createElement('p');
        ratingNameElement.classList.add('rating_name');
        ratingNameElement.textContent = `${data[i]['userName']}`;
        iDiv.appendChild(ratingNameElement);

        // Количество опыта
        let ratingExpElement = document.createElement('p');
        ratingExpElement.classList.add('rating_exp');
        ratingExpElement.textContent = `${data[i]['exp']} exp`;
        iDiv.appendChild(ratingExpElement);

        persRatingDiv.appendChild(iDiv);
    }
});