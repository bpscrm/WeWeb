package com.bp.wei.model.message.response;  
  
import java.util.List;  
  
public class PicNewsMessage extends BaseMessage{    //图文消息的基本设置  
    private int ArticleCount;  
    private List<PicNews> Articles;//该集合中存放的是PicNews对象，每个对象都代表着一条图文消息  
    public int getArticleCount() {  
        return ArticleCount;  
    }  
    public void setArticleCount(int articleCount) {  
        ArticleCount = articleCount;  
    }  
    public List<PicNews> getArticles() {  
        return Articles;  
    }  
    public void setArticles(List<PicNews> articles) {  
        Articles = articles;  
    }  
}  