/*
 Navicat Premium Data Transfer

 Source Server         : tong
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : db_tlibrary

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 15/04/2018 22:27:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(30) UNSIGNED NOT NULL AUTO_INCREMENT,
  `admin_no` int(30) UNSIGNED NOT NULL,
  `admin_psw` int(30) NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 123, 123);

-- ----------------------------
-- Table structure for back
-- ----------------------------
DROP TABLE IF EXISTS `back`;
CREATE TABLE `back`  (
  `back_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ISBN` int(30) UNSIGNED NOT NULL,
  `book_name` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `reader_no` int(30) UNSIGNED NULL DEFAULT NULL,
  `reader_tel` varchar(11) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `return_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`back_id`) USING BTREE,
  INDEX `reader_no`(`reader_no`) USING BTREE,
  INDEX `borrow_ibfk_2`(`ISBN`) USING BTREE,
  CONSTRAINT `back_ibfk_1` FOREIGN KEY (`reader_no`) REFERENCES `reader` (`reader_no`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `back_ibfk_2` FOREIGN KEY (`back_id`) REFERENCES `borrow` (`borrow_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `ISBN` int(30) UNSIGNED NOT NULL,
  `book_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_author` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `book_publisher` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `book_quantity` int(30) UNSIGNED NOT NULL,
  `book_issued` int(30) UNSIGNED NOT NULL,
  INDEX `ISBN`(`ISBN`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (2, 'we', 'we', NULL, 7, 8);
INSERT INTO `book` VALUES (3, 'w', 'w', NULL, 1, 3);
INSERT INTO `book` VALUES (4, 'e', 'e', 'e', 3, 3);

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow`  (
  `borrow_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ISBN` int(30) UNSIGNED NOT NULL,
  `book_name` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `reader_no` int(30) UNSIGNED NULL DEFAULT NULL,
  `reader_tel` varchar(11) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `borrow_date` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`borrow_id`) USING BTREE,
  INDEX `reader_no`(`reader_no`) USING BTREE,
  INDEX `borrow_ibfk_2`(`ISBN`) USING BTREE,
  CONSTRAINT `borrow_ibfk_1` FOREIGN KEY (`reader_no`) REFERENCES `reader` (`reader_no`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `borrow_ibfk_2` FOREIGN KEY (`ISBN`) REFERENCES `book` (`ISBN`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1273 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES (6, 3, 'w', 1, '1', '2018-04-14 22:23:55');
INSERT INTO `borrow` VALUES (1262, 2, 'we', 1, '1', NULL);
INSERT INTO `borrow` VALUES (1267, 2, 'we', 1, '1', '2018-04-15 03:08:58');
INSERT INTO `borrow` VALUES (1268, 2, 'we', 1, '1', NULL);
INSERT INTO `borrow` VALUES (1269, 2, 'we', 1, '1', '2018-04-15 00:00:00');
INSERT INTO `borrow` VALUES (1272, 3, 'w', 1, '1', '2018-04-15 00:00:00');

-- ----------------------------
-- Table structure for reader
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader`  (
  `reader_id` int(30) UNSIGNED NOT NULL AUTO_INCREMENT,
  `reader_no` int(30) UNSIGNED NOT NULL,
  `reader_psw` int(50) NULL DEFAULT NULL,
  `reader_name` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `reader_tel` varchar(11) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`reader_id`) USING BTREE,
  INDEX `reader_no`(`reader_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES (1, 1, 1, '1', '1');
INSERT INTO `reader` VALUES (2, 2, 2, '2', '2');
INSERT INTO `reader` VALUES (3, 3, 3, NULL, NULL);
INSERT INTO `reader` VALUES (4, 4, 4, NULL, NULL);
INSERT INTO `reader` VALUES (5, 7, 7, NULL, NULL);

-- ----------------------------
-- Table structure for return
-- ----------------------------
DROP TABLE IF EXISTS `return`;
CREATE TABLE `return`  (
  `borrow_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ISBN` int(30) UNSIGNED NOT NULL,
  `book_name` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `reader_no` int(30) UNSIGNED NULL DEFAULT NULL,
  `reader_tel` varchar(11) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `admin_no` int(11) NULL DEFAULT NULL,
  `borrow_date` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`borrow_id`) USING BTREE,
  INDEX `reader_no`(`reader_no`) USING BTREE,
  INDEX `borrow_ibfk_2`(`ISBN`) USING BTREE,
  CONSTRAINT `return_ibfk_1` FOREIGN KEY (`reader_no`) REFERENCES `borrow` (`reader_no`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `return_ibfk_2` FOREIGN KEY (`ISBN`) REFERENCES `borrow` (`ISBN`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1270 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
