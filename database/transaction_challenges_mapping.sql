use pms;

CREATE TABLE `transaction_challenges_mapping` (
  `transaction_id` VARCHAR(64) NOT NULL,
  `challenge_id` VARCHAR (64) NOT NULL,
  `created` datetime NOT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
  PRIMARY KEY (`transaction_id`),
  KEY `idx_tcm_ci` (`challenge_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
