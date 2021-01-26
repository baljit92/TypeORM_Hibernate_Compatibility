import {Entity, PrimaryGeneratedColumn, Column, OneToMany, ManyToOne, JoinColumn} from "typeorm";
import { User } from "./User";

@Entity({name: "infos"})
export class Info {

    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    description: string;

    @ManyToOne(type => User, user => user.info)
    @JoinColumn({name: "user_id"})
    user: User

}