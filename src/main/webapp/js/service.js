var boardServices = angular.module('boardServices', ['ngResource']);

boardServices.factory('Board', ['$resource',
    function($resource) {
        return $resource('restful/boards/:id', {id:'@id'}, {
            query: {method:'GET', isArray:true},
            create: {method:'POST'},
            update: {method: 'PUT'},
            delete: {method: 'DELETE'}
        });
    }
]);