fetch (
    'https://jsonplaceholder.typicode.com/users', {
        method: 'GET',
    }
).then ((data) => {
    return data.json();
}).then ((info) => {
    console.log(info)
})

