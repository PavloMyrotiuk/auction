'use strict';

/**
 * @ngdoc function
 * @name auctionApp.controller:AddProductController
 * @description
 * # AddProductController
 * Controller of the auctionApp
 */
auctionApp
    .controller('AddProductController', ['$scope', '$location', 'AuthService', 'CategoryResource', 'ProductResource', 'DATE',
        function ($scope, $location, AuthService, CategoryResource, ProductResource, DATE) {
            $scope.product = {
                category: '',
                validDate: '',
                price: '',
                title: '',
                description: '',
                userId: ''
            };

            function populateCategories() {
                CategoryResource.getHierarchy({}, function (response) {
                    var mapCategoryStatus = {};
                    var r = 0;
                    for (var i = 0; i < response.length; i++) {
                        mapCategoryStatus[r++] = {name: response[i].name, disabled: true}
                        for (var j = 0; j < response[i].childrenCategories.length; j++) {
                            mapCategoryStatus[r++] = {
                                name: response[i].childrenCategories[j].name,
                                disabled: false
                            }
                        }
                    }
                    ;

                    var _select = $('#selectCategory');
                    $.each(mapCategoryStatus, function (key, value) {
                        if (value.disabled) {
                            _select.append($('<option></option>').val(value.name).html(value.name).attr('disabled', true));
                        } else {
                            _select.append($('<option></option>').val(value.name).html(' &nbsp &nbsp ' + value.name));
                        }
                    });
                });

            };

            $scope.open = function ($event) {
                $event.preventDefault();
                $event.stopPropagation();

                $scope.opened = true;
            };

            function valid(product) {
                if (!product.validDate ||
                    typeof product.price !== "number" ||
                    isNaN(Date.parse(product.validDate)) ||
                    Date.parse(product.validDate) < new Date() ||
                    product.price < 0) {
                    return false;
                } else {
                    return true;
                }
            }

            function getProductVO(product) {
                var productVO = {};
                productVO.category = product.category;
                productVO.validDate = Date.parse(product.validDate);
                productVO.price = product.price;
                productVO.title = product.title;
                productVO.description = product.description;
                return productVO;
            }


            $scope.add = function (product) {
                if (valid(product)) {
                    ProductResource.post({}, getProductVO(product), function (response) {
                        var product = response;
                        var productId = product.id;
                        $location.path('/product/' + productId);
                    });
                } else {
                    bootbox.alert("Please check input data and try again.");
                }
            }

            populateCategories();
        }
    ]);