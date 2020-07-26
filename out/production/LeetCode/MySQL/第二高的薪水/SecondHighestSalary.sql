/**
1。IFNULL(A,B)函数：如果不为空返回第一个参数A，为空返回参数B
2。distinct去重
3。Limit函数指定SELECT语句返回指定的记录数，
  如果给定两个参数，第一个参数指定第一个返回记录行的偏移量，第二个参数指定返回记录行的最大数目。初始记录行的偏移量是 0(而不是 1)
 */

select IFNULL((select distinct Salary from Employee order by Salary DESC Limit 1,1) ,NULL)as SecondHighestSalary;