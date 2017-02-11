1. Users
use concessionaire;
db.users.createIndex({email: 1}, {unique: true});
db.users.createIndex({username: 1}, {unique: true});
mongoimport --db concessionaire --collection users --file users_list.json --jsonArray

2. Cars
mongoimport --db concessionaire --collection cars --file cars_list.json --jsonArray
