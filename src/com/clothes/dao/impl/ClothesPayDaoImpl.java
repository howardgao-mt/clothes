package com.clothes.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.clothes.dao.ClothesPayDao;
import com.clothes.model.ClothesCheck;
import com.clothes.model.ClothesPay;

public class ClothesPayDaoImpl extends HibernateDaoSupport implements ClothesPayDao{

	public void saveClothesPay(ClothesPay clothesPay) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(clothesPay);			
	}

	public void updateClothesPay(ClothesPay clothesPay) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(clothesPay);	
	}

	public void deleteClothesPay(ClothesPay clothesPay) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(clothesPay);		
	}

	public List<ClothesPay> getAllClothesPay() {
		// TODO Auto-generated method stub
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ClothesCheck.class);
		return criteria.list();
	}

	public ClothesPay getClothesPayById(int payId) {
		// TODO Auto-generated method stub
		return null;
	}

}
