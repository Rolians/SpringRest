<%--
  Created by IntelliJ IDEA.
  User: jivan
  Date: 25/3/19
  Time: 6:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new Customer</title>
    <meta charset="UTF-8">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
    <script>
        function myFunction() {
            var id = document.getElementById("custId").value;
            var name = document.getElementById("name").value;
            var email = document.getElementById("email").value;
            var date = document.getElementById("dateOfBirth").value;

            var data = {custId:id,name:name,email : email, date : date};

            $.ajax({
                url:"http://localhost:8080/SpringRest/customer",
                type:"POST",
                contentType:"application/json",
                data : JSON.stringify(data),
                success : function (data, status) {
                    console.log("Status",status);
                    console.log("SUCCESS",data);
                },
                error : function(e) {
                    console.log("ERROR: ", e);
                    display(e);
                },
                done : function(e) {
                    console.log("DONE");
                }
            });
            // alert(id +" "+name + " " +email+ " " +date+ " ");
        }
    </script>
    <script>
        function checkName() {
            var name = document.getElementById("name").value;
            alert(name);
            $.ajax({
                url:"http://localhost:8080/SpringRest/checkName",
                type:"POST",
                contentType:"application/json",
                data : name,
                success : function (data, status) {
                    setReslt(data);
                    console.log("SUCCESS",data);
                },
                error : function(e) {
                    console.log("ERROR: ", e);
                    display(e);
                },
                done : function(e) {
                    console.log("DONE");
                }
            });
        }
    </script>
    <script>
        function setReslt(result) {
            if(result == true){
                alert("UserName is exist");
                document.getElementById("duplicate_user").innerText = "This userName already exist";
            }else {

            }
        }
    </script>
</head>
<body>
    <form id="submitForm" enctype="multipart/form-data" onsubmit="myFunction()">
        <table>
            <tr>
                <td><label>Customer Id</label></td>
                <td><input type="number" id="custId" name="custId" value="custId"></td>
            </tr>
            <tr>
                <td><label>Customer Name</label></td>
                <td><input type="text" id="name" onfocusout = "checkName()" name="name" ><p id="duplicate_user"></p></td>
            </tr>
            <tr>
                <td><label>Customer Email</label></td>
                <td><input type="email" id="email"  name="email" value="custEmail"></td>
            </tr>
            <tr>
                <td><label>Customer Date</label></td>
                <td><input type="date" id="dateOfBirth" name="dateOfBirth" value="dateOfBirth"></td>
            </tr>
            <tr>
                <td><input type="submit"></td>
                <td><input type="reset" value="reset"></td>
            </tr>
        </table>
    </form>
</body>
</html>
