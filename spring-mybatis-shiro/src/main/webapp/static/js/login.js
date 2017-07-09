/**
 * Created by zhaobing on 2017/7/4.
 */
var baseUrl = $('base').attr('href');
$(function () {
    $('#login').click(function () {
        var username = $('#username').val();
        var password = $('#password').val();
        var remeberMe = $('#remeberMe').val();
        $.ajax({
            url:baseUrl+'login/doLogin?username='+username+'&password='+password+'&remeberMe='+remeberMe,
            async:false,
            type:'post',
            dataType:'json',
            cache:false,
            success:function (json) {
                if (json.code == 0){
                    location.href = baseUrl+'main/index';
                }else {
                    alert(json.msg);
                }
            },
            error:function (err) {
                alert(err);
            }
        });
    });
});