define(function(require,exports,module){

    var formatter = {};

    formatter.switch = function (cellvalue, options, cell) {
        setTimeout(function () {
            $(cell).find('input[type=checkbox]')
                .wrap('<label class="inline" />')
                .addClass('ace ace-switch ace-switch-5')
                .after('<span class="lbl"></span>');
        }, 0);
    };
    formatter.pickDate = function (cellvalue, options, cell) {
        setTimeout(function () {
            $(cell).find('input[type=text]')
                .datepicker({ format: 'yyyy-mm-dd', language: 'zh-CN', autoclose: true });
        }, 0);
    };
    formatter.multiSelect = function (cellvalue, options, cell) {
        setTimeout(function () {
            var dropId = $(cell).find('select').attr('id');
            var selectDropDown = $("#selectDropDown_" + dropId);
            var offset = $(cell).offset();
            console.log(offset);
            if (selectDropDown.length > 0) {
                selectDropDown.find('select').attr('style', 'top:' + offset.top + 'px;left:' + offset.left + 'px');
            }
            else {
                selectDropDown = $("<div id='selectDropDown_'" + dropId + "></div>");
                console.log(dropId);
                $(cell).find('select').appendTo(selectDropDown);
                selectDropDown.find('select').addClass("width-20 chosen-select").attr("multiple", "").attr("data-placeholder", "Choose a Item...").chosen();
                selectDropDown.appendTo($(cell).parent().parent().parent());
                $("#" + dropId + "_chosen").attr("style", "width:300px");
                selectDropDown.attr('style', 'top:' + offset.top + 'px;left:' + offset.left + 'px;width: 250px; position:fixed; z-index:99999');
            }
        }, 0);
        //setTimeout(function () {
        //    console.log($(cell).find('.chosen-drop').length);
        //    $(cell).find('.chosen-drop').attr("style", 'none').appendTo($(cell).parent().parent().parent());
        //    console.log($(cell).find('.chosen-drop').length);

        //}, 0);
    };

    formatter.constructWysiwyg = function (value, options) {
        //var el = $('<div></div>');        //创建一个父div
        //el.attr('id', 'parent');        //给父div设置id
        //el.addclass('wysiwyg-editor');    //添加css样式

        var el = document.createElement("div");
        if (options.height) {
            el.style.height = options.height + 'px';
            //el.style.width = '600px';
        }
        //  el.className='wysiwyg-editor';
        //var el = document.createElement("input");
        // el.type = "text";
        el.innerHTML = value;

        return el;
    };

    formatter.utilizeWysiwyg = function (elem, operation, value) {

        if (operation === 'get') {
            return htmlEncode($(elem).html());
        } else if (operation === 'set') {
            $(elem).val(htmlDecode(value));
        }
    };

    function htmlEncode(value) {
        //create a in-memory div, set it's inner text(which jQuery automatically encodes)
        //then grab the encoded contents back out.  The div never exists on the page.
        return $('<div/>').text(value).html();
    }

    function htmlDecode(value) {
        return $('<div/>').html(value).text();
    }


    module.exports = formatter;
})
