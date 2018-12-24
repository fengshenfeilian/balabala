-- phpMyAdmin SQL Dump
-- version 4.4.15.7
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2018-12-24 12:48:53
-- 服务器版本： 10.1.16-MariaDB
-- PHP Version: 5.3.29-upupw

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ruangong`
--

-- --------------------------------------------------------

--
-- 表的结构 `assignment`
--

CREATE TABLE IF NOT EXISTS `assignment` (
  `ASSIGNMENT_ID` varchar(11) NOT NULL,
  `TITLE` varchar(50) NOT NULL DEFAULT 'default_title',
  `BODY` varchar(255) NOT NULL DEFAULT 'default_body',
  `COURSE_ID` int(10) NOT NULL,
  `RELEASE_TIME` datetime DEFAULT NULL,
  `DEADLINE` datetime DEFAULT NULL,
  `PERCENT` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `assignment`
--

INSERT INTO `assignment` (`ASSIGNMENT_ID`, `TITLE`, `BODY`, `COURSE_ID`, `RELEASE_TIME`, `DEADLINE`, `PERCENT`) VALUES
('40', '软件开发计划', '给出软件开发计划', 4, '2018-12-15 15:16:19', '2018-12-25 00:00:00', 10),
('41', '第一次验收', '无', 4, '2018-12-15 15:32:36', '2018-12-25 00:00:00', 20);

-- --------------------------------------------------------

--
-- 表的结构 `course`
--

CREATE TABLE IF NOT EXISTS `course` (
  `COURSE_ID` int(10) NOT NULL,
  `COURSE_NAME` varchar(40) NOT NULL,
  `COURSE_DESCRIPTION` varchar(80) NOT NULL,
  `TEACHER_ID` varchar(10) NOT NULL,
  `GROUP_CAPACITY_MIN` int(3) NOT NULL DEFAULT '1',
  `GROUP_CAPACITY_MAX` int(3) NOT NULL DEFAULT '5',
  `GROUP_PREFIX` varchar(30) DEFAULT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `IS_END` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `course`
--

INSERT INTO `course` (`COURSE_ID`, `COURSE_NAME`, `COURSE_DESCRIPTION`, `TEACHER_ID`, `GROUP_CAPACITY_MIN`, `GROUP_CAPACITY_MAX`, `GROUP_PREFIX`, `CREATE_TIME`, `IS_END`) VALUES
(4, '软件工程实践', '无', '199001255', 3, 5, '4-201804', '2018-12-15 14:57:46', 1),
(5, '现代通信网', '介绍现代通信网', '199001255', 1, 5, '5-20182', '2018-09-01 00:00:00', 0);

-- --------------------------------------------------------

--
-- 表的结构 `group_assignment`
--

CREATE TABLE IF NOT EXISTS `group_assignment` (
  `ASSIGNMENT_ID` varchar(11) NOT NULL,
  `GROUP_ID` varchar(30) NOT NULL,
  `TITLE` varchar(255) DEFAULT NULL,
  `BODY` varchar(255) DEFAULT NULL,
  `SUBMISSION_TIME` datetime DEFAULT NULL,
  `SCORE` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `group_course`
--

CREATE TABLE IF NOT EXISTS `group_course` (
  `GROUP_ID` varchar(30) NOT NULL,
  `COURSE_ID` int(10) NOT NULL,
  `GROUP_NAME` varchar(20) DEFAULT NULL,
  `GROUP_MEMBER_NUM` int(11) NOT NULL,
  `LEADER_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `group_student`
--

