BEGIN
  FOR i IN (SELECT table_name FROM user_tables WHERE table_name = 'A_DISH_IMG') LOOP
    EXECUTE IMMEDIATE 'DROP TABLE A_DISH_IMG';
  END LOOP;
END;
/
CREATE TABLE A_DISH_IMG (
	IMG_ID			NUMBER(6, 0) NOT NULL,
	DID				NUMBER(5, 0) NOT NULL,
	IMG_PATH		VARCHAR2(100),
	CONSTRAINT A_DISH_IMG_IDX1 PRIMARY KEY (IMG_ID)
)
/