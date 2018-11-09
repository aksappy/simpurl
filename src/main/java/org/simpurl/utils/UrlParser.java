package org.simpurl.utils;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlParser {

	public static String getHost(String url) {
		URL _url = null;
		try {
			_url = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null != _url ? _url.getHost() : null;
	}

	public static String getProtocol(String url) {
		URL _url = null;
		try {
			_url = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null != _url ? _url.getProtocol() : null;
	}
}
