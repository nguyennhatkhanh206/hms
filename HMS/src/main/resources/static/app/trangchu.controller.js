var app = angular.module('app', []);

app.controller('tcController', function($scope, $http) {
	$http.get('/loaiphong/list').success(function(response) {
		$scope.dsloaiphong= response;
	});
	
	$http.get('/dongia/list').success(function(response) {
		$scope.dsdongia= response;
		
	});
	
;
	$scope.tinhsodem=function(){
		if($scope.ngayra=="" || $scope.ngayra=="")
		{
			$scope.sodem=0;
		}
		else
		{
		var dateB = moment($scope.ngayra,"MM-DD-YYYY");
		var dateC = moment($scope.ngayvao,"MM-DD-YYYY");
		$scope.sodem=dateB.diff(dateC, 'days')
		}	
	}
	function getIndex(id) {
		for (var i = 0; i < $scope.dsphong.length; i++)
			if ($scope.dsphong[i].maP == id)
				return i;
		return -1;

	}
	$scope.timkiem=function(){
	$scope.phongloai=[];
	//Tim phieu thue phong
	$http.get('/phieuthuephong/dsthue/'+ $scope.ngayvao).success(function(response) {
		$scope.dsphongthue= response;
		for(i=0;i<$scope.dsphongthue.length;i++)
		{   $scope.p=$scope.dsphongthue[i].phong;
			$scope.phongloai.push({
				maP:$scope.p.maP	
			});
		}
		$http.get('/phieudatphong/dsdat/'+ $scope.ngayvao).success(function(response) {
			$scope.dsphongdat= response;	
			for(i=0;i<$scope.dsphongdat.length;i++)
			{   $scope.pd=$scope.dsphongdat[i].phong;
			    for(i=0;i<$scope.pd.length;i++)
				{$scope.phongloai.push({
					maP:$scope.pd[i].maP	
				});	
				}
			}
			$http.get('/phong/list').success(function(response) {
				$scope.dsp= response;
				$scope.dsphong=[];
				for(i=0;i<$scope.dsp.length;i++)
				{
					$scope.dsphong.push({
						maP:$scope.dsp[i].maP,
						tenLP:$scope.dsp[i].tenLP
					});	
				}
				for(i=0;i<$scope.phongloai.length;i++)
					{
					  for(j=0;j<$scope.dsp.length;j++)
						  {
						     if($scope.phongloai[i].maP==$scope.dsp[j].maP)
						    	 {
						    	    var ma=getIndex($scope.phongloai[i].maP)
						    	    $scope.dsphong.splice(ma, 1);
						    	 }
						  }
					} 
				$scope.phonggia=[];
				for(i=0;i<$scope.dsphong.length;i++)
				{for(j=0;j<$scope.dsdongia.length;j++){
					if($scope.dsphong[i].maLP==$scope.dsdongia[j].loaiphong.maLP)
						{
						  $scope.phonggia.push({
							  phong:$scope.dsphong[i],
							  dongia:$scope.dsdongia[j]
						  });
						}
				}
				}	
				console.log($scope.dsphong);
				console.log($scope.phonggia);
				$scope.thu=true;
				$scope.trangchu=false;
			});
			
		});
	});
	}
	$scope.btndatphong=function(id){
		$scope.datphong=true;
		$scope.thu=false;
		$scope.khungtimkiem=false;
		$scope.maphong=id;
		$http.get('/phong/update/'+ $scope.maP).success(function(response) {
			$scope.phong= response;	
		});
	}
	$scope.luudatphong=function(){
		console.log($scope.thanhtoan);
	}
	 

});