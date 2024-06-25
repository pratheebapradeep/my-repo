	
package Model;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args)
    {
        ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");
        Employee emp=(Employee) app.getBean("employeeBean");
        
        System.out.println("Employee id:"+emp.getId());
        System.out.println("Employee Name:"+emp.getEname());
        System.out.println("City:" +emp.getCity());
        System.out.println("Salary: "+emp.getSalary());
    }
}

  