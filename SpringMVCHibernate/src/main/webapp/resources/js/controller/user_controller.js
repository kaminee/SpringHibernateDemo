'use strict';

angular.module('myUserApp').controller('UserController', ['$scope', 'UserService','$http', function($scope, UserService,$http) {
	console.log("\n\t stareted ");

	var self = this;
    self.user={id:null,username:'',address:'',email:''};
    self.users=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
	console.log("\n\t *****");
//	$scope.users=[];
    $scope.countryAccounts = [];
    $http({
            method: 'GET',
            url: 'http://localhost:8080/SpringMVCHibernate/countries'
           
        }).success(function (result) {
        	console.log("\n\t resule"+result);
        $scope.countryAccounts = result;
    });
    $scope.groupAccounts = [];
    $http({
            method: 'GET',
            url: 'http://localhost:8080/SpringMVCHibernate/group/fetch'
           
        }).success(function (result) {
        	console.log("\n\t groupAccounts "+result);
        $scope.groupAccounts = result;
    });


    fetchAllUsers();
    
    $scope.GetValue = function (count) {
    	console.log("count======"+count)
    	 $scope.countryId = count.countryId;
    	 
    	 console.log("scope.countryName = "+count.countryName);
    	 
    	 console.log("\n\t $scope.countryId "+$scope.countryId+"\t ==="+$scope.countryName);
    	 
    	}
    function fetchAllUsers(){
    	console.log("\n\t fetchAllUsers");
        UserService.fetchAllUsers()
            .then(
            function(d) {
            	
            
            	console.log("\n\t fetchAllUsers"+d.length);
//            	$scope.userN=d[0].username;
            	
            	self.users = d;
            	$scope.usersList=angular.copy(d);
            	console.log("\n\t self.users-->"+self.users.length+"\t angular.copy---->"+angular.copy(d));
            	
            	$scope.temp = angular.fromJson(d);
            	
            	console.log("\n\t $scope.temp-->"+$scope.temp.country);
            	var len =d.length;
            	$scope.leng=len;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }

    function createUser(user){
    	user.country={
    		countryId:	user.country
    	};
    	console.log("\n\t to create user requet--->"+user);
        UserService.createUser(user)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while creating User');
            }
        );
    }

    function updateUser(user, id){
        UserService.updateUser(user, id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while updating User');
            }
        );
    }

    function deleteUser(id){
       /* UserService.deleteUser(id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while deleting User');
            }
        );*/
    	  $http({
              method: 'DELETE',
              url: 'http://localhost:8080/SpringMVCHibernate/user/' + id,
            
              headers: {
                  'Content-type': 'application/json;charset=utf-8'
              }
          })
          .then(function(response) {
              console.log(response.data);
          }, function(rejection) {
              console.log(rejection.data);
          });
    }

    function submit() {
        if(self.user.id===null){
            console.log('Saving New User', self.user);
            createUser(self.user);
        }else{
            updateUser(self.user, self.user.id);
            console.log('User updated with id ', self.user.id);
        }
        reset();
    }

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.users.length; i++){
            if(self.users[i].id === id) {
                self.user = angular.copy(self.users[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.user.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteUser(id);
    }


    function reset(){
        self.user={id:null,username:'',address:'',email:''};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
