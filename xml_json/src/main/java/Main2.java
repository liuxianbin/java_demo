import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import pojo.User;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Main2 {
    public static void main(String[] args) throws JsonProcessingException, DocumentException {
        String file = Objects.requireNonNull(Main2.class.getClassLoader().getResource("user.xml")).getPath();
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        System.out.println(document);
        Element rootElement = document.getRootElement();
        List<Element> users = rootElement.elements("user");
        for (Element user : users) {
            String username = user.elementText("username");
            String age = user.elementText("age");
            System.out.println(username + " " + age);
        }
    }
}
