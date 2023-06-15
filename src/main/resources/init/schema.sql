DROP table IF EXISTS `t_todo`;

CREATE TABLE IF NOT EXISTS `health` (
    `itodo` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `ctnt` varchar(100) NOT NULL,
    `del_yn` tinyint(4) DEFAULT 0 CHECK (`del_yn` in (0,1)),
    `pic` varchar(100) DEFAULT NULL,
    `finish_yn` tinyint(4) DEFAULT 0 CHECK (`del_yn` in (0,1)),
    `created_at` datetime DEFAULT current_timestamp(),
    `updated_at` datetime DEFAULT current_timestamp(),
    PRIMARY KEY (`itodo`)
    )
