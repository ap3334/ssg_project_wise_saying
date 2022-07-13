package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    public List<WiseSaying> wiseSayings;
    public int wiseSayingLastId;

    WiseSayingRepository() {
        wiseSayings = new ArrayList<>();
        wiseSayingLastId = 0;
    }

    public WiseSaying findById(int paramId) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.id == paramId) {
                return wiseSaying;
            }
        }

        return null;
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;

        // 다 찾기
    }

    public WiseSaying write(String content, String author) {
        int id = ++wiseSayingLastId;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);

        // 파일저장

        return wiseSaying;
    }

    public void remove(int paramId) {
        WiseSaying foundWiseSaying = findById(paramId);
        wiseSayings.remove(foundWiseSaying);

        // 파일 삭제
    }

    public void modify(int paramId, String content, String writer) {
        WiseSaying foundWiseSaying = findById(paramId);
        foundWiseSaying.content = content;
        foundWiseSaying.writer = writer;

        // 파일 수정
    }
}
