package lab;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BackFilter implements Filter {
    private static final String SESSION_ATTR = "sessionObj";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        if (session == null) {
            session = req.getSession(true);
        }

        Object attribute = session.getAttribute(SESSION_ATTR);
        if (attribute != null) {
            SessionAttribute object = (SessionAttribute) attribute;
            if (object.validateCurrentUrl(req.getRequestURI())) {
            } else {
                resp.sendRedirect(req.getContextPath() + "/error.xhtml");
            }
            object.setParam(req.getRequestURI());
        } else {
            session.setAttribute(SESSION_ATTR, new SessionAttribute());
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

}

    @Override
    public void destroy() {
    }
}
