package com.ll.exam;

import java.io.*;
import java.util.Scanner;

public class App {

    public void run() throws IOException {

        System.out.println("== 명령 SSG ==");

        Scanner sc = new Scanner(System.in);

        int cnt = 0;

        while (true) {
            cnt++;
            try {
                FileInputStream input = new FileInputStream("./wise_saying/" + cnt + ".json");
            } catch (Exception e) {
                break;
            }
        }

        outer:
        while (true) {
            System.out.printf("명령) ");

            String cmd = sc.nextLine().trim();

            switch (cmd) {

                case("등록"):
                    cnt = register(sc, cnt);
                    break;

                case("목록"):


                case("종료"):
                    break outer;

            }

        }

        sc.close();

    }

    private int register(Scanner sc, int cnt) throws IOException {
        PrintWriter pw = new PrintWriter("./wise_saying/" + cnt + ".json");

        System.out.printf("명언 :  ");
        String wiseSaying = sc.nextLine();

        System.out.printf("작가 : ");
        String writer = sc.nextLine();

        pw.println("{");
        pw.println("\"wiseSaying\": \"" + wiseSaying + "\",");
        pw.println("\"writer\": \"" + writer + "\"");
        pw.println("}");

        pw.close();

        System.out.println(cnt + "번 명언이 등록되었습니다.");
        cnt++;
        return cnt;
    }
}
