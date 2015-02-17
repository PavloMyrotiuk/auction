'use strict';

function resourceErrorInterceptor(response){
    console.log("Error occured: ", response.headers('exception'))
}