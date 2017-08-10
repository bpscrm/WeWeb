package com.bp.wei.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
import com.bp.wei.service.impl.X509TrustManagerImpl;
import net.sf.json.JSONObject;

public class WeUtil {
	//public final static String APPID = "wx4eabcc7676fe35b1";
	//cloud
	//public final static String APPID = "wx50c7fecf06ffdd0b";
  //temporary mask off 
	//public static String APPID = "wxf2c80bfa2eabeb26";
	public static String APPID;
	//public final static String APPSECRET = "6c763da4f3c974415308bb30c1f94b6e";
	//cloud
	//public final static String APPSECRET = "69cb967254a95951ca67dcc665fcb190";
  //temporary mask off
	//public static String APPSECRET = "dfebc70ad709363133e63be774e0c84b";
	public static String APPSECRET;
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	private static final String CONFIG_FILENAME = "c:\\10\\config.txt";
	
	private static Logger log = LoggerFactory.getLogger(WeUtil.class);
	
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {  
        JSONObject jsonObject = null;  
        StringBuffer buffer = new StringBuffer();  
        System.out.println( "[util][WeUtil][httpRequest]");
        try {  
            // 鍒涘缓SSLContext瀵硅薄锛屽苟浣跨敤鎴戜滑鎸囧畾鐨勪俊浠荤鐞嗗櫒鍒濆鍖�  
            TrustManager[] tm = { new X509TrustManagerImpl() };  
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");  
            sslContext.init(null, tm, new java.security.SecureRandom());  
            // 浠庝笂杩癝SLContext瀵硅薄涓緱鍒癝SLSocketFactory瀵硅薄  
            SSLSocketFactory ssf = sslContext.getSocketFactory();  
  
            URL url = new URL(requestUrl);  
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();  
            httpUrlConn.setSSLSocketFactory(ssf);  
  
            httpUrlConn.setDoOutput(true);  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setUseCaches(false);  
            // 璁剧疆璇锋眰鏂瑰紡锛圙ET/POST锛�  
            httpUrlConn.setRequestMethod(requestMethod);  
  
            if ("GET".equalsIgnoreCase(requestMethod))  
                httpUrlConn.connect();  
  
            // 褰撴湁鏁版嵁闇�瑕佹彁浜ゆ椂  
            if (null != outputStr) {  
                OutputStream outputStream = httpUrlConn.getOutputStream();  
                // 娉ㄦ剰缂栫爜鏍煎紡锛岄槻姝腑鏂囦贡鐮�  
                outputStream.write(outputStr.getBytes("UTF-8"));  
                outputStream.close();  
            }  
  
            // 灏嗚繑鍥炵殑杈撳叆娴佽浆鎹㈡垚瀛楃涓�  
            InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            bufferedReader.close();  
            inputStreamReader.close();  
            // 閲婃斁璧勬簮  
            inputStream.close();  
            inputStream = null;  
            httpUrlConn.disconnect();  
            jsonObject = JSONObject.fromObject(buffer.toString());  
        } catch (ConnectException ce) {  
            //log.error("Weixin server connection timed out.");  
        } catch (Exception e) {  
           // log.error("https request error:{}", e);  
        }  
        return jsonObject;  
    }  

	/** 
	 * 鑾峰彇access_token 
	 *  
	 * @param appid 鍑瘉 
	 * @param appsecret 瀵嗛挜 
	 * @return 
	 */  
	public static AccessToken getAccessToken() {  
	    AccessToken accessToken = null;  
	  
	  	//Read config.txt file
	  	FileReader fr = null;
			BufferedReader br = null;
			String ws_whole_string="";
			try 
			{
				fr = new FileReader(CONFIG_FILENAME);
				br = new BufferedReader(fr);

				String sCurrentLine;

				br = new BufferedReader(new FileReader(CONFIG_FILENAME));

				while ((sCurrentLine = br.readLine()) != null) 
				{
					//log.error(sCurrentLine);
					char[] array = sCurrentLine.toCharArray();
    			for(int i = 0; i < array.length; i++)
    			{
        		if(array[i] == '=')
        		{
            	//System.out.println(i);
            	if (sCurrentLine.substring(0,i).equals("APPID"))
            	{
            			APPID = sCurrentLine.substring(i+1, array.length);
            			//System.out.println("APPID "+sCurrentLine.substring(i+1, array.length));	
            	}	
            	if (sCurrentLine.substring(0,i).equals("APPSECRET"))
            	{
            			APPSECRET = sCurrentLine.substring(i+1, array.length);
            			//System.out.println("APPSECRET "+sCurrentLine.substring(i+1, array.length));	
            	}	
        		}   
    			}	
					ws_whole_string+=sCurrentLine;
				}

			} 
			catch (IOException e) 
			{

				e.printStackTrace();

			}
			finally
			{

				try 
				{

					if (br != null)
						br.close();

					if (fr != null)
						fr.close();

				} 
				catch (IOException ex) 
				{
					ex.printStackTrace();

				}
			}
	  
	    System.out.println( "[util][WeUtil][getAccessToken]");
	    String requestUrl = access_token_url.replace("APPID", APPID).replace("APPSECRET", APPSECRET);  
			//System.out.println( "[util][WeUtil][getAccessToken]requestUrl "+requestUrl);
	    JSONObject jsonObject = httpRequest(requestUrl, "GET", null);  
	    // 濡傛灉璇锋眰鎴愬姛  
	    if (null != jsonObject) {  
	        try {  
	            accessToken = new AccessToken();  
	            accessToken.setToken(jsonObject.getString("access_token"));  
	            accessToken.setExpiresIn(jsonObject.getInt("expires_in"));  
	        } catch (Exception e) {  
	            accessToken = null;  
	            // 鑾峰彇token澶辫触  
	            log.error("Get accessToken failed - errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));  
	        }  
	    }  
	    
	    System.out.println( "[util][WeUtil][getAccessToken]value " + accessToken);
	    return accessToken;  
	}  
}