CREATE TABLE IF NOT EXISTS `group_student` (
  `GROUP_ID` varchar(30) NOT NULL,
  `STUDENT_ID` varchar(10) NOT NULL,
  `GRADE` int(3) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `privelege`
--

CREATE TABLE IF NOT EXISTS `privelege` (
  `PRI_ID` varchar(11) NOT NULL,
  `NAME` varchar(30) NOT NULL,
  `DESCRIPTION` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `privelege`
--

INSERT INTO `privelege` (`PRI_ID`, `NAME`, `DESCRIPTION`) VALUES
('UC1', '更新个人信息', NULL),
('UC11', '设置课程', NULL),
('UC12', '设置学生名单', NULL),
('UC14', '设置小组配置', NULL),
('UC15', '设置作业', NULL),
('UC16', '作业检查', NULL),
('UC17', '生成成绩', NULL),
('UC19', '查看学生名单', NULL),
('UC31', '查看课程信息', NULL),
('UC32', '查看作业信息', NULL),
('UC33', '创建及管理小组', NULL),
('UC34', '提交作业', NULL),
('UC35', '重复提交', NULL),
('UC36', '查看成绩', NULL),
('UC41', '用户导入', NULL),
('UC42', '用户管理', NULL);

-- --------------------------------------------------------

--
-- 表的结构 `pri_role`
--

CREATE TABLE IF NOT EXISTS `pri_role` (
  `ROLE_ID` varchar(11) NOT NULL,
  `PRI_ID` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `pri_role`
--

INSERT INTO `pri_role` (`ROLE_ID`, `PRI_ID`) VALUES
('1', 'UC1'),
('1', 'UC41'),
('1', 'UC42'),
('2', 'UC1'),
('2', 'UC11'),
('2', 'UC12'),
('2', 'UC14'),
('2', 'UC15'),
('2', 'UC16'),
('2', 'UC17'),
('2', 'UC19'),
('3', 'UC1'),
('3', 'UC31'),
('3', 'UC32'),
('3', 'UC33'),
('3', 'UC34'),
('3', 'UC35'),
('3', 'UC36');

-- --------------------------------------------------------

--
-- 表的结构 `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `ROLE_ID` varchar(11) NOT NULL,
  `NAME` varchar(30) NOT NULL,
  `DESCRIPTION` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `role`
--

INSERT INTO `role` (`ROLE_ID`, `NAME`, `DESCRIPTION`) VALUES
('1', 'admin', '管理员'),
('2', 'teacher', '老师'),
('3', 'student', '学生');

-- --------------------------------------------------------

--
-- 表的结构 `student_course`
--

CREATE TABLE IF NOT EXISTS `student_course` (
  `STUDENT_ID` varchar(10) NOT NULL,
  `COURSE_ID` int(10) NOT NULL,
  `ASSIGNMENT_GRADE` int(11) NOT NULL DEFAULT '0',
  `DAILY_GRADE` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `student_course`
--

INSERT INTO `student_course` (`STUDENT_ID`, `COURSE_ID`, `ASSIGNMENT_GRADE`, `DAILY_GRADE`) VALUES
('2015211232', 4, 4, 100),
('2015211242', 4, 4, 0);

-- --------------------------------------------------------

--
-- 表的结构 `user_role`
--

CREATE TABLE IF NOT EXISTS `user_role` (
  `USER_ID` varchar(11) NOT NULL,
  `ROLE_ID` varchar(11) DEFAULT NULL,
  `PASSWORD` varchar(100) NOT NULL DEFAULT 'ruangong',
  `USER_NAME` varchar(10) NOT NULL,
  `GENDER` varchar(20) NOT NULL,
  `EMAIL` varchar(20) DEFAULT NULL,
  `DEPARTMENT` varchar(30) DEFAULT NULL,
  `MAJOR` varchar(30) DEFAULT NULL,
  `CLASSES` varchar(30) DEFAULT NULL,
  `PWD_DEFAULT` int(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user_role`
--

INSERT INTO `user_role` (`USER_ID`, `ROLE_ID`, `PASSWORD`, `USER_NAME`, `GENDER`, `EMAIL`, `DEPARTMENT`, `MAJOR`, `CLASSES`, `PWD_DEFAULT`) VALUES
('199001255', '2', 'cdf6544f8f1043477cf8257baff76353', '张老师', '女', 'test123@qq.com', '计算机', NULL, NULL, 1),
('2014211232', '3', 'e74aed0bcfb66ed5a44cb1c1f20bca28', '张三', '男', '111@qq.com', '计算机', '计算机科学与技术', '2015211333', 0),
('2015211232', '3', 'e10adc3949ba59abbe56e057f20f883e', '郭子晖', '男', 'test2@qq.com', '计算机', '计算机科学与技术', '2015211304', 0),
('2015211242', '3', 'e10adc3949ba59abbe56e057f20f883e', '古同学', '男', '', '计算机', '计算机', '2015211304', 0),
('2015211255', '3', '4db09faf87cfca9e4d3a6124adfee1bf', '王年', '女', '', '计算机', '计算机', '2015211304', 1),
('2015211303', '3', '74058fad5eebc032f067f05241d5a54d', '张盐城', '男', '', '计算机', '计算机', '2015211304', 1),
('admin', '1', 'e10adc3949ba59abbe56e057f20f883e', 'admin', '男', NULL, NULL, NULL, NULL, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assignment`
--
ALTER TABLE `assignment`
  ADD PRIMARY KEY (`ASSIGNMENT_ID`),
  ADD KEY `COURSE_ID` (`COURSE_ID`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`COURSE_ID`),
  ADD KEY `TEACHER_ID` (`TEACHER_ID`);

--
-- Indexes for table `group_assignment`
--
ALTER TABLE `group_assignment`
  ADD PRIMARY KEY (`ASSIGNMENT_ID`,`GROUP_ID`),
  ADD KEY `GROUP_ID` (`GROUP_ID`);

--
-- Indexes for table `group_course`
--
ALTER TABLE `group_course`
  ADD PRIMARY KEY (`GROUP_ID`),
  ADD KEY `COURSE_ID` (`COURSE_ID`),
  ADD KEY `LEADER_ID` (`LEADER_ID`);

--
-- Indexes for table `group_student`
--
ALTER TABLE `group_student`
  ADD PRIMARY KEY (`GROUP_ID`,`STUDENT_ID`),
  ADD KEY `STUDENT_ID` (`STUDENT_ID`);

--
-- Indexes for table `privelege`
--
ALTER TABLE `privelege`
  ADD PRIMARY KEY (`PRI_ID`);

--
-- Indexes for table `pri_role`
--
ALTER TABLE `pri_role`
  ADD PRIMARY KEY (`ROLE_ID`,`PRI_ID`),
  ADD KEY `pri_role_ibfk_2` (`PRI_ID`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`ROLE_ID`);

--
-- Indexes for table `student_course`
--
ALTER TABLE `student_course`
  ADD PRIMARY KEY (`STUDENT_ID`,`COURSE_ID`),
  ADD KEY `student_course_ibfk_2` (`COURSE_ID`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`USER_ID`),
  ADD KEY `ROLE_ID` (`ROLE_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `COURSE_ID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
