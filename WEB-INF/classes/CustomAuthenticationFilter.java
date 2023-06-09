import java.io.IOException;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomAuthenticationFilter implements Filter {

	
	private CallbackHandler handler;
		private FilterConfig filterConfig;
		
	
		public void init(FilterConfig filterConfig) throws ServletException {
			this.filterConfig = filterConfig;
		}
		  
		

			private static final String LOGIN_PAGE_URL = "/login.jsp";
			private static final String OTP_PAGE_URL = "/error.jsp";
		  
			@Override
			public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			  HttpServletRequest httpRequest = (HttpServletRequest) request;
					
			  // Check if this is a login request
			  if (httpRequest.getMethod().equalsIgnoreCase("POST")
				  && httpRequest.getParameter("j_security_check") != null
				  && httpRequest.getParameter("j_security_check").equals("/j_security_check")) {
				
				// Check if the request came from the login page or the OTP page
				String referer = httpRequest.getHeader("referer");
				System.out.println(referer);
				if (referer != null && referer.endsWith(LOGIN_PAGE_URL)) {
				  // This is a login request from the login page, use BasicLoginModule
				  invokeLoginModule("BasicLoginModule");
				} else if (referer != null && referer.endsWith(OTP_PAGE_URL)) {
				  // This is a login request from the OTP page, use OtpLoginModule
				  invokeLoginModule("OtpModule");
				}
			  }
		  
			  // Continue the filter chain
			  chain.doFilter(request, response);
			}
		  
			private void invokeLoginModule(String loginModuleName) throws ServletException {
			  try {
				// Get the LoginContext for the given login module
				LoginContext lc = new LoginContext(loginModuleName) {
				  // Implement the callback handler here
				};
		  
				// Invoke the login module
				lc.login();
				
			  } catch (LoginException e) {
				throw new ServletException("Login failed: " + e.getMessage());
			  }
			}
		  
		  
		public void destroy() {
			filterConfig = null;
		}
	
	
  }

		
  