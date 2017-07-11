package com.bp.wei.model.message.response;
/**
 * 
 * @author liyanc
 * @desc Video response message
 * <xml>
	<ToUserName><![CDATA[toUser]]></ToUserName>
	<FromUserName><![CDATA[fromUser]]></FromUserName>
	<CreateTime>12345678</CreateTime>
	<MsgType><![CDATA[video]]></MsgType>
	<Video>
	<MediaId><![CDATA[media_id]]></MediaId>
	<Title><![CDATA[title]]></Title>
	<Description><![CDATA[description]]></Description>
	</Video> 
	</xml>
 */
public class VideoMessage extends BaseMessage {
	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	@Override
	public String toString() {
		return "VideoMessage [video=" + video + ", toString()=" + super.toString() + "]";
	}	
	
}
