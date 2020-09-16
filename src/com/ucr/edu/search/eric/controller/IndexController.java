package com.ucr.edu.search.eric.controller;

import com.ucr.edu.search.eric.dao.LuceneDbDao;
import com.ucr.edu.search.eric.pojo.ArticlePOJO;
import com.ucr.edu.search.eric.utils.JsoupParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.ArrayList;


@Controller

@RequestMapping("/indexController")
public class IndexController {
    @RequestMapping("/hi.do")
    public ModelAndView show(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();

        LuceneDbDao ld  = new LuceneDbDao();
        ArrayList<ArticlePOJO> alp = new ArrayList<ArticlePOJO>();
        alp = ld.testQueryDb();
        System.out.println(alp.get(0).getContent().toString());
        JsoupParser jp = new JsoupParser();
        // TODO 剔除所有标签以及无用内容，获取内容
//        for(ArticlePOJO apj : alp)
//        {
//            String content_str = apj.getContent();
//            apj.setContent(jp.GetThePassageText(content_str));
//        }

        mv.addObject("info","HelloWorld! This is Spring MVC");
        mv.addObject(alp);
        mv.setViewName("index");
        return mv;
    }
}