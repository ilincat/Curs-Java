package com.curs.Curs4;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

@SuppressWarnings("restriction")
public class RegisterHandler extends BaseHttpHandler {

	public void handle(HttpExchange e) throws IOException {
		Map<String, String> user = stringToMap(readBody(e));
		String response = "";
		if (!DbConnection.exists(user.get("uname"))) {
			DbConnection.addUser(user.get("uname"), user.get("psw"));
			Headers h = e.getResponseHeaders();
			h.set("Location", "/home?name=" + user.get("uname"));
			e.sendResponseHeaders(302, 0);

		} else {
			response = "<html><body><h1>User already exists</h1></body></html>";
			e.sendResponseHeaders(400, response.length());
		}

		OutputStream os = e.getResponseBody();
		os.write(response.getBytes());
		os.close();

	}

}
