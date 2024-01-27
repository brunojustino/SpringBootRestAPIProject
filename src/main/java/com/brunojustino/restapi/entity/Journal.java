package com.brunojustino.restapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Journal")
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name="user_id")
    private Users users;

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    @JsonFormat(shape=JsonFormat.Shape.STRING,  pattern="yyyy-MM-dd HH:mm:ss")
    private java.sql.Timestamp date;

    public Journal() {

    }

    public Journal(Users users, String text, Timestamp date) {
        super();
        this.users = users;
        this.text = text;
        this.date = date;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", users=" + users +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
