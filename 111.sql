-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.17-log - MySQL Community Server (GPL)
-- 服务器OS:                        Win64
-- HeidiSQL 版本:                  10.1.0.5560
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for test
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;

-- Dumping structure for table test.address
CREATE TABLE IF NOT EXISTS `address` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `user_id` int(50) NOT NULL,
  `contry` varchar(20) DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `detail` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '1123',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table test.address: ~0 rows (大约)
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;

-- Dumping structure for table test.goods
CREATE TABLE IF NOT EXISTS `goods` (
  `id` int(11) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table test.goods: ~2 rows (大约)
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` (`id`, `code`, `name`) VALUES
	(1, 'p30', 'p30'),
	(2, 'iphone4', 'iphone4'),
	(3, 'iphonex', 'iphonex');
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;

-- Dumping structure for table test.goods_attr
CREATE TABLE IF NOT EXISTS `goods_attr` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_code` varchar(50) DEFAULT NULL,
  `attr_id` varchar(200) DEFAULT NULL,
  `value_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table test.goods_attr: ~7 rows (大约)
/*!40000 ALTER TABLE `goods_attr` DISABLE KEYS */;
INSERT INTO `goods_attr` (`id`, `goods_code`, `attr_id`, `value_id`) VALUES
	(1, 'p30', '1-1', '1'),
	(2, 'p30', '2-1', '1'),
	(3, 'iphone4', '1-1', '1'),
	(4, 'iphone4', '2-2', '2'),
	(5, 'iphone4', '3-3', '3'),
	(6, 'iphonex', '1-2', '2'),
	(7, 'iphonex', '2-2', '2');
/*!40000 ALTER TABLE `goods_attr` ENABLE KEYS */;

-- Dumping structure for table test.hobby
CREATE TABLE IF NOT EXISTS `hobby` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `user_id` int(50) NOT NULL,
  `code` varchar(50) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '123',
  `field` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `Index 2` (`user_id`,`code`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- Dumping data for table test.hobby: ~6 rows (大约)
/*!40000 ALTER TABLE `hobby` DISABLE KEYS */;
INSERT INTO `hobby` (`id`, `user_id`, `code`, `name`, `field`) VALUES
	(21, 1, 'pp', '乒乓球', 0),
	(22, 1, 'b', '篮球', 1),
	(23, 1, 'f', '足球', 1),
	(24, 2, 'f', '足球', 1),
	(25, 952855, '177', '😟😤😢😭😦', 0),
	(26, 838163, '38254', '😟😤😢😭😦', 0);
/*!40000 ALTER TABLE `hobby` ENABLE KEYS */;

-- Dumping structure for table test.test
CREATE TABLE IF NOT EXISTS `test` (
  `id` int(11) NOT NULL,
  `t` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table test.test: ~3 rows (大约)
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` (`id`, `t`) VALUES
	(1, 1),
	(2, 22),
	(3, 33);
/*!40000 ALTER TABLE `test` ENABLE KEYS */;

-- Dumping structure for table test.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `pwd` varchar(300) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- Dumping data for table test.user: ~5 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `code`, `name`, `pwd`, `country`) VALUES
	(1, '123', '张三', '123', '中国'),
	(2, '124', '李四', '213', '中国'),
	(3, '125', '王五', '123213', 'asd'),
	(13, '126', '126', NULL, NULL),
	(14, '127', '127', NULL, NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- Dumping database structure for ms_goods
CREATE DATABASE IF NOT EXISTS `ms_goods` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ms_goods`;

-- Dumping structure for table ms_goods.g_attr
CREATE TABLE IF NOT EXISTS `g_attr` (
  `attr_id` mediumint(9) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `attr_code` varchar(30) NOT NULL COMMENT '属性代码',
  `attr_name` varchar(30) NOT NULL COMMENT '属性名',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`attr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10004 DEFAULT CHARSET=utf8 COMMENT='属性表';

-- Dumping data for table ms_goods.g_attr: ~7 rows (大约)
/*!40000 ALTER TABLE `g_attr` DISABLE KEYS */;
INSERT INTO `g_attr` (`attr_id`, `attr_code`, `attr_name`, `description`, `created_time`, `updated_time`) VALUES
	(1, 'color', '颜色', NULL, '2019-05-24 11:14:20', '2019-05-25 09:46:42'),
	(2, 'brand', '品牌', NULL, '2019-06-06 10:07:18', '2019-06-06 10:07:18'),
	(3, 'length', '长度', NULL, '2019-06-06 10:07:18', '2019-06-06 10:07:18'),
	(10000, 'width', '宽度', NULL, '2019-06-11 16:34:22', '2019-06-11 16:34:22'),
	(10001, 'height', '高度', NULL, '2019-06-11 16:34:38', '2019-06-11 16:34:38'),
	(10002, 'thickness', '厚度', NULL, '2019-06-11 16:35:07', '2019-06-11 16:35:07'),
	(10003, 'screenSize', '屏幕尺寸', NULL, '2019-06-11 16:35:37', '2019-06-11 16:35:37');
/*!40000 ALTER TABLE `g_attr` ENABLE KEYS */;

-- Dumping structure for table ms_goods.g_category
CREATE TABLE IF NOT EXISTS `g_category` (
  `category_id` mediumint(9) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_code` varchar(30) NOT NULL COMMENT '分类代码',
  `category_name` varchar(50) NOT NULL COMMENT '分类名',
  `parent_id` mediumint(9) NOT NULL DEFAULT '0' COMMENT '父节点id',
  `order_value` smallint(6) NOT NULL DEFAULT '1' COMMENT '排序值',
  `level` tinyint(4) NOT NULL DEFAULT '1' COMMENT '层级',
  `is_leaf` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否叶子节点 0:不是 1:是',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态 1:正常 0:删除',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `created_user` varchar(30) NOT NULL COMMENT '创建人',
  `updated_user` varchar(30) DEFAULT NULL COMMENT '最后更改人',
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `idx_category_2` (`category_code`),
  KEY `idx_category_1` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10024 DEFAULT CHARSET=utf8 COMMENT='商品分类表';

-- Dumping data for table ms_goods.g_category: ~11 rows (大约)
/*!40000 ALTER TABLE `g_category` DISABLE KEYS */;
INSERT INTO `g_category` (`category_id`, `category_code`, `category_name`, `parent_id`, `order_value`, `level`, `is_leaf`, `status`, `created_time`, `updated_time`, `created_user`, `updated_user`) VALUES
	(10000, 'mobile-device', '移动设备', 0, 1, 1, 1, 1, '2019-05-25 11:21:08', '2019-05-28 11:30:59', 'system', NULL),
	(10001, 'computer', '计算机', 0, 2, 1, 1, 1, '2019-05-25 11:22:04', '2019-05-28 11:31:01', 'system', NULL),
	(10002, 'clothing', '服装', 0, 3, 1, 1, 1, '2019-05-25 11:22:59', '2019-05-28 11:31:02', 'system', NULL),
	(10003, 'electric-appliance', '电器', 0, 5, 1, 1, 1, '2019-05-25 11:24:13', '2019-05-28 11:31:03', 'system', NULL),
	(10004, 'outdoors', '户外', 0, 4, 1, 1, 1, '2019-05-25 11:25:59', '2019-05-28 11:31:04', 'system', NULL),
	(10005, 'book', '图书', 0, 6, 1, 1, 1, '2019-05-25 11:27:05', '2019-05-28 11:31:06', 'system', NULL),
	(10006, 'industrial-goods', '工业品', 0, 7, 1, 1, 1, '2019-05-25 11:28:17', '2019-05-28 11:31:07', 'system', NULL),
	(10019, 'winesDrinks', '酒水饮料', 0, 8, 1, 0, 1, '2019-05-29 15:36:45', '2019-06-20 15:47:44', 'string', NULL),
	(10020, 'drinkingWater', '饮用水', 10019, 1, 2, 1, 1, '2019-05-29 15:36:59', '2019-06-20 15:48:03', 'string', NULL),
	(10021, 'wine', '酒', 10019, 2, 2, 1, 1, '2019-06-03 20:19:48', '2019-06-20 15:48:28', 'system', NULL),
	(10023, 'drinks', '饮料', 10019, 3, 2, 1, 0, '2019-06-04 18:23:09', '2019-06-20 15:48:46', 'system', NULL);
/*!40000 ALTER TABLE `g_category` ENABLE KEYS */;

-- Dumping structure for table ms_goods.g_category_attr
CREATE TABLE IF NOT EXISTS `g_category_attr` (
  `ca_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_id` mediumint(9) NOT NULL COMMENT '分类id',
  `attr_id` mediumint(9) NOT NULL COMMENT '属性id',
  `parent_id` mediumint(9) DEFAULT '0' COMMENT '父节点id',
  `type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '类型 1:关键属性 2:销售属性 3:其他属性',
  `selected` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否查询属性 0:否 1:是',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态 1:正常 0:删除',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `created_user` varchar(30) NOT NULL DEFAULT 'system' COMMENT '创建人',
  `updated_user` varchar(30) DEFAULT NULL COMMENT '最后更改人',
  PRIMARY KEY (`ca_id`),
  UNIQUE KEY `idx_gca_1` (`category_id`,`attr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='分类属性表';

-- Dumping data for table ms_goods.g_category_attr: ~4 rows (大约)
/*!40000 ALTER TABLE `g_category_attr` DISABLE KEYS */;
INSERT INTO `g_category_attr` (`ca_id`, `category_id`, `attr_id`, `parent_id`, `type`, `selected`, `status`, `created_time`, `updated_time`, `created_user`, `updated_user`) VALUES
	(1, 10020, 1, 0, 1, 0, 1, '2019-06-06 10:08:20', '2019-06-06 10:08:53', 'system', NULL),
	(2, 10020, 2, 0, 2, 0, 1, '2019-06-06 10:08:52', '2019-06-13 14:12:36', 'system', 'system'),
	(3, 10020, 3, 0, 3, 0, 1, '2019-06-11 20:03:20', '2019-06-13 13:54:39', 'system', 'system'),
	(5, 10021, 1, 0, 1, 1, 1, '2019-06-11 20:13:10', NULL, 'system', NULL);
/*!40000 ALTER TABLE `g_category_attr` ENABLE KEYS */;

-- Dumping structure for table ms_goods.g_category_attr_value
CREATE TABLE IF NOT EXISTS `g_category_attr_value` (
  `cav_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ca_id` int(11) NOT NULL COMMENT '分类属性id',
  `value` varchar(50) NOT NULL COMMENT '属性值',
  `description` varchar(300) DEFAULT NULL COMMENT '描述',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态 1:正常 0:删除',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `created_user` varchar(30) NOT NULL COMMENT '创建人',
  `updated_user` varchar(30) DEFAULT NULL COMMENT '最后更改人',
  PRIMARY KEY (`cav_id`),
  UNIQUE KEY `idx_cav_1` (`ca_id`,`value`)
) ENGINE=InnoDB AUTO_INCREMENT=10004 DEFAULT CHARSET=utf8 COMMENT='分类属性值表';

-- Dumping data for table ms_goods.g_category_attr_value: ~4 rows (大约)
/*!40000 ALTER TABLE `g_category_attr_value` DISABLE KEYS */;
INSERT INTO `g_category_attr_value` (`cav_id`, `ca_id`, `value`, `description`, `status`, `created_time`, `updated_time`, `created_user`, `updated_user`) VALUES
	(10000, 1, '红色', NULL, 1, '2019-06-06 14:16:18', NULL, 'system', NULL),
	(10001, 1, '蓝色', NULL, 1, '2019-06-06 14:16:36', NULL, 'system', NULL),
	(10002, 1, '黑色', NULL, 1, '2019-06-06 14:16:58', NULL, 'system', NULL),
	(10003, 1, '绿色', NULL, 1, '2019-06-13 13:55:03', NULL, 'system', NULL);
/*!40000 ALTER TABLE `g_category_attr_value` ENABLE KEYS */;

-- Dumping structure for table ms_goods.g_item
CREATE TABLE IF NOT EXISTS `g_item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ca_id` int(11) NOT NULL COMMENT '分类id',
  `item_code` varchar(30) NOT NULL COMMENT '商品代码',
  `item_name` varchar(100) NOT NULL COMMENT '商品名称',
  `description` varchar(300) DEFAULT NULL COMMENT '描述',
  `price` decimal(12,2) NOT NULL DEFAULT '0.00' COMMENT '价格',
  `picture` varchar(300) DEFAULT NULL COMMENT '图片',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态   0:删除 1:上架 2:下架 ',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `created_user` varchar(30) NOT NULL COMMENT '创建人',
  `updated_user` varchar(30) DEFAULT NULL COMMENT '最后更改人',
  PRIMARY KEY (`item_id`),
  UNIQUE KEY `idx_item_1` (`item_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='商品表';

-- Dumping data for table ms_goods.g_item: ~2 rows (大约)
/*!40000 ALTER TABLE `g_item` DISABLE KEYS */;
INSERT INTO `g_item` (`item_id`, `ca_id`, `item_code`, `item_name`, `description`, `price`, `picture`, `status`, `created_time`, `updated_time`, `created_user`, `updated_user`) VALUES
	(1, 10023, 'xuebi', '雪碧', NULL, 0.00, NULL, 1, '2019-06-20 15:49:24', NULL, 'system', NULL),
	(2, 10023, 'cocacola', '可口可乐', NULL, 0.00, NULL, 1, '2019-06-20 15:50:06', NULL, 'system', NULL),
	(3, 10023, 'baishikele', '百事可乐', NULL, 0.00, NULL, 1, '2019-06-20 15:50:33', NULL, 'system', NULL);
/*!40000 ALTER TABLE `g_item` ENABLE KEYS */;

-- Dumping structure for table ms_goods.g_sku
CREATE TABLE IF NOT EXISTS `g_sku` (
  `sku_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ca_id` int(11) NOT NULL COMMENT '分类id',
  `spu_id` int(11) NOT NULL DEFAULT '0' COMMENT 'spuid',
  `sku_code` varchar(30) DEFAULT NULL COMMENT '商品代码',
  `sku_name` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `description` varchar(300) DEFAULT NULL COMMENT '描述',
  `retail_price` decimal(12,2) DEFAULT '0.00' COMMENT '建议零售价',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态 1:正常 0:删除',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `created_user` varchar(30) NOT NULL COMMENT '创建人',
  `updated_user` varchar(30) DEFAULT NULL COMMENT '最后更改人',
  PRIMARY KEY (`sku_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- Dumping data for table ms_goods.g_sku: ~0 rows (大约)
/*!40000 ALTER TABLE `g_sku` DISABLE KEYS */;
/*!40000 ALTER TABLE `g_sku` ENABLE KEYS */;

-- Dumping structure for table ms_goods.g_sku_attr
CREATE TABLE IF NOT EXISTS `g_sku_attr` (
  `sa_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sku_id` int(11) NOT NULL COMMENT 'skuid',
  `attr_code` varchar(50) NOT NULL COMMENT '属性code,ca_id-cav_id',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `created_user` varchar(30) NOT NULL COMMENT '创建人',
  `updated_user` varchar(30) DEFAULT NULL COMMENT '最后更改人',
  PRIMARY KEY (`sa_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品属性表';

-- Dumping data for table ms_goods.g_sku_attr: ~0 rows (大约)
/*!40000 ALTER TABLE `g_sku_attr` DISABLE KEYS */;
/*!40000 ALTER TABLE `g_sku_attr` ENABLE KEYS */;


-- Dumping database structure for ms_system
CREATE DATABASE IF NOT EXISTS `ms_system` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ms_system`;

-- Dumping structure for table ms_system.sys_dictionary
CREATE TABLE IF NOT EXISTS `sys_dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(50) NOT NULL DEFAULT '' COMMENT '分类code',
  `item_code` varchar(50) NOT NULL COMMENT '条目code',
  `item_value` varchar(50) NOT NULL COMMENT '条目值',
  `description` varchar(300) DEFAULT NULL COMMENT '描述',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态 1:正常 0:删除',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `created_user` varchar(30) NOT NULL COMMENT '创建人',
  `updated_user` varchar(30) DEFAULT NULL COMMENT '最后更改人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_dictionary_1` (`code`,`item_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=utf8 COMMENT='数据字典表';

-- Dumping data for table ms_system.sys_dictionary: ~5 rows (大约)
/*!40000 ALTER TABLE `sys_dictionary` DISABLE KEYS */;
INSERT INTO `sys_dictionary` (`id`, `code`, `item_code`, `item_value`, `description`, `status`, `created_time`, `updated_time`, `created_user`, `updated_user`) VALUES
	(1000, 'attr_type', '1', '关键属性', NULL, 1, '2019-06-12 15:23:49', '2019-06-12 15:42:22', 'system', NULL),
	(1001, 'attr_type', '2', '销售属性', NULL, 1, '2019-06-12 15:24:09', '2019-06-12 15:42:27', 'system', NULL),
	(1002, 'attr_type', '3', '其他属性', NULL, 1, '2019-06-12 15:24:37', '2019-06-12 15:42:32', 'system', NULL),
	(1003, 'attr_selected', '1', '是', NULL, 1, '2019-06-12 15:25:05', NULL, 'system', NULL),
	(1004, 'attr_selected', '0', '否', NULL, 1, '2019-06-12 15:25:25', NULL, 'system', NULL);
/*!40000 ALTER TABLE `sys_dictionary` ENABLE KEYS */;


-- Dumping database structure for ms_stock
CREATE DATABASE IF NOT EXISTS `ms_stock` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ms_stock`;

-- Dumping structure for table ms_stock.s_stock
CREATE TABLE IF NOT EXISTS `s_stock` (
  `stock_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `item_id` int(11) NOT NULL COMMENT '商品id',
  `total` int(11) DEFAULT NULL COMMENT '总库存',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`stock_id`),
  UNIQUE KEY `idx_stock_1` (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='库存表';

-- Dumping data for table ms_stock.s_stock: ~2 rows (大约)
/*!40000 ALTER TABLE `s_stock` DISABLE KEYS */;
INSERT INTO `s_stock` (`stock_id`, `item_id`, `total`, `created_time`, `updated_time`) VALUES
	(1, 1, 11, '2019-06-20 11:43:54', NULL),
	(2, 2, 12, '2019-06-20 11:44:05', NULL);
/*!40000 ALTER TABLE `s_stock` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
