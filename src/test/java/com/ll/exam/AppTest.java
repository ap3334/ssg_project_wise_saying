package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void 테스트_실험() {
        int rs = 10 + 20;
        assertEquals(30, rs);
    }

    @Test
    public void 문자열을_스캐너의_입력으로_설정() {
        String input = """
                등록
                명언1
                작가1
                """.stripIndent();

        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner sc = new Scanner(in);

        String cmd = sc.nextLine();
        String content = sc.nextLine();
        String writer = sc.nextLine();

        assertEquals("등록", cmd);
        assertEquals("명언1", content);
        assertEquals("작가1", writer);

    }

    @Test
    public void 표준풀력을_리다이렉션하여_결과를_문자열로_받기() throws IOException {

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        System.out.println("안녕");

        String rs = output.toString().trim();

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        output.close();

        assertEquals("안녕", rs);
    }

}