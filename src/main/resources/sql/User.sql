-- auto Generated on 2017-07-25 23:20:07 
-- DROP TABLE IF EXISTS `user_d_o`; 
CREATE TABLE `user_d_o`(
    `id` BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'name',
    `password` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'password',
    `role_id` INT (11) NOT NULL DEFAULT -1 COMMENT 'roleId',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`user_d_o`';
