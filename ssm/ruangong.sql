-- phpMyAdmin SQL Dump
-- version 4.4.15.7
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2018-12-01 11:35:57
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
  `GROUP_PREFIX` int(11) DEFAULT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `IS_END` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `group_assignment`
--

CREATE TABLE IF NOT EXISTS `group_assignment` (
  `ASSIGNMENT_ID` varchar(11) NOT NULL,
  `GROUP_ID` int(10) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `PATH` varchar(255) DEFAULT NULL,
  `SUBMISSION_TIME` datetime DEFAULT NULL,
  `SCORE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `group_course`
--

CREATE TABLE IF NOT EXISTS `group_course` (
  `GROUP_ID` int(10) NOT NULL,
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
  `GROUP_ID` int(10) NOT NULL,
  `STUDENT_ID` varchar(10) NOT NULL,
  `GRADE` int(3) DEFAULT '100'
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

-- --------------------------------------------------------

--
-- 表的结构 `pri_role`
--

CREATE TABLE IF NOT EXISTS `pri_role` (
  `ROLE_ID` varchar(11) NOT NULL,
  `PRI_ID` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `ASSIGNMENT_GRADE` int(11) DEFAULT '0',
  `DAILY_GRADE` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `user_role`
--

CREATE TABLE IF NOT EXISTS `user_role` (
  `USER_ID` varchar(11) NOT NULL,
  `ROLE_ID` varchar(11) DEFAULT NULL,
  `PASSWORD` varchar(40) NOT NULL DEFAULT 'ruangong',
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
('2014211232', '3', '2014211232', '无', '男', '无', '计算机', '计算机科学与技术', '2015211333', 0),
('2015211232', '3', '2015211232', '郭子晖', '男', '无', '计算机', '计算机科学与技术', '2015211304', 0),
('4', '3', '444', 'test', '男', 'aaaa', NULL, NULL, '2015211304', 1),
('5', '1', '555', '111', '男', NULL, NULL, NULL, NULL, 1);

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
  MODIFY `COURSE_ID` int(10) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
