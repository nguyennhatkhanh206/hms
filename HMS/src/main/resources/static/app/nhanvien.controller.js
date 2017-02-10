var app = angular.module('app', []).constant('API', '/nhanvien/');
app.controller('nvController', function($scope, $http, API) {
	$http.get(API + 'list').success(function(response) {
		$scope.nhanviens = response;
	});

	$scope.modal = function(state, idNv) {
		$scope.state = state;
		switch (state) {
		case "them":
			$scope.title = "Thêm nhân viên";
			$scope.datas = [ {
				'id' : 1,
				'label' : 'Admin'
			}, {
				'id' : 2,
				'label' : 'Nhân viên'
			}, ]
			break;
		case "sua":
			$scope.title = "Update information";
			$scope.idNv = idNv;
			$http.get(API + 'update/' + idNv).success(
					function(reponse) {
						$scope.nhanvien = reponse;
						$scope.nhanvien.ngaySinhNV = new Date(
								$scope.nhanvien.ngaySinhNV);
						$scope.nhanvien.ngayLamNV = new Date(
								$scope.nhanvien.ngayLamNV);
						$scope.datas = [ {
							'id' : 1,
							'label' : 'Admin'
						}, {
							'id' : 2,
							'label' : 'Nhân viên'
						}, ]

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
					"maNV" : $scope.nhanvien.maNV,
					"tenNV" : $scope.nhanvien.tenNV,
					"diaChiNV" : $scope.nhanvien.diaChiNV,
					"sdtNV" : $scope.nhanvien.sdtNV,
					"ngaySinhNV" : $scope.nhanvien.ngaySinhNV,
					"ngayLamNV" : $scope.nhanvien.ngayLamNV,
					"matKhauNV" : $scope.nhanvien.matKhauNV,
					"quyenNV" : $scope.nhanvien.quyenNV

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
					"maNV" : $scope.nhanvien.maNV,
					"tenNV" : $scope.nhanvien.tenNV,
					"diaChiNV" : $scope.nhanvien.diaChiNV,
					"sdtNV" : $scope.nhanvien.sdtNV,
					"ngaySinhNV" : $scope.nhanvien.ngaySinhNV,
					"ngayLamNV" : $scope.nhanvien.ngayLamNV,
					"matKhauNV" : $scope.nhanvien.matKhauNV,
					"quyenNV" : $scope.nhanvien.quyenNV

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
				alert("Xay ra loi!");
			});

		}

	}

});