define(['jquery', 'underscore', 'backbone', 'moment'],
    function ($, _, Backbone, moment) {

        var Player = Backbone.Model.extend({
            idAttribute: "pid",
            defaults: {
                tentativeSalary: null,
                isDisabledFromDrafting: null,
                atabbr: null,
                atid: null,
                fn: null,
                htabbr: null,
                htid: null,
                i: null,
                ln: null,
                pid: null,
                pn: null,
                s: null,
                tid: null
            },

            forTemplate: function() {
                var j = $.extend(true, {}, this.attributes);
                j.isInjured = (this.get("i") !== null && this.get("i").length);
                j.formattedSalary = "$" + commaNumberFormatter(this.get("s"));
                j.upcomingGame = this.get("atabbr") + " @ " + this.get("htabbr");
                return j;
            },

            save: function(attrs, options) {
                options = (options || {});
                attrs = $.extend(true, {}, this.attributes, attrs);
                delete attrs.tentativeSalary;
                Backbone.Model.prototype.save.call(this, attrs, options);

            }
        });

        return Player;

    }
);