1. Users
use concessionaire;
db.users.createIndex({email: 1}, {unique: true});
db.users.createIndex({username: 1}, {unique: true});
mongoimport --db concessionaire --collection users --drop --file users_list.json --jsonArray

2. Menus
mongoimport --db concessionaire --collection menus --drop --file menus_list.json --jsonArray


3. Cars
mongoimport --db concessionaire --collection cars --drop --file cars_list.json --jsonArray
