package com.bp.wei.model.message.request;
/**
 * 
 * @author liyanc
 * @desc URL Message
 */
public class LinkMessage extends BaseMessage {
	//消息标题
	private String Title;	
	
	//消息描述
	private String Description;
	
	//消息链接
	private String Url;

	public String getTitle() {
		System.out.println( "[LinkMessage][getTitle]");
		return Title;
	}

	public void setTitle(String title) {
		System.out.println( "[LinkMessage][setTitle]");
		Title = title;
	}

	public String getDescription() {
		System.out.println( "[LinkMessage][getDescription]");
		return Description;
	}

	public void setDescription(String description) {
		System.out.println( "[LinkMessage][getUrl]" + description);
		Description = description;
	}

	public String getUrl() {
		System.out.println( "[LinkMessage][getUrl]" + Url);
		return Url;
	}

	public void setUrl(String url) {
		System.out.println( "[LinkMessage][setUrl]" + url);
		Url = url;
	}

	@Override
	public String toString() {
		System.out.println( "[LinkMessage][toString]");
		return "LinkMessage [Title=" + Title + ", Description=" + Description + ", Url=" + Url + ", toString()="
				+ super.toString() + "]";
	}	
	
}
