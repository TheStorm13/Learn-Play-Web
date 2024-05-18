const editableElements = document.querySelectorAll('.editable');

editableElements.forEach(element => {
    element.addEventListener('input', () => {
        // Сохранение изменений при вводе текста
        localStorage.setItem('editableContent-' + element.id, element.innerHTML);
    });

    // Загрузка сохраненных данных
    const content = localStorage.getItem('editableContent-' + element.id);
    if (content) {
        element.innerHTML = content;
    }
});

