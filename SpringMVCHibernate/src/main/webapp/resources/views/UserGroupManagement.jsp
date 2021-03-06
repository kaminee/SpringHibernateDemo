<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>AngularJS $http Example</title>  

      </head>
  <body ng-app="myGroupApp" class="ng-cloak">
     <div class="generic-container" ng-controller="GroupController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Group Registration Form </span></div>
              <div class="formcontainer">
               <form ng-submit="ctrl.submit()" name="groupForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.group.id" />
             
             
              			<div class="row">
                          <div class="form-group col-md-12">
                            	  <label class="col-md-2 control-lable" for="file">Group</label>
                              
                   					 <select ng-model="ctrl.group.group" name="" class="select input-sm" ng-options="ctr.id as ctr.name for ctr in groupArray track by ctr.id" ng-change="GetValue(ctrl.group.group)">
										<option value="">--Select--</option>
    						
									</select>
						
										Selected Value is:{{ctrl.group.id}}
 							</div>
                          </div>
                          
                          
                          <div class="row">
                          <div class="form-group col-md-12">
                            	  <label class="col-md-2 control-lable" for="file">User</label>
                              
                   					 <select ng-model="ctrl.group.user" name="" class="select input-sm" ng-options="ctr.id as ctr.username for ctr in userArray track by ctr.id" ng-change="GetValue(ctrl.group.user)">
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
                 <!--    {{usersgroupList}}-->
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of UserGroups </span></div>
          
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
                     
                          <tr ng-repeat="u in usersgroupList">
                       
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.name"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table> 
              </div>
              
           
  </body>
</html>