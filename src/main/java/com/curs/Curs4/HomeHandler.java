package com.curs.Curs4;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;

@SuppressWarnings("restriction")
public class HomeHandler extends BaseHttpHandler {

	public void handle(HttpExchange e) throws IOException {

		String name = stringToMap(e.getRequestURI().getQuery()).get("name");
		String response = "<html><body><h1>Hello, " + name + "</h1>" + "</body></html>";

		e.sendResponseHeaders(200, response.length());
		OutputStream os = e.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}

}
