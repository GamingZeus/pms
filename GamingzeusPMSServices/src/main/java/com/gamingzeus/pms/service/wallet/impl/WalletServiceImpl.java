package com.gamingzeus.pms.service.wallet.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamingzeus.pms.core.entity.Wallet;
import com.gamingzeus.pms.dbaccess.mysql.wallet.IWalletDao;
import com.gamingzeus.pms.service.wallet.IWalletService;

@Service("walletService")
public class WalletServiceImpl implements IWalletService {

	@Autowired
	private IWalletDao walletDao;

	@Override
	@Transactional
	public Wallet insertWallet(Wallet wallet) {
		return walletDao.insertWallet(wallet);
	}

	@Override
	@Transactional (readOnly = true)
	public Wallet fetchWalletDetailsByUserId(String userId) {
		return walletDao.fetchWalletDetailsByUserId(userId);
	}

}
