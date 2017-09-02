package com.bp.wei.model.qrcode.request;

public class QRCode {
	//该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
	private int expire_seconds;
	
	//二维码类型，QR_SCENE为临时的整型参数值，QR_STR_SCENE为临时的字符串参数值，QR_LIMIT_SCENE为永久的整型参数值，QR_LIMIT_STR_SCENE为永久的字符串参数值
	private String action_name;
	
	//action_info	二维码详细信息
	private ActionInfo action_info;

	public int getExpire_seconds() {
		return expire_seconds;
	}

	public void setExpire_seconds(int expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

	public String getAction_name() {
		return action_name;
	}

	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}

	public ActionInfo getAction_info() {
		return action_info;
	}

	public void setAction_info(ActionInfo action_info) {
		this.action_info = action_info;
	}

	@Override
	public String toString() {
		return "QRCode [expire_seconds=" + expire_seconds + ", action_name=" + action_name + ", action_info="
				+ action_info + "]";
	}		
	
}
