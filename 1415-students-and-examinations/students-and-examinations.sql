SELECT
    s.student_id,
    s.student_name,
    sb.subject_name,
    COUNT(e.subject_name) AS attended_exams
FROM Students s
CROSS JOIN Subjects sb
LEFT JOIN Examinations e on
s.student_id=e.student_id
and sb.subject_name=e.subject_name
GROUP BY
    s.student_id,
    s.student_name,
    sb.subject_name
ORDER BY
    s.student_id,
    sb.subject_name;