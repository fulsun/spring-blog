package pers.fulsun.blog.utils;

import org.junit.jupiter.api.Test;

class MarkdownUtilTest {

    @Test
    void markdownToHtml() {
        String markdown = """
                ```java
                public static void main(String[] args) {
                    System.out.println("Hello World");
                }
                ```
                """ ;
        System.out.println(MarkdownUtil.md2html(markdown));
    }
}