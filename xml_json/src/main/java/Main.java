import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.User;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        User u = new User();
        u.setUsername("java");
        u.setBirth(new Date());

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(u);
        System.out.println(json);
        User u2 = objectMapper.readValue(json, User.class);
        System.out.println(u2);
    }
}
