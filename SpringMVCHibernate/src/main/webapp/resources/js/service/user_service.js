'use strict';

angular.module('myUserApp').factory('UserService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/SpringMVCHibernate/user/';

    var factory = {
        fetchAllUsers: fetchAllUsers,
        createUser: createUser,
        updateUser:updateUser
        ,
        deleteUser:deleteUser
    };

    return factory;

    function fetchAllUsers() {
    	console.log("\n\t fetchAllUsers service 1");
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+"user/")
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createUser(user) {
        console.log('REST_SERVICE_URI', REST_SERVICE_URI);
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, user)
            .then(
            function (response) {
            	   console.log('response.data', response.data);
                deferred.resolve(response.data);
            },
            function(errResponse){
            	 console.log('errResponse', errResponse);
                console.error('Error while creating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateUser(user, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating User');
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
