package com.vaibhav.googleTranslate;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Writer;
import java.net.URLEncoder;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	public void homePage() throws Exception {
		
		InputStream is = new FileInputStream("/Users/vaibhav/Documents/everyday/messages_en.properties");
		Writer writer = new BufferedWriter(new FileWriter("/Users/vaibhav/Documents/everyday/messages_es.properties"));
		Properties props = new Properties();
		props.load(is);
		is.close();
		Set<Entry<Object, Object>> entrySet = props.entrySet();
		for(Entry<Object, Object> entry : entrySet){
			String key = String.valueOf(entry.getKey());
			String value = String.valueOf(entry.getValue());
			if(value == null || value.length() == 0 || URLEncoder.encode(value, "UTF-8").length() == 0){
				System.out.println(key);
			}
			else{
				String translatedValue = Translate.translate(URLEncoder.encode(value, "UTF-8"), "en", "es");
				writer.write(key + "="+ translatedValue + "\n");
			}
			
		}
		writer.flush();
	    writer.close();
	}
	
	public void simpleTranslation() throws Exception{
		Translate.translate("Vaibhav Gupta is a good boy, He is 26 years old", "en", "es");
	}
}
