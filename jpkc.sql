/*
SQLyog Ultimate v11.22 (64 bit)
MySQL - 5.6.27-log : Database - jpkc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jpkc` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jpkc`;

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT COMMENT 'Unique ID for the record',
  `title` varchar(32) NOT NULL COMMENT '标题',
  `content` text NOT NULL COMMENT '内容',
  `delete_status` smallint(6) NOT NULL DEFAULT '0' COMMENT 'Delete flag: 0-normal 1-deleted',
  `create_time` datetime NOT NULL COMMENT '记录生成的时间',
  `create_by` varchar(32) NOT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='通知公告表';

/*Data for the table `notice` */

insert  into `notice`(`id`,`title`,`content`,`delete_status`,`create_time`,`create_by`) values (1,'32132','132131231',0,'2015-11-26 13:40:40','123'),(2,'ewrwere','<img width=\"200px\" height=\"200px\" src=\"/jpkc/upload/image/20151126/20151126134237_172.jpg\" alt=\"\" />',0,'2015-11-26 13:42:38','123');

/*Table structure for table `resources` */

DROP TABLE IF EXISTS `resources`;

CREATE TABLE `resources` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT COMMENT 'Unique ID for the record',
  `title` varchar(32) NOT NULL COMMENT '标题',
  `path` text NOT NULL COMMENT '资源路径',
  `type` smallint(6) NOT NULL COMMENT '1 -- 电子教案,2 -- 教学课件,3 -- 教学视频,4 -- 教学大纲 ,5 -- 实验教学资料',
  `delete_status` smallint(6) NOT NULL DEFAULT '0' COMMENT 'Delete flag: 0-normal 1-deleted',
  `create_time` datetime NOT NULL COMMENT '记录生成的时间',
  `create_by` varchar(32) NOT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='资源表';

/*Data for the table `resources` */

/*Table structure for table `result` */

DROP TABLE IF EXISTS `result`;

CREATE TABLE `result` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT COMMENT 'Unique ID for the record',
  `team_id` smallint(6) NOT NULL COMMENT '成果者',
  `content` text NOT NULL COMMENT '简介',
  `type` smallint(6) NOT NULL COMMENT '1 -- 主持项目，2 -- 发表论文，3 -- 出版教材，4 -- 奖励情况',
  `delete_status` smallint(6) NOT NULL DEFAULT '0' COMMENT 'Delete flag: 0-normal 1-deleted',
  `create_time` datetime NOT NULL COMMENT '记录生成的时间',
  `create_by` varchar(32) NOT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='成果展示表';

/*Data for the table `result` */

/*Table structure for table `team` */

DROP TABLE IF EXISTS `team`;

CREATE TABLE `team` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT COMMENT 'Unique ID for the record',
  `member_name` varchar(32) NOT NULL COMMENT '成员名称',
  `content` text NOT NULL COMMENT '简介',
  `type` smallint(6) NOT NULL COMMENT '1 -- 导师,2 -- 学生',
  `email` varchar(32) NOT NULL COMMENT '邮箱',
  `tel` varchar(32) NOT NULL COMMENT '电话',
  `delete_status` smallint(6) NOT NULL DEFAULT '0' COMMENT 'Delete flag: 0-normal 1-deleted',
  `create_time` datetime NOT NULL COMMENT '记录生成的时间',
  `create_by` varchar(32) NOT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='师资队伍表';

/*Data for the table `team` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT COMMENT 'Unique ID for the record',
  `username` varchar(32) NOT NULL COMMENT '姓名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `delete_status` smallint(6) NOT NULL DEFAULT '0' COMMENT 'Delete flag: 0-normal 1-deleted',
  `create_time` datetime NOT NULL COMMENT '记录生成的时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`delete_status`,`create_time`) values (1,'123','123',0,'2015-11-25 23:32:57'),(2,'fsf3423','432423432432',0,'2015-11-26 13:40:33'),(3,'zhangsan','123456',0,'2015-11-27 13:53:25');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
