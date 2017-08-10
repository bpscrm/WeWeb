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
		System.out.println( "[TextMessage][getContent]" + content);
		return content;
	}

	public void setContent(String content) {
		System.out.println( "[TextMessage][setContent]" + content);
		this.content = content;
	}

	@Override
	public String toString() {
		System.out.println( "[TextMessage][toString]");
		return "TextMessage [content=" + content + ", toString()=" + super.toString() + "]";
	}	
	
}
