


import java.io.Serializable;


public class ContactMobile implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private int ct_id;
	private int cid;
	private int pid;
    private String mobilenumber;
    private String category;
    public ContactMobile(int ct_id,int cid,int pid,String mobilenumber, String category)
    {
       this.ct_id=ct_id;
       this.cid=cid;
       this.pid=pid;
       this.mobilenumber=mobilenumber;
       this.category=category;
    }
    public ContactMobile(int ct_id,int cid,String mobilenumber)
    {
       this.ct_id=ct_id;
       this.cid=cid;
       this.mobilenumber=mobilenumber;
    }
    public ContactMobile(int pid, String category, String mobilenumber) {
      this.pid = pid;
      this.mobilenumber = mobilenumber;
      this.category = category;
    }
    public ContactMobile(String category, String mobilenumber)
    {
       
       this.mobilenumber=mobilenumber;
       this.category=category;
    }
    public String getMobilenumber() 
    {
		return mobilenumber;
    }
    public String getCategory() 
    {
		return category;
    }
    public int getCtid() 
    {
		return ct_id;
    }
    public int getCid() 
    {
		return cid;
    }
     public String getPid() 
    {
		return Integer.toString(pid);
    }

          
}
