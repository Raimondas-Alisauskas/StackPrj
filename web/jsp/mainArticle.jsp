<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.beans.ArticleBean" %>
<%@ page import="model.DTO.ArticleDTO" %>
<%@ page import="java.util.List" %>
<html>
<% ArticleDTO articleDTO = (ArticleDTO) request.getAttribute("articleDTO");%>
<head>

    <title><%=articleDTO.getTitle()%>
    </title>>
</head>
<body>

<h1>Article description</h1>
<p>Article title: <%=articleDTO.getTitle()%>
</p>
<% String introductionHtml = articleDTO.getIntroductionHtml();
    if (!introductionHtml.isEmpty()) {
%>
<div>
    <p>introductionHtml</p>
    <%=introductionHtml%>
</div>
<% } %>

<% String remarksHtml = articleDTO.getRemarksHtml();
    if (!remarksHtml.isEmpty()) {
%>
<div>
    <p>remarksHtml</p>
    <%=remarksHtml%>
</div>
<% } %>

<% String parametersHtml = articleDTO.getParametersHtml();
    if (!parametersHtml.isEmpty()) {
%>
<div>
    <p>parametersHtml</p>
    <%=parametersHtml%>
</div>
<% } %>

<% String syntaxHtml = articleDTO.getSyntaxHtml();
    if (!syntaxHtml.isEmpty()) {
%>
<div>
    <p>syntaxHtml</p>
    <%=syntaxHtml%>
</div>
<% } %>


<button type="button" class="button button--ghost button--ghost--green" onclick="history.back()">Go back to articles
</button>
<div class="middle">
    <% List<ArticleBean> articles = articleDTO.getArticleList();%>
    <%for (ArticleBean article : articles) { %>
    <div class="example">
        <div class="articleTitle">
            <h3><%=article.getTitle()%>
            </h3>
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