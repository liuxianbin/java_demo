package factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import pojo.User;
@Component("user2")
public class UserFactory implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        User u = new User();
        u.setUsername("FactoryBean...");
        return u;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
