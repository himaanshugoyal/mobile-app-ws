/**
 * 
 */
package com.himanshugoyal.tech.app.ws.io.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;

import com.himanshugoyal.tech.app.ws.io.dao.DAO;
import com.himanshugoyal.tech.app.ws.io.entity.UserEntity;
import com.himanshugoyal.tech.app.ws.shared.dto.UserDTO;

/**
 * @author himanshugoyal
 *
 */
public class MySQLDAO implements DAO {

	Session session;
	
	public void openConnection() {
		// TODO Auto-generated method stub
		
	}

	public UserDTO getUserByUserName(String userName) {
		UserDTO userDto = null;
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
	    //CriteriaQuery<T>teria against a particualr persistent class
		CriteriaQuery<UserEntity> criteria = cb.createQuery(UserEntity.class);
		
		//Query root always reference entitiy
		Root<UserEntity> profileRoot = criteria.from(UserEntity.class);
		criteria.select(profileRoot);
		criteria.where(cb.equal(profileRoot.get("email"), userName));
		
		//Fetch single result
		Query<UserEntity> query = session.createQuery(criteria);
		List<UserEntity> resultList = query.getResultList();
		if(resultList!=null && resultList.size() > 0)
		{
			UserEntity userEntity = resultList.get(0);
			userDto = new UserDTO();
			BeanUtils.copyProperties(userEntity, userDto);
		}
		return userDto;
	}

	public void closeConnection() {
		// TODO Auto-generated method stub
		
	}

}
