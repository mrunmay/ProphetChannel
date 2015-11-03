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
        .when('/view/:id', {
            'templateUrl': '/html/new.html',
            'controller': 'viewCtrl'
        })
        .otherwise({
            redirectTo: '/home'
        });
}]);

app.controller('rootCtrl', function ($scope, $rootScope, $http, $cookies, $window) {
	
	$scope.init = function(){
		if($cookies.token == undefined){
			console.log($window);
			$window.location.href= "/login?state="+encodeURIComponent($window.location.href);
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
            $rootScope.session = data;
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $cookies.token;
        }).error(function(error, status){
            $window.location.href= "/logout";
        });
	};
	
});

app.controller('homeCtrl', function ($scope, $rootScope) {

});

app.controller('searchCtrl', function ($scope, $http, $rootScope) {

    $scope.init = function () {
        $scope.getVisitors();
    };

    $scope.getVisitors = function () {
        $http({
            url: 'api/visitors',
            method: 'get'
        }).success(function (data, status) {
            if (status === 200) {
                $scope.visitors = data;
                console.log('Visitors' + $scope.visitors.length);
            } else {
                console.log('status:' + status);
            }
        }).error(function (error) {
            $rootScope.message = "Error occurred";
        });
    };

});

app.controller('newCtrl', function ($scope, $rootScope, $http) {

    $scope.init = function () {
    };

    $scope.submit = function (form) {
        if (!form.$invalid) {
            console.log(JSON.stringify($scope.visitor));
            $http({
                method: 'POST',
                url: 'api/visitor/create',
                data: $scope.visitor
            }).success(function(data, status){
                alert('SUCCESS : ' + data);
            }).error(function(error, status){
                alert('ERROR : ' + error);
            });
        } else {
            console.log(form);
        }
    };

});

app.controller('viewCtrl', function ($scope, $http, $routeParams, $rootScope) {

    $scope.disable = true;

    $scope.init = function () {
        $scope.getVisitor();
    };

    $scope.getVisitor = function () {
        $http({
            url: 'api/visitor/' + $routeParams.id,
            method: 'get'
        }).success(function (data, status) {
            if (status === 200) {
                console.log(data);
                $scope.visitor = data;
            } else {
                console.log('status:' + status);
            }
        }).error(function (error) {
            $rootScope.message = "Error occurred";
        });
    };

    $scope.cancel = function () {
        $http({
            url: 'api/visitor/' + $routeParams.id + '/cancel',
            method: 'get'
        }).success(function (data, status) {
            if (status === 200) {
                console.log('Cancelled');
                $scope.visitor = data;
            } else {
                console.log('status:' + status);
            }
        }).error(function (error) {
            $rootScope.message = "Error occurred";
        });
    };

    $scope.approve = function () {
        $http({
            url: 'api/visitor/' + $routeParams.id + '/approve',
            method: 'get'
        }).success(function (data, status) {
            if (status === 200) {
                console.log('Approved');
                $scope.visitor = data;
            } else {
                console.log('status:' + status);
            }
        }).error(function (error) {
            $rootScope.message = "Error occurred";
        });
    };

});