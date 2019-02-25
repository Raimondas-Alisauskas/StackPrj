<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.ArticleBin" %>
<%@ page import="java.util.ArrayList" %>
<html>
    <head>
    </head>
    <body>
        <% ArrayList<ArticleBin> articles = (ArrayList) request.getAttribute("article");%>
        <h1>Article description</h1>
        <p>Article title: <%=articles.get(0).getTitle()%></p>
        <div class="middle">
            <%for (ArticleBin articleBin2 : articles) { %>
            <div class="example">
                <div>
                    <%=articleBin2.getExample()%>
                </div>
            </div>
            <% } %>
        </div>
    </body>
</html>