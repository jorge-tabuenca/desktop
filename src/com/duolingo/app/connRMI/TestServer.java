package com.duolingo.app.connRMI;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

import com.duolingo.interfaces.ILanguageCourse;
import com.duolingo.interfaces.impl.LanguageCourseImpl;
import com.duolingo.model.LanguageCourse;

import net.sf.lipermi.exception.LipeRMIException;
import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.IServerListener;
import net.sf.lipermi.net.Server;


public class TestServer implements ITestService{

	public TestServer() {
		try {CallHandler callHandler = new CallHandler();
	            callHandler.registerGlobal(ITestService.class, this);
	            Server server = new Server();
	            server.bind(7777, callHandler);
	            server.addServerListener(new IServerListener() {
	                
	                @Override
	                public void clientDisconnected(Socket socket) {
	                    System.out.println("Client Disconnected: " + socket.getInetAddress());
	                }
	                
	                @Override
	                public void clientConnected(Socket socket) {
	                    System.out.println("Client Connected: " + socket.getInetAddress());
	                }
	            });
	            System.out.println("Server Listening");
	        } catch (LipeRMIException | IOException e) {
	            e.printStackTrace();
	        }
	}
	
	@Override
    public String getResponse(int originLang) {
		
		ILanguageCourse languageCourseManager = new LanguageCourseImpl();
		List<LanguageCourse> courses =  languageCourseManager.getAllCourses(1, 0);		
		
		System.out.println(courses.size());

		
        System.out.println("getResponse called");
        return "Resultados: " + courses.size();
    }
	
	public static void main(String[] args) {
        TestServer testServer = new TestServer();

	}

	

}
