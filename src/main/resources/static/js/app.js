var app = angular.module("app", ['ngRoute', 'ngCookies']);

app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
	    .when('/home', {
	        'templateUrl': '/html/home.html',
	        'controller': 'homeCtrl'
	    })
	    .when('/search', {
	        'templateUrl': '/html/search.html',
	        'controller': 'searchCtrl'
	    })
	    .when('/new', {
            'templateUrl': '/html/new.html',
            'controller': 'newCtrl'
        })
        .otherwise({
            redirectTo: '/home'
        });
}]);

app.controller('rootCtrl', function ($scope, $rootScope, $http, $cookies, $window) {
	
	$scope.init = function(){
		if($cookies.token == undefined){
			console.log($window);
			$window.location.href= "/login?request="+encodeURIComponent($window.location.href);
		} else {
			$scope.validate($cookies.token);
		}
	};
	
	$scope.validate = function(token){
		$http({
            method: 'POST',
            url: '/validate',
            headers: {
            	"Content-Type": "text/html"
            },
            data: token
        }).success(function(data, status){
            $rootScope.user = data;
        }).error(function(error, status){
            alert("Error !!!");
        });
	};
	
});

app.controller('homeCtrl', function ($scope, $rootScope) {

});

app.controller('searchCtrl', function ($scope, $rootScope) {

});

app.controller('newCtrl', function ($scope, $rootScope, $http) {

    $scope.submit = function (form) {
        if (!form.$invalid) {
            console.log(JSON.stringify($scope.visitor));
            $http({
                method: 'POST',
                url: 'api/visitor/create',
                data: $scope.visitor
            }).success(function(data, status){
                alert('SUCCESS');
            }).error(function(error, status){
                alert('ERROR');
            });
        } else {
            console.log(form);
        }
    };

});