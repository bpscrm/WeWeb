package com.bp.wei.model.message.event;
/**
 * 
 * @author liyanc
 * @desc QR Code scanning
 * <xml>
 *  <ToUserName><![CDATA[toUser]]></ToUserName>
	<FromUserName><![CDATA[FromUser]]></FromUserName>
	<CreateTime>123456789</CreateTime>
	<MsgType><![CDATA[event]]></MsgType>
	<Event><![CDATA[subscribe]]></Event>
	<EventKey><![CDATA[qrscene_123123]]></EventKey>
	<Ticket><![CDATA[TICKET]]></Ticket>
   </xml>
 */
public class QRCodeEvent extends BaseEvent {
	// 事件KEY值
    private String EventKey;
    
    // 用于换取二维码图片
    private String Ticket;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}

	@Override
	public String toString() {
		return "QRCodeEvent [EventKey=" + EventKey + ", Ticket=" + Ticket + ", toString()=" + super.toString() + "]";
	}    
    
}
