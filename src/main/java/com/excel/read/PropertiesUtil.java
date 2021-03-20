package com.excel.read;

import java.util.Locale;
import java.util.ResourceBundle;

public class PropertiesUtil {

	private  ResourceBundle objProp;
	private  ResourceBundle configProp;
	private  ResourceBundle userProp;
	private  ResourceBundle stringProp;
	//private  final Logger logger = LogManager.getLogger(PropertiesUtil.class);
	
	public PropertiesUtil(String fileName)
	{
			
//			configProp = ResourceBundle.getBundle(fileName);
//			String localeValue = configProp.getString(LOCALE);
//			//logger.info("Locale Value from configuration file:"+fileName+"is:"+localeValue);
//			Locale localObj = getLocaleObject(localeValue);
//			objProp = ResourceBundle.getBundle(FILENAME_OBJECT,localObj);
//			userProp = ResourceBundle.getBundle(FILENAME_USER,localObj);
//			stringProp = ResourceBundle.getBundle(FILENAME_STRINGS,localObj);
	}
	


	private static Locale getLocaleObject(String localeValue)
	{
		String[] localeArr = localeValue.split("_");
		if(localeArr.length==1)
		{
			return Locale.forLanguageTag(localeValue);
		}else
		{
			String locale = localeArr[0]+"-"+localeArr[1];
			return Locale.forLanguageTag(locale);
		}
	}
	public String getObjectPropertyValue(String propKey)
	{
		String value = objProp.getString(propKey);
		if(value!=null && !value.equalsIgnoreCase(""))
		{
			value = value.trim();
		}
		return value;
	}
	
	public String getConfigPropertyValue(String propKey)
	{
		String value = configProp.getString(propKey);
		if(value!=null && !value.equalsIgnoreCase(""))
		{
			value = value.trim();
		}
		//logger.info("Configuration "+propKey+" :"+value);
		return value;
	}
	

	public String getUserPropertyValue(String propKey)
	{
		String value = userProp.getString(propKey);
		if(value!=null && !value.equalsIgnoreCase(""))
		{
			value = value.trim();
		}
		//logger.info("User "+propKey+" :"+value);
		return value;
	}
	
	public String getStringPropertyValue(String propKey)
	{
		String value = stringProp.getString(propKey);
		if(value!=null && !value.equalsIgnoreCase(""))
		{
			value = value.trim();
		}
		return value;
	}
}
