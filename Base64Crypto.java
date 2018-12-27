package base64crypto;
import java.util.Base64 ;

public class Base64Crypto {

    static final String SEPARATOR = "----------------------------------------";
    static String[] tests = new String[]{"Hello", "This is a test", "I want to encode me then decode me :D"};

    public static void main(String[] args) {
        for (String test : tests) {
            String encoded = encrypt(test);
            String decrypted = decrypt(encoded);
            System.out.printf("%s%n%s -> %s%n%s -> %s%n", SEPARATOR, test, encoded, encoded, decrypted);
        }
    }

    static String encrypt(String plainText) {
        
        byte[] encode = plainText.getBytes() ;
        return Base64.getEncoder().encodeToString(encode);
    }

    static String decrypt(String base64) {

        byte[] decode = Base64.getDecoder().decode(base64);
        String result = "" ;
        for(byte D : decode){
            char C = (char) D ;
            result += C ;
        }
        return result ;
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                             Output                                                   //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //      Hello -> SGVsbG8=                                                                               //
    //      SGVsbG8= -> Hello                                                                               //
    //      ----------------------------------------                                                        //
    //      This is a test -> VGhpcyBpcyBhIHRlc3Q=                                                          //
    //      VGhpcyBpcyBhIHRlc3Q= -> This is a test                                                          //
    //      ----------------------------------------                                                        //
    //      I want to encode me then decode me :D -> SSB3YW50IHRvIGVuY29kZSBtZSB0aGVuIGRlY29kZSBtZSA6RA==   //
    //      SSB3YW50IHRvIGVuY29kZSBtZSB0aGVuIGRlY29kZSBtZSA6RA== -> I want to encode me then decode me :D   //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
}