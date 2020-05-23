package com.project.urlshortener.service;

import com.project.urlshortener.model.UrlModel;

public interface UrlService {

	String getTinyUrl(UrlModel url);
	String getOriginalUrl(String tinyUrl);
}
