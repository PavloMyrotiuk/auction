'use strict';

/**
 * @ngdoc function
 * @name auctionApp.controller:ProductController
 * @description
 * # ProductController
 * Controller of the auctionApp
 */
auctionApp
    .controller('ProductController', ['$scope', '$routeParams', 'ProductResource',
        function ($scope, $routeParams, ProductResource) {
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
                version: ''
            };

            var id = $routeParams.id;
            
            $scope.canBet = function(){
                if ($scope.product) {
                    return new Date() < $scope.product.validDate;
                }
            }

            $scope.bet = function(betAmount){
                console.log(product.id, betAmount);
            }

            ProductResource.getById({id: id}, function (response) {
                $scope.product = response;
                $scope.betAmount = $scope.product.price + betStep;
                $scope.minBet = $scope.product.price + betStep;
            });
        }
    ]);