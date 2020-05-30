#######################################  系统类功能 ###################################################
-- 用户表
create table ods_s_user(
	id int PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	name varchar(255) DEFAULT NULL COMMENT '名称',
    code varchar(255) DEFAULT NULL COMMENT '登录编码',
    head_path varchar(255) DEFAULT NULL COMMENT '头像图片路径',
    head_name varchar(255) DEFAULT NULL COMMENT '头像图片名称',
	phone varchar(255) DEFAULT NULL COMMENT '电话',
	e_mail varchar(255) DEFAULT NULL COMMENT '邮箱',
	descrition  varchar(255)  DEFAULT NULL COMMENT '描述',
    active_flag varchar(2) DEFAULT NULL COMMENT '是否活动',
    is_manager varchar(2) DEFAULT NULL COMMENT '是否管理员',
	password varchar(50) DEFAULT NULL COMMENT '登录密码'
);
INSERT INTO `ods_s_user` (`id`, `name`, `code`, `phone`, `active_flag`, `is_manager`, `password`, `e_mail`, `descrition`) VALUES ('1', '管理员', 'admin', '183', '1', '1', '96E79218965EB72C92A549DD5A330112', '690610004', '111');

-- 用户可用权益
create table ods_user_available(
   id varchar(32) PRIMARY KEY COMMENT '主键',
   is_vip varchar(4) DEFAULT '0' COMMENT '是否会员',
   execFrequency int DEFAULT 0 COMMENT '全真测试次数',
   execTime date DEFAULT NULL COMMENT '全真测试次数有效期',
   lineEffectiveTime date DEFAULT NULL COMMENT '在线学习有效期',
   integral int  DEFAULT 0 COMMENT '积分',
   user_id int DEFAULT NULL COMMENT '用户id'
);

-- 菜单
create table ods_s_menu(
	id int PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	parentId int DEFAULT NULL COMMENT '父id',
	title varchar(255) DEFAULT NULL COMMENT '菜单名称',
	href varchar(255) DEFAULT NULL COMMENT '菜单链接',
	icon varchar(255) DEFAULT NULL COMMENT '菜单图标',
	rightIcon varchar(255) DEFAULT NULL COMMENT '菜单图标',
	target varchar(255) DEFAULT NULL COMMENT '菜单目标,默认:_self',
	level varchar(4) DEFAULT NULL COMMENT '菜单等级'
);

#######################################  码表类 ###################################################
-- 分类码表
create table ods_c_sort(
 id varchar(32) PRIMARY KEY COMMENT '主键',
 code varchar(32) DEFAULT NULL COMMENT '分类编码',
 name varchar(255) DEFAULT NULL COMMENT '分类名称',
 type varchar(32) DEFAULT NULL COMMENT '类型',
 ord int DEFAULT NULL COMMENT '排序'
);

INSERT into ods_c_sort(id,code, name, type, ord) values('1','danzilianxi','单字练习','question','1');
INSERT into ods_c_sort(id,code, name, type, ord) values('2','ciyulianxi','词语练习','question','2');
INSERT into ods_c_sort(id,code, name, type, ord) values('3','duanwenlianxi','短文练习','question','3');

INSERT into ods_c_sort(id,code, name, type, ord) values('4','goodsOrder','套餐订单','order','1');
INSERT into ods_c_sort(id,code, name, type, ord) values('5','bookOrder','教材订单','order','2');
INSERT into ods_c_sort(id,code, name, type, ord) values('6','sendOrder','邮寄订单','order','3');

INSERT into ods_c_sort(id,code, name, type, ord) values('7','package','套餐商品','goods','1');
INSERT into ods_c_sort(id,code, name, type, ord) values('8','book','普通商品','goods','2');
INSERT into ods_c_sort(id,code, name, type, ord) values('9','send','邮寄运费商品','goods','3');
INSERT into ods_c_sort(id,code, name, type, ord) values('10','send','教材商品','goods','4');

