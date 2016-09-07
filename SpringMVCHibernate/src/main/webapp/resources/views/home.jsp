<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html ng-app="myUserApp">

<head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"></link>
<!--   <link href="/resources/css/app.css" rel="stylesheet"></link> -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    
  </head>

  
  
<%-- <jsp:include page="/WEB-INF/views/header.jsp"/>
 --%>    
<body>
    
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
     	<li><a href="#user">Users </a></li>
		<li><a href="#groups"> Show Groups </a></li>
      <li><a href="#showUsers">Show List</a></li>
    </ul>
  </div>
</nav>
<!-- 		<div ng-controller="todoCtrl"> -->
     
<!--            </div> -->
                      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.js"></script>
                      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0rc1/angular-route.min.js"></script>
                       <script data-require="angular-animate@1.2.11" data-semver="1.2.11" src="http://code.angularjs.org/1.2.11/angular-animate.min.js"></script>
  					<!--<script src="http://angular-ui.github.io/ui-router/release/angular-ui-router.min.js"></script>-->
<%--        					<script src="<c:url value="/resources/js/app.js" />"></script> --%>
                      <script src="<c:url value="/resources/js/controller/home.js" />"></script>
        
      	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.js"></script>
  				<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0rc1/angular-route.min.js"></script>
				<script src="<c:url value="/resources/js/app.js" />"></script>
                <script src="<c:url value="/resources/js/service/group_service.js" />"></script>
             	<script src="<c:url value="/resources/js/controller/group_controller.js" />"></script>
             	
                <script src="<c:url value="/resources/js/service/group_service.js" />"></script>
             	<script src="<c:url value="/resources/js/controller/group_controller.js" />"></script>


   <div ng-view></div>
    </body>
</html>
