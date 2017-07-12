function getValueFromUrl(numberOfPosition) {
    var value = 0;
    window.location.pathname.split('/').forEach(function (item, i, arr) {
        if (i == numberOfPosition) {
            value =item.toString();
        }
    });
    return value;
}