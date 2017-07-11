package com.bp.wei.model.message.response;
/**
 * 
 * @author liyanc
 * @desc Voice response message
 * 
 * <xml>
	<ToUserName><![CDATA[toUser]]></ToUserName>
	<FromUserName><![CDATA[fromUser]]></FromUserName>
	<CreateTime>12345678</CreateTime>
	<MsgType><![CDATA[voice]]></MsgType>
	<Voice>
	<MediaId><![CDATA[media_id]]></MediaId>
	</Voice>
	</xml>
 */
public class VoiceMessage extends BaseMessage {
	
	private Voice voice;

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	@Override
	public String toString() {
		return "VoiceMessage [voice=" + voice + ", toString()=" + super.toString() + "]";
	}	
	
}
