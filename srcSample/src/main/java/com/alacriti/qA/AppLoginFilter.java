package com.alacriti.qA;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppLoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		  String url = request instanceof HttpServletRequest ?
	                ((HttpServletRequest) request).getRequestURL().toString() : "N/A";
	      
	      System.out.println("from filter, processing url: " + url);
	      System.out.println("Origin: " + ((HttpServletRequest) request).getHeader("origin") );
	      HttpServletResponse  httpServletResponse = (HttpServletResponse) response;
	      // We can get white listed origin values as input and validate the origin based on that
	      httpServletResponse.addHeader("Access-Control-Allow-Origin",((HttpServletRequest) request).getHeader("origin") );
	      //httpServletResponse.addHeader("Access-Control-Allow-Origin","http://192.168.35.68:1234" );
	      httpServletResponse.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
	      httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
	      httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	      httpServletResponse.addHeader("Access-Control-Max-Age", "1209600");
	      chain.doFilter(request, httpServletResponse);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
