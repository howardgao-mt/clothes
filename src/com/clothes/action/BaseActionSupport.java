package com.clothes.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class BaseActionSupport {
	private static final long serialVersionUID = -5494822598377316497L;

	protected HttpSession session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected ServletContext application;

	protected String resultPage;
	protected String message;
	protected String actionpath;

	public void initServlet() {
		this.request = ServletActionContext.getRequest();
		this.response = ServletActionContext.getResponse();
		this.application = ServletActionContext.getServletContext();
		this.session = request.getSession();
		this.message = "";
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public ServletContext getApplication() {
		return application;
	}

	public void setApplication(ServletContext application) {
		this.application = application;
	}

	public String getResultPage() {
		return resultPage;
	}

	public void setResultPage(String resultPage) {
		this.resultPage = resultPage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getActionpath() {
		return actionpath;
	}

	public void setActionpath(String actionpath) {
		this.actionpath = actionpath;
	}


}
