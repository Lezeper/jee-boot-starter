angular.module('footer', []).controller('footerController', function($scope, $http){
	
	var date = new Date();
	
	this.angular_ = "AnuglarJS Setup!";
	$scope.FromDate = date.getFullYear();
});