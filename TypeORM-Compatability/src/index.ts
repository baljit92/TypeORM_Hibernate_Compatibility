import "reflect-metadata";
import { createConnection } from "typeorm";
import { User } from "./entity/User";
import { Info } from "./entity/Info";

createConnection().then(async connection => {

    console.log("Inserting a new user into the database...");
    const user = new User();
    user.name = "Baljit Singh";
    user.email = "baljits@andrew.cmu.edu";
    await connection.manager.save(user);
    console.log("Saved a new user with id: " + user.id);


    console.log("Inserting a new info into the database...");
    const info = new Info();
    info.description = "Talk about TypeORM and Hibernate";
    info.user = user;
    await connection.manager.save(info);
    console.log("Saved a new info with id: " + info.id);

  

    console.log("Loading users from the database...");
    const users = await connection.manager.find(User);
    console.log("Loaded users: ", users);



}).catch(error => console.log(error));
