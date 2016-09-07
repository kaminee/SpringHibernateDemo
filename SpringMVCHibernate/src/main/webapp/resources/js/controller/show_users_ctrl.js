
'use strict';
//app.controller('todoCtrl', ['$scope','$http','$routeProvider', function($scope,$http,$routeProvider) {
	
//	angular.module('myApp', ['ui.router', 'ngAnimate'])
		angular.module('myUserApp', ['ngRoute'])
	.config(function($routeProvider){
		 $routeProvider
		 .when('/showUsers', {
				templateUrl: 'showUsers',
//			   	template: '<div class="tab tab1"><p>Caerphilly fromage cheeseburger. Goat fromage frais halloumi melted cheese cheese and biscuits macaroni cheese babybel ricotta. Roquefort croque monsieur babybel fromage frais chalk and cheese bavarian bergkase cream cheese emmental. When the cheese comes out everybody\'s happy camembert de normandie fromage frais ricotta.</p></div>',
				controller: 'showUserCtrl'
			})
	})
	.controller('showUserCtrl', ['$scope','$http', function($scope,$http) {
		console.log("\n\t stareted ");

	console.log("data===");
	$http.get('http://localhost:8080/SpringMVCHibernate/mobile').
        success(function(data) {
         $scope.usersdata = data[0];
        	console.log("data==="+data[0].username+"\t object=="+data);
  				$scope.email = data[0].email;
        });
        
        
         $scope.testAccounts = [];
    $http({
            method: 'GET',
            url: 'http://localhost:8080/SpringMVCHibernate/users'
           
        }).success(function (result) {
        $scope.testAccounts = result;
    });
    
    $scope.todoList = [{todoText:'Clean House', done:false}];

    $scope.todoAdd = function() {
        $scope.todoList.push({todoText:$scope.todoInput, done:false});
        $scope.todoInput = "";
    };

    $scope.remove = function() {
        var oldList = $scope.todoList;
        $scope.todoList = [];
        angular.forEach(oldList, function(x) {
            if (!x.done) $scope.todoList.push(x);
        });
    };
}]);
