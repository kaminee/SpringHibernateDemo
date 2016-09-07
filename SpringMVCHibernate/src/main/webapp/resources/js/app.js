'use strict';

var App = angular.module('myUserApp', ['ngRoute'])

.config(function($routeProvider){
 $routeProvider
 	.when('/user', {
		templateUrl: 'resources/views/UserManagement.jsp',
//		template:'views/UserGroupManagement.jsp',
//	   	template: '<div class="tab tab1"><p>Caerphilly fromage cheeseburger. Goat fromage frais halloumi melted cheese cheese and biscuits macaroni cheese babybel ricotta. Roquefort croque monsieur babybel fromage frais chalk and cheese bavarian bergkase cream cheese emmental. When the cheese comes out everybody\'s happy camembert de normandie fromage frais ricotta.</p></div>',
		controller: 'UserController as uctrl'
	})
	.when('/showOrders', {
//		templateUrl: 'views/show_orders.jsp',
	   	template: '<div class="tab tab1"><p>Caerphilly fromage cheeseburger. Goat fromage frais halloumi melted cheese cheese and biscuits macaroni cheese babybel ricotta. Roquefort croque monsieur babybel fromage frais chalk and cheese bavarian bergkase cream cheese emmental. When the cheese comes out everybody\'s happy camembert de normandie fromage frais ricotta.</p></div>',

		controller: 'todoCtrl'
      })
     .when('/groups', {
		templateUrl: 'resources/views/GroupsManagement.jsp',
//	   	template: '<div class="tab tab1"><p>Caerphilly fromage cheeseburger. Goat fromage frais halloumi melted cheese cheese and biscuits macaroni cheese babybel ricotta. Roquefort croque monsieur babybel fromage frais chalk and cheese bavarian bergkase cream cheese emmental. When the cheese comes out everybody\'s happy camembert de normandie fromage frais ricotta.</p></div>',
	
//		template:'views/UserGroupManagement.jsp',
		controller: 'GroupController as ctrl'
	})
    .otherwise({
		redirectTo: '/showUsers'
      });
})

//var appHome = angular.module('myApp',['ngRoute']);


