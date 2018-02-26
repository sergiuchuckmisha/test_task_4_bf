/**
 * 
 */
package com.guerrillamail.www;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Test class for email address.
 * @author <a reef="https://github.com/DavidePastore">DavidePastore</a>
 *
 */
@Ignore    //no need to run these tests because they are not mine
public class GuerrillaMailTest {

	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(GuerrillaMailTest.class);
	
	private HttpClient httpclient = new DefaultHttpClient();
	private HttpContext httpContext = new BasicHttpContext();
	private CookieStore cookieStore = new BasicCookieStore();
    private HttpResponse httpResponse;
    private HttpPost httpPost;
    private HttpGet httpGet;
    private String stringResponse;
	
	private GuerrillaMail tester;
	private ArrayList<EMail> emails;
	private ArrayList<Integer> emailIdsToDelete;
	
	/**
	 * Setup the test.
	 * @throws Exception 
	 */
	@BeforeTest
	public void testSetup() throws Exception{
		tester = new GuerrillaMail();
		emails = new ArrayList<EMail>();
		httpContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
		emailIdsToDelete = new ArrayList<Integer>();
		emailIdsToDelete.add(1);
		emailIdsToDelete.add(2);
	}


	/**
	 * Test for email address.
	 */
	@Test
	public void testEmailAddress() {
		try{
			assertNotNull(tester.getEmailAddress(), "Email address must not be null");
			
			tester.setEmailUser("pingas");
			assertNotNull(tester.getEmailAddress(), "Email address must not be null after changing the user name");
			
			emails = tester.getEmailList();
			printEMails(emails);
			assertNotNull(emails, "Email list must not be null after reading messages");

			assertNotNull(tester.checkEmail(), "Email list must not be null after checking messages");
			
			assertNotNull(tester.fetchEmail(1), "Email must not be null after fetching message");
			tester.delEmail(emailIdsToDelete);

		} catch(Exception ex){
			ex.printStackTrace();
			fail(ex.getLocalizedMessage());
		}
	}
	
	
	/**
	 * Test for body null before fetching email.
	 * @throws Exception
	 */
	@Test
	public void testBodyNullBeforeFetchEmail() throws Exception{
		tester = new GuerrillaMail();
		tester.getEmailAddress();
		emails = tester.getEmailList();
		assertNull("Email body must be null before fecth.",  emails.get(0).getBody());
	}
	
	
	/**
	 * Test for body not null after fetching email.
	 * @throws Exception
	 */
	@Test
	public void testBodyNotNullAfterFetchEmail() throws Exception{
		tester = new GuerrillaMail();
		tester.getEmailAddress();
		emails = tester.getEmailList();
		EMail email = tester.fetchEmail(emails.get(0).getId());
		assertNotNull("Email body must not be null after fetch.",  email.getBody());
	}
	
	/**
	 * Test for account expired with extend.
	 * @throws Exception 
	 */
	@Test(expectedExceptions = Exception.class)
	public void testAccountExpiredWithExtend() throws Exception {
		forget();
		tester.extend();
	}
	
	/**
	 * Test for account expired with getEmailAddress.
	 * @throws Exception 
	 */
	@Test
	public void testAccountExpiredWithGetEmailAddress() throws Exception {
		forget();
		assertNotNull("Email address must not be null", tester.getEmailAddress());
	}
	
	/**
	 * Test for account expired with setEmailUser.
	 * @throws Exception 
	 */
	@Test
	public void testAccountExpiredWithSetEmailUser() throws Exception {
		forget();
		tester.setEmailUser("pingas");
		assertNotNull("Email address must not be null", tester.getEmailAddress());
	}
	
	/**
	 * Test for double forget.
	 * @throws Exception 
	 */
	@Test
	public void testDoubleForget() throws Exception {
		forget();
		forget();
	}
	
	/**
	 * Test to send an email to this address and read his content.
	 * @throws Exception
	 */
	@Test
	public void testReadEmail() throws Exception{
		httpContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
		tester = new GuerrillaMail();
		String email = tester.getEmailAddress();
		
		log.info("Your email is: "+email);
		
        try {
            Thread.sleep(30000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        /**/
        emails = tester.checkEmail();
        
        printEMails(emails);
	}
	
	/**
	 * Delete all messages and read the number of the emails.
	 * @throws Exception
	 */
	@Test
	public void testDeleteAllMessagesAndReadNumber() throws Exception{
		tester.delEmail(emailIdsToDelete);
		emails = tester.getEmailList();
		assertSame(emails.size(), 0, "The emails must be 0");
	}
	
	
	/**
	 * Forget the email address.
	 */
	private void forget(){
		try {
			tester.forgetMe();
		} catch (Exception ex) {
			ex.printStackTrace();
			fail(ex.getLocalizedMessage());
		}
	}
	
	/**
	 * Print all the emails.
	 * @param emails
	 */
	private void printEMails(ArrayList<EMail> emails){
		Iterator<EMail> iterator = emails.iterator();
		EMail email;
		while(iterator.hasNext()){
			email = iterator.next();
			log.info(email);
		}
	}
	
	/**
	 * Send an email to the email address.
	 * @param email the email address.
	 * @return Email sent successfully?
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	private boolean sendEmail(String email) throws ClientProtocolException, IOException{
		stringResponse = getPage("http://www.email-standards.org/blog/entry/want-to-test-your-own-email-client/");
		
		httpPost = new HttpPost("http://emailstandardsproject.cmail1.com/s/388620/");
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("cm-388620-388620", email));
        
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
        httpPost.setEntity(entity);
		httpResponse = httpclient.execute(httpPost, httpContext);
        stringResponse = EntityUtils.toString(httpResponse.getEntity());
        return stringResponse.contains("http://www.email-standards.org/acid-test-sent/");
	}
	
	/**
	 * Read all the content of a page
	 * @param url the url that you want to read from.
	 * @return Return the content of a page.
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	private String getPage(String url) throws ClientProtocolException, IOException{
		httpGet = new HttpGet(url);
		httpResponse = httpclient.execute(httpGet, httpContext);
        stringResponse = EntityUtils.toString(httpResponse.getEntity());
        return stringResponse;
	}
}
