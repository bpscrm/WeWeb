package com.bp.wei.model.message.response;
/**
 * 
 * @author liyanc
 * @desc Base response message info 公众账号->个人用户
 */
public class BaseMessage {
	// 接收方帐号（收到的OpenID）
    private String ToUserName;
    
    // 开发者微信号
    private String FromUserName;
    
    // 消息创建时间 （整型）
    private long CreateTime;
    
    // 消息类型
    private String MsgType;

	public String getToUserName() {
		System.out.println( "[BaseMessage][getToUserName]");
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		System.out.println( "[BaseMessage][setToUserName]");
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		System.out.println( "[BaseMessage][getFromUserName]");
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		System.out.println( "[BaseMessage][setFromUserName]");
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
		System.out.println( "[BaseMessage][getMsgType]");
		return MsgType;
	}

	public void setMsgType(String msgType) {
		System.out.println( "[BaseMessage][setMsgType]");
		MsgType = msgType;
	}

	@Override
	public String toString() {
		System.out.println( "[BaseMessage][toString]");
		return "BaseMessage [ToUserName=" + ToUserName + ", FromUserName=" + FromUserName + ", CreateTime=" + CreateTime
				+ ", MsgType=" + MsgType + "]";
	}    
    
}
