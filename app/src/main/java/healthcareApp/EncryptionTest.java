
public class EncryptionTest {
    public static void main(String[] args) {
        Encryption rsa1 = new Encryption(61, 53, 7);
        Decryption rsa2 = new Decryption(61,53, 7 );

        String message = "hello";
        String ciphertext = rsa1.encrypt(message);
        System.out.println("Ciphertext: " + ciphertext);

        String decryptedMessage = rsa2.decrypt(ciphertext);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}
