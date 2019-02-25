package com.curs.Curs4;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.*;

/**
 * Hello world!
 *
 */
public class App {
	@SuppressWarnings("restriction")
	public static void main(String[] args) throws IOException {
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		DbConnection.getInstance();
		server.createContext("/", new WelcomeHandler());
		server.createContext("/login", new LoginHandler());
		server.createContext("/loginPage", new LoginPageHandler());
		server.createContext("/registerPage", new RegisterPageHandler());
		server.createContext("/register", new RegisterHandler());
		server.createContext("/home", new HomeHandler());

		server.setExecutor(null);
		server.start();
		System.out.println("Server started at port 8000");

	}
}
