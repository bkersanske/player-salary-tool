require(['jquery', 'views/app', 'router', 'viewManager'],
    function($, AppView, Router, ViewManager) {
        var appView = ViewManager.create({}, 'AppView', AppView);
        Router.initialize({appView: appView});
    }
);