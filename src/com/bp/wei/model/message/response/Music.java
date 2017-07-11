package com.bp.wei.model.message.response;
/**
 * 
 * @author liyanc
 * @desc Music field in Musical response message
 * <xml>
	<ToUserName><![CDATA[toUser]]></ToUserName>
	<FromUserName><![CDATA[fromUser]]></FromUserName>
	<CreateTime>12345678</CreateTime>
	<MsgType><![CDATA[music]]></MsgType>
	<Music>
	<Title><![CDATA[TITLE]]></Title>
	<Description><![CDATA[DESCRIPTION]]></Description>
	<MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
	<HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>
	<ThumbMediaId><![CDATA[media_id]]></ThumbMediaId>
	</Music>
	</xml>
 */
public class Music {
	//音乐标题
	private String Title;
	
	//音乐描述
	private String Description;
	
	//音乐链接
	private String MusicURL;
	
	//高质量音乐链接，WIFI环境优先使用该链接播放音乐
	//Not Mandatory
	private String HQMusicUrl;
	
	//缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
	private String ThumbMediaId;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getMusicURL() {
		return MusicURL;
	}

	public void setMusicURL(String musicURL) {
		MusicURL = musicURL;
	}

	public String getHQMusicUrl() {
		return HQMusicUrl;
	}

	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

	@Override
	public String toString() {
		return "Music [Title=" + Title + ", Description=" + Description + ", MusicURL=" + MusicURL + ", HQMusicUrl="
				+ HQMusicUrl + ", ThumbMediaId=" + ThumbMediaId + "]";
	}
	
}
