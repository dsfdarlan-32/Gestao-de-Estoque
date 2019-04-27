(function () {
    var form = document.querySelector('form');
    window.onresize = function () {
        form.style.height = (window.innerHeight - 20) + 'px';
    };
    window.onresize();
})();