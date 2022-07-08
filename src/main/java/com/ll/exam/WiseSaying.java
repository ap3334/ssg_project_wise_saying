package com.ll.exam;

public class WiseSaying {

    private int id;

    private String content;

    private String writer;

    public WiseSaying(int id, String content, String writer) {
        this.id = id;
        this.content = content;
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "WiseSaying{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
}
