/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : lostfound

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 20/06/2021 10:22:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `post_id` bigint(20) NOT NULL COMMENT '贴子ID',
  `uname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论人',
  `content` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `ctime` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
  `parent` bigint(20) NULL DEFAULT NULL COMMENT '是否有父评论',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `comment_ibfk_1`(`post_id`) USING BTREE,
  INDEX `comment_ibfk_2`(`uname`) USING BTREE,
  INDEX `parent_comment`(`parent`) USING BTREE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 75 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (68, 45, 'kappy', '这个黑大头是什么呢', '2021-01-16 07:44:25', NULL);
INSERT INTO `comment` VALUES (69, 45, 'kappy', '我也不知道，看着很古董', '2021-01-16 07:44:42', NULL);
INSERT INTO `comment` VALUES (70, 45, 'kappy', '老式电话', '2021-01-16 07:44:56', 68);
INSERT INTO `comment` VALUES (71, 44, 'kappy', '的首发式地方', '2021-06-17 10:52:29', NULL);
INSERT INTO `comment` VALUES (72, 44, 'kappy', '哈哈哈哈哈哈哈哈哈', '2021-06-17 10:54:19', NULL);
INSERT INTO `comment` VALUES (73, 44, 'kappy', '周晓鸥出继续', '2021-06-17 10:55:09', NULL);
INSERT INTO `comment` VALUES (74, 44, 'kappy', '微软犬瘟热', '2021-06-17 10:55:26', 73);

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '反馈用户',
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '反馈标题',
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '反馈内容',
  `ctime` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uname`(`uname`) USING BTREE,
  CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`uname`) REFERENCES `user` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES (1, 'kappy', '好人', '处理', '2020-12-01 11:57:18');
INSERT INTO `feedback` VALUES (3, 'kappy', '测试反馈', '看下有什么问题', '2020-12-21 03:42:25');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cuser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `ctime` datetime(0) NOT NULL COMMENT '创建时间',
  `title` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '通知标题',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `admin_fk`(`cuser`) USING BTREE,
  CONSTRAINT `admin_fk` FOREIGN KEY (`cuser`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (8, 'kappy', '感谢大家的相互帮助', '2020-12-16 01:50:31', '乐于助人');

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发帖人',
  `type_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类',
  `title` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `address` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `ctime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态：1为进行中，0为结束',
  `flag` int(11) NULL DEFAULT NULL COMMENT '标记：1为失物招领，0为寻物启事',
  `view_count` int(11) NULL DEFAULT NULL COMMENT '查看次数',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `post_ibfk_1`(`uname`) USING BTREE,
  INDEX `psot_fk`(`type_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '1为失物招领，0为寻物启事' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (44, 'kappy', '衣服', '我捡到了卡片', '我捡到了卡片', '/images/b4488e75d6f9464e9b991b26e42ae18c_1.png', '我捡到了卡片', '2021-01-12 15:16:49', 1, 1, 51);
INSERT INTO `post` VALUES (45, 'kappy', '手机', '我的手机在餐厅不见了', '今天中午吃饭后，手机忘了，黑色的，谁见了给我下', '/images/4ad0fd9075c9422084cfffb26881b536_shouji.png', '餐厅', '2021-01-16 07:26:38', 0, 0, 14);
INSERT INTO `post` VALUES (47, 'kappy', '校园卡', 'h1, h2, h3, h4, h5, h6', '', '/images/5ae67d9f0a8c4cd390e2da4358385576_头像压缩.jpg', '青山湖区蛟桥镇庐山中大道888号', '2021-06-17 16:22:48', 1, 1, 2);
INSERT INTO `post` VALUES (50, 'kappy', '校园卡', 'ads', 'asdfasfas', '/images/e8996fde2d11432b95613698cfa3b476_头像压缩.jpg', '青山湖区蛟桥镇庐山中大道888号', '2021-06-20 01:36:35', 1, 0, 0);

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `type_name`(`type_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (3, '手机');
INSERT INTO `type` VALUES (1, '校园卡');
INSERT INTO `type` VALUES (2, '衣服');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'email',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `photo` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `reward_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '打赏码',
  `personal_say` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  `last_time` datetime(0) NULL DEFAULT NULL COMMENT '上一次登录',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型 0 普通 1 管理员',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (22, 'true', 'kappy', 'c4ca4238a0b923820dcc509a6f75849b', '490151517@qq.com', '女', 21, '/images/e54ea210109c4ced9df74ded7c4aeb35_头像压缩.jpg', '/images/320573054bda4c42b618d0f838efa4c6_erwei.png', '在哪里', '2021-01-07 01:46:34', 1);
INSERT INTO `user` VALUES (27, NULL, 'admin', 'c4ca4238a0b923820dcc509a6f75849b', 'admin@126.com', '男', 18, '/images/e54ea210109c4ced9df74ded7c4aeb35_头像压缩.jpg', '/images/6721681d257d426484d34bcc9426ae40_微信.jpg', '21312', '2021-02-18 03:54:05', 0);

SET FOREIGN_KEY_CHECKS = 1;
