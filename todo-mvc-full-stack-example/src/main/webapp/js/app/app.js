define([
  'backbone',
  'marionette',
  'app/controller',
  'app/router',
  'app/views/main-layout-view'
], function(Backbone, Marionette, AppController, AppRouter, MainLayoutView) {
  'use strict';

  var app = new Marionette.Application();

  app.on('before:start', function() {
    this.mainLayout = new MainLayoutView();
  });

  app.on('start', function() {
    var controller = new AppController({
      'rootView': this.mainLayout
    });

    controller.router = new AppRouter({
      controller: controller
    });

    controller.start();

    Backbone.history.start();
  });

  return app;
});
