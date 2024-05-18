fetch('/progress')
    .then(response => response.json())
    .then(data => {
        const progressFill = document.querySelector('.progress-fill');
        progressFill.style.width = `${data.progress}%`;
    });