#######################################  商品购买支付类功能 ###################################################
-- 地址管理
create table ods_address(
	id varchar(32) PRIMARY KEY COMMENT '主键',
	accept_man varchar(255) COMMENT '收货人',
	phone varchar(255) COMMENT '电话',
	province varchar(255) COMMENT '省份',
	city varchar(255) COMMENT '地市',
	area varchar(255) COMMENT '片区',
	is_delete varchar(2) COMMENT '是否删除',
	user_id int COMMENT '用户id'
);

-- license地址
create table ods_license_address(
	id varchar(32) PRIMARY KEY COMMENT '主键',
	accept_man varchar(255) COMMENT '收货人',
    idCard varchar(18) DEFAULT NULL COMMENT '身份证号',
	phone varchar(255) COMMENT '电话',
	province varchar(255) COMMENT '省份',
	city varchar(255) COMMENT '地市',
	area varchar(255) COMMENT '片区',
	address varchar(1000) COMMENT '详细地址',
	is_delete varchar(2) COMMENT '是否删除',
	user_id int COMMENT '用户id'
);

-- 订单
create table ods_order(
	id varchar(32) PRIMARY KEY  COMMENT '主键',
	name varchar(255) DEFAULT NULL COMMENT '订单名称',
	create_date datetime DEFAULT NULL COMMENT '创建时间',
	sort_id varchar(32) DEFAULT NULL COMMENT '订单分类id',
	user_id int COMMENT '用户id'
);

-- 订单与商品关联表
create table ods_order_goods(
 	id varchar(32) PRIMARY KEY  COMMENT '主键',
 	order_id varchar(32) COMMENT '订单id',
 	quantity decimal DEFAULT NULL COMMENT '商品数量',
 	goods_id varchar(32) COMMENT '商品id'
);

-- 商品 对于邮费 就相当于一个商品 根据地区确定的商品,商品的一个概述
create table ods_goods(
	id varchar(32) PRIMARY KEY COMMENT '主键',
	name varchar(255) DEFAULT NULL COMMENT '商品名称',
	price decimal DEFAULT NULL COMMENT '商品单价格',
	discountPrice decimal DEFAULT NULL COMMENT '折扣价格',
	unit varchar(32) DEFAULT NULL COMMENT '商品单位',
	image varchar(255) DEFAULT NULL COMMENT '商品图片',
	create_date datetime DEFAULT NULL COMMENT '创建时间',
	desciption varchar(255) DEFAULT NULL COMMENT '介绍',
	execFrequency int DEFAULT NULL COMMENT '测试次数',
  	effectiveTime int DEFAULT NULL COMMENT '套餐时间',
	sort_id varchar(32) DEFAULT NULL COMMENT '商品分类id'
);
INSERT into ods_goods(id, name, price,discountPrice, unit, create_date, desciption,execFrequency, effectiveTime, sort_id) values('1','年卡会员',79, 1240,'元', now(),'无限次 全真测试，360天在线学习',-1, 360,7);
INSERT into ods_goods(id, name, price,discountPrice, unit, create_date, desciption,execFrequency, effectiveTime, sort_id) values('2','季卡会员',59, 310,'元', now(),'无限次 全真测试，90天在线学习',-1, 90,7);
INSERT into ods_goods(id, name, price,discountPrice, unit, create_date, desciption,execFrequency, effectiveTime, sort_id) values('3','月卡会员',39, 70,'元', now(),'10次 全真测试，30天在线学习',10, 30,7);

INSERT into ods_goods(id, name, price,discountPrice, unit, create_date, desciption,execFrequency, effectiveTime, sort_id) values('4','在线学习',15, 20,'元', now(),'30天在线学习',0, 30,8);
INSERT into ods_goods(id, name, price,discountPrice, unit, create_date, desciption,execFrequency, effectiveTime, sort_id) values('5','全真测试',10, 20,'元', now(),'2次 全真测试',2, 0,8);



