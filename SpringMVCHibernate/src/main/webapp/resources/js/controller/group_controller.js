'use strict';

angular.module('myUserApp').controller('GroupController', ['$scope', 'GroupService','$http', function($scope, GroupService,$http) {
	console.log("\n\t stareted ");

	var self = this;
    self.group={id:null,name:'',users:[]};
    self.groups=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
	console.log("\n\t *****");
//	$scope.users=[];
	$scope.countusers=[];
    $scope.groupArray = [];
    $scope.usersarrayele = [];
    $http({
            method: 'GET',
            url: 'http://localhost:8080/SpringMVCHibernate/group/fetch'
           
        }).success(function (result) {
//        	console.log("\n\t resule"+result);
        $scope.groupArray = result;
    });

    
    $scope.userArray = [];
    $http({
        method: 'GET',
        url: 'http://localhost:8080/SpringMVCHibernate/users'
       
    }).success(function (result) {
//    	console.log("\n\t resule"+result);
    $scope.userArray = result;
});
    
    
    fetchAllGroups();
    fetchAllUsersGroups();
    
    $scope.GetValue = function (count) {
    	console.log("count======"+count)
    	console.log("count======"+count.id)
//    	 $scope.countusers = count.id;
    	$scope.usersarrayele.push(count);
    	 $scope.countusers=count;
    		console.log("$scope.usersarrayele======"+$scope.usersarrayele)
//    	 console.log("scope.name = "+count.name);
    	 
//    	 console.log("\n\t $scope.id "+$scope.id+"\t ==="+$scope.name);
    	 
    	}
    function fetchAllGroups(){
    	GroupService.fetchAllGroups()
            .then(
            function(d) {
            	
            
//            	$scope.userN=d[0].username;
            	
            	self.groups = d;
            	$scope.groupList=angular.copy(d);
//            	console.log("\n\t self.users-->"+self.group.length+"\t angular.copy---->"+angular.copy(d));
            	
            	$scope.temp = angular.fromJson(d);
            	
//            	console.log("\n\t $scope.temp-->"+$scope.temp.country);
            	var len =d.length;
            	$scope.leng=len;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }

    
    function fetchAllUsersGroups(){
    	GroupService.fetchAllUsersGroups()
            .then(
            function(d) {
            	
            
//            	console.log("\n\t fetchAllUsersGroups"+d.length);
//            	$scope.userN=d[0].username;
            	
            	self.groups = d;
            	$scope.groupList=angular.copy(d);
//            	console.log("\n\t self.usersgroups-->"+self.group.length+"\t angular.copy---->"+angular.copy(d));
            	
            	$scope.temp = angular.fromJson(d);
            	
//            	console.log("\n\t $scope.temp-->"+$scope.temp.country);
            	var len =d.length;
            	$scope.leng=len;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }

    function createGroup(group){
    	console.log("Selected Value: " +$scope.countusers + "\nSelected Text: "+$scope.usersarrayele );

    		group.users=$scope.usersarrayele;

    	GroupService.createGroup(group)
            .then(
            		fetchAllGroups,
            function(errResponse){
                console.error('Error while creating group');
            }
        );
    }

    function updateGroup(group, id){
		group.users=$scope.usersarrayele;

//    	group.users=[{id:group.usersarr}];
    	console.log("\n\t\t ---group-->"+group+"\t\t group.users-->"+group.users)
    	GroupService.updateGroup(group, id)
            .then(
            		fetchAllGroups,
            function(errResponse){
                console.error('Error while updating group');
            }
        );
    }

    function deleteGroup(id){
       /* UserService.deleteUser(id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while deleting User');
            }
        );*/
    	  $http({
              method: 'DELETE',
              url: 'http://localhost:8080/SpringMVCHibernate/group/' + id,
            
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
        if(self.group.id===null){
            console.log('Saving New group', self.group);
            createGroup(self.group);
        }else{
        	updateGroup(self.group, self.group.id);
            console.log('User updated with id ', self.group.id);
        }
        reset();
    }

    function edit(id){
        console.log('id to be edited', id);
        console.log('id to be self.groups', self.groups);

        for(var i = 0; i < self.groups.length; i++){
            if(self.groups[i].id === id) {
                self.selUser = angular.copy(self.groups[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.group.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteGroup(id);
    }


    function reset(){
        self.group={id:null,name:''};
        $scope.groupForm.$setPristine(); //reset Form
    }

}]);
