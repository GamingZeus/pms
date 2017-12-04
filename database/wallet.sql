use pms;

CREATE TABLE `wallet` (
  `user_id` VARCHAR(64) NOT NULL,
  `balance` int(11) NOT NULL,
  `currency` VARCHAR(10) NOT NULL,
  `created` datetime NOT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
  PRIMARY KEY (`user_id`),
  KEY `idx_t_ui` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
