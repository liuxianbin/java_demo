import org.junit.Test;
import pojo.Person;
import pojo.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class Demo3 {
    @Test
    public void test() {
        User u = new User();
        Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(), User.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before...");
                Object result = method.invoke(u, args);
                System.out.println("after...");
                return result;
            }
        });
        Person user = (Person)proxy;
        user.doWork();
    }
}
