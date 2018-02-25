/**
 * 
 */
package com.guerrillamail.www;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Representation of an email. This contains the message, the forwarder and the remaining information in an email.
 * @author <a ref="https://github.com/DavidePastore">DavidePastore</a>
 *
 */
public class EMail {
	
	private int att;
	private String body;
	private String contentType;
	private String date;
	private String excerpt;
	private int id;
	private boolean read;
	private String recipient;
	private String sender;
	private int sourceId;
	private int sourceMailId;
	private String subject;
	private long timestamp;
	
	
	/**
	 * Constructor of the EMail.
	 * @param jSonObject the JSONObject from which to create the EMail object.
	 * @throws JSONException
	 */
	public EMail(JSONObject jSonObject) throws JSONException{
		//log.info("jsonobject: "+jSonObject);
//		recipient = jSonObject.getString("mail_recipient");
		recipient = safelyGetStringFromJson("mail_recipient", jSonObject);
		timestamp = jSonObject.getLong("mail_timestamp");
		date = jSonObject.getString("mail_date");
		read = Utils.fromIntToBoolean(jSonObject.getInt("mail_read"));
		sender = jSonObject.getString("mail_from");
//		sourceId = jSonObject.getInt("source_id");
		sourceId = Integer.parseInt(safelyGetStringFromJson("source_id", jSonObject));
		excerpt = jSonObject.getString("mail_excerpt");
		att = jSonObject.getInt("att");
		subject = jSonObject.getString("mail_subject");
//		contentType = jSonObject.getString("content_type");
		contentType = safelyGetStringFromJson("content_type", jSonObject);
//		sourceMailId = jSonObject.getInt("source_mail_id");
		sourceMailId = Integer.parseInt(safelyGetStringFromJson("source_mail_id", jSonObject));
		id = jSonObject.getInt("mail_id");
	}

	private String safelyGetStringFromJson(String field, JSONObject jSonObject){
		String result;
		try{
			result = jSonObject.getString(field);
		}
		catch (JSONException e){
			result = "0";
		}
		return result;
	}
	
	/**
	 * Return the String representation of this email.
	 * @return the String representation of this email.
	 */
	public String toString(){
		return String.format("ID:%d\nFrom: <%s>\nSubject: %s\nDate: %s\nRead: %s\nBody: %s\n", id, sender, subject, date, read, body);
	}
	
	
	/* GET METHODS */
	
	/**
	 * Get the mail att.
	 * @return the att of this email.
	 */
	public int getAtt(){
		return this.att;
	}
	
	/**
	 * Get the mail body.
	 * @return the body of this email.
	 */
	public String getBody(){
		return this.body;
	}
	
	/**
	 * Get the mail content type.
	 * @return the content type of this email.
	 */
	public String getContentType(){
		return this.contentType;
	}
	
	/**
	 * Get the mail date.
	 * @return the date of this email.
	 */
	public String getDate(){
		return this.date;
	}
	
	/**
	 * Get the mail excerpt.
	 * @return the excerpt of this email.
	 */
	public String getExcerpt(){
		return this.excerpt;
	}
	
	/**
	 * Get the mail id.
	 * @return the id of this email.
	 */
	public int getId(){
		return this.id;
	}
	
	/**
	 * Get the mail read.
	 * @return the read of this email.
	 */
	public boolean getRead(){
		return this.read;
	}
	
	/**
	 * Get the mail recipient.
	 * @return the recipient of this email.
	 */
	public String getRecipient(){
		return this.recipient;
	}
	
	/**
	 * Get the mail sender.
	 * @return the sender of this email.
	 */
	public String getSender(){
		return this.sender;
	}
	
	/**
	 * Get the mail source id.
	 * @return the source id of this email.
	 */
	public int getSourceId(){
		return this.sourceId;
	}
	
	/**
	 * Get the mail source mail id.
	 * @return the source mail id of this email.
	 */
	public int getSourceMailId(){
		return this.sourceMailId;
	}
	
	/**
	 * Get the mail subject.
	 * @return the subject of this email.
	 */
	public String getSubject(){
		return this.subject;
	}
	
	/**
	 * Get the mail timestamp.
	 * @return the timestamp of this email.
	 */
	public long getTimestamp(){
		return this.timestamp;
	}
	
	
	/* SET METHODS */
	
	/**
	 * Set the body of the email.
	 * @param body the body of the EMail.
	 */
	public void setBody(String body){
		this.body = body;
	}
}
