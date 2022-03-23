--INSERT INTO table(column1, column2, ...)
--SELECT value1, value2, ... FROM DUAL
--UNION ALL
--SELECT value1, value2, ... FROM DUAL
--UNION ALL
--...
--SELECT value1, value2, ... FROM DUAL;

INSERT INTO ITEM_IMAGE (img_code, origin_img_name, attached_img_name, is_main, item_code)
SELECT 'IMG_001', 'A.JPG', 'AAA_A.JPG', 'N', 'ITEM_001' FROM DUAL;