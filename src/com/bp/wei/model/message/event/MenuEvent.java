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
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	@Override
	public String toString() {
		return "MenuEvent [EventKey=" + EventKey + ", toString()=" + super.toString() + "]";
	}	
	
}
