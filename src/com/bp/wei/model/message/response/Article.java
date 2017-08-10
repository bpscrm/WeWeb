package com.bp.wei.model.message.response;
/**
 * 
 * @author liyanc
 * @desc Article item in Article response message
 */
public class Article {
	//图文消息标题
	private String Title;
	
	//图文消息描述
	private String Description;
	
	//图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
	private String PicUrl;
	
	//点击图文消息跳转链接
	private String Url;

	public String getTitle() {
		System.out.println( "[response][Article][getTitle]" + Title);
		return Title;
	}

	public void setTitle(String title) {
		System.out.println( "[response][Article][setTitle]" + Title);
		Title = title;
	}

	public String getDescription() {
		System.out.println( "[response][Article][getDescription]" + Description);
		return Description;
	}

	public void setDescription(String description) {
		System.out.println( "[response][Article][setDescription]" + description);
		Description = description;
	}

	public String getPicUrl() {
		System.out.println( "[response][Article][getPicUrl]" + PicUrl);
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		System.out.println( "[response][Article][setPicUrl]" + picUrl);
		PicUrl = picUrl;
	}

	public String getUrl() {
		System.out.println( "[response][Article][getUrl]" + Url);
		return Url;
	}

	public void setUrl(String url) {
		System.out.println( "[response][Article][setUrl]" + url);
		Url = url;
	}

	@Override
	public String toString() {
		System.out.println( "[response][Article][toString]");
		return "Item [Title=" + Title + ", Description=" + Description + ", PicUrl=" + PicUrl + ", Url=" + Url + "]";
	}	
	
}
