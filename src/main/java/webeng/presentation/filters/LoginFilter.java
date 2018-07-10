package webeng.presentation.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webeng.presentation.managedbeans.UserBean;

public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		UserBean userBean = (UserBean)((HttpServletRequest)request).getSession().getAttribute("userBean");

		if (userBean == null || !userBean.isLoggedIn()) {
			String contextPath = ((HttpServletRequest)request).getContextPath();
			((HttpServletResponse)response).sendRedirect(contextPath + "/login.xhtml");
		}

		// TODO add logic to idivisual profile pages, restrict editing of posts
		
		else {
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void destroy() {
		
	}

}
