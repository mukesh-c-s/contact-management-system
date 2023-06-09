


import java.io.Serializable;


public class ContactEmail implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private int ct_id;
	private int cid;
	private int eid;
    	private String email;
      private String category;
    public ContactEmail(int ct_id,int cid,int eid,String email)
    {
       this.ct_id=ct_id;
       this.cid=cid;
       this.eid=eid;
       this.email=email;
    }
    
    public ContactEmail(int eid, String category, String email) {
      this.eid = eid;
      this.email = email;
      this.category = category;
    }

    public ContactEmail(String category, String email ) {
      this.email = email;
      this.category = category;
    }
    public ContactEmail(int ct_id,int cid,String email)
    {
       this.ct_id=ct_id;
       this.cid=cid;
       this.email=email;
    }

    public String getCategory() {
      return category;
    }
    public String getEmail() 
    {
		return email;
    }
    public int getCtid() 
    {
		return ct_id;
    }
    public int getCid() 
    {
		return cid;
    }
     public String getEid() 
    {
		return Integer.toString(eid) ;
    }

          
}
