package com.bp.wei.model.message.response;
/**
 * 
 * @author liyanc
 * @desc Music response message
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
public class MusicMessage extends BaseMessage {
	private Music music;

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	@Override
	public String toString() {
		return "MusicMessage [music=" + music + ", toString()=" + super.toString() + "]";
	}	
	
}
