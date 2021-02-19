window.onload = function () {
  document.getElementById("selectAll").onclick = function () {
    var cbs = document.getElementsByName("cb");
    for (var i = 0; i < cbs.length; i++) {
      cbs[i].checked = true;
    }
  };

  document.getElementById("unSelectAll").onclick = function () {
    var cbs = document.getElementsByName("cb");
    for (var i = 0; i < cbs.length; i++) {
      cbs[i].checked = false;
    }
  };

  document.getElementById("selectRev").onclick = function () {
    var cbs = document.getElementsByName("cb");
    for (var i = 0; i < cbs.length; i++) {
      cbs[i].checked = !cbs[i].checked;
    }
  };

  document.getElementById("firstcb").onclick = function () {
    var cbs = document.getElementsByName("cb");
    var firstcb = document.getElementById("firstcb");
    for (var i = 0; i < cbs.length; i++) {
      cbs[i].checked = firstcb.checked;
    }
  };

  var trs = document.getElementsByTagName("tr");
  for (var i = 0; i < trs.length; i++) {
    trs[i].onmouseover = function () {
      this.className = "over";
    };

    trs[i].onmouseout = function () {
      this.className = "out";
    };
  }
};
