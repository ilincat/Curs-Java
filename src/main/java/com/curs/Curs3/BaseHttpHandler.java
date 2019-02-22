package com.curs.Curs3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
@SuppressWarnings("restriction")
public abstract class BaseHttpHandler implements HttpHandler{
	public abstract void handle(HttpExchange e) throws IOException;
	
	public String readBody(HttpExchange t) {
		InputStreamReader isr;
		StringBuilder buf = new StringBuilder(512);
		try {
			isr = new InputStreamReader(t.getRequestBody(),"utf-8");
			BufferedReader br = new BufferedReader(isr);
			int b;

			while ((b = br.read()) != -1) {
			    buf.append((char) b);
			}

			br.close();
			isr.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buf.toString();
	}
	
	public Map<String, String> stringToMap(String s){
		   Map<String, String> result = new HashMap<String,String>();
		    for (String param : s.split("&")) {
		        String[] entry = param.split("=");
		        if (entry.length > 1) {
		            result.put(entry[0], entry[1]);
		        }else{
		            result.put(entry[0], "");
		        }
		    }
		    return result;
	}
}
