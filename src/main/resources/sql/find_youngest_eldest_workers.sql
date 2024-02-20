SELECT 'YOUNGEST' AS type, "name", birthday FROM WORKER
WHERE birthday IN ( SELECT MAX(birthday) FROM WORKER)
UNION
SELECT 'OLDEST' AS TYPE, "name", birthday FROM WORKER
WHERE birthday IN ( SELECT MIN(birthday) FROM WORKER)
ORDER BY TYPE  DESC;