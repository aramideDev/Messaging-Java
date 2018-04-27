/**
 * 
 */
package com.syniverse.scgapi;

/**
 * @author ashobande
 *
 */
public class SimpleActivator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final String baseUrl = "https://api.syniverse.com";
		final String validSenderId = "3VjDOfH2P6Juf7JAI2cwb7";
		final String invalidSenderId = "3VjDOfH2P6Juf7JAI21Fb7";
		
		sendTestSms(baseUrl, validSenderId);
	}

	private static MessageRequest sendTestSms(final String baseUrl, final String senderId) {
		
		AuthInfo authInfo = new AuthInfo("_5LfsWuC04n9VdXpwkmxFxwCpT0a", "fONDfPJaOci7lBxKkDLzZ1mmOYAa", "a79463de-3142-3919-9b36-a9f46660f751", 3);
		Session session = null;
		
		Scg scg = new Scg();
		try {
			
			session = scg.connect(baseUrl, authInfo);
			
			//now connected to session, send required msg...
			
			MessageRequest.Resource res = new MessageRequest.Resource(session);
			MessageRequest messageRequest = new MessageRequest(); // create a generic message req obj...
			messageRequest.setFrom(senderId);
			
			messageRequest.setTo("+447711953722");
			messageRequest.setBody("this is a sample message from syniverse's API...");
			messageRequest.setTestMessageFlag(false);
			
				// TODO -->> this could be used as the 'MessageResponse' section, where we obtain metadata regarding the just-distributed message
			String reqId = res.create(messageRequest);
			
			//using pulled req info, get metadata regarding the sent message (e.g. state, success message etc)...
			final MessageRequest pulledMesId = res.get(reqId);
			pulledMesId.getState();
			System.out.println("message request id: " + pulledMesId.getId());
			return pulledMesId;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
		
	}

}
