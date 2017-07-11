package com.bp.wei.model.message.event;
/**
 * 
 * @author liyanc
 * @desc Location event
 * <xml>
	<ToUserName><![CDATA[toUser]]></ToUserName>
	<FromUserName><![CDATA[fromUser]]></FromUserName>
	<CreateTime>123456789</CreateTime>
	<MsgType><![CDATA[event]]></MsgType>
	<Event><![CDATA[LOCATION]]></Event>
	<Latitude>23.137466</Latitude>
	<Longitude>113.352425</Longitude>
	<Precision>119.385040</Precision>
   </xml>
 * 
 */
public class LocationEvent extends BaseEvent {
	// 地理位置纬度
    private String Latitude;
    
    // 地理位置经度
    private String Longitude;
    
    // 地理位置精度
    private String Precision;

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getPrecision() {
		return Precision;
	}

	public void setPrecision(String precision) {
		Precision = precision;
	}

	@Override
	public String toString() {
		return "LocationEvent [Latitude=" + Latitude + ", Longitude=" + Longitude + ", Precision=" + Precision
				+ ", toString()=" + super.toString() + "]";
	}    
    
}
