$(document).ready(function() {
    
    $("#carousel").owlCarousel({
      autoPlay: 2000,
      items : 1,
      itemsDesktop : [1199,1],
      itemsDesktopSmall : [979,1],
         stopOnHover:true,
         responsive:true,
        navigation:true
  });
    
    $('#accordion-js').find('h3').click(function(){
       $(this).next().stop().slideToggle();
   }).next().stop().hide();
    
    
    (function(){
var a = document.querySelector('.left_menu'), b = null, P = 10;  // если ноль заменить на число, то блок будет прилипать до того, как верхний край окна браузера дойдёт до верхнего края элемента. Может быть отрицательным числом
window.addEventListener('scroll', Ascroll, false);
document.body.addEventListener('scroll', Ascroll, false);
function Ascroll() {
  if (b == null) {
    var Sa = getComputedStyle(a, ''), s = '';
    for (var i = 0; i < Sa.length; i++) {
      if (Sa[i].indexOf('overflow') == 0 || Sa[i].indexOf('padding') == 0 || Sa[i].indexOf('border') == 0 || Sa[i].indexOf('outline') == 0 || Sa[i].indexOf('box-shadow') == 0 || Sa[i].indexOf('background') == 0) {
        s += Sa[i] + ': ' +Sa.getPropertyValue(Sa[i]) + '; '
      }
    }
    b = document.createElement('div');
    b.style.cssText = s + ' box-sizing: border-box; width: ' + a.offsetWidth + 'px;';
    a.insertBefore(b, a.firstChild);
    var l = a.childNodes.length;
    for (var i = 1; i < l; i++) {
      b.appendChild(a.childNodes[1]);
    }
    a.style.height = b.getBoundingClientRect().height + 'px';
    a.style.padding = '0';
    a.style.border = '0';
  }
  var Ra = a.getBoundingClientRect(),
      R = Math.round(Ra.top + b.getBoundingClientRect().height - document.querySelector('footer').getBoundingClientRect().top + 0);  // селектор блока, при достижении верхнего края которого нужно открепить прилипающий элемент;  Math.round() только для IE; если ноль заменить на число, то блок будет прилипать до того, как нижний край элемента дойдёт до футера
  if ((Ra.top - P) <= 0) {
    if ((Ra.top - P) <= R) {
      b.className = 'stop';
      b.style.top = - R +'px';
    } else {
      b.className = 'sticky';
      b.style.top = P + 'px';
    }
  } else {
    b.className = '';
    b.style.top = '';
  }
  window.addEventListener('resize', function() {
    a.children[0].style.width = getComputedStyle(a, '').width
  }, false);
}
})()
    

    $('.filter').click(function(){
       $(this).parent('div').toggleClass('active'); 
    });

    $("#slider").ionRangeSlider({
    type: "double",
    min: 0,
    max: 500,
    from: 30,
    to: 350,
    prefix: "$",
    grid: true,
    force_edges: true
    });

    simpleCart({
        cartColumns: [
            { attr: "image", label: ""},
            { attr: "name", label: "Наименование"},
            { view: "decrement" , label: " ↓" , text: "-" },
            { view:"input", attr: "quantity", label: "Количество"},
            { view: "increment" , label: " ↑" , text: "+" },
            { view: "currency", attr: "price", label: "Стоимость"},
            { view: "remove", text: "X", label: "Удалить позицию"}
        ],
        cartStyle: "table",
    });
    simpleCart.currency({
        code: "US" ,
        symbol: "$" ,
        name: "Dollars",
        delimiter: " ",
        after: true ,
        accuracy: 0,
    });
    $(".clearbasket_link").click(function(){
        simpleCart.empty();
    });

    
});