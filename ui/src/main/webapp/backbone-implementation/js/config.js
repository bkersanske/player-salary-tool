// Set the require.js configuration for your application.
require.config({

    // Initialize the application with the main application file
    deps: ['main'],

    /* Configure shortcuts to the commonly used third party libraries. */
    paths: {
        jquery: '../../js/vendor/jquery-2.1.4.min',
        datatables: '../../js/vendor/jquery.dataTables',
        underscore: '../../js/vendor/underscore-min',
        backbone: '../../js/vendor/backbone-min',
        modernizr: '../../js/vendor/modernizr-2.8.3.min',
        bootstrap: '../../js/bootstrap/js/bootstrap.min',
        handlebars: '../../js/vendor/handlebars.runtime',
        moment: '../../js/vendor/moment',
        templates: 'compiled-templates'
    },

    /* Configure library dependencies and exported variables. */
    shim: {
        'bootstrap': {
            deps: ['jquery']
        },
        'underscore': {
            exports: '_'
        },
        'backbone': {
            deps: ['underscore', 'jquery'],
            exports: 'Backbone'
        },
        'modernizr': {
            exports: 'Modernizr'
        },
        'moment': {
            exports: 'moment'
        },
        'handlebars': {
            exports: 'Handlebars'
        },
        'templates': {
            deps: ['handlebars'],
            exports: 'Handlebars.templates'
        }
    },
    /* Cache busting URL argument. Change the v to be equal to the current date/time whenever major JS updates are made. */
    urlArgs: "v=8-9-15"
});