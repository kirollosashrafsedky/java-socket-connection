import org.json.simple.JSONObject;

import java.sql.*;

public class ServerFunctionalities {
    public JSONObject login(JSONObject credentials){
        String s;
        DB_Manipulations dbm = new DB_Manipulations();
        JSONObject res = new JSONObject();
        String user = (String) credentials.get("user");
        String pass = (String) credentials.get("pass");
        s = dbm.compareUser(user, pass);
        res.put("access", s);
        return res;
    }
}
