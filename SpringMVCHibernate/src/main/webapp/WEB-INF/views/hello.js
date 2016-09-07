function Hello($scope, $http) {
    $http.get('http://localhost:8080/SpringMvcHibernateXML/mobile').
        success(function(data) {
        	console.log("data==="+data);
//            $scope.greeting = data;
        });
}