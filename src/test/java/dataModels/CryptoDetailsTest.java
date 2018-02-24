package dataModels;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**idea is to check CryptoDetails class*/
public class CryptoDetailsTest {
    @Test
    public void checkConstructor(){
        CryptoDetails cryptoDetails = new CryptoDetails("<div><br><div><br><br><br><div style=\"border:1px solid #e5e5e5;padding:15px 20px;margin:auto;\">\n" +
                "<p><span>HASH HEXADECIMAL: c4a393a9820d5f079eee0b2a3fab1d5b116ddf75f607e25cc8f791a96d4c9460</span></p>\n" +
                "<p><span>MNEMONIC CODE PLAINTEXT: recipe wheelbarrow angel</span></p>\n" +
                "<p>BLOCKCHAIN TRANSACTION LINK:<a href=\"https://blockchain.info/tx/a17def12f90505574bca79799b3a1aca9828661626e9ea534d58d01f0fb7e653\">link</a></p>\n" +
                "</div><br><br><div style=\"padding:12px 15px;background:#f5f5f5;font-size:12px;color:#333;\">Email sent via <a href=\"http://www.emailjs.com?src=email-footer\">EmailJS.com</a></div><br></div><br><div><br></div><div><div></div></div>\n" +
                "</div>");

        assertEquals("c4a393a9820d5f079eee0b2a3fab1d5b116ddf75f607e25cc8f791a96d4c9460", cryptoDetails.getHash());
        assertEquals("recipe wheelbarrow angel", cryptoDetails.getWords());
    }
}
