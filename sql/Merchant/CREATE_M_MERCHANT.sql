BEGIN
  FOR i IN (SELECT table_name FROM user_tables WHERE table_name = 'M_MERCHANT') LOOP
    EXECUTE IMMEDIATE 'DROP TABLE M_MERCHANT';
  END LOOP;
END;
/
CREATE TABLE M_MERCHANT (
	MID			NUMBER(4, 0) NOT NULL,
	USERNAME	VARCHAR2(30) NOT NULL,
	PASSWORD	VARCHAR2(32) NOT NULL,
	NAME		VARCHAR2(30) NOT NULL,
	BRITH_DATE	DATE,
	GENDER		VARCHAR2(8),
	STATUS		VARCHAR2(10),
	REG_DATE	DATE,
	CONSTRAINT M_MERCHANT_IDX1 PRIMARY KEY (MID)
)
/
CREATE SEQUENCE M_MERCHANT_SEQ START WITH 1 INCREMENT BY 1;
/