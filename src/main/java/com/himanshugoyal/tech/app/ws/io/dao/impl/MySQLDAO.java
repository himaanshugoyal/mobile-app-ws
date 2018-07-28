/**
 * 
 */
package com.himanshugoyal.tech.app.ws.io.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;

import com.himanshugoyal.tech.app.ws.io.dao.DAO;
import com.himanshugoyal.tech.app.ws.io.entity.UserEntity;
import com.himanshugoyal.tech.app.ws.shared.dto.UserDTO;
import com.himanshugoyal.tech.app.ws.utils.HibernateUtils;

/**
 * @author himanshugoyal
 *
 */
public class MySQLDAO implements DAO {

	Session session;
	
	public void openConnection() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		sessionFactory.openSession();
	}

	public UserDTO getUserByUserName(String userName) {
		UserDTO userDto = null;
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
	    //Create Criteria against a particular persistent class
		CriteriaQuery<UserEntity> criteria = cb.createQuery(UserEntity.class);
		
		//Query root always reference entity
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
		if(session != null)
		{
			session.clear();
		}
		
	}

}
