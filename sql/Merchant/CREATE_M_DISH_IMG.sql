BEGIN
  FOR i IN (SELECT table_name FROM user_tables WHERE table_name = 'M_DIS_IMG') LOOP
    EXECUTE IMMEDIATE 'DROP TABLE M_DIS_IMG';
  END LOOP;
END;
/
CREATE TABLE M_DIS_IMG (
	IMG_ID			NUMBER(6, 0) NOT NULL,
	DID				NUMBER(5, 0) NOT NULL,
	IMG_PATH		VARCHAR2(100),
	CONSTRAINT M_DIS_IMG_IDX1 PRIMARY KEY (IMG_ID)
)
/
CREATE SEQUENCE M_DIS_IMG_SEQ START WITH 1 INCREMENT BY 1;
/