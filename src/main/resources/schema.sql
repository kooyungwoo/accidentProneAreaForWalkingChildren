DROP TABLE IF EXISTS KOREA_AREA_CODE;

CREATE TABLE KOREA_AREA_CODE (
  AREA_CODE varchar(10) DEFAULT NULL COMMENT '법정동코드',
  AREA_NAME varchar(200) DEFAULT NULL COMMENT '법정동명',
  PARENT_CODE varchar(10) DEFAULT NULL COMMENT '상위코드',
  VIEW_ORDER int DEFAULT NULL COMMENT '출력순서',
  AREA_DEPTH varchar(2) DEFAULT NULL COMMENT '출력 위치'
);