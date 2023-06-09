


import java.io.Serializable;


public class category implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private int ctid ;
   private String category;
    
    public category(int ctid,String category)
    {
       this.ctid=ctid;
       this.category=category;
       
    }
    public category(String category)
    {
       
       this.category=category;
       
    }
    
    public String getCategory() 
    {
		return category;
    }
    public int getCtid() 
    {
		return ctid;
    }
          
}
