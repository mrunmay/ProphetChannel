var app = angular.module("app", ['ngRoute']);

app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/new', {
            'templateUrl': '/html/new.html',
            'controller': 'newCtrl'
        }).otherwise({
            redirectTo: '/new'
        });
}]);

app.controller('rootCtrl', function ($scope, $rootScope, $http) {

});

app.controller('newCtrl', function ($scope, $rootScope, $http) {

    $scope.submit = function (form) {
        if (!form.$invalid) {
            console.log(JSON.stringify($scope.visitors));
        } else {
            console.log(form);
        }
    };

});