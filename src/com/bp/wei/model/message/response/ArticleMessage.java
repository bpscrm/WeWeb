package com.bp.wei.model.message.response;

import java.util.List;

/**
 * 
 * @author liyanc
 * @desc Article response message
 * 
 * <xml>
	<ToUserName><![CDATA[toUser]]></ToUserName>
	<FromUserName><![CDATA[fromUser]]></FromUserName>
	<CreateTime>12345678</CreateTime>
	<MsgType><![CDATA[news]]></MsgType>
	<ArticleCount>2</ArticleCount>
	<Articles>
	<item>
	<Title><![CDATA[title1]]></Title> 
	<Description><![CDATA[description1]]></Description>
	<PicUrl><![CDATA[picurl]]></PicUrl>
	<Url><![CDATA[url]]></Url>
	</item>
	<item>
	<Title><![CDATA[title]]></Title>
	<Description><![CDATA[description]]></Description>
	<PicUrl><![CDATA[picurl]]></PicUrl>
	<Url><![CDATA[url]]></Url>
	</item>
	</Articles>
	</xml>
 */

public class ArticleMessage extends BaseMessage {
	// 图文消息个数，限制为10条以内
    private int ArticleCount;
    
    //多条图文
	private List<Article> articles;

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	@Override
	public String toString() {
		return "ArticleMessage [ArticleCount=" + ArticleCount + ", articles=" + articles + ", toString()="
				+ super.toString() + "]";
	}		
	
}
