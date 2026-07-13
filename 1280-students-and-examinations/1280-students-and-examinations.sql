select st.student_id , st.student_name , sb.subject_name , count(em.subject_name) as attended_exams
from Students st 
cross join Subjects sb
left join Examinations em
on st.student_id = em.student_id
And sb.subject_name = em.subject_name 
Group By 
    st.student_id,
    sb.subject_name,
    em.subject_name
Order By 
    st.student_id,
    sb.subject_name;
