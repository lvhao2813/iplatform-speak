-- 用户表
create table ods_s_user(
	id int PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	name varchar(255) DEFAULT NULL COMMENT '名称',
    code varchar(255) DEFAULT NULL COMMENT '登录编码',
	phone varchar(255) DEFAULT NULL COMMENT '电话',
    active_flag varchar(2) DEFAULT NULL COMMENT '是否活动',
    is_manager varchar(2) DEFAULT NULL COMMENT '是否管理员',
	password varchar(50) DEFAULT NULL COMMENT '登录密码'
);

-- 地址管理
create table ods_address(
	id int PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	accept_man varchar(255) COMMENT '收货人',
	phone varchar(255) COMMENT '电话',
	province varchar(255) COMMENT '省份',
	city varchar(255) COMMENT '地市',
	area varchar(255) COMMENT '片区',
	is_delete varchar(2) COMMENT '是否删除',
	user_id int COMMENT '用户id'
);

-- 问题分类
create table ods_s_quention_sort(
 id int PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
 code varchar(32) DEFAULT NULL COMMENT '分类编码',
 name varchar(255) DEFAULT NULL COMMENT '分类名称',
 ord int DEFAULT NULL COMMENT '排序'
);
INSERT into ods_s_quention_sort(code, name, ord) values('danzilianxi','单字练习','1');
INSERT into ods_s_quention_sort(code, name, ord) values('ciyulianxi','词语练习','2');
INSERT into ods_s_quention_sort(code, name, ord) values('duanwenlianxi','短文练习','3');

-- 附件包表
create table ods_c_attachment_unit(
	id int PRIMARY KEY AUTO_INCREMENT COMMENT '主键'
	
);

-- 附件表
create table ods_c_atachment(
	id int PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	name varchar(255) DEFAULT NULL COMMENT '附件名称',
	attach_path varchar(255) DEFAULT NULL COMMENT '附件路径',
	uploader int DEFAULT NULL COMMENT '上传人',
	upload_date datetime DEFAULT NULL COMMENT '上传时间',
	ord int DEFAULT NULL COMMENT '排序'
);

-- 题目表
create table ods_questions(
	id int PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	name varchar(255) DEFAULT NULL COMMENT '名称',
	attachment_unit_id int COMMENT '语音附件包id',
	sort_id int COMMENT '题目类别'
);

-- 题目明细
create table ods_questions_detail(
	id int PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	word text DEFAULT NULL COMMENT '题目内容',
	questions_id int COMMENT '问题id'
);

-- 问题明细汉字包
create table ods_s_chinese_unit(
  id int PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
  questions_detail_id int COMMENT '问题明细id',
  chinese_id int COMMENT '汉字id',
  ord int COMMENT '汉字排序'
);

-- 汉字包
create table ods_s_chinese(
  id int PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
  word varchar(6) DEFAULT NULL COMMENT '汉字',
  pinyin varchar(12) DEFAULT NULL COMMENT '汉字拼音'
);


