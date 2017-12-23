package com.gamingzeus.pms.dbaccess.mysql.wallet;

import com.gamingzeus.pms.core.entity.Wallet;

public interface IWalletDao {

	Wallet insertWallet(Wallet wallet);
	Wallet fetchWalletDetailsByUserId(String userId);
}
