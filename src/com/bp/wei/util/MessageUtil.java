package com.bp.wei.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bp.wei.model.message.response.ImageMessage;
import com.bp.wei.model.message.response.TextMessage;
import com.bp.wei.model.message.response.VideoMessage;
import com.bp.wei.model.message.response.VoiceMessage;
import com.bp.wei.model.message.response.Article;
import com.bp.wei.model.message.response.MusicMessage;
import com.bp.wei.model.message.response.NewsMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * 
 * @author liyanc
 * @desc Utility regarding to WeChat messages
 */

public class MessageUtil {
	
	// 请求消息类型：文本
    public static final String REQ_MESSAGE_TYPE_TEXT = "TEXT";
    // 请求消息类型：图片
    public static final String REQ_MESSAGE_TYPE_IMAGE = "IMAGE";
    // 请求消息类型：语音
    public static final String REQ_MESSAGE_TYPE_VOICE = "VOICE";
    // 请求消息类型：视频
    public static final String REQ_MESSAGE_TYPE_VIDEO = "VIDEO";
    // 请求消息类型：小视频
    public static final String REQ_MESSAGE_TYPE_SHORTVIDEO = "SHORTVIDEO";
    // 请求消息类型：地理位置
    public static final String REQ_MESSAGE_TYPE_LOCATION = "LOCATION";
    // 请求消息类型：链接
    public static final String REQ_MESSAGE_TYPE_LINK = "LINK";

    // 请求消息类型：事件推送
    public static final String REQ_MESSAGE_TYPE_EVENT = "EVENT";
    
 // 事件类型：subscribe(订阅)
    public static final String EVENT_TYPE_SUBSCRIBE = "SUBSCRIBE";
    // 事件类型：unsubscribe(取消订阅)
    public static final String EVENT_TYPE_UNSUBSCRIBE = "UNSUBSCRIBE";
    // 事件类型：scan(用户已关注时的扫描带参数二维码)
    public static final String EVENT_TYPE_SCAN = "SCAN";
    // 事件类型：LOCATION(上报地理位置)
    public static final String EVENT_TYPE_LOCATION = "LOCATION";
    // 事件类型：CLICK(自定义菜单)
    public static final String EVENT_TYPE_CLICK = "CLICK";
    // 事件类型：VIEW(自定义菜单点击跳转)
    public static final String EVENT_TYPE_VIEW = "VIEW";

    // 响应消息类型：文本
    public static final String RESP_MESSAGE_TYPE_TEXT = "TEXT";
    // 响应消息类型：图片
    public static final String RESP_MESSAGE_TYPE_IMAGE = "IMAGE";
    // 响应消息类型：语音
    public static final String RESP_MESSAGE_TYPE_VOICE = "VOICE";
    // 响应消息类型：视频
    public static final String RESP_MESSAGE_TYPE_VIDEO = "VIDEO";
    // 响应消息类型：音乐
    public static final String RESP_MESSAGE_TYPE_MUSIC = "MUSIC";
    // 响应消息类型：图文
    public static final String RESP_MESSAGE_TYPE_ARTICLE = "ARTICLE";
	
	public static Logger log = LoggerFactory.getLogger(MessageUtil.class);
	
	@SuppressWarnings("unchecked")
	public static Map<String,String> parseXML(HttpServletRequest request) throws IOException, DocumentException{
		
		Map<String, String> map = new HashMap<String, String>();
		
		InputStream inputStream = request.getInputStream();
		SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        Element root = document.getRootElement();
        List<Element> elementList = root.elements();
        
        for (Element e : elementList)
            map.put(e.getName(), e.getText());
        
        inputStream.close();
        inputStream = null;
        
		return map;
	}
	
	/**
	 * To support CDATA
	 */
	private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // Add CDATA tag
                boolean cdata = true;

                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });
	
	/**
     * 文本消息对象转换成xml
     * 
     * @param textMessage 文本消息对象
     * @return xml
     */
    public static String messageToXml(TextMessage textMessage) {
        xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);
    }

    /**
     * 图片消息对象转换成xml
     * 
     * @param imageMessage 图片消息对象
     * @return xml
     */
    public static String messageToXml(ImageMessage imageMessage) {
        xstream.alias("xml", imageMessage.getClass());
        return xstream.toXML(imageMessage);
    }

    /**
     * 语音消息对象转换成xml
     * 
     * @param voiceMessage 语音消息对象
     * @return xml
     */
    public static String messageToXml(VoiceMessage voiceMessage) {
        xstream.alias("xml", voiceMessage.getClass());
        return xstream.toXML(voiceMessage);
    }

    /**
     * 视频消息对象转换成xml
     * 
     * @param videoMessage 视频消息对象
     * @return xml
     */
    public static String messageToXml(VideoMessage videoMessage) {
        xstream.alias("xml", videoMessage.getClass());
        return xstream.toXML(videoMessage);
    }

    /**
     * 音乐消息对象转换成xml
     * 
     * @param musicMessage 音乐消息对象
     * @return xml
     */
    public static String messageToXml(MusicMessage musicMessage) {
        xstream.alias("xml", musicMessage.getClass());
        return xstream.toXML(musicMessage);
    }

    /**
     * 图文消息对象转换成xml
     * 
     * @param newsMessage 图文消息对象
     * @return xml
     */
    public static String messageToXml(NewsMessage newsMessage) {
        xstream.alias("xml", newsMessage.getClass());
        xstream.alias("item", new Article().getClass());
        return xstream.toXML(newsMessage);
    }
}
