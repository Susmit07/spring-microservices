package com.sapient.microservices.Netflixzuulapigatewayserver.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFile extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// Main logic of interception.
	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		HttpServletRequest request = 
				RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri -> {}", 
				request, request.getRequestURI());
		return null;
	}

	// Should this be filter executed every once for every request by default false
	@Override
	public boolean shouldFilter() {
		return true;
	}

	// Filter order for this filter by default 0
	@Override
	public int filterOrder() {
		return 1;
	}
	
	// Should the filter be happening before the request being executed (pre), 
	// after(post), or only error request.
	@Override
	public String filterType() {
		return "pre";
	}
}
