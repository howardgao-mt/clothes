package com.clothes.dao.impl;
	import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.clothes.dao.ClothesCheckDao;
import com.clothes.model.ClothesCheck;
public class ClothesCheckDaoImpl extends HibernateDaoSupport implements ClothesCheckDao{

	public void saveClothesCheck(ClothesCheck clothesCheck) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(clothesCheck);
	}

	public void updateClothesCheck(ClothesCheck clothesCheck) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(clothesCheck);
	}

	public void deleteClothesCheck(ClothesCheck clothesCheck) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(clothesCheck);		
	}

	public ClothesCheck getClothesCheckById(int checkId) {
		// TODO Auto-generated method stub
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesCheck.class);
		criteria.setFetchMode("checkId", FetchMode.JOIN);
		if(checkId != 0) {
			criteria.add(Restrictions.eq("checkId", checkId));
		}
		List<ClothesCheck> list = criteria.list();
		if(list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}
	}
	public List<ClothesCheck> getAllClothesCheck(int checkStatus) {
		// TODO Auto-generated method stub
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesCheck.class);
		criteria.setFetchMode("checkStatus", FetchMode.JOIN);
		if(checkStatus != 0) {
			criteria.add(Restrictions.eq("checkStatus", checkStatus));
		}
		return criteria.list();		
	}

	public List<ClothesCheck> getAllClothesCheck() {
		// TODO Auto-generated method stub
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesCheck.class);
		return criteria.list();
	}
}
		
