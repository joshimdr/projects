define([
  'marionette',
  'app/domain/todo-items',
  'app/views/header-item-view',
  'app/views/footer-item-view',
  'app/views/todo-items-composite-view'
], function(Marionette, TodoItems, HeaderItemView, FooterItemView, TodoItemsCompositeView) {
  'use strict';

  return Backbone.Marionette.Object.extend({
    initialize: function(options) {
      this.rootView = options.rootView;
      this.todoList = new TodoItems();
    },
    start: function() {
      var that = this;

      this.todoList.fetch({
        success: function() {
          that.showTodoList(that.todoList);
          that.todoList.on('all', that.updateHiddenElements, that);
        }
      });
      this.showHeader(this.todoList);
      this.showFooter(this.todoList);
    },
    updateHiddenElements: function() {
      $('#main, #footer').toggle( !! this.todoList.length);
    },
    showHeader: function(todoList) {
      this.rootView.showChildView('header', new HeaderItemView({
        collection: todoList
      }));
    },
    showFooter: function(todoList) {
      this.rootView.showChildView('footer', new FooterItemView({
        collection: todoList
      }));
    },
    showTodoList: function(todoList) {
      this.rootView.showChildView('main', new TodoItemsCompositeView({
        collection: todoList
      }));
    }
  });
});