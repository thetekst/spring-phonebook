;(function($) {
    'use strict';

    $('#addNewContact').bind("click", function (e) {
        e.preventDefault();
        var baseUrl = window.location.pathname;
        var $form = $('#addUserForm');
        var fieldsArray = $form.serializeArray();

        var fields = {};

        $.each(fieldsArray, function (i, field) {
            fields[field.name] = field.value;
        });
        console.log(fields);

        if (fields.username != undefined && fields.phone != undefined) {
            $.post(baseUrl + '/user', $form.serialize(), function (rowId) {
                console.log(rowId);
                $form[0].reset();

                var template = '<tr item="' + rowId + '">';
                template += '<td>' + rowId + '</td>';
                template += '<td class="item-username">' + fields.username + '</td>';
                template += '<td class="item-phone">' + fields.phone + '</td>';
                template += '<td><a href="#edit-' + rowId + '" element-id="' + rowId + '" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>';
                template += '<td><a href="#remove-' + rowId + '" element-id="' + rowId + '"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>';
                template += '</tr>';

                $('table').append(template);
            });
        }
    });

    $("a[href*=remove-]").bind( "click", function(e) {
        e.preventDefault();
        var baseUrl = window.location.pathname;
        var $anchor = $(this);
        var $tr = $(this).parents('tr');
        var id = $anchor.attr('element-id');

        if($.isNumeric(id)) {
            $.ajax({
                url: baseUrl + 'user/remove/' + id,
                type: 'POST',
                success: function(result) {
                    $tr.remove();
                }
            });
        }

    });

    $("#saveModal").bind( "click", function(e) {
        var baseUrl = window.location.pathname;
        // var dataSerialize = $('.modal-body #updateForm').serialize();
        var fieldsArray = $('.modal-body #updateForm').serializeArray();

        var fields = {};

        $.each( fieldsArray, function( i, field ) {
            fields[field.name] = field.value;
        });

        if(fields.userid != undefined && fields.username != undefined && fields.phone != undefined) {

            $.post(baseUrl + 'user/update/' + fields.userid, fields, function(result) {
                $('#myModal').modal('hide');
                var $tr = $('[item=' + fields.userid + ']');
                $tr.find('.item-username').text(fields.username);
                $tr.find('.item-phone').text(fields.phone);
            });
        }
    });

    $('#myModal').on('shown.bs.modal', function (e) {
        var id = $(e.relatedTarget).attr('element-id');
        var baseUrl = window.location.pathname;
        var modal = $(this);
        console.log(id);

        if($.isNumeric(id)) {

            $.get(baseUrl + 'user/' + id, function(result) {
                $('#username').focus();
                console.log(result);
                modal.find('.modal-body input:hidden#userid').val(result.id);
                modal.find('.modal-body input#username').val(result.username);
                modal.find('.modal-body input#phone').val(result.phone);
            })
        }

    });

    $('#myModal').on('hidden.bs.modal', function (e) {
        var modal = $(this);
        modal.find('.modal-body input:hidden#userid').val();
        modal.find('.modal-body input#username').val();
        modal.find('.modal-body input#phone').val();
        console.log('hide modal and clear data')
    });

    $(function() {
        var log = console.log.bind(console);

    });
})(jQuery);