/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syniverse.scgapi;

/**
 * @author ashobande
 *
 */
public class SyniversePushSMSApiRequest {
	
	private MessageRequest.Resource messageResource;
	
	public SyniversePushSMSApiRequest(final MessageRequest.Resource msgResource) {
		
		this.messageResource = msgResource;
	}
	
	/**
	 * 
	 * Sends SMS request. Returns request Id.
	 * 
	 * @param originator
	 * @param destination
	 * @param messageBody
	 * @return
	 * @throws ScgException 
	 */
	public String pushMessageSMS(String originator, String destination, String messageBody) throws ScgException {
		
		MessageRequest scgMessageRequest = new MessageRequest();
		
		scgMessageRequest.setFrom("sender_id" + originator);
		scgMessageRequest.setTo(destination);
		scgMessageRequest.setBody(messageBody);
		
		final String scgRequestId = this.messageResource.create(scgMessageRequest);
		
		return scgRequestId;
	}
	
	//TODO --> if we later decide to go with this approach where we push messages through the syniverse SDK code, implement 'pushMEssageMMS(... /'
	

}