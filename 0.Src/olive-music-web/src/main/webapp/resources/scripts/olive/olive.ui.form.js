var oliveFormDecorator = (function () {
    var decorator = {};
    decorator.decorateDeleteForm = function (form) {
        var buttons = form.next().find('.EditButton .fm-button');
        buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
        buttons.eq(0).addClass('btn-danger').prepend('<i class="icon-trash"></i>');
        buttons.eq(1).prepend('<i class="icon-remove"></i>')
    };
    decorator.decorateSearchFilters = function (form) {
        form.find('.delete-rule').val('X');
        form.find('.add-rule').addClass('btn btn-xs btn-primary');
        form.find('.add-group').addClass('btn btn-xs btn-success');
        form.find('.delete-group').addClass('btn btn-xs btn-danger');
    };
    decorator.decorateSearchForm = function (form) {
        var dialog = form.closest('.ui-jqdialog');
        var buttons = dialog.find('.EditTable')
        buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'icon-retweet');
        buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'icon-comment-alt');
        buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'icon-search');
    };
    decorator.decorateEditForm = function (form, options) {
        //update buttons classes
        var buttons = form.next().find('.EditButton .fm-button');
        buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
        buttons.eq(0).addClass('btn-primary').prepend('<i class="icon-ok"></i>');
        buttons.eq(1).prepend('<i class="icon-remove"></i>')

        buttons = form.next().find('.navButton a');
        buttons.find('.ui-icon').remove();
        buttons.eq(0).append('<i class="icon-chevron-left"></i>');
        buttons.eq(1).append('<i class="icon-chevron-right"></i>');

        if (options) {
            $.each(options['controls'], function (index, obj) {
                decoratorControl(form,obj);
            })
            //{ctlId:xx,ctlType:switch/datepicker,ctlValues:{}}
        }
    };
    function decoratorControl(form,options) {
        if (options) {
            switch (options['ctlType']) {
                case 'switch':
                    form.find("input[name='"+options['ctlId']+"']").addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');
                    break;
                case 'datepicker':
                    form.find("input[name='" + options['ctlId'] + "']").datepicker({ format: 'yyyy-mm-dd',language:'zh-CN', autoclose: true });
                    break;
                case 'multiSelect':
                    form.find("#" + options['ctlId']).addClass("width-90 chosen-select").attr("multiple", "").attr("data-placeholder", "Choose a Item...").chosen();
                    form.find("#" + options['ctlId'] + "_chosen").attr("style", "width:200px");
                    break;
                case 'imagefile':
                    form.find("input[name='" + options['ctlId'] + "']").wrap('<div class="widget-main">').ace_file_input({
                        style:'well',
                        btn_choose : "Drop images here or click to choose",
                        btn_change:null,
                        no_icon: 'icon-picture',
                        droppable:true,
                        thumbnail:'small'//large | fit
                        //,icon_remove:null//set null, to hide remove/reset button
                        ,before_change:function(files, dropped) {
                            var allowed_files = [];
                            for(var i = 0 ; i < files.length; i++) {
                                var file = files[i];
                                if(typeof file === "string") {
                                    //IE8 and browsers that don't support File Object
                                    if(! (/\.(jpe?g|png|gif|bmp)$/i).test(file) ) return false;
                                }
                                else {
                                    var type = $.trim(file.type);
                                    if( ( type.length > 0 && ! (/^image\/(jpe?g|png|gif|bmp)$/i).test(type) )
											|| ( type.length == 0 && ! (/\.(jpe?g|png|gif|bmp)$/i).test(file.name) )//for android's default browser which gives an empty string for file.type
										) continue;//not an image so don't keep this file
                                }
								
                                allowed_files.push(file);
                            }
                            if(allowed_files.length == 0) return false;
			
                            return allowed_files;
                        }
                        /**,before_remove : function() {
                            return true;
                        }*/
					,
                        preview_error : function(filename, error_code) {
                            //name of the file that failed
                            //error_code values
                            //1 = 'FILE_LOAD_FAILED',
                            //2 = 'IMAGE_LOAD_FAILED',
                            //3 = 'THUMBNAIL_FAILED'
                            //alert(error_code);
                        }
			
                    }).on('change', function(){
                        //console.log($(this).data('ace_input_files'));
                        //console.log($(this).data('ace_input_method'));
                    });
                    break;
                case 'wysiwygeditor':
                    form.find("#" + options['ctlId']).addClass("wysiwyg-editor").ace_wysiwyg({
                        toolbar:
                        [
                            'font',
                            null,
                            'fontSize',
                            null,
                            { name: 'bold', className: 'btn-info' },
                            { name: 'italic', className: 'btn-info' },
                            { name: 'strikethrough', className: 'btn-info' },
                            { name: 'underline', className: 'btn-info' },
                            null,
                            { name: 'insertunorderedlist', className: 'btn-success' },
                            { name: 'insertorderedlist', className: 'btn-success' },
                            { name: 'outdent', className: 'btn-purple' },
                            { name: 'indent', className: 'btn-purple' },
                            null,
                            { name: 'justifyleft', className: 'btn-primary' },
                            { name: 'justifycenter', className: 'btn-primary' },
                            { name: 'justifyright', className: 'btn-primary' },
                            { name: 'justifyfull', className: 'btn-inverse' },
                            null,
                            { name: 'createLink', className: 'btn-pink' },
                            { name: 'unlink', className: 'btn-pink' },
                            null,
                            { name: 'insertImage', className: 'btn-success' },
                            null,
                            'foreColor',
                            null,
                            { name: 'undo', className: 'btn-grey' },
                            { name: 'redo', className: 'btn-grey' }
                        ],
                        'wysiwyg': {
                            fileUploadError: showErrorAlert
                        }
                    }).prev().addClass('wysiwyg-style2');
                    //$('#Description').ace_wysiwyg();
                    break;
            }
        }
    }

    function showErrorAlert(reason, detail) {
        var msg = '';
        if (reason === 'unsupported-file-type') { msg = "Unsupported format " + detail; }
        else {
            console.log("error uploading file", reason, detail);
        }
        $('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>' +
		 '<strong>File upload error</strong> ' + msg + ' </div>').prependTo('#alerts');
    }
    return decorator;
}())
