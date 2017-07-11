package com.bp.wei.model.message.response;
/**
 * 
 * @author liyanc
 * @desc Image response message
 * 
 * <xml>
	<ToUserName><![CDATA[toUser]]></ToUserName>
	<FromUserName><![CDATA[fromUser]]></FromUserName>
	<CreateTime>12345678</CreateTime>
	<MsgType><![CDATA[image]]></MsgType>
	<Image>
	<MediaId><![CDATA[media_id]]></MediaId>
	</Image>
	</xml>
 */
public class ImageMessage extends BaseMessage {
	private Image image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ImageMessage [image=" + image + ", toString()=" + super.toString() + "]";
	}	
	
}
