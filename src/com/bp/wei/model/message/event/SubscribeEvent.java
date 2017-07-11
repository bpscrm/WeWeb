package com.bp.wei.model.message.event;

/**
 * 
 * @author liyanc
 * @desc subscribe
 * 
 * <xml>
	<ToUserName><![CDATA[toUser]]></ToUserName>
	<FromUserName><![CDATA[FromUser]]></FromUserName>
	<CreateTime>123456789</CreateTime>
	<MsgType><![CDATA[event]]></MsgType>
	<Event><![CDATA[subscribe]]></Event>
   </xml>
 */
public class SubscribeEvent extends BaseEvent {

	@Override
	public String toString() {
		return "SubscribeEvent [toString()=" + super.toString() + "]";
	}

}
