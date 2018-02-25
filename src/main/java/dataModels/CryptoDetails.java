package dataModels;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * idea of the class is to incapsulate hash and 'MNEMONIC CODE PLAINTEXT' holding and retrieving from email body
 */
public class CryptoDetails {
    private static final Pattern HEXADECIMAL_PATTERN = Pattern.compile("HEXADECIMAL: (\\w+)");
    private static final Pattern MNEMONIC_CODE_PATTERN =
            Pattern.compile("MNEMONIC CODE PLAINTEXT: ([a-zA-Z]+ [a-zA-Z]+ [a-zA-Z]+)");

    private String hash = "";
    private String words = "";

    public CryptoDetails(String hash, String words) {
        this.hash = hash;
        this.words = words;
    }

    public CryptoDetails(String emailBody) {
        hash = getHashFromString(emailBody);
        words = getWordsFromEmailBody(emailBody);
    }

    //using code from https://stackoverflow.com/a/10432594
    private String getHashFromString(String emailBody) {
        Matcher mat = HEXADECIMAL_PATTERN.matcher(emailBody);

        String result;
        if (!mat.find()) {
            return "";
        }
        result = mat.group(1);

        //only one hash is expected and it should have length 64
        if (mat.find() || 64 != result.length()) {
            return "";
        }

        return result;
    }

    private String getWordsFromEmailBody(String emailBody) {
        Matcher mat = MNEMONIC_CODE_PATTERN.matcher(emailBody);

        String result;
        if (!mat.find()) {
            return "";
        }
        result = mat.group(1);

        //only one hash is expected
        if (mat.find()) {
            return "";
        }

        return result;
    }

    public String getHash() {
        return hash;
    }

    public String getWords() {
        return words;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CryptoDetails that = (CryptoDetails) o;

        if (hash != null ? !hash.equals(that.hash) : that.hash != null) return false;
        return words != null ? words.equals(that.words) : that.words == null;

    }

    @Override
    public int hashCode() {
        int result = hash != null ? hash.hashCode() : 0;
        result = 31 * result + (words != null ? words.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CryptoDetails{" +
                "hash='" + hash + '\'' +
                ", words='" + words + '\'' +
                '}';
    }
}
