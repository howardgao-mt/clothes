package com.clothes.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.clothes.dao.ClothesSubscribeItemDao;
import com.clothes.model.ClothesSubscribe;
import com.clothes.model.ClothesSubscribeItem;

public class ClothesSubscribeItemDaoImpl extends HibernateDaoSupport implements ClothesSubscribeItemDao{

	public void saveClothesSubscribeItem(
			ClothesSubscribeItem clothesSubscribeItem) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(clothesSubscribeItem);	
	}

	public void updateClothesSubscribeItem(
			ClothesSubscribeItem clothesSubscribeItem) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(clothesSubscribeItem);		
	}

	public void deleteClothesSubscribeItem(
			ClothesSubscribeItem clothesSubscribeItem) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(clothesSubscribeItem);	
	}

	public List<ClothesSubscribeItem> getAllClothesSubscribeItem() {
		// TODO Auto-generated method stub
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesSubscribeItem.class);
		criteria.setFetchMode("clothesProduct", FetchMode.JOIN);
		return criteria.list();
	}

	public ClothesSubscribeItem getClothesSubscribeItemById(int subscribeitemId) {
		// TODO Auto-generated method stub
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesSubscribeItem.class);
		criteria.setFetchMode("clothesSubscribe", FetchMode.JOIN);
		if(subscribeitemId != 0) {
			criteria.add(Restrictions.eq("subscribeitemId", subscribeitemId));
		}
		List<ClothesSubscribeItem> list = criteria.list();
		if(list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public List<ClothesSubscribeItem> searchSubscribeItem(
			ClothesSubscribe clothesSubscribe, String SubscribeitemName) {
		// TODO Auto-generated method stub
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesSubscribeItem.class);
		criteria.setFetchMode("clothesSubscribe", FetchMode.JOIN);
		if(clothesSubscribe != null) criteria.add(Restrictions.eq("clothesSubscribe", clothesSubscribe));
		return criteria.list();
	}

	public List<ClothesSubscribeItem> getSubscribeItemListBySubscribe(
			ClothesSubscribe clothesSubscribe) {
		// TODO Auto-generated method stub
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesSubscribeItem.class);
		criteria.setFetchMode("clothesSubscribe", FetchMode.JOIN);
		criteria.setFetchMode("clothesProduct", FetchMode.JOIN);
		criteria.setFetchMode("clothesCheck.clothesProduct", FetchMode.JOIN);

		if(clothesSubscribe != null) criteria.add(Restrictions.eq("clothesSubscribe", clothesSubscribe));
		return criteria.list();
	}


}
