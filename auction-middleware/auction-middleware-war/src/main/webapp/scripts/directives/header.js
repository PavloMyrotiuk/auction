'use strict';

/**
 * @ngdoc function
 * @name auctionApp.directive:ngHeader
 * @description
 * # ngHeader
 * Controller of the auctionApp
 */
auctionApp
    .directive('ngHeader', [function (){
            return {
                restrict: 'E',
                templateUrl: 'views/header.html'
            }
        }]);