var app = angular.module('app', []).constant('API', '/phieuthuephong/');
app.controller('ptpController', function($scope, $http, API) {
	$http.get('khachhang/seach').success(function(response) {
		$scope.phongs = response;
	});
	
	$scope.checkkhach = function(id) {
		$scope.title = "List room";
		$http.get('/khachhang/seach/' + id).success(function(reponse) {
			$scope.khachhang = reponse;
			$scope.kh=$scope.khachhang;
		});
	}
});
