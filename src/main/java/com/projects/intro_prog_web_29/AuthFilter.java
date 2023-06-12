package com.projects.intro_prog_web_29;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "auth", urlPatterns = {"/amministratore.jsp", "/aderente.jsp", "/simpatizzante.jsp", "/admin", "/aderente", "/simpatizzante"})
public class AuthFilter implements Filter {
    // Filter to check if a user can be in a page or not

    // The filter is applied only to pages in the urlPatterns array, so the pages that needs
    // the user to be registered and logged in to be accessed
    protected FilterConfig config;

    public void init(FilterConfig config) {this.config = config;}

    public void destroy() {this.config = null;}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Read the request and get the session
        HttpServletRequest hreq=(HttpServletRequest) request;
        HttpSession session = hreq.getSession(false);

        // Get from the URL the jsp page we are in
        String page = hreq.getRequestURI().substring(hreq.getContextPath().length());


        if(session == null || session.getAttribute("username") == null){
            // If the user is not logged in, redirect to the login page, because no page in the array
            // is accessible if not logged in
            request.setAttribute("error", "Non sei loggato, effettua il login per accedere a questa pagina");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }else{
            // Otherwise check if the user has the permission to access the page, if it is the correct page to stay in
            String role = (String) session.getAttribute("userType");
            String page_url = AuthBasic.redirect_pages.get(role);

            // Otherwise, it gets redirected to the page that corresponds to the user role
            if(!page.equals(page_url)){
                request.setAttribute("error", "Non hai i permessi per accedere a questa pagina");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
                return;
            }
        }

        chain.doFilter(request,response);
    }
}
