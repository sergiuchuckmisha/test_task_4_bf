package com.guerrillamail.www;

import com.sergiuchuckmisha.bf.dataModels.CryptoDetails;
import org.apache.http.client.CookieStore;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.sergiuchuckmisha.bf.config.Config.HOW_MANY_MINUTES_TO_WAIT_FOR_EMAIL;

/**idea of class is to provide object which can create email and check it. Also it can retrieve hash and 'MNEMONIC CODE PLAINTEXT' from email*/
public class EmailChecker {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(EmailChecker.class);

    private HttpContext httpContext = new BasicHttpContext();
    private CookieStore cookieStore = new BasicCookieStore();

    private GuerrillaMail tester;
    private ArrayList<Integer> emailIdsToDelete;

    private String currentEmail;

    public EmailChecker(String currentEmail) throws Exception {
        this.currentEmail = currentEmail;
        testSetup();
        tester.setEmailUser(currentEmail);
    }

    public EmailChecker() throws Exception {
        testSetup();
        currentEmail = tester.getEmailAddress();
    }

    public void testSetup() throws Exception{
        tester = new GuerrillaMail();
        httpContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
        emailIdsToDelete = new ArrayList<>();
        emailIdsToDelete.add(1);//copy-paste from GuerrillaMailTest
        emailIdsToDelete.add(2);
    }


    public String getCurrentEmail() {
        return currentEmail;
    }

    /**method returns list if id's of emails with subject 'Voter, your ballot has been successfully posted on public bulletin board'*/
    public List<Integer> currentVotingEmails() throws Exception {
        return tester
                .getEmailList()
                .stream()
                .filter(eMail -> "Voter, your ballot has been successfully posted on public bulletin board".equals(eMail.getSubject()))
                .map(EMail::getId)
                .collect(Collectors.toList());
    }

    /**method returns list if CryptoDetails(BALLOT RECEIPT 3-WORD MEMO AND HASH)
     * of emails with subject:
     * 'Voter, your ballot has been successfully posted on public bulletin board'*/
    public List<CryptoDetails> currentVotingCryptoDetails() throws Exception {
        return tester
                .getEmailList()
                .stream()
                .filter(eMail -> "Voter, your ballot has been successfully posted on public bulletin board".equals(eMail.getSubject()))
                .map(eMail -> {
                    String emailBody = "";
                    try {
                        emailBody = tester.fetchEmail(eMail.getId()).getBody();
                        log.trace("emailBody" + emailBody);
                    } catch (Exception e) {
                        log.warn(e);
                    }
                    return new CryptoDetails(emailBody);
                })
                .collect(Collectors.toList());
    }

    /**idea of method is to wait until email with certain details is obtained*/
    public void waitForCertainCryptoDetails(CryptoDetails cryptoDetails) throws Exception {
        waitForCertainCryptoDetails(cryptoDetails, HOW_MANY_MINUTES_TO_WAIT_FOR_EMAIL);
    }

    /**idea of method is to wait until email with certain details is obtained*/
    public void waitForCertainCryptoDetails(CryptoDetails cryptoDetails, int minutesToWait) throws Exception {
        log.info("cryptoDetails: " + String.valueOf(cryptoDetails));
        log.info(String.valueOf(currentVotingCryptoDetails()));
        if(currentVotingCryptoDetails().contains(cryptoDetails)){
            return;
        }
        for(int i = 0; i < minutesToWait; i++){
            if(currentVotingCryptoDetails().contains(cryptoDetails)){
                log.info(String.valueOf(currentVotingCryptoDetails()));
                return;
            }
            Thread.sleep(1000L*60);
        }
        throw new IllegalStateException(String.format("%d minutes have expired. Email with Crypto details: %s is not observed yet ", minutesToWait, cryptoDetails));
    }
}
