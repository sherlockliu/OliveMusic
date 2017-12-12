/**
 * Created by user on 2017/4/8.
 */
define(function (require, exports, module) {
    var spinner;
    var isSpinnerClosed = true;

    function display() {
        var opts = {
            lines: 13, // loading小块的数量
            length: 7, // 小块的长度
            width: 4, // 小块的宽度
            radius: 10, // 整个圆形的半径
            corners: 1, // 小块的圆角，越大则越圆
            rotate: 0, // loading动画的旋转度数，貌似没什么实际作用
            color: '#000', // 颜色
            speed: 1, // 变换速度
            trail: 60, // 余晖的百分比
            shadow: false, // 是否渲染出阴影
            hwaccel: false, // 是否启用硬件加速
            className: 'spinner', // 给loading添加的css样式名
            zIndex: 2e9, // The z-index (defaults to 2000000000)
            top: 'auto', // Top position relative to parent in px
            left: 'auto' // Left position relative to parent in px
        };
        var target = document.getElementById('iframeContainer');
        if (isSpinnerClosed) {
            spinner = new Spinner(opts).spin(target);
        }
        isSpinnerClosed = false;
    }

    function hide() {
        spinner.stop();
        isSpinnerClosed = true;
    }

    module.exports = {
        hide: hide,
        display: display
    };
})