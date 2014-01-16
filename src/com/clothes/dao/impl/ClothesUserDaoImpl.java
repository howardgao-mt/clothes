package com.clothes.dao.impl;
	import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.clothes.dao.ClothesUserDao;
import com.clothes.model.ClothesUser;
public class ClothesUserDaoImpl extends HibernateDaoSupport implements ClothesUserDao{

	public void saveClothesUser(ClothesUser clothesUser) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(clothesUser);	
	}

	public void updateClothesUser(ClothesUser clothesUser) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(clothesUser);			
	}

	public void deleteClothesUser(ClothesUser clothesUser) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(clothesUser);			
	}

	public List<ClothesUser> getAllClothesUser() {
		// TODO Auto-generated method stub
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesUser.class);
		return criteria.list();
	}
//對應帳號的回傳
	public List<ClothesUser> getClothesUserByAccount(String userAccount) {
		// TODO Auto-generated method stub
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesUser.class);
		if (userAccount != null && !"".equals(userAccount)) {
			criteria.add(Restrictions.eq("userAccount", userAccount));
		}
		return criteria.list();
	}

	public List<ClothesUser> getClothesUserById(int userId) {
		// TODO Auto-generated method stub
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesUser.class);
		if (userId != 0) {
			criteria.add(Restrictions.eq("userId", userId));
		}
		return criteria.list();
	}

	public List<ClothesUser> getClothesUserByEmail(String email) {
		// TODO Auto-generated method stub
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesUser.class);
		if (email != null && !"".equals(email)) {
			criteria.add(Restrictions.eq("userEmail", email));
		}
		return criteria.list();
	}
	
}
