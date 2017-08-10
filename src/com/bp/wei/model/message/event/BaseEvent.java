package com.bp.wei.model.message.event;
/**
 * 
 * @author liyanc
 * @ Event Base Class
 */
public class BaseEvent {
	// 开发者微信号
    private String ToUserName;
    
    // 发送方帐号（一个OpenID）
    private String FromUserName;
    
    // 消息创建时间 （整型）
    private long CreateTime;
    
    // 消息类型
    private String MsgType;
    
    // 事件类型
    private String Event;

	public String getToUserName() {
		System.out.println( "[BaseEvent][getToUserNAme]");
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		System.out.println( "[BaseEvent][setToUserName]");
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		System.out.println( "[BaseEvent][getFromUserName]");
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		System.out.println( "[BaseEvent][setFromUserName]");
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		System.out.println( "[BaseEvent][getCreateTime]");
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		System.out.println( "[BaseEvent][setCreateTime]");
		CreateTime = createTime;
	}

	public String getMsgType() {
		System.out.println( "[BaseEvent][getMsgType]");
		return MsgType;
	}

	public void setMsgType(String msgType) {
		System.out.println( "[BaseEvent][setMsgType]");
		MsgType = msgType;
	}

	public String getEvent() {
		System.out.println( "[BaseEvent][getEvent]");
		return Event;
	}

	public void setEvent(String event) {
		System.out.println( "[BaseEvent][setEvent]");
		Event = event;
	}

	@Override
	public String toString() {
		System.out.println( "[BaseEvent][toString]");
		return "BaseEvent [ToUserName=" + ToUserName + ", FromUserName=" + FromUserName + ", CreateTime=" + CreateTime
				+ ", MsgType=" + MsgType + ", Event=" + Event + "]";
	}    
    
}
