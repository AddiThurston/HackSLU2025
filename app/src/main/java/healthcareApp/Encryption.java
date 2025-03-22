import java.math.BigInteger;

public class Encryption {
    private int p;
    private int q;
    private int n;
    private int e;

    public Encryption(int p, int q, int e) {
        this.p = p;
        this.q = q;
        this.n = p * q;
        this.e = e;
    }

    private int calculatePrivateKey() {
        int phi = (p - 1) * (q - 1);
        BigInteger eBigInteger = BigInteger.valueOf(e);
        BigInteger phiBigInteger = BigInteger.valueOf(phi);
        BigInteger dBigInteger = eBigInteger.modInverse(phiBigInteger);
        return dBigInteger.intValue();
    }

    public String encrypt(String message) {
        StringBuilder ciphertextBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            BigInteger m = BigInteger.valueOf((int) c);
            BigInteger encrypted = m.modPow(BigInteger.valueOf(e), BigInteger.valueOf(n));
            ciphertextBuilder.append(encrypted).append(" ");
        }
        return ciphertextBuilder.toString();
    }
}