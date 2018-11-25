-- phpMyAdmin SQL Dump
-- version 4.4.15.7
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2018-11-22 19:12:47
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
  `TEACHER_ID` varchar(10) NOT NULL,
  `CAPACITY` int(3) NOT NULL,
  `CREATE_TIME` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `group_assignment`
--

CREATE TABLE IF NOT EXISTS `group_assignment` (
  `ASSIGNMENT_ID` varchar(11) NOT NULL,
  `GROUP_ID` int(10) NOT NULL,
  `TITLE` varchar(50) NOT NULL DEFAULT 'default_title',
  `BODY` varchar(255) NOT NULL DEFAULT 'default_body',
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
  `CAPACITY_MIN` int(3) NOT NULL DEFAULT '1',
  `CAPACITY_MAX` int(3) NOT NULL DEFAULT '5',
  `NAME` varchar(20) DEFAULT NULL,
  `LEADER_ID` varchar(10) DEFAULT NULL,
  `IS_CREATED` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `group_student`
--

CREATE TABLE IF NOT EXISTS `group_student` (
  `GROUP_ID` int(10) NOT NULL,
  `STUDENT_ID` varchar(10) NOT NULL,
  `GRADE` int(3) DEFAULT NULL
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
  `TOTAL_GRADE` int(3) DEFAULT NULL
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
  `GENDER` varchar(1) NOT NULL,
  `EMAIL` varchar(20) DEFAULT NULL,
  `FIRST_LOGIN` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user_role`
--

INSERT INTO `user_role` (`USER_ID`, `ROLE_ID`, `PASSWORD`, `USER_NAME`, `GENDER`, `EMAIL`, `FIRST_LOGIN`) VALUES
('1', '1', '111', 'root', '', '', 0),
('2', '2', '222', 'laoshi', '', '', 0),
('3', '3', '333', 'xiaoming', '', 'bbb', 0),
('4', '2', '444', 'test', '', 'bbb', 0);

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
--
-- AUTO_INCREMENT for table `group_course`
--
ALTER TABLE `group_course`
  MODIFY `GROUP_ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- 限制导出的表
--

--
-- 限制表 `assignment`
--
ALTER TABLE `assignment`
  ADD CONSTRAINT `assignment_ibfk_1` FOREIGN KEY (`COURSE_ID`) REFERENCES `course` (`COURSE_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `course_ibfk_1` FOREIGN KEY (`TEACHER_ID`) REFERENCES `user_role` (`USER_ID`);

--
-- 限制表 `group_assignment`
--
ALTER TABLE `group_assignment`
  ADD CONSTRAINT `group_assignment_ibfk_1` FOREIGN KEY (`ASSIGNMENT_ID`) REFERENCES `assignment` (`ASSIGNMENT_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `group_assignment_ibfk_2` FOREIGN KEY (`GROUP_ID`) REFERENCES `group_course` (`GROUP_ID`);

--
-- 限制表 `group_course`
--
ALTER TABLE `group_course`
  ADD CONSTRAINT `group_course_ibfk_1` FOREIGN KEY (`COURSE_ID`) REFERENCES `course` (`COURSE_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `group_course_ibfk_2` FOREIGN KEY (`LEADER_ID`) REFERENCES `user_role` (`USER_ID`);

--
-- 限制表 `group_student`
--
ALTER TABLE `group_student`
  ADD CONSTRAINT `group_student_ibfk_1` FOREIGN KEY (`GROUP_ID`) REFERENCES `group_course` (`GROUP_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `group_student_ibfk_2` FOREIGN KEY (`STUDENT_ID`) REFERENCES `user_role` (`USER_ID`);

--
-- 限制表 `pri_role`
--
ALTER TABLE `pri_role`
  ADD CONSTRAINT `pri_role_ibfk_1` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pri_role_ibfk_2` FOREIGN KEY (`PRI_ID`) REFERENCES `privelege` (`PRI_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `student_course`
--
ALTER TABLE `student_course`
  ADD CONSTRAINT `student_course_ibfk_2` FOREIGN KEY (`COURSE_ID`) REFERENCES `course` (`COURSE_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `student_course_ibfk_3` FOREIGN KEY (`STUDENT_ID`) REFERENCES `user_role` (`USER_ID`);

--
-- 限制表 `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
