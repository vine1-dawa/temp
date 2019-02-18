package org.devil.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    /**
     * (一)
     * ctrl + alt + v 生成变量
     * eg:       new ArrayList<String>();
     * (二)
     * ctrl + alt + l 格式化代码
     * (三)
     * alt + enter 导入包
     * (四)
     * ctrl + h 查看实现类
     * (五)
     * ctrl + shift + u 切换大小写
     * (六)
     * ctrl + d 复制一行
     * (七)
     * ctrl + y 删除一行
     * (八)
     * ctrl + alt + t surround with （try..catch）
     * (九)
     * ctrl + n 查找类
     * (十)
     * ctrl + f 查找文字
     * (十一)
     * ctrl + shift + f 全文查找文字
     * （）
     * @return
     */

    @RequestMapping("/hello")
    public String hello() {
        return "index";
    }

}
