/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : rbac

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 28/11/2022 11:54:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (2, '人力资源部', 'Human Resources Department');
INSERT INTO `department` VALUES (3, '采购部', 'Order Department');
INSERT INTO `department` VALUES (4, '仓储部', 'Warehousing Department');
INSERT INTO `department` VALUES (5, '财务部', 'Finance Department');
INSERT INTO `department` VALUES (6, '技术部', 'Technolog Department ');
INSERT INTO `department` VALUES (39, '学习部', 'Learning Department');
INSERT INTO `department` VALUES (43, 'zar', 'Technolog Department');
INSERT INTO `department` VALUES (46, 'tomran', 'banlandengsi');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT NULL,
  `admin` bit(1) NULL DEFAULT NULL,
  `dept_id` bigint(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, 'admin', '1', 'admin@abc.com', 20, b'1', 2);
INSERT INTO `employee` VALUES (2, '赵总', '1', 'zhaoz@wolfcode.cn', 35, b'0', 2);
INSERT INTO `employee` VALUES (3, '赵一明', 'c4ca4238a0b923820dcc509a6f75849b', 'zhaoym@wolfcode.cn', 25, b'0', 2);
INSERT INTO `employee` VALUES (4, '钱总', 'c4ca4238a0b923820dcc509a6f75849b', 'qianz@wolfcode.cn', 35, b'0', 2);
INSERT INTO `employee` VALUES (5, '钱二明', 'c4ca4238a0b923820dcc509a6f75849b', 'qianem@wolfcode.cn', 25, b'0', 2);
INSERT INTO `employee` VALUES (6, '孙总', 'c4ca4238a0b923820dcc509a6f75849b', 'sunz@wolfcode.cn', 35, b'0', 3);
INSERT INTO `employee` VALUES (7, '孙三明', 'c4ca4238a0b923820dcc509a6f75849b', 'sunsm@wolfcode.cn', 25, b'0', 3);
INSERT INTO `employee` VALUES (8, '李总', 'c4ca4238a0b923820dcc509a6f75849b', 'liz@wolfcode.cn', 35, b'0', 4);
INSERT INTO `employee` VALUES (9, '李四明', 'c4ca4238a0b923820dcc509a6f75849b', 'lism@wolfcode.cn', 25, b'0', 4);
INSERT INTO `employee` VALUES (10, '周总', 'c4ca4238a0b923820dcc509a6f75849b', 'zhouz@wolfcode.cn', 35, b'0', 5);
INSERT INTO `employee` VALUES (11, '周五明', 'c4ca4238a0b923820dcc509a6f75849b', 'zhouwm@wolfcode.cn', 25, b'0', 5);
INSERT INTO `employee` VALUES (12, '吴总', 'c4ca4238a0b923820dcc509a6f75849b', 'wuz@wolfcode.cn', 35, b'0', 6);
INSERT INTO `employee` VALUES (13, '吴六明', 'c4ca4238a0b923820dcc509a6f75849b', 'wulm@wolfcode.cn', 25, b'0', 6);
INSERT INTO `employee` VALUES (14, '郑总', 'c4ca4238a0b923820dcc509a6f75849b', 'zhengz@wolfcode.cn', 35, b'0', 7);
INSERT INTO `employee` VALUES (15, '郑七明', 'c4ca4238a0b923820dcc509a6f75849b', 'zhengqm@wolfcode.cn', 25, b'0', 7);
INSERT INTO `employee` VALUES (16, '孙四明', 'c4ca4238a0b923820dcc509a6f75849b', 'sunsim@wolfcode.cn', 25, b'0', 3);
INSERT INTO `employee` VALUES (17, '孙五明', 'c4ca4238a0b923820dcc509a6f75849b', 'sunwm@wolfcode.cn', 25, b'0', 3);
INSERT INTO `employee` VALUES (18, '李五明', 'c4ca4238a0b923820dcc509a6f75849b', 'liwm@wolfcode.cn', 25, b'0', 4);
INSERT INTO `employee` VALUES (19, '李六明', 'c4ca4238a0b923820dcc509a6f75849b', 'lilm@wolfcode.cn', 25, b'0', 2);
INSERT INTO `employee` VALUES (20, 'tomran', '123', '431112652@qq.com', 12, b'0', 39);
INSERT INTO `employee` VALUES (21, '1234', '1234', '431112652@qq.com', 12, b'0', 2);
INSERT INTO `employee` VALUES (22, 'zar', '123', '431112652@qq.com', 12, b'0', 4);
INSERT INTO `employee` VALUES (26, 'te', '12345', '431112652@qq.com', 12, b'1', 2);

-- ----------------------------
-- Table structure for employee_role
-- ----------------------------
DROP TABLE IF EXISTS `employee_role`;
CREATE TABLE `employee_role`  (
  `employee_id` bigint(0) NULL DEFAULT NULL,
  `role_id` bigint(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee_role
-- ----------------------------
INSERT INTO `employee_role` VALUES (22, 4);
INSERT INTO `employee_role` VALUES (21, 2);
INSERT INTO `employee_role` VALUES (21, 3);
INSERT INTO `employee_role` VALUES (21, 12);
INSERT INTO `employee_role` VALUES (22, 2);
INSERT INTO `employee_role` VALUES (26, 2);
INSERT INTO `employee_role` VALUES (26, 21);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `expression` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '部门删除', 'department:delete');
INSERT INTO `permission` VALUES (2, '部门列表', 'department:list');
INSERT INTO `permission` VALUES (3, '部门编辑', 'department:input');
INSERT INTO `permission` VALUES (4, '部门保存或更新', 'department:saveOrUpdate');
INSERT INTO `permission` VALUES (5, '员工删除', 'employee:delete');
INSERT INTO `permission` VALUES (6, '员工列表', 'employee:list');
INSERT INTO `permission` VALUES (7, '员工编辑', 'employee:input');
INSERT INTO `permission` VALUES (8, '员工保存或更新', 'employee:saveOrUpdate');
INSERT INTO `permission` VALUES (9, '权限列表', 'permission:list');
INSERT INTO `permission` VALUES (10, '权限加载', 'permission:reload');
INSERT INTO `permission` VALUES (11, '角色删除', 'role:delete');
INSERT INTO `permission` VALUES (12, '角色列表', 'role:list');
INSERT INTO `permission` VALUES (13, '角色编辑', 'role:input');
INSERT INTO `permission` VALUES (14, '角色保存或更新', 'role:saveOrUpdate');
INSERT INTO `permission` VALUES (15, '权限删除', 'permission:delete');
INSERT INTO `permission` VALUES (17, '删库跑路', 'run:delete');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '人事管理', 'HR_MGR');
INSERT INTO `role` VALUES (2, '采购管理', 'ORDER_MGR');
INSERT INTO `role` VALUES (3, '仓储管理', 'WAREHOUSING_MGR');
INSERT INTO `role` VALUES (4, '行政部管理', 'Admin_MGR');
INSERT INTO `role` VALUES (11, '市场经理', 'Market_Manager');
INSERT INTO `role` VALUES (12, '市场专员', 'Market');
INSERT INTO `role` VALUES (21, 'tomran', 'Learning');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `role_id` bigint(0) NULL DEFAULT NULL,
  `permission_id` bigint(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (1, 6);
INSERT INTO `role_permission` VALUES (1, 7);
INSERT INTO `role_permission` VALUES (1, 8);
INSERT INTO `role_permission` VALUES (1, 11);
INSERT INTO `role_permission` VALUES (13, 14);
INSERT INTO `role_permission` VALUES (21, 1);

SET FOREIGN_KEY_CHECKS = 1;
