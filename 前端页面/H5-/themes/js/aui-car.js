$(function(){
	// 数量减
	$(".minus").click(function() {
		var t = $(this).parent().find('.num');
		t.text(parseFloat(t.text()) - 1);
		if (t.text() <= 1) {
			t.text(1);
		}
		TotalPrice();
	});
	// 数量加
	$(".plus").click(function() {
		var t = $(this).parent().find('.num');
		t.text(parseFloat(t.text()) + 1);
    $.ajax({
      url:"http://localhost/cart/updateNum",
      type:"post",
      headers:{
      token:token
      },
            data:{
      carId:carId
            },
            success:function(respTxt){
                if(respTxt.status == 1){
                    alert("移出成功");
                    //前台页面删除
                    var div = theOneDiv1.parent().parent().parent().parent();
                    div.remove();
                } else{
                    alert("移出失败");
                    return;
                }
            }
        })
		if (t.text() <= 1) {
			t.text(1);
		}
		TotalPrice();
	});
	/******------------分割线-----------------******/
	  // 点击商品按钮
  $(".goodsCheck").click(function() {
    var goods = $(this).closest(".aui-car-box").find(".goodsCheck"); //获取本店铺的所有商品
    var goodsC = $(this).closest(".aui-car-box").find(".goodsCheck:checked"); //获取本店铺所有被选中的商品
    if (goods.length == goodsC.length) { //如果选中的商品等于所有商品
        $("#AllCheck").prop('checked', true); //全选按钮被选中
        TotalPrice();
    } else { //如果选中的商品不等于所有商品
      $("#AllCheck").prop('checked', false); //全选按钮也不被选中
      // 计算
      TotalPrice();
      // 计算
    }
  });
  // 点击全选按钮
  $("#AllCheck").click(function() {
    if ($(this).prop("checked") == true) { //如果全选按钮被选中
      $(".goods-check").prop('checked', true); //所有按钮都被选中
      TotalPrice();
    } else {
      $(".goods-check").prop('checked', false); //else所有按钮不全选
      TotalPrice();
    }
    $(".shopCheck").change(); //执行店铺全选的操作
  });
	//计算
  function TotalPrice() {
    var allprice = 0; //总价
    var checkB = $(".goodsCheck");//购物车中所有商品组成的集合
      checkB.each(function() { //循环购物车里的商品
        if ($(this).prop("checked") == true) { //如果该商品被选中
            var num = parseInt($(this).parent().find(".numDicClass").find(".num").text()); //得到商品的数量
            var price = parseFloat($(this).parent().find(".goodsPriceText").text()); //得到商品的单价
            var total = price * num; //计算单个商品的总价
            allprice += total; //计算总价
        }
      });
    $("#AllTotal").html(allprice); //输出全部总价
  }
});
