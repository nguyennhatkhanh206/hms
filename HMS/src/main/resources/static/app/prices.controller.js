var app = angular.module('app', []).constant('API', '/dongia/');
app.controller('prController', function($scope, $http, API) {
	$http.get(API + 'list').success(function(response) {
		$scope.pricess = response;
	});
	$scope.modal = function(state, idPr) {
		$scope.state = state;
		switch (state) {
		case "them":
			$scope.title = "Thêm giá mới";
			break;
		case "sua":
			$scope.title = "Cập nhật thông tin";
			$scope.idPr = idPr;
			$http.get(API + 'update/' + idPr).success(
					function(reponse) {
						$scope.price = reponse;

					})
			break;
		default:
			$scope.title = "Không biết";
			break;
		}
		$("#myModal").modal('show');

	}

	$scope.save = function(state, id) {

		if (state == 'them') {
			var url = API + 'add';
			$http({

				method : 'POST',
				url : url,
				data : JSON.stringify(

				{   
					"tenDG" : $scope.price.tenDG,
					"giaDemDG":$scope.price.giaDemDG,
					"giaGioDG" : $scope.price.giaGio,
					"phuThuCT" : $scope.price.phuThuCT,
					"phuThuM": $scope.price.phuThuM,
					"khuyenMai": $scope.price.khuyenMai,
				
				}

				),
				headers : {
					'Accept' : 'application/json',
					'Content-Type' : 'application/json'
				}

			}).success(function(response) {
				location.reload();
			}).error(function(response) {
				alert("Xay ra loi!");
			});

		}

		if (state == 'sua') {
			var url = API + 'update/' + id;
			$http({

				method : 'POST',
				url : url,
				data : JSON.stringify(

				{
					"tenDG" : $scope.price.tenDG,
					"giaDemDG":$scope.price.giaDemDG,
					"giaGioDG" : $scope.price.giaGio,
					"phuThuCT" : $scope.price.phuThuCT,
					"phuThuM": $scope.price.phuThuM,
					"khuyenMai": $scope.price.khuyenMai
				}

				),
				headers : {
					'Accept' : 'application/json',
					'Content-Type' : 'application/json'
				}

			}).success(function(response) {
				location.reload();
			}).error(function(response) {
				alert("Xay ra loi!");
			});
		}
	}
	$scope.del = function(id) {
		console.log(id);
		var Del = confirm("Are you sure ?");
		if (Del == true) {
			$http.get(API + 'delete/' + id).success(function(response) {
				location.reload();
			}).error(function(response) {
				alert("Error!");
			});

		}

	}
	
	$scope.det = function(idLp) {
		$scope.title = "Loại phòng";
		$http.get('/dongia/update/' + idLp).success(function(reponse) {
			$scope.pr = reponse;
		});
		$("#myKroomModal").modal('show');

	}

});