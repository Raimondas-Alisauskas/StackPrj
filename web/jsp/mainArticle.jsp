<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.beans.ArticleBean" %>
<%@ page import="model.DTO.ArticleDTO" %>
<%@ page import="java.util.List" %>
<html>
<head>
</head>
<body>
<% ArticleDTO articleDTO = (ArticleDTO) request.getAttribute("articleDTO");%>
<h1>Article description</h1>
<p>Article title: <%=articleDTO.getTitle()%>
</p>
<button type="button" class="button button--ghost button--ghost--green" onclick="history.back()">Go back to articles
</button>
<div class="middle">
    <% List<ArticleBean> articles = articleDTO.getArticleList();%>
    <%for (ArticleBean article : articles) { %>
    <div class="example">
        <div class="articleTitle">
            <h3><%=article.getTitle()%></h3>
        </div>
        <div class="articleBH">
            <%=article.getExample()%>
        </div>
        <div class="articleMD">
            <%=article.getBodyMarkdown()%>
        </div>
    </div>
    <% } %>
</div>
</body>
</html>