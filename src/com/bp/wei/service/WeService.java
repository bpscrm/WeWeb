package com.bp.wei.service;

import java.util.Map;

public interface WeService {
	public boolean valid(String signature, String timestamp, String nonce);
	
	public String process(Map<String, String> requestMap);
}
