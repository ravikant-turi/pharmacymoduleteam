package com.infinite.jsf.test;

import com.infinite.jsf.util.MailSend;

public class MailSenderTest {
	
	public static void main(String[] args) {
		System.out.println("Hello world");
		MailSend.sendInfo("turiravikant@gmail.com", "this is for pharmacy review", "2384");
	}

}
