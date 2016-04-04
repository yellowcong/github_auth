package com.yellowcong.github.test;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.Test;

public class DemoTest {
	
	
	@Test
	public void testStr(){
		String str =   "access_token=a830243338566fc7a2ec912d10fae76fc3e2aec1&scope=&token_type=bearer";
		str = str.substring(str.indexOf("access_token=")+"access_token=".length(), str.indexOf("&scope="));
		System.out.println(str);
	}
	
	@Test
	public void testSTr2() throws Exception, Exception{
		String token = "a830243338566fc7a2ec912d10fae76fc3e2aec1";
		String URI_INFO = "https://api.github.com/user?access_token="+token;
		HttpClient client2 = new HttpClient();
		//6ff5878ee99bf1cc87d6
		GetMethod method2 = new GetMethod(URI_INFO);
		int statu2 = client2.executeMethod(method2);
		if(statu2 >= 200 && statu2 <300){
			String str2 = method2.getResponseBodyAsString();
			System.out.println("token返回的数据"+str2);
		}
				
	}
}
