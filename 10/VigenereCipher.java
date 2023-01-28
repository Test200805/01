import java.util.Scanner;

public class VigenereCipher {
    private String key;

    public VigenereCipher(String key) {
        this.key = key;
    }

    public String encrypt(String plaintext) {
        plaintext = plaintext.toUpperCase();
        key = key.toUpperCase();
        String ciphertext = "";
        for (int i = 0, j = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            ciphertext += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return ciphertext;
    }

    public String decrypt(String ciphertext) {
        ciphertext = ciphertext.toUpperCase();
        key = key.toUpperCase();
        String plaintext = "";
        for (int i = 0, j = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            plaintext += (char)((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return plaintext;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine();
        System.out.print("Enter the key: ");
        String key = scanner.nextLine();

        VigenereCipher vigenereCipher = new VigenereCipher(key);
        String cipherText = vigenereCipher.encrypt(plaintext);
        System.out.println("Ciphertext: " + cipherText);
        System.out.println("Plaintext: " + vigenereCipher.decrypt(cipherText));
    }
}
