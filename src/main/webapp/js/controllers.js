var boardControllers = angular.module('boardControllers', []);

boardControllers.controller('boardListCtrl', ['$scope', '$http', 'Board', function($scope, $http, Board) {
    $scope.boards = Board.query();

    $scope.delete = function(id) {
        $http.defaults.headers.common['Accept'] = 'application/json';
        Board.delete({id:id}, function() {
            for (var i = 0; i < $scope.boards.length; i++) {
                if($scope.boards[i].id == id) {
                    $scope.boards.splice(i, 1);
                    break;
                }
            }
        });
    };

    $scope.create = function() {
        var board = {title:'title', content:'contents'};
        Board.create(board, function(newBoard) {
            $scope.boards.push(newBoard);
        });
    };

    $scope.update = function(board) {
        board.title = "change Title"
        Board.update(board, function(updateBoard){
            console.log(updateBoard);
        });
    }
}]);


boardControllers.controller('boardDetailCtrl', ['$scope', '$routeParams',
    function($scope, $routeParams) {
        $scope.boardId = $routeParams.boardId;
    }
]);