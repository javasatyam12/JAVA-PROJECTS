
import java.util.HashMap;

public class IDandPasswords {

    HashMap<String,String> logininfo = new HashMap<String,String>();

     IDandPasswords() {

        logininfo.put("Satyam","Burger");
        logininfo.put("Rocky","PASSWORD");
        logininfo.put("Nitin","2004");
    }

    protected  HashMap<String, String> getLogininfo() {
        return logininfo;
    }

    
    
}
