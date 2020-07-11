package com.atguigu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CharSetFilter
 */
public class CharSetFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String code = this.getFilterConfig().getInitParameter("code");
		request.setCharacterEncoding(code);
		response.setContentType("text/html;charset=UTF-8");
		//放行
		chain.doFilter(request, response);
	}
       

}
