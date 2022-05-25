package sample;

public class MyJDBC {

    public static void main(String[] args){

        try{
            DB_Manipulations dbm = new DB_Manipulations();

            User user = new User(2, "Rany", "R.", "Phillip", "bigranyx10", "1234567", 6000);
            dbm.insertUser(user);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
