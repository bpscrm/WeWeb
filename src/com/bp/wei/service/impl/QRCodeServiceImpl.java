package com.bp.wei.service.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bp.wei.model.qrcode.request.ActionInfo;
import com.bp.wei.model.qrcode.request.QRCode;
import com.bp.wei.model.qrcode.request.Scene;
import com.bp.wei.model.qrcode.response.QRCodeTicket;
import com.bp.wei.service.QRCodeServcie;
import com.bp.wei.util.WeUtil;

@Service
public class QRCodeServiceImpl implements QRCodeServcie {
	
	public static Logger log = LoggerFactory.getLogger(QRCodeServiceImpl.class);

	@Override
	public QRCodeTicket getTicket(Map<String, String> params) {
		if(params == null || params.isEmpty()){
			log.error("Empty params for QR Code Preparation.");
			return null;
		}
		Iterator<?> itr = params.keySet().iterator();
		QRCode qrCode = new QRCode();
		ActionInfo actInfo = new ActionInfo();
		Scene scene = new Scene();
		
		while(itr.hasNext()){
			
			String key = itr.next().toString();
			String value = params.get(key);
			if(value == null || value.length() == 0){
				log.error("Illegal value of " + key + ":" + value);
				qrCode = null;
				break;
			}
			switch(key){
				case "action_name":
					qrCode.setAction_name(value);
					if(!value.contains("LIMIT")){
						qrCode.setExpire_seconds(2592000);
					}
					break;
				case "scene_id":
					scene.setScene_id(Integer.parseInt(value));					
					break;
				case "scene_str":
					scene.setScene_str(value);
					break;
				default:
			}			
		}
		actInfo.setScene(scene);
		qrCode.setAction_info(actInfo);
		
		QRCodeTicket ticket = WeUtil.createQRCodeTicket(qrCode);
		return ticket;
	}

	@Override
	public String getTicketUrl(QRCodeTicket ticket) {
		if(ticket == null || ticket.getTicket() == null){
			log.error("Invalid ticket.");
			return null;
		}
		String showUrl = WeUtil.showQRCode(ticket);
		return showUrl;
	}

}
