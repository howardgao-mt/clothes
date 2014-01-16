package com.clothes.dao.impl;

	import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.clothes.dao.ClothesProductDao;
import com.clothes.model.ClothesCheck;
import com.clothes.model.ClothesProduct;

public class ClothesProductDaoImpl extends HibernateDaoSupport implements ClothesProductDao{

	public void saveClothesProduct(ClothesProduct clothesProduct) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(clothesProduct);	
	}

	public void updateClothesProduct(ClothesProduct clothesProduct) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(clothesProduct);			
	}

	public void deleteClothesProduct(ClothesProduct clothesProduct) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(clothesProduct);			
	}

	public List<ClothesProduct> getAllClothesProduct(ClothesCheck clothesCheck, int productStatus) {
		// TODO Auto-generated method stub
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesProduct.class);
		criteria.setFetchMode("clothesCheck", FetchMode.JOIN);
		if(clothesCheck != null) criteria.add(Restrictions.eq("clothesCheck", clothesCheck));
		if(productStatus != 0) criteria.add(Restrictions.eq("productStatus", productStatus));
		return criteria.list();

	}
	public List<ClothesProduct> getAllClothesProduct() {
		// TODO Auto-generated method stub
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesProduct.class);
		criteria.setFetchMode("clothesCheck", FetchMode.JOIN);

		return criteria.list();

	}	
	public ClothesProduct getClothesProductById(int productId) {
		// TODO Auto-generated method stub
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesProduct.class);
		criteria.setFetchMode("clothesCheck", FetchMode.JOIN);
		if(productId != 0) {
			criteria.add(Restrictions.eq("productId", productId));
		}
		List<ClothesProduct> list = criteria.list();
		if(list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}
	}
    //類別跟商品的對應關係
	public List<ClothesProduct> searchProduct(ClothesCheck clothesCheck,
			String productName) {
		// TODO Auto-generated method stub
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesProduct.class);
		criteria.setFetchMode("clothesCheck", FetchMode.JOIN);
		if(clothesCheck != null) criteria.add(Restrictions.eq("clothesCheck", clothesCheck));
		return criteria.list();
	}

}
