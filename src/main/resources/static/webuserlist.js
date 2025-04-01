var add_user = function () {
    var newUser = $("#userName").val();
    var newRole = "admin";
    $.post({
        url: "/addUser",
        data: JSON.stringify({
            "user": {
                "userName": newUser
            },
            "role": {
                "roleName": $("#buttonAddRoleToUser").html()
            }
        }),
        contentType: 'application/json; charset=utf-8'
    }).done(add_done_users);
    $("#userName").val("");
}

var add_role_to_user = function () {
    let selected = $(this).html();
    $("#buttonAddRoleToUser").html(selected);
}

var add_done_users = function () {
    $.getJSON("/getUsers", fetch_users);
}

var add_role = function(){
    var newRole = $("#roleName").val();
    console.log(newRole);
    $.post({
        url: "/addRole",
        data: JSON.stringify({
            "roleName": newRole
        }),
        contentType: 'application/json; charset=utf-8',
    }).done(add_done_roles);
    $("#roleName").val("");
}

var add_done_roles = function () {
    $.getJSON("/getRoles", fetch_roles);
}
var document_ready = function () {
    $("#addUser").click(add_user);
    $("#addRole").click(add_role);
}

var delete_user = function () {
    let id = $(this).attr("id")
    $.ajax({
        type: "DELETE",
        url: "/deleteUser/" + id,
        success: function (result) {
            $.getJSON("/getUsers", fetch_users);
        }
    })
}

var delete_role = function () {
    let id = $(this).attr("id")
    $.ajax({
        type: "DELETE",
        url: "/deleteRole/" + id,
        success: function (result) {
            $.getJSON("/getRoles", fetch_roles);
        }
    })
}

var fetch_users = function (data) {
    console.log(data);
    $('#maintable').html('<tr><th>User</th><th>Role</th><th class="deleter">Edit</th></tr>');


    for (i = 0; i < data.length; i++) {
        let userId = data[i]["userId"]
        let userName = data[i]["userName"]
        let roleName = data[i]["roleName"]
        $('#maintable').append(`<tr><td>${userName}</td><td>${roleName}</td><td class="deleter"><button id="${userId}" class="delete"></button></td></tr>`);
        $(`#${userId}`).click(delete_user);
    }
}

var fetch_roles = function (data) {
    console.log(data);
    $('#rolestable').html('<tr><th>Role</th><th class="deleter">Edit</th></tr><tr>')
    $('#roles_dropdown').html('')

    for (i = 0; i < data.length; i++) {
        let roleId = data[i]["roleId"]
        let roleName = data[i]["roleName"]
        $('#rolestable').append(`<tr><td>${roleName}<td class="deleter"><button id="${roleId}" class="delete"></button></td></tr>`);
        $(`#${roleId}`).click(delete_role);
        $('#roles_dropdown').append(`<a href="#" class="dropdown-item" id="drop_${roleId}">${roleName}</a>`);
        $(`#drop_${roleId}`).click(add_role_to_user);
    }
}

$(document).ready(document_ready);
$.getJSON("/getUsers", fetch_users);
$.getJSON("/getRoles", fetch_roles);