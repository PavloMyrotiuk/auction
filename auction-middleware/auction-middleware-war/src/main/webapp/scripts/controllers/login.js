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
            var hPassword = CryptoJS.SHA3(credentials.password);
            credentials.password = hPassword.toString();

            var successFn = function(){
                bootbox.alert("Yes" );
            }

            var errorFn = function(){
                bootbox.alert("No" );
            }

            LoginResource.authenticate($.param({username:credentials.username, password:credentials.password}),
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