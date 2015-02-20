'use strict';

/**
 * @ngdoc function
 * @name auctionApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the auctionApp
 */
auctionApp
    .controller('SignUpController', ['$scope', 'UserResource', function ($scope, UserResource) {
        $scope.user = {
            password: '',
            name: '',
            username: ''
        };
        $scope.reset = function () {
            $scope.user = {
                password: '',
                name: '',
                username: ''
            };
        };

        $scope.submit = function (user) {

            var successFn = function(){
                $scope.reset();
                bootbox.alert("You have been registered. You may log in now." );
            }

            var errorFn = function(){
                user.password = '';
                bootbox.alert("Please try again later." );
            }

            UserResource.save({},user, successFn, errorFn);
        };
    }]);
