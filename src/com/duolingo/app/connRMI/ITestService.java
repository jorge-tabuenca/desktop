package com.duolingo.app.connRMI;

import java.util.ArrayList;
import java.util.List;
import com.duolingo.model.LanguageCourse;


public interface ITestService {
	
    public ArrayList<String> getResponse(short originLang);


}
