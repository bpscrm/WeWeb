package com.bp.wei.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bp.wei.model.AccessToken;
import com.bp.wei.model.Oauth2AccessToken;
import com.bp.wei.model.qrcode.request.QRCode;
import com.bp.wei.model.qrcode.response.QRCodeTicket;
import com.bp.wei.service.impl.X509TrustManagerImpl;
import net.sf.json.JSONObject;

public class WeUtil {
	public final static String APPID = "wx4eabcc7676fe35b1";
	public final static String APPSECRET = "6c763da4f3c974415308bb30c1f94b6e";
//	public final static String APPID = "wx50c7fecf06ffdd0b";
//	public final static String APPSECRET = "69cb967254a95951ca67dcc665fcb190";
	
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	public final static String oauth_access_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	public final static String oauth_url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	public final static String qrcode_create_url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";
	public final static String qrcode_show_url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
	
	public final static String redirect_url = "http://www.wecarecrm.com//EnglishCenterZHH/oauth";
	
	private static Logger log = LoggerFactory.getLogger(WeUtil.class);
	
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {  
        JSONObject jsonObject = null;  
        StringBuffer buffer = new StringBuffer();  
        try {  
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化  
            TrustManager[] tm = { new X509TrustManagerImpl() };  
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");  
            sslContext.init(null, tm, new java.security.SecureRandom());  
            // 从上述SSLContext对象中得到SSLSocketFactory对象  
            SSLSocketFactory ssf = sslContext.getSocketFactory();  
  
            URL url = new URL(requestUrl);  
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();  
            httpUrlConn.setSSLSocketFactory(ssf);  
  
            httpUrlConn.setDoOutput(true);  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setUseCaches(false);  
            // 设置请求方式（GET/POST）  
            httpUrlConn.setRequestMethod(requestMethod);  
  
            if ("GET".equalsIgnoreCase(requestMethod) || "POST".equalsIgnoreCase(requestMethod)){  
                httpUrlConn.connect();  
            }
            // 当有数据需要提交时  
            if (null != outputStr) {  
                OutputStream outputStream = httpUrlConn.getOutputStream();  
                // 注意编码格式，防止中文乱码  
                outputStream.write(outputStr.getBytes("UTF-8"));  
                outputStream.close();  
            }  
  
            // 将返回的输入流转换成字符串  
            InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            bufferedReader.close();  
            inputStreamReader.close();  
            // 释放资源  
            inputStream.close();  
            inputStream = null;  
            httpUrlConn.disconnect();  
            jsonObject = JSONObject.fromObject(buffer.toString());  
        } catch (ConnectException ce) {  
            log.error("Wechat server connection timed out.");  
        } catch (Exception e) {  
            log.error("https request error:{}", e);  
        }  
        return jsonObject;  
    }  

	/** 
	 * 获取access_token 
	 *  
	 * @param appid 凭证 
	 * @param appsecret 密钥 
	 * @return 
	 */  
	public static synchronized AccessToken getAccessToken() {  
	    AccessToken accessToken = null;  
	  
	    String requestUrl = access_token_url.replace("APPID", APPID).replace("APPSECRET", APPSECRET);  
	    JSONObject jsonObject = httpRequest(requestUrl, "GET", null);  
	    // 如果请求成功  
	    if (null != jsonObject) {  
	    	long now = System.currentTimeMillis();
	        try {  
	            accessToken = new AccessToken();  
	            accessToken.setToken(jsonObject.getString("access_token")); 
	            int expiredIn = jsonObject.getInt("expires_in");
	            accessToken.setExpiresIn(now + expiredIn*1000);  
	        } catch (Exception e) {  
	            accessToken = null;  
	            // 获取token失败  
	            log.error("Get accessToken failed - errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));  
	        }  
	    }  
	    return accessToken;  
	}  
	
	public static Oauth2AccessToken getOauth2AccessToken(String code){
		Oauth2AccessToken accessToken = null;
		String requestUrl = oauth_access_token_url.replace("APPID", APPID).replace("SECRET", APPSECRET).replace("CODE", code);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);  
		// 如果请求成功  
	    if (null != jsonObject) {  
	        try {
	        	accessToken = new Oauth2AccessToken();
	        	accessToken.setAccessToken(jsonObject.getString("access_token"));  
	            accessToken.setExpiresIn(jsonObject.getInt("expires_in")); 
	            accessToken.setRefreshToken(jsonObject.getString("refresh_token"));
	            accessToken.setOpenId(jsonObject.getString("openid"));
	            accessToken.setScope(jsonObject.getString("scope"));
	        }catch (Exception e) {  
	            accessToken = null;  
	            // 获取token失败  
	            log.error("Get Oauth2AccessToken failed - errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));  
	        }  
	    }  
	    log.debug("Get Oauth2AccessToken: " + accessToken.toString());
	    return accessToken;
	}	
	
	public static String getRedirectUrl(){
		String url = oauth_url.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		url = url.replace("SCOPE", "snsapi_userinfo");
		url = url.replace("STATE", "2001");
		return url;
	}
	
	public static QRCodeTicket createQRCodeTicket(QRCode code){
		AccessToken token = ConfigUtil.getCachedAccessToken();
		if(token == null || token.getToken() == null){
			log.error("Failed to get the access token");
			return null;
		}
		QRCodeTicket ticket = null;
		String requestUrl = qrcode_create_url.replace("TOKEN", token.getToken());
		JSONObject postData = JSONObject.fromObject(code);
		JSONObject jsonObject = httpRequest(requestUrl, "POST", postData.toString());
		
		if(jsonObject != null){
			 ticket = (QRCodeTicket) JSONObject.toBean(jsonObject, QRCodeTicket.class);
		}
		return ticket;
	}
	
	public static String showQRCode(QRCodeTicket ticket){
		return qrcode_show_url.replace("TICKET", ticket.getTicket());
	}

}
