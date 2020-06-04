DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `user_id` bigint(20) NOT NULL COMMENT '用户id',
                        `user_name` varchar(255) DEFAULT '' COMMENT '用户名称',
                        `user_phone` varchar(50) DEFAULT '' COMMENT '用户手机',
                        `address` varchar(255) DEFAULT '' COMMENT '住址',
                        `weight` int(3) NOT NULL DEFAULT '1' COMMENT '权重，大者优先',
                        `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                        PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` VALUES ('1196978513958141952', '测试1', '18826334748', '广州市海珠区', '1', '2019-11-20 10:28:51', '2019-11-22 14:28:26');
INSERT INTO `user` VALUES ('1196978513958141953', '测试2', '18826274230', '广州市天河区', '2', '2019-11-20 10:29:37', '2019-11-22 14:28:14');
INSERT INTO `user` VALUES ('1196978513958141954', '测试3', '18826273900', '广州市天河区', '1', '2019-11-20 10:30:19', '2019-11-22 14:28:30');