package com.gamingzeus.pms.dbaccess.mysql.wallet.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gamingzeus.pms.core.entity.Wallet;
import com.gamingzeus.pms.dbaccess.mysql.wallet.IWalletDao;

public class WalletDaoImpl implements IWalletDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Wallet insertWallet(Wallet wallet) {
		return (Wallet) sessionFactory.getCurrentSession().merge(
				wallet);
	}

	@Override
	public Wallet fetchWalletDetailsByUserId(String userId) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Wallet where userId=:userId");
		query.setParameter("userId", userId);
		return (Wallet) query.uniqueResult();
	}

}
