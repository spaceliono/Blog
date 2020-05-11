<#include "head.ftlh">
<div id="home">
    <div class="img">
        <div>
            <div class="blog_title">
                <span>祈愿每个此刻我更懂我</span>
            </div>
            <div class="tab">
                <span><a href="mailto:694773629@qq.com" target="_blank" rel="noopener">EMAIL</a></span>
                <span><a href="https://github.com/spaceliono" target="_blank" rel="noopener">GITHUB</a></span>
<#--                <span>TWITTER</span>-->
            </div>
        </div>
    </div>
    <div class="container" id="somewhere">
        <div class="all_articles">

            <#list articles as article>
                <div class="article_single">
                    <div class="article_title">
                        <a href="/article/${article.article_id}">${article.article_title}</a>
                    </div>
                    <div class = "article_date">${article.create_date}</div>

                </div>
            </#list>
        </div>
    </div>
</div>
</body>
</html>