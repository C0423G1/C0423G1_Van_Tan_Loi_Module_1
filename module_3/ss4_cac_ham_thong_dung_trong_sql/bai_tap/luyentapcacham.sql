use quan_ly_sinh_vien;
SELECT *
FROM subject
WHERE credit = (
    SELECT MAX(credit)
    FROM subject
);
SELECT *
FROM subject
WHERE sub_id = (
    SELECT sub_id
    FROM mark
    WHERE mark = (
        SELECT MAX(mark)
        FROM mark
    )
);
SELECT *
FROM subject
WHERE sub_id = (
    SELECT sub_id
    FROM mark
    WHERE mark = (
        SELECT MAX(mark)
        FROM mark
    )
);

