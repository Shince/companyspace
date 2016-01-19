package com.lovematch.match.service;

public interface BaseService<T> {
	T find(Long id);
	T create(T entity);
	T update(T entity);
	void delete(Long id);
}
