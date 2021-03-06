package com.bp.wei.model.message.response;
/**
 * 
 * @author liyanc
 * @desc Text message response
 * 
 * <xml>
	<ToUserName><![CDATA[toUser]]></ToUserName>
	<FromUserName><![CDATA[fromUser]]></FromUserName>
	<CreateTime>12345678</CreateTime>
	<MsgType><![CDATA[text]]></MsgType>
	<Content><![CDATA[你好]]></Content>
   </xml>
 */
public class TextMessage extends BaseMessage {
	// 回复的消息内容
    private String Content;

	public String getContent() {
		System.out.println( "[response][TextMessage][getContent]");
		return Content;
	}

	public void setContent(String content) {
		System.out.println( "[response][TextMessage][setContent]");
		Content = content;
	}

	@Override
	public String toString() {
		System.out.println( "[response][TextMessage][toString]");
		return "TextMessage [Content=" + Content + ", toString()=" + super.toString() + "]";
	}    
    
}
