BEGIN
  FOR i IN (SELECT table_name FROM user_tables WHERE table_name = 'M_SHOP') LOOP
    EXECUTE IMMEDIATE 'DROP TABLE M_SHOP';
  END LOOP;
END;
/
CREATE TABLE M_SHOP (
	SID			NUMBER(4, 0) NOT NULL,
	MID			NUMBER(4, 0) NOT NULL,
	NAME 		VARCHAR2(50) NOT NULL,
	DESCRIPTION	VARCHAR2(50),
	IMG_PATH	VARCHAR2(100),
	CONSTRAINT M_SHOP_IDX1 PRIMARY KEY (SID)
)
/
CREATE SEQUENCE M_SHOP_SEQ START WITH 1 INCREMENT BY 1;
/