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

