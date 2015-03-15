'use strict';

/**
 * @ngdoc function
 * @name auctionApp.controller:ProductController
 * @description
 * # ProductController
 * Controller of the auctionApp
 */
auctionApp
    .controller('ProductController', ['$scope','$rootScope', '$routeParams', 'ProductResource', 'BetResource',
        function ($scope,$rootScope, $routeParams, ProductResource, BetResource) {
            var betStep = 1;

            var product = {
                id: '',
                category: '',
                addedDate: '',
                validDate: '',
                price: '',
                title: '',
                description: '',
                productStatus: '',
                user: '',
                winner: '',
                version: '',
                bets:''
            };

            var id = $routeParams.id;
            
            $scope.canBet = function(){
                if ($scope.product) {
                    var expired = new Date() > $scope.product.validDate;
                    var differentOwner = $scope.product.user.userId !== $rootScope.user.userId;
                    return !expired && differentOwner;
                }
            };

            $scope.isEnded = function () {
                if ($scope.product) {
                    return new Date() > $scope.product.validDate;
                }
            };

            $scope.bet = function(betAmount){
                var betVO = {
                    amount: betAmount,
                    productId: $scope.product.id,
                    productVersion: $scope.product.version
                };

                BetResource.bet(betVO);
            };

            ProductResource.getById({id: id}, function (response) {
                $scope.product = response;
                $scope.betAmount = $scope.product.price + betStep;
                $scope.minBet = $scope.product.price + betStep;
            });
        }
    ]);