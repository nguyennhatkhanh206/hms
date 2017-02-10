var app = angular.module('app', []);

app.controller('lpController', function($scope, $http) {
	$http.get('/loaiphong/list').success(function(response) {
		$scope.kindrooms = response;
	});

	$http.get('/dongia/list').success(function(response) {
		$scope.price = response;
	});
	$scope.modal = function(state, idLp) {
		$scope.state = state;
		switch (state) {
		case "them":
			$scope.title = "Thêm loại phòng";
			break;
		case "sua":
			$scope.title = "Cập nhật thông tin";
			$scope.idLp = idLp;
			$http.get('/loaiphong/update/' + idLp).success(function(reponse) {
				$scope.kindroom = reponse;
			})
			break;
		default:
			$scope.title = "Không biết";
			break;
		}
		$("#myModal").modal('show');

	}

	$scope.det = function(idLp) {
		$scope.title = "List room";
		$http.get('/loaiphong/update/' + idLp).success(function(reponse) {
			$scope.krooms = reponse;
		});
		$("#myRoomModal").modal('show');

	}

	$scope.save = function(state, idlp,iddg) {
		if (state == 'them') {
			var url = '/loaiphong/add/'+iddg;
			$http({

				method : 'POST',
				url : url,
				data : JSON.stringify(
				{
					"tenLP" : $scope.kindroom.tenLP,
					"dienTichLP" : $scope.kindroom.dienTichLP,
					"moTaLP" : $scope.kindroom.moTaLP,
					"soNguoiLP" : $scope.kindroom.soNguoiLP,
					"soGiuongLP" : $scope.kindroom.soGiuongLP,
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
			var url = '/loaiphong/update/' + idlp+'/'+iddg;
			$http({

				method : 'POST',
				url : url,
				data : JSON.stringify(

				{

					"tenLP" : $scope.kindroom.tenLP,
					"dienTichLP" : $scope.kindroom.dienTichLP,
					"moTaLP" : $scope.kindroom.moTaLP,
					"soNguoiLP" : $scope.kindroom.soNguoiLP,
					"soGiuongLP" : $scope.kindroom.soGiuongLP,
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
			$http.get('/loaiphong/delete/' + id).success(function(response) {
				location.reload();
			}).error(function(response) {
				alert("Xay ra loi!");
			});

		}

	}

	$scope.modalroom = function(state, idp) {
		$scope.title = "New room";

		$("#newroom").modal('show');

	}

});