var app = angular.module('app', []).constant('API', '/phieuthuephong/');

app.controller('tpController', function($scope, $http, API) {
	$http.get('/phieuthuephong/list').success(function(response) {
		$scope.dsthuephong = response;
		$scope.dsthuephong.ngayBD = new Date($scope.dsthuephong.ngayBD);
		$scope.dsthuephong.ngayTP = new Date($scope.dsthuephong.ngayTP);

	});
	
	$http.get('/phong/trangthai/grey').success(function(response) {
		$scope.dsloaiphong = response;
	
	});
	
	
	$http.get('/phong/list').success(function(response) {
		$scope.dsphong = response;
	});
	
	$scope.btntaophieu = function() {
		$("#themKhach").modal('show');
		$scope.ngayBD = new Date();
		$scope.listkhach = [];
	}

	$scope.nhanphong = function() {
		$("#nhanPhong").modal('show');
	}

	$scope.checkkhach = function(id) {
		$http.get('/khachhang/search/' + id).success(function(reponse) {
			$scope.khachhang = reponse;

		});
	}

	function getSelectedIndex(id) {
		for (var i = 0; i < $scope.listkhach.length; i++)
			if ($scope.listkhach[i].cmndKH == id)
				return i;
		return -1;

	}
	

	function checkkhach(id) {
		for (var i = 0; i < $scope.dskhach.length; i++)
			if ($scope.dskhach[i].cmndKH == id)
				return i;
		return -1;

	}
	
	$scope.luukhach = function() {

		$scope.listkhach.push(
		{
			cmndKH : $scope.cmndKH,
			queQuanKH : $scope.khachhang.queQuanKH,
			sdtKH : $scope.khachhang.sdtKH,
			hoTenKH : $scope.khachhang.hoTenKH
		});

	}

	$scope.xoakhach = function(id) {
		var ketqua = confirm('Are you sure?');
		if (ketqua == true) {
			var index = getSelectedIndex(id);
			$scope.listkhach.splice(index, 1);
		}
	}
	$scope.suakhach = function() {
		var index = getSelectedIndex($scope.cmndKH);
		$scope.listkhach[index].cmndKH = $scope.cmndKH;
		$scope.listkhach[index].queQuanKH = $scope.khachhang.queQuanKH;
		$scope.listkhach[index].sdtKH = $scope.khachhang.sdtKH;
		$scope.listkhach[index].hoTenKH = $scope.khachhang.hoTenKH;
	}
	$scope.chonsuakhach = function(id) {
		var index = getSelectedIndex(id);
		var khach = $scope.listkhach[index];
		console.log(index);
		$scope.cmndKH = khach.cmndKH;
		$scope.khachhang.queQuanKH = khach.queQuanKH;
		$scope.khachhang.sdtKH = khach.sdtKH;
		$scope.khachhang.hoTenKH = khach.hoTenKH;
	}

	$scope.tieptuc = function() {
		$("#nhanPhong").modal('show');
		$scope.ngayvao= new Date();
	}
	$scope.luu = function(id) {$http.get('/khachhang/list')
		.success(function(response) {
			$scope.dskhach = response;
		for (var i = 0; i < $scope.listkhach.length; i++) {
			         
					   var index=checkkhach($scope.listkhach[i].cmndKH)	;
					  console.log(index);
						if (index==-1) {
							urlkhach = '/khachhang/add';
							$http({
								method : 'POST',
								url : urlkhach,
								data : JSON.stringify(

								{
									"cmndKH" : $scope.listkhach[i].cmndKH,
									"queQuanKH" : $scope.listkhach[i].queQuanKH,
									"hoTenKH" : $scope.listkhach[i].hoTenKH,
									"sdtKH" : $scope.listkhach[i].sdtKH,
									"tichluyKH" : 0
								}

								),
								headers : {
									'Accept' : 'application/json',
									'Content-Type' : 'application/json'
								}

							}).success(function(response) {

							}).error(function(response) {
								alert("Xay ra loi!");
							});

						} 
				

		}
		});
		var url = '/phieuthuephong/add/' + $scope.dsphong;
		$http({

			method : 'POST',
			url : url,
			data : JSON.stringify(

			{
				"ngayBD" : $scope.ngayvao,
				"ngayTP":$scope.ngayra,
				"loaithue" : $scope.loaithue,
				"tiendatra" : $scope.tiendatra,
				"ghiChu" : $scope.ghichu,
				"khachhang" : $scope.listkhach,
			
			}),
			headers : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			}

		}).success(
				function(response) {
				
					$http.get('/phong/update/' + $scope.dsphong).success(
							function(response) {
								$scope.phongdata = response;
								var url = '/phong/update/' + $scope.dsphong
										+ '/' + $scope.phongdata.maLP;
								$http({

									method : 'POST',
									url : url,
									data : JSON.stringify({

										"maP" : $scope.phongdata.maP,
										"trangThaiP" : "red",
									}),
									headers : {
										'Accept' : 'application/json',
										'Content-Type' : 'application/json'
									}

								}).success(function(response) {
									location.reload();
								}).error(function(response) {
									alert("Xay ra loi!");

								});
							});
				}).error(function(response) {
			alert("Xay ra loi!");
		});
		
	}

});