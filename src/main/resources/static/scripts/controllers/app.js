/*jshint browser: true*/
/*global define, console*/
define([
  'jquery',
  'underscore',
  'marionette',
  'app',
  'models/users',
  'views/users',
  'models/exercises',
  'views/exercises',
  'models/programs',
  'views/programs',
  'models/certificates',
  'views/certificates'
],
  function($, _, Marionette, App, UsersModels, UsersViews, ExercisesModels, ExercisesViews,
    ProgramsModels, ProgramsViews, CertificatesModels, CertificatesViews) {
  'use strict';

    function setupApplicationLayout() {
      var applicationLayout = new UsersViews.Layout();
      var users = new UsersModels.Users();
        var usersView = new UsersViews.Users({
          collection: users
        });
        users.fetch();
        $.get('/api/v1/admin/user-type').done(function(data) {
          users._types = _.union({id: null, nameEn: ''}, data);
          users.trigger('sync');
        });
        users.on('user:new', function(model) {
          var user = new UsersModels.User();
          user._types = users._types;
          if (!_.isUndefined(model)) {
            user.set({
              id: model.get('id'),
              name: model.get('name'),
              email: model.get('email'),
              type: model.get('type')
            });
          }
          var userEditView = new UsersViews.NewUserLayout({
            model: user
          });
          user.on('user:back', function() {
            var usersView = new UsersViews.Users({
              collection: users
            });
            users.fetch();
            applicationLayout.mainUsers.show(usersView);
          });
          applicationLayout.mainUsers.show(userEditView);
        });
        App.mainRegion.show(applicationLayout);

        applicationLayout.mainUsers.show(usersView);
        
        var exercises = new ExercisesModels.Exercises();
        var exercisesView = new ExercisesViews.Exercises({
          collection: exercises
        });
        exercises.fetch();
        $.get('/api/v1/admin/exercise-category').done(function(data) {
          exercises._categories = _.union({id: null, nameEn: ''}, data);
          exercises.trigger('sync');
        });
        $.get('/api/v1/admin/exercise-type').done(function(data) {
          exercises._types = _.union({id: null, nameEn: ''}, data);
          exercises.trigger('sync');
        });
        exercises.on('exercise:new', function(model) {
          var exercise = new ExercisesModels.Exercise();
          exercise._categories = exercises._categories;
          exercise._types = exercises._types;
          if (!_.isUndefined(model)) {
            exercise.set({
              id: model.get('id'),
              category: model.get('category'),
              types: model.get('types'),
              exerciseId: model.get('exerciseId'),
              nameEn: model.get('nameEn'),
              nameNo: model.get('nameNo'),
              descriptionEn: model.get('descriptionEn'),
              descriptionNo: model.get('descriptionNo')
            });
          }
          var exerciseEditView = new ExercisesViews.NewExerciseLayout({
            model: exercise
          });
          exercise.on('exercise:back', function() {
            var exercisesView = new ExercisesViews.Exercises({
              collection: exercises
            });
            exercises.fetch();
            applicationLayout.mainExercises.show(exercisesView);
          });
          applicationLayout.mainExercises.show(exerciseEditView);
        });
        applicationLayout.mainExercises.show(exercisesView);

        var programs = new ProgramsModels.Programs();
        var programsView = new ProgramsViews.Programs({
          collection: programs
        });
        programs.fetch();
        programs.on('program:new', function(model) {
          var program = new ProgramsModels.Program();
          if (!_.isUndefined(model)) {
            program.set({
              id: model.get('id'),
              name: model.get('name'),
              fileName: model.get('fileName'),
              fileSize: model.get('fileSize'),
              fileType: model.get('fileType'),
              dataUrl: model.get('dataUrl'),
              parseUsers: model.get('parseUsers')
            });
          }
          var programEditView = new ProgramsViews.NewProgramLayout({
            model: program
          });
          program.on('program:back', function() {
            var programsView = new ProgramsViews.Programs({
              collection: programs
            });
            programs.fetch();
            applicationLayout.mainPrograms.show(programsView);
          });
          applicationLayout.mainPrograms.show(programEditView);
        });
        applicationLayout.mainPrograms.show(programsView);

        var certificates = new CertificatesModels.Certificates();
        var certificatesView = new CertificatesViews.Certificates({
          collection: certificates
        });
        certificates.fetch();
        certificates.on('certificate:new', function(model) {
          var certificate = new CertificatesModels.Certificate();
          if (!_.isUndefined(model)) {
            certificate.set({
              id: model.get('id'),
              code: model.get('code'),
              amountOfDays: model.get('amountOfDays'),
              activated: model.get('activated')
            });
          }
          var certificateEditView = new CertificatesViews.NewCertificateLayout({
            model: certificate
          });
          certificate.on('certificate:back', function() {
            var certificatesView = new CertificatesViews.Certificates({
              collection: certificates
            });
            certificates.fetch();
            applicationLayout.mainCertificates.show(certificatesView);
          });
          applicationLayout.mainCertificates.show(certificateEditView);
        });
        applicationLayout.mainCertificates.show(certificatesView);
    }

    return Marionette.Controller.extend({
      index: function () {
        setupApplicationLayout('');
      }
    });
  });
