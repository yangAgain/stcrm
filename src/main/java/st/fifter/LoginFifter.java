package st.fifter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import st.crm.model.UserModel;

public class LoginFifter extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod method = (HandlerMethod) handler;
		Auth auth = method.getMethod().getAnnotation(Auth.class);
		// 验证登陆超时问题 auth = null，默认不验证
		if (auth != null && auth.verifyLogin()) {
			String baseUri = request.getContextPath();
			UserModel um = (UserModel) request.getSession().getAttribute("user");
			if (um == null) {
				request.getRequestDispatcher(baseUri + "/jsp/login.jsp");
				response.sendRedirect(baseUri + "/jsp/login.jsp");
				return false;
			}
		}
		return super.preHandle(request, response, handler);
	}

}
