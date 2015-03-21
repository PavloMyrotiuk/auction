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

            function populateDateLogic() {
                $scope.dateFormat = DATE.FORMAT;
                $scope.minDate = new Date();
                var plusYearDate = new Date($scope.minDate);
                plusYearDate.setDate($scope.minDate.getDate() + DATE.YEAR);
                $scope.maxDate = plusYearDate;
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
                    typeof product.price !== "number") {
                    return false;
                } else {
                    return true;
                }
            }


            $scope.add = function (product) {
                (function getTimeFromDate() {
                    var time = Date.parse(product.validDate);
                    if (typeof time === "number" && !isNaN(time)) {
                        product.validDate = time;
                    }else{
                        product.validDate = "";
                    }
                })();
                if (valid(product)) {
                    product.userId = AuthService.getUserId();

                    ProductResource.post({}, product, function (response) {
                        var product = response;
                        var productId = product.id;
                        $location.path('/product/' + productId);
                    });
                } else {
                    bootbox.alert("Please check input data and try again.");
                }
            }

            populateCategories();

            populateDateLogic();
        }
    ]);