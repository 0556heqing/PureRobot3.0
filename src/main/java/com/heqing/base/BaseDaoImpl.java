package com.heqing.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import com.heqing.dao.TestDao;
import com.heqing.entities.Test;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	protected Class<T> clazz; 
	protected BaseDao baseDao;
	
	@Resource
	private TestDao testDao;
	
	public BaseDaoImpl() {
		// 通过反射得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class) pt.getActualTypeArguments()[0];
	}
	
	private BaseDao getDao(){
		if(this.clazz.equals(Test.class))  baseDao = testDao;
		return baseDao;
	}

	public void save(T entity) {
		getDao().save(entity);
	}

	public void update(T entity) {
		getDao().update(entity);
	}

	public void delete(Long id) {
		getDao().delete(id);
	}

	public T getById(Long id) {
		return (T)getDao().getById(id);
	}

	public List<T> getByIds(Long[] ids) {
		return getDao().getByIds(ids);
	}

	public List<T> findAll() {
		return getDao().findAll();
	}
	
	public List<T> getPageBean(int pageNum, int pageSize){
		return getDao().getPageBean(pageNum, pageSize);
	}
}
