package com.bp.wei.model.message.response;
/**
 * 
 * @author liyanc
 * @desc Voice field in Voice response message
 */
public class Voice {
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
		return "Voice [MediaId=" + MediaId + "]";
	}	
	
}
