define([
  'marionette'
], function(Marionette) {
  'use strict';

  return Marionette.LayoutView.extend({
    el: '#todoapp',
    regions: {
      header: '#header',
      main: '#main',
      footer: '#footer'
    }
  });
});
