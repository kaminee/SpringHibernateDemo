'use strict';

angular.module('myUserApp').factory('GroupService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/SpringMVCHibernate/group/';

    var factory = {
    	fetchAllGroups: fetchAllGroups,
    	fetchAllUsersGroups:fetchAllUsersGroups,
    	createGroup: createGroup,
    	updateGroup:updateGroup
//        deleteGroup:deleteGroup
    };

    return factory;

    function fetchAllGroups() {
    	console.log("\n\t fetchAllGroups service 1");
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+"group/")
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching groups');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function fetchAllUsersGroups() {
    	console.log("\n\t fetchAllGroups service 1");
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+"usergroups/fetch")
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching usergroups');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createGroup(group) {
        console.log('REST_SERVICE_URI', REST_SERVICE_URI);
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, group)
            .then(
            function (response) {
            	   console.log('response.data', response.data);
                deferred.resolve(response.data);
            },
            function(errResponse){
            	 console.log('errResponse', errResponse);
                console.error('Error while creating group');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateGroup(group, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, group)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating group');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteUser(id) {
    	
        var deferred = $q.defer();
        $http.del(REST_SERVICE_URI+id).then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting User');
                deferred.reject(errResponse);
            }
        );
        
      
        return deferred.promise;
    }

}]);
