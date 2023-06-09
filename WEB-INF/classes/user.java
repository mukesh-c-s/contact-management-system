


import java.io.Serializable;


public class user implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private int uid;
	private String username;
	private String password;
  private String secretkey; 
    
    public user(String username, String password, String secretkey) {
    this.username = username;
    this.password = password;
    this.secretkey = secretkey;
  }
    public user(int uid,String username,String password)
    {  this.uid=uid;
       this.username=username;
       this.password=password;
       
    }
    public String getUsername() 
    {
		return username;
    }
    public String getPassword() 
    {
		return password;
    }
    public int getUid() 
    {
		return uid;
    }
    public String getSecretkey() {
      return secretkey;
    }
    
          
}
