package com.bp.wei.model.message.request;

/**
 * 
 * @author liyanc
 * @desc Text Message
 */
public class TextMessage extends BaseMessage {
	//message content
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "TextMessage [content=" + content + ", toString()=" + super.toString() + "]";
	}	
	
}
