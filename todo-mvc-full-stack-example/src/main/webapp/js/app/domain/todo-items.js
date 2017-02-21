define([
  "backbone",
  "app/domain/todo-item"
], function(Backbone, TodoItem) {
  "use strict";

  return Backbone.Collection.extend({
    model: TodoItem,
    url: "/api/todo-items",
    getCompleted: function () {
  	  return this.filter(this._isCompleted);
  	},
  	getActive: function () {
  	  return this.reject(this._isCompleted);
  	},
  	_isCompleted: function (todo) {
  	  return todo.isCompleted();
  	}
  });
});