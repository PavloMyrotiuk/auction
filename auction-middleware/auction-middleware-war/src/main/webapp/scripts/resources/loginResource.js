'use strict';

auctionApp
    .factory('LoginResource', ['$resource', function ($resource) {
        return $resource("/auction-middleware/rest/auth/:action", {}, {
            'authenticate': {
                method: 'POST',
                params: {'action': 'authenticate'},
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                interceptor: {responseError: resourceErrorInterceptor}
            }
        });
    }]);