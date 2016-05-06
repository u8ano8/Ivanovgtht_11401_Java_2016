<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<div class="top_line">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="header_menu">
                    <ul>
                    <@sec.authorize ifAnyGranted="ROLE_ANONYMOUS">
                    <#--<#if user??>-->
                    <#--<#else>-->
                        <li><a href="/reg">Регистрация</a></li>
                        <li><a href="/login">Войти</a></li>
                    </@sec.authorize>
                    <@sec.authorize access="isAuthenticated()">

                    <li><a href="/cabinet"> <@sec.authentication property="principal.username" /></a></li>
                        <li><a href="/logout">Выйти</a></li>
                    </@sec.authorize>
                        <li><a href="/feedback">Обратная связь</a></li>
                        <li><a href="#">Помощь</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="logo_block">
    <div class="container">
        <div class="row">
            <div class="col-md-2">
                <div class="logo">

                </div>
            </div>
            <div class="col-md-6">
                <div class="logo">
                    <a href="/"><p>Book<span>Store</span></p></a>
                </div>
            </div>
            <div class="col-md-3">
                <div class="cart_block">
                    <p><img src="/resources/images/icons/cart_icon.png" alt="wish_list">
                        Корзина<span class="simpleCart_quantity"></span><span id="header_items">всего</span><br>
                        <span id="total" class="simpleCart_total"></span>
                        <a href="/cart" class="checkout_button">Посмотреть</a>
                        <a href="javascript:;" class="clearbasket_link">Очистить</a></p>
                    <script>


                    </script>
                </div>
            </div>

        </div>
    </div>
</div>
</header>