package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncrypter {

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray(); 
    private static final String SALT = "654321";

    private static PasswordEncrypter encrypter;
    
    private PasswordEncrypter() {
    	
    }
    
    public static PasswordEncrypter getPasswordEncrypter() {
    	if (encrypter == null) {
    		encrypter = new PasswordEncrypter();
    	}
    	return encrypter;
    }
    
    public String getEncryptedPassword(String input) {
        String encryptedPassword;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(SALT.getBytes());
            md.update(input.getBytes());
            byte[] bytes = md.digest();
            char[] hexChar = new char[bytes.length * 2];
            int v;
            for (int i = 0; i < bytes.length; i++) {
                v = bytes[i]&0xFF;
                hexChar[i*2] = HEX_ARRAY[v>>>4];
                hexChar[i*2+1] = HEX_ARRAY[v&0x0F];
            }
            encryptedPassword = new String(hexChar);                           
        } catch (NoSuchAlgorithmException e) {
            encryptedPassword="";
        }
        return encryptedPassword;
    }
}
