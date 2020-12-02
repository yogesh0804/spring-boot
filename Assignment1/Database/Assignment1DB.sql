/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.6.50-log : Database - school
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`school` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `school`;

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_nm` varchar(50) DEFAULT NULL,
  `dept_branch_type` varchar(50) DEFAULT NULL,
  `dt_created` datetime DEFAULT NULL,
  `dt_modif` datetime DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `modif_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `department` */

insert  into `department`(`dept_id`,`dept_nm`,`dept_branch_type`,`dt_created`,`dt_modif`,`created_by`,`modif_by`) values 
(1,'Computer','Science',NULL,NULL,NULL,NULL),
(2,'Mathematics ','Science',NULL,NULL,NULL,NULL),
(3,'History','Arts',NULL,NULL,NULL,NULL),
(4,'Accounts','Commerce',NULL,NULL,NULL,NULL);

/*Table structure for table `mark` */

DROP TABLE IF EXISTS `mark`;

CREATE TABLE `mark` (
  `rec_no` int(11) NOT NULL AUTO_INCREMENT,
  `year` int(11) DEFAULT NULL,
  `mark_stud_id` int(11) DEFAULT NULL,
  `mark_dept_id` int(11) DEFAULT NULL,
  `dt_created` datetime DEFAULT NULL,
  `dt_modif` datetime DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `modif_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`rec_no`),
  KEY `mark_stud_id` (`mark_stud_id`),
  KEY `mark_dept_id` (`mark_dept_id`),
  CONSTRAINT `mark_ibfk_1` FOREIGN KEY (`mark_stud_id`) REFERENCES `student` (`stud_id`),
  CONSTRAINT `mark_ibfk_2` FOREIGN KEY (`mark_dept_id`) REFERENCES `department` (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `mark` */

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `stud_id` int(11) NOT NULL AUTO_INCREMENT,
  `stud_nm` varchar(50) DEFAULT NULL,
  `stud_dob` date DEFAULT NULL,
  `stud_addr` varchar(50) DEFAULT NULL,
  `stud_enr_dt` date DEFAULT NULL,
  `stud_cont_no` varchar(50) DEFAULT NULL,
  `stud_dept_id` int(11) DEFAULT NULL,
  `dt_created` datetime DEFAULT NULL,
  `dt_modif` datetime DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `modif_by` varchar(50) DEFAULT NULL,
  `user_nm` varchar(50) DEFAULT NULL,
  `stud_pass` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`stud_id`),
  KEY `stud_dept_id` (`stud_dept_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`stud_dept_id`) REFERENCES `department` (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `student` */

insert  into `student`(`stud_id`,`stud_nm`,`stud_dob`,`stud_addr`,`stud_enr_dt`,`stud_cont_no`,`stud_dept_id`,`dt_created`,`dt_modif`,`created_by`,`modif_by`,`user_nm`,`stud_pass`) values 
(10,'Yogesh Kurne','1994-10-05','Gangapur','2020-11-27','8408044835',1,'2020-11-27 15:52:15','2020-11-27 15:52:15','Yogesh','Yogesh',NULL,'fFBFKK2Y4oJ2oy0W6q1wLg=='),
(11,'pratik Kadam','1994-09-23','Pune','2020-11-27','9876543210',2,'2020-11-27 15:57:42','2020-11-27 15:57:42','Yogesh','Yogesh',NULL,'fFBFKK2Y4oJ2oy0W6q1wLg=='),
(12,'Vittal Jadhav','1991-03-09','Mumbai','2020-11-27','8976543210',3,'2020-11-27 15:59:03','2020-11-27 15:59:03','Yogesh','Yogesh',NULL,'fFBFKK2Y4oJ2oy0W6q1wLg=='),
(13,'Vency Pandit','1991-03-09','Hyderabad','2020-11-27','8976345210',3,'2020-11-27 16:00:05','2020-11-27 16:00:05','Yogesh','Yogesh',NULL,'fFBFKK2Y4oJ2oy0W6q1wLg=='),
(14,'Rita Rai','1991-03-09','Hyderabad','2020-11-27','8976345210',1,'2020-11-27 16:01:33','2020-11-27 16:01:33','Yogesh','Yogesh',NULL,'fFBFKK2Y4oJ2oy0W6q1wLg=='),
(15,'Rushi Kurne','1999-01-01','Vaijapur','2020-11-27','9876543210',3,'2020-11-27 17:51:10','2020-11-27 17:51:10','Yogesh','Yogesh','Rushi007@gmail.com','fFBFKK2Y4oJ2oy0W6q1wLg==');

/*Table structure for table `subject` */

DROP TABLE IF EXISTS `subject`;

CREATE TABLE `subject` (
  `sub_id` int(11) NOT NULL AUTO_INCREMENT,
  `sub_name` varchar(50) DEFAULT NULL,
  `sub_total_mark` int(11) DEFAULT '100',
  `subject_dept_id` int(11) DEFAULT NULL,
  `dt_created` datetime DEFAULT NULL,
  `dt_modif` datetime DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `modif_by` varchar(50) DEFAULT NULL,
  `sub_obt_mark` int(11) DEFAULT NULL,
  PRIMARY KEY (`sub_id`),
  KEY `subject_dept_id` (`subject_dept_id`),
  CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`subject_dept_id`) REFERENCES `department` (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `subject` */

insert  into `subject`(`sub_id`,`sub_name`,`sub_total_mark`,`subject_dept_id`,`dt_created`,`dt_modif`,`created_by`,`modif_by`,`sub_obt_mark`) values 
(11,'Java',100,1,NULL,NULL,NULL,NULL,87),
(12,'PHP',100,1,NULL,NULL,NULL,NULL,88),
(13,'PYTHON',100,1,NULL,NULL,NULL,NULL,90),
(14,'Acount',100,2,NULL,NULL,NULL,NULL,77),
(15,'Histry',100,3,NULL,NULL,NULL,NULL,67),
(16,'Algebra',100,4,NULL,NULL,NULL,NULL,98);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
