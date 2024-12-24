package pers.fulsun.blog.utils;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

/**
 * Markdown工具类
 *
 * @author fulsun
 */
public class MarkdownUtil {
    private static final Parser PARSER = Parser.builder().build();
    private static final HtmlRenderer RENDERER = HtmlRenderer.builder().build();

    /**
     * markdown 转 html
     *
     * @param markdown 文章内容
     * @return 文章内容
     */
    public static String md2html(String markdown) {
        Node document = PARSER.parse(markdown);
        return RENDERER.render(document).trim();
    }
}
