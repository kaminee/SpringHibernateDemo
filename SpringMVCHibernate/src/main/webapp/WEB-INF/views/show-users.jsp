<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <body ng-app="showUsers">
		<div ng-controller="showUserCtrl">
		 Hi {{usersdata.username}}
		 <select ng-model="selectedTestAccount" ng-options="item.id as item.username for item in testAccounts">
    <option value="">Select User</option>
</select>

  <!-- <button type="button" ng-click="" class="btn btn-success custom-width">Users</button>-->
      
        <div align="center">
	        <h1>Contact List</h1>
        	<table border="1">
	        	<th>No</th>
	        	<th>Username</th>
	        	<th>Email</th>
	        	
				<c:forEach var="user" items="${userList}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${user.username}</td>
					<td>${user.email}</td>
							
	        	</tr>
				</c:forEach>	        	
        	</table>
        </div>
     
        <div ng-view></div>
           </div>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0rc1/angular-route.min.js"></script>
   <script data-require="angular-animate@1.2.11" data-semver="1.2.11" src="http://code.angularjs.org/1.2.11/angular-animate.min.js"></script>
	<script src="<c:url value="/resources/js/app.js" />"></script>
  <script src="<c:url value="/resources/js/controller/show_users_ctrl.js" />"></script>

   </body>
</html>
