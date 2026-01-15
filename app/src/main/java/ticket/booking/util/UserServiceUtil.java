package ticket.booking.util;

import org.mindrot.jbcrypt.BCrypt;

public class UserServiceUtil {
    public static String hashpassword(String plainPassword){
        return BCrypt.hashpw(plainPassword,BCrypt.gensalt());
    }
    public static boolean checkPassword(String plainPassword,String hasshPassword){
        return BCrypt.checkpw(plainPassword,hasshPassword);
    }
}
