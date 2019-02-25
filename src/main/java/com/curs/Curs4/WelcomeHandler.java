package com.curs.Curs4;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.*;

@SuppressWarnings("restriction")
public class WelcomeHandler implements HttpHandler {

	public void handle(HttpExchange e) throws IOException {
		String response = "<html><body><h1>Welcome to my app</h1>" + "<form method=\"get\" action=\"/loginPage\">\r\n"
				+ "    <button type=\"submit\">Login</button>\r\n" + "</form>"
				+ "<form method=\"get\" action=\"/registerPage\">\r\n"
				+ "    <button type=\"submit\">Register</button>\r\n" + "</form>" + "</body></html>";

		e.sendResponseHeaders(200, response.length());
		OutputStream os = e.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}
}
