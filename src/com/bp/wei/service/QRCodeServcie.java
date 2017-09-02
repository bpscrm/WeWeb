package com.bp.wei.service;

import java.util.Map;

import com.bp.wei.model.qrcode.response.QRCodeTicket;

public interface QRCodeServcie {
	QRCodeTicket getTicket(Map<String, String> params);
	
	String getTicketUrl(QRCodeTicket ticket);
}
