var main = {
    init: function () {
        var _this = this;
        $("#btn_custom_save").on('click', function () {
            _this.save();
        })
    },
    save: function () {
        var requestParam = {
            extension: $('#custom_extension').val(),
            isFixed: false,
            isUse: true
        };

        $.ajax({
            type: 'POST',
            url: '/api/extension',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(requestParam)
        }).done(function () {
            console.log("성공")
            window.location.href = "/";
        }).fail(function (error) {
            alert(JSON.parse(error));
        })
    }, validate: function () {
        var input = $('#custom_extension').val();
        if (input.length < 1 || input.length > 20 || !/^[a-zA-Z0-9\$]*$/.test(input) || !this.duplicateCheck(input)) {
            alert("유효하지 않는 값입니다.")
            return false;
        }
        return true;
    }, duplicateCheck: function (target) {
        var size = document.getElementById("card").children.length;
        var flag = true;
        for (var i = 1; i < size; i++) {
            if (target == document.getElementById("card").children[i].children[0].innerText) {
                flag = false;
                break;
            }
        }
        return flag;
    }
};

main.init();