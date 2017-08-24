package com.bp.wei.model.message.request;

/**
 * 
 * @author liyanc
 * @desc Base class of request message
 */
public class BaseMessage implements IMessage{
	// 开发者微信号
    private String ToUserName;
    // 发送方帐号（一个OpenID）
    private String FromUserName;
    // 消息创建时间 （整型）
    private long CreateTime;
    // 消息类型（text/image/location/link）
    private String MsgType;
    // 消息id，64位整型
    private long MsgId;
    
	public String getToUserName() {
		System.out.println( "[BaseMessage][getToUserName]" + ToUserName);
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		System.out.println( "[BaseMessage][setToUserName]" + toUserName);
		ToUserName = toUserName;
	}
	
	public String getFromUserName() {
		System.out.println( "[BaseMessage][getFromUserName]" + FromUserName);
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		System.out.println( "[BaseMessage][setFromUserName]" + fromUserName);
		FromUserName = fromUserName;
	}
	
	public long getCreateTime() {
		System.out.println( "[BaseMessage][getCreateTime]");
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		System.out.println( "[BaseMessage][setCreateTime]");
		CreateTime = createTime;
	}
	
	public String getMsgType() {
		System.out.println( "[BaseMessage][getMsgType]" + MsgType);
		return MsgType;
	}
	public void setMsgType(String msgType) {
		System.out.println( "[BaseMessage][setMsgType]" + msgType);
		MsgType = msgType;
	}
	
	public long getMsgId() {
		System.out.println( "[BaseMessage][getMsgId]" + MsgId);
		return MsgId;
	}
	public void setMsgId(long msgId) {
		System.out.println( "[BaseMessage][setMsgId]" + msgId);
		MsgId = msgId;
	}
	
	@Override
	public String toString() {
		System.out.println( "[BaseMessage][toString]");
		return "BaseMessage [ToUserName=" + ToUserName + ", FromUserName=" + FromUserName + ", CreateTime=" + CreateTime
				+ ", MsgType=" + MsgType + ", MsgId=" + MsgId + "]";
	}    
    
}
