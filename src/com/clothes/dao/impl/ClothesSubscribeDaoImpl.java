package com.clothes.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.clothes.dao.ClothesSubscribeDao;
import com.clothes.model.ClothesSubscribe;
import com.clothes.model.ClothesSubscribe;
import com.clothes.model.ClothesUser;

public class ClothesSubscribeDaoImpl extends HibernateDaoSupport implements ClothesSubscribeDao{

	public void saveClothesSubscribe(ClothesSubscribe clothesSubscribe) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(clothesSubscribe);
	}

	public void updateClothesSubscribe(ClothesSubscribe clothesSubscribe) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(clothesSubscribe);
	}

	public void deleteClothesSubscribe(ClothesSubscribe clothesSubscribe) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(clothesSubscribe);
	}

	public List<ClothesSubscribe> getAllClothesSubscribe() {
		// TODO Auto-generated method stub
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesSubscribe.class);
		criteria.setFetchMode("clothesUser", FetchMode.JOIN);
		return criteria.list();
	}

	public ClothesSubscribe getClothesSubscribeById(int subscribeId) {
		// TODO Auto-generated method stub
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesSubscribe.class);
		criteria.setFetchMode("subscribeId", FetchMode.JOIN);
		if(subscribeId != 0) {
			criteria.add(Restrictions.eq("subscribeId", subscribeId));
		}
		List<ClothesSubscribe> list = criteria.list();
		if(list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}
	
	}

	public List<ClothesSubscribe> getClothesSubscribeByUserId(
			String subscribeId, ClothesUser clothesUser, String subscribeStatus) {
		// TODO Auto-generated method stub
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesSubscribe.class);
		criteria.setFetchMode("clothesUser", FetchMode.JOIN);
		if(subscribeId != null && !"".equals(subscribeId)) {
			criteria.add(Restrictions.eq("subscribeId", Integer.valueOf(subscribeId)));
		}
		if(clothesUser != null) {
			criteria.add(Restrictions.eq("clothesUser", clothesUser));
		}
		if(subscribeStatus !=null && !"".equals(subscribeStatus)) {
			criteria.add(Restrictions.eq("subscribeStatus", Integer.valueOf(subscribeStatus)));
		}
		return criteria.list();
	}

	public List<ClothesSubscribe> searchSubscribe(ClothesUser clothesUser,
			String subscribeStatus) {
		// TODO Auto-generated method stub
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesSubscribe.class);
		criteria.setFetchMode("clothesUser", FetchMode.JOIN);
		if(clothesUser != null) {
			criteria.add(Restrictions.eq("clothesUser", clothesUser));
		}
		if(subscribeStatus != null && !"".equals(subscribeStatus)) {
			criteria.add(Restrictions.eq("subscribeStatus",subscribeStatus));
		}
		return criteria.list();
	}



}
