package com.bp.wei.model.message.request;

/**
 * 
 * @author liyanc
 * @desc Image Message
 */
public class ImageMessage extends BaseMessage {
	//图片链接（由系统生成）
	private String PicUrl;
	
	//图片消息媒体id，可以调用多媒体文件下载接口拉取数据
	private String MediaId;
	
	public String getPicUrl() {
		System.out.println( "[request][ImageMessage][getPicUrl]" + PicUrl);
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		System.out.println( "[request][ImageMessage][setPicUrl]" + picUrl);
		PicUrl = picUrl;
	}
	public String getMediaId() {
		System.out.println( "[request][ImageMessage][getMediaId]" + MediaId);
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		System.out.println( "[request][ImageMessage][setMediaId]" + MediaId);
		MediaId = mediaId;
	}
	
	@Override
	public String toString() {
		System.out.println( "[request][ImageMessage][toString]");
		return "ImageMessage [PicUrl=" + PicUrl + ", MediaId=" + MediaId + ", toString()=" + super.toString() + "]";
	}		
	
}
