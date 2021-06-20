package interceptor;

import com.study.jwt.JWTUtil;
import com.study.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");

        //解决跨越与拦截器冲突
        if("OPTIONS".equals(request.getMethod().toUpperCase())){
            return true;
        }

        if(token!=null){
            //验证携带的token是否是一个有效的
            User user= JWTUtil.getUser(token);
            if(user==null){
                return false;
            }
            //生成新的token
            String newToken = JWTUtil.createJsonWebToken(user);
            response.setHeader("token",newToken);
            response.setHeader("Access-Control-Expose-Headers", "token");
            request.setAttribute("user",user);
            return true;
        }
        return false;
    }

}

