'use strict';

/**
 * @ngdoc function
 * @name auctionApp.controller:AddProductController
 * @description
 * # AddProductController
 * Controller of the auctionApp
 */
auctionApp
    .controller('AddProductController', ['$scope', '$location', 'AuthService', 'CategoryResource', 'ProductResource',
        function ($scope, $location, AuthService, CategoryResource, ProductResource) {
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

            function isWrongInputData(product) {
                return !product.validDate ||
                    isNaN(Date.parse(product.validDate)) ||
                    Date.parse(product.validDate) < new Date().getTime();
            }

            function isWrongInputPrice(product){
               return product.price <0;
            }

            function valid(product) {
                if (isWrongInputData(product)||isWrongInputPrice(product)) {
                    return false;
                } else {
                    return true;
                }
            }

            function getErrors(product){
            var errors=[];
                if(isWrongInputData(product)){
                    errors.push("You should enter valid date(Please use date picker). " +
                    "Input date/time should be bigger than now.");
                };

                if(isWrongInputPrice(product)){
                    errors.push("Product price cannot be less than 0.");
                };

                return errors;
            }
            function clearWrongInput(product){
                if(isWrongInputPrice(product)){product.price = ''}
                if(isWrongInputData(product)){product.validDate = ''}
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
                    bootbox.alert("Please check input data and try again. " + getErrors(product).toString());
                    clearWrongInput(product);
                }
            }

            populateCategories();
        }
    ]);