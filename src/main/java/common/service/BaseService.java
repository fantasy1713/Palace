package common.service;

import org.springframework.beans.factory.annotation.Autowired;

import common.generic.GenericDao;

/**
 * Service基类
 * @author ThinkGem
 * @version 2013-01-15
 */
public abstract class BaseService {
	@Autowired
	protected GenericDao genericDao;
	
}
