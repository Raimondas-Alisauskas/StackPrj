<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.TopicBin" %>
<%@ page import="controllers.ArticleController" %>
<html>
    <head>
    </head>

    <body>
        <div class="middle">
                <% ArrayList<TopicBin> topics = (ArrayList) request.getAttribute("topicsList");
                    for (TopicBin topic : topics) { %>
                <div class="article">
                    <div>
                        <a href="article?title=<%=topic.getTitle()%>&id=<%=topic.getId()%>" name="article_name"><h2><%=topic.getTitle()%>
                        </h2></a>
                    </div>
                </div>
            <% } %>
        </div>
    </body>
</html>
