package com.gdu.app12.aspect;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@EnableAspectJAutoProxy
@Component
public class ConfirmLoginAspect {

  // 포인트컷 : ConfirmLoginAspect를 동작시킬 메소드
  // execution : 반환타입 (*) < 모든 반환타입  
  // com.gdu.app12.controller.*Controller < 모든 컨트롤러
  // .requiredLogin_*) < 모든 메소드
  // (..) 모든 매개변수
  @Pointcut("execution(* com.gdu.app12.controller.*Controller.requiredLogin_*(..))")
  public void requiredLogin() {}
  
  
  // 조인포인트(컨트롤러의 모든 메소드)가 동작하기 이전에 포인트컷이 동작
  @Before("requiredLogin()")
  public void requiredLoginHandler(JoinPoint joinpoint) throws Exception {
    
    // 로그인 확인을 위해서 HttpServletRequest를 구한뒤 HttpSession을 구한다.
    ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = servletRequestAttributes.getRequest();
    HttpSession session = request.getSession();
    
    // 로그인 여부
    if(session.getAttribute("loginId") == null) {
      
      // 응답을 위한 HttpServletResponse를 구한다
      HttpServletResponse response = servletRequestAttributes.getResponse();
      
      // 응답
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>");
        out.println("if(confirm('로그인이 된 후 가능합니다. 로그인 하시겠습니까?')){;");
        out.println("location.href='" + request.getContextPath() + "/user/login.form';");
        out.println("} else {");
        out.println("history.back();");
        out.println("}");
        out.println("</script>");
        out.flush();
        out.close();
        
    }
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
