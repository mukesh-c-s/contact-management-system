package model;


//import java.io.Serializable;


public class Contact 
//implements Serializable 
{
	//private static final long serialVersionUID = 1L;
	private String[] details=new String[10];
    
    public Contact(String firstname,String lastname,String companyname,String homemobile ,String workmobile ,String homeemail ,String workemail ,String homeaddress ,String workaddress,String birthday)
    {
       this.details[0]=firstname;
       this.details[1]=lastname;
       this.details[2]=companyname;
       this.details[3]=homemobile;
       this.details[4]=workmobile;
       this.details[5]=homeemail;
       this.details[6]=workemail;
       this.details[7]=homeaddress;
       this.details[8]=workaddress;
       this.details[9]=birthday;
    }
    public String toString()
    {
       return getDetails()[0]+" "+getDetails()[1]+" "+getDetails()[2]+" "+getDetails()[3]+" "+getDetails()[4]+" "+getDetails()[5]+" "+getDetails()[6]+" "+getDetails()[7]+" "+getDetails()[8]+" "+getDetails()[9];
    }
    public String[] getDetails() 
    {
		return details;
    }

          
}
