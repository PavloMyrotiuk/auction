'use strict';

auctionApp
    .service('AuthService', ['$http', '$rootScope', '$cookieStore', 'SECURITY',
        function ($http, $rootScope, $cookieStore, SECURITY) {

            this.authenticate = function (authenticationResult) {
                var user = {
                    username: authenticationResult.username,
                    name: authenticationResult.name,
                    roles: authenticationResult.roles
                }
                $rootScope[SECURITY.AUTH_USER_KEY] = user;
                $cookieStore.put(SECURITY.AUTH_USER_KEY, user);
            };

            this.init = function () {
                if ($rootScope[SECURITY.AUTH_USER_KEY] === undefined) {
                    $rootScope[SECURITY.AUTH_USER_KEY] = $cookieStore.get(SECURITY.AUTH_USER_KEY);
                }
                ;
            };

            this.clear = function () {
                $rootScope[SECURITY.AUTH_USER_KEY] = undefined;
                $cookieStore.remove(SECURITY.AUTH_USER_KEY);
            };

            this.isAuthenticated = function () {
                var result = $rootScope[SECURITY.AUTH_USER_KEY] !== undefined;
                return result
            };

            return this;
        }]);