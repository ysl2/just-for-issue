package src.web.xml.code;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * JsoupDemo01
 */
public class JsoupDemo01 {

    public static void main(String[] args) throws Exception{
        String path = JsoupDemo01.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
    }
}
