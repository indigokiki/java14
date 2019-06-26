package mytest;

import com.cskaoyan.service.IDepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {

    @Test
    public void test1(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        IDepartmentService service = (IDepartmentService)ac.getBean("service");
        service.findAll();
    }
}
