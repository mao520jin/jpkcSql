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

/*Table structure for table `sys_admin` */

DROP TABLE IF EXISTS `sys_admin`;

CREATE TABLE `sys_admin` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `username` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `status` int(11) NOT NULL COMMENT '状态：1=启用，0=禁用',
  `desc` varchar(64) DEFAULT NULL COMMENT '备注',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `last_modified_by` varchar(32) NOT NULL COMMENT '最后更新人',
  `last_modified_date` datetime NOT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统管理员表';

/*Data for the table `sys_admin` */

insert  into `sys_admin`(`id`,`username`,`password`,`status`,`desc`,`created_by`,`created_date`,`last_modified_by`,`last_modified_date`) values (147021694235870404,'zz123','zz123',1,'z','admin','2016-08-03 17:35:42','admin','2016-08-03 17:35:42');

/*Table structure for table `team_group` */

DROP TABLE IF EXISTS `team_group`;

CREATE TABLE `team_group` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `name` varchar(64) NOT NULL COMMENT '名称',
  `type` int(11) NOT NULL COMMENT '成员类型：1=导师，2=学生',
  `about` text NOT NULL COMMENT '简介',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(32) DEFAULT NULL COMMENT '电话',
  `desc` varchar(64) DEFAULT NULL COMMENT '备注',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `last_modified_by` varchar(32) NOT NULL COMMENT '最后更新人',
  `last_modified_date` datetime NOT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教学成员表';

/*Data for the table `team_group` */

insert  into `team_group`(`id`,`name`,`type`,`about`,`email`,`mobile`,`desc`,`created_by`,`created_date`,`last_modified_by`,`last_modified_date`) values (147399007194081921,'fsdfd',1,'sdfs','15570670131@163.com','13421831037',NULL,'admin','2016-09-16 09:41:11','admin','2016-09-16 09:41:11');

/*Table structure for table `team_honor` */

DROP TABLE IF EXISTS `team_honor`;

CREATE TABLE `team_honor` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `team_group_id` bigint(20) NOT NULL COMMENT '成果者',
  `about` text NOT NULL COMMENT '简介',
  `type` int(11) NOT NULL COMMENT '荣誉类型: 1=主持项目，2=发表论文，3=出版教材，4=奖励情况',
  `desc` varchar(64) DEFAULT NULL COMMENT '备注',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `last_modified_by` varchar(32) NOT NULL COMMENT '最后更新人',
  `last_modified_date` datetime NOT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教学荣誉表';

/*Data for the table `team_honor` */

insert  into `team_honor`(`id`,`team_group_id`,`about`,`type`,`desc`,`created_by`,`created_date`,`last_modified_by`,`last_modified_date`) values (146943160893170406,146942823076317601,'',2,NULL,'admin','2016-07-25 15:26:48','admin','2016-07-25 15:26:48'),(147399007921698305,147399007194081921,'sdf',2,NULL,'admin','2016-09-16 09:41:19','admin','2016-09-16 09:41:19');

/*Table structure for table `team_resource` */

DROP TABLE IF EXISTS `team_resource`;

CREATE TABLE `team_resource` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `title` varchar(64) NOT NULL COMMENT '标题',
  `path` varchar(64) NOT NULL COMMENT '资源路径',
  `type` int(11) NOT NULL COMMENT '资源类型: 1=电子教案,2=教学课件,3=教学视频,4=教学大纲 ,5=实验教学资料',
  `count` int(11) DEFAULT '0' COMMENT '下载次数',
  `desc` varchar(64) DEFAULT NULL COMMENT '备注',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `last_modified_by` varchar(32) NOT NULL COMMENT '最后更新人',
  `last_modified_date` datetime NOT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教学资源表';

/*Data for the table `team_resource` */

/*Table structure for table `website_msg` */

DROP TABLE IF EXISTS `website_msg`;

CREATE TABLE `website_msg` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `ip` varchar(64) NOT NULL COMMENT '留言ip',
  `count` int(11) NOT NULL COMMENT '同ip当天留言次数',
  `content` varchar(512) NOT NULL COMMENT '留言内容',
  `type` int(11) DEFAULT '1' COMMENT '留言类型：1=留言，2=回复',
  `desc` varchar(64) DEFAULT NULL COMMENT '备注',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `last_modified_by` varchar(32) NOT NULL COMMENT '最后更新人',
  `last_modified_date` datetime NOT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网站留言表';

/*Data for the table `website_msg` */

/*Table structure for table `website_notice` */

DROP TABLE IF EXISTS `website_notice`;

CREATE TABLE `website_notice` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `title` varchar(64) NOT NULL COMMENT '标题',
  `content` text NOT NULL COMMENT '内容',
  `desc` varchar(64) DEFAULT NULL COMMENT '备注',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `last_modified_by` varchar(32) NOT NULL COMMENT '最后更新人',
  `last_modified_date` datetime NOT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网站公告表';

/*Data for the table `website_notice` */

insert  into `website_notice`(`id`,`title`,`content`,`desc`,`created_by`,`created_date`,`last_modified_by`,`last_modified_date`) values (146330085306735214,'dsa','dsa',NULL,'admin','2016-05-15 16:27:33','admin','2016-05-15 16:27:33'),(146330085681870423,'dsadsadsadsa','asdas\n					',NULL,'admin','2016-05-15 16:27:36','admin','2016-05-15 16:29:51'),(146330103862670425,'sdsada','<div style=\"text-align:center;\">\n	asdasdasdasdasdasdasdasddasdsadsadsadasdasdsadsadsadas<img width=\"200px\" height=\"200px\" src=\"/jpkc/file/view?path=d://image/20160515163031/20160515163031_870.jpg\" alt=\"\" /> \n</div>',NULL,'admin','2016-05-15 16:30:38','admin','2016-05-15 17:00:35'),(146942774554988007,'das','dsa\n					',NULL,'admin','2016-07-25 14:22:25','admin','2016-07-25 22:16:01'),(146945629788835203,'4656','654',NULL,'admin','2016-07-25 22:18:17','admin','2016-07-25 22:18:17');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
