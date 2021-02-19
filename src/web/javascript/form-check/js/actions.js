window.onload = function () {
  document.getElementById("form").onsubmit = function () {
    //验证用户名
    //验证密码
    //...
    //都成功则返回true
    //
    return checkUsername() && checkPassword();
  };

  document.getElementById("username").onblur = checkUsername;
  document.getElementById("password").onblur = checkPassword;
};

function checkUsername() {
  var username = document.getElementById("username").value;
  var reg_username = /^\w{6,12}$/;
  var flag = reg_username.test(username);
  var s_username = document.getElementById("s_username");
  if (flag) {
    s_username.innerHTML = "<img height='25' width='35' src='../../../../../assets/images/gou.png'>";
  } else {
    s_username.innerHTML = "用户名格式有误";
  }
  return flag;
}

function checkPassword() {
  var password = document.getElementById("password").value;
  var reg_password = /^\w{6,12}$/;
  var flag = reg_password.test(password);
  var s_password = document.getElementById("s_password");
  if (flag) {
    s_password.innerHTML = "<img height='25' width='35' src='../../../../../assets/images/gou.png'>";
  } else {
    s_password.innerHTML = "密码格式有误";
  }
  return flag;
}
