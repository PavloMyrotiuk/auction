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
            var product = {
                category: ''
            }

            var categoryName;
            if (!categoryName) {
                categoryName = $routeParams.categoryName;
                product.category = categoryName;

                $scope.products = ProductResource.getByTemplate(product);
            }
        }
    ]);