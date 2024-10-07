function getAllUsers() {
    const allUsersTBodyJS = document.getElementById("allUsersTBody");

    fetch('/admin')
        .then(response => response.json())
        .then(allUsers => {
            allUsersTBodyJS.innerHTML = '';
            for (const user of allUsers) {
                let row = allUsersTBodyJS.insertRow();
                row.insertCell().innerHTML = user.id
                row.insertCell().innerHTML = user.name
                row.insertCell().innerHTML = user.surname
                row.insertCell().innerHTML = user.age
                row.insertCell().innerHTML = user.username;
                row.insertCell().innerHTML = user.roles.map(role => role.roleName).join(', ');
                row.insertCell().innerHTML =
                    '<button class="btn btn-sm btn-info" type="submit" onclick="getEditModal(' + user.id + ')" data-toggle="modal" data-target="#editModal">Edit</button>';
                row.insertCell().innerHTML =
                    '<button class="btn btn-sm btn-danger" type="submit" onclick="getDeleteModal(' + user.id + ')" data-toggle="modal" data-target="#deleteModal">Delete</button>';
            }
        })
        .catch(error => console.error('Ошибка:', error));
}