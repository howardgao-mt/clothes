package com.clothes.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.clothes.dao.ClothesCartDao;
import com.clothes.model.ClothesCart;
import com.clothes.model.ClothesUser;

public class ClothesCartDaoImpl extends HibernateDaoSupport implements ClothesCartDao{

	public void saveClothesCart(ClothesCart clothesCart) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(clothesCart);		
	}

	public void updateClothesCart(ClothesCart clothesCart) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(clothesCart);		
	}

	public void deleteClothesCart(ClothesCart clothesCart) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(clothesCart);		
	}

	public List<ClothesCart> getAllClothesCart() {
		// TODO Auto-generated method stub
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesCart.class);
		criteria.setFetchMode("clothesUser", FetchMode.JOIN);
		criteria.setFetchMode("clothesProduct", FetchMode.JOIN);
		criteria.setFetchMode("clothesCheck", FetchMode.JOIN);
		return criteria.list();
	}

	public ClothesCart getClothesCartById(int cartId) {
		// TODO Auto-generated method stub
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesCart.class);
		criteria.setFetchMode("cartId", FetchMode.JOIN);
		if(cartId != 0) {
			criteria.add(Restrictions.eq("cartId", cartId));
		}
		List<ClothesCart> list = criteria.list();
		if(list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public List<ClothesCart> getClothesCartByUserId(String cartId, ClothesUser clothesUser, String cartStatus) {
		// TODO Auto-generated method stub
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesCart.class);
		criteria.setFetchMode("clothesUser", FetchMode.JOIN);
		if(cartId != null && !"".equals(cartId)) {
			criteria.add(Restrictions.eq("cartId", Integer.valueOf(cartId)));
		}
		if(clothesUser != null) {
			criteria.add(Restrictions.eq("clothesUser", clothesUser));
		}
		if(cartStatus !=null && !"".equals(cartStatus)) {
			criteria.add(Restrictions.eq("cartStatus", Integer.valueOf(cartStatus)));
		}
		return criteria.list();
	}

	public List<ClothesCart> searchCart(ClothesUser clothesUser,
			String cartStatus) {
		// TODO Auto-generated method stub
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesCart.class);
		criteria.setFetchMode("clothesUser", FetchMode.JOIN);
		if(clothesUser != null) {
			criteria.add(Restrictions.eq("clothesUser", clothesUser));
		}
		if(cartStatus != null && !"".equals(cartStatus)) {
			criteria.add(Restrictions.eq("cartStatus", cartStatus));
		}
		return criteria.list();
	}


}
