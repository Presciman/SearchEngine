/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucr.edu.search.eric.dao;


import com.ucr.edu.search.eric.pojo.ArticlePOJO;
import com.ucr.edu.search.eric.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sunba
 */
public class LuceneDbDao {
    
        public ArrayList<ArticlePOJO> testQueryDb()
        {
                ArrayList<ArticlePOJO> result = new ArrayList<ArticlePOJO>();
                Connection con = null;
                PreparedStatement st = null;
                con = DBUtil.getConnection();
                ResultSet rs = null;
            try {
                
               
                StringBuilder sql= new StringBuilder();
                
                sql.append("  select * from `4[physical]article` ");
                st = con.prepareStatement(sql.toString());
//                int index = 1;

                rs = st.executeQuery();
                
                while (rs.next())
                {
                    ArticlePOJO article = new ArticlePOJO();
                    article.setUrl_object_id(rs.getString("url_object_id"));
                    article.setTitle(rs.getString("title"));
                    article.setUrl(rs.getString("url"));
                    article.setCreate_date(rs.getString("create_date"));
                    article.setFront_image_url(rs.getString("front_image_url"));
                    article.setAuthor(rs.getString("author"));
                    article.setTag(rs.getString("tag"));
                    article.setContent(rs.getString("content"));
                    article.setFront_image_path(rs.getString("front_image_path"));
                    result.add(article);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(LuceneDbDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally 
		   {
			   DBUtil.closeResource(rs,st, con);
		   }
            return result;
        }
    
        public boolean InsertNewContentToDB( ArrayList<ArticlePOJO> alap)
        {
            boolean result = true;
            Connection con = null;
            PreparedStatement st = null;
            con = DBUtil.getConnection();
            
            
            
            return result;
        }
}
