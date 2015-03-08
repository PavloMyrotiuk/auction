var users = [
    {
        "_class": "com.myrotiuk.auction.common.core.model.user.User",
        "name": "a",
        "username": "a@a",
        "password": "a",
        "roles": [
            "ROLE_USER"
        ]
    },
    {
        "_class": "com.myrotiuk.auction.common.core.model.user.User",
        "name": "b",
        "username": "b@b",
        "password": "b",
        "roles": [
            "ROLE_USER"
        ]
    }
];

function addUsers(users){
    for (var user in users){
        db.users.insert(users[user]);
    }
}

addUsers(users);