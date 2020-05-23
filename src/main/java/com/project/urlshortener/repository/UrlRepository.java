package com.project.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.urlshortener.entity.Url;

public interface UrlRepository extends JpaRepository<Url, Long>{

	@Query("select u from Url u where u.tinyUrl=?1")
	Url getFromTinyUrl(String tinyUrl);
}
