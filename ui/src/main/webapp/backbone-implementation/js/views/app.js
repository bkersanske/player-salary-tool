define(['jquery', 'underscore', 'backbone', 'handlebars', 'viewManager', 'templates'],
    function($, _, Backbone, Handlebars, ViewManager) {

        var AppView = Backbone.View.extend({

            el: 'body',

            initialize: function (options) {
                this.render();
            },

            render: function() {
                $(this.el).html(Handlebars.templates.layout);
            }
        });

        return AppView;
    }
);