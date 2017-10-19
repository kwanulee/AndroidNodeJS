package com.kwanwoo.android.webconnection;

/**
 * Created by kwanwoo on 2017. 10. 17..
 */

public class Book {
    String id;
    String title;
    String content;
    String author;

    public Book(String id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String toString() {
        return String.format("ID = %s \n Title = %s \n Content = %s \n Author = %s",id,title,content,author);
    }
}
