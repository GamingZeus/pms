/* type: DEBIT, CREDIT, WITHDRAW, DEPOSIT */

use pms;

CREATE TABLE `transaction` (
  `transaction_id` VARCHAR(64) NOT NULL,
  `payment_gateway_id` VARCHAR(64) NOT NULL,
  `payment_gateway` VARCHAR(64) NOT NULL,
  `user_id` VARCHAR(64) NOT NULL,
  `type` VARCHAR(10) NOT NULL,
  `amount` int(11) NOT NULL,
  `currency` VARCHAR(10) NOT NULL,
  `created` datetime NOT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
  PRIMARY KEY (`transaction_id`),
  KEY `idx_t_ui` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
