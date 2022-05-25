public class MyJDBC {

    public static void main(String[] args){

        try{
            DB_Manipulations dbm = new DB_Manipulations();

            User user = new User(3, "Ramy", "M.", "Ahmed", "bigramyx10", "123456", 6000);
            dbm.insertUser(user);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
