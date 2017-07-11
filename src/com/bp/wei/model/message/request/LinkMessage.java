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
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	@Override
	public String toString() {
		return "LinkMessage [Title=" + Title + ", Description=" + Description + ", Url=" + Url + ", toString()="
				+ super.toString() + "]";
	}	
	
}
