package com.gamingzeus.pms.service.wallet;

import com.gamingzeus.pms.core.entity.Wallet;

public interface IWalletService {

	Wallet insertWallet(Wallet wallet);
	Wallet fetchWalletDetailsByUserId(String userId);
}
