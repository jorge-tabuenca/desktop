package com.duolingo.app.connRMI;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.duolingo.interfaces.ICourse;
import com.duolingo.interfaces.ILanguageCourse;
import com.duolingo.interfaces.impl.CourseImpl;
import com.duolingo.interfaces.impl.LanguageCourseImpl;
import com.duolingo.model.Course;
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
    public ArrayList<String> getResponse(short originLang) {
		
		ArrayList<String> arrayCourses = new ArrayList<>();
		
		ILanguageCourse languageCourseManager = new LanguageCourseImpl();
		List<LanguageCourse> languageCourse =  languageCourseManager.getAllCourses((short)1, (short)0);		
		
		ICourse courseManager = new CourseImpl();
		List<Course> course = courseManager.getAllCourses(); 
				
		arrayCourses.add("CURSOS DISPONIBLES...");
		for (Course c : course) {
			for (LanguageCourse lc : languageCourse) {
				if (c.getId() == lc.getCourse_ID()) {
					arrayCourses.add(c.getName());		
				}
			}
		}

		
        System.out.println("DONE");
        return arrayCourses;
    }
	
	public static void main(String[] args) {
        TestServer testServer = new TestServer();

	}

	

}
