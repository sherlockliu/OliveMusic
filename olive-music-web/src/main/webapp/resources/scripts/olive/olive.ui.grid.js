define(['overlay','olivelib/olive.ui.decorator'],function(require,exports,module){
    "use strict";
    $.fn.oliveGrid = function (options) {
        var settings = $.extend({
            datatype: "json",
            viewrecords: true,
            rowNum: 10,
            rowList: [10, 20, 30],
            altRows: true,
            //toppager: true,
            multiselect: true,
            //multikey: "ctrlKey",
            multiboxonly: true,
            loadComplete: function () {
                var table = this;
                setTimeout(function () {
                    styleCheckbox(table);
                    updateActionIcons(table);
                    updatePagerIcons(table);
                    enableTooltips(table);
                }, 0);
            },
            autowidth: true,
            edit: {
                top: 300,
                left: 300
            }
        }, options);
        $(settings.gridSelector).jqGrid(settings);
        $(settings.gridSelector).jqGrid('navGrid', settings.pagerSelector,
            { 	//navbar options
                edit: true,
                editicon: 'icon-pencil blue',
                add: true,
                addicon: 'icon-plus-sign purple',
                del: true,
                delicon: 'icon-trash red',
                search: true,
                searchicon: 'icon-search orange',
                refresh: true,
                refreshicon: 'icon-refresh green',
                view: true,
                viewicon: 'icon-zoom-in grey',
            },
            {
                //edit record form
                closeAfterEdit: true,
                recreateForm: true,
                width: settings.formWidth || 'auto',
                height: settings.formHeight || 'auto',
                beforeShowForm: function (e) {
                    var form = $(e[0]),
                        decorator = require('olivelib/olive.ui.decorator');
                    form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />');

                    decorator.decorateEditForm(form,
                        {
                            controls: settings.controls
                        });
                    form.attr('overflow', 'hidden');
                    (settings.beforeEditShowForm || function () { })();
                },
                afterSubmit: settings.afterEditSubmit || function (response, postdata) { return [true, "", 0]; },
                onclickSubmit: function () {
                    require('overlay');
                    $('#editmodgrid-table').overlay('load');
                }
            }, {
                //new record form
                closeAfterAdd: true,
                width: settings.formWidth || 'auto',
                height: settings.formHeight || 'auto',
                recreateForm: true,
                viewPagerButtons: false,
                beforeShowForm: function (e) {
                    var form = $(e[0]),
                        decorator = require('olivelib/olive.ui.decorator');
                    form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />').attr('overflow', 'hidden');
                    decorator.decorateEditForm(form,
                        {
                            controls: settings.controls
                        });
                    form.attr('style', 'width:auto;overflow:hidden;position:relative;height:auto');

                    (settings.beforeAddShowForm || function () { })();
                },
                afterSubmit: settings.afterAddSubmit || function (response, postdata) { return [true, "", 0]; },
                onclickSubmit: function () {
                    require('overlay');
                    $('#editmodgrid-table').overlay('load');
                }
            }, {
                //delete record form
                recreateForm: true,
                beforeShowForm: function (e) {
                    var form = $(e[0]),
                        decorator = require('olivelib/olive.ui.decorator');
                    if (form.data('styled')) {
                        return false;
                    }
                    form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                    decorator.decorateDeleteForm(form);
                    form.data('styled', true);
                }
            }, {
                //search form
                recreateForm: true,
                afterShowSearch: function (e) {
                    var form = $(e[0]);
                    form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                    style_search_form(form);
                },
                afterRedraw: function () {
                    var decorator = require('olivelib/olive.ui.decorator');
                    decorator.decorateSearchFilters($(this));
                }
                ,
                multipleSearch: true,
                /**
                 multipleGroup:true,
                 showQuery: true
                 */
            }, {
                //view record form
                recreateForm: true,
                beforeShowForm: function (e) {
                    var form = $(e[0]);
                    form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                }
            }
        )
        function beforeDeleteCallback(e) {
            var form = $(e[0]),
                decorator = require('olivelib/olive.ui.decorator');
            if (form.data('styled')) {
                return false;
            }

            form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
            decorator.decorateDeleteForm(form);

            form.data('styled', true);
        }

        function beforeEditCallback(e) {
            var form = $(e[0]),
                decorator = require('olivelib/olive.ui.decorator');
            form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
            decorator.decorateEditForm(form,
                options.controls
            );
        }
        //it causes some flicker when reloading or navigating grid
        //it may be possible to have some custom formatter to do this as the grid is being created to prevent this
        //or go back to default browser checkbox styles for the grid
        function styleCheckbox(table) {
            /**
             $(table).find('input:checkbox').addClass('ace')
             .wrap('<label />')
             .after('<span class="lbl align-top" />')


             $('.ui-jqgrid-labels th[id*="_cb"]:first-child')
             .find('input.cbox[type=checkbox]').addClass('ace')
             .wrap('<label />').after('<span class="lbl align-top" />');
             */
        }

        //unlike navButtons icons, action icons in rows seem to be hard-coded
        //you can change them like this in here if you want
        function updateActionIcons(table) {
            /**
             var replacement =
             {
                 'ui-icon-pencil' : 'icon-pencil blue',
                 'ui-icon-trash' : 'icon-trash red',
                 'ui-icon-disk' : 'icon-ok green',
                 'ui-icon-cancel' : 'icon-remove red'
             };
             $(table).find('.ui-pg-div span.ui-icon').each(function(){
                var icon = $(this);
                var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
                if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
            })
             */
        }

        //replace icons with FontAwesome icons like above
        function updatePagerIcons(table) {
            var replacement =
            {
                'ui-icon-seek-first': 'icon-double-angle-left bigger-140',
                'ui-icon-seek-prev': 'icon-angle-left bigger-140',
                'ui-icon-seek-next': 'icon-angle-right bigger-140',
                'ui-icon-seek-end': 'icon-double-angle-right bigger-140'
            };
            $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function () {
                var icon = $(this);
                var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

                if ($class in replacement) icon.attr('class', 'ui-icon ' + replacement[$class]);
            })
        }
        function enableTooltips(table) {
            $('.navtable .ui-pg-button').tooltip({ container: 'body' });
            $(table).find('.ui-pg-div').tooltip({ container: 'body' });
        }
    }
    module.exports = $.fn.oliveGrid;
})

