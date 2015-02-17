'use strict';

auctionApp
    .factory('UserResource', ['$resource', function ($resource) {
        return $resource("/auction-middleware/rest/user/", {}, {
            'save': {
                method: 'POST',
                interceptor: {responseError: resourceErrorInterceptor}
            }
        });
    }]);