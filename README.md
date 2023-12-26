post man requests

header: Content-Type  application/json
---------------------------------------------------------------------------
1. http://localhost:8081/department/all     --get

 
2. http://localhost:8081/department/add    --post
   {
    "deptId": 444444,
	  "deptName": "dept44444"
   }


3. http://localhost:8081/department/11111    --get



4.   http://localhost:8081/department/with-employees    --get

------------------------------------------------------------------------

5.  http://localhost:8082/employee/add    --post


{
    "empId": 105,
    "deptId":44444,
	  "empName": "karthik",
    "age": 30,
    "position":"software Engineer3"
}


6.   http://localhost:8082/employee/all    --get

7.   http://localhost:8082/employee/105    --get

8.   http://localhost:8082/employee/department/44444    --get
   
