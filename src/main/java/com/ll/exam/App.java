package com.ll.exam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public void run() throws IOException {

        System.out.println("== 명령 SSG ==");

        Scanner sc = new Scanner(System.in);

        List<WiseSaying> wiseSayings = new ArrayList<>();
        int wiseSayingLastId = 0;

        outer:
        while (true) {
            System.out.printf("명령) ");

            String cmd = sc.nextLine().trim();

            switch (cmd) {

                case ("등록"):

                    System.out.printf("명언 :  ");
                    String content = sc.nextLine();

                    System.out.printf("작가 : ");
                    String writer = sc.nextLine();

                    int id = ++wiseSayingLastId;

                    WiseSaying wiseSaying = new WiseSaying(id, content, writer);
                    wiseSayings.add(wiseSaying);

                    System.out.println(id + "번 명언이 등록되었습니다.");

                    break;

                case ("목록"):
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("-----------------------");

                    for (int i = wiseSayings.size() - 1; i >= 0; i--) {
                        WiseSaying wiseSaying_ = wiseSayings.get(i);
                        System.out.printf("%d / %s / %d\n", wiseSaying_.id, wiseSaying_.content, wiseSaying_.writer);
                    }

                    break;

                case ("종료"):
                    break outer;

            }

        }

        sc.close();

    }
}