/**
 * 
 */
package com.bp.wei.model;

/**
 * @author liyanc
 *
 */
public class AccessToken {
	//weixin返回的凭证
	private String token;
	//有效的时间 单位：秒
	private long expiresIn;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public long getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}
	@Override
	public String toString() {
		return "AccessToken [token=" + token + ", expiresIn=" + expiresIn + "]";
	}
	
}
