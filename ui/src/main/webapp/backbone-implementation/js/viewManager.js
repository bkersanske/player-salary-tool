/**
 * The ViewManager manages the initialization of views by cleaning out any old event bindings.
 * It also manages the creation of child views of a specific view.
 */
define(['jquery', 'underscore', 'backbone'],
    function($, _, Backbone) {

        var views = {};
        var create = function(context, name, View, options) {
            if(typeof views[name] !== 'undefined') {
                logger.debug(name + " view will be cleaned.");
                views[name].undelegateEvents();
                if(typeof views[name].clean === 'function') {
                    views[name].clean();
                }
            }
            var view = new View(options);
            views[name] = view;
            if(typeof context.children === 'undefined') {
                context.children = {};
                context.children[name] = view;
            } else {
                context.children[name] = view;
            }
            return view;
        };

        var destroy = function(name) {
            if(typeof views[name] !== 'undefined') {
                logger.debug(name + " will be destroyed");
                views[name].undelegateEvents();
                if(typeof views[name].clean === 'function') {
                    views[name].clean();
                }
                views[name].remove();
                delete views[name];
            }
        };

        var get = function(name) {
            if(typeof views[name] !== 'undefined') {
                return views[name];
            }
        };

        return {
            create: create,
            destroy: destroy,
            get: get
        };
    }
);