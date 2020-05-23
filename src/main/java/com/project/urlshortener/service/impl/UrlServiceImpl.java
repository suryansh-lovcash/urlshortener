package com.project.urlshortener.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.urlshortener.entity.Url;
import com.project.urlshortener.model.UrlModel;
import com.project.urlshortener.repository.UrlRepository;
import com.project.urlshortener.service.UrlService;
import com.project.urlshortener.utilities.UrlEncoder;

@Service
public class UrlServiceImpl implements UrlService{

	@Autowired
	UrlRepository urlRepository;
	
	@Autowired
	UrlEncoder urlEncoder;
	
	@Override
	public String getTinyUrl(UrlModel model) {
		Long count = urlRepository.count();
		String tinyUrl = urlEncoder.encode(count);
		tinyUrl = model.getDomain() + "/" + tinyUrl;
		
		Url url = new Url();
		url.setTinyUrl(tinyUrl);
		url.setUrl(model.getUrl());
		url.setCreatedAt(new Date());
		urlRepository.save(url);
		return url.getTinyUrl();
	}

	@Override
	public String getOriginalUrl(String tinyUrl) {
		Url url = urlRepository.getFromTinyUrl(tinyUrl);
		return url != null ? url.getUrl() : "" ;
	}

}
