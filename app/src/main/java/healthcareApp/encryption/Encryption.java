package healthcareApp.encryption;

import java.math.BigInteger;

public class Encryption {
    private static int p;
    private static int q;
    private static int n;
    private static int e;
    private static int d;
    
    public Encryption(int p, int q) {
        Encryption.p = p;
        Encryption.q = q;
        Encryption.n = p * q;
        Encryption.e = 65537;
        calculatePrivateKey();
    }

    private static int calculatePrivateKey() {
        int phi = (p - 1) * (q - 1);
        BigInteger eBigInteger = BigInteger.valueOf(e);
        BigInteger phiBigInteger = BigInteger.valueOf(phi);
        BigInteger dBigInteger = eBigInteger.modInverse(phiBigInteger);
        d = dBigInteger.intValue();
        return d;
    }

    public static String encrypt(String message) {
        StringBuilder ciphertextBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            BigInteger m = BigInteger.valueOf((int) c);
            BigInteger encrypted = m.modPow(BigInteger.valueOf(e), BigInteger.valueOf(n));
            ciphertextBuilder.append(encrypted).append(" ");
        }
        return ciphertextBuilder.toString();
    }

    public static String decrypt(String ciphertext) {
        StringBuilder plaintextBuilder = new StringBuilder();
        String[] encryptedChars = ciphertext.split(" ");
        for (String encryptedChar : encryptedChars) {
            BigInteger encrypted = new BigInteger(encryptedChar);
            BigInteger decrypted = encrypted.modPow(BigInteger.valueOf(d), BigInteger.valueOf(n));
            char plaintextChar = (char) decrypted.intValue();  // Convert back to character
            plaintextBuilder.append(plaintextChar);  // Append the character to the result
        }
        return plaintextBuilder.toString();  // Return the decrypted word
    }

    public static int getE() {
        return e;
    }

    public static void setE(int e) {
        Encryption.e = e;
    }

    public static int getN() {
        return n;
    }

    public static void setN(int n) {
        Encryption.n = n;
    }

    public static int getD() {
        return d;
    }

    public static void setD(int d) {
        Encryption.d = d;
    }
}