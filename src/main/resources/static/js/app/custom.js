var main = {
    init: function () {
        var _this = this;
        $("#btn_custom_save").on('click', function () {
            _this.insertCustom();
        });
        $(".btn-close").on('click', function (e) {
            _this.deleteCustom(e.target.id);
        });
        $(".form-check-input").on('click', function (e) {
            _this.updateFixed(e.target.id);
        });

    },
    insertCustom: function () {

        if (!this.validate()) {
            alert("유효하지 않는 값입니다.")
            return false;
        }

        var requestParam = {
            extension: $('#custom_extension').val(),
            fixed: false,
            useYn: true
        };

        $.ajax({
            type: 'POST',
            url: '/api/extension',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(requestParam)
        }).done(function () {
            window.location.href = '/';
        }).fail(function (request, error) {
            console.log("code " + request.status + "\n" + "message:" + request.responseText + "\n" + "error" + error);
        })
    }, validate: function () {
        var input = $('#custom_extension').val();
        if (input.length < 1 || input.length > 20 || !/^[a-zA-Z0-9\$]*$/.test(input) || !this.duplicateCheck(input)) {
            return false;
        }
        return true;
    }, duplicateCheck: function (target) {
        var customList = $('#deleteCustomExtension').children().children().text();
        if (customList.indexOf(target) > -1) {
            return false;
        }
        return true;
    }, deleteCustom: function (id) {

        var requestParam = $('#' + id).parent().text().trim()
        console.log(requestParam);

        $.ajax({
            type: 'DELETE',
            url: '/api/extension/' + requestParam,
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            window.location.href = '/';
        }).fail(function (request, error) {
            console.log("code " + request.status + "\n" + "message:" + request.responseText + "\n" + "error" + error);
        })
    }, updateFixed(id) {

        var extension = $('#'+id).siblings().first().text();
        var requestParam = {
            extension: extension,
            fixed: true,
            useYn: $('#'+id).prop('checked')
        };

        $.ajax({
            type: 'PUT',
            url: '/api/extension/' + extension,
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(requestParam)
        }).done(function () {
            window.location.href = '/';
        }).fail(function (request, error) {
            console.log("code " + request.status + "\n" + "message:" + request.responseText + "\n" + "error" + error);
        })

    }
};

main.init();