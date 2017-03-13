var app = angular.module('app', []).constant('API', '/phieudatphong/');

app.controller('dpController', function($scope, $http, API) {
	$http.get('/phieudatphong/list').success(function(response) {
		$scope.dsdatphong = response;
		$scope.dsdatphong.ngaydatPDP = new Date($scope.dsdatphong.ngaydatPDP);
		$scope.dsdatphong.ngayvaoPDP = new Date($scope.dsdatphong.ngayvaoPDP);
		$scope.dsdatphong.ngayraPDP = new Date($scope.dsdatphong.ngayraPDP);
		$scope.dsdatphong.hanTraPDP = new Date($scope.dsdatphong.hanTraPDP);
	});
	
	$http.get('/loaiphong/list').success(function(response) {
		$scope.dsloaiphong = response;
		
	});
	
	$http.get('/httt/list').success(function(response) {
		$scope.dshttt = response;
		
	});
	

	$scope.nhan = function(id) {
		var Del = confirm("Are you sure ?");
		if (Del == true) {
			$http.get(API + 'update/' + id).success(function(response) {
				$scope.datphong = response;
			});
			$scope.ngaynhan = new Date();
			var url = '/phieunhanphong/add';
			$http({

				method : 'POST',
				url : url,
				data : JSON.stringify(

				{
					"ngaynhan" : $scope.ngaynhan,
					"phieudatphong" : $scope.datphong,

				}

				),
				headers : {
					'Accept' : 'application/json',
					'Content-Type' : 'application/json'
				}

			}).success(function(response) {
				$("#nhanPhong").modal('show');
			}).error(function(response) {
				alert("Xay ra loi!");
			});

		}
	}

	$scope.thuephong = function(id, maLP) {
		$scope.listkhach = [];
		$scope.maLP = maLP;
		$scope.maphong=id;
		$scope.ngayvao=new Date();
		$("#themKhach").modal('show');
		console.log($scope.loaiphong);

	}

	/*
	 * Thêm khách
	 * 
	 */
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
		$scope.cmndKH = khach.cmndKH;
		$scope.khachhang.queQuanKH = khach.queQuanKH;
		$scope.khachhang.sdtKH = khach.sdtKH;
		$scope.khachhang.hoTenKH = khach.hoTenKH;
	}



	$scope.nhanphong = function() {

		for (var i = 0; i < $scope.listkhach.length; i++) {
			$scope.data = "";
			var khach = $scope.listkhach[i];
			$http.get('/khachhang/search/' + $scope.listkhach[i].cmndKH)
					.success(function(response) {
						$scope.data = response;
						if ($scope.data == "") {
							urlkhach = '/khachhang/add';
							$http({
								method : 'POST',
								url : urlkhach,
								data : JSON.stringify(

								{
									"cmndKH" : khach.cmndKH,
									"queQuanKH" : khach.queQuanKH,
									"hoTenKH" : khach.hoTenKH,
									"sdtKH" : khach.sdtKH,
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

						} else {
							urlkhach = '/khachhang/update/' + khach.cmndKH;
							$http({
								method : 'POST',
								url : urlkhach,
								data : JSON.stringify(

								{
									"cmndKH" : khach.cmndKH,
									"queQuanKH" : khach.queQuanKH,
									"hoTenKH" : khach.hoTenKH,
									"sdtKH" : khach.sdtKH,
									"tichluyKH" : $scope.data.tichluyKH
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
					});

		}
		$http.get('/loaiphong/update/' + $scope.maLP).success(
				function(response) {
					$scope.loaiphong = response;
					$http.get('/dongia/update/' + $scope.loaiphong.maDG).success(
							function(response) {
								$scope.dongia = response;
								$scope.tiendatra = $scope.dongia.giaDemDG
										* $scope.datphong.sodemPDP;
								console.log($scope.tiendatra);
								console.log($scope.datphong.sodemPDP);
								var url = '/phieuthuephong/add/' + $scope.maphong;
								$http({

									method : 'POST',
									url : url,
									data : JSON.stringify(

									{
										"ngayBD" : $scope.ngayvao,
										"loaithue" : 2,
										"tiendatra" : $scope.tiendatra,
										"ghiChu" :"",
										"khachhang" : $scope.listkhach,
									}),
									headers : {
										'Accept' : 'application/json',
										'Content-Type' : 'application/json'
									}

								}).success(
										function(response) {
											$scope.phongdata = "";
											$http.get('/phong/update/' + $scope.maphong).success(
													function(response) {
														$scope.phongdata = response;
														var url = '/phong/update/' + $scope.maphong
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


							});
				});

		
	}
	$scope.btntaophieu=function()
	{
		$("#taophieu").modal('show');
		$scope.ngaydat=new Date();
		$scope.dsp=[];
	}
	
	$scope.tieptucdp=function(){
		
		for(i=0;i<$scope.dsphong.length;i++)
			{
			$http.get('/phong/update/' + $scope.dsphong[i]).success(
					function(response) {
						$scope.p=response;
						$http.get('/loaiphong/update/' + $scope.p.maLP).success(
								function(dtresponse) {   
						$scope.loaiphong=dtresponse;
						$scope.dsp.push({
							maP : $scope.p.maP,
							trangThaiP : $scope.p.trangThaiP,
							loaiphong : $scope.loaiphong
						});
					});
					});
			
			}
		console.log($scope.httt);	
		$scope.ngayra=new Date($scope.ngayra)
		$http.get('/httt/update/'+$scope.httt).success(function(response) {
			$scope.shttt = response;
			console.log($scope.shttt);
								var url = '/phieudatphong/add' ;
								$http({

									method : 'POST',
									url : url,
									data : JSON.stringify({
										"tenDK":$scope.hoten,
										"cmndDK":$scope.cmnd,
										"emailDK":$scope.email,
										"ngaydatPDP":$scope.ngaydat,
										"ngayvaoPDP":$scope.ngayvao,
										"ngayraPDP":$scope.ngayra,
										"sodemPDP":$scope.sodem,
										"hinhthuctt":$scope.shttt,
										"ktthanhtoan":0,
										"ktnhanphong":0,
										"phong":$scope.dsp
										
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
		}
   $scope.nhan=function(id){
	   
   }
});