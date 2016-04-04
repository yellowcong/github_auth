package com.yellowcong.github.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GitHubAuthServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//服务器跳转
		String uri = URLEncoder.encode("http://yellowcong.wicp.net/github_auth/login.jsp", "utf-8");
		String state = UUID.randomUUID().toString();
		//跳转服务器
		resp.sendRedirect("https://github.com/login/oauth/authorize?client_id=9d4d0bfce4c2f328279f&state="+state+"&redirect_uri="+uri);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
