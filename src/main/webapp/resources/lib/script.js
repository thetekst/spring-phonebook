;(function($) {
    'use strict';

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
                    console.log('deleted');
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
                console.log(result);
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
    });

    $(function() {
        var log = console.log.bind(console);

        log(window.location.pathname);
    });
})(jQuery);