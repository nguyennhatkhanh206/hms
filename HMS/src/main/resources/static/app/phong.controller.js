var app = angular.module('app', []).constant('API', '/phong/');
app.controller('pController', function($scope, $http, API) {
	$http.get(API + 'list').success(function(response) {
		$scope.phongs = response;
	});
	$http.get('/loaiphong/list').success(function(response) {
		$scope.loaiphongs = response;
	});
	
	 $http.get('/httt/list').success(function(response) {
         $scope.dsachhttt=response;	
	 });
	$scope.ngayvao = new Date();
	$scope.modal = function(state, idP) {
		$scope.state = state;
		switch (state) {
		case "them":
			$scope.title = "Thêm phòng";
			break;
		case "sua":
			$scope.title = "Cập nhật thông tin";
			$scope.idP = idP;
			$http.get(API + 'update/' + idP).success(function(reponse) {
				$scope.phong = reponse;

			})
			break;
		default:
			$scope.title = "Không biết";
			break;
		}
		$("#myModal").modal('show');

	}

	$scope.save = function(state, id, malp) {

		if (state == 'them') {
			var url = API + 'add/' + malp;
			$http({

				method : 'POST',
				url : url,
				data : JSON.stringify(

				{
					"maP" : $scope.phong.maP,
					"trangThaiP" : "grey",

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

			var url = API + 'update/' + id + '/' + malp;
			$http({

				method : 'POST',
				url : url,
				data : JSON.stringify(

				{
					"maP" : $scope.phong.maP,
					"trangThaiP" : "grey",

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
	$scope.checkin = function(id) {
		$scope.maphong = id;
		$scope.title = "Nhận phòng " + id;
		$scope.listkhach = [];
		$("#themKhach").modal('show');
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

	$scope.nhanphong = function() {
		$("#nhanPhong").modal('show');
	}

	$scope.luu = function() {

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
		var url = '/phieuthuephong/add/' + $scope.maphong;
		$http({

			method : 'POST',
			url : url,
			data : JSON.stringify(

			{
				"ngayBD" : $scope.ngayvao,
				"ngayTP" : $scope.ngayra,
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

	}

	$scope.checkout = function(id) {
		$scope.phongdata = "";
		$http.get('/phong/update/' + id).success(
				function(response) {
					$scope.phongdata = response;
					var url = '/phong/update/' + id + '/'
							+ $scope.phongdata.maLP;
					$http({

						method : 'POST',
						url : url,
						data : JSON.stringify({

							"maP" : $scope.phongdata.maP,
							"trangThaiP" : "black",
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

				}).error(function(response) {
			alert("Xay ra loi!");
		});

	}

	$scope.btntraphong=function(id){
	$scope.ngaytao=new Date();
	$http.get('/phieuthuephong/sophieu/' + id).success(function(response) {
	  $scope.sp=response;	
	  $http.get('/phieuthuephong/dsphong/' + id).success(function(response) {
		   		           $scope.p=response;	
		   		           $scope.sophieu=$scope.p[$scope.sp-1].maPTP;
		   		           $scope.phieuthue=$scope.p[$scope.sp-1];
		   		           $scope.phieuthue.ngayBD = new Date($scope.phieuthue.ngayBD);
		   		        $scope.phieuthue.ngayTP = new Date($scope.phieuthue.ngayTP);
		   		      $http.get('/loaiphong/update/' + $scope.phieuthue.phong.maLP).success(function(response) {
		   		   	  $scope.loaiphong=response; 
		   		          $http.get('/dongia/update/' + $scope.loaiphong.maDG).success(function(response) {
			   		   	  $scope.dongia=response; 
			   		   	 
			   		   	  if($scope.phieuthue.loaithue==2)
			   		   		  {
			   		   		  $scope.tongtien=$scope.dongia.giaGioDG * $scope.phieuthue.sogio;
			   		   		  }
			   		   	  else
			   		   	      $scope.tongtien=$scope.dongia.giaDemDG * $scope.phieuthue.sodem;
			   		   	  
			   		     }); 
		   		          
		   		          
		   		      });
		   		     
		   		});    
		});
	$("#hoadon").modal('show');
	
	}
	$scope.btnchuyenphong=function(id)
	{
		$scope.maP=id;
		$http.get('/phieuthuephong/sophieu/' + id).success(function(response) {
			  $scope.sp=response;	
			  $http.get('/phieuthuephong/dsphong/' + id).success(function(response) {
				   		           $scope.p=response;	
				   		           $scope.sophieu=$scope.p[$scope.sp-1].maPTP;
				   		           $scope.phieuthue=$scope.p[$scope.sp-1];
				   		           $scope.sp.push(

				   		        		{
				   		        		ngayBD : $scope.phieuthue.ngayBD,
				   		 				ngayTP:$scope.phieuthue.ngayTP,
				   		 				loaithue : $scope.phieuthue.loaithue,
				   		 				tiendatra : $scope.phieuthue.tiendatra,
				   		 				ghiChu : $scope.phieuthue.ghiChu,
				   		 				khachhang: $scope.phieuthue.khachhang,
				   		        		});
			  });
		});
		$http.get('/phong/trangthai/grey').success(function(response) {
			  $scope.dsphong=response;	
		})
		$("#chuyenphong").modal('show');
	}
	
	$scope.chuyenphong=function()
	{
		
		var url = '/phieuthuephong/update/' + $scope.phieuthue.maPTP +'/'+$scope.phongchuyen;
		$http({

			method : 'POST',
			url : url,
			data : JSON.stringify(

			{
				
				
			}),
			headers : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			}

		}).success(function(response) {
			var urlK = '/phong/update/' + $scope.maP;
			$http({

				method : 'POST',
				url : urlK,
				data : JSON.stringify(

				{
					"trangThaiP" : "grey"
					
				}),
				headers : {
					'Accept' : 'application/json',
					'Content-Type' : 'application/json'
				}

			}).success(function(response) {
				var urlK = '/phong/update/' + $scope.phongchuyen;
				$http({

					method : 'POST',
					url : urlK,
					data : JSON.stringify(

					{
						"trangThaiP" : "red"
						
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
			}).error(function(response) {
				alert("Xay ra loi!");
			});		
		}).error(function(response) {
			alert("Xay ra loi!");
		});
	}
     $scope.dondep=function(id)
     {
    	 var urlK = '/phong/update/' + id;
			$http({

				method : 'POST',
				url : urlK,
				data : JSON.stringify(

				{
					"trangThaiP" : "grey"
					
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
      }
     
     $scope.traphong=function(id){
    
    	 console.log($scope.phieuthue);
    	 $scope.tongtientong=$scope.tongtien *((100-$scope.khuyenmai)/100) + $scope.phieuthue.quaGio + $scope.phuthu;
    	 $http.get('/httt/update/' + $scope.httt).success(function(response) {
		           $scope.hinhthuc=response;	   
    	
    	 var urlK = '/hoadon/add/'+$scope.phieuthue.maPTP;
			$http({

				method : 'POST',
				url : urlK,
				data : JSON.stringify(

				{
					"ngayHD" : $scope.ngaytao,
					"tongtien": $scope.tongtientong,
					"tienphong":$scope.tongtien,
					"phuthu":$scope.phuthu,
					"khuyenmai":$scope.khuyenmai,
					"ktthanhtoan":1,
					"hinhthuctt":$scope.hinhthuc
					
				}),
				headers : {
					'Accept' : 'application/json',
					'Content-Type' : 'application/json'
				}

			}).success(function(response) {
		        location.reload();	
			});
		           
    	  })
     }
});
