function getEditModal(id) {
    let form = document.forms.namedItem("editUserForm");
    fillModal(id, form)
}

function getDeleteModal(id) {
    let form = document.forms.namedItem("deleteUserForm");
    fillModal(id, form)
}

function fillModal(id, form) {
    fetch('/admin/' + id)
        .then(response => response.json())
        .then(user => {
            form.elements.namedItem("id").value = user.id;
            form.elements.namedItem("name").value = user.name;
            form.elements.namedItem("surname").value = user.surname;
            form.elements.namedItem("age").value = user.age;
            form.elements.namedItem("username").value = user.username;
            if (form.elements.namedItem("password") != null) {
                form.elements.namedItem("password").value = "";
            }
        })
        .catch(error => console.error('Ошибка:', error));
}