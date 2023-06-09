

import java.util.ArrayList;

public class Contact  
{
   private int cid;
   private int uid;
	private String firstname;
   private String lastname;
   private String companyname;
   private String birthday;
   private ArrayList<String> mobileCategory;
   private ArrayList<String> mobilelist;
   private ArrayList<String> mobileid;
   private ArrayList<String> emailCategory;
   private ArrayList<String> emaillist;
   private ArrayList<String> emailid;
   private ArrayList<String> addressCategory;
   private ArrayList<String> addresslist;
   private ArrayList<String> addressid;
   private ArrayList<ArrayList<String>> mobile;
   private ArrayList<ArrayList<String>> email;
   private ArrayList<ArrayList<String>> address;
   
   public Contact(String firstname, String lastname, String companyname, String birthday) {
      this.firstname = firstname;
      this.lastname = lastname;
      this.companyname = companyname;
      this.birthday = birthday;
   }
   public Contact(int cid,String firstname, String lastname, String companyname, String birthday) {
      this.cid=cid;
      this.firstname = firstname;
      this.lastname = lastname;
      this.companyname = companyname;
      this.birthday = birthday;
   }
   public Contact(int cid, String firstname, String lastname, String companyname, String birthday,
         ArrayList<ArrayList<String>> mobile, ArrayList<ArrayList<String>> email, ArrayList<ArrayList<String>> address) {
      this.cid = cid;
      this.firstname = firstname;
      this.lastname = lastname;
      this.companyname = companyname;
      this.birthday = birthday;
      this.mobile = mobile;
      this.email = email;
      this.address = address;
   }
   

   public Contact(String firstname, String lastname, String companyname, String birthday,
         ArrayList<String> mobileCategory, ArrayList<String> mobilelist, ArrayList<String> emailCategory,
         ArrayList<String> emaillist, ArrayList<String> addressCategory, ArrayList<String> addresslist) {
      this.firstname = firstname;
      this.lastname = lastname;
      this.companyname = companyname;
      this.birthday = birthday;
      this.mobileCategory = mobileCategory;
      this.mobilelist = mobilelist;
      this.emailCategory = emailCategory;
      this.emaillist = emaillist;
      this.addressCategory = addressCategory;
      this.addresslist = addresslist;
   }

   
   public Contact(int uid) 
   {
      this.uid=uid;
   }
   public int getCid() {
      return cid;
   }
   public int getUid() {
      return uid;
   }
   public String getFirstname() {
      return firstname;
   }
   public String getLastname() {
      return lastname;
   }
   public String getCompanyname() {
      return companyname;
   }
   public String getBirthday() {
      return birthday;
   }
   public ArrayList<ArrayList<String>> getMobile() {
      return mobile;
   }
   public ArrayList<ArrayList<String>> getEmail() {
      return email;
   }
   public ArrayList<ArrayList<String>> getAddress() {
      return address;
   }
    
    
          
}
