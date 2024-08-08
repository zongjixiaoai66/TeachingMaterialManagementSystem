/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb3 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP DATABASE IF EXISTS `t286`;
CREATE DATABASE IF NOT EXISTS `t286` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `t286`;

DROP TABLE IF EXISTS `banji`;
CREATE TABLE IF NOT EXISTS `banji` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `yuanxi_types` int DEFAULT NULL COMMENT '院系 Search111 ',
  `banji_name` varchar(200) DEFAULT NULL COMMENT '班级名称 Search111 ',
  `banji_address` varchar(200) DEFAULT NULL COMMENT '班级位置',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '添加时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COMMENT='班级';

DELETE FROM `banji`;
INSERT INTO `banji` (`id`, `yuanxi_types`, `banji_name`, `banji_address`, `insert_time`, `create_time`) VALUES
	(1, 1, '班级名称1', '班级位置1', '2022-03-11 06:49:38', '2022-03-11 06:49:38'),
	(2, 2, '班级名称2', '班级位置2', '2022-03-11 06:49:38', '2022-03-11 06:49:38'),
	(3, 3, '班级名称3', '班级位置3', '2022-03-11 06:49:38', '2022-03-11 06:49:38'),
	(4, 1, '班级名称4', '班级位置4', '2022-03-11 06:49:38', '2022-03-11 06:49:38'),
	(5, 2, '班级名称5', '班级位置5', '2022-03-11 06:49:38', '2022-03-11 06:49:38');

DROP TABLE IF EXISTS `config`;
CREATE TABLE IF NOT EXISTS `config` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='配置文件';

DELETE FROM `config`;

DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE IF NOT EXISTS `dictionary` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dic_code` varchar(200) DEFAULT NULL COMMENT '字段',
  `dic_name` varchar(200) DEFAULT NULL COMMENT '字段名',
  `code_index` int DEFAULT NULL COMMENT '编码',
  `index_name` varchar(200) DEFAULT NULL COMMENT '编码名字  Search111 ',
  `super_id` int DEFAULT NULL COMMENT '父字段id',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3 COMMENT='字典';

DELETE FROM `dictionary`;
INSERT INTO `dictionary` (`id`, `dic_code`, `dic_name`, `code_index`, `index_name`, `super_id`, `beizhu`, `create_time`) VALUES
	(1, 'sex_types', '性别类型', 1, '男', NULL, NULL, '2022-03-11 06:38:00'),
	(2, 'sex_types', '性别类型', 2, '女', NULL, NULL, '2022-03-11 06:38:00'),
	(3, 'kecheng_types', '课程类别', 1, '课程类别1', NULL, NULL, '2022-03-11 06:38:00'),
	(4, 'kecheng_types', '课程类别', 2, '课程类别2', NULL, NULL, '2022-03-11 06:38:00'),
	(5, 'kecheng_types', '课程类别', 3, '课程类别3', NULL, NULL, '2022-03-11 06:38:00'),
	(6, 'kecheng_types', '课程类别', 4, '课程类别4', NULL, NULL, '2022-03-11 06:38:00'),
	(7, 'yuanxi_types', '院系', 1, '院系1', NULL, NULL, '2022-03-11 06:38:00'),
	(8, 'yuanxi_types', '院系', 2, '院系2', NULL, NULL, '2022-03-11 06:38:00'),
	(9, 'yuanxi_types', '院系', 3, '院系3', NULL, NULL, '2022-03-11 06:38:00'),
	(10, 'yuanxi_types', '院系', 4, '院系4', NULL, NULL, '2022-03-11 06:38:00'),
	(11, 'jiaoxueziliao_types', '资料类型', 1, '文本类', NULL, NULL, '2022-03-11 06:38:00'),
	(12, 'jiaoxueziliao_types', '资料类型', 2, '图像类', NULL, NULL, '2022-03-11 06:38:00'),
	(13, 'jiaoxueziliao_types', '资料类型', 3, '视频类', NULL, NULL, '2022-03-11 06:38:00'),
	(14, 'jiaoxueziliao_types', '资料类型', 4, '音频类', NULL, NULL, '2022-03-11 06:38:00'),
	(15, 'jiaoxueziliao_types', '资料类型', 5, '试卷', NULL, NULL, '2022-03-11 06:38:00'),
	(16, 'jiaoxueziliao_types', '资料类型', 6, '课件', NULL, NULL, '2022-03-11 06:38:00'),
	(17, 'fenxiang_types', '是否分享', 1, '分享', NULL, NULL, '2022-03-11 06:38:00'),
	(18, 'fenxiang_types', '是否分享', 2, '不分享', NULL, NULL, '2022-03-11 06:38:00'),
	(19, 'yuanxi_types', '院系', 5, '院系5', NULL, '', '2022-03-11 07:29:52');

DROP TABLE IF EXISTS `jiaoxueziliao`;
CREATE TABLE IF NOT EXISTS `jiaoxueziliao` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `laoshi_id` int DEFAULT NULL COMMENT '老师',
  `kecheng_id` int DEFAULT NULL COMMENT '课程',
  `jiaoxueziliao_name` varchar(200) DEFAULT NULL COMMENT '教学资料名称 Search111 ',
  `jiaoxueziliao_types` int DEFAULT NULL COMMENT '资料类型 Search111 ',
  `jiaoxueziliao_file` varchar(200) DEFAULT NULL COMMENT '资料文件',
  `jiaoxueziliao_content` text COMMENT '资料详情',
  `banben` varchar(200) DEFAULT NULL COMMENT '版本',
  `fenxiang_types` int DEFAULT NULL COMMENT '是否分享 Search111 ',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '添加时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COMMENT='教学资料';

DELETE FROM `jiaoxueziliao`;
INSERT INTO `jiaoxueziliao` (`id`, `laoshi_id`, `kecheng_id`, `jiaoxueziliao_name`, `jiaoxueziliao_types`, `jiaoxueziliao_file`, `jiaoxueziliao_content`, `banben`, `fenxiang_types`, `insert_time`, `create_time`) VALUES
	(6, 1, 4, '资料111', 6, 'http://localhost:8080/jiaoxueziliaoguanli/upload/1646983602733.rar', '<p>撒打算</p>', '1', 1, '2022-03-11 07:26:51', '2022-03-11 07:26:51'),
	(7, 1, 4, '资料222', 3, 'http://localhost:8080/jiaoxueziliaoguanli/upload/1646983602733.rar', '<p>撒打算1</p>', '1', 2, '2022-03-11 07:26:51', '2022-03-11 07:26:51');

DROP TABLE IF EXISTS `kecheng`;
CREATE TABLE IF NOT EXISTS `kecheng` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `laoshi_id` int DEFAULT NULL COMMENT '老师',
  `yuanxi_types` int DEFAULT NULL COMMENT '院系 Search111 ',
  `kecheng_name` varchar(200) DEFAULT NULL COMMENT '课程名称 Search111 ',
  `kecheng_types` int DEFAULT NULL COMMENT '课程类别 Search111 ',
  `kecheng_address` varchar(200) DEFAULT NULL COMMENT '上课地点',
  `xuefen` int DEFAULT NULL COMMENT '学分',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '添加时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COMMENT='课程';

DELETE FROM `kecheng`;
INSERT INTO `kecheng` (`id`, `laoshi_id`, `yuanxi_types`, `kecheng_name`, `kecheng_types`, `kecheng_address`, `xuefen`, `insert_time`, `create_time`) VALUES
	(1, 1, 1, '课程名称1', 1, '上课地点1', 489, '2022-03-11 06:49:38', '2022-03-11 06:49:38'),
	(2, 1, 2, '课程名称2', 3, '上课地点2', 267, '2022-03-11 06:49:38', '2022-03-11 06:49:38'),
	(3, 2, 3, '课程名称3', 1, '上课地点3', 75, '2022-03-11 06:49:38', '2022-03-11 06:49:38'),
	(4, 1, 1, '课程名称4', 4, '上课地点4', 284, '2022-03-11 06:49:38', '2022-03-11 06:49:38'),
	(5, 2, 2, '课程名称5', 2, '上课地点5', 500, '2022-03-11 06:49:38', '2022-03-11 06:49:38');

DROP TABLE IF EXISTS `laoshi`;
CREATE TABLE IF NOT EXISTS `laoshi` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(200) DEFAULT NULL COMMENT '账户',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `laoshi_name` varchar(200) DEFAULT NULL COMMENT '老师姓名 Search111 ',
  `laoshi_phone` varchar(200) DEFAULT NULL COMMENT '老师手机号',
  `laoshi_id_number` varchar(200) DEFAULT NULL COMMENT '老师身份证号',
  `laoshi_photo` varchar(200) DEFAULT NULL COMMENT '老师头像',
  `sex_types` int DEFAULT NULL COMMENT '性别',
  `yuanxi_types` int DEFAULT NULL COMMENT '院系',
  `laoshi_email` varchar(200) DEFAULT NULL COMMENT '电子邮箱',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='老师';

DELETE FROM `laoshi`;
INSERT INTO `laoshi` (`id`, `username`, `password`, `laoshi_name`, `laoshi_phone`, `laoshi_id_number`, `laoshi_photo`, `sex_types`, `yuanxi_types`, `laoshi_email`, `create_time`) VALUES
	(1, '老师1', '123456', '老师姓名1', '17703786901', '410224199610232001', 'http://localhost:8080/jiaoxueziliaoguanli/upload/laoshi1.jpg', 1, 1, '1@qq.com', '2022-03-11 06:49:38'),
	(2, '老师2', '123456', '老师姓名2', '17703786902', '410224199610232002', 'http://localhost:8080/jiaoxueziliaoguanli/upload/laoshi2.jpg', 2, 2, '2@qq.com', '2022-03-11 06:49:38'),
	(3, '老师3', '123456', '老师姓名3', '17703786903', '410224199610232003', 'http://localhost:8080/jiaoxueziliaoguanli/upload/laoshi3.jpg', 2, 3, '3@qq.com', '2022-03-11 06:49:38');

DROP TABLE IF EXISTS `token`;
CREATE TABLE IF NOT EXISTS `token` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='token表';

DELETE FROM `token`;
INSERT INTO `token` (`id`, `userid`, `username`, `tablename`, `role`, `token`, `addtime`, `expiratedtime`) VALUES
	(1, 6, 'admin', 'users', '管理员', '4gmjicov5ywevwttwmxsn5q63hvgmsfg', '2022-03-11 07:00:36', '2024-07-24 03:56:37'),
	(2, 1, 'a1', 'laoshi', '老师', 'ts81lv9h5wfwl9hsgmq7vqso41l7q992', '2022-03-11 07:24:52', '2024-07-24 03:57:28'),
	(3, 2, 'a2', 'laoshi', '老师', '1b2m1z08dhcvceug9wvtthtvcb9r3mgl', '2022-03-11 07:27:52', '2022-03-11 08:35:24');

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='管理员';

DELETE FROM `users`;
INSERT INTO `users` (`id`, `username`, `password`, `role`, `addtime`) VALUES
	(6, 'admin', '123456', '管理员', '2022-05-02 06:51:13');

DROP TABLE IF EXISTS `xuesheng`;
CREATE TABLE IF NOT EXISTS `xuesheng` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `laoshi_id` int DEFAULT NULL COMMENT '老师',
  `banji_id` int DEFAULT NULL COMMENT '班级',
  `xuesheng_name` varchar(200) DEFAULT NULL COMMENT '学生姓名 Search111 ',
  `xuesheng_phone` varchar(200) DEFAULT NULL COMMENT '学生手机号',
  `xuesheng_id_number` varchar(200) DEFAULT NULL COMMENT '学生身份证号',
  `xuesheng_photo` varchar(200) DEFAULT NULL COMMENT '学生头像',
  `xuesheng_email` varchar(200) DEFAULT NULL COMMENT '电子邮箱',
  `sex_types` int DEFAULT NULL COMMENT '性别',
  `xuesheng_content` text COMMENT '备注',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '添加时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COMMENT='学生';

DELETE FROM `xuesheng`;
INSERT INTO `xuesheng` (`id`, `laoshi_id`, `banji_id`, `xuesheng_name`, `xuesheng_phone`, `xuesheng_id_number`, `xuesheng_photo`, `xuesheng_email`, `sex_types`, `xuesheng_content`, `insert_time`, `create_time`) VALUES
	(1, 2, 1, '学生姓名1', '17703786901', '410224199610232001', 'http://localhost:8080/jiaoxueziliaoguanli/upload/xuesheng1.jpg', '1@qq.com', 2, '备注1', '2022-03-11 06:49:38', '2022-03-11 06:49:38'),
	(2, 3, 2, '学生姓名2', '17703786902', '410224199610232002', 'http://localhost:8080/jiaoxueziliaoguanli/upload/xuesheng2.jpg', '2@qq.com', 2, '备注2', '2022-03-11 06:49:38', '2022-03-11 06:49:38'),
	(3, 1, 3, '学生姓名3', '17703786903', '410224199610232003', 'http://localhost:8080/jiaoxueziliaoguanli/upload/xuesheng3.jpg', '3@qq.com', 1, '备注3', '2022-03-11 06:49:38', '2022-03-11 06:49:38'),
	(4, 3, 4, '学生姓名4', '17703786904', '410224199610232004', 'http://localhost:8080/jiaoxueziliaoguanli/upload/xuesheng4.jpg', '4@qq.com', 2, '备注4', '2022-03-11 06:49:38', '2022-03-11 06:49:38'),
	(5, 2, 5, '学生姓名5', '17703786905', '410224199610232005', 'http://localhost:8080/jiaoxueziliaoguanli/upload/xuesheng5.jpg', '5@qq.com', 1, '备注5', '2022-03-11 06:49:38', '2022-03-11 06:49:38'),
	(6, 1, 1, 'xuesheng2', '17703782852', '410224199610232002', 'http://localhost:8080/jiaoxueziliaoguanli/upload/1646984105056.jpg', 'ww@qq.com', 2, '<p>wwq</p>', '2022-03-11 07:35:14', '2022-03-11 07:35:14');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
