function isDecimal (number) {
    return /^\d+(\.\d+)?$/.test(number);
}

function containsSpecialCharacters (str) {
    return !!str.match(/[^a-zA-Z0-9 ]/g);
}

$('#cost').change( function () {
    let cost = $('#cost').val();
    if (!isDecimal(cost)) {
        $('#cost').val('');
    } else {
        cost = (Math.round(cost * 100) / 100).toFixed(2);
        $('#cost').val(cost);
    }
});

function validateProduct (){
    var name = $("#name").val();
    var cost = $("#cost").val();
    var storeName = $("#storeName").val();
    if (name === '' || containsSpecialCharacters(name)) {
        alert('Name can not be empty or contains special characters');
        $("#name").focus();
        return false;
    }
    if (storeName === '' || containsSpecialCharacters(storeName)) {
        alert('Store name can not be empty or contains special characters');
        $("#storeName").focus();
        return false;
    }

    if (cost === '' || !isDecimal(cost)) {
        alert('Cost can not be empty or contains alphabetic characters');
        $("#cost").focus();
        return false;
    }
    return true;
}