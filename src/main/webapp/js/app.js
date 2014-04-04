var boardApp = angular.module('boardApp', 
		['ngRoute', 'boardControllers','boardServices']);

boardApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/boards', {
		templateUrl:'board-list.html',
		controller: 'boardListCtrl'
	}).when('/boards/:boardId', {
        templateUrl:'board-detail.html',
        controller: 'boardDetailCtrl'
    }).otherwise({
        redirectTo: '/boards'
    });
}]);
