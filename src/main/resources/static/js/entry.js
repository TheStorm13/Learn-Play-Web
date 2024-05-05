fetch('http://localhost:8080/getNewTask')
    .then((response) => {
        var last_task = response.json()
        return last_task
    })
    .then((data) => {
        // data_server = data;
        return data;
    });
