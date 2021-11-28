package com.qa.tempInterface;

import com.qa.restAPI.APIGetTemp;
import com.qa.ui.pages.SearchPage;
import com.qa.ui.pages.SearchResultPage;

public interface TemparatureInterface {
	
	/**
	 * returns the temperature in degree celsius for the provided city
	 * returns -1 if error occurs
	 * @param city
	 * @return
	 */
	float getTemperature (String city);
	
	

}
