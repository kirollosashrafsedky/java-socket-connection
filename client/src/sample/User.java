package sample;

public class User {
    private int userId;
    private String fName;
    private String mName;
    private String lName;
    private String userName;
    private String userPass;
    private float balance;

    public User(int userId, String fName, String mName, String lName, String userName, String userPass, float balance){
        this.userId = userId;
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.userName = userName;
        this.userPass = userPass;
        this.balance = balance;
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public String getFName(){
        return fName;
    }

    public void setFName(String fName){
        this.fName = fName;
    }

    public String getMName(){
        return mName;
    }

    public void setMName(String mName){
        this.mName = mName;
    }

    public String getLName(){
        return lName;
    }

    public void setLName(String lName){
        this.lName = lName;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserPass(){
        return userPass;
    }

    public void setUserPass(String userPass){
        this.userPass = userPass;
    }

    public float getBalance(){
        return balance;
    }

    public void setBalance(float balance){
        this.balance = balance;
    }
}
