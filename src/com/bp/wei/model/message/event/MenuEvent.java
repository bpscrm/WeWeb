package com.bp.wei.model.message.event;
/**
 * 
 * @author liyanc
 * @desc custom menu event
 * <xml>
	<ToUserName><![CDATA[toUser]]></ToUserName>
	<FromUserName><![CDATA[FromUser]]></FromUserName>
	<CreateTime>123456789</CreateTime>
	<MsgType><![CDATA[event]]></MsgType>
	<Event><![CDATA[CLICK]]></Event>
	<EventKey><![CDATA[EVENTKEY]]></EventKey>
   </xml>
 * 
 */
public class MenuEvent extends BaseEvent {
	//mapped to Menu.key 对应自定义菜单类的key
	private String EventKey;

	public String getEventKey() {
		System.out.println( "[MenuEvent][getEventKey]");
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		System.out.println( "[MenuEvent][setEventKey]");
		EventKey = eventKey;
	}

	@Override
	public String toString() {
		System.out.println( "[MenuEvent][toString]");
		return "MenuEvent [EventKey=" + EventKey + ", toString()=" + super.toString() + "]";
	}	
	
}
