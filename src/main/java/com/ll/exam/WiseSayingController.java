package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    private Scanner sc;
    private List<WiseSaying> wiseSayings;
    private int wiseSayingLastId;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        this.wiseSayings = new ArrayList<>();
        this.wiseSayingLastId = 0;
    }

    public void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------");
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying.id, wiseSaying.content, wiseSaying.writer);
        }
    }

    public void remove(Rq rq) {
        // URL에 입력된 id 얻기
        int paramId = rq.getIntParam("id", 0);

        // URL에 입력된 id가 없다면 작업중지
        if (paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        // URL에 입력된 id에 해당하는 명언객체 찾기
        WiseSaying foundWiseSaying = findById(paramId);

        // 찾지 못했다면 중지
        if (foundWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다..\n", paramId);
            return;
        }

        // 입력된 id에 해당하는 명언객체를 리스트에서 삭제
        wiseSayings.remove(foundWiseSaying);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
    }

    public WiseSaying findById(int paramId) {

        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.id == paramId) {
                return wiseSaying;
            }
        }
        return null;
    }

    public int write(Rq rq) {
        System.out.printf("명언 :  ");
        String content = sc.nextLine();

        System.out.printf("작가 : ");
        String writer = sc.nextLine();

        int id = ++wiseSayingLastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, writer);
        wiseSayings.add(wiseSaying);

        System.out.println(id + "번 명언이 등록되었습니다.");
        return wiseSayingLastId;
    }
}
