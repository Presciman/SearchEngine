/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucr.edu.search.eric.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author sunba
 */
public class JsoupParser {
    public String GetThePassageText(String passage)
    {
        String result = null;
        if (passage != "" && passage != null)
        {
            Document doc = Jsoup.parse(passage);
            Elements eles = doc.getElementsByTag("p");
            StringBuffer buffer = new StringBuffer();
                for(Element ele: eles)
                {
                    buffer.append(ele.text().trim());
                }
                result = buffer.toString().trim();
        }
        return result;
    }
    
}
