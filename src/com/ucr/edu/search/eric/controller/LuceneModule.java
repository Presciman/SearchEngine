/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucr.edu.search.eric.controller;


import com.ucr.edu.search.eric.dao.LuceneDbDao;
import com.ucr.edu.search.eric.pojo.ArticlePOJO;
import com.ucr.edu.search.eric.utils.JsoupParser;

import java.util.ArrayList;


/**
 *
 * @author sunba
 */
public class LuceneModule {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Test DB connection module
        LuceneDbDao ld  = new LuceneDbDao();
        ArrayList<ArticlePOJO> alp = new ArrayList<ArticlePOJO>();
        alp = ld.testQueryDb();
        System.out.println(alp.get(0).getContent().toString());
        JsoupParser jp = new JsoupParser();
        // TODO 剔除所有标签以及无用内容，获取内容
        for(ArticlePOJO apj : alp)
        {
            String content_str = apj.getContent();
            apj.setContent(jp.GetThePassageText(content_str));
        }
//        for(ArticlePOJO apjj : alp)
//        {
//            System.out.println(apjj.getContent());
//        }
//        1.the content in ArticlePOJO need to be parsed via jsoup (dom structure)
//        2.use the Lucene to Search in Database and give a ranking of the results
//        3.(+) use a function to adjust the correctness of ranking (set parameters)
       
    }
    
}
