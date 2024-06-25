package Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table
public class Employee extends Salary
{
    @Id
  private int id;
  String ename;
 String city;   
    public Employee()
    {    }
    public Employee(int id , String name,String city)
    {	
    	this.id=id;
    	this.ename=name;
    	this.city=city;
    }
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getEname()
	{
		return ename;
	}
	public void setEname(String ename)
	{
		this.ename = ename;
	}
	public String getCity() 
	{
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
