'use strict';

auctionApp
    .factory('CategoryResource', ['$resource', function ($resource) {
        return $resource("/auction-middleware/rest/category/hierarchy", {}, {
            'getHierarchy': {method: 'GET', isArray: true}
        });
    }]);