/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.19-log : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `bookinfo` */

DROP TABLE IF EXISTS `bookinfo`;

CREATE TABLE `bookinfo` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `book_name` varchar(255) DEFAULT NULL COMMENT '图书名称',
  `publisher` varchar(255) DEFAULT NULL COMMENT '出版社',
  `publish_time` date DEFAULT NULL COMMENT '出版日期',
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  `price` float DEFAULT NULL COMMENT '价格',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  `book_type` varchar(50) DEFAULT NULL COMMENT '图书分类',
  `creater` varchar(50) DEFAULT NULL COMMENT '创建人',
  `borrowing_status` int(2) DEFAULT NULL COMMENT '借阅状态， 借出，未借出',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bookinfo` */

/*Table structure for table `booktype` */

DROP TABLE IF EXISTS `booktype`;

CREATE TABLE `booktype` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '类型名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  `creater` varchar(50) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `booktype` */

insert  into `booktype`(`id`,`name`,`remark`,`create_date`,`update_date`,`creater`) values ('438a99d9-4220-11e8-b305-6045cb2655cd','1','12','2018-04-17 17:18:06',NULL,NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(50) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`address`,`phone`,`create_date`) values ('1','1','1','1','13699989898','2018-01-17 09:54:48'),('111','1','1','1','1','2018-01-03 00:00:00'),('112','1','1','1','1','2018-01-03 00:00:00'),('113','1','1','1','1','2018-01-03 00:00:00'),('114','1','1','1','1','2018-01-03 00:00:00'),('115','1','1','1','1','2018-01-03 00:00:00'),('120','1','1','1','1','2018-01-03 00:00:00'),('121','1','1','1','1','2018-01-03 00:00:00'),('122','1','1','1','1','2018-01-03 00:00:00'),('123','1','1','1','1','2018-01-03 00:00:00'),('2','2@qq.com','1ee04e0b1cb5af7367c80c22e42efd8b','3','1','2018-01-03 11:45:21'),('3','3@qq.com','1ee04e0b1cb5af7367c80c22e42efd8b','2','1','2018-01-03 11:45:20'),('4','4@qq.com','1ee04e0b1cb5af7367c80c22e42efd8b','1','1','2018-01-03 11:45:18'),('5','5@qq.com','1ee04e0b1cb5af7367c80c22e42efd8b','8','1','2018-01-03 11:45:31'),('6','6@qq.com','1ee04e0b1cb5af7367c80c22e42efd8b','10','1','2018-01-03 11:45:39'),('7','7@qq.com','1ee04e0b1cb5af7367c80c22e42efd8b','7','1','2018-01-03 11:45:28'),('8','8@qq.com','1ee04e0b1cb5af7367c80c22e42efd8b','9','1','2018-01-03 11:45:31'),('9','9@qq.com','1ee04e0b1cb5af7367c80c22e42efd8b','6','1','2018-01-03 11:45:26'),('95ce347b-f673-11e7-8981-6045cb2655cd','n111','131','221','112','2018-01-09 00:00:00'),('9a40338d-f5da-11e7-8981-6045cb2655cd','n','13','22','12','2018-01-08 00:00:00'),('9caedce3-f5e0-11e7-8981-6045cb2655cd','n111','131','221','112','2018-01-09 00:00:00'),('c227bf31-f5da-11e7-8981-6045cb2655cd','n111','131','221','112','2018-01-09 00:00:00'),('cfcf12ed-f4da-11e7-8981-6045cb2655cd','n','13','22','12','2018-01-08 00:00:00'),('ef2bb58d-f677-11e7-8981-6045cb2655cd','n111','131','221','112','2018-01-09 00:00:00'),('f737b1bc-f5e0-11e7-8981-6045cb2655cd','n111','131','221','112','2018-01-09 00:00:00'),('fb8d804c-f677-11e7-8981-6045cb2655cd','n111','131','221','112','2018-01-09 00:00:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
