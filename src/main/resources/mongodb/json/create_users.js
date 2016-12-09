use concessionaire;
db.users.createIndex({email: 1}, {unique: true});
db.users.createIndex({username: 1}, {unique: true});
db.users.insert({
    email: "pablotr87@gmail.com",
    username: "ptirado",
    password: "$2a$08$hMSQHg1RdSAbk5lYcfw96egaiZubWXslFAL/soL/L5iXoMrzMkrJe",
    role: 1
})