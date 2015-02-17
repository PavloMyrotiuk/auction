'use strict';

/**
 * @ngdoc function
 * @name auctionApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the auctionApp
 */
auctionApp
    .controller('LoginController', ['$scope','$rootScope',  '$location', 'LoginResource', function ($scope, $rootScope, $location, LoginResource) {
        $scope.rememberMe = true;

        $scope.credentials = {
            username: '',
            password: ''
        };

        $scope.login = function(credentials) {

            var successFn = function(){
                bootbox.alert("Yes" );
            }

            var errorFn = function(){
                bootbox.alert("No" );
            }

            LoginResource.authenticate($.param({username:$scope.credentials.username, password:$scope.credentials.password}),
                function(authenticationResult){
                    var authToken = authenticationResult.token;
                    $rootScope.authToken = authToken;
                    if ($scope.rememberMe){
                        $cookieStore.put('authToken', authToken);
                    }
                    //LoginResource.get(function(user){
                    //    $rootScope.user = user;
                    //    $location.path("/");
                    //});
                })
        };

    }]);