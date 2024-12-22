package pers.fulsun.blog.web.admin.controller;

import com.pig4cloud.captcha.SpecCaptcha;
import com.pig4cloud.captcha.base.Captcha;
import com.pig4cloud.captcha.utils.CaptchaJakartaUtil;
import com.pig4cloud.captcha.utils.CaptchaUtil;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台登录控制器
 *
 * @author fulsun
 */
@Controller
@RequestMapping("/admin")
@Slf4j
public class LoginController {
    /**
     * 后台登录页面
     * @return String
     */
    @RequestMapping({"/", "/login.html", "/index.html", "/login", "/index"})
    public String login() {
        return "admin/login";
    }

    /**
     * 获取验证码
     *
     * @param response
     * @param session
     * @throws Exception
     */
    @RequestMapping(value = "/captcha.jpg")
    public void getCaptchaImage(HttpServletResponse response, HttpSession session) throws Exception {
        // 设置请求头为输出图片类型
        CaptchaJakartaUtil.setHeader(response);
        // 三个参数分别为宽、高、位数
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 32, 4);
        // 设置类型，纯数字、纯字母、字母数字混合
        specCaptcha.setCharType(Captcha.TYPE_NUM_AND_UPPER);
        log.info("验证码结果：" + specCaptcha.text());
        // 输出图片流
        specCaptcha.out(response.getOutputStream());
    }


}

