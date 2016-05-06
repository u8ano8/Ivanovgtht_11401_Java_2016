<#-- @ftlvariable name="comments" type="java.util.List<mvc.common.ReviewInfo>" -->
<#-- @ftlvariable name="good" type="mvc.common.GoodInfo" -->
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<div class="comments">
<#if comments?has_content>
    <h3>Отзывы</h3>
    <#list comments as comment>
        <div class="comment">
            <#if comment.user.profile_img_url??>
                <img src="${comment.user.profile_img_url}"/>
            <#else>
                <img src="/resources/images/icons/noname_icon.png" alt="anon">
            </#if>
            <p><span>${comment.user.name}</span> <br/>${comment.content}</p>
            <hr/>
        </div>
    </#list>
    <a href="/good/showMore" id="showMore" data-id="${good.id}">Показать больше</a>
<#else>
    <div class="comment">
        <h3>Отзывов нет. Вы можете быть первым</h3>
    </div>
<div class="good_id">
    <a href="#" id="${good.id}" style="display: none"></a>
</div>
    <#--<input type="text" value="${good.id}" id="id-value" style="display:none;" />-->
</#if>
    <div class="write_a_comment">
    <@sec.authorize ifAnyGranted="ROLE_ANONYMOUS">
        <a href="/login" class="btn btn-default login-btn">Пожалуйста, авторизируйтесь</a>
    </@sec.authorize>
    <@sec.authorize access="isAuthenticated()">
        <a href="/write-review?id=${good.id}" class="btn btn-default submit-btn">Написать отзыв</a>
    </@sec.authorize>
    </div>
</div>