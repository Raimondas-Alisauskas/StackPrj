<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.TopicBin" %>
<%@ page import="controllers.ArticleController" %>
<%@ page import="models.TopicResults" %>
<html>
    <head>
    </head>

    <body>
        <div class="middle">
                <%
                    ArrayList<TopicBin> topics = (ArrayList<TopicBin>) ((TopicResults) request.getAttribute("topicResults")).getTopicsList();
                    for (TopicBin topic : topics) {
                %>
                <div class="article">
                    <div>
                        <a href="article?id=<%=topic.getId()%>" name="article_name"><h2><%=topic.getTitle()%>
                        </h2></a>
                    </div>
                </div>
            <% } %>
        </div>
    </body>
</html>