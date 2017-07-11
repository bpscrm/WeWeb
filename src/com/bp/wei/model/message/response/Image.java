package com.bp.wei.model.message.response;
/**
 * 
 * @author liyanc
 * @desc Image field in Image response message
 */
public class Image {
	//媒体文件id
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	@Override
	public String toString() {
		return "Image [MediaId=" + MediaId + "]";
	}	
	
}
