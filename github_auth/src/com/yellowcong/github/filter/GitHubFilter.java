package com.yellowcong.github.filter;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class GitHubFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String code = req.getParameter("code");
		if(code != null && !"".equals(code)){
			System.out.println("返回的"+code);
			//https://github.com/login/oauth/access_token?client_id=xxxx&client_secret=xxx&code=xxx&redirect_uri=xx
			String uri = URLEncoder.encode("http://yellowcong.wicp.net/github_auth/login.jsp", "utf-8");
			String path = "https://github.com/login/oauth/access_token?client_id=9d4d0bfce4c2f328279f&client_secret=034d444efb060f6feb10e29b5f5bc7226bf963fc&code="+code+"&redirect_uri="+uri;
			
			String str = sendGet(path);
			
			if(str != null){
				String token = str.substring(str.indexOf("access_token=")+"access_token=".length(), str.indexOf("&scope="));
				//获取token
				System.out.println(token);
				
				//获取用户信息
				String URI_INFO = "https://api.github.com/user?access_token="+token;
				/**
				 * 返回的数据信息
{"login":"yellowcong","id":11716180,"avatar_url":"https://avatars.githubusercontent.com/u/11716180?v=3","gravatar_id":"","url":"https://api.github.com/users/yellowcong","html_url":"https://github.com/yellowcong","followers_url":"https://api.github.com/users/yellowcong/followers","following_url":"https://api.github.com/users/yellowcong/following{/other_user}","gists_url":"https://api.github.com/users/yellowcong/gists{/gist_id}","starred_url":"https://api.github.com/users/yellowcong/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/yellowcong/subscriptions","organizations_url":"https://api.github.com/users/yellowcong/orgs","repos_url":"https://api.github.com/users/yellowcong/repos","events_url":"https://api.github.com/users/yellowcong/events{/privacy}","received_events_url":"https://api.github.com/users/yellowcong/received_events","type":"User","site_admin":false,"name":"yellowcong","company":"yellowcong","blog":"http://yellowcong.jd-app.com","location":"湖北","email":"717350389@qq.com","hireable":null,"bio":null,"public_repos":32,"public_gists":0,"followers":3,"following":0,"created_at":"2015-03-30T08:13:08Z","updated_at":"2016-03-29T10:38:57Z"}
				 */
				//获取到用户信息
				String userInfo = sendGet(URI_INFO);
				
				System.out.println("用户信息\t"+userInfo);
			}
			
		}
		
		chain.doFilter(req, resp);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 发送get请求给服务器
	 * @param uri
	 * @return 
	 */
	public String sendGet(String uri){
		String res = null;
		try {
			HttpClient client = new HttpClient();
			//6ff5878ee99bf1cc87d6
			GetMethod method = new GetMethod(uri);
			int statu2 = client.executeMethod(method);
			if(statu2 >= 200 && statu2 <300){
				res = method.getResponseBodyAsString();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

}
