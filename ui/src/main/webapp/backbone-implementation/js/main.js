// global utility function for formatting numbers with commas.
var commaNumberFormatter = function(value) {
    if (parseFloat(value) < 1000) {
        return value;
    } else {
        return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }
};

require(['jquery', 'views/app', 'router', 'viewManager'],
    function($, AppView, Router, ViewManager) {
        var appView = ViewManager.create({}, 'AppView', AppView);
        Router.initialize({appView: appView});
    }
);