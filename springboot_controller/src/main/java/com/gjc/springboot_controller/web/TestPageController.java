package com.gjc.springboot_controller.web;

import com.gjc.common.constant.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class TestPageController {


    // ***************************转发******************

    // 转发请求 forward
    // 以字符串的形式构建目标url, url 需要加上 forward: 前缀
    @RequestMapping("/page1")
    public String page1() {
        return "forward:/pageResult?param1=value1&param2=value2";
    }


    /**
     * modelAndView 跳转请求地址
     * @return
     */
    @RequestMapping("/page2")
    public ModelAndView page2() {
        ModelAndView modelAndView = new ModelAndView("/pageResult");// 绝对路径OK
//        ModelAndView modelAndView = new ModelAndView("pageResult");// 相对路径也OK
        return modelAndView;
    }

    // *******************************重定向*******************

    @RequestMapping("/redirect")
    public RedirectView redirect() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("pageResult");
        return redirectView;
    }

    @RequestMapping("/redirectOne")
    public String redirectOne() {
        return "redirect:/pageResult";
    }

    // 重定向带值
    @RequestMapping("/redirectResult")
    public String redirectResult(RedirectAttributes attributes) {
        attributes.addAttribute("param1", "value1");
        attributes.addAttribute("param2", "value2");
        return "redirect:/pageResult";
    }



    // *******************跳转地址后的结果*********************
    // 请求跳转后的路径请求
    @RequestMapping("/pageResult")
    @ResponseBody
    public ResultData pageResult(String param1, String param2) {
        log.info("param1: {} ,param2: {}", param1, param2);
        return new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成");
    }


}
