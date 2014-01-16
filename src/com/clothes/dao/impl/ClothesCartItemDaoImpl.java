package com.clothes.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.clothes.dao.ClothesCartItemDao;
import com.clothes.model.ClothesCart;
import com.clothes.model.ClothesCartItem;
public class ClothesCartItemDaoImpl extends HibernateDaoSupport implements ClothesCartItemDao{

	public void saveClothesCartItem(ClothesCartItem clothesCartItem) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(clothesCartItem);		
	}

	public void updateClothesCartItem(ClothesCartItem clothesCartItem) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(clothesCartItem);			
	}

	public void deleteClothesCartItem(ClothesCartItem clothesCartItem) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(clothesCartItem);	
	}
	public List<ClothesCartItem> getAllClothesCartItem() {
		// TODO Auto-generated method stub
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesCartItem.class);
		criteria.setFetchMode("clothesProduct", FetchMode.JOIN);
		criteria.setFetchMode("clothesCheck", FetchMode.JOIN);
		return criteria.list();
	}

	public ClothesCartItem getClothesCartItemById(int cartitemId) {
		// TODO Auto-generated method stub
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesCartItem.class);
		criteria.setFetchMode("clothesCart", FetchMode.JOIN);
		if(cartitemId != 0) {
			criteria.add(Restrictions.eq("cartItemId", cartitemId));
		}
		List<ClothesCartItem> list = criteria.list();
		if(list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public List<ClothesCartItem> searchCartItem(ClothesCart clothesCart,
			String cartitemName) {
		// TODO Auto-generated method stub
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesCartItem.class);
		criteria.setFetchMode("clothesCart", FetchMode.JOIN);
		if(clothesCart != null) criteria.add(Restrictions.eq("clothesCart", clothesCart));
		return criteria.list();
	}

	public List<ClothesCartItem> getCartItemListByCart(ClothesCart clothesCart) {
		// TODO Auto-generated method stub
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesCartItem.class);
		criteria.setFetchMode("clothesCart", FetchMode.JOIN);
		criteria.setFetchMode("clothesProduct", FetchMode.JOIN);
		criteria.setFetchMode("clothesProduct.clothesCheck", FetchMode.JOIN);

		if(clothesCart != null) criteria.add(Restrictions.eq("clothesCart", clothesCart));
		return criteria.list();
	}

}
