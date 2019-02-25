package com.curs.Curs4;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@SuppressWarnings("restriction")
public class RegisterPageHandler implements HttpHandler {

	public void handle(HttpExchange e) throws IOException {
		String response = "<html><body><h1>Register</h1>" + "<form method=\"post\" action=\"/register\">\r\n"
				+ "        <label for=\"uname\"><b>Username</b></label>\r\n"
				+ "    <input type=\"text\" placeholder=\"Enter Username\" name=\"uname\" required>\r\n" + "\r\n"
				+ "    <label for=\"psw\"><b>Password</b></label>\r\n"
				+ "    <input type=\"password\" placeholder=\"Enter Password\" name=\"psw\" required>" + "\r\n"
				+ "    <button type=\"submit\">Register</button>" + "</form>" + "</body></html>";

		e.sendResponseHeaders(200, response.length());
		OutputStream os = e.getResponseBody();
		os.write(response.getBytes());
		os.close();

	}
}