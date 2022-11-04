CREATE TABLE `board` (
`seq` bigint(20) NOT NULL AUTO_INCREMENT,
`subject` varchar(200) DEFAULT NULL COMMENT '게시글제목',
`content` varchar(2000) DEFAULT NULL COMMENT '게시글내용',
`hits` int(20) DEFAULT '0' COMMENT '게시글조회수',
`ins_id` varchar(100) DEFAULT NULL COMMENT '입력자ID',
`ins_date` datetime DEFAULT NULL COMMENT '입력일시',
`mod_id` varchar(100) DEFAULT NULL COMMENT '수정자ID',
`mod_date` datetime DEFAULT NULL COMMENT '수정일시',
PRIMARY KEY (`seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;