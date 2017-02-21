requirejs.config({
  shim: {
    "backbone": {
      deps:    [ "jquery", "underscore" ],
      exports: "Backbone"
    },
    "marionette": {
      deps:    [ "backbone" ],
      exports: "Marionette"
    },
    "underscore": {
      exports: "_"
    }
  },
  paths: {
    // Vendor Dependencies
    "backbone":       "../vendor/backbone/backbone",
    "marionette":     "../vendor/backbone.marionette/lib/backbone.marionette",
    "handlebars":     "../vendor/handlebars/handlebars.amd",
    "jquery":         "../vendor/jquery/dist/jquery",
    "hbs":            "../vendor/require-handlebars-plugin/hbs",
    "underscore":     "../vendor/underscore/underscore"
  }
});

requirejs([
  "app/app"
],
function(App) {
  "use strict";

  App.start();
});