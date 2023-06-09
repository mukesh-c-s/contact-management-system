


import java.io.Serializable;


public class ContactAddress implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private int ct_id;
	private int cid;
	private int aid;
    	private String address;
      private String category;
    public ContactAddress(int ct_id,int cid,int aid,String address)
    {
       this.ct_id=ct_id;
       this.cid=cid;
       this.aid=aid;
       this.address=address;
    }
    public ContactAddress(String category, String  address ) {
      this.address = address;
      this.category = category;
    }
    
    public ContactAddress(int aid, String category, String  address) {
      this.aid = aid;
      this.address = address;
      this.category = category;
    }
    public ContactAddress(int ct_id,int cid,String address)
    {
       this.ct_id=ct_id;
       this.cid=cid;
       this.address=address;
    }
    public String getCategory() {
      return category;
    }
    public String getAddress() 
    {
		return address;
    }
    public int getCtid() 
    {
		return ct_id;
    }
    public int getCid() 
    {
		return cid;
    }
     public String getAid() 
    {
		return Integer.toString(aid);
    }

          
}
