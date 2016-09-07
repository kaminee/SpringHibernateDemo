<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <html>
  <head>  
    <title>AngularJS $http Example</title>  

     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myGroupApp" class="ng-cloak"> 
     <div class="generic-container" ng-controller="GroupController as ctrl">--%>
     
          <div class="generic-container">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Group Registration Form </span></div>
              <div class="formcontainer">
               <form ng-submit="ctrl.submit()" name="groupForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.group.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Group Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.group.name" name="uname" class="name form-control input-sm" placeholder="Enter your group name" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="groupForm.$dirty">
                                      <span ng-show="groupForm.uname.$error.required">This is a required field</span>
                                      <span ng-show="groupForm.uname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="groupForm.uname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                    
 					 <div class="row">
                          <div class="form-group col-md-12">
                            	  <label class="col-md-2 control-lable" for="file">User</label>
                              
                   					 <select ng-model="ctrl.group.users" name="" class="select input-sm" ng-options="ctr.id as ctr.username for ctr in userArray track by ctr.id" ng-change="GetValue(ctrl.group.users)">
										<option value="">--Select--</option>
									</select>
						
										Selected Value is:{{ctrl.group.id}}
 							</div>
                          </div>
                          
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.group.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="groupForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="groupForm.$pristine">Reset Form</button>
                          </div>
                     </div>
                     
                     
                  </form>
                </div>
                </div>
                </div>
                 <!--    {{groupList}}-->
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Groups </span></div>
          
              <div class="tablecontainer">
             
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Name</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                     
                          <tr ng-repeat="u in groupList">
                       
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.name"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table> 
              </div>
              
              
<!--   </body>
</html> -->