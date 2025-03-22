package healthcareApp.encryption;

import java.math.BigInteger;

public class Decryption {
    private int p;
    private int q;
    private int n;
    private int e;
    private int d;

    public Decryption(int p, int q, int e) {
        this.p = p;
        this.q = q;
        this.n = p * q;
        this.e = e;
        this.d = this.calculatePrivateKey();
    }

    private int calculatePrivateKey() {
        int phi = (p - 1) * (q - 1);
        BigInteger eBigInteger = BigInteger.valueOf(e);
        BigInteger phiBigInteger = BigInteger.valueOf(phi);
        BigInteger dBigInteger = eBigInteger.modInverse(phiBigInteger);
        return dBigInteger.intValue();
    }

    public String decrypt(String ciphertext) {
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
}
