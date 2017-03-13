var app = angular.module('app', []);

app.controller('dController', function($scope, $http) {
	$http.get('/doankhach/list').success(function(response) {
		$scope.dsdoan = response;
	});
	$scope.ktkhach=function(id){
		 $http.get('/khachhang/search/' + id).success(function(response) {
				$scope.khachhang=response;
		 });
	}
    $http.get('/loaiphong/list').success(function(response) {
				$scope.dsloaiphong=response;
		 });

	$scope.khachdoan = function(ma) {
		$scope.maD = ma;
		$http.get('/doankhach/update/'+ma).success(function(reponse) {
			$scope.doan = reponse.khachhang; });
		$("#doanKhach").modal('show');
	}
	function getSelectedIndex(id) {
		for (var i = 0; i < $scope.listthemkhach.length; i++)
			if ($scope.listthemkhach[i].cmndKH == id)
				return i;
		return -1;

	}
	
	function checkIndex(id) {
		for (var i = 0; i < $scope.doank.length; i++)
			if ($scope.doank[i].cmndKH == id)
				return i;
		return -1;

	}
	
	
	function chonxoa(id) {
		for (var i = 0; i < $scope.doan.length; i++)
			if ($scope.doan[i].cmndKH == id)
				return i;
		return -1;

	}

	$scope.xoakhach = function(id) {
		var ketqua = confirm('Are you sure?');
		if (ketqua == true) {
				var index = chonxoa(id);
				$scope.doan.splice(index, 1);	
				$http.get('/doankhach/update/' + $scope.maD).success(function(response) {
					$scope.doank = response;
					var url='/doankhach/update/'+$scope.maD;
					$http({

						method : 'POST',
						url : url,
						data : JSON.stringify({
							
						    
							"tenD":$scope.doank.tenD,
							"tenTruongD":$scope.doank.tenTruongD,
						    "cmndD":$scope.doank.cmndD,
							"tinhThanhD":$scope.doank.tinhThanhD,
							"emailD":$scope.doank.emailD,
							"sdtD":$scope.doank.sdtD,
						    "khachhang":$scope.doan
						}

						),
						headers : {
							'Accept' : 'application/json',
							'Content-Type' : 'application/json'
						}

					}).success(function(response) {
						$scope.xoa=false;
						$scope.them=true;
						$scope.capnhat=true;
					}).error(function(response) {
						alert("Xay ra loi!");
					});
				});
			
		}
	}
	$scope.luukhach = function(id) {
		var url = '/khachhang/update/' + id;
		$http({

			method : 'POST',
			url : url,
			data : JSON.stringify(

			{

				"cmndKH" : $scope.khachhang.cmndKH,
				"hoTenKH" : $scope.khachhang.hoTenKH,
				"queQuanKH" : $scope.khachhang.queQuanKH,
				"sdtKH" : $scope.khachhang.sdtKH,
				"tichLuyKH" : $scope.khachhang.tichLuyKH,
			}

			),
			headers : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			}

		}).success(
				function(response) {

					$http.get('/doankhach/update/' + $scope.maD).success(
							function(response) {
								$scope.doan = response.khachhang;
								$("#khach").modal('hide');
								$scope.capnhat = false;
							});

				}).error(function(response) {
			alert("Xay ra loi!");
		});
		$("#doanKhach").modal('show');

	}
	$(".close").click(function() {
		$("#myAlert").alert("close");
	});
	$scope.chonsuakhach = function(id) {
		 $http.get('/khachhang/search/' + id).success(function(response) {
				$scope.khachhang=response;});
		$("#khach").modal('show');
	}
	$scope.chonxoakhach=(function(id){
		var index = getSelectedIndex(id);
		$scope.listthemkhach.splice(index, 1);		
	});
	
    // Thêm đoàn mới
	$scope.btnthemdoan = function() {
		$("#ttDoan").modal('show');
	}
	
	// Xóa đoàn
	$scope.btnxoadoan=function(id){
		var Del = confirm("Are you sure ?");
		if (Del == true) {
			$http.get('/doankhach/delete/' + id).success(function(response) {
				location.reload();
			}).error(function(response) {
				alert("Error!");
			});

		}
	}
	
	$scope.btnsuadoan=function(id)
	{
		$scope.maD=id;
		$http.get('/doankhach/update/'+id).success(function(reponse) {
			$scope.doan = reponse; });
		$("#suattDoan").modal('show');
	}
	
	$scope.suattdoan=function()
	{
		var url='/doankhach/update/'+$scope.maD;
		$http({

			method : 'POST',
			url : url,
			data : JSON.stringify({
				"tenD":$scope.doan.tenD,
				"tenTruongD":$scope.doan.tenTruongD,
			    "cmndD":$scope.doan.cmndD,
				"tinhThanhD":$scope.doan.tinhThanhD,
				"emailD":$scope.doan.emailD,
				"sdtD":$scope.doan.sdtD,
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
    // Tạm lưu đoàn để tiếp tục thêm khách
	$scope.tieptuc = function() {
			var tenD=$scope.doan.tenD;
			var tenTruongD=$scope.doan.tenTruongD;
			$scope.doan.cmndD=$scope.doan.cmndD;
			$scope.doan.tinhThanhD=$scope.doan.tinhThanhD;
			$scope.doan.emailD=$scope.doan.emailD;
			$scope.doan.sdtD=$scope.doan.sdtD;
		    $("#themKhach").modal('show');
		    $scope.listthemkhach=[];
		   
	}
	
	$scope.themkhach = function() {
		var index = getSelectedIndex($scope.cmndKH);
		if(index==-1){
		$scope.listthemkhach.push(
		{
			cmndKH : $scope.cmndKH,
			queQuanKH : $scope.khachhang.queQuanKH,
			sdtKH : $scope.khachhang.sdtKH,
			hoTenKH : $scope.khachhang.hoTenKH
		});
		$scope.capnhat = true;
		}		
		else
			$scope.capnhat = false;
			
	} 
 
    function checkkhach(id)
    {
    	for (var i = 0; i < $scope.dskhach.length; i++)
			if ($scope.dskhach[i].cmndKH == id)
				return i;
		return -1;
    }
	
	$scope.luudoan=function(listthemkhach){
		$http.get('/khachhang/list').success(function(reponse) {
			$scope.dskhach=reponse;
			for(i=0;i<listthemkhach.length;i++)
			{	 
				    var index=checkkhach()
					if(index==-1){
						var url='/khachhang/add';
						$http({

							method : 'POST',
							url : url,
							data : JSON.stringify({
								"cmndKH" : listthemkhach[i].cmndKH,
								"queQuanKH" : listthemkhach[i].queQuanKH,
								"sdtKH" :listthemkhach[i].sdtKH,
								"hoTenKH" : listthemkhach[i].hoTenKH,
								"tichluyKH":0
							}),
							headers : 
							{
								'Accept' : 'application/json',
								'Content-Type' : 'application/json'
							}

						}).success(function(response) {
							
						}).error(function(response) {
							alert("Xay ra loi!"); });
				}
			
			}
		});
			
			
		var url='/doankhach/add';
		$http({

			method : 'POST',
			url : url,
			data : JSON.stringify({
				"tenD":$scope.doan.tenD,
				"tenTruongD":$scope.doan.tenTruongD,
			    "cmndD":$scope.doan.cmndD,
				"tinhThanhD":$scope.doan.tinhThanhD,
				"emailD":$scope.doan.emailD,
				"sdtD":$scope.doan.sdtD,
			    "khachhang":listthemkhach
			}

			),
			headers : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			}

		}).success(function(response) {
			var ketqua = confirm('Are you sure?');
			if (ketqua == false) {
			location.reload();
			$cope.themdoan=false;
			}
			else
			{
				$scope.listthemkhach=$scope.listthemkhach;
				$scope.ngayBD=new Date();
				$("#thueDoan").modal('show');	
			}
		}).error(function(response) {
			alert("Xay ra loi!");
		});
		
	}
	
	$scope.btnthemkhach=function(){
		$("#themttDoan").modal('show');
	}
    
	$scope.themktt=function(state){	
		$scope.state=state;
		$http.get('/khachhang/search/' +$scope.khachhang.cmndKH ).success(function(reponse) {
			$scope.kh= reponse;
			if($scope.kh=="")
				{
				var url='/khachhang/add';
				$http({

					method : 'POST',
					url : url,
					data : JSON.stringify({
						"cmndKH" : $scope.khachhang.cmndKH,
						"queQuanKH" : $scope.khachhang.queQuanKH,
						"sdtKH" : $scope.khachhang.sdtKH,
						"hoTenKH" : $scope.khachhang.hoTenKH,
						"tichluyKH":0
					}),
					headers : 
					{
						'Accept' : 'application/json',
						'Content-Type' : 'application/json'
					}

				}).success(function(response) {
					$("#doanKhach").modal('show');
					$scope.capnhat=true;
					$scope.doank=[];
					$http.get('/doankhach/update/'+$scope.maD).success(function(reponse) {
						$scope.doank = reponse.khachhang;
						$scope.doankh = reponse;
						var index= checkIndex($scope.khachhang.cmndKH);
						if(index==-1){
						$scope.themtrung=true;
						$scope.doank.push({
									cmndKH : $scope.khachhang.cmndKH,
									queQuanKH : $scope.khachhang.queQuanKH,
									sdtKH : $scope.khachhang.sdtKH,
									hoTenKH : $scope.khachhang.hoTenKH
								});
				        var url='/doankhach/update/'+$scope.maD;
						$http({

							method : 'POST',
							url : url,
							data : JSON.stringify({
								"tenD":$scope.doankh.tenD,
								"tenTruongD":$scope.doankh.tenTruongD,
							    "cmndD":$scope.doankh.cmndD,
								"tinhThanhD":$scope.doankh.tinhThanhD,
								"emailD":$scope.doankh.emailD,
								"sdtD":$scope.doankh.sdtD,
							    "khachhang":$scope.doank
							}

							),
							headers : {
								'Accept' : 'application/json',
								'Content-Type' : 'application/json'
							}

						}).success(function(response) {
							if($scope.state=='luu')
							{	
							$("#themttDoan").modal('hide');
							$http.get('/doankhach/update/'+$scope.maD).success(function(reponse) {
								$scope.doan = reponse.khachhang;
							});
							$scope.them=false;
							}
							else
							{
							$scope.themmoi=false;	
							}				
							
						}).error(function(response) {
							alert("Xay ra loi!");
						});
						}
						else
						{
							$scope.themtrung=false;
						}
					});
				}).error(function(response) {
					alert("Xay ra loi!");

				});
				}
			else
				{
				$("#doanKhach").modal('show');
				$scope.capnhat=true;
				$scope.doank=[];
				$http.get('/doankhach/update/'+$scope.maD).success(function(reponse) {
					$scope.doank = reponse.khachhang;
					var index= checkIndex($scope.khachhang.cmndKH);
					if(index==-1){
					$scope.doankh = reponse;
					$scope.doank.push({
						cmndKH : $scope.khachhang.cmndKH,
						queQuanKH : $scope.khachhang.queQuanKH,
						sdtKH : $scope.khachhang.sdtKH,
						hoTenKH : $scope.khachhang.hoTenKH
					});
					var url='/doankhach/update/'+$scope.maD;
					$http({

						method : 'POST',
						url : url,
						data : JSON.stringify({
							"tenD":$scope.doankh.tenD,
							"tenTruongD":$scope.doankh.tenTruongD,
						    "cmndD":$scope.doankh.cmndD,
							"tinhThanhD":$scope.doankh.tinhThanhD,
							"emailD":$scope.doankh.emailD,
							"sdtD":$scope.doankh.sdtD,
						    "khachhang":$scope.doank
						}

						),
						headers : {
							'Accept' : 'application/json',
							'Content-Type' : 'application/json'
						}

					}).success(function(response) {
						if($scope.state=='luu')
						{	
						$("#themttDoan").modal('hide');
						$http.get('/doankhach/update/'+$scope.maD).success(function(reponse) {
							$scope.doan = reponse.khachhang;
						});
						$scope.them=false;
						}
						else
						{
						$scope.themmoi=false;	
						}				
						
					}).error(function(response) {
						alert("Xay ra loi!");
					});
					}
					else
					{
						$scope.themtrung=false;
					}
				
				});
				
				}
			
		});	
	}
	$scope.thoat=function()
	{
		$("#themttDoan").modal('hide');	
		$http.get('/doankhach/update/'+$scope.maD).success(function(reponse) {
			$scope.doan = reponse.khachhang;
		});
	}
	
	$scope.tieptuctp=function(){
		$scope.ngayBD= new Date($scope.ngayBD);
		$scope.ngayTP=new Date($scope.ngayTP);
		$scope.loaithue=$scope.loaithue;
		$scope.ghichu=$scope.ghichu;
	
		$http.get('/phong/trangthai/grey').success(function(reponse) {
			$scope.dsphong = reponse;
		});
		
		$http.get('/doankhach/list').success(function(reponse) {
			$scope.dsdoankhach = reponse;
			$http.get('/doankhach/count').success(function(reponse) {
				$scope.idex = reponse;
				$scope.dskhachhang=$scope.dsdoankhach[$scope.idex-1].khachhang;	
				$scope.dk=$scope.dsdoankhach[$scope.idex-1];
			});
		});	
		$("#dsk").modal('show');
	}
	
	$scope.luuphieuthue=function()
	{
		console.log($scope.ngayBD);
		$scope.listkhach=[];
		$scope.doan=[];
		for(i=0;i<$scope.dskhachhang.length;i++){
			for(j=0;j>$scope.khachthue.length;j++){
				if($scope.dskhachhang[i].cmndKH==$scope.khachhang[j])
					{ 
					$scope.listkhach.push(

							{
								cmndKH : $scope.khachthue[j].cmndKH,
								queQuanKH : $scope.khachthue[j].queQuanKH,
								sdtKH : $scope.khachthue[j].sdtKH,
								hoTenKH : $scope.khachthue[j].hoTenKH
							});
					}
			}
		}
		$scope.doan.push(
				{   "maDK":$scope.dk.maDK,
					"tenD":$scope.dk.tenD,
					"tenTruongD":$scope.dk.tenTruongD,
				    "cmndD":$scope.dk.cmndD,
					"tinhThanhD":$scope.dk.tinhThanhD,
					"emailD":$scope.dk.emailD,
					"sdtD":$scope.dk.sdtD,
				    "khachhang":$scope.dk.khachhang
				});
		var url = '/phieuthuephong/add/' + $scope.phongthue;
		$http({

			method : 'POST',
			url : url,
			data : JSON.stringify(
			{
				"ngayBD" : $scope.ngayBD,
				"ngayTP" : $scope.ngayTP,
				"loaithue" : $scope.loaithue,
				"tiendatra" : $scope.tiendatra,
				"ghiChu" : $scope.ghichu,
				"khachhang" : $scope.listkhach,
				"doankhach": $scope.doan
			}),
			headers : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			}

		}).success(
				function(response) {
					$scope.phongdata = "";
					$http.get('/phong/update/' + $scope.phongthue).success(
							function(response) {
								$scope.phongdata = response;
								var url = '/phong/update/' + $scope.phongthue
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
	
	
	$scope.luuphieuthuett=function()
	{
		console.log($scope.ngayBD);
		$scope.listkhach=[];
		$scope.doan=[];
		for(i=0;i<$scope.dskhachhang.length;i++){
			for(j=0;j>$scope.khachthue.length;j++){
				if($scope.dskhachhang[i].cmndKH==$scope.khachhang[j])
					{ 
					$scope.listkhach.push(

							{
								cmndKH : $scope.khachthue[j].cmndKH,
								queQuanKH : $scope.khachthue[j].queQuanKH,
								sdtKH : $scope.khachthue[j].sdtKH,
								hoTenKH : $scope.khachthue[j].hoTenKH
							});
					}
			}
		}
		$scope.doan.push(
				{   "maDK":$scope.dk.maDK,
					"tenD":$scope.dk.tenD,
					"tenTruongD":$scope.dk.tenTruongD,
				    "cmndD":$scope.dk.cmndD,
					"tinhThanhD":$scope.dk.tinhThanhD,
					"emailD":$scope.dk.emailD,
					"sdtD":$scope.dk.sdtD,
				    "khachhang":$scope.dk.khachhang
				});
		var url = '/phieuthuephong/add/' + $scope.phongthue;
		$http({

			method : 'POST',
			url : url,
			data : JSON.stringify(
			{
				"ngayBD" : $scope.ngayBD,
				"ngayTP" : $scope.ngayTP,
				"loaithue" : $scope.loaithue,
				"tiendatra" : $scope.tiendatra,
				"ghiChu" : $scope.ghichu,
				"khachhang" : $scope.listkhach,
				"doankhach": $scope.doan
			}),
			headers : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			}

		}).success(
				function(response) {
					$scope.phongdata = "";
					$http.get('/phong/update/' + $scope.phongthue).success(
							function(response) {
								$scope.phongdata = response;
								var url = '/phong/update/' + $scope.phongthue
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
									$scope.listkhach=[];
									for(i=0;i<$scope.dskhachhang.length;i++){
										for(j=0;j>$scope.khachthue.length;j++){
											if($scope.dskhachhang[i].cmndKH!=$scope.khachhang[j])
												{ 
												$scope.listkhach.push(

														{
															cmndKH : $scope.khachthue[j].cmndKH,
															queQuanKH : $scope.khachthue[j].queQuanKH,
															sdtKH : $scope.khachthue[j].sdtKH,
															hoTenKH : $scope.khachthue[j].hoTenKH
														});
												}
										}
									}
								}).error(function(response) {
									alert("Xay ra loi!");

								});
							});
				}).error(function(response) {
			alert("Xay ra loi!");
		});

	}
});