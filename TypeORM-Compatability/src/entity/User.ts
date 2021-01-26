import {Entity, PrimaryGeneratedColumn, Column, OneToMany} from "typeorm";
import { Info } from "./Info";

@Entity({name: "users"})
export class User {

    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    name: string;

    @Column()
    email: string;

    @OneToMany(type => Info, info => info.user)
    info: Info[]
}