#######################################  题目练习类功能 ###################################################

-- 附件包表
create table ods_c_attachment_unit(
	id varchar(32) PRIMARY KEY COMMENT '主键'
	
);

-- 附件表
create table ods_c_atachment(
	id varchar(32) PRIMARY KEY COMMENT '主键',
	name varchar(255) DEFAULT NULL COMMENT '附件名称',
	attach_path varchar(255) DEFAULT NULL COMMENT '附件路径',
	uploader int DEFAULT NULL COMMENT '上传人',
	upload_date datetime DEFAULT NULL COMMENT '上传时间',
	attachment_unit_id varchar(32) COMMENT '语音附件包id',
	ord int DEFAULT NULL COMMENT '排序'
);

-- 题目表
create table ods_questions(
	id varchar(32) PRIMARY KEY COMMENT '主键',
	name varchar(255) DEFAULT NULL COMMENT '名称',
    create_date datetime DEFAULT NULL COMMENT '创建时间',
    sort_id varchar(32) COMMENT '分类id',
	attachment_unit_id varchar(32) COMMENT '语音附件包id'
);

-- 题目明细
create table ods_questions_detail(
	id varchar(32) PRIMARY KEY COMMENT '主键',
	word text DEFAULT NULL COMMENT '题目内容',
	ord int DEFAULT NULL COMMENT '排序',
	questions_id varchar(32) COMMENT '问题id'
);

-- 问题明细汉字包
create table ods_s_chinese_unit(
  id varchar(32) PRIMARY KEY COMMENT '主键',
  questions_detail_id varchar(32) COMMENT '问题明细id',
  chinese_id varchar(32) COMMENT '汉字id',
  ord int COMMENT '汉字排序'
);

-- 汉字包
create table ods_s_chinese(
  id varchar(32) PRIMARY KEY COMMENT '主键',
  chinese varchar(6) DEFAULT NULL COMMENT '汉字',
  pinyin varchar(12) DEFAULT NULL COMMENT '汉字拼音',
  hzAndpy varchar(255) DEFAULT NULL COMMENT '汉字和拼音',
  attachment_unit_id varchar(32) COMMENT '语音附件包id'
);

-- 测试题目包
create table ods_s_exam(
  id varchar(32) PRIMARY KEY COMMENT '主键',
  name varchar(255) DEFAULT NULL COMMENT '测试题目名称',
  singleword_id varchar(32) DEFAULT NULL COMMENT '单字题目id',
  multiword_id varchar(32) DEFAULT NULL COMMENT '多字题目id',
  essay_id varchar(32) DEFAULT NULL COMMENT '短文题目id',
  topic_id varchar(32) COMMENT '命题练习id',
  create_date datetime DEFAULT NULL COMMENT '创建时间'
);


-- 报名
create table ods_exam_people(
	id int PRIMARY KEY COMMENT '主键',
	name varchar(255) DEFAULT NULL COMMENT '姓名',
	sex varchar(4) DEFAULT NULL COMMENT '性别',
	idCard varchar(18) DEFAULT NULL COMMENT '身份证号',
	birthday datetime DEFAULT NULL COMMENT '出生日期',
	exam_type int DEFAULT NULL COMMENT '考试类型',

);

-- 考试类型
create table ods_exam_type(
	id int PRIMARY KEY COMMENT '主键',
	name varchar(255) DEFAULT NULL COMMENT '考试名称',
	exam_date datetime DEFAULT NULL COMMENT '考试时间',
	exam_address int DEFAULT NULL COMMENT '考试地点'

);

-- 成绩
create table ods_grade(
	id int PRIMARY KEY COMMENT '主键',
	name varchar(255) DEFAULT NULL COMMENT '姓名',
	idCard varchar(18) DEFAULT NULL COMMENT '身份证号',
	admissionTicket varchar(32) DEFAULT NULL COMMENT '准考证号',
	score varchar(32) DEFAULT NULL COMMENT '成绩'
